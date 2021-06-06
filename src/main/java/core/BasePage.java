package core;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage extends AbstractBasePage {

    protected static Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        super(driver);
    }

}
