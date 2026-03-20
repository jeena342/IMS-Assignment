package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

	public class ExcelUtils {
	    
		private static final String FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/Data.xlsx";
		public static Object[][] getTestData(String sheetName) {
		    Object[][] data = null;
		    DataFormatter formatter = new DataFormatter(); // Add this!

		    try (FileInputStream file = new FileInputStream(FILE_PATH);
		         Workbook workbook = new XSSFWorkbook(file)) {

		        Sheet sheet = workbook.getSheet(sheetName);
		        int rowCount = sheet.getLastRowNum();
		        int colCount = sheet.getRow(0).getLastCellNum();

		        data = new Object[rowCount][1];

		        for (int i = 0; i < rowCount; i++) {
		            Map<String, String> map = new HashMap<>();
		            Row headerRow = sheet.getRow(0);
		            Row currentRow = sheet.getRow(i + 1);

		            for (int j = 0; j < colCount; j++) {
		                // formatter handles null cells and converts everything to String
		                String key = formatter.formatCellValue(headerRow.getCell(j));
		                String value = formatter.formatCellValue(currentRow.getCell(j));
		                
		                if(!key.isEmpty()) { 
		                    map.put(key, value);
		                }
		            }
		            data[i][0] = map;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return data;
		}
	}
