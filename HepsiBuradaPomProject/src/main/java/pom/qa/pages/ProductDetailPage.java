package pom.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.qa.base.TestBase;

public class ProductDetailPage extends TestBase {

    WebDriver driver ;
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    @FindBy(css = "h1#product-name")
    WebElement productDetailItem;

    @FindBy(css = ".product-comments")
    WebElement rateTab;

    @FindBy(css = "a#productReviews")
    WebElement productReviews;

    @FindBy(css = ".hermes-Sort-module-Zwr_VRf_e4tZXl5J1PgT")
    WebElement sortingDropdown;

    @FindBy(css = "div[class='hermes-Sort-module-vJqiqyAGHsTNXjMsIwJD'] div:nth-child(2)")
    WebElement sortingDropdownItem;

    @FindBy(css = ".hermes-ReviewCard-module-lOsa4wAwncdp3GgzpaaV")
    WebElement thumbsUp;

    @FindBy(css = ".hermes-ReviewCard-module-eFtSSTU4lYZLCnzHtzca")
    WebElement commentText;

    public ProductDetailPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String verifyProductCardText() {

        windowsHandler();
        ThreadSleep(1);
        verifyElementFunction(productDetailItem);
        return productDetailItem.getText();
    }

    public void clickRateTab() {

        if(productReviews.getText().equals("Henüz değerlendirilmemiş")){

            System.out.println(productReviews.getText());

        }else{

            clickFunction(rateTab);
            ThreadSleep(1);
            keyboardInputActionFunction(Keys.SPACE);
        }
    }

    public void clickDropdownMenuItem()
    {
        ThreadSleep(1);
        clickFunction(sortingDropdown);
        ThreadSleep(1);
        clickFunction(sortingDropdownItem);
    }

    public void clickReviewThumbsUp(){
        ThreadSleep(2);
        keyboardInputActionFunction(Keys.SPACE);
        ThreadSleep(1);
        clickFunction(thumbsUp);
    }

    public String verifyComment(){

        return commentText.getText();
    }
}
