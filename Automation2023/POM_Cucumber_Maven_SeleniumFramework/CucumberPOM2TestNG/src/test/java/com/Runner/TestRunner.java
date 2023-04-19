package com.Runner;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\test\\resources\\parallel"},
		glue = {"parallel"},
		publish = true ,  //this will create one report at https://reports.cucumber.io/reports/ef9d05a0-b35d-4387-94e2-830740efb62a
		plugin = {"pretty"
					},
		dryRun = false,
		monochrome = true
		
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	//This code is required for parallel testing
	/*
	 * @Override
	 * 
	 * @DataProvider(parallel=true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */

}
