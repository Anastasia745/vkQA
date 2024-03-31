package browsers;

import config.CommonActions;
import org.testng.annotations.BeforeTest;
import search.SearchTest;
import static constants.Constant.Browsers.CHROME_BROWSER;

/**
 * Тесты в браузере Chrome
 * */
public class ChromeSearchTest extends SearchTest {

    @BeforeTest
    public void setDriver() {
        driver = CommonActions.createDriver(CHROME_BROWSER);
        createPages();
    }
}
