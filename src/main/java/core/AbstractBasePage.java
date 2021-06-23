package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class AbstractBasePage {

    private static Logger log = LoggerFactory.getLogger(AbstractBasePage.class);
    protected WebDriver driver;
    protected final static Long BASE_TIME_OUT = 10L;
    /**
     * Navigate to a URL function
     *
     * @param url - URL Address of that function
     */

    protected void navigateToURL(String url) {
        try {
            log.info("Navigate to: {}", url);
            driver.navigate().to(url);
        } catch (TimeoutException ex) {
            log.warn("Exception while navigating to the {} and Exception {}", url, ex);
        }
    }

    /**
     * Click on a Particular element
     *
     * @param element - Type: By
     */
    protected void clickElement(By element) {
        clickElement(waitUntilElementIsClickable(element, BASE_TIME_OUT));
    }

    /**
     * Click on an element
     *
     * @param element - Type: WebElement
     */
    protected void clickElement(WebElement element) {

        log.info("Click on Element : {}", element);
        waitForAMoment(BASE_TIME_OUT).until((ExpectedCondition<Boolean>) input -> {
            element.click();
            return true;
        });
    }

    /**
     * JavaScript Click on element
     *
     * @param element - Type: By
     */
    protected void javaScriptClick(By element) {

    }

    /**
     * Javascript click
     *
     * @param element - Type: WebElement
     */
    protected void javaScriptClick(WebElement element) {

    }

    /**
     * Select operations for List of value <li><li/>
     *
     * @param element - Type: By
     * @param option  - Value need to Select from the List
     */
    protected void selectOptions(By element, String option) {

    }

    /**
     * Select operations for List of value <li><li/>
     *
     * @param element - Type: WebElement
     * @param option  - Value need to Select from the List
     */
    protected void selectOptions(WebElement element, String option) {

    }

    /**
     * Return the WebElement Reference of the Locator
     *
     * @param locator - Type: By
     * @return WebElement
     */
    protected WebElement existingElement(By locator) {
        try {
            return waitForAMoment(BASE_TIME_OUT).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            log.warn("Existing element {} Function throw an error {}", locator, e);
            return null;
        }
    }

    /**
     * To Find the elements from the particular locator
     *
     * @param locator          - Locator value
     * @param expectingAtLeast - Minimum expectation of element
     * @param duration         - Time duration in second
     * @return List<WebElements> - List of WebElements
     */
    protected List<WebElement> findElements(By locator, int expectingAtLeast, Long duration) {
        waitForAMoment(duration).until((ExpectedCondition<Boolean>) input -> input.findElements(locator).size() >= expectingAtLeast);
        return driver.findElements(locator);
    }

    /**
     * Get the attribute value from the locator
     *
     * @param locator   - Locator value (Type: By)
     * @param attribute - attribute
     * @return value of the specified attribute
     */
    protected String getAttributeValue(By locator, String attribute) {
        return getAttributeValue(existingElement(locator), attribute);
    }

    /**
     * Get the attribute value from the locator
     *
     * @param locator   - Locator value (Type: WebElement)
     * @param attribute - attribute
     * @return value of the specified attribute
     */
    protected String getAttributeValue(WebElement locator, String attribute) {
        return locator.getAttribute(attribute).isEmpty() ? "" : locator.getAttribute(attribute);
    }

    /**
     * Enter texts into a field
     *
     * @param locator   - Locator value of Element (Type: By)
     * @param textValue - Value need to enter into the field
     */
    protected void enterText(By locator, String textValue) {
        log.info("Enter the text: {} into the Field {}", textValue, locator);
        enterText(existingElement(locator), textValue);
    }

    /**
     * Enter texts into a field
     *
     * @param element   - Locator value of Element (Type: WebElement)
     * @param textValue - Value need to enter into the field
     */
    protected void enterText(WebElement element, String textValue) {
        log.info("Enter the text: {} into the Field {}", textValue, element);
        try {
            waitForAMoment(BASE_TIME_OUT).until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(textValue);
        } catch (Exception e) {
            log.error("Error while entering the value inside the field");
        }
    }

    /**
     * Wait Until the element is clickable
     *
     * @param element
     * @param duration
     * @return
     */
    protected WebElement waitUntilElementIsClickable(By element, Long duration) {
        return waitForAMoment(duration).until(ExpectedConditions.elementToBeClickable(element));
    }

    protected Boolean waitUntilElementIsPresent(By locator, Long duration) {
        return waitForAMoment(duration).until((ExpectedCondition<Boolean>) input -> {
            try {
                return driver.findElements(locator).size() > 0;
            } catch (Exception e) {
                return false;
            }
        });
    }

    protected Boolean waitUntilElementIsDisappear(By locator, Long duration) {
        return waitForAMoment(duration).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected WebElement waitUntilElementIsDisplayed(WebElement element, Long duration) {
        return waitForAMoment(duration).until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Poll wait
     *
     * @param polling  - polling time in millisecond
     * @param duration - poll duration in seconds
     * @return
     */
    protected WebDriverWait waitForMomentWithPolling(Long polling, Long duration) {
        return (WebDriverWait) new WebDriverWait(driver, duration)
                .pollingEvery(Duration.ofMillis(polling))
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }

    /**
     * Wait for A Moment
     *
     * @param timeOut - Time in Second
     * @return WebDriverWait
     */
    protected WebDriverWait waitForAMoment(Long timeOut) {
        return (WebDriverWait) new WebDriverWait(driver, timeOut)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }
}
