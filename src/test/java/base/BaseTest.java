package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import pages.base.BasePage;
import pages.wikipedia.WikipediaEndPage;
import pages.wikipedia.WikipediaStartPage;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected BasePage basePage;
    protected WikipediaStartPage wikipediaStartPage;
    protected WikipediaEndPage wikipediaEndPage;

    /**
     * Очистка Cookie после каждого теста
     * */
    @AfterTest
    public void clearCookieAndLocalStorage() {
        JavascriptExecutor javascriptException = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        javascriptException.executeScript("window.sessionStorage.clear()");
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        driver.quit();
    }
}
