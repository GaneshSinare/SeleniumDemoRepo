package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExentReporter {
	static ExtentReports extentReport;
	

		public static ExtentReports getExtentReport() {
			String path=System.getProperty("user.dir")+"\\reports\\extentreport.html";
			ExtentSparkReporter reporter= new ExtentSparkReporter(path);
			reporter.config().setReportName("Tutoeials Ninja Automation Results");
			reporter.config().setDocumentTitle("Test Result");
			
			 extentReport= new ExtentReports();
			 extentReport.attachReporter(reporter);
			 extentReport.setSystemInfo("Operating System", "Windows 10");
			 extentReport.setSystemInfo("Tested By", "Ganesh Sinare");
			 
			return extentReport;
			
		}
}
