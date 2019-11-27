/*package Stepdef.Maidenhead;

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
import Elements.Popbitch_Logged_Out_Wallet;

import Elements.Register_Page_Elements1;
import Elements.Wallet_Elements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class POPSMO02_maidenhead_register_from_wallet {
	
	//Initiate driver
	WebDriver maidenhead_register_from_wallet_driver;
	
	//--------------------POPSMO02-----------------------
	//Given I am a user of Axate and I am on the registration page through maidenhead wallet homepages 	
	
	@Given("I am a user of Axate and I am on the registration page through maidenhead Wallet homepages {string}")
	@Test(priority=7)
	@Parameters("browser")
	public void i_am_a_user_of_Axate_and_I_am_on_the_registration_page_through_maidenhead_Wallet_homepages(String browser) throws InterruptedException {	
	//firefox
	if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver","C:/Users/Administrator/Desktop/geckodriver.exe");		
		maidenhead_register_from_wallet_driver = new FirefoxDriver();
		maidenhead_register_from_wallet_driver.get("http://maidenhead.agate.one");
		Popbitch_Logged_Out_Wallet w1= new Popbitch_Logged_Out_Wallet(maidenhead_register_from_wallet_driver);
		w1.Click_On_popbitch_agate_poster();
		w1.Click_On_popbitch_wallet_register_button();			
		WebDriverWait wait = new WebDriverWait(maidenhead_register_from_wallet_driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));	
		String reg_Page_url= maidenhead_register_from_wallet_driver.getCurrentUrl();
		if(reg_Page_url.contains("sign"))
		{
			System.out.println("Clicking on create wallet opened registration page");
		}			
	}	
	//safari
		else if (browser.equalsIgnoreCase("safari")) { 
			maidenhead_register_from_wallet_driver= new SafariDriver();
			maidenhead_register_from_wallet_driver.manage().window().maximize();
			maidenhead_register_from_wallet_driver.get("http://maidenhead.agate.one");
			Popbitch_Logged_Out_Wallet w1= new Popbitch_Logged_Out_Wallet(maidenhead_register_from_wallet_driver);
			w1.Click_On_popbitch_agate_poster();
			w1.Click_On_popbitch_wallet_register_button();			
			WebDriverWait wait = new WebDriverWait(maidenhead_register_from_wallet_driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));	
			String reg_Page_url= maidenhead_register_from_wallet_driver.getCurrentUrl();
			if(reg_Page_url.contains("sign"))
			{
				System.out.println("Clicking on create wallet opened registration page");
			}			
	} 
	//chrome
		else if (browser.equalsIgnoreCase("chrome")) { 
			System.setProperty("webdriver.chrome.driver","/Users/jay/eclipse-workspace/chromedriver");				
			maidenhead_register_from_wallet_driver= new ChromeDriver();				
			maidenhead_register_from_wallet_driver.get("http://staging.maidenhead-advertiser.co.uk");
			maidenhead_register_from_wallet_driver.findElement(By.linkText("Ok")).click();
			Popbitch_Logged_Out_Wallet w1= new Popbitch_Logged_Out_Wallet(maidenhead_register_from_wallet_driver);
			w1.Click_On_popbitch_agate_poster();
			w1.Click_On_popbitch_wallet_register_button();			
			WebDriverWait wait = new WebDriverWait(maidenhead_register_from_wallet_driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));	
			String reg_Page_url= maidenhead_register_from_wallet_driver.getCurrentUrl();
			if(reg_Page_url.contains("sign"))
			{
				System.out.println("Clicking on create wallet opened registration page");
			}			
	} 
	//edge
		else if (browser.equalsIgnoreCase("Edge")) {
		System.setProperty("webdriver.edge.driver","/Users/jay/eclipse-workspace/chromedriver"); 
		maidenhead_register_from_wallet_driver = new EdgeDriver();
	}				
		}
		
	//When I enter all the required details on step one and click on continue
	@When("I enter all the required details on step one and click on continue")
	@Test(priority=8)
	public void i_enter_all_the_required_details_on_step_one_and_click_on_continue() throws InterruptedException {
	 
		Register_Page_Elements1 Reg_page_elements = new Register_Page_Elements1(maidenhead_register_from_wallet_driver);
		Reg_page_elements.Registration_Step1();
		
	}

	
	//And top up with a valid card in steptwo with one pound and click on continue
	@When("top up with a valid card in steptwo with one pound and click on continue")
	@Test(priority=9)
	public void top_up_with_a_valid_card_in_steptwo_with_one_pound_and_click_on_continue() throws InterruptedException {
		Register_Page_Elements1 Reg_page_elements = new Register_Page_Elements1(maidenhead_register_from_wallet_driver);
			Reg_page_elements.Registration_Step2();
	}
	
	
	//Then I get a funded axate wallet with one pound in it
	@Then("I get a funded axate wallet with one pound in it")
	@Test(priority=10)
	public void i_get_a_funded_axate_wallet_with_one_pound_in_it() throws InterruptedException {
		
		Wallet_Elements w1 = new Wallet_Elements(maidenhead_register_from_wallet_driver);
		w1.Click_On_popbitch_staging_agate_poster();
		String actual_current_balance=w1.current_balance();
		String expected_current_balance="3.00";
		Assert.assertEquals(actual_current_balance, expected_current_balance);		
	}
	
	//And navigated to maidenhead.com
	@Then("navigated to maidenhead.com")
	@Test(priority=11)
	public void navigated_to_maidenhead_com() {
		String actual_url= maidenhead_register_from_wallet_driver.getCurrentUrl();
	    String expected_url = "http://staging.maidenhead-advertiser.co.uk/";
	    Assert.assertEquals(actual_url, expected_url);
	    maidenhead_register_from_wallet_driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    maidenhead_register_from_wallet_driver.quit();
	}

}*/