import carrefour.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpCarrefour {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.carrefour.fr/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testCarrefour() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie()
                .openShoppingPage()
                .openRayonsMenu()
                .hoverSportsCategorie()
                .openBestSales()
                .openFirstResultSports()
                .chooseDeliveryMode()
                .addToCart();



        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
