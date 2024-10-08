package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	//WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	WebElement myaccountlinkClick;
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement registerBtnClick;
	
	
	public void myAccount()
	{
		myaccountlinkClick.click();
	}
	
	public void register()
	{
		registerBtnClick.click();
	}
	

}
