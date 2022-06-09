package UtilClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class UtilClass1 {

	

	public static String getScreenShot(WebDriver driver,String testName) throws IOException
	{
		Date date=new Date();
		
		SimpleDateFormat f=new SimpleDateFormat("YYYY-MM-dd-hh-mm-ss");
		
		String currentDate=f.format(date);
		
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String path=testName+".png";
		
		File dest=new File(path);
		
		FileHandler.copy(source, dest);
		
		return path;
	}
	
	public static void getDataFromExcelSheet(String sheetName,int row,int cell,WebElement element)throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\Flipkart_Automation\\src\\main\\resources\\TestData\\cartexcel.xlsx");
		Sheet sheet=WorkbookFactory.create(file).getSheet(sheetName);
		try
		{
			String data=sheet.getRow(row).getCell(cell).getStringCellValue();
			element.sendKeys(data);
			element.click();
			
			
		}catch(Exception e)
		{
			String data=String.valueOf(sheet.getRow(row).getCell(cell).getNumericCellValue());
			element.sendKeys(data);
			element.click();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
