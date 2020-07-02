package scenarios.scn_3.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features="D:\\neha\\scenarios\\Scenarios\\resources\\scn_3\\MinMaxPrice.feature",
		glue="scenarios/scn_3.stepdef",
		tags="@tag3",
		plugin = {"pretty",
				"html:target/html/",
				"json:target/json/file.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		
		dryRun=false
		)

public class RunTest {

}
