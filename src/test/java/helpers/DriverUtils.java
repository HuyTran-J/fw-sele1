package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils {

	public static WebDriver driver;

	public static void initDriver(String browser) throws Throwable {
		Logger.log("Clear chrome cache");
		WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
		Logger.log("create" + browser);
		switch (browser) {
		case "chrome": {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		}
		case "firefox": {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		}
		case "edge": {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
		default:
			var message = "Browser" + browser + "was not supported";
			Logger.log(message);
			throw new Exception(message);
		}
	}


	//public static void setDriver(String browser) {
		// TODO Auto-generated method stub
		
	//}
}
