package com.runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.gherkin.model.Feature;
import com.listeners.ExtentReportListener;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(
		features={"src/test/resources/com/features"},
		glue={"com.stepdefinations"},
		plugin={"pretty", "json:target/cucumber.json",
				"html:target/cucumber-html-report"},
		monochrome = true
		)

public class runner{

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeSuite
	public void setUp(){
		ExtentReportListener.setUp();
	}

	@AfterSuite
	public void tearDown(){
		ExtentReportListener.extent.flush();
	}

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}



}