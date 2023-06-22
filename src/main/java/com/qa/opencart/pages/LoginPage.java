package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	//1. constructor of the class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	//2. private by locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdlink = By.linkText("Forgotten Password");
	private By footerLinks = By.xpath("//footer//a");
	private By myAccountLink = By.xpath("//div/a[text()='My Account']");
	private By loginErrorMessage = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	
	private By registerLink = By.linkText("Register");
	
	
	//public page actions/methods
	public String getLoginPageTitle() {
		return eleUtil.waitForTitleIsAndCapture(AppConstants.LOGIN_PAGE_TITLE_VALUE, AppConstants.SHORT_DEFAULT_WAIT);		
	}
	
	public String getLoginPageUrl() {
		return eleUtil.waitForURLContainsAndCapture(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE, AppConstants.SHORT_DEFAULT_WAIT);	
	}
	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.checkElementIsDisplayed(forgotPwdlink);
	}
	
	public boolean isMyAccountLinkExist() {
		return driver.findElement(myAccountLink).isDisplayed();
	}
	
	public List<String> getFooterElementsList() {
		List<WebElement> fppterLinksList = eleUtil.waitForElementsVisible(footerLinks,AppConstants.MEDIUM_DEFAULT_WAIT);
		List<String> footerTextList = new ArrayList<String>();
		for(WebElement e : fppterLinksList) {
			String text = e.getText();
			footerTextList.add(text);
		}
		return footerTextList;
	}
	
	public AccountsPage doLogin(String userName, String pwd) {		
		System.out.println("Correct Credentials are " + userName + ":" + pwd);
		eleUtil.waitForElementVisible(emailId, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(userName);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);
		//return the next landing page --chain model
	}
	
	public boolean doLoginWithWrongCredentials(String userName, String pwd) {
		System.out.println("Wrong Credentials are " + userName + ":" + pwd);
		eleUtil.waitForElementVisible(emailId, AppConstants.MEDIUM_DEFAULT_WAIT);
		eleUtil.doSendKeys(emailId, userName);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		String errorMess = eleUtil.doGetElementText(loginErrorMessage);
		System.out.println(errorMess);
		if(errorMess.contains(AppConstants.LOGIN_ERROR_MESSAGE)){
			return true;					
		}
		return false;
		//return the next landing page --chain model
	}
	
	public RegistrationPage navigateRegisterPage() {
		eleUtil.doClick(registerLink);
		return new RegistrationPage(driver);
	}
	

}
