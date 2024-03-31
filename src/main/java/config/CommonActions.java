package config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class CommonActions {
    static public WebDriver createDriver(String browser) {
        WebDriver driver = null;

        switch (browser) {
            case "Edge":
                System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                Assert.fail("Incorrect browser name " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}
