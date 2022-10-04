package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = (".\\src\\test\\java\\features\\createorganization.feature"),
	glue = ("stepdefinations"),
	dryRun = false,
	monochrome=true,
	plugin = {
			"pretty",
			"html:ReadyCucumber.html",
			"json:ReadyCucumber.json"
	}
		
	
)

public class Runner extends AbstractTestNGCucumberTests {
	

}
