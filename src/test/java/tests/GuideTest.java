package tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import page.GuidePage;

public class GuideTest extends BaseTest {

    @Test
    public void getMainGuideTitles_shouldReturnNonEmptyListWithOneElement() {
        guidePage.open();

        Set<String> titles = guidePage.getMainGuideTitles().stream().filter(x -> !x.isEmpty()).collect(Collectors.toSet());

        assertThat(titles).isNotEmpty();
        assertThat(titles).hasSize(1);
        assertThat(titles.stream().map(String::toLowerCase).toList()).contains("руководство для новичков");
    }

    @Test
    public void getOtherGuideTitles_shouldReturnNonEmptyList() {
        guidePage.open();

        Set<String> titles =
            guidePage.getOtherGuideTitles().stream().filter(x -> !x.isEmpty()).map(String::toLowerCase).collect(Collectors.toSet());

        assertThat(titles).isNotEmpty();
        assertThat(titles).hasSize(5);
        assertThat(titles).contains("основное", "экономика world of tanks", "платежи",
            "играем по правилам", "безопасность аккаунта");
    }

}
