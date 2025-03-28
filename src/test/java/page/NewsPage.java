package page;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage extends BasePage {

    public NewsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Getter
    private final String URL = "https://worldoftanks.eu/ru/news/";

    private final By sectionNews = By.xpath("//div[contains(@class, 'preview')]");

    private final By moreNewsButton = By.xpath("//a[contains(@class, 'show-more_link')]");

    private final By newsPadding = By.xpath("//div[contains(@class, 'paging')]");

    private final By filterSection = By.xpath("//div[contains(@class, 'filter')]");

    public static final String CATEGORY_HISTORY = "История";
    public static final String CATEGORY_ARCHIVE = "Архив";
    public static final String CATEGORY_TOURNAMENTS = "Турниры";

    public List<String> getNewsList() {
        List<String> newsList = new ArrayList<>();
        List<WebElement> elements = find(sectionNews).findElements(By.tagName("h2"));
        for (WebElement element : elements) {
            newsList.add(element.getText());
        }
        return newsList;
    }

    public void showMoreNews() {
        click(moreNewsButton);
    }

    public WebElement getNewsPadding() {
        return find(newsPadding);
    }

    public WebElement getShowMoreButton() {
        return find(moreNewsButton);
    }

    public void selectFilterCategory(String category) {
        var filterTextElement = find(filterSection);

        var actions = new Actions(driver);
        actions.moveToElement(filterTextElement).perform();

        var categoryMenu = find(By.xpath("//ul[contains(@class, 'filter-list')]"));

        var categoryElement =
            categoryMenu.findElement(By.xpath("//li//span[@class='filter-list_text' and text()='" + category + "']"));

        categoryElement.click();

        actions.moveToLocation(1, 1).perform();
    }

}
