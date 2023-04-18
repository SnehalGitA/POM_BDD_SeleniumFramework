package com.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop ;
	
	public Properties init_Properties() {
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\snpawar\\Automation2023\\POM_Cucumber_Maven_SeleniumFramework\\CucumberPOM\\src\\test\\resources\\com\\Config\\Config.properties");
			prop.load(fis);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
