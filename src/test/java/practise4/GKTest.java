package practise4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GKTest {

	@Test(dataProvider = "data1")
	public void test(ArrayList<String> test) {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElements(By.xpath("//h4[@class='product-name']")).stream()
				.filter(x -> test.contains(x.getText().split(" ")[0])).forEach(x -> {
					x.findElement(By.xpath("(parent::div) //input")).sendKeys(Keys.CONTROL + "A", Keys.DELETE);
					x.findElement(By.xpath("(parent::div) //input")).sendKeys("20");
					x.findElement(By.xpath("(parent::div) //button")).click();
					System.out.println(driver.findElement(By.xpath("//img[@class='tada']")).isDisplayed());
				});

	}

	@DataProvider(name = "data1")
	public Object[][] data1() {
		String[] names = { "Brocolli", "Capsicum", "Banana", "Raspberry" };
		ArrayList<String> test = new ArrayList<String>(Arrays.asList(names));
		Object[][] o = new Object[1][];
		o[0] = new Object[] { test };
		return o;
	}
}
