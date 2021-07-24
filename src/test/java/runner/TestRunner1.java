package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "steps",
        plugin = {"pretty", "junit:target/test-runner1-results.xml",
                "json:target/test-runner1-cucumber-reports.json", "html:target/TestRunner1.html"},
        monochrome = true,
        tags = "@post"
)
public class TestRunner1 {
    //"rerun:target/rerun.txt"
}


