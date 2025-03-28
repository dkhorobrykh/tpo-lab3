package page;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClanPage extends BasePage {

    public ClanPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Getter
    private final String URL = "https://worldoftanks.eu/ru/clanwars";

    private final By searchClanButton = By.xpath("(//a[contains(@class, 'old-button')])[1]");
    private final By createClanButton = By.xpath("(//a[contains(@class, 'old-button')])[2]");

    public WebElement getSearchClanButton() {
        return find(searchClanButton);
    }

    public WebElement getCreateClanButton() {
        return find(createClanButton);
    }

}
