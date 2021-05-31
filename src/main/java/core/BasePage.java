package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BasePage extends AbstractBasePage {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    private static Logger log = LoggerFactory.getLogger(BasePage.class);

}
