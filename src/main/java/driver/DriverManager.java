package driver;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverManager {

    private static Logger log = LoggerFactory.getLogger(DriverManager.class);

    private static ThreadLocal<WebDriver> driver = new ThreadLocal();

    public static void createDriver() {

    }

    public static WebDriver getDriver() {
        log.info("Get the Driver for thread: --> {}", Thread.currentThread().getId());
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        log.info("Set the Driver for thread: --> {}", Thread.currentThread().getId());
        DriverManager.driver.set(driver);
    }

    /**
     * To Quit the driver
     */

    public static void quitDriver() {
        log.info("Close the Driver for thread: --> {}", Thread.currentThread().getId());
        //Check The driver Type
        if (driver.get() == null) {
            return;
        }
        driver.get().quit();
        driver.remove();
    }

}
