package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import constants.Constants;
import utils.ScreenShotUtility;



public class Base {
	Properties pro;
	FileInputStream file;
	public WebDriver driver;
	
	@Parameters("browsers")
	@BeforeMethod//(alwaysRun= true)
	public void browserInitialisation(String browers) throws IOException 	 {
		pro= new Properties();
		file=new FileInputStream(Constants.CONFIGFILE);
		pro.load(file);//to load the file
		if( browers.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();	
		}
		else if(browers.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browers.equalsIgnoreCase("edge")) {
			
			driver=new EdgeDriver();
		}
		driver.get(pro.getProperty("url"));
		
		driver.manage().window().maximize();
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult iTestResult) throws IOException {
	    
	    if (iTestResult.getStatus() == ITestResult.FAILURE) {

	       ScreenShotUtility screenShot = new ScreenShotUtility();
	       screenShot.getScreenshot(driver, iTestResult.getName());
	    }

	    driver.quit();
	}
	}

