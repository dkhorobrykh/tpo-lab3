package page;

import java.time.Instant;
import java.util.Objects;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor
public abstract class BasePage {

    public final @NonNull WebDriver driver;
    public final @NonNull WebDriverWait wait;

    public abstract String getURL();

    public void open() {
        try {
            driver.get(getURL());
        } catch (TimeoutException ignored) {
        }
    }

    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void click(By locator) {
        WebElement element = find(locator);
        element.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }
    }

    protected String getText(By locator) {
        WebElement element = find(locator);
        return element.getText();
    }

}
