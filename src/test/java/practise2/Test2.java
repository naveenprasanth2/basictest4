package practise2;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test2 {
	static WebDriver driver;

	@Test
	public void test() throws InterruptedException {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("openwindow")).click();
		Test2.winSwitch();
		driver.findElement(By.id("opentab")).click();
		Test2.winSwitch();
		driver.quit();
	}

	public static void winSwitch() throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		String child = iter.next();
		driver.switchTo().window(child);
		driver.findElement(By.xpath("//li/a[text()='Courses']")).click();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parent);
	}
}
