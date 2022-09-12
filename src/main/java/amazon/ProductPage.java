package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;

    private By addCartSelector = By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']");
    private By refuseApplecareSelector = By.cssSelector("[aria-labelledby=\"attachSiNoCoverage-announce\"]");
    private By ajoutPanierSelector = By.cssSelector("#attach-sidesheet-view-cart-button");


    private final int TIMEOUT_NOAPPLECARE = 6;


    // constructeur
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage addToCart() {

        WebElement addCart = driver.findElement(addCartSelector);
        addCart.click();
        return this;
    }

    public ProductPage refuseApplecare() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_NOAPPLECARE));
        WebElement noApplecare = wait.until(ExpectedConditions.elementToBeClickable(refuseApplecareSelector));
        noApplecare.click();
        return this;
    }

    public CartPage openCart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_NOAPPLECARE));
        WebElement ajoutPanier = wait.until(ExpectedConditions.elementToBeClickable(ajoutPanierSelector));
        ajoutPanier.click();
        return new CartPage(driver);
    }
}
