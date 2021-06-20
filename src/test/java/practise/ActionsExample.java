package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ActionsExample {
	@Test
	public void test() {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("mousehover"))).perform();
		act.keyDown(Keys.CONTROL).moveToElement(driver.findElement(By.xpath("//a[text()='Reload']"))).click().perform();
		act.keyUp(Keys.CONTROL).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='courses-iframe']")));
//		driver.switchTo().frame("//iframe[@id='courses-iframe']");
		driver.findElement(By.xpath("//li/a[text()='Courses']")).click();
	}

}
