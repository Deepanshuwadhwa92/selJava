package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.search.GoogleSearchPage;
import pages.search.YahooSearchPage;
import pages.yatra.YatraLandingPage;

public class PageProvider {

    private final WebDriver driver;

    public PageProvider(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleSearchPage getGoogleSearchPage() {
        return PageFactory.initElements(driver, GoogleSearchPage.class);
    }

    public YahooSearchPage getYahooSearchPage() {
        return PageFactory.initElements(driver, YahooSearchPage.class);
    }

    public YatraLandingPage getYatraPage() {
        return PageFactory.initElements(driver, YatraLandingPage.class);
    }
}
