package browsers;

import config.CommonActions;
import org.testng.annotations.BeforeTest;
import search.SearchTest;
import static constants.Constant.Browsers.EDGE_BROWSER;

/**
 * Тесты в браузере Edge
 * */
public class EdgeSearchTest extends SearchTest {

    @BeforeTest
    public void setDriver() {
        driver = CommonActions.createDriver(EDGE_BROWSER);
        createPages();
    }
}
