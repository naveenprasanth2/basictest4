package practise2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class Test1 {
	@Test
	public void test() {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElements(By.cssSelector("input.radioButton")).stream()
				.filter(x -> x.getAttribute("value").equals("radio3")).findFirst().ifPresent(x-> x.click());
		driver.findElement(By.cssSelector("input#autocomplete")).sendKeys("ind");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
		WebElement foo = wait.until(t -> {
				if (t.findElement(By.xpath("//li //div")).isDisplayed()) {
					return t.findElement(By.xpath("//li //div"));
				} else {
					return null;
				}
		});
		driver.findElements(By.xpath("//li //div")).stream().filter(x -> x.getText().equalsIgnoreCase("Indonesia"))
				.limit(1).forEach(x -> x.click());
		driver.findElement(By.xpath("//input[@value='option1']")).click();
	}
}
