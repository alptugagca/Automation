package pom.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.qa.base.TestBase;

public class SearchPage extends TestBase {

    WebDriver driver ;
    @FindBy(xpath = "//a[@title='Xiaomi Mi Smart Air Fryer 3,5L Fritöz']//h3[@type='comfort']")
    WebElement productItem;


    public SearchPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickProductItem(){

        clickFunction(productItem);
    }


}
