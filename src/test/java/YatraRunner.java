import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/feature/yatra.feature",
        glue = {"core", "definition"}, plugin = "html: target/cucumber/report.html")
public class YatraRunner extends BaseRunner {
}
