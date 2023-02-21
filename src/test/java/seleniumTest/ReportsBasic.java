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

public class ReportsBasic {
    WebDriver driver;

    @Test
    public void test() throws IOException {
        String reportPath = System.getProperty("user.dir") + "\\src\\main\\java\\reports\\";
        String screenPath = System.getProperty("user.dir") + "\\src\\main\\java\\screenshots\\myImage.png";
        ChromeOptions co = new ChromeOptions();
        co.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        co.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        co.addArguments("--headless");
        co.addArguments("--screen-size=1920,1080");
        co.addArguments("--disable-infobars");


        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath + "myNew.html");
        spark.config().setDocumentTitle("my report");
        spark.config().setReportName("Regression Report");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("tester", "naveen");
        extent.setSystemInfo("Executed in", "chrome");
        extent.setSystemInfo("ExecutedBy", System.getProperty("user.name"));

        ExtentTest et = extent.createTest("myFirstTest");
        driver = new ChromeDriver(co);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//iframe")));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Blog']")));
        driver.switchTo().defaultContent();
        TakesScreenshot sc = (TakesScreenshot) driver;
        File src = sc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(screenPath));
        et.addScreenCaptureFromPath(screenPath);
        extent.flush();
        driver.quit();
    }

}
