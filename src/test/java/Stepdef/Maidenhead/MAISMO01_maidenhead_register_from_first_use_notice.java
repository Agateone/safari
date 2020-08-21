package Stepdef.Maidenhead;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Elements.Wallet_Elements;
import Elements.Finish_Notice_elements;
import Elements.Popbitch_First_Use_Notice_Elements;
import Elements.Register_Page_Elements1;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MAISMO01_maidenhead_register_from_first_use_notice {
	//Initiate driver
	WebDriver maidenhead_Signup_Page_driver;	
	
	//--------------------POPSMO01-----------------------
	//Given I am a user of Axate and I am on the registration page through maidenhead FUN 
	@Given("^I am a user of Axate and I am on the registration page through maidenhead FUN \"([^\"]*)\"$")
	@Test(priority=1)
	public void i_am_a_user_of_Axate_and_I_am_on_the_registration_page_through_maidenhead_FUN() throws Throwable {
		
		
				maidenhead_Signup_Page_driver= new SafariDriver();
				maidenhead_Signup_Page_driver.manage().window().maximize();
				try {
					maidenhead_Signup_Page_driver.get("https://popbitch.com");					
				}
				catch(Exception e)
				{
					System.out.println("Couldnt open maidenhead staging");
				}
				

		
	}

	
	
}