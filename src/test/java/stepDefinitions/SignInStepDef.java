package stepDefinitions;



import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.SignInPage;
import utilities.XLS_DataProvider;


public class SignInStepDef {
	
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
	   Assert.assertEquals(Expected_title, Actual_title);
	}
	
    
	@When("I enter EmailId and Password")
	public void i_enter_email_id_and_password() throws InterruptedException, EncryptedDocumentException, IOException {
        List<Map<String,String>>testdata = XLS_DataProvider.getTestData("sheet1");
		
		for(Map<String, String>e : testdata) {
			
			
			String Txtbox_Emailid =String.valueOf(e.get("EmailId")); 
			
			String Txtbox_Password =String.valueOf(e.get("Password"));
			
			sp.enterSignInDetails(Txtbox_Emailid, Txtbox_Password);
			
	     }
	}
	

	@Then("I click on Sign In button")
	public void i_click_on_sign_in_button() {
	    sp.clickSignInSubmitButton();
	    String Expected_URL = "https://www.chilternoakfurniture.co.uk/challenge";
	    String Actual_URL = sp.validateURL();
	    Assert.assertEquals(Expected_URL, Actual_URL);
	}
	
	


}
