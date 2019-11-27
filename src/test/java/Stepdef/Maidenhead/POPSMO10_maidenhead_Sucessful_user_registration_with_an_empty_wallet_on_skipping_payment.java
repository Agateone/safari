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

import Elements.Add_Funds_Notice;
import Elements.Popbitch_First_Use_Notice_Elements;
import Elements.Register_Page_Elements1;
import Elements.Wallet_Elements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class POPSMO10_maidenhead_Sucessful_user_registration_with_an_empty_wallet_on_skipping_payment{


WebDriver maidenhead_add_funds;
	
	@Given("I am a user of Axate and I am on the registration page through maidenhead FUN")
	@Test(priority=48)
	@Parameters("browser")
	public void i_am_a_user_of_Axate_and_I_am_on_the_registration_page_through_maidenhead_FUN(String browser) throws InterruptedException {
		
		System.out.println("Started executing - POPSMO10_maidenhead_Sucessful_user_registration_with_an_empty_wallet_on_skipping_payment");
		
		//firefox
		if(browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver","C:/Users/Administrator/Desktop/geckodriver.exe");	
			maidenhead_add_funds = new FirefoxDriver();
			maidenhead_add_funds.get("http://maidenhead.agate.one/2017/10/the-harder-they-fall-2/");
			Popbitch_First_Use_Notice_Elements maidenhead_first_use_elements= new Popbitch_First_Use_Notice_Elements(maidenhead_add_funds);
			maidenhead_first_use_elements.Click_On_Popbitch_First_Use_Notice_Create_Wallet();
			WebDriverWait wait = new WebDriverWait(maidenhead_add_funds, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));	
			String reg_Page_url= maidenhead_add_funds.getCurrentUrl();
			if(reg_Page_url.contains("sign"))
			{
				System.out.println("Clicking on create wallet opened registration page");
			}			
		}	
		//safari
			else if (browser.equalsIgnoreCase("safari")) { 
				maidenhead_add_funds= new SafariDriver();
				maidenhead_add_funds.manage().window().maximize();
				try {
					maidenhead_add_funds.get("http://maidenhead.agate.one/2017/10/the-harder-they-fall-2/");					
				}
				catch(Exception e)
				{
					System.out.println("Couldnt open maidenhead staging");
				}
				Popbitch_First_Use_Notice_Elements maidenhead_first_use_elements= new Popbitch_First_Use_Notice_Elements(maidenhead_add_funds);
				maidenhead_add_funds.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				maidenhead_first_use_elements.Click_On_Popbitch_First_Use_Notice_Create_Wallet();
				String reg_Page_url= maidenhead_add_funds.getCurrentUrl();
				if(reg_Page_url.contains("sign"))
				{
					System.out.println("Clicking on create wallet opened registration page");
				}
				maidenhead_add_funds.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		} 
		//chrome
			else if (browser.equalsIgnoreCase("chrome")) { 
				System.setProperty("webdriver.chrome.driver","/Users/jay/eclipse-workspace/chromedriver");				
				maidenhead_add_funds= new ChromeDriver();				
				maidenhead_add_funds.get("http://staging.maidenhead-advertiser.co.uk/news/remember-when/137862/remember-remember-when-the-ghosts-and-guys-of-november.html?refresh_ce");
				maidenhead_add_funds.findElement(By.linkText("Ok")).click();
				Thread.sleep(2000);
				Popbitch_First_Use_Notice_Elements maidenhead_first_use_elements= new Popbitch_First_Use_Notice_Elements(maidenhead_add_funds);
				maidenhead_first_use_elements.Click_On_Popbitch_First_Use_Notice_Create_Wallet();
				WebDriverWait wait = new WebDriverWait(maidenhead_add_funds, 20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));	
				String reg_Page_url= maidenhead_add_funds.getCurrentUrl();
				if(reg_Page_url.contains("https://account-qa.axate.io/my-agate/sign-up"))
				{
					System.out.println("Clicking on create wallet opened registration page");
				}
		} 
		//edge
			else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver","/Users/jay/eclipse-workspace/chromedriver"); 
			maidenhead_add_funds = new EdgeDriver();
		}	
	}
	
	@When("I enter all the required details on step one and click on continue")
	@Test(priority=49)
	public void i_enter_all_the_required_details_on_step_one_and_click_on_continue() throws InterruptedException {	 
		Register_Page_Elements1 Reg_page_elements = new Register_Page_Elements1(maidenhead_add_funds);
		Reg_page_elements.Registration_Step1();
		System.out.println("registered with a random email");
		
	}		

	@When("I skip the payment and navigating to a premium article on maidenhead")
	@Test(priority=50)
	public void i_skip_the_payment_and_navigating_to_a_premium_article_on_maidenhead() {
		WebDriverWait wait = new WebDriverWait(maidenhead_add_funds, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("braintree-option__label")));
		maidenhead_add_funds.get("http://staging.maidenhead-advertiser.co.uk/news/remember-when/137862/remember-remember-when-the-ghosts-and-guys-of-november.html?refresh_ce");
		String reg_Page_url= maidenhead_add_funds.getCurrentUrl();
		if(reg_Page_url.contains("http://staging.maidenhead-advertiser.co.uk/news/remember-when/137862/remember-remember"))
		{
			System.out.println("skipped payment and navigated to URL");
		}
		
	}

	@Then("I get an unfunded axate wallet with zero pounds in it")
	@Test(priority=51)
	public void i_get_an_unfunded_axate_wallet_with_zero_pounds_in_it() throws InterruptedException {
		Wallet_Elements w1 = new Wallet_Elements(maidenhead_add_funds);
		w1.Click_On_popbitch_staging_agate_poster();
		String actual_current_balance=w1.current_balance();
		String expected_current_balance="0.00";
		Assert.assertEquals(actual_current_balance, expected_current_balance);
		System.out.println("Wallet topped up with 0.00 pounds");
	}

	@Then("an ADD funds notice is displayed")
	@Test(priority=52)
	public void an_ADD_funds_notice_is_displayed() {
		Add_Funds_Notice add1= new Add_Funds_Notice(maidenhead_add_funds);
		Boolean Actual = add1.Add_funds_notice_displayed();
		Boolean expected= true;
		Assert.assertEquals(Actual, expected);
		System.out.println("Add funds notice displayed");
		maidenhead_add_funds.quit();
}
}
*/