package utils;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class PageUtility {
	
	
	public static void selectByVisibleText(WebElement element, String text) {
		try {
        Select select = new Select(element);
        select.selectByVisibleText(text);
		}catch(NoSuchElementException e) {
            System.out.println(text +" is not in the dropdown" );
			       
        }
    }

    // Cleans strings like "₹ 80750/-" into "80750"
    public static double cleanAmount(String text) {
        String clean = text.replaceAll("[^0-9]", "");
        
        return Double.parseDouble(clean);
    }

    
}
