package com.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageObject.AccountPage;
import com.pageObject.LandingPage;
import com.pageObject.LoginPage;
import com.Resources.Base;
import com.Resources.Base;
public class LoginTest extends Base {
	WebDriver driver;
	
		@Test
		public void login() throws IOException {
		
		LandingPage ldp=new LandingPage(driver);
		ldp.myAccount().click();
		ldp.loginbutton().click();
		
		LoginPage lgp= new LoginPage(driver);
		lgp.username().sendKeys(prop.getProperty("username"));
		lgp.password().sendKeys(prop.getProperty("password"));
		lgp.login_button().click();
		String title=driver.getTitle();
		Assert.assertEquals(title, "My Account");
		AccountPage acp=new AccountPage(driver);
		Assert.assertEquals(acp.editAccountInfo().getText(),"Edit your account information");
		
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
}