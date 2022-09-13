import amazon.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TpPageObjectTest {

    WebDriver driver;

    final String expectedCapacity  = "256Go";
    final String keyword = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";

    @BeforeMethod
    public void before() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        // driver = new ChromeDriver();
        driver = new RemoteWebDriver(new URL("http://192.168.121.11:4444"), options);
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

        // Assert.assertEquals(cartPage.getSubTotal(), "1000");


    }

    @Test
    public void Test2() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie();

        WebElement loginButton = driver.findElement(By.cssSelector("#nav-link-accountList"));

        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton);
        actions.perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
