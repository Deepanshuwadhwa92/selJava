package pages.yatra;

import core.BasePage;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class YatraLandingPage extends BasePage {


    private By flightOrigin = By.id("BE_flight_origin_city");
    private By addedDestination = By.xpath("custom-autoTxt");
    private By dropDownList = By.cssSelector("div[class='ac_results origin_ac'] p[class='ac_cityname']");

    public void navigateToYatraPage() {
        navigateToURL(DriverManager.getProperties("yatraUrl"));
    }

    public void clickOnDestinationField(String destination) {
        new Actions(driver).moveToElement(existingElement(flightOrigin)).pause(500).click(existingElement(flightOrigin)).build().perform();
        if (waitUntilElementIsDisappear(addedDestination, 10L)) {
            clickElement(flightOrigin);
        }

        waitForMomentWithPolling(1000L, 60L).until(driver -> {
            first_loop:
            for (char dest : destination.toCharArray()) {
                log.info(waitUntilElementIsDisappear(addedDestination, 10L).toString());
                if (waitUntilElementIsDisappear(addedDestination, 10L)) {
                    clickElement(flightOrigin);
                    enterText(flightOrigin, String.valueOf(dest));
                }

                waitUntilElementIsPresent(dropDownList, 30L);
                List<WebElement> elementList = findElements(dropDownList, 1, 30L);
                for (WebElement element : elementList) {
                    log.info("Destination {}", element.getText());
                    if (element.getText().contains(destination)) {
                        log.info("Found Destination {}", element.getText());
                        new Actions(driver).moveToElement(element).pause(500).click(element).build().perform();
                        break first_loop;
                    } else {
                        continue first_loop;
                    }
                }
            }
            return true;
        });
    }
}
