package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    private WebDriver driver;

    private By livraisonButtonSelector = By.xpath("//*[@id=\"product-detail-page\"]/div/div/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div[2]/div/div[1]/div[2]");
    private By addCartSelector = By.xpath("//*[@id=\"data-produit-acheter\"]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage chooseDeliveryMode() {

        WebElement livraisonsButton = driver.findElement(livraisonButtonSelector);
        livraisonsButton.click();
        return this;
    }

    public ProductPage addToCart() {

        WebElement addCart = driver.findElement(addCartSelector);
        addCart.click();
        return this;
    }
}
