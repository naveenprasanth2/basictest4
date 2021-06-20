package practise3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SeleDrop {
	@Test
	public void test() {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.orangehrm.com/orangehrm-30-day-trial/");
		WebElement emp = driver.findElement(By.name("NoOfEmployees"));
		WebElement ind = driver.findElement(By.name("Industry"));
		WebElement cou = driver.findElement(By.name("Country"));
		SeleDrop.selecting(emp, "2", Drop.INDEX.toString());
		SeleDrop.selecting(cou, "Andorra", Drop.VALUE.toString());
		SeleDrop.selecting(ind, "Travel", Drop.VISIBLETEXT.toString());
	}

	public static void selecting(WebElement element, String value, String type) {
		Select select = new Select(element);
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("enter proper values");
		}
	}

}
