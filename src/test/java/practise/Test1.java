package practise;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class Test1 {
	@Test
	public void test() {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));
		for (WebElement radio : radios) {
			if (radio.getAttribute("value").equalsIgnoreCase("radio3")) {
				radio.click();
			}
		}
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
		WebElement foo = wait.until(t -> {
				if (t.findElement(By.xpath("")).isDisplayed()) {
					return t.findElement(By.xpath(""));
				} else {
					return null;
				}
		});

		List<WebElement> suggestions = driver.findElements(By.xpath("//li/div"));
		for (WebElement suggestion : suggestions) {
			if (suggestion.getText().equalsIgnoreCase("Indonesia")) {
				suggestion.click();
			}
		}
		WebElement element = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(element);
		select.selectByIndex(2);
	}

}
