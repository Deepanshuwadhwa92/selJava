package definition;

import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.yatra.YatraLandingPage;

public class YatraTest {
    private WebDriver driver;

    public YatraTest() {
        driver = DriverManager.getDriver();
    }

    @Given("The User is in yatra WebSite Page")
    public void navigateToYatraPage() {
        new YatraLandingPage(driver).navigateToYatraPage();
    }

    @And("The User click on destination field on yatra WebSite Page")
    public void clickOnDesinationField() {
//        new YatraLandingPage(DriverManager.getDriver()).clickOnDestinationField("");
    }

    @And("The User click on the destination {string} in the yatra WebSite Page")
    public void clickOnDestination(String destination) {
        new YatraLandingPage(driver).clickOnDestinationField(destination);
    }

    @Then("The User can see that the destination is added to the Destination {string} in the yatra WebSite Page")
    public void userCanSeeTheDestination(String destination) {
//        YatraLandingPage().canSeeTheDestinationAdded(destination);
    }
}
