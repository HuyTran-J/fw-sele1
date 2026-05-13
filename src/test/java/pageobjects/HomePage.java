package pageobjects;

import org.openqa.selenium.By;

import helpers.ElementsUtils;

public class HomePage extends BasePage {
//	private By lblWecomeMessage = By.tagName("h1");
	
	String dashboardNotifcationMsgLocator = "//div[@id='content']/h1";
	By dashboardNotifcationMsg;
	
	public HomePage() 
	{
		dashboardNotifcationMsg = By.xpath(dashboardNotifcationMsgLocator);
		pageTitle = "Safe Railway - Selenium Automation";
	}

//	public String getWelcomeMessage()
//	{
//		waitForPageLoad();
//		ElementsUtils.waitForElementExists(lblWecomeMessage, Constant.PAGE_WAIT_TIMEOUT);
//		return ElementsUtils.findElement(lblWecomeMessage).getText();
//	}
	public String getdashBoardNotificationMsg() {
		return ElementsUtils.findElement(dashboardNotifcationMsg).getText();
	}
}
