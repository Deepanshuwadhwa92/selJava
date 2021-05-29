package core;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractBasePage {

    protected final Long baseTimeOut = 10L;
    protected final WebDriver driver = DriverManager.getDriver();

    /**
     * Navigate to a URL function
     * @param url - URL Address of that function
     */

    protected abstract void navigateToURL(String url);

    /**
     * Text Entry Operations
     * @param locator
     * @param textValue
     */
    protected abstract void enterText(By locator, String textValue);
    protected abstract void enterText(WebElement element, String textValue);

    /**
     * Wait operations
     */

    protected abstract WebDriverWait waitForAMoment(Long timeOut);
    protected abstract WebElement existingElement(By locator);
}
