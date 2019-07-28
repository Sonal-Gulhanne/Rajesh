package com.ormb.com.ormb;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "json:target/cucumber.json", 
features="Test.feature",
glue= "com.ormb.com.ormb")

public class Testrunner {
	

}
