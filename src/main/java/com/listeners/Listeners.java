package com.listeners;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Resources.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utilities.ExentReporter;

public class Listeners extends Base implements ITestListener {
	WebDriver driver;
	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		 extentReport = ExentReporter.getExtentReport();
		 String testName=result.getName();
		 extentTest = extentReport.createTest(testName+" Execution start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		 String testName=result.getName();
		 extentTest.log(Status.PASS, testName+"Test got passed");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getName();
		extentTest.fail(result.getThrowable());
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		try {
			takeScreenshot(testName, driver);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		
	}

}
