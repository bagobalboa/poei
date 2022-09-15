package commun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.net.MalformedURLException;

public class SetupTeardown {

    protected WebDriver driver;

    String browser = "firefox";

    @BeforeMethod
    public void before() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.BROWSER_NAME, "chrome");

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

        }

        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();

        //driver = new RemoteWebDriver(new URL("http://admin:admin@192.168.121.11:4444"), options);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
