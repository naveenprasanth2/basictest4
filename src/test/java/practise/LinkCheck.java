package practise;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LinkCheck {
	@Test
	public void test() throws InterruptedException, IOException, MalformedURLException {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = driver.findElements(By.xpath("//li //a"));
		List<URL> urls = links.stream().map(s-> s.getAttribute("href")).map(s-> {
			try {
				return new URL(s);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
		for (WebElement link : links) {
			URL url = new URL(link.getAttribute("href"));
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			connect.setRequestMethod("HEAD");
			connect.connect();
			int response = connect.getResponseCode();
			if (response > 400) {
				System.out.println("link is not working " + link.getText());
			} else {
				System.out.println("link is working " + link.getText());
			}
		}
	}
}
