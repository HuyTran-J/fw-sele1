package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helpers.Constant;
import helpers.ElementsUtils;

public class ConfirmationPage extends RegisterPage{
	
	private String confirmationCodeTxtLocator = "//input[@id='confirmationCode']";
	private String confirmBtnLocator = "//input[@type='submit']";
	private String confirmationMessageLocator  = "//div[@id='content']/p";

	By confirmBtn;
	By confirmationCodeTxt;
	By confirmationMessage;
	
	public ConfirmationPage() {
		confirmationCodeTxt = By.xpath(confirmationCodeTxtLocator);
		confirmBtn = By.xpath(confirmBtnLocator);
		confirmationMessage = By.xpath(confirmationMessageLocator);
	}
	
	public void inputConfirmationCode(String confirmationCode) {
		ElementsUtils.findElement(confirmationCodeTxt).sendKeys(confirmationCode);
	}
	
	public void clickConfirmButton(){
		WebElement elementConfirmbtn = ElementsUtils.findElement(confirmBtn);
		ElementsUtils.waitForElementClickable(confirmBtn, Constant.PAGE_WAIT_TIMEOUT);
		ElementsUtils.scrollIntoView(elementConfirmbtn);
		elementConfirmbtn.click();
	}
	public String getConfirmationMessage(){
		ElementsUtils.waitForElementExists(confirmationMessage,Constant.PAGE_WAIT_TIMEOUT);
		return ElementsUtils.findElement(confirmationMessage).getText();
	}
}
