package pageobjects;

import org.openqa.selenium.By;

import helpers.BrowserUtils;
import helpers.Constant;
import helpers.ElementsUtils;
import helpers.Logger;

public class BasePage {
	protected String pageTitle;
	
	private String xpathMenu = "//li[.='%s']";
	
	private By getMenuLocator(String menu) {
		return By.xpath(String.format(xpathMenu, menu));
	}
	public void selectMenu(String menu) 
	{
		Logger.log("Select"+ menu);
		var locator = getMenuLocator(menu);
		ElementsUtils.waitForElementClickable(locator, Constant.PAGE_WAIT_TIMEOUT);
		ElementsUtils.findElement(locator).click();
	}
	public boolean isMenuExists(String menu, int timeoutInSeconds) 
	{
		var locator = getMenuLocator(menu);
		return ElementsUtils.isElementExists(locator, timeoutInSeconds);
	}
	
	public void waitForPageLoad() 
	{
		BrowserUtils.waitForTitle(pageTitle, Constant.PAGE_WAIT_TIMEOUT);
	}
}
