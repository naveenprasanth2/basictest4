package seleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectModel {
    WebDriver driver;
    public PageObjectModel(){
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }
}
