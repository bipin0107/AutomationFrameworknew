package com.w2q.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {

	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 5;

	public static String generateEmailWithTimestamp() {
		Date date = new Date();
		String timestamp = date.toString().replace(" ", "_").replace(":", "_");
		return "test" + timestamp + "@gmail.com";

	}

	
	
	public static Object[][] getTestDataFromExcel(String sheetName) {
	    File excelFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\w2a\\testdata\\TestDataInput.xlsx");
	    XSSFWorkbook workbook = null;
	    FileInputStream fisexcel;
	    Object[][] data = null; // Initialize the data array outside the loop

	    try {
	        fisexcel = new FileInputStream(excelFile);
	        workbook = new XSSFWorkbook(fisexcel);
	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        int rows = sheet.getLastRowNum();
	        int cols = sheet.getRow(0).getLastCellNum();
	        data = new Object[rows][cols]; // Initialize the data array here

	        for (int i = 0; i < rows; i++) {
	            XSSFRow row = sheet.getRow(i + 1);

	            for (int j = 0; j < cols; j++) {
	                XSSFCell cell = row.getCell(j);
	                CellType cellType = cell.getCellType();

	                switch (cellType) {
	                    case STRING:
	                        data[i][j] = cell.getStringCellValue();
	                        break;
	                    case NUMERIC:
	                        data[i][j] = Integer.toString((int) cell.getNumericCellValue());
	                        break;
	                    case BOOLEAN:
	                        data[i][j] = cell.getBooleanCellValue();
	                        break;
	                    default:
	                        // Handle other cell types if needed
	                        break;
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return data;
	}


}
