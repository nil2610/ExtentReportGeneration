package com.stepdefinations;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.listeners.ExtentReportListener;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class samplestepdefination1 extends ExtentReportListener{
	
	static ExtentTest mExtentTest;
	static{
		mExtentTest = extent.createTest(Feature.class, "This is feature one file");
	}
	private String scenarioName;
	
	@Before
	public void beforeHook(cucumber.api.Scenario scenario) {
		scenarioName = scenario.getName();
	}
	
	@Given("^This is precondition steps$")
	public void this_is_precondition_steps() throws Throwable {
		test = mExtentTest.createNode(Scenario.class, scenarioName);
		test.createNode(new GherkinKeyword("Given"), "this_is_precondition_steps");
		System.out.println("This is preconditions steps");
	}

	@Then("^first step$")
	public void first_step() throws Throwable {
		
		test.createNode(new GherkinKeyword("Then"), "first_step");
		System.out.println("First Step");
	}

	@Then("^sencond step$")
	public void sencond_step() throws Throwable {
		test.createNode(new GherkinKeyword("Then"), "sencond_step");
		System.out.println("Second Step");
	}

	@Then("^third step$")
	public void third_step() throws Throwable {
		test.createNode(new GherkinKeyword("Then"), "third_step");
		System.out.println("Third Step");
	}

	@Then("^third step change$")
	public void third_step_change() throws Throwable {
		test.createNode(new GherkinKeyword("Then"), "third_step_change");
		System.out.println("Third Step Change");
	}
	
	@Then("^third step change2$")
	public void third_step_change2() throws Throwable {
		test.createNode(new GherkinKeyword("Then"), "third_step_change2");
		System.out.println("Third Step Change2");
	}

}
