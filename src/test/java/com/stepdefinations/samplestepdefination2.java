package com.stepdefinations;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.listeners.ExtentReportListener;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class samplestepdefination2 extends ExtentReportListener{
	
	static ExtentTest mExtentTest;
	static{
		mExtentTest = extent.createTest(Feature.class, "This is feature two file");
	}
	private String scenarioName;
	
	@Before
	public void beforeHook(cucumber.api.Scenario scenario) {
		scenarioName = scenario.getName();
	}
	
	@Given("^This is precondition steps1$")
	public void this_is_precondition_steps() throws Throwable {
		test = mExtentTest.createNode(Scenario.class, scenarioName);
		test.createNode(new GherkinKeyword("Given"), "this_is_precondition_steps1");
		System.out.println("This is preconditions steps");
	}

	@Then("^first step1$")
	public void first_step() throws Throwable {
		
		test.createNode(new GherkinKeyword("Then"), "first_step1");
		System.out.println("First Step");
	}

	@Then("^sencond step1$")
	public void sencond_step() throws Throwable {
		test.createNode(new GherkinKeyword("Then"), "sencond_step1");
		System.out.println("Second Step");
	}

	@Then("^third step1$")
	public void third_step() throws Throwable {
		test.createNode(new GherkinKeyword("Then"), "third_step1");
		System.out.println("Third Step");
	}

	@Then("^third step change1$")
	public void third_step_change() throws Throwable {
		test.createNode(new GherkinKeyword("Then"), "third_step_change1");
		System.out.println("Third Step Change");
	}
	
	@Then("^third step change21$")
	public void third_step_change2() throws Throwable {
		test.createNode(new GherkinKeyword("Then"), "third_step_change21");
		System.out.println("Third Step Change2");
	}

}
