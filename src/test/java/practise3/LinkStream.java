package practise3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LinkStream {
	@Test
	public void test() {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<String> values = driver.findElements(By.xpath("//li //a")).stream().map(x -> {
			try {
				return new URL(x.getAttribute("href"));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).map(x -> {
			try {
				HttpURLConnection connect = (HttpURLConnection) x.openConnection();
				return connect.getResponseCode();
			} catch (IOException e) {
				// TODO Auto-generated catch block`
				e.printStackTrace();
			}
			return null;
		}).map(x -> x > 400 ? "link is not working" : "link is working").collect(Collectors.toList());
		values.listIterator().forEachRemaining(System.out::println);
	}

}
