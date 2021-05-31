package pages.yatra;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YatraLandingPage extends BasePage {

    public YatraLandingPage(WebDriver driver) {
        super(driver);
    }

    private By flightOrigin = By.id("BE_flight_origin_city");
    private By addedDestination = By.className("custom-autoTxt");
    private By dropDownList = By.cssSelector("div[class='ac_results origin_ac'] p[class='ac_cityname']");

    public void navigateToYatraPage() {
        navigateToURL("https://www.yatra.com/");
    }

    public void clickOnDestinationField(String destination) {
        clickElement(flightOrigin);
        int i = 0;
        while (i <= 2) {
            if (waitUntilElementIsPresent(addedDestination, 10L)) {
                clickElement(flightOrigin); i++;
            }
        }
    }
}
