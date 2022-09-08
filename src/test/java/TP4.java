import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TP4 {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");
        WebElement Cookie = driver.findElement(By.cssSelector("#sp-cc-accept"));
        Cookie.click();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testAmazonAssert(){
        // Arrange

        final String expectedSoustotal = "Sous-total (2 articles):";
        final String expectedTaille = "256Go";
        final String expectedCouleur = "Vert alpin";
        final String expectedConfiguration = "Sans AppleCare+";

        // Act

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement barreRecherche = driver.findElement(By.xpath("//input[@aria-label='Rechercher']"));
        barreRecherche.sendKeys("Apple iPhone 13 Pro Max (256 Go) - Vert Alpin");

        WebElement validerLoupe = driver.findElement(By.xpath("//div[@class='nav-right'][1]/*[1]/*[1]/*[1]"));
        validerLoupe.click();

        WebElement premierResultat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cel-widget=MAIN-SEARCH_RESULTS-2]")));
        premierResultat.click();

        WebElement addCart = driver.findElement(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']"));
        addCart.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-labelledby=\"attachSiNoCoverage-announce\"]")));

        WebElement noApplecare = driver.findElement(By.cssSelector("[aria-labelledby=\"attachSiNoCoverage-announce\"]"));
        noApplecare.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-labelledby=\"attach-sidesheet-view-cart-button-announce\"]")));

        WebElement ajoutPanier = driver.findElement(By.cssSelector("[aria-labelledby=\"attach-sidesheet-view-cart-button-announce\"]"));
        ajoutPanier.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#quantity")));

        WebElement dropdown = driver.findElement(By.cssSelector("#quantity"));
        Select quantiteSelect = new Select(dropdown);
        quantiteSelect.selectByIndex(2);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        List<WebElement> informations = driver.findElements(By.cssSelector(".a-text-bold + span"));
        WebElement taille = informations.get(0);
        WebElement couleur = informations.get(1);
        WebElement configuration = informations.get(2);
        WebElement soustotale = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sc-subtotal-label-activecart")));


        // Asserts

        Assert.assertEquals(taille.getText(),expectedTaille,"Taille pas bon");
        Assert.assertEquals(couleur.getText(),expectedCouleur ,"couleur pas bon");
        Assert.assertEquals(configuration.getText(),expectedConfiguration ,"config pas bon");
        Assert.assertEquals(soustotale.getText(),expectedSoustotal,"sous total pas bon");


    }
}
