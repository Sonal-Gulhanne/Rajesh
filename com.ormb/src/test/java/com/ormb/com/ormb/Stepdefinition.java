package com.ormb.com.ormb;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefinition {
	//Ormb a = new Ormb();
	@Given("^Login id and password$")
	public void login_id_pasword(){
		Ormb.ConfigFileReader();
		Ormb.getApplicationUrl();
		Ormb.OpenBrowser();

}
	@When("^id password entered$")
	public void id_password_entered() {
	    // Write code here that turns the phrase above into concrete actions
	    Ormb.clickGmail();
	}

	@Then("^User should be able to login$")
	public void user_should_be_able_to_login(){
	    // Write code here that turns the phrase above into concrete actions
	    
	}


}
