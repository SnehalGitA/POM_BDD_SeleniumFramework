package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	private WebDriver driver;
	
	private By DashboardTitle = By.xpath("//h6");
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean GetDashboardPageTitle(String ExpPageTitle) {
		
		String DashTitle = driver.findElement(DashboardTitle).getText();
		System.out.println(DashTitle);
		return DashTitle.equals(ExpPageTitle);
	}

}
