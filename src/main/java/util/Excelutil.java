package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutil {
	public static Workbook book;
	public static Sheet sheet;
	
	public static String excel_sheet_path="C:\\Users\\cute puja\\eclipse-workspace\\"
			+ "aprilpomser\\src\\main\\java\\Testdata\\book2.xlsx";
	
	public static Object[][] gettestdata(String sheetname) {
		try {
			FileInputStream fi=new FileInputStream(excel_sheet_path);
			
				book=WorkbookFactory.create(fi);
				sheet=book.getSheet(sheetname);
				Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				for(int i=0;i<sheet.getLastRowNum();i++) {
					
					for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
						data[i][k]=sheet.getRow(i+1).getCell(k).toString();
						
					}	
					}
				return data;
			} catch (InvalidFormatException e) {
				
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
	catch (IOException e) {
			
			e.printStackTrace();
		 }
		return null;
	}
}

