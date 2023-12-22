package pom.qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static int IMPLICITYLY_WAIT =5;

    public static int DURATION_INT =15;
    private static int PAGE_LOAD_TIMEOUT=30;
    public static WebDriver initialization(String browser) {

        if (driver == null) {

            switch (browser) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(IMPLICITYLY_WAIT, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);


        }
        return driver;
    }

    public static void closeDriver() {

        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
    public void clickFunction(WebElement x) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DURATION_INT));
        wait.until(ExpectedConditions.elementToBeClickable(x));
        x.click();
    }

    public void verifyElementFunction(WebElement x) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DURATION_INT));
        wait.until(ExpectedConditions.elementToBeClickable(x));
    }

    public void setTextFunction(WebElement x, String y) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DURATION_INT));
        wait.until(ExpectedConditions.elementToBeClickable(x));
        Actions actions = new Actions(driver);
        actions.moveToElement(x).click().sendKeys(y).build().perform();
    }

    public void windowsHandler(){

        Set<String> windowAllWindows = driver.getWindowHandles();

        for(String window:windowAllWindows){

            driver.switchTo().window(window);
        }
    }

    public void keyboardInputActionFunction(Keys x) {
        Actions actionProvider = new Actions(driver);
        Action key = actionProvider.keyDown(x).build();
        key.perform();
    }

    public void ThreadSleep ( int i)
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {

        }

    }

}
