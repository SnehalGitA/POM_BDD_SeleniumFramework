package parallel;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.CommonMethods.InvokeDriver;
import com.CommonMethods.TakeScreenshotsMethods;
import com.Utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

//To run before and after every scenario
public class ApplicationHooks {
	
	Properties prop;
	WebDriver driver = InvokeDriver.getDriver();
	
	@Before(order=0)  //executed first
	public void ReadProperty() {
		ConfigReader r = new ConfigReader();
		prop = r.init_Properties();
				
	}
	
	@Before(order=1)  //execute last
	public void LaunchApp() throws Throwable {
		InvokeDriver d = new InvokeDriver();
		String BrowserName = prop.getProperty("Browser");
		driver = d.initDriver(BrowserName);
		
	}
	
	@After(order=0) //This will run last
	public void QuitDriver() {
		driver.close();
	}
	
	@After(order=1) //This will run first
	public void TakeScreenshotOnTestFail(Scenario sc) throws IOException {
		
		if(sc.isFailed()) {
			TakeScreenshotsMethods.CaptureScreenshot(sc, driver);
		}
//			else {
//			TakeScreenshotsMethods.CaptureScreenshot(sc, driver);
//		}
		
	}

}
