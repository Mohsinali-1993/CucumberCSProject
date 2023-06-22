package StepDefinition;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass{

	@Before("@Sanity")
	public void setup1() {
		readconfig=new ReadConfig();
		
		System.out.println("setup sanity method executed");
		String browser=readconfig.getBrowser();
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@Before("@Regression")
	public void setup2() {
		System.out.println("setup2 regression method executed");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		loginPg=new LoginPage(driver);
		addNewCustPg=new AddNewCustomerPage(driver);
		SearchCustPg=new SearchCustomerPage(driver);
	}

	@When("User Opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String password) {
		loginPg.enterEmail(emailAdd);
		loginPg.enterPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
		loginPg.clickOnLoginButton();
	}
	///////////login feature/////////////////////////////////////////
	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);//pass
		}
		else {
			Assert.assertTrue(false);//fail
		}
	}

	@When("User click on Log out Link")
	public void user_click_on_log_out_link() {
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPg.clickOnLogOutButton();
		
	}




	/////add new customer////////////////////////////
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle=addNewCustPg.getPageTitle();
		String expectedTitle="Dashboard / nopCommerce administration";
		if(actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

	@When("User clicks on customer menu")
	public void user_clicks_on_customer_menu()  {
		addNewCustPg.clickOnCustomerMenu();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("Click on customer menu item")
	public void click_on_customer_menu_item() {
		addNewCustPg.clickOnCustomerMenuItem();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("Click on add new button")
	public void click_on_add_new_button() {
		addNewCustPg.clickOnAddNew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle=addNewCustPg.getPageTitle();
		String expectedTitle="Add a new customer / nopCommerce administration";
		if(actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

	@When("User enters customer info")
	public void user_enters_customer_info() {
		//addNewCustPg.enterEmail("fhgjk@gmail.com");
		addNewCustPg.enterEmail(generateEmailId()+"@gmail.com");
		addNewCustPg.enterPassword("test1");
		addNewCustPg.enterFirstName("prahi");
		addNewCustPg.enterLastName("gupta");
		addNewCustPg.enterGender("female");
		addNewCustPg.enterDob("8/13/2022");
		addNewCustPg.enterCompanyName("codestudio");
		addNewCustPg.enterAdminContent("Admin content");
		addNewCustPg.enterManagerOfVendor("Vendor 1");
	}

	@When("click on save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
		String bodyTagText=driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(expectedConfirmationMsg)) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	///////search customer/////////////////////
	@When("Enter customer Email")
	public void enter_customer_email() {
		SearchCustPg.enterEmailAdd("victoria_victoria@nopCommerce.com");
	}

	@When("click on search button")
	public void click_on_search_button() {
		SearchCustPg.clickOnSearchButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail="victoria_victoria@nopCommerce.com";
		Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail));//same in one line
		/*if(   SearchCustPg.searchCustomerByEmail(expectedEmail)==true) {
		Assert.assertTrue(true);
	}
	else {
		Assert.assertTrue(false);
	}*/
	}
	//////////////////search customer by name/////////////////
	@When("enter customer Firstname")
	public void enter_customer_firstname() {
		SearchCustPg.enterFirstName("Victoria");
	}

	@When("enter customer Lastname")
	public void enter_customer_lastname() {
		SearchCustPg.enterLastName("Terces");
	}


	@Then("User should find name in search table")
	public void user_should_find_name_in_search_table() {
		String expectedName="Victoria Terces";

		if(   SearchCustPg.searchCustomerByName(expectedName)==true) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	/*@After
	public void teardown(Scenario sc) {
		System.out.println("tear down method executed");
		if(sc.isFailed()==true)
		{
			//Convert web driver object to TakeScreenshot

			String fileWithPath = "D:\\Selenium\\CucumberCodeStudio\\screenshot\\failedScreenshot1.png";
			TakesScreenshot scrShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination
			File DestFile=new File(fileWithPath);

			//Copy file at destination

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.quit();
	}*/
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
		final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot,"image/png",scenario.getName());
	}}
	
	/*@After
	public void teardown2() {
		System.out.println("tear down method executed");
		driver.quit();
	}*/
	
	/*@BeforeStep
	public void beforestepMethodDemo() {
		System.out.println("This is before step");
	}
	@AfterStep
	public void afterstepMethodDemo() {
		System.out.println("This is after step");
	}*/
}







