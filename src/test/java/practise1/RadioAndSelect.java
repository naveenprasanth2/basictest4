package practise1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class RadioAndSelect {
	@Test
	public void test() {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> radios = driver.findElements(By.cssSelector("input.radioButton"));
		radios.stream().filter(x -> x.getAttribute("value").contains("radio2")).limit(1).forEach(x -> x.click());
		driver.findElement(By.cssSelector("input#autocomplete")).sendKeys("ind");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
		WebElement foo = wait.until(t -> {
			if (t.findElement(By.xpath("//li/div")).isDisplayed()) {
				return t.findElement(By.xpath("//li/div"));
			} else {
				return null;
			}
		});
		List<WebElement> auto = driver.findElements(By.xpath("//li/div"));
		auto.stream().filter(x -> x.getText().equalsIgnoreCase("Indonesia")).limit(1).forEach(x -> x.click());
		driver.findElement(By.xpath("//label[@for='bmw']/input")).click();
	}

}
