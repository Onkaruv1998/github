package PomClasses;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.UtilClass1;

public class HomePage extends UtilClass1{
	WebDriver driver;
	
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath="//div[text()='Akshay']")
	private WebElement profileName;

	@FindBy(xpath="//span[text()='Cart']")
	private WebElement cartButton;

	@FindBy(xpath="//div[@class='_1AtVbE col-12-12']")
	private WebElement productList;
	
	@FindBy(xpath="(//div[@class='_1AtVbE col-12-12'])[1]")
	private WebElement productItem;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void enterSearchText() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Thread.sleep(2000);
		getDataFromExcelSheet("Sheet1", 0, 0,searchBox);
	}
	
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	
	public boolean isProfileNameVisible()
	{
		try
		{
			WebElement element=driver.findElement(By.xpath("//div[text()='Akshay']"));
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
