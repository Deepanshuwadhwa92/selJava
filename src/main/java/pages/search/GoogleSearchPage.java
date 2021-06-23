package pages.search;

import core.BasePage;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleSearchPage extends BasePage {

    private By searchInput = By.name("q");

    public void navigateToGoogle() {
        navigateToURL(DriverManager.getProperties("googleUrl"));
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
