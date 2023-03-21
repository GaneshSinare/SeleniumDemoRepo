package com.Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageObject.AccountPage;
import com.pageObject.LandingPage;
import com.pageObject.LoginPage;
import com.Resources.*;

public class LoginThreeTest extends Base {
	WebDriver driver;
	Logger log;
	
	@Test
	public void login() throws IOException {
	
	LandingPage ldp=new LandingPage(driver);
	ldp.myAccount().click();
	log.debug("Clicked on My account");
	ldp.loginbutton().click();
	log.debug("Clicked on Login Button");
	
	LoginPage lgp= new LoginPage(driver);
	lgp.username().sendKeys(prop.getProperty("username"));
	lgp.password().sendKeys(prop.getProperty("password"));
	lgp.login_button().click();
	log.debug("User logged in");
	String title=driver.getTitle();
	Assert.assertEquals(title, "My Account");
	log.debug("Page title matched");
	AccountPage acp=new AccountPage(driver);
	Assert.assertEquals(acp.editAccountInfo().getText(),"Edit your account information");
	log.debug("Test case passed");
	}
	@BeforeMethod
	public void startApplication() throws IOException {
		log=LogManager.getLogger(LoginThreeTest.class.getName());
		driver=launchBrowser();	
	    driver.get(prop.getProperty("url"));
	    log.debug("Browser launched");
	}
	@AfterMethod
	public void close() {
		driver.close();
		log.debug("Browser closed");
	}
}
