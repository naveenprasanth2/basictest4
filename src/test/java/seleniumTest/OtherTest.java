package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class OtherTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        driver.findElements(By.xpath("//label[contains(@for,'radio')]"))
//                .stream().filter(x -> x.getText().replaceAll("\\s", "").equalsIgnoreCase("radio1"))
//                .findFirst().map(x -> x.findElement(By.xpath("input"))).ifPresent(WebElement::click);
//        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind");
//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(5))
//                .ignoring(NoSuchElementException.class);
//        wait.until(t -> {
//            if(t.findElement(By.cssSelector("li.ui-menu-item")).isDisplayed()){
//                return t.findElement(By.cssSelector("li.ui-menu-item"));
//            }else{
//                return null;
//            }
//        });
//        driver.findElements(By.cssSelector("li.ui-menu-item")).stream().filter(x -> x.getText().equalsIgnoreCase("india"))
//                .findFirst().ifPresent(WebElement::click);

//        Select select = new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
//        select.getOptions().stream().filter(x -> x.getText().equalsIgnoreCase("option3")).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//input[contains(@value,'option')]")).stream().filter(x -> x.getAttribute("value").equalsIgnoreCase("option2"))
                .findFirst().ifPresent(WebElement::click);
    }
}
