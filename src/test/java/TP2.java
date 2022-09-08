import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TP2 {

    WebDriver driver;


    @BeforeMethod
    public void before(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }


    @Test
    public void testXpath() {



        WebElement acceptCookie = driver.findElement(By.xpath("//input[@class='a-button-input celwidget']"));
        acceptCookie.click();

        WebElement searchBar = driver.findElement(By.xpath("//input[@aria-label='Rechercher']"));
        searchBar.sendKeys("coque iphone 13");

        WebElement launchRequest = driver.findElement(By.xpath("//div[@class='nav-right'][1]/*[1]/*[1]/*[1]"));
        launchRequest.click();

        WebElement firstResult = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        firstResult.click();

        WebElement addCart = driver.findElement(By.xpath("//input[@aria-labelledby='submit.add-to-cart-announce']"));
        addCart.click();

        WebElement clickCart = driver.findElement(By.xpath("//div[@class=\" nav-progressive-attribute\"]"));
        clickCart.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testCss() {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        WebElement acceptCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        acceptCookie.click();

        WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys("coque iphone 13");

        WebElement launchRequest = driver.findElement(By.cssSelector("[type=submit]"));;
        launchRequest.click();

        WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cel-widget=MAIN-SEARCH_RESULTS-2]")));
        firstResult.click();

        WebElement addCart = driver.findElement(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']"));
        addCart.click();

        WebElement clickCart = driver.findElement(By.cssSelector("#nav-cart-text-container"));
        clickCart.click();

    }
}
