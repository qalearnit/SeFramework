package testCases;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelExportAndFileIO.ReadAgileExcelSheet;
import operation.ReadObject;
import operation.UIOperation;

public class HybridExecuteTest {
	
	WebDriver webdriver=null;	
	
  @Test(dataProvider = "hybridData")
  public void loginTest(String executeTest,String testcaseName,String keyword,String objectName,String objectType,String value) throws Exception
  {
	  if(executeTest.equalsIgnoreCase("Yes") && testcaseName!=null && testcaseName.length()!=0)
	  {
		  System.setProperty("webdriver.chrome.driver","P:\\browsers\\chromedriver.exe");
		  webdriver = new ChromeDriver();	
		  
		  ReadObject object = new ReadObject();
		  Properties allObjects = object.getObjectRepository();
		  UIOperation operation = new UIOperation(webdriver);
		  //Call perform function to perform operation on UI
		              operation.perform(allObjects, keyword, objectName,
		                  objectType, value);	  
				  
	  }
	 	 
  }
  
  @DataProvider(name="hybridData")
  public Object[][] getDataFromDataprovider() throws IOException{
  Object[][] object = null;
  ReadAgileExcelSheet file = new ReadAgileExcelSheet();
//Read keyword sheet
  XSSFSheet wSheet = file.readExcel("C:\\Users\\Srikanth\\git\\SeFramework\\seFramework\\src\\test\\java\\excelSheets\\","TestCase.xlsx" , "KeywordFramework");
//Find number of rows in excel file
  int rowCount = wSheet.getLastRowNum()-wSheet.getFirstRowNum();
  
  XSSFRow firstRow = wSheet.getRow(0);
  int colCount=firstRow.getPhysicalNumberOfCells();
  //object = new Object[rowCount][5];
  object = new Object[rowCount][colCount];
  for (int i = 0; i < rowCount; i++) 
  {
      //Loop over all the rows
      XSSFRow row = wSheet.getRow(i+1);
      //Create a loop to print cell values in a row
      for (int j = 0; j < row.getLastCellNum(); j++) 
      {
          //Print excel data in console
          object[i][j] = row.getCell(j).toString();
      }
  }
  
  System.out.println("");
   return object;    
  }
  @BeforeTest
  public void beforeTest() {
	  
	  System.out.println("The test has started");
  }

  @AfterTest
  public void afterTest() {
	  
	  webdriver.close();
  }  

}
