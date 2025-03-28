package page;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Getter
    private final String URL = "https://worldoftanks.eu/ru/";

    private final By headerGamesButton = By.xpath("(//span[contains(@class, 'cm-showcase_opener')])[1]");
    private final By headerGamesPart =
        By.xpath("(//ul[contains(@class, 'cm-showcase_list')])");

    private final By headerServicesButton = By.xpath("(//span[contains(@class, 'cm-showcase_opener')])[2]");
    private final By headerServicesPart =
        By.xpath("(//ul[contains(@class, 'cm-showcase_list')])");

    private final By sectionNews = By.xpath("//div[@class='main-wrapper_content'][.//article[@style='order: 0']]");
    private final By firstNews = By.xpath("(//a[contains(@class, 'cards-news-widget_card-body__link')])[1]");

    private final By registrationButton = By.xpath("//a[contains(@class, 'cm-link__register')]");

    public List<String> getHeaderGames() {
        List<String> headerGames = new ArrayList<>();
        var body = find(By.tagName("body"));
        body.sendKeys(Keys.PAGE_DOWN);
        body.sendKeys(Keys.PAGE_UP);
        click(headerGamesButton);
        List<WebElement> elements = find(headerGamesPart).findElements(By.tagName("li"));
        for (WebElement element : elements) {
            headerGames.add(element.getText());
        }
        return headerGames;
    }

    public List<String> getHeaderServices() {
        List<String> headerServices = new ArrayList<>();
        var body = find(By.tagName("body"));
        body.sendKeys(Keys.PAGE_DOWN);
        body.sendKeys(Keys.PAGE_UP);
        click(headerServicesButton);
        List<WebElement> elements = find(headerServicesPart).findElements(By.tagName("li"));
        for (WebElement element : elements) {
            headerServices.add(element.getText());
        }
        return headerServices;
    }

    public String getFirstNewsTitle() {
        return find(firstNews).findElement(By.tagName("h3")).getText();
    }

    public List<String> getNewsList() {
        List<String> newsList = new ArrayList<>();
        List<WebElement> elements = find(sectionNews).findElements(By.tagName("h3"));
        for (WebElement element : elements) {
            newsList.add(element.getText());
        }
        return newsList;
    }

    public void clickOnFirstNews() {
        click(firstNews);
    }

    public void clickRegistrationButton() {
        var body = find(By.tagName("body"));
        body.sendKeys(Keys.PAGE_DOWN);
        body.sendKeys(Keys.PAGE_UP);
        click(registrationButton);
    }

}
