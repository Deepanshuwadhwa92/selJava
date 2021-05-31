package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal();

    public static void createDriver() {

    }
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    /**
     * To Quit the driver
     */

    public static void quitDriver(){
        driver.get().quit();
        driver.remove();
    }

}
