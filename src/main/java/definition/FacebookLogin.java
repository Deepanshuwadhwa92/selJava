package definition;

import core.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class FacebookLogin extends BasePage {


    @Given("The User is navigating to Facebook Page")
    public void navigateTofaceBook() {
        driver.navigate().to("https://www.facebook.com/");
    }

    @And("The User enter userid and password at login Page")
    public void enterLogins() throws InterruptedException {
        enterText(By.id("email"),"test@test.com");
        driver.findElement(By.id("pass")).sendKeys("test");
    }

    @Then("The User can view Facebook Logo")
    public void viewFacebook() {

    }
}


