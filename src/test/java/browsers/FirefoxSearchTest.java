package browsers;

import config.CommonActions;
import org.testng.annotations.BeforeTest;
import search.SearchTest;
import static constants.Constant.Browsers.FIREFOX_BROWSER;

/**
 * Тесты в браузере Firefox
 * */
public class FirefoxSearchTest extends SearchTest {

    @BeforeTest
    public void setDriver() {
        driver = CommonActions.createDriver(FIREFOX_BROWSER);
        createPages();
    }
}
