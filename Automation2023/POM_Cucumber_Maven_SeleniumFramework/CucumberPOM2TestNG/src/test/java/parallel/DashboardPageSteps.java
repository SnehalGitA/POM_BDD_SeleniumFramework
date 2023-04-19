package parallel;

import java.util.List;
import java.util.Map;

import com.CommonMethods.InvokeDriver;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class DashboardPageSteps {
	
	private LoginPage login = new LoginPage(InvokeDriver.getDriver());
	private DashboardPage dashboard;
	
	@Given("User has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> cred = dataTable.asMaps();
		String Uname = cred.get(0).get("UserName");
		String Pwd = cred.get(0).get("Password");
		
		InvokeDriver.getDriver().get("https://opensource-demo.orangehrmlive.com/");
		dashboard = login.LoginTheApp(Uname, Pwd);
	}

	@When("User is on Dashboard page")
	public void user_is_on_dashboard_page() {
	}

	@Then("Title should be {string}")
	public void title_should_be(String DashTitle) {
		dashboard.GetDashboardPageTitle(DashTitle);
		
	}

	
	

}
