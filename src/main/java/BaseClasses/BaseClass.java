package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

		public static WebDriver openChromeBrowser()
		{
			
			WebDriverManager.chromedriver().setup();
		//	System.setProperty("webdriver.chrome.driver","src\\main\\resourses\\Browser\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			return driver;
		}
		
		public static WebDriver openMsEdgeBrowser()
		{
			WebDriverManager.edgedriver().setup();
		//	System.setProperty("webdriver.edge.driver", "src\\main\\resources\\Browser\\msedgedriver.exe");
			WebDriver driver=new EdgeDriver();
			return driver;
		}
	

}
