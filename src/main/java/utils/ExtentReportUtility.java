package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports=new ExtentReports();
	public synchronized static ExtentReports createExtentReports() {
	ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
	reporter.config().setReportName("IMS-Catapult Classroom Program");
	extentReports.attachReporter(reporter);

	extentReports.setSystemInfo("Organization", "IMS");
	extentReports.setSystemInfo("Name", "Jeena"); // provides context of the report
	return extentReports;
	
	}

}