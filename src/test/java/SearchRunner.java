import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/Search.feature",
        glue = {"core", "definition"}, plugin = "html: target/cucumber/report.html")
public class SearchRunner extends BaseRunner {
}
