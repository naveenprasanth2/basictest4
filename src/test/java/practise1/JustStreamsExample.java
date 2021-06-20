package practise1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JustStreamsExample {
	static WebDriver driver;
	@Test
	public void test() throws MalformedURLException {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElements(By.xpath("//li //a")).stream().forEach(x-> {
			try {
				test1(x);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	public static void test1(WebElement x) throws IOException {
		URL url = new URL(x.getAttribute("href"));
		HttpURLConnection connect = (HttpURLConnection) url.openConnection() ;
		connect.getHeaderField("HEAD");
		connect.connect();
		int response = connect.getResponseCode();
		if(response > 400) {
			System.out.println(x.getText() + " link is not working");
		}else {
			System.out.println(x.getText() + " link is working");
		}
		
	}
}
