package definition;

import core.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.InvalidArgumentException;

public class SearchTest extends BasePage {

    @Given("The User is navigate to {string} Home page")
    public void navigateToPage(String searchPage) {
        switch (searchPage) {
            case "google":
                pages().getGoogleSearchPage().navigateToGoogle();
                break;
            case "yahoo":
                pages().getYahooSearchPage().navigateToYahoo();
                break;
            default:
                throw new InvalidArgumentException("Not a Valid Search Page");
        }
    }

    @And("The User enter {string} on {string} Search page")
    public void enterSearchParameter(String parameter, String page) {
        switch (page) {
            case "google":
                pages().getGoogleSearchPage().enterATextInGoogle(parameter);
                break;
            case "yahoo":
                pages().getYahooSearchPage().enterTextInYahoo(parameter);
                break;
            default:
                throw new RuntimeException("Not Found this page");
        }
    }


    @And("The User press Enter Key on {string} Search page")
    public void enterKeyPressOnSearchPage(String searchPage) {
        switch (searchPage) {
            case "google":
                pages().getGoogleSearchPage().enterKeyPress();
                break;
            case "yahoo":
                pages().getYahooSearchPage().enterKeyPressOnYahoo();
                break;
            default:
                throw new RuntimeException("Not Found this page");
        }
    }

    @Then("The User can see the results in {string} Home page")
    public void canSeeTheSearchResults(String searchPage) {
        switch (searchPage) {
            case "google":
                pages().getGoogleSearchPage().sawGooglePage();
                break;
            case "yahoo":
                pages().getYahooSearchPage().sawYahooPage();
                break;
            default:
                throw new RuntimeException("Not Found this page");
        }
    }

}
