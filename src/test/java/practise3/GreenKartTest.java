package practise3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GreenKartTest {
	@Test(dataProvider = "data1")
	public void test(ArrayList<String> test) {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElements(By.cssSelector("h4.product-name")).stream()
				.filter(x -> test.contains(x.getText().split("-")[0].strip())).forEach(x -> {
					x.findElement(By.xpath("parent::div //input")).sendKeys(Keys.CONTROL + "A", Keys.DELETE);
					x.findElement(By.xpath("parent::div //input")).sendKeys("20");
					x.findElement(By.xpath("parent::div //button")).click();
				});
	}

	@DataProvider(name = "data1")
	public static Object[][] data1() {
		String[] x = { "Brocolli", "Tomato", "Pumpkin", "Apple", "Musk Melon", "Pomegranate" };
		Object[][] o = new Object[1][];
		ArrayList<String> test = new ArrayList<String>(Arrays.asList(x));
		o[0] = new Object[] { test };
		return o;
	}

}
