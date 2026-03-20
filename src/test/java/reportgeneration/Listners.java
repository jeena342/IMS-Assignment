package reportgeneration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentReportUtility;




public class Listners implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent = ExtentReportUtility.createExtentReports();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();// to store each test in each threadtest  
	//execute before every testcase
	public void onTestStart(ITestResult result) {

	ITestListener.super.onTestStart(result);
	test = extent.createTest(result.getMethod().getMethodName());//to featch each testcase method and method name
	extentTest.set(test);

	}
	
	public void onTestSuccess(ITestResult result) {

	ITestListener.super.onTestSuccess(result);
	extentTest.get().log(Status.PASS, "Test Passed");

	}
    // execute when a testcase fail 
	public void onTestFailure(ITestResult result) {

	ITestListener.super.onTestFailure(result);

	extentTest.get().log(Status.FAIL, "Test Failed");
	extentTest.get().fail(result.getThrowable());

	WebDriver driver = null;

	String testMethodName = result.getMethod().getMethodName();
	
	try {

	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
	.get(result.getInstance());
	} catch (IllegalArgumentException e) {

	e.printStackTrace();
	} catch (IllegalAccessException e) {

	e.printStackTrace();
	} catch (NoSuchFieldException e) {

	e.printStackTrace();
	} catch (SecurityException e) {

	e.printStackTrace();
	}

	try {
	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
	.get(result.getInstance());
	String screenshotPath = null;
	
    extentTest.get().addScreenCaptureFromPath(screenshotPath);
	} catch (Exception e) {
	}
	}
	
	public void onTestSkipped(ITestResult result) {

	ITestListener.super.onTestSkipped(result);
	extentTest.get().log(Status.SKIP, "Test Skipped");
	String testMethodName = result.getMethod().getMethodName();

	}
	//execute when fails before the success percentage
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}
	//execute when the testcase failed on timeout,connectivity issue
	public void onTestFailedWithTimeout(ITestResult result) {

	ITestListener.super.onTestFailedWithTimeout(result);
	}
	// execute when the testcase start
	public void onStart(ITestContext context) {

	ITestListener.super.onStart(context);
	}
	// execute when the testcase finish
	public void onFinish(ITestContext context) {

	ITestListener.super.onFinish(context);
	extent.flush();// to log all the testcase
	}

}
