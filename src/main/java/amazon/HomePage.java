package main.java.amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private By acceptCookieSelector = By.cssSelector("#sp-cc-accept");
    private By barreRechercheSelector = By.cssSelector("[aria-label=Rechercher]");
    private By validerLoupeSelector = By.cssSelector("[type=submit]");
    private static final Logger Log = LogManager.getLogger(HomePage.class);
    private final int TIMEOUT_COOKIE = 6;

    // constructeur
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * cette fonction permet d'accepter les cookies pour passer à l'étape suivante
     * @return HomePage
     */
    public HomePage acceptCookie() {

        Log.info("J'accepte les cookies");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieSelector));
        buttonCookie.click();
        return this;
    }

    public SearchResultPage searchWithButton(String keyword) {

        Log.info("Je tape ma recherche");

        WebElement barreRecherche = driver.findElement(barreRechercheSelector);
        barreRecherche.sendKeys(keyword);

        WebElement validerLoupe = driver.findElement(validerLoupeSelector);
        validerLoupe.click();

        return new SearchResultPage(driver);
    }
}
