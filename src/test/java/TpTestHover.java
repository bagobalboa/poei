import amazon.HomePage;
import commun.SetupTeardown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class TpTestHover extends SetupTeardown {

    @Test
    public void TestHover() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie();

        WebElement loginButton = driver.findElement(By.cssSelector("#nav-link-accountList"));

        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton);
        actions.perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

