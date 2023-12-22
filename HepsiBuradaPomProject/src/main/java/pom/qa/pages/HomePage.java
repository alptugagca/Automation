package pom.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.qa.base.TestBase;

public class HomePage extends TestBase {

    WebDriver driver ;
    @FindBy(css = ".searchBoxOld-M1esqHPyWSuRUjMCALPK")
    WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"react-autowhatever-1--item-0\"]")
    WebElement suggestionContainerItem;


    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePage() {

        return driver.getTitle();
    }

    public void setSearchBar(String productName) {
        ThreadSleep(1);
        clickFunction(searchBar);
        setTextFunction(searchBar , productName);
    }

    public void clickSuggestionContainerItem() {
        ThreadSleep(1);
        clickFunction(suggestionContainerItem);
    }




}
