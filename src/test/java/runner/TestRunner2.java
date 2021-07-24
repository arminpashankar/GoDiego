package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "steps",
        plugin = {"pretty", "junit:target/test-runner2-results.xml",
                "json:target/test-runner2-cucumber-reports.json", "html:target/TestRunner2.html"},
        monochrome = true,
        tags = "@get"
)
public class TestRunner2 {
    //"rerun:target/rerun.txt"

}


