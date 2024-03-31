package search;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.base.BasePage;
import pages.wikipedia.WikipediaEndPage;
import pages.wikipedia.WikipediaStartPage;
import java.io.IOException;
import static constants.Constant.Urls.START_PAGE;

/**
 * Тесты, верифицирующие требования в задаче
 * */
public class SearchTest extends BaseTest {

    /* Создание страниц */
    public void createPages() {
        basePage = new BasePage(driver);
        wikipediaStartPage = new WikipediaStartPage(driver);
        wikipediaEndPage = new WikipediaEndPage(driver);
    }

    /**
     * Проверка наличия элемента с саджестами
     * */
    @Test
    public void checkExistSuggest() throws InterruptedException {
        basePage.open(START_PAGE);
        wikipediaStartPage.existSuggest();
    }

    /**
     * Проверка выделения поискового запроса жирным шрифтом
     * */
    @Test
    public void checkBoldFont() throws InterruptedException {
        basePage.open(START_PAGE);
        wikipediaStartPage.boldFont();
    }

    /**
     * Проверка корректности перехода на первую подсказку саджеста при нажатии кнопки поиска (лупы)
     * */
    @Test
    public void checkFirstLink() throws IOException {
        basePage.open(START_PAGE);
        wikipediaStartPage.firstLink();
        wikipediaEndPage.checkLink();
    }

    /**
     * Проверка корректности перехода на первую подсказку саджеста при нажатии кнопки поиска и отсутствии саджестов
     * */
    @Test
    public void checkFirstLinkEmpty() throws IOException {
        basePage.open(START_PAGE);
        wikipediaStartPage.firstLinkEmpty();
        wikipediaEndPage.checkFirstLinkEmpty();
    }

    /**
     * Проверка корректности перехода на страницу поиска по выбранному саджесту (первый)
     * */
    @Test
    public void checkToLink() throws InterruptedException, IOException {
        basePage.open(START_PAGE);
        wikipediaStartPage.toLink();
        wikipediaEndPage.checkLink();
    }

    /**
     * Проверка корректности перехода на страницу поиска при клике на "Поиск страниц содержащих"
     * */
    @Test
    public void checkContainWord() throws InterruptedException, IOException {
        basePage.open(START_PAGE);
        wikipediaStartPage.containWord();
        wikipediaEndPage.checkLinkContainWord();
    }
}
