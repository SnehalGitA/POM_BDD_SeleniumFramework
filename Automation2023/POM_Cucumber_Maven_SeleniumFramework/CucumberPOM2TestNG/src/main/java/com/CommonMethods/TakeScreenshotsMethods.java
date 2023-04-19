package com.CommonMethods;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class TakeScreenshotsMethods {
	
	public static void CaptureScreenshot(Scenario sc , WebDriver driver) throws IOException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now)); 
		String time = dtf.format(now).replaceAll(":", "");
		   
		String screenshotName = sc.getName().replaceAll(" ", "_") ;
		System.out.println(screenshotName);
		TakesScreenshot scShot = ((TakesScreenshot)driver);
		byte [] srcFile1 = scShot.getScreenshotAs(OutputType.BYTES);
		File srcFile = scShot.getScreenshotAs(OutputType.FILE);
		System.out.println(srcFile);
		sc.attach(srcFile1, "image/png", screenshotName);
		FileUtils.copyFile(srcFile, new File("C:\\Users\\snpawar\\Automation2023\\POM_Cucumber_Maven_SeleniumFramework\\CucumberPOM\\Screenshots\\"+screenshotName+"_"+time+".png"));
		
	}
	
	

}
