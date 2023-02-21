package practise4;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

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
	private static WebDriver driver;

	@Test
	public void test() throws InterruptedException {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElements(By.name("radioButton")).stream()
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
				.findFirst().ifPresent(x -> x.click());

		WebElement element = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(element);
		select.getOptions().stream().filter(x -> x.getText().equalsIgnoreCase("option1")).findFirst()
				.ifPresent(x -> x.click());

		driver.findElement(By.xpath("//input[@value='option2']")).click();

		driver.findElement(By.id("openwindow")).click();
		RadioTest.winSwitch();
		driver.findElement(By.id("opentab")).click();
		RadioTest.winSwitch();

		driver.findElement(By.id("name")).sendKeys("naveen");
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		driver.findElement(By.id("name")).sendKeys("naveen");
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]")).stream()
				.filter(x -> x.getText().equals("37")).findFirst()
				.ifPresent(x -> System.out.println(x.findElement(By.xpath("preceding-sibling::td[3]")).getText()));
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("mousehover"))).perform();
		act.keyDown(Keys.CONTROL).moveToElement(driver.findElement(By.linkText("Reload"))).click().perform();
		act.keyUp(Keys.CONTROL).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe"))));
		driver.findElement(By.xpath("//*[text()='Courses']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("displayed-text")).sendKeys("naveen");
		Thread.sleep(5000);

		driver.quit();
	}

	public static void winSwitch() throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		String child = iter.next();
		driver.switchTo().window(child);
		driver.findElement(By.xpath("//*[text()='Courses']")).click();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parent);
	}
}
