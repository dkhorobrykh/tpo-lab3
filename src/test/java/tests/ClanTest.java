package tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ClanTest extends BaseTest {

    @Test
    public void createClanButton_shouldBeVisible() {
        clanPage.open();

        assertThat(clanPage.getCreateClanButton().isDisplayed()).isTrue();
    }

    @Test
    public void searchClanButton_shouldBeVisible() {
        clanPage.open();

        assertThat(clanPage.getSearchClanButton().isDisplayed()).isTrue();
    }

}
