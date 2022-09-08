import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {

    private WebDriver driver;

    private By firstResultSelector = By.cssSelector("img.s-image");

    // private final int TIMEOUT_FIRST_RESULT = 6;


    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage openSearchResult(int index) {

        List<WebElement> firstResult = driver.findElements(firstResultSelector);
        firstResult.get(index).click();
        return new ProductPage(driver);
    }
}
