package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingPage {

    private WebDriver driver;

    private By rayonsButtonSelector = By.cssSelector("[aria-label='Ouvrir la liste des rayons']");
    private By sportLoisirCategorieSelector = By.xpath("//*[@id=\"data-menu-level-0\"]/li[5]/a");

    private By bestSalesCategorieSelector = By.xpath("//*[@id=\"data-menu-level-1_R26\"]/li[3]/a");

    private final int TIMEOUT_HOVER = 6;

    public ShoppingPage (WebDriver driver) {
        this.driver = driver;
    }

    public ShoppingPage openRayonsMenu() {

        WebElement rayonsButton = driver.findElement(rayonsButtonSelector);
        rayonsButton.click();
        return this;
    }

    public ShoppingPage hoverSportsCategorie() {

        WebElement sportLoisirCategorie = driver.findElement(sportLoisirCategorieSelector);

        Actions actions = new Actions(driver);
        actions.moveToElement(sportLoisirCategorie);
        actions.perform();
        return this;
    }

    public BestSellerPage openBestSales() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_HOVER));
        WebElement bestSalesCategorie = wait.until(ExpectedConditions.elementToBeClickable(bestSalesCategorieSelector));
        bestSalesCategorie.click();

        return new BestSellerPage(driver);
    }
}
