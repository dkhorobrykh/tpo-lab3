package page;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadPage extends BasePage {

    public DownloadPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Getter
    private final String URL = "https://worldoftanks.eu/ru/game/download/";

    private final By downloadButton = By.xpath("//a[contains(@class, 'download-button')]");

    public WebElement getDownloadButton() {
        return find(downloadButton);
    }

}
