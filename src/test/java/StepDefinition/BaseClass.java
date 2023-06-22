package StepDefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

public class BaseClass {
	public static WebDriver driver;
	public LoginPage loginPg;
	public SearchCustomerPage SearchCustPg;
	public AddNewCustomerPage addNewCustPg;
	public ReadConfig readconfig;
	
	public String generateEmailId() {
  		return (RandomStringUtils.randomAlphabetic(5));
	}

}
