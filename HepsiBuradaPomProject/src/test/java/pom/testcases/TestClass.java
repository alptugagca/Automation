package pom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pom.qa.base.TestBase;
import pom.qa.pages.HomePage;
import pom.qa.pages.ProductDetailPage;
import pom.qa.pages.SearchPage;
import pom.qa.util.ConfigReader;
import pom.qa.util.TestListener;

@Listeners(TestListener.class)
public class TestClass  extends TestBase {


    HomePage homePage;
    SearchPage searchPage;

    ProductDetailPage productDetailPage;
    @BeforeTest
    public void setUp() {

        initialization("firefox");
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productDetailPage = new ProductDetailPage(driver);
    }
    @Test(priority = 1)
    public void open_Url() {

        initialization("firefox").get(ConfigReader.getProperty("url"));
    }

    @Test(priority = 2)
    public void verifyHomePage() {

        String homePageTitle = homePage.verifyHomePage();
        Assert.assertEquals(homePageTitle, "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com");
    }

    @Test(priority = 3)
    public void setSearchBar() {

        homePage.setSearchBar("airfryer");
    }

    @Test(priority = 4)
    public void selectItemElements() {

        homePage.clickSuggestionContainerItem();

    }

    @Test(priority = 5)
    public void selectProductItem() {

        searchPage.clickProductItem();
    }

    @Test(priority = 6)
    public void verifyProductDetailPage() {

        String procuctCardText = productDetailPage.verifyProductCardText();
        Assert.assertTrue(procuctCardText.contains("Xiaomi Mi Smart Air Fryer 3,5L Fritöz"));
    }
    @Test(priority = 7)
    public void clickRateTab() {

        productDetailPage.clickRateTab();
    }

    @Test(priority = 8)
    public void selectSortDropDownMenuItem() {

        productDetailPage.clickDropdownMenuItem();
    }

    @Test(priority = 9)
    public void clickThumbsUp() {

        productDetailPage.clickReviewThumbsUp();
    }

    @Test(priority = 10)
    public void verifyCommentText() {

        String commentText = productDetailPage.verifyComment();
        Assert.assertTrue(commentText.contains("Teşekkür Ederiz"));
    }

    @AfterTest
    public void driverClose() {

        closeDriver();
    }
}
