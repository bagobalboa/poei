package main.java.commun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.IOException;
import java.net.MalformedURLException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class SetupTeardown {

    protected WebDriver driver;
    String browser = "chrome";

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
    public void teardown(ITestResult result) throws IOException, NoSuchAlgorithmException, KeyStoreException, InterruptedException, KeyManagementException {

       ImportResultsToXray res = new ImportResultsToXray();

        if(result.getStatus() == ITestResult.SUCCESS)
        {
            res.generateJsonResults("PASSED");
            System.out.println("Passed **");

        }
        else if(result.getStatus() == ITestResult.FAILURE)
        {
            res.generateJsonResults("FAILED");
            System.out.println("Failed **");

        }
        else if(result.getStatus() == ITestResult.SKIP ){

            res.generateJsonResults("SKIPPED");
            System.out.println("Skiped **");
        }

        res.RemonteResultats();


        driver.quit();
    }
}
