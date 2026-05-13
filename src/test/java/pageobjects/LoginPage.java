package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dataObjects.User;
import helpers.Constant;
import helpers.ElementsUtils;
import helpers.Logger;

public class LoginPage extends BasePage  {
	
	private By txtEmail = By.id("username");
	private By txtPassword = By.id("password");
	private By btnLogin = By.xpath("//input[@value='login']");
	private By lblErrorMessage = By.xpath("//p[contains(@class, 'error')]");
	
	public LoginPage() 
	{
		pageTitle = "Safe Railway - Login";
	}
	public void login(User user) 
	{
		Logger.log("login");
		waitForPageLoad();
		ElementsUtils.waitForElementExists(txtEmail, Constant.PAGE_WAIT_TIMEOUT);
		if (user.getEmail() != null) {
			var element = ElementsUtils.findElement(txtEmail);
			element.clear();
			element.sendKeys(user.getEmail());
		}
		if (user.getPassword() != null) {
			var element = ElementsUtils.findElement(txtPassword);
			element.clear();
			element.sendKeys(user.getPassword());
		}
		
		var submitElement = ElementsUtils.findElement(btnLogin);
		ElementsUtils.scrollIntoView(submitElement);
		submitElement.click();
	}
	
	public void clickLoginButton(){
		WebElement elementbtnLogin = ElementsUtils.findElement(btnLogin);
		ElementsUtils.waitForElementClickable(btnLogin, Constant.PAGE_WAIT_TIMEOUT);
		ElementsUtils.scrollIntoView(elementbtnLogin);
		elementbtnLogin.click();
	}
	
	public String getErrorMessage() {
		try {
		return ElementsUtils.findElement(lblErrorMessage).getText().trim();
		}catch(Exception e){
			return "";
		}
	}
}
