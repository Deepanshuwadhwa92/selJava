package core;

import driver.Browsers;
import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import util.PropertiesManager;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Hooks {

    private static Logger log = LoggerFactory.getLogger(Hooks.class);

    private List<String> userOptions = setUserOptions();
    private Browsers.RunType mode = setMode();
    private Browsers browsers = setBrowsers();

    public List<String> setUserOptions() {
        try {
            userOptions = new LinkedList<>(Arrays.asList(System.getProperty("options", "").split(",")));
        } catch (Exception e) {
            throw new RuntimeException("Options not valid");
        }
        return userOptions;
    }                   

    public Browsers.RunType setMode() {
        String modeValue = System.getProperty("mode", "LOCAL").toUpperCase();
        return Browsers.RunType.valueOf(modeValue);
    }

    public Browsers setBrowsers() {
        String browserName = System.getProperty("browsers", "CHROME").toUpperCase();
        return Browsers.valueOf(browserName);
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        log.info("Reading Properties Files...");
        PropertiesManager prop = new PropertiesManager();
        DriverManager.setProperties(prop);

        log.info("Creating the Driver ..");
        WebDriver driver = new EventFiringWebDriver(browsers.createDriver(mode, userOptions));
        DriverManager.setDriver(driver);
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        log.info("Creating the Driver .. for thread {}", Thread.currentThread().getId());
        WebDriver driver = new EventFiringWebDriver(browsers.createDriver(mode, userOptions));
        DriverManager.setDriver(driver);
    }

    @AfterTest(alwaysRun = true)
    public void afterScenario() {
        log.info("Quit the Driver");
        DriverManager.quitDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
        log.info("Quit the Driver");
        DriverManager.quitDriver();
    }

}
