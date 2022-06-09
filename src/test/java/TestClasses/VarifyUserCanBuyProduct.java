package TestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClasses.BaseClass;
import PomClasses.HomePage;
import PomClasses.Login_Page;

public class VarifyUserCanBuyProduct {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;
	
	Login_Page lp;
	HomePage hp;
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		System.out.println(browserName);
		if(browserName.equals("Chrome"))
		{
			driver=BaseClass.openChromeBrowser();
		}
		else if(browserName.equals("Edge"))
		{
			driver=BaseClass.openMsEdgeBrowser();
		}
		
	}
	
	@BeforeClass
	public void beforeClass()
	{
		htmlReporter= new ExtentHtmlReporter("ExtentReporter.html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		test=report.createTest("VarifyUserCanBuyProduct");
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		lp=new Login_Page(driver);
		hp=new HomePage(driver);
	}
	
    @Test(priority=1)
    public void verifyUserCanLogin() throws InterruptedException
    {
    	lp.putEmail();
    	lp.putPassword();
    	lp.clickLoginBtn();
    	SoftAssert soft=new SoftAssert();
    	Thread.sleep(4000);
    	soft.assertTrue(lp.isProfileNameVisible());
    	soft.assertAll();
    	
    }
    
    @Test(priority=2)
    public void verifyUserCanSearchProduct() throws EncryptedDocumentException, IOException, InterruptedException
    {
    	hp.enterSearchText();
    	hp.clickOnSearchButton();
    	Assert.assertTrue(hp.isProfileNameVisible());
    	
    	
    	
    }
    @AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test is passed " + result.getName());
		}
		else
		{
			String path = hp.getScreenShot(driver, result.getName());
			test.log(Status.FAIL, "Test is failed " + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
			
		}
	}
    
    @AfterClass
    public void afterClass()
    {
    	report.flush();
    }
}
