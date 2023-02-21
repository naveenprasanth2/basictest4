package practise3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	@Test
	public void test() throws IOException {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		String screenPath = System.getProperty("user.dir") + "\\src\\main\\java\\screenshots\\test3.png";
		String reportPath = System.getProperty("user.dir") + "\\src\\main\\java\\reports\report3.html";
		System.setProperty("webdriver.chrome.driver", chromePath);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		co.addArguments("--disable-infobars");
		co.addArguments("--window-size=1920,1080");
		co.merge(dc);
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setReportName("regression");
		spark.config().setDocumentTitle("phase1");
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Tester", "naveen");
		ExtentTest test = report.createTest("Test1");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElements(By.cssSelector("input.radipButton")).stream()
				.filter(x -> x.getText().equalsIgnoreCase("radio3")).findFirst().ifPresent(x -> x.click());
		js.executeScript("window.scroll(0,500)");
		js.executeScript("document.querySelector('div.tableFixHead').scrollTop=5000");
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(screenPath));
		test.addScreenCaptureFromPath(screenPath);
		report.flush();
		driver.quit();

	}

}
