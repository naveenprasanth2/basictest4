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

import io.github.bonigarcia.wdm.WebDriverManager;

public class PractiseWithLambdas {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> lists = driver.findElements(By.xpath("//li //a"));
		List<String> summa = lists.parallelStream().map(x -> x.getAttribute("href")).collect(Collectors.toList());
		List<URL> test = summa.stream().map(x-> {
			try {
				return summa1(x);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
		for(URL url : test) {
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			connect.setRequestMethod("HEAD");
			connect.connect();
			int response = connect.getResponseCode();
			if(response>400) {
				System.out.println("link not working");
			}else {
				System.out.println("link working");
			}
		}

	}
	
	public static URL summa1(String x) throws MalformedURLException {
		URL url = new URL(x);
		return url;
	}

}
