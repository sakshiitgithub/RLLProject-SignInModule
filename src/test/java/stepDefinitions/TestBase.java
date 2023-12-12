package stepDefinitions;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



public class TestBase {
	
public static WebDriver driver;
	
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static WebDriver getdriver() {
		return driver;
	}
	
	@After
	public void teardown(Scenario scenario)  {
            if(scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			final byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		
		driver.close();
	}
	
	

}
