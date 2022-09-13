import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class TP3Test {

    WebDriver driver;

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
    public void teardown(){
        driver.quit();
    }

    @Test
    public void testAmazon() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement acceptCookie = driver.findElement(By.cssSelector("#sp-cc-accept"));
        acceptCookie.click();

        WebElement buttonAll = driver.findElement(By.cssSelector("#nav-hamburger-menu"));
        buttonAll.click();

        WebElement bestSalesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[2]/a")));
        bestSalesButton.click();

        WebElement thirdProduct = driver.findElement(By.xpath("//*[@id=\"anonCarousel1\"]/ol/li[3]"));
        thirdProduct.click();


    }

    @Test
    public void testAmazonList() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement acceptCookie = driver.findElement(By.cssSelector("#sp-cc-accept"));
        acceptCookie.click();

        WebElement buttonAll = driver.findElement(By.cssSelector("#nav-hamburger-menu"));
        buttonAll.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item")));

        List<WebElement> menuList = driver.findElements(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item"));
        menuList.get(0).click();

        List<WebElement> thirdProduct = driver.findElements(By.cssSelector("div.a-carousel-viewport > ol > li.a-carousel-card"));
        thirdProduct.get(2).click();


    }
}
