package scenarios.scn_1.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features="D:\\neha\\scenarios\\Scenarios\\resources\\scn_1\\Search.feature",
		glue="scenarios/scn_1.stepdef",
		tags="@tag1",
		plugin = {"pretty",
				"html:target/html/",
				"json:target/json/file.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		
		dryRun=false
		)

public class RunTest {

}
