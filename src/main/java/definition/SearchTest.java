package definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.GoogleSearchPage;
import pages.YahooSearchPage;

public class SearchTest {

    @Given("The User is navigate to {string} Home page")
    public void navigateToPage(String searchPage) {
        switch (searchPage) {
            case "google":
                new GoogleSearchPage().navigateToGoogle();
                break;
            case "yahoo":
                new YahooSearchPage().navigateToYahoo();
                break;
            default:
                throw new RuntimeException("Not a Valid Search Page");
        }
    }

    @And("The User enter {string} on {string} Search page")
    public void enterSearchParameter(String parameter, String page) {
        switch (page) {
            case "google":
                new GoogleSearchPage().enterATextInGoogle(parameter);
                break;
            case "yahoo":
                new YahooSearchPage().enterTextInYahoo(parameter);
                break;
            default:
                throw new RuntimeException("Not Found this page");
        }
    }


    @And("The User press Enter Key on {string} Search page")
    public void enterKeyPressOnSearchPage(String searchPage) {
        switch (searchPage) {
            case "google":
                new GoogleSearchPage().enterKeyPress();
                break;
            case "yahoo": new YahooSearchPage().enterKeyPressOnYahoo(); break;
            default:
                throw new RuntimeException("Not Found this page");
        }
    }

    @Then("The User can see the results in {string} Home page")
    public void canSeeTheSearchResults(String searchPage) {
        switch (searchPage) {
            case "google":
                new GoogleSearchPage().sawGooglePage();
                break;
            case "yahoo": new YahooSearchPage().sawYahooPage();break;
            default:
                throw new RuntimeException("Not Found this page");
        }
    }

}
