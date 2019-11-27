/*package Stepdef.Maidenhead;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Elements.Finish_Notice_elements;
import Elements.Login_Page_Elements;
import Elements.Popbitch_First_Use_Notice_Elements;
import Elements.Register_Page_Elements1;
import Elements.Wallet_Elements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class POPSMO03_maidenhead_register_from_login_page {
	//Initiate driver
	WebDriver maidenhead_Signup_Page_driver;	
	
	//--------------------POPSMO01-----------------------
	//Given I am a user of Axate and I am on the login page through maidenhead FUN 
	@Given("I am a user of Axate and I am on the login page through maidenhead FUN")
	@Test(priority=12)
	@Parameters("browser")
	public void i_am_a_user_of_Axate_and_I_am_on_the_login_page_through_maidenhead_FUN(String browser) throws InterruptedException {
		//firefox
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:/Users/Administrator/Desktop/geckodriver.exe");		
			maidenhead_Signup_Page_driver = new FirefoxDriver();
			maidenhead_Signup_Page_driver.get("http://maidenhead.agate.one/2017/10/the-harder-they-fall-2/");
			WebDriverWait wait = new WebDriverWait(maidenhead_Signup_Page_driver, 20);
			Popbitch_First_Use_Notice_Elements maidenhead_first_use_elements= new Popbitch_First_Use_Notice_Elements(maidenhead_Signup_Page_driver);
			maidenhead_first_use_elements.Click_On_Popbitch_First_Use_Notice_Login();
			WebElement register= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Not registered? Register now!")));	
			Boolean login_page_displayed= register.isDisplayed();
			if(login_page_displayed==true)
			{
				System.out.println("Clicking on Login from FUN opened Login page");
			}
		}	
		//safari
			else if (browser.equalsIgnoreCase("safari")) { 
				maidenhead_Signup_Page_driver= new SafariDriver();
				maidenhead_Signup_Page_driver.manage().window().maximize();
				try {
					maidenhead_Signup_Page_driver.get("http://maidenhead.agate.one/2017/10/the-harder-they-fall-2/");					
				}
				catch(Exception e)
				{
					System.out.println("Couldnt open maidenhead staging");
				}
				Popbitch_First_Use_Notice_Elements maidenhead_first_use_elements= new Popbitch_First_Use_Notice_Elements(maidenhead_Signup_Page_driver);
				maidenhead_first_use_elements.Click_On_Popbitch_First_Use_Notice_Create_Wallet();
				String reg_Page_url= maidenhead_Signup_Page_driver.getCurrentUrl();
				if(reg_Page_url.contains("sign"))
				{
					System.out.println("Clicking on create wallet opened registration page");
				}
		} 
		//chrome
			else if (browser.equalsIgnoreCase("chrome")) { 
				System.setProperty("webdriver.chrome.driver","/Users/jay/eclipse-workspace/chromedriver");				
				maidenhead_Signup_Page_driver= new ChromeDriver();				
				maidenhead_Signup_Page_driver.get("http://staging.maidenhead-advertiser.co.uk/news/remember-when/137862/remember-remember-when-the-ghosts-and-guys-of-november.html");
				maidenhead_Signup_Page_driver.findElement(By.linkText("Ok")).click();
				Thread.sleep(2000);
				WebDriverWait wait = new WebDriverWait(maidenhead_Signup_Page_driver, 20);
				Popbitch_First_Use_Notice_Elements maidenhead_first_use_elements= new Popbitch_First_Use_Notice_Elements(maidenhead_Signup_Page_driver);
				maidenhead_first_use_elements.Click_On_Popbitch_First_Use_Notice_Login();
				WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Not registered? Register now!")));	
				Boolean login_page_displayed= login.isDisplayed();
				if(login_page_displayed==true)
				{
					System.out.println("Clicking on Login from FUN opened Login page");
				}
		} 
		//edge
			else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver","/Users/jay/eclipse-workspace/chromedriver"); 
			maidenhead_Signup_Page_driver = new EdgeDriver();
		}	
	}

	
	
	@When("I click on register here on the login page")
	@Test(priority=13)
	public void I_click_on_register_here_on_the_login_page() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(maidenhead_Signup_Page_driver, 20);
		Login_Page_Elements login_page = new Login_Page_Elements(maidenhead_Signup_Page_driver);
		login_page.Click_On_Register_From_Login_Page();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));	
		String reg_Page_url= maidenhead_Signup_Page_driver.getCurrentUrl();
		if(reg_Page_url.contains("sign"))
		{
			System.out.println("Clicking on create wallet opened registration page");
		}		
		
	}
	
	@When("I enter all the required details on step one and click on continue")
	@Test(priority=14)
	public void i_enter_all_the_required_details_on_step_one_and_click_on_continue() throws InterruptedException {
	 
		Register_Page_Elements1 Reg_page_elements = new Register_Page_Elements1(maidenhead_Signup_Page_driver);
		Reg_page_elements.Registration_Step1();
		
	}

	
	@When("top up with a valid card in steptwo with one pound and click on continue")
	@Test(priority=15)
	public void top_up_with_a_valid_card_in_steptwo_with_one_pound_and_click_on_continue() throws InterruptedException {
		Register_Page_Elements1 Reg_page_elements = new Register_Page_Elements1(maidenhead_Signup_Page_driver);
			Reg_page_elements.Registration_Step2();
	}
	
	
	@Then("I get a funded axate wallet with one pound in it")
	@Test(priority=16)
	public void i_get_a_funded_axate_wallet_with_one_pound_in_it() throws InterruptedException {
		
		Wallet_Elements w1 = new Wallet_Elements(maidenhead_Signup_Page_driver);
		w1.Click_On_popbitch_staging_agate_poster();
		String actual_current_balance=w1.current_balance();
		String expected_current_balance="3.00";
		Assert.assertEquals(actual_current_balance, expected_current_balance);		
	}

	
	@Then("navigated to the same article")
	@Test(priority=17)
	public void navigated_to_the_same_article() {
	    String actual_url= maidenhead_Signup_Page_driver.getCurrentUrl();
	    String expected_url = "http://staging.maidenhead-advertiser.co.uk/news/remember-when/137862/remember-remember-when-the-ghosts-and-guys-of-november.html";
	    Assert.assertEquals(actual_url, expected_url);	
	}
	
	
	@Then("finish notice appears")
	@Test(priority=18)
	public void finish_notice_appears() throws InterruptedException {
		Finish_Notice_elements finish_notice = new Finish_Notice_elements(maidenhead_Signup_Page_driver);
		Boolean Actual_result = finish_notice.Verify_finish_notice_appears();
		Boolean Expected_result= true;
		Assert.assertEquals(Actual_result, Expected_result);
		maidenhead_Signup_Page_driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}
	
}
*/