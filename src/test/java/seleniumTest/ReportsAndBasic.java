package seleniumTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ReportsAndBasic {
    WebDriver driver;
    String screenPath = System.getProperty("user.dir") + "\\src\\main\\java\\screenshots\\newScreen.png";
    String reportPath = System.getProperty("user.dir") + "\\src\\main\\java\\reports\\newReport.html";

    @Test
    public void initiate() throws IOException {
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setReportName("regression");
        spark.config().setDocumentTitle("firstRegression");
        ExtentReports report = new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("tester", "Naveen");

        ExtentTest test = report.createTest("firstTest");
        ChromeOptions co = new ChromeOptions();
        co.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        co.addArguments("--headless");
        co.addArguments("--disable-infobars");
        co.addArguments("--screen-size=1920,1080");
        driver = new ChromeDriver(co);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor)  driver;
        js.executeScript("window.scroll(0,1500)");
        js.executeScript("document.querySelector('div.tableFixHead').scrollTop=5000");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='courses-iframe']")));
        driver.findElement(By.xpath("//a[text()='Blog']")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Blog']")));
        TakesScreenshot sc = (TakesScreenshot) driver;
        File src = sc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(screenPath));
        test.addScreenCaptureFromPath(screenPath);
        report.flush();
        driver.quit();
    }
}
