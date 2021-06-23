package driver;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class DriverManager {

    private static Logger log = LoggerFactory.getLogger(DriverManager.class);
    private static Properties properties = new Properties();
    private static ThreadLocal<WebDriver> driver = new ThreadLocal();

    public static WebDriver getDriver() {
        log.info("Get the Driver for thread: --> {}", Thread.currentThread().getId());
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        log.info("Set the Driver for thread: --> {}", Thread.currentThread().getId());
        DriverManager.driver.set(driver);
    }

    public static String getProperties(String property) {
        return properties.getProperty(property);
    }

    public static void setProperties(Properties properties) {
        DriverManager.properties = properties;
    }

    /**
     * To Quit the driver
     */

    public static void quitDriver() {
        log.info("Close the Driver for thread: --> {}", Thread.currentThread().getId());
        //Check The driver Type
        try {
            if (driver.get() != null) {
                driver.get().quit();
                driver.remove();
                Runtime.getRuntime().exec("taskkill /F /IM Chromedriver.exe");
            }
        } catch (IOException e) {
            log.error("IO Exception Occurred {}", e.getMessage());
        }

    }

}
