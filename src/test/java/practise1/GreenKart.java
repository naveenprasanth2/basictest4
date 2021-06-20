package practise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GreenKart {
	WebDriver driver;

	@Test
	public void test() {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		ArrayList<String> values = values();
		driver.findElements(By.cssSelector("h4.product-name")).stream()
				.filter(x -> values.contains(x.getText().split(" ")[0])).forEach(x -> {
					x.findElement(By.xpath("((preceding-sibling::div)/following-sibling::div[1])/input"))
							.sendKeys(Keys.CONTROL + "A", Keys.DELETE);
					x.findElement(By.xpath("((preceding-sibling::div)/following-sibling::div[1])/input"))
					.sendKeys("5");
					x.findElement(By.xpath("((preceding-sibling::div)/following-sibling::div[2])/button")).click();
				});

	}

	public static ArrayList<String> values() {
		String[] a = { "Brocolli", "Brinjal", "Potato", "Corn", "Raspberry", "Walnuts" };
		ArrayList<String> value = new ArrayList<String>(Arrays.asList(a));
		return value;
	}
}
