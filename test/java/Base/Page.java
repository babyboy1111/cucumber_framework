package Base;

import com.google.common.base.Function;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.google.common.util.concurrent.Futures.withTimeout;

public class Page {
    public WebDriver driver;

    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com");
    }

    public void tearDown() {
        driver.quit();
    }

    public void ElementClick(String locator, String type) {
        if (type.toLowerCase().equals("xpath")) {
            WebElement slider = driver.findElement(By.xpath(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", slider);
            slider.click();
        } else if (type.toLowerCase().equals("id")) {
            WebElement slider = driver.findElement(By.id(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", slider);
            slider.click();
        } else driver.findElement(By.name(locator)).click();

    }

    public void Click_SendKey(String element,String value) {
        WebElement textField = driver.findElement(By.id(element));
        textField.sendKeys(value);
    }

    public String GetText(String locator, String type) {
        String slider;
        if (type.toLowerCase().equals("xpath")) {
            slider = driver.findElement(By.xpath(locator)).getText();
        } else if (type.toLowerCase().equals("id")) {
            slider = driver.findElement(By.id(locator)).getText();
        } else {
            slider = driver.findElement(By.name(locator)).getText();
        }
        return slider;
    }

    public void doubleClick(String locator) {
        WebElement btn2 = driver.findElement(By.id(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn2);
        Actions act = new Actions(driver);
        act.doubleClick(btn2).perform();
    }



}
