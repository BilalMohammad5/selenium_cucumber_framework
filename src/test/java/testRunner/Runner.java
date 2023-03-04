package testRunner;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(

		features="src/test/java/features",
		glue= {"step_definitions","hooks"},
		tags = "",
		plugin = { "pretty","html:reports/cucumber_test_reports.html"} //json, can also be added here
)

public class Runner extends AbstractTestNGCucumberTests{

	
	//converting junit runner file to test NG using cucumber - test NG plugin	
	
}
 