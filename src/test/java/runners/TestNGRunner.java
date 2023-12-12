package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Users\\hp\\eclipse-workspace\\RLLproject\\src\\test\\java\\features\\SignIn.feature",
glue = {"stepDefinitions"},
dryRun = false,
plugin = {"html:target/Cucumberreport.html",
		 "pretty",
		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		 "timeline:test-output-thread/"
		 }
)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
