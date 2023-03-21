package com.Test;
import com.Resources.Base;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pageObject.AccountPage;
import com.pageObject.LandingPage;
import com.pageObject.LoginPage;

public class LoginOneTest extends Base {
	WebDriver driver;
	
	@Test(dataProvider="getLoginData")
	public void login(String mailId, String password, String expectedStatus) throws IOException {
	
	LandingPage ldp=new LandingPage(driver);
	ldp.myAccount().click();
	ldp.loginbutton().click();
	
	LoginPage lgp= new LoginPage(driver);
	lgp.username().sendKeys(mailId);
	lgp.password().sendKeys(password);
	lgp.login_button().click();
	
	AccountPage acp=new AccountPage(driver);
	try {
		Assert.assertEquals(acp.editAccountInfo().getText(),"Edit your account information");
		String actualStatus="Successfull";
		
	}catch(Exception e){
		String actualStatus="Failure";
	}	
	}
	@BeforeMethod
	public void startApplication() throws IOException {
		driver=launchBrowser();	
	    driver.get(prop.getProperty("url"));
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
	@DataProvider
	public Object [] [] getLoginData() {
		Object [][] data= {{"ganeshsinare3110@gmail.com","Ganesh@3110","Successfull"},{"ganeshsinare@gmail.com","Ganesh3110","Failure"}};
		return data;
	}
}
