package scenarios.scn_4.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features="D:\\neha\\scenarios\\Scenarios\\resources\\scn_4\\ProductSequence.feature",
		glue="scenarios/scn_4.stepdef",
		tags="@tag4",
		plugin = {"pretty",
				"html:target/html/",
				"json:target/json/file.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		
		dryRun=false
		)

public class RunTest {

}
