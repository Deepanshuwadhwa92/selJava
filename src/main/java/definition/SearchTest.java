package definition;

import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import pages.GoogleSearchPage;
import pages.YahooSearchPage;

public class SearchTest {

    private WebDriver driver = DriverManager.getDriver();

    @Given("The User is navigate to {string} Home page")
    public void navigateToPage(String searchPage) {
        switch (searchPage) {
            case "google":
                new GoogleSearchPage(driver).navigateToGoogle();
                break;
            case "yahoo":
                new YahooSearchPage(driver).navigateToYahoo();
                break;
            default:
                throw new InvalidArgumentException("Not a Valid Search Page");
        }
    }

    @And("The User enter {string} on {string} Search page")
    public void enterSearchParameter(String parameter, String page) {
        switch (page) {
            case "google":
                new GoogleSearchPage(driver).enterATextInGoogle(parameter);
                break;
            case "yahoo":
                new YahooSearchPage(driver).enterTextInYahoo(parameter);
                break;
            default:
                throw new RuntimeException("Not Found this page");
        }
    }


    @And("The User press Enter Key on {string} Search page")
    public void enterKeyPressOnSearchPage(String searchPage) {
        switch (searchPage) {
            case "google":
                new GoogleSearchPage(driver).enterKeyPress();
                break;
            case "yahoo":
                new YahooSearchPage(driver).enterKeyPressOnYahoo();
                break;
            default:
                throw new RuntimeException("Not Found this page");
        }
    }

    @Then("The User can see the results in {string} Home page")
    public void canSeeTheSearchResults(String searchPage) {
        switch (searchPage) {
            case "google":
                new GoogleSearchPage(driver).sawGooglePage();
                break;
            case "yahoo":
                new YahooSearchPage(driver).sawYahooPage();
                break;
            default:
                throw new RuntimeException("Not Found this page");
        }
    }

}
