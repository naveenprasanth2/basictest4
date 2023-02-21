package practise3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RadioTest {
	@Test
	public void test() throws MalformedURLException, IOException, InterruptedException {
		String chromePath = System.getProperty("user.dir") + "//src//main//java//resources//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElements(By.cssSelector("input.radioButton")).stream()
				.filter(x -> x.getAttribute("value").equalsIgnoreCase("radio3")).findFirst().ifPresent(x -> x.click());
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
		WebElement foo = wait.until(t -> {
			if (driver.findElement(By.xpath("//li/div")).isDisplayed()) {
				return driver.findElement(By.xpath("//li/div"));
			} else {
				return null;
			}
		});
		driver.findElements(By.xpath("//li/div")).stream().filter(x -> x.getText().equalsIgnoreCase("indonesia"))
				.findAny().ifPresent(x -> x.click());
		WebElement element = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(element);
		select.getOptions().stream().filter(x -> x.getText().equals("Option2")).findFirst().ifPresent(x -> x.click());

		driver.findElement(By.id("checkBoxOption3")).click();
		driver.findElement(By.name("enter-name")).sendKeys("naveen");
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		driver.findElement(By.name("enter-name")).sendKeys("naveen");
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.id("courses-iframe"))));
		driver.findElement(By.xpath("//li/a[text()='Courses']")).click();
		driver.switchTo().defaultContent();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("mousehover"))).perform();
		act.keyDown(Keys.CONTROL).moveToElement(driver.findElement(By.xpath("//a[text()='Reload']"))).click().perform();
		act.keyUp(Keys.CONTROL).perform();
		RadioTest.winSwitch(driver);
		driver.findElements(By.xpath("//table[@id='product'] //tr/td[4]")).stream()
				.filter(x -> x.getText().equals("37")).findFirst()
				.ifPresent(x -> System.out.println(x.findElement(By.xpath("preceding-sibling::td[3]")).getText()));
		List<WebElement> lists = driver.findElements(By.xpath("//li //a"));
		for (WebElement list : lists) {
			URL url = new URL(list.getAttribute("href"));
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			connect.setRequestMethod("HEAD");
			connect.connect();
			int response = connect.getResponseCode();
			if (response > 400) {
				System.out.println("link is not working " + list.getText());
			} else {
				System.out.println("link is working " + list.getText());
			}
		}

		driver.findElement(By.id("openwindow")).click();
		RadioTest.winSwitch(driver);
		driver.findElement(By.id("opentab")).click();
		RadioTest.winSwitch(driver);
		driver.quit();

	}

	public static void winSwitch(WebDriver driver) throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		String child = iter.next();
		driver.switchTo().window(child);
		try {
			driver.findElement(By.xpath("//a[text()='Courses']")).click();
		} catch (Exception e) {
			System.out.println("no such element present");
		} finally {
			Thread.sleep(2000);
			driver.close();
			driver.switchTo().window(parent);
		}
	}
}
