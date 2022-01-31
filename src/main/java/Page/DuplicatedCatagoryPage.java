package Page;


import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class DuplicatedCatagoryPage {

	WebDriver driver;

	// Each page must have a constructor in order to invite the driver
	public DuplicatedCatagoryPage(WebDriver driver) {
		this.driver = driver;
	}

	// Elements Library
	@FindBy(how = How.NAME, using = "categorydata")
	WebElement addNewCatagery;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[2]")
	WebElement addCategoryButton;

	public void UserShldBeAbleToAddNewcategory() throws InterruptedException {
		Random rnd = new Random();
		int Num = rnd.nextInt(21);
		addNewCatagery.sendKeys("Jungle" + Num);
		addCategoryButton.click();
	}
	
	public String NewCategory() {
		return driver.getTitle();
	}
}
