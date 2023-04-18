package com.CommonMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokeDriver {
	
	WebDriver driver ;
	
	public static ThreadLocal<WebDriver> TLdriver = new ThreadLocal<>();
	//This is used for parallel execution
	
	@SuppressWarnings("deprecation")
	public WebDriver initDriver(String browser) throws Throwable {
		System.out.println("Browser : "+browser);
		
		if(browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			TLdriver.set(new ChromeDriver());
			
		}else if(browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			TLdriver.set(new EdgeDriver());
			
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return getDriver();
		
	}
	
	//This is used to get driver using ThreadLocal
	public static WebDriver getDriver() {
		return TLdriver.get();
		
	}

}
