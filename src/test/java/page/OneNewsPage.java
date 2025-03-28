package page;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneNewsPage extends BasePage {

    public OneNewsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Getter
    private final String URL = "https://worldoftanks.eu/ru/news/";

    private final By newsTitle = By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/section[1]/div[2]/h1");

    public String getNewsTitle() {
        return getText(newsTitle);
    }
}
