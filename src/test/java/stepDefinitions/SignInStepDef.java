package stepDefinitions;



import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.SignInPage;
import utilities.XLS_DataProvider;


public class SignInStepDef {
	SoftAssert sa = new SoftAssert();
	WebDriver driver;
	TestBase tb;
	SignInPage sp;

	
	public SignInStepDef(TestBase tb) {
		this.tb=tb;
	}
	
	@Given("I am on the Furniture Website HomePage")
	public void i_am_on_the_furniture_website_home_page() {
		driver = TestBase.getdriver();
	    sp = PageFactory.initElements(driver, SignInPage.class);
	    driver.get("https://www.chilternoakfurniture.co.uk/");
	}

	@When("I click on Sign In icon")
	public void i_click_on_sign_in_icon() {
	   sp.clickSignInIcon();
	   String Expected_title = "Account – Chiltern Oak Furniture";
	   String Actual_title = TestBase.driver.getTitle();
	   sa.assertEquals(Expected_title, Actual_title);
	}
	
    
	@When("I enter EmailId and Password")
	public void i_enter_email_id_and_password() throws InterruptedException, EncryptedDocumentException, IOException {
        List<Map<String,String>>testdata = XLS_DataProvider.getTestData("Sheet1");
		
		for(Map<String, String>e : testdata) {
			
			
			String Txtbox_Emailid =String.valueOf(e.get("EmailId")); 
			
			String Txtbox_Password =String.valueOf(e.get("Password"));
			
			sp.enterSignInDetails(Txtbox_Emailid, Txtbox_Password);
			
	     }
	}
	

	@Then("I click on Sign In button")
	public void i_click_on_sign_in_button()  {
	    sp.clickSignInSubmitButton();
	    
	    WebDriverWait wait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(12000));
	    String expectedURL = "https://www.chilternoakfurniture.co.uk/account";
	   
	    wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(expectedURL)));
	    String Actual_URL = sp.validateURL();
	    sa.assertEquals(expectedURL, Actual_URL);
	   
	}
	
	@When("I enter wrong EmailId and Password")
	public void i_enter_wrong_email_id_and_password() throws EncryptedDocumentException, IOException {
List<Map<String,String>>testdata = XLS_DataProvider.getTestData("Sheet2");
		
		for(Map<String, String>e : testdata) {
			
			
			String Txtbox_Emailid =String.valueOf(e.get("EmailId")); 
			
			String Txtbox_Password =String.valueOf(e.get("Password"));
			
			sp.enterSignInDetails(Txtbox_Emailid, Txtbox_Password);
			
			
		    
			
	     }
		
	}
	
	@Then("click on Sign In button")
	public void click_on_sign_in_button() throws InterruptedException {
		sp.clickSignInSubmitButton();
		
	    Thread.sleep(120000);
	    String actualMessage = sp.message_validation.getText();
	    sa.assertEquals("Incorrect email or password.", actualMessage);
	   
	    
	    sa.assertAll();
     
	
	
	}

}
