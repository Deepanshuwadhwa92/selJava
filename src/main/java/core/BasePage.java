package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage extends AbstractBasePage {

    private static Logger log = LoggerFactory.getLogger(BasePage.class);

    protected void navigateToURL(String url) {
        try {
            log.info("Navigate to: " + url);
            driver.navigate().to(url);
        } catch (TimeoutException ex) {
            throw new RuntimeException("Exception while navigating to the" + url);
        }
    }

    protected void enterText(By locator, String textValue) {
        log.info("Enter the text: " + textValue + " into the Field " + locator);
        enterText(existingElement(locator), textValue);
    }

    protected void enterText(WebElement element, String textValue) {
        log.info("Enter the text: " + textValue + " into the Field " + element);
        try {
            waitForAMoment(baseTimeOut).until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(textValue);
        } catch (Exception e) {
            log.error("Error while entering the value inside the field");
        }
    }

    /**
     * Wait operations
     *
     * @param timeOut
     */
    protected WebDriverWait waitForAMoment(Long timeOut) {
        return (WebDriverWait) new WebDriverWait(driver, timeOut)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }

    protected WebElement existingElement(By locator) {
        WebElement element;
        try {
            element = waitForAMoment(baseTimeOut).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            throw new RuntimeException("Not found this element" + locator);
        }
        return element;
    }
}
