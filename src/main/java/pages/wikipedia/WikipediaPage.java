package pages.wikipedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.base.BasePage;

/**
 * Страница Википедии
 * */
public class WikipediaPage extends BasePage {

    /* Элемент "Поиск страниц, содержащих ..." */
    protected final By containPagesBy = By.cssSelector("body > div.suggestions > a");
    /* Лупа */
    protected final By searchButtonBy = By.xpath("//*[@id=\"searchButton\"]");
    /* Элемент с саджестами */
    protected final By suggestionsElementBy = By.xpath("/html/body/div[6]");
    /* Список подсказок */
    protected final By suggestionsBy = By.cssSelector("body > div.suggestions > div");
    /* Строка поиска */
    protected final By searchLineBy = By.xpath("//*[@id=\"searchInput\"]");

    public WikipediaPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Ввод в строке поиска
     * */
    public void inputRequest(String word) {
        WebElement searchLine = driver.findElement(searchLineBy);
        searchLine.clear();
        Actions actions = new Actions(driver);
        actions.sendKeys(searchLine, word).perform();
    }
}
