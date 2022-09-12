package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BestSellerPage {

    private WebDriver driver;

    private By voirButtonSelector = By.cssSelector("#3663326022551 > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > a");

    public BestSellerPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage openFirstResultSports() {

        WebElement voirButton = driver.findElement(voirButtonSelector);
        voirButton.click();
        return new ProductPage(driver);
    }

}
