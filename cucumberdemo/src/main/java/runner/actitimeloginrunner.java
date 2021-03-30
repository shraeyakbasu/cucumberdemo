package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "D:\\cucumberautomation\\cucumberdemo\\src\\main\\java\\feature\\login.feature"
		,glue = {"stepdefination"}
		,monochrome = true
		,strict = true //to check if all steps are defined in step defination file
		,dryRun = false //to check if mapping is proper between feature file and step defination file
		
		)

	

public class actitimeloginrunner
{
	

}
