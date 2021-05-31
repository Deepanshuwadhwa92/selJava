package definition;

import driver.DriverManager;
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
                new GoogleSearchPage(DriverManager.getDriver()).navigateToGoogle();
                break;
            case "yahoo":
                new YahooSearchPage(DriverManager.getDriver()).navigateToYahoo();
                break;
            default:
                throw new RuntimeException("Not a Valid Search Page");
        }
    }

    @And("The User enter {string} on {string} Search page")
    public void enterSearchParameter(String parameter, String page) {
        switch (page) {
            case "google":
                new GoogleSearchPage(DriverManager.getDriver()).enterATextInGoogle(parameter);
                break;
            case "yahoo":
                new YahooSearchPage(DriverManager.getDriver()).enterTextInYahoo(parameter);
                break;
            default:
                throw new RuntimeException("Not Found this page");
        }
    }


    @And("The User press Enter Key on {string} Search page")
    public void enterKeyPressOnSearchPage(String searchPage) {
        switch (searchPage) {
            case "google":
                new GoogleSearchPage(DriverManager.getDriver()).enterKeyPress();
                break;
            case "yahoo":
                new YahooSearchPage(DriverManager.getDriver()).enterKeyPressOnYahoo();
                break;
            default:
                throw new RuntimeException("Not Found this page");
        }
    }

    @Then("The User can see the results in {string} Home page")
    public void canSeeTheSearchResults(String searchPage) {
        switch (searchPage) {
            case "google":
                new GoogleSearchPage(DriverManager.getDriver()).sawGooglePage();
                break;
            case "yahoo":
                new YahooSearchPage(DriverManager.getDriver()).sawYahooPage();
                break;
            default:
                throw new RuntimeException("Not Found this page");
        }
    }

}
