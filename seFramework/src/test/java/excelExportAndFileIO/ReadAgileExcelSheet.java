package excelExportAndFileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAgileExcelSheet {
	
	public XSSFSheet readExcel(String filePath,String fileName,String sheetName) throws IOException
	
	{
		File src = new File("C:\\Users\\Srikanth\\git\\SeFramework\\seFramework\\src\\test\\java\\excelSheets\\TestCase.xlsx");
		
		FileInputStream fileSrc = new FileInputStream(src);
			
		XSSFWorkbook wbook = new XSSFWorkbook(fileSrc);
		
		XSSFSheet wsheet = wbook.getSheet(sheetName);
		
		return wsheet;		
	}

}
