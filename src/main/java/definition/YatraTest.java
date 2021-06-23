package definition;

import core.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class YatraTest extends BasePage {


    @Given("The User is in yatra WebSite Page")
    public void navigateToYatraPage() {
       pages().getYatraPage().navigateToYatraPage();
    }

    @And("The User click on destination field on yatra WebSite Page")
    public void clickOnDesinationField() {
//        new YatraLandingPage(DriverManager.getDriver()).clickOnDestinationField("");
    }

    @And("The User click on the destination {string} in the yatra WebSite Page")
    public void clickOnDestination(String destination) {
        pages().getYatraPage().clickOnDestinationField(destination);
    }

    @Then("The User can see that the destination is added to the Destination {string} in the yatra WebSite Page")
    public void userCanSeeTheDestination(String destination) {
//        YatraLandingPage().canSeeTheDestinationAdded(destination);
    }
}
