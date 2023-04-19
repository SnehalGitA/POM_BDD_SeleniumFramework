package com.Runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\test\\resources\\com\\feature"},
		glue = {"com.StepDef","com.AppHooks"},
//		tags = "@All",
		publish = true ,  //this will create one report at https://reports.cucumber.io/reports/ef9d05a0-b35d-4387-94e2-830740efb62a
		plugin = {"pretty",
					"json:target/JsonReport/report.json",
					"junit:target/JUnitReport/report.xml",
					"timeline:test-output-thread/"
					},
		dryRun = false,
		monochrome = true
		
		)
public class TestRunner {
	

}
