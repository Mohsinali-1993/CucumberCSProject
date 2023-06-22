package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		//features=".//Features/customers.feature",//to execute single feature file
		//features=".//Features/",//to execute all feature file we will give folder name
		features={".//Features/LoginFeature.feature",".//Features/customers.feature"},//to run specific feature file
		//same is for step definition file also
		glue="StepDefinition",dryRun=false,
		monochrome=true,
		tags="@Sanity",//scenarios under sanity test will execute
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		//plugin= {"pretty","html:taget/cucumber-reports/reportsall_html.html"}
		//plugin= {"pretty","html:taget/cucumber-reports/reports1.html"}
		//plugin= {"pretty","json:taget/cucumber-reports/reports_json.json"}
		)
public class Run extends AbstractTestNGCucumberTests{
//this class will be empty
}
