package testscript;


import java.util.Map;

import org.testng.Assert;

import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constants;
import dataprovider.TestDataProvider;

import pages.CatapultClassroomProgramPage;



public class CatapultClassroomProgramTest extends Base {
	    
	@Test(dataProvider = "CityFeeData", dataProviderClass = TestDataProvider.class, description="User is verifying the fees displayed ")
	public void verifyFeesAssignment(Map<String, String> rowData) {
	    CatapultClassroomProgramPage page = new CatapultClassroomProgramPage(driver);
	    
	    // Get values using Excel Header names (Must match exactly)
	    String city = rowData.get("City"); 
	    String center = rowData.get("Center");
	    String expectedAmount = rowData.get("Expected Fees"); 
  
	    try {
	        page.selectCityAndCenter(city, center);	        	      
	        double actualTotal = page.getTotalFeeFromUI();
	        double expectedTotal = Double.parseDouble(expectedAmount);
	        Assert.assertEquals(actualTotal, expectedTotal, Constants.AMOUNTMISMATCHERROR);

	    } catch (Exception e) {
	       
	        Assert.fail(Constants.DROPDOWNMISSINGERROR + e.getMessage());
	    }
	}
	    
	   
	
}