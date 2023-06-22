package StepDefinition;

import io.cucumber.java.en.Then;

public class CloseStep extends BaseClass{

	@Then("Close Browser")
	public void close_browser() {
		driver.close();
		//	driver.quit();

	}

}
