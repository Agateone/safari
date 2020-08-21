package Stepdef.Maidenhead;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import cucumber.api.java.en.Given;
import java.net.URL;


public class MAISMO01_maidenhead_register_from_first_use_notice {
	
	public static final String USERNAME = "axate2020";
	  public static final String ACCESS_KEY = "2e99804e-89a3-4e7e-9d56-370719cb578a";
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	
	//--------------------POPSMO01-----------------------
	//Given I am a user of Axate and I am on the registration page through maidenhead FUN 
	@Given("^I am a user of Axate and I am on the registration page through maidenhead FUN")
	@Test(priority=1)
	public void i_am_a_user_of_Axate_and_I_am_on_the_registration_page_through_maidenhead_FUN() throws Throwable {
		
		DesiredCapabilities caps = DesiredCapabilities.safari();
	    caps.setCapability("platform", "macOS 10.15.5");
	    caps.setCapability("version", "latest");
	    WebDriver driver = new RemoteWebDriver(new URL(URL),caps);

					driver.get("https://popbitch.com");					
				
					System.out.println("Couldnt open maidenhead staging");
			
				

		
	}

	
	
}