package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public enum Browsers {

    CHROME {
        @Override
        public WebDriver createDriver(RunType mode, List<String> userOptions) {
            switch (mode) {
                case REMOTE:
                    return new RemoteWebDriver(hubUrl, ChromeTestDriver.addChromeOptions(new ChromeOptions().addArguments(userOptions)));
                case LOCAL:
                    return ChromeTestDriver.createDriver(userOptions);
                default:
                    log.warn("Not found this mode. Please check the run mode are this {}", RunType.values());
                    return null;
            }
        }
    };


    public abstract WebDriver createDriver(RunType mode, List<String> userOptions);


    public static URL hubUrl = null;

    private static final Logger log = LoggerFactory.getLogger(Browsers.class);

    static {
        try {
            hubUrl = new URL(System.getProperty("host", "http://127.0.0.1:4444/wd/hub"));
        } catch (MalformedURLException exception) {
            log.warn("URL Exception. {}. Please check your HUB: {}", hubUrl, exception.getMessage());
        }
    }

    public enum RunType {
        REMOTE, LOCAL
    }
}
