package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dataObjects.User;
import helpers.Constant;
import helpers.ElementsUtils;
import helpers.Logger;

public class RegisterPage extends BasePage{

	private String confirmAccountLnkLocator = "//a[@href='Confirm.cshtml']";
	
	private By txtEmail = By.id("email");
	private By txtPassword = By.id("password");
	private By txtConfirmPassword = By.id("confirmPassword");
	private By txtPID = By.id("pid");
	private By btnRegister = By.xpath("//input[@value='Register']");
	private By confirmAccountLnk;
	
	
	public RegisterPage() {
		pageTitle = "Safe Railway - Register an Account";
		confirmAccountLnk = By.xpath(confirmAccountLnkLocator);
	}
	
	public void register(User user) 
	{
		Logger.log("Create user");
		waitForPageLoad();
		ElementsUtils.waitForElementExists(txtEmail, Constant.PAGE_WAIT_TIMEOUT);
		ElementsUtils.findElement(txtEmail).sendKeys(user.getEmail());
		ElementsUtils.findElement(txtPassword).sendKeys(user.getPassword());
		ElementsUtils.findElement(txtConfirmPassword).sendKeys(user.getPassword());
		ElementsUtils.findElement(txtPID).sendKeys(user.getPid());
		var registerButton = ElementsUtils.findElement(btnRegister);
		ElementsUtils.scrollIntoView(registerButton);
		
		ElementsUtils.findElement(btnRegister).click();
	}
	
	public void goToConfirmationPage(){
		WebElement confirmLinkElement = ElementsUtils.findElement(confirmAccountLnk);
		ElementsUtils.waitForElementClickable(confirmAccountLnk, Constant.PAGE_WAIT_TIMEOUT);
		ElementsUtils.scrollIntoView(confirmLinkElement);
		confirmLinkElement.click();
	}
	
}
