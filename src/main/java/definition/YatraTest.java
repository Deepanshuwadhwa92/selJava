package definition;

import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.yatra.YatraLandingPage;

public class YatraTest {

    @Given("The User is in yatra WebSite Page")
    public void navigateToYatraPage() {
        new YatraLandingPage(DriverManager.getDriver()).navigateToYatraPage();
    }

    @And("The User click on destination field on yatra WebSite Page")
    public void clickOnDesinationField() {
//        new YatraLandingPage(DriverManager.getDriver()).clickOnDestinationField("");
    }

    @And("The User click on the destination {string} in the yatra WebSite Page")
    public void clickOnDestination(String destination){
        new YatraLandingPage(DriverManager.getDriver()).clickOnDestinationField(destination);
    }

    @Then("The User can see that the destination is added to the Destination {string} in the yatra WebSite Page")
    public void userCanSeeTheDestination(String destination) {
//        YatraLandingPage().canSeeTheDestinationAdded(destination);
    }
}
