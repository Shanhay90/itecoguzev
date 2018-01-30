package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"},
        glue = "stepDef",
        tags = "@11111",
        plugin = {"html:target/cucumber-html-report"}
        )
public class TestRunner {

}
