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
import Elements.Account_Page;
import Elements.Popbitch_First_Use_Notice_Elements;
import Elements.Register_Page_Elements1;
import Elements.Wallet_Elements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class POPSMO13_maidenhead_User_Registers_with_Country_As_US {
WebDriver driver;
	@Given("I am a user of Axate and I am on the registration page through maidenhead FUN")
	@Test(priority=66)
	@Parameters("browser")
	public void i_am_a_user_of_Axate_and_I_am_on_the_registration_page_through_maidenhead_FUN(String browser) throws InterruptedException {
		
		System.out.println("Started executing - POPSMO10_maidenhead_Sucessful_user_registration_with_an_empty_wallet_on_skipping_payment");
		
		//firefox
		if(browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver","C:/Users/Administrator/Desktop/geckodriver.exe");	
			driver = new FirefoxDriver();
			driver.get("http://maidenhead.agate.one/2017/10/the-harder-they-fall-2/");
			Popbitch_First_Use_Notice_Elements maidenhead_first_use_elements= new Popbitch_First_Use_Notice_Elements(driver);
			maidenhead_first_use_elements.Click_On_Popbitch_First_Use_Notice_Create_Wallet();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));	
			String reg_Page_url= driver.getCurrentUrl();
			if(reg_Page_url.contains("sign"))
			{
				System.out.println("Clicking on create wallet opened registration page");
			}			
		}	
		//safari
			else if (browser.equalsIgnoreCase("safari")) { 
				driver= new SafariDriver();
				driver.manage().window().maximize();
				try {
					driver.get("http://maidenhead.agate.one/2017/10/the-harder-they-fall-2/");					
				}
				catch(Exception e)
				{
					System.out.println("Couldnt open maidenhead staging");
				}
				Popbitch_First_Use_Notice_Elements maidenhead_first_use_elements= new Popbitch_First_Use_Notice_Elements(driver);
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				maidenhead_first_use_elements.Click_On_Popbitch_First_Use_Notice_Create_Wallet();
				String reg_Page_url= driver.getCurrentUrl();
				if(reg_Page_url.contains("sign"))
				{
					System.out.println("Clicking on create wallet opened registration page");
				}
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		} 
		//chrome
			else if (browser.equalsIgnoreCase("chrome")) { 
				System.setProperty("webdriver.chrome.driver","/Users/jay/eclipse-workspace/chromedriver");				
				driver= new ChromeDriver();				
				driver.get("http://staging.maidenhead-advertiser.co.uk/news/remember-when/137862/remember-remember-when-the-ghosts-and-guys-of-november.html?refresh_ce");
				driver.findElement(By.linkText("Ok")).click();
				Popbitch_First_Use_Notice_Elements maidenhead_first_use_elements= new Popbitch_First_Use_Notice_Elements(driver);
				maidenhead_first_use_elements.Click_On_Popbitch_First_Use_Notice_Create_Wallet();
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));	
				String reg_Page_url= driver.getCurrentUrl();
				if(reg_Page_url.contains("https://account-qa.axate.io/my-agate/sign-up"))
				{
					System.out.println("Clicking on create wallet opened registration page");
				}
		} 
		//edge
			else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver","/Users/jay/eclipse-workspace/chromedriver"); 
			driver = new EdgeDriver();
		}	
	}	
	
	

	@When("I enter all the required details on step one and click on continue")
	@Test(priority=67)
	public void i_enter_all_the_required_details_on_step_one_and_click_on_continue() throws InterruptedException {	 
		Register_Page_Elements1 Reg_page_elements = new Register_Page_Elements1(driver);
		Reg_page_elements.Registration_Step1();
		System.out.println("registered with a random email");
		
	}		
	
	@When("I click on one pound on regpage two")
	@Test(priority=68)
	public void i_click_on_one_pound_on_regpage_two() {
		System.out.println("clicked on one pound on reg page 2");  
	}
	
	@When("enter valid card details")
	@Test(priority=69)
	public void enter_valid_card_details() throws InterruptedException {
		
		Register_Page_Elements1 Reg_page_elements = new Register_Page_Elements1(driver);
		Reg_page_elements.Registration_Step2_without_continue();
		System.out.println("Entered valid card details");

	}
	
	@When("I select country as United states from the drop down on reg page two")
	@Test(priority=70)
	public void i_select_country_as_United_states_from_the_drop_down_on_reg_page_two() throws InterruptedException {
		Register_Page_Elements1 Reg_page_elements = new Register_Page_Elements1(driver);
		Reg_page_elements.select_country_US();
		Reg_page_elements.click_continue_on_reg_page2();
		System.out.println("US is selected as the country");
	}
	
	
	
	@When("I enter state as Alaska")
	@Test(priority=71)
	public void i_enter_state_as_Alaska() throws InterruptedException {
		Register_Page_Elements1 Reg_page_elements = new Register_Page_Elements1(driver);
		Reg_page_elements.select_state_Alaska();		
		System.out.println("Alaska is selected as the country"); 
	}

	@When("I enter Zipcode")
	@Test(priority=72)
	public void i_enter_Zipcode() throws InterruptedException {
		Register_Page_Elements1 Reg_page_elements = new Register_Page_Elements1(driver);
		Reg_page_elements.enter_zipcode_for_alaska();		
		System.out.println("ZIPCODE entered for alaska"); 
		Reg_page_elements.click_continue_on_reg_page2();
		System.out.println("Registered with US as country");
	}

	@Then("Country in the personal information page in the account page is united states")
	@Test(priority=73)
	public void country_in_the_personal_information_page_in_the_account_page_is_united_states() {
		Wallet_Elements w1 = new Wallet_Elements(driver);
		w1.Click_On_popbitch_staging_agate_poster();
		w1.flip_wallet();
		w1.click_on_account();
		Account_Page acc = new Account_Page(driver);
		acc.Click_on_profile();
		acc.Click_on_personal_information();
		String Country= acc.get_country();
		String expected_country= "United States";
		Assert.assertEquals(expected_country, Country);
		System.out.println("Country selected is "+ Country);
	}
}