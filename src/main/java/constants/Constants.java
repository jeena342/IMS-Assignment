package constants;

public class Constants {
	//we can add constants capital letter
	public static final String CONFIGFILE= System.getProperty("user.dir")+"\\src\\main\\resources\\config.property";
	//user.dir = is the system local adderss
	public static final String TESTDATA=System.getProperty("user.dir")+"\\src\\test\\resources\\Data.xlsx";
	
	//"C:\\Users\\91996\\eclipse-workspace\\GroceryStore";
	public static final String AMOUNTMISMATCHERROR= "The amount is not matching with the database";
	public static final String DROPDOWNMISSINGERROR="The dropdown is missing. ";
}
