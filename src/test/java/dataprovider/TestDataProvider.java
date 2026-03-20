package dataprovider;


import org.testng.annotations.DataProvider;
import utils.ExcelUtils; 
	public class TestDataProvider {

	   /* @DataProvider(name = "TestData")
	    "/*public Object[][] getData() {
	        // This is the source. It reads the Excel file.
	        return ExcelUtils.getTestData("Sheet1");
	    }"*/

	        /*public Object[][] getLoginData() {
	            // This returns a 2D array containing Maps
	            return ExcelUtils.getTestData("Sheet1");
	        }*/
		

		    @DataProvider(name = "CityFeeData")
		    public static Object[][] getCityFeeData() {
		        // Calls the fixed ExcelUtils method we discussed earlier
		        // "Sheet1" is the name of your tab in Data.xlsx
		        return ExcelUtils.getTestData("Sheet1");
		    }
		}
	    

