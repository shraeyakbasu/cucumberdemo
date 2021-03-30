package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "D:\\cucumberautomation\\cucumberdemo\\src\\main\\java\\feature\\actitimecreatecustomer.feature"
		,glue = {"stepdefination"}
		,monochrome = true
		,strict = true
		,dryRun = false)


public class actitimecreatecustomerrunner 
{

}
