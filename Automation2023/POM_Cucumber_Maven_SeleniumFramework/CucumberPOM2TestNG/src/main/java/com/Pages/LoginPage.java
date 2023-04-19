package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver ;
	
	private By Username = By.name("username");
	private By Password = By.name("password");
	private By LoginBtn = By.xpath("//button[@type='submit']");
	private By LoogedInUser = By.xpath("//span/p[text()='Paul Collings']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String GetTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}
	
	public void EnterUsername(String Uname) {
//		System.out.println("Usename displayed ? "+driver.findElement(Username).isDisplayed());
		driver.findElement(Username).sendKeys(Uname);
	}
	
	public void EnterPassword(String Pwd) {
//		System.out.println("Pssword displayed ? "+driver.findElement(Password).isDisplayed());
		driver.findElement(Password).sendKeys(Pwd);
	}
	
	public void ClickLoginBtn() {
		driver.findElement(LoginBtn).click();
	}
	
	public boolean ValidatePageTitle(String ExpPageTitle) {
		String s = driver.getTitle();
		return s.equals(ExpPageTitle);
	}
	
	public void ValidateLoggedInUser() {
//		if (driver.findElement(LoogedInUser).isDisplayed()) {		
//		System.out.println("Successfully LoggedIn");
//		return true;
//		}else {
//		System.out.println("Failed to login");
//		return false;
//		}
	}
	
	//Login in single method and land to dashboard page 
	
	public DashboardPage LoginTheApp(String Uname, String Pwd) throws InterruptedException {
		driver.findElement(Username).sendKeys(Uname);
		driver.findElement(Password).sendKeys(Pwd);
		driver.findElement(LoginBtn).click();
		Thread.sleep(5000);
		
		return new DashboardPage(driver);
	}

}
