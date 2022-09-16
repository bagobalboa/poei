package main.java.amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {

    private WebDriver driver;

    private By firstResultSelector = By.cssSelector("img.s-image");

    private static final Logger Log = LogManager.getLogger(SearchResultPage.class);

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage openSearchResult(int index) {

        Log.info("La page de résultat s'est ouverte");

        List<WebElement> firstResult = driver.findElements(firstResultSelector);
        firstResult.get(index).click();
        return new ProductPage(driver);
    }
}

