package tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class NewsTest extends BaseTest {

    @Test
    public void getFirstNewsTitle_shouldReturnNonEmptyStringWithNeededValue() {
        mainPage.open();
        String firstNewsTitle = mainPage.getFirstNewsTitle();

        assertThat(firstNewsTitle).isNotBlank();

        assertThat(firstNewsTitle).contains("Спецвыпуск Боевого пропуска");
    }

    @Test
    public void getNews_shouldReturnNonEmptyList() {
        mainPage.open();
        List<String> news = mainPage.getNewsList();

        assertThat(news).isNotEmpty();
    }

    @Test
    public void showMore_shouldAddNewNews() {
        mainPage.open();
        Set<String> newsBefore = mainPage.getNewsList().stream().filter(x -> !List.of(" ", "").contains(x)).collect(
            Collectors.toSet());

        mainPage.showMoreNews();

        Set<String> newsAfter = mainPage.getNewsList().stream().filter(x -> !List.of(" ", "").contains(x)).collect(
            Collectors.toSet());

        assertThat(newsAfter).isNotEqualTo(newsBefore);
        assertThat(newsAfter).containsOnlyOnceElementsOf(newsBefore);
    }

    @Test
    public void clickOnNewsFromMainPage_shouldOpenThisNews() throws InterruptedException {
        mainPage.open();

        mainPage.clickOnFirstNews();

        String currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).contains(oneNewsPage.getURL());

        String currentNewsTitle = oneNewsPage.getNewsTitle().toLowerCase();
        assertThat(currentNewsTitle).contains("спецвыпуск боевого пропуска");
    }

    @Test
    public void showMoreInNewsPage_shouldAddNewNews() {
        newsPage.open();

        List<String> newsBefore = newsPage.getNewsList();

        newsPage.showMoreNews();

        List<String> newsAfter = newsPage.getNewsList();

        assertThat(newsAfter).isNotEqualTo(newsBefore);
        assertThat(newsAfter).containsOnlyOnceElementsOf(newsBefore);
    }

    @Test
    public void twiceShowMoreInNewsPage_shouldAddPadding() {
        newsPage.open();

        List<String> newsBefore = newsPage.getNewsList();

        newsPage.showMoreNews();
        newsPage.showMoreNews();

        List<String> newsAfter = newsPage.getNewsList();

        assertThat(newsAfter).isNotEqualTo(newsBefore);
        assertThat(newsAfter).containsOnlyOnceElementsOf(newsBefore);

        assertThat(newsPage.getNewsPadding().isDisplayed()).isTrue();
        assertThat(newsPage.getShowMoreButton().isDisplayed()).isFalse();
    }

}
