package helpers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsUtils 
	{
	public static WebElement findElement(By locator) 
	{
		return DriverUtils.driver.findElement(locator);
	}
	public static List<WebElement> findElements(By locator) 
	{
		return DriverUtils.driver.findElements(locator);

	}
	public static void waitForElementExists(By locator, int timeoutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(DriverUtils.driver, Duration.ofSeconds(timeoutInSeconds));

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static void waitForElementDisappear(By locator, int timeoutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(DriverUtils.driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(locator)));
	}
	public static void waitForElementClickable(By locator, int timeoutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(DriverUtils.driver, Duration.ofSeconds(timeoutInSeconds));

		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	
	public static boolean isElementExists(By locator, int timeoutInSeconds) 
	{
		try {
			waitForElementExists(locator, timeoutInSeconds);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
	public static void scrollIntoView(WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
