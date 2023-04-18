package com.StepDef;

import com.CommonMethods.InvokeDriver;
import com.Pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private LoginPage login = new LoginPage(InvokeDriver.getDriver());
	
	
	@Given("User is on Login Page")
	public void UserLoginPage() {
		InvokeDriver.getDriver().get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@When("User get the title of the page")
	public void UserGetTitle() {		
		login.GetTitle();		
	}
	
	@Then("Page title should be {string}")
	public void PageTitle(String Title) {
		login.ValidatePageTitle(Title);
		System.out.println("Page title is : "+ Title);
	}
	
	@When ("User enters username {string}")
	public void EnterUsername(String Username) {
//		System.out.println("User Name is : "+Username);
		login.EnterUsername(Username);
	}
	
	@And("User enters password {string}")
	public void EnterPassword(String Password) {
//		System.out.println("Password is : "+Password);
		login.EnterPassword(Password);
	}
	
	@And("User Click Login Button")
	public void ClickLogin() throws InterruptedException {
		login.ClickLoginBtn();
		Thread.sleep(5000);
	}
	
	@And("user should be logged in successfully")
	public void VerifyLoggedInSuccessfully() {
		login.ValidateLoggedInUser();
	}

}
