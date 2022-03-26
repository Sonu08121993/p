package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	 
	static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); 
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		
		// ExtentReports class is main class which is responsible for extent report execution
		  extent = new  ExtentReports();
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Tester", "Sonu Arya");
		 return extent;
	}
	
}
