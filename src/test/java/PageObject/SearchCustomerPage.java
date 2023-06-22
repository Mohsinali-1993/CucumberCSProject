package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	public WebDriver ldriver;

	public SearchCustomerPage(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	@FindBy(id="SearchEmail")
	WebElement emailAdd;

	@FindBy(id="search-customers")
	WebElement searchBtn;
	@FindBy(xpath="//div[@class='dataTables_scrollHead']")
	WebElement searchResult;
	@FindBy(id="SearchFirstName")
	WebElement firstName;

	@FindBy(id="SearchLastName")
	WebElement lastName;

	@FindBy(xpath="//div[@id='customers-grid_wrapper']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(xpath="//div[@id='customers-grid_wrapper']//tbody/tr[1]/td")
	List<WebElement> tableColumns;

	public void enterEmailAdd(String email ) {
		emailAdd.sendKeys(email);
	}
	public void clickOnSearchButton() {
		searchBtn.click();
	}
///////search customer by emAIL/////////////
	public boolean searchCustomerByEmail(String email) {
		boolean found=false;
		//total no. of rows in grid
		int ttlRows=tableRows.size();
		//total no. of columns in grid
		//	int ttlColumns=tableColumns.size();
		for(int i=1;i<=ttlRows;i++) //to iterate all the rows of the grid
		{
			WebElement webElementEmail=ldriver.findElement(By.xpath("//div[@id='customers-grid_wrapper']//tbody/tr["+i+"]/td[2]"));	
			String actualEmailAdd=webElementEmail.getText();
			if(actualEmailAdd.equals(email)) {
				found=true;
			}

		}
		return found;
	}
	///////search customer by name/////////////
	public void enterFirstName(String firstNameText) {
		firstName.sendKeys(firstNameText);
	}
	public void enterLastName(String LastNameText) {
		lastName.sendKeys(LastNameText);
	}
	public boolean searchCustomerByName(String name) {
		boolean found=false;
		//total no. of rows in grid
		int ttlRows=tableRows.size();

		for(int i=1;i<=ttlRows;i++) //to iterate all the rows of the grid
		{
			WebElement webElementName=ldriver.findElement(By.xpath("//div[@id='customers-grid_wrapper']//tbody/tr["+i+"]/td[3]"));	
			String actualName=webElementName.getText();
			if(actualName.equals(name)) {
				found=true;
				break;
			}

		}
		return found;
	}
}
