package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.testng.annotations.Test;

import dataObjects.Menu;
import dataObjects.User;
import helpers.BrowserUtils;
import helpers.Constant;
import helpers.DriverUtils;
import helpers.Logger;
import pageobjects.BookTicketPage;
import pageobjects.ConfirmationPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyTicketPage;
import pageobjects.RegisterPage;
import pageobjects.thirdPartySite.MailBoxPage;

public class TestCase extends TestBase{

@Test
	public void TC01() {
		//User can log into Railway with valid username and password

		//Data prepare
		HomePage homePage = new HomePage();
		LoginPage loginPage = new LoginPage();
	
		User user = new User(
	            "huyy.tran0801@gmail.com",
	            "Huyyy@08022000"
	    );

	    String expectedMsg = "Welcome to Safe Railway";

		
		//Step1. Navigate to QA Railway Website
		BrowserUtils.navigateTo(Constant.URL);
		
		//Step2. Click on "Login" tab
		homePage.selectMenu(Menu.LOGIN.toString());
		
		//Step3. Enter valid Email and Password
		homePage.selectMenu(Menu.LOGIN.toString());
		loginPage.login(user);
		
		//Step4. Click on "Login" button
		loginPage.clickLoginButton();
		
		//VP:User is logged into Railway. Welcome user message is displayed.
        assertEquals(homePage.getdashBoardNotificationMsg(), welcomeMsg, "Welcome user message displayed");
	}	
//	
//	@Test
//	public void TC02() {
//		//User cannot login with blank "Username" textbox
//
//		//Data prepare
//		HomePage homePage = new HomePage();
//		LoginPage loginPage = new LoginPage();
//	
//		
//		var email = "";
//		var password = "Huyyy@08022000";
//	    var user = new User(email,password);
//	    var errorMsg = "There was a problem with your login and/or errors exist in your form.";
//
//	
//        //pre.Navigate to Railway to register
//		DriverUtils.driver.navigate().to(Constant.URL);
//		
//		//Step1. Navigate to QA Railway Website
//		BrowserUtils.navigateTo(Constant.URL);
//		
//		//Step2. Click on "Login" tab
//		homePage.selectMenu(Menu.LOGIN.toString());
//		
//		//Step3. User doesn't type any words into "Username" textbox but enter valid information into "Password" textbox 
//		homePage.selectMenu(Menu.LOGIN.toString());
//		loginPage.login(user);
//		
//		//Step4. Click on "Login" button
//		loginPage.clickLoginButton();
//		
//		//VP:User can't login and message "There was a problem with your login and/or errors exist in your form. " appears.
//        assertEquals(homePage.getdashBoardNotificationMsg(), errorMsg, "Expected errors message displayed");
//	}	
//	
//	@Test
//	public void TC03() {
//		//User cannot log into Railway with invalid password 
//
//		//Data prepare
//		HomePage homePage = new HomePage();
//		LoginPage loginPage = new LoginPage();
//	
//		var email = "huyy.tran0801@gmail.com";
//		var password = "2000";
//	    var user = new User(email,password);
//	    var errorMsg = "There was a problem with your login and/or errors exist in your form.";
//
//
//        //pre.Navigate to Railway to register
//		DriverUtils.driver.navigate().to(Constant.URL);
//		
//		//Step1. Navigate to QA Railway Website
//		BrowserUtils.navigateTo(Constant.URL);
//		
//		//Step2. Click on "Login" tab
//		homePage.selectMenu(Menu.LOGIN.toString());
//		
//		//Step3. Enter valid Email and invalid Password
//		homePage.selectMenu(Menu.LOGIN.toString());
//		loginPage.login(user);
//		
//		//Step4. Click on "Login" button
//		loginPage.clickLoginButton();
//		
//		//VP:Error message "There was a problem with your login and/or errors exist in your form." is displayed.
//        assertEquals(homePage.getdashBoardNotificationMsg(), errorMsg, "Expected errors message displayed");
//	}	
//	
//	@Test
//	public void TC04() {
//		//System shows message when user enters wrong password many times
//
//		//Data prepare
//		HomePage homePage = new HomePage();
//		LoginPage loginPage = new LoginPage();
//	
//		
//		var email = "huyy.tran0801@gmail.com";
//		var password = "2000";
//	    var user = new User(email,password);
//	    var errorMsg = "Invalid username or password. Please try again";
//	    var notiMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
//	
//
//        //pre.Navigate to Railway to register
//		DriverUtils.driver.navigate().to(Constant.URL);
//	
//		//Step1. Navigate to QA Railway Website
//		BrowserUtils.navigateTo(Constant.URL);
//		
//		//Step2. Click on "Login" tab
//		homePage.selectMenu(Menu.LOGIN.toString());
//		
//		//Step3. Enter valid Email and invalid Password
//		homePage.selectMenu(Menu.LOGIN.toString());
//		loginPage.login(user);
//		
//		//Step4. Click on "Login" button
//		loginPage.clickLoginButton();
//		
//		//VP:"Invalid username or password. Please try again" is shown
//        assertEquals(homePage.getdashBoardNotificationMsg(), errorMsg, "Invalid username or password. Please try again");
//        
//        //Step5. Repeat step 3 and 4 three more times.
//        	
//        homePage.selectMenu(Menu.LOGIN.toString());
//		loginPage.login(user);
//		loginPage.clickLoginButton();
//        
//        //VP:User can't login and message "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes." appears.
//        assertEquals(homePage.getdashBoardNotificationMsg(), notiMsg, "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.");
//	}
	
//	@Test
//	public void TC05() {
//		//User can't login with an account hasn't been activated
//
//		//Data prepare
//		HomePage homePage = new HomePage();
//		MailBoxPage mailboxPage = new MailBoxPage();
//		RegisterPage registerPage = new RegisterPage();
//		LoginPage loginPage = new LoginPage();
//	
//		var username = "Jin_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
//		var emailDomain = "sharklasers.com";
//		var userNameEmail = username + "@" + emailDomain;
//		var password = "Test!123";
//		var pidNumber = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMddyyyyHHmmss"));
//		var user = new User(userNameEmail,password,pidNumber);
//		var emailTitle = "Please confirm your account " + userNameEmail;
//	    var errorMsg = "Invalid username or password. Please try again";
//	   
//	
//
//        //pre.Navigate to Railway to register
//		DriverUtils.driver.navigate().to(Constant.URL);
//		
//		//pre.Go to register
//	    homePage.selectMenu(Menu.REGISTER.toString());
//		
//		//pre.enter credential
//		registerPage.register(user);
//		
////		//pre.open mail box
////		DriverUtils.driver.navigate().to(Constant.MAIL_BOX_URL);
//
//		
////		//pre.enter email info
////		mailboxPage.setEmailUserName(username);
////		mailboxPage.selectEmailDomain(emailDomain);
////		mailboxPage.selectExpectedEmail(emailTitle);
////		
//		
//		//Step1. Navigate to QA Railway Website
//		BrowserUtils.navigateTo(Constant.URL);
//		
//		//Step2. Click on "Login" tab
//		homePage.selectMenu(Menu.LOGIN.toString());
//		
//		//Step3. Enter username and password of account hasn't been activated.
//		homePage.selectMenu(Menu.LOGIN.toString());
//		loginPage.login(user);
//		
//		//Step4. Click on "Login" button
//		loginPage.clickLoginButton();
//		
//		//VP:"Invalid username or password. Please try again" is shown
//        assertEquals(homePage.getdashBoardNotificationMsg(), errorMsg, "Invalid username or password. Please try again");
//        
//	}
}
