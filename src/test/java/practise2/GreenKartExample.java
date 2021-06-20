package practise2;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GreenKartExample {
	static WebDriver driver;

	@Test(dataProvider = "data1")
	public void test(ArrayList<String> test) {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElements(By.cssSelector("h4.product-name")).stream()
				.filter(x -> test.contains((x.getText().split(" ")[0]))).forEach(x -> {
					x.findElement(By.xpath("parent::div //div/input")).sendKeys(Keys.CONTROL + "A", Keys.DELETE);
					x.findElement(By.xpath("parent::div //div/input")).sendKeys("20");
					x.findElement(By.xpath("parent::div //div/button")).click();
				});

	}

	@DataProvider(name = "data1")
	public Object[][] data1() {
		String[] test = { "Brocolli", "Brinjal", "Mushroom", "Apple", "Grapes", "Raspberry", "Walnuts", "Pista", "Brinjal" };
		ArrayList<String> names = new ArrayList<String>(Arrays.asList(test));
		Object[][] o = new Object[1][];
		o[0] = new Object[] { names };
		return o;
	}
}
