package helpers;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

	public static void navigateTo(String url) 
	{
		Logger.log("navigate to"+ url);
		DriverUtils.driver.navigate().to(url);
	}
	public static void maximize()
	{
		Logger.log("Maximize browser");
		DriverUtils.driver.manage().window().maximize();
	}
	public static void close() 
	{
		Logger.log("Close browser");
		DriverUtils.driver.quit();
	}
	public static void waitForTitle(String title,int timeoutInSeconds) 
	{
		WebDriverWait wait = new WebDriverWait(DriverUtils.driver,Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.titleIs(title));
	}
	public static void openBrowser(String browser) throws Throwable{
		Logger.log("open browser");
		DriverUtils.initDriver(browser);
		BrowserUtils.maximize();
		}

}
