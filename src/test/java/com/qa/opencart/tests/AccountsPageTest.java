package com.qa.opencart.tests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.utils.AppConstants;

public class AccountsPageTest extends BaseTest {
	
		
	@BeforeClass
	public void accPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}	
	
	@Test
	public void accPageTitleTest() {
		String accTitle = accPage.getAccPageTitle();
		Assert.assertEquals(accTitle, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);	
	}
	
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	@Test
	public void accPageheadesCountTest() {
		List<String> actAccHeadersList = accPage.getAccPageHeadersList();
		Assert.assertEquals(actAccHeadersList.size(), 4);
	}
	
	@Test
	public void accPageheadesTest() {
		List<String> actAccHeadersList = accPage.getAccPageHeadersList();
		List<String> expAccHeadersList = Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
		Assert.assertEquals(actAccHeadersList, expAccHeadersList);
	}

}
