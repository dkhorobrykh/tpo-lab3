package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.ClanPage;
import page.DownloadPage;
import page.GuidePage;
import page.MainPage;
import page.NewsPage;
import page.OneNewsPage;
import page.RegistrationPage;

public class BaseTest {

    protected WebDriver driver;

    protected MainPage mainPage;
    protected NewsPage newsPage;
    protected OneNewsPage oneNewsPage;
    protected DownloadPage downloadPage;
    protected GuidePage guidePage;
    protected ClanPage clanPage;
    protected RegistrationPage registrationPage;

    @BeforeAll
    static void setupClass() {
        String browser = System.getenv("BROWSER");
        if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
        } else {
            WebDriverManager.chromedriver().setup();
        }
    }

    @BeforeEach
    void setupTest() {
        String browser = System.getenv("BROWSER");
        if ("firefox".equalsIgnoreCase(browser)) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage",
                "--disable-background-networking", "--disable-ipc-flooding-protection",
                "--disable-renderer-backgrounding", "--disable-background-timer-throttling",
                "--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();

        var wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        mainPage = new MainPage(driver, wait);
        newsPage = new NewsPage(driver, wait);
        oneNewsPage = new OneNewsPage(driver, wait);
        downloadPage = new DownloadPage(driver, wait);
        guidePage = new GuidePage(driver, wait);
        clanPage = new ClanPage(driver, wait);
        registrationPage = new RegistrationPage(driver, wait);
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.close();
            try {
                driver.quit();
            } catch (Exception ignored) {}
        }
    }

}
