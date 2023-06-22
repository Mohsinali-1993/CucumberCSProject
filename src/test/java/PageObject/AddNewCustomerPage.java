package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {
	 public WebDriver ldriver;

	public AddNewCustomerPage(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(ldriver, this);
	}
	//find web elements on the web page
	@FindBy(xpath="(//a[@href='#' ])[7]")
	WebElement lnkCustomers_menu;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),' Customers')]")
	WebElement lnkCustomers_menuitem;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btnAddnew;
	@FindBy(id="Email")
	WebElement txtEmail;
	@FindBy(id="Password")
	WebElement txtPassword;
	
	@FindBy(xpath="(//div[@class='k-multiselect-wrap k-floatwrap'])[2]")
	WebElement txtCustomerRoles;
	
	@FindBy(xpath="//li[text()='Administrators']")
	WebElement listItemAdministrators;
	
	@FindBy(xpath="//li[text()='Registered']")
	WebElement listItemRegistered;
	
	@FindBy(xpath="//li[text()='Guests']")
	WebElement listItemGuests;
	
	@FindBy(xpath="//li[text()='Vendors']")
	WebElement listItemVendors;

	@FindBy(xpath = "//*[@id='VendorId']")
	WebElement dropdownVendorMgr;

	@FindBy(id="Gender_Male")
	WebElement MaleGender;
	
	@FindBy(id="Gender_Female")
	WebElement FemaleGender;
	
	@FindBy(id="FirstName")
	WebElement txtFirstName;
	
	@FindBy(id="LastName")
	WebElement txtLastName;
	@FindBy(id="DateOfBirth")
	WebElement txtDob;
	
	@FindBy(id="Company")
	WebElement txtCompanyName;
	
	@FindBy(xpath="//textarea[@id='AdminComment']")
	WebElement txtAdminContent;
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btnAddNew;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement btnSave;
	////Action method for web element///////////////////////////////////
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	public void clickOnCustomerMenu() {
		lnkCustomers_menu.click();
	}
	public void clickOnCustomerMenuItem() {
		lnkCustomers_menuitem.click();
	}
	public void clickOnAddNew() {
		btnAddNew.click();
	}
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void enterFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}

	public void enterDob(String dob)
	{
		txtDob.sendKeys(dob);
	}
	public void enterCompanyName(String coName)
	{
		txtCompanyName.sendKeys(coName);
	}

	public void enterAdminContent(String content)
	{
		txtAdminContent.sendKeys(content);
	}

	/*public void enterCustomerRoles(String role)  
	{

	}*/

	public void enterManagerOfVendor(String value)
	{
		Select drp=new Select(dropdownVendorMgr);
		drp.selectByVisibleText(value);
	}

	public void enterGender(String gender)
	{
		if(gender.equals("Male"))
		{
			MaleGender.click();
		}
		else if(gender.equals("Female"))
		{
			FemaleGender.click();
		}
		else//default set Male gender
		{
			MaleGender.click();
		}

	}

	

	public void clickOnSave()
	{
		btnSave.click();
	}
	
	
	

}
