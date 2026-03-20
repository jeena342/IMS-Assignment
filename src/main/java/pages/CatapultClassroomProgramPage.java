package pages;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageUtility;
import utils.WaitUtility;

public class CatapultClassroomProgramPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//select[@id='city']") WebElement cityDropdown;
	@FindBy(id="centernew") WebElement centerDropdown;
	@FindBy(xpath="//input[@id='newtotalcost']/preceding-sibling::span") WebElement baseFeeText;
	@FindBy(xpath="//span[contains(text(), 'GST')]/following-sibling::span") WebElement gstFeeText;
    

    public CatapultClassroomProgramPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CatapultClassroomProgramPage selectCityAndCenter(String city, String center) {
    	
        PageUtility.selectByVisibleText(cityDropdown, city);
       
        PageUtility.selectByVisibleText(centerDropdown, center);
    		
		return this;
		
    }

    public double getTotalFeeFromUI() {
        
 
        WaitUtility.waitForElement(driver, baseFeeText);
        // Clean and parse the fees
        double base = PageUtility.cleanAmount(getOnlyNumbers(baseFeeText.getText()));
        double gst = PageUtility.cleanAmount(getOnlyNumbers(gstFeeText.getText()));
        
        // Calculate the sum
        double totalCalculated = base + gst;
        
        return totalCalculated;
    }
    
   
    private String getOnlyNumbers(String text) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(text);
        
        if (m.find()) {
            return m.group(); 
        }
        return "0";
    }
    
}
