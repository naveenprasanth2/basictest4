package practise2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AlertsHandle {
	static WebDriver driver;

	@Test
	public void test() throws InterruptedException {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("naveen");
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.id("name")).sendKeys("naveen");
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[3]")).stream()
				.filter(x -> x.getText().equalsIgnoreCase("chennai")).findFirst()
				.ifPresent(x -> System.out.println(x.findElement(By.xpath("following-sibling::td")).getText()));
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("mousehover"))).perform();
		act.moveToElement(driver.findElement(By.xpath("//div //a[text()='Top']"))).keyDown(Keys.CONTROL).click()
				.perform();
		act.keyUp(Keys.CONTROL).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe[@id='courses-iframe']"))));
		driver.findElement(By.xpath("//li/a[text()='Courses']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).sendKeys("naveen");
		
	}
}
