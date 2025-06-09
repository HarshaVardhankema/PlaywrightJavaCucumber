package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature/Background.feature",
        glue = {"StepDefinition"},
        plugin = {
                "pretty",
               // "html:target/cucumber-reports/html-report",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml"
        },
        dryRun = false,
        monochrome = true
)
public class TestRunner {
}
