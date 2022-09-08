import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpPageObject {

    WebDriver driver;

    final String expectedCapacity  = "256Go";
    final String keyword = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testPO() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie()
                .searchWithButton(keyword)
                .openSearchResult(0)
                .addToCart()
                .refuseApplecare()
                .openCart()
                .selectQuantity(2);


    }


}
