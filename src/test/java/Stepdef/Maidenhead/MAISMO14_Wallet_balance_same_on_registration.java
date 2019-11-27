/*package Stepdef.Maidenhead;

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

import Elements.Popbitch_First_Use_Notice_Elements;
import Elements.Register_Page_Elements1;
import Elements.Wallet_Elements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MAISMO14_Wallet_balance_same_on_registration {
	WebDriver driver;
	
	String maidenhead_wallet_balance;
	String slough_wallet_balance;
	String windsor_wallet_balance;
	
	@Given("I am a user of Axate and I am on the registration page through popbitch FUN {string}")
	@Test(priority=74)
	@Parameters("browser")
	public void i_am_a_user_of_Axate_and_I_am_on_the_registration_page_through_popbitch_FUN(String browser) throws InterruptedException {
		//firefox
				if(browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver","C:/Users/Administrator/Desktop/geckodriver.exe");		
					driver = new FirefoxDriver();
					driver.get("http://staging.maidenhead-advertiser.co.uk/news/remember-when/137862/remember-remember-when-the-ghosts-and-guys-of-november.html");
					Popbitch_First_Use_Notice_Elements maidenhead_first_use_elements= new Popbitch_First_Use_Notice_Elements(driver);
					maidenhead_first_use_elements.Click_On_Popbitch_First_Use_Notice_Create_Wallet();
					WebDriverWait wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));	
					String reg_Page_url= driver.getCurrentUrl();
					if(reg_Page_url.contains("https://account-staging.agate.io/my-agate/sign-up?mp=333768&pub_id=mad&publication_name=Maidenhead%20Advertiser%20Staging&url_from=http%3A%2F%2Fstaging.maidenhead-advertiser.co.uk%2Fnews%2Fremember-when%2F137862%2Fremember-remember-when-the-ghosts-and-guys-of-november.html"))
					{
						System.out.println("Clicking on create wallet opened registration page");
					}			
				}	
				//safari
					else if (browser.equalsIgnoreCase("safari")) { 
						driver= new SafariDriver();
						driver.manage().window().maximize();
						try {
							driver.get("http://staging.maidenhead-advertiser.co.uk/news/remember-when/137862/remember-remember-when-the-ghosts-and-guys-of-november.html");					
						}
						catch(Exception e)
						{
							System.out.println("Couldnt open maidenhead staging");
						}
						Popbitch_First_Use_Notice_Elements maidenhead_first_use_elements= new Popbitch_First_Use_Notice_Elements(driver);
						maidenhead_first_use_elements.Click_On_Popbitch_First_Use_Notice_Create_Wallet();
						String reg_Page_url= driver.getCurrentUrl();
						if(reg_Page_url.contains("sign"))
						{
							System.out.println("Clicking on create wallet opened registration page");
						}
				} 
				//chrome
					else if (browser.equalsIgnoreCase("chrome")) { 
						System.setProperty("webdriver.chrome.driver","/Users/jay/eclipse-workspace/chromedriver");				
						driver= new ChromeDriver();				
						driver.get("http://staging.maidenhead-advertiser.co.uk/news/remember-when/137862/remember-remember-when-the-ghosts-and-guys-of-november.html");
						driver.findElement(By.linkText("Ok")).click();
						Popbitch_First_Use_Notice_Elements maidenhead_first_use_elements= new Popbitch_First_Use_Notice_Elements(driver);
						maidenhead_first_use_elements.Click_On_Popbitch_First_Use_Notice_Create_Wallet();
						WebDriverWait wait = new WebDriverWait(driver, 20);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));	
						String reg_Page_url= driver.getCurrentUrl();
						if(reg_Page_url.contains("https://account-staging.agate.io/my-agate/sign-up?mp=333768&pub_id=mad&publication_name=Maidenhead%20Advertiser%20Staging&url_from=http%3A%2F%2Fstaging.maidenhead-advertiser.co.uk%2Fnews%2Fremember-when%2F137862%2Fremember-remember-when-the-ghosts-and-guys-of-november.html"))
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

	@When("I register successfully on popbitch with three pound")
	@Test(priority=75)
	public void i_register_successfully_on_popbitch_with_three_pound() throws InterruptedException {
		Register_Page_Elements1 Reg_page_elements = new Register_Page_Elements1(driver);
		Reg_page_elements.Registration_Step1();
		Register_Page_Elements1 Reg_page_elements1 = new Register_Page_Elements1(driver);
		Reg_page_elements1.Registration_Step2_without_continue();
		System.out.println("Entered valid card details");
		Reg_page_elements.click_continue_on_reg_page2();
	}

	@When("I check in wallet balance on Maidenhead")
	@Test(priority=76)
	public void i_check_in_wallet_balance_on_Maidenhead() throws InterruptedException {
		Wallet_Elements w1 = new Wallet_Elements(driver);
		w1.Click_On_popbitch_staging_agate_poster();
		maidenhead_wallet_balance=w1.current_balance();
		
	}

	@When("I navigate to slough")
	@Test(priority=77)
	public void i_navigate_to_slough() {
	 driver.get("http://staging.sloughexpress.co.uk/news/remember-when/137862/remember-remember-when-the-ghosts-and-guys-of-november.html");	
	}

	@When("I check in wallet balance on slough")
	@Test(priority=78)
	public void i_check_in_wallet_balance_on_slough() throws InterruptedException {
		Wallet_Elements w1 = new Wallet_Elements(driver);
		w1.Click_On_popbitch_staging_agate_poster();
		slough_wallet_balance=w1.current_balance();
	}

	@When("I navigate to windsor")
	@Test(priority=79)
	public void i_navigate_to_windsor() {
	   driver.get("http://staging.windsorexpress.co.uk/news/remember-when/137862/remember-remember-when-the-ghosts-and-guys-of-november.html");
	}

	@When("I check in wallet balance on windsor")
	@Test(priority=80)
	public void i_check_in_wallet_balance_on_windsor() throws InterruptedException {
		Wallet_Elements w1 = new Wallet_Elements(driver);
		w1.Click_On_popbitch_staging_agate_poster();
		windsor_wallet_balance=w1.current_balance();
	}

	@Then("the wallet balance is same across the publications")
	@Test(priority=81)
	public void the_wallet_balance_is_same_across_the_publications() {
	    String expected_balance= "3.00";
		Assert.assertEquals(maidenhead_wallet_balance, expected_balance);
		Assert.assertEquals(slough_wallet_balance, expected_balance);
		Assert.assertEquals(windsor_wallet_balance, expected_balance);
	
	}






}
*/