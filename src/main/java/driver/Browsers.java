package driver;

import org.openqa.selenium.WebDriver;

import java.util.List;

public enum Browsers {

    CHROME {
        @Override
        public WebDriver createDriver(RunType mode, List<String> userOptions) {
            switch (mode) {
                case REMOTE:
                case LOCAL:
                    return ChromeTestDriver.createDriver(userOptions);
                default:
                    throw new RuntimeException("Not found this mode, valid modes are " + RunType.values());
            }
        }
    };

    public abstract WebDriver createDriver(RunType mode, List<String> userOptions);

    public enum RunType {
        REMOTE, LOCAL
    }
}
