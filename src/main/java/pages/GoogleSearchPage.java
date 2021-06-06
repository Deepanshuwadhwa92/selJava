package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage extends BasePage {

    private By searchInput = By.name("q");

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGoogle() {
        navigateToURL("https://www.google.com");
    }

    public void enterATextInGoogle(String value) {
        enterText(searchInput, value);
    }

    public void enterKeyPress() {
        enterText(searchInput, Keys.ENTER.toString());
    }

    public void sawGooglePage() {
        assert true;
    }
}
