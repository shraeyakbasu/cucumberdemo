package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\shraeyakbasu\\git\\cucumberdemo\\cucumberdemo\\src\\main\\java\\feature\\tagcucumberdemo.feature"
		,glue = {"stepdefination"}
		,monochrome = true
		,strict = true //to check if all steps are defined in step defination file
		,dryRun = false
		,tags= {"@SmokeTest","@RegressionTest"} // "@tags","@tags"= or
		                                    // "@tags,@tags" = and
		
		
		)
public class tagcucumberdemo {

}
