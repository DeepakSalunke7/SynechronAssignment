package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/Report.HTML", "json:target/Report.Json"},
		features = "src/test/resources/features",
		glue ={"stepDefinations","hooks"},
		monochrome = true
		)

public class LoginTestRunner {

}
	