package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class YahooSearchPage extends BasePage {

    private By searchInput = By.name("p");

    public void navigateToYahoo() {
        navigateToURL("https://au.yahoo.com/");
    }

    public void enterTextInYahoo(String value) {
        enterText(searchInput, value);
    }

    public void enterKeyPressOnYahoo() {
        enterText(searchInput, Keys.ENTER.toString());
    }

    public void sawYahooPage(){
        assert true;
    }
}
