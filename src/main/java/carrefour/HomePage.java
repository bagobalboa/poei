package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private By acceptCookieSelector = By.cssSelector("#onetrust-accept-btn-handler");

    private By maisonLoisirButtonSelector = By.xpath("//*[@id=\"data-top-bar\"]/div/div/div[2]/label/a");
    private final int TIMEOUT_COOKIE = 6;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage acceptCookie() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieSelector));
        buttonCookie.click();
        return this;
    }

    public ShoppingPage openShoppingPage() {


        WebElement maisonLoisirButton = driver.findElement(maisonLoisirButtonSelector);
        maisonLoisirButton.click();

        return new ShoppingPage(driver);
    }

}
