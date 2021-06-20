package practise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectExample {
	WebDriver driver;

	@Test
	public void test() {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://www.orangehrm.com/orangehrm-30-day-trial/");
		WebElement emp = driver.findElement(By.name("NoOfEmployees"));
		WebElement ind = driver.findElement(By.name("Industry"));
		WebElement cou = driver.findElement(By.name("Country"));
		selectFunction(emp, Values.INDEX.toString(), "2");
		selectFunction(ind, Values.VISIBLETEXT.toString(), "Manufacturing - Non Computer Related");
		selectFunction(cou, Values.VALUE.toString(), "Antigua and Barbuda");
		driver.findElement(By.xpath("//a[@aria-label='Accept Cookies']")).click();

	}

	public static void selectFunction(WebElement ele, String type, String value) {
		Select select = new Select(ele);
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibeltext":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("enter proper value");
			break;
		}
	}

}
