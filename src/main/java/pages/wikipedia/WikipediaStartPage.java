package pages.wikipedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.util.List;
import static constants.Constant.TimeoutVariable.WAITING_TIME;

/**
 * Стартовая страница
 * */
public class WikipediaStartPage extends WikipediaPage {

    public WikipediaStartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Появление саджестов при вводе поискового запроса
     * */
    public WikipediaStartPage existSuggest() throws InterruptedException {
        inputRequest("Иван");
        Thread.sleep(WAITING_TIME);

        boolean isExist = true;
        try {
            driver.findElement(suggestionsElementBy);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            isExist = false;
        }
        Assert.assertTrue(isExist);
        return this;
    }

    /**
     * Переход на первую подсказку саджеста при нажатии кнопки поиска (лупы)
     * */
    public WikipediaStartPage firstLink() {
        inputRequest("Иван");
        driver.findElement(searchButtonBy).click();
        return this;
    }

    /**
     * Переход на страницу поиска при нажатии кнопки поиска и отсутствии саджестов
     * */
    public WikipediaStartPage firstLinkEmpty() {
        inputRequest("asdfghjklkjhgfdssa");
        driver.findElement(searchButtonBy).click();
        return this;
    }

    /**
     * Переход на страницу поиска по выбранному саджесту (первый)
     * */
    public WikipediaStartPage toLink() throws InterruptedException {
        inputRequest("Иван");
        Thread.sleep(WAITING_TIME);

        WebElement linksList = driver.findElement(suggestionsBy);
        List<WebElement> links = linksList.findElements(By.tagName("a"));
        if(!links.isEmpty()) {
            WebElement link = links.get(0);
            link.click();
        }
        return this;
    }

    /**
     * Выделение поискового запроса жирным шрифтом
     * */
    public WikipediaStartPage boldFont() throws InterruptedException {
        inputRequest("Иван");
        Thread.sleep(WAITING_TIME);
        boolean bold = true;

        WebElement linksList = driver.findElement(suggestionsBy);
        List<WebElement> links = linksList.findElements(By.tagName("a"));

        for (WebElement link: links) {
            WebElement word = link.findElement(By.tagName("div")).findElement(By.tagName("span"));
            String fontWeight = word.getCssValue("font-weight");
            if (!fontWeight.equals("bold") && !fontWeight.equals("700")) {
                bold = false;
                break;
            }
        }
        Assert.assertTrue(bold);
        return this;
    }

    /**
     * Переход на страницу поиска при клике на "Поиск страниц содержащих"
     * */
    public WikipediaStartPage containWord() throws InterruptedException {
        WebElement searchLine = driver.findElement(searchLineBy);
        searchLine.clear();
        Actions actions = new Actions(driver);
        actions.sendKeys(searchLine, "Ива").perform();
        Thread.sleep(WAITING_TIME);
        actions.sendKeys(searchLine, "н").perform();

        WebElement element = driver.findElement(containPagesBy);
        element.click();
        return this;
    }
}
