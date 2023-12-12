package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\hp\\eclipse-workspace\\RLLproject\\src\\test\\java\\features\\SignIn.feature",
glue = {"stepDefinitions"},
dryRun = false,
plugin = {"html:target/Cucumberreport.html",
		 "pretty",
		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		 "timeline:test-output-thread/"
		 }
)
public class TestRunner {

}
