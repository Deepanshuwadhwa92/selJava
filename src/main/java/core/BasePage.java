package core;

import driver.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.PageProvider;

public class BasePage extends AbstractBasePage {

    protected static Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        //Create the Driver
        driver = DriverManager.getDriver();
    }

    protected PageProvider pages() {
        return new PageProvider(driver);
    }

}
