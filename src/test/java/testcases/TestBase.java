package testcases;

import helpers.BrowserUtils;
import helpers.DriverUtils;
import pageobjects.BasePage;
import org.testng.annotations.*;

public class TestBase extends BasePage{
	
	@Parameters({"browser"})
	@BeforeMethod
	public void openBrowser(String browser) throws Throwable{
		DriverUtils.initDriver(browser);
		BrowserUtils.maximize();
		}
	
	@AfterMethod
	public void teardown() {
		BrowserUtils.close();
	}

}