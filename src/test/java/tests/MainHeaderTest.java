package tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import page.MainPage;

public class MainHeaderTest extends BaseTest {

    @Test
    public void getHeaderGames_shouldReturnNonEmptyList() {
        mainPage.open();
        List<String> games = mainPage.getHeaderGames();

        assertThat(games).isNotEmpty();
    }

    @Test
    public void getHeaderServices_shouldReturnNonEmptyList() {
        mainPage.open();
        List<String> services = mainPage.getHeaderServices();

        assertThat(services).isNotEmpty();
    }

    @Test
    public void clickOnEnterButton_shouldRedirectToRegistrationPage() {
        mainPage.open();
        mainPage.clickRegistrationButton();

        String currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).contains(registrationPage.getURL());
    }

}
