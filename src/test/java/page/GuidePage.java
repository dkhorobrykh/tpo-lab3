package page;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GuidePage extends BasePage {

    public GuidePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Getter
    private final String URL = "https://worldoftanks.eu/ru/content/guide/";

    private final By mainGuideSection = By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/article/div/div/ul" +
        "[1]");
    private final By otherGuideSection = By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/article/div/div/ul[2]");

    public Set<String> getMainGuideTitles() {
        Set<String> titles = new HashSet<>();
        List<WebElement> elements = find(mainGuideSection).findElements(By.tagName("span"));
        for (WebElement element : elements) {
            titles.add(element.getText());
        }
        return titles.stream().filter(x -> !List.of(" ", "").contains(x)).collect(Collectors.toSet());
    }

    public Set<String> getOtherGuideTitles() {
        Set<String> titles = new HashSet<>();
        List<WebElement> elements = find(otherGuideSection).findElements(By.tagName("span"));
        for (WebElement element : elements) {
            titles.add(element.getText());
        }
        return titles.stream().filter(x -> !List.of(" ", "").contains(x)).collect(Collectors.toSet());
    }

}
