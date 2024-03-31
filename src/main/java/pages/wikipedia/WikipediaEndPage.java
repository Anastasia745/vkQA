package pages.wikipedia;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Конечная страница
 * */
public class WikipediaEndPage extends WikipediaPage {

    private final String serviceWord = "Служебная";
    private final String searchWord = "Поиск";
    private final String goWord = "Перейти";

    public WikipediaEndPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Проверка адреса страницы после перехода по подсказке
     * */
    public WikipediaEndPage checkLink() throws IOException {
        String currUrl = driver.getCurrentUrl();
        String myWord = URLEncoder.encode("Иван", "UTF-8");
        String str = "https://ru.wikipedia.org/wiki/" + myWord;
        Assert.assertEquals(str, currUrl);
        return this;
    }

    /**
     * Проверка адреса страницы поиска после нажатия на лупу при отсутствии саджеста
     * */
    public WikipediaEndPage checkFirstLinkEmpty() throws IOException {
        String currUrl = driver.getCurrentUrl();
        String myWord = URLEncoder.encode("asdfghjklkjhgfdssa", "UTF-8");
        String str = "https://ru.wikipedia.org/w/index.php?go="
                + URLEncoder.encode(goWord, "UTF-8")
                + "&search=" + myWord + "&title="
                + URLEncoder.encode(serviceWord, "UTF-8")
                + "%3A" + URLEncoder.encode(searchWord, "UTF-8") + "&ns0=1";
        Assert.assertEquals(str, currUrl);
        return this;
    }

    /**
     * Проверка адреса страницы с результатами поиска после нажатия на подсказку "Поиск страниц, содержащих ..."
     * */
    public WikipediaEndPage checkLinkContainWord() throws UnsupportedEncodingException {
        String currUrl = driver.getCurrentUrl();
        String myWord = URLEncoder.encode("Иван", "UTF-8");
        String str = "https://ru.wikipedia.org/w/index.php?fulltext=1&search="
                + myWord + "&title=" + URLEncoder.encode(serviceWord, "UTF-8") + "%3A"
                + URLEncoder.encode(searchWord, "UTF-8") + "&ns0=1";
        Assert.assertEquals(str, currUrl);
        return this;
    }
}
