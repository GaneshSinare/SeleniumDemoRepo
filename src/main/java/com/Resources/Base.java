package com.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	WebDriver driver;
	public Properties prop;
	public WebDriver launchBrowser() throws IOException {
		
		ChromeOptions co= new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		prop = new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\NinjaTutorialProject\\src\\main\\java\\com\\resources\\Data.properties");
		prop.load(fis);
		
		String browser=prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
		    driver= new ChromeDriver(co);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		    driver= new ChromeDriver(co);
		}
		else if(browser.equalsIgnoreCase("ie")){
			WebDriverManager.iedriver().setup();
			driver= new ChromeDriver(co);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}

	public void takeScreenshot(String testName, WebDriver driver) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		File des= new File(destination);
		FileUtils.copyFile(src, des);
	}
}
