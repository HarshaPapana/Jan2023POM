package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest {
	
	@BeforeClass
	public void regSetup() {		
		registrationPage = loginPage.navigateRegisterPage();		
	}
	
	public String getRandomEmailID() {
		return "testautomation" + System.currentTimeMillis() + "@gmail.com";
		//return "testautomation"+UUID.randomUUID()+@gmail.com";
		
		//generate random data
//		Random random = new Random();
//		random.nextInt(1000);
		
	}
	
	@DataProvider(name = "regData")
	public Object[][] getUserRegTestData() {
		return new Object[][] {
			{"abhi", "anand", "9000123456", "abhi@123", "yes"},
			{"robinson", "matinez", "9000123456", "robin@123", "no"},
			{"amber", "automation", "9000123456", "amber@123", "yes"},
		};
	}
	
	//for excel data
	@DataProvider(name = "regExcelData")
	public Object[][] getRegExcelTestData() {
		Object regData[][] = ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return regData;
	}
	
	@Test(dataProvider = "regData")
	public void userRegistrationTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		
		 String actSuccessMessg = registrationPage.registerUser(firstName, lastName, getRandomEmailID(), telephone, password, subscribe);
		 Assert.assertEquals(actSuccessMessg, AppConstants.USER_REG_SUCCESS_MESSG);
		 
	}
	
	

}
