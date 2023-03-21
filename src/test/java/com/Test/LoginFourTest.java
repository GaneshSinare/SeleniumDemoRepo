package com.Test;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Resources.Base;

public class LoginFourTest extends Base {
	public WebDriver driver;
	@Test
	public void loginTest() throws IOException {
		driver =launchBrowser();
		driver.get("https://www.google.com");
		System.out.println("Fourth Test");
		Assert.assertEquals("name", "Name");
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

}
