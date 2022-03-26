package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;
public class Listeners extends base implements ITestListener {

	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //for thread safe in parallel execution
	@Override
	public void onTestStart(ITestResult result) {
	
		 test = extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable());
	//for screenshot attached in extent report add extentTest screenshot path in try block
		
		//for screenshot in loical machine
		WebDriver driver=null;
		String testMethodName = result.getMethod().getMethodName();
		
		try {
			
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
		}
		
		
		try {
			//pulling screenshotpath from local machine pushing to extent report path
			extentTest.get().addScreenCaptureFromPath(getscreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			
			
			getscreenShotPath(testMethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

	
}