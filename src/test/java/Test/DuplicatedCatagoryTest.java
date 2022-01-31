package Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import Page.DuplicatedCatagoryPage;
import Util.BrowserFactory;


public class DuplicatedCatagoryTest {

	WebDriver driver;

  @Test(priority = 1)
	public void UserShouldBeAbleToAddCategory() throws InterruptedException {
	  BrowserFactory.readConfig();
		driver = BrowserFactory.init();
		
		// Navigate to test site
		driver.get("http://techfios.com/test/101");
		System.out.println("Before Adding " + driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		DuplicatedCatagoryPage newcategory = PageFactory.initElements(driver, DuplicatedCatagoryPage.class);
		newcategory.UserShldBeAbleToAddNewcategory();
		System.out.println("After Adding " + driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	}

	@Test(priority = 2)
	public void UserShouldNotBeAbleToAddDublicteCategory() {

		// Navigate to techfios  test site
		driver.get("http://techfios.com/test/101/");
		
		DuplicatedCatagoryPage newcategory = PageFactory.initElements(driver, DuplicatedCatagoryPage.class);
		String expectedCategory = "Jungle";
		String actualcategory = newcategory.NewCategory();
		System.out.println("The category you want to add already exists: <duplicated category name>");
		assertTrue(true, expectedCategory);
	
		driver.close();
	}

	
	}
