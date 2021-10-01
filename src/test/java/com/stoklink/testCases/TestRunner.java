package com.stoklink.testCases;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/java/com/stoklink/Features" }, glue = {
		"src/test/java/com/stoklink/stepDefinitions" })
public class TestRunner extends AbstractTestNGCucumberTests {

}
