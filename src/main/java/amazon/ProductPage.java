package amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger Log = LogManager.getLogger(ProductPage.class);


    private final int TIMEOUT_NOAPPLECARE = 6;


    // constructeur
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage addToCart() {
        Log.info("Je met mon produit dans mon panier");

        WebElement addCart = driver.findElement(addCartSelector);
        addCart.click();
        return this;
    }

    public ProductPage refuseApplecare() {

        Log.info("Je refuse l'applecare");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_NOAPPLECARE));
        WebElement noApplecare = wait.until(ExpectedConditions.elementToBeClickable(refuseApplecareSelector));
        noApplecare.click();
        return this;
    }

    public CartPage openCart() {

        Log.info("J'ouvre le panier");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_NOAPPLECARE));
        WebElement ajoutPanier = wait.until(ExpectedConditions.elementToBeClickable(ajoutPanierSelector));
        ajoutPanier.click();
        return new CartPage(driver);
    }
}

