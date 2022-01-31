package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BrowserFactory {

	 static WebDriver driver;
	  static String browser ;
	  static String url;

	  public static void readConfig()  {
		  try {
		  InputStream input = new FileInputStream("src\\main\\java\\config\\Config.properties");
		  Properties prop = new Properties();
		  prop.load(input);
		  browser = prop.getProperty("browser");
		  url = prop.getProperty("url");
		  
		  }catch(IOException e) {
			  e.printStackTrace();
		  }
	  }
	  
	   public static WebDriver init () {
		  
			   System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
			   driver = new ChromeDriver();
		  
		   
		  
		   driver.get(url);
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	   }

   
	
		/*
		 * public static void teardown() { driver.close(); driver.quit(); }
		 */
	
}
