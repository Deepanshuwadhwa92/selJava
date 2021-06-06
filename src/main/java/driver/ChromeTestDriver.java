package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ChromeTestDriver {

    private static Logger log = LoggerFactory.getLogger(ChromeTestDriver.class);

    public static WebDriver createDriver(List<String> userOptions) {
        WebDriver driver;
        try {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = addChromeOptions(new ChromeOptions());
            userOptions.removeIf(item -> item == "");
            if (userOptions.isEmpty() && userOptions != null) userOptions.forEach(value -> options.addArguments(value));
            driver = new ChromeDriver(options);
        } catch (Exception ex) {
           ex.printStackTrace();
           log.error("Failed to create webDriver for Chrome with user Options: {} and Exception message: {}", userOptions, ex.getMessage());
           return null;
        }
        return driver;
    }

    public static ChromeOptions addChromeOptions(ChromeOptions options) {
        options.addArguments("--disable-dev-shm-usage")
                .addArguments("--disable-extensions")
                .addArguments("--window-size=1600,900")
                .addArguments("--no-sandbox")
                .addArguments("--disable-popup-blocking");
        if (System.getProperty("devtools") == "true") options.addArguments("--auto-open-devtools-for-tabs");
        return options;
    }
}
