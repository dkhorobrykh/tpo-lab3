package tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import page.DownloadPage;

public class DownloadTest extends BaseTest{

    @Test
    public void downloadGamePage_shouldContainsDownloadButton() {
        downloadPage.open();

        assertThat(downloadPage.getDownloadButton().isDisplayed()).isTrue();
    }

}
