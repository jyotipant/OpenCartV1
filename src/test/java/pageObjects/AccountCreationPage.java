package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreationPage extends BasePage
{

	public AccountCreationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//WebDriver driver;
	

	
	@FindBy(id="input-firstname")
	WebElement firstName;
	
	@FindBy(id="input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-telephone")
	WebElement telephone;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(id="input-confirm")
	WebElement cfmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkBox;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continuebtn;
	
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement cfmMessage;
	
	public void setFirstName(String fname)
	{
		firstName.sendKeys(fname);
		
	}
	public void setLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String emailId)
	{
		email.sendKeys(emailId);
		
	}
	
	public void setTelephone(String phone)
	{
		telephone.sendKeys(phone);
		
	}
	public String setPassword(String pwd)
	{
		password.sendKeys(pwd);
		return pwd;
		
	}
	public String setConfirmPwd(String cnfPwd)
	{
		cfmPassword.sendKeys(cnfPwd);
		return cnfPwd;
		
	}
	
	public void setCheckbox()
	{
		checkBox.click();
		
	}
	public void setContinue()
	{
		continuebtn.click();
		//continuebtn.submit();
		//continuebtn.sendKeys(Keys.RETURN);
		
	}
	
	public String confirmationMessage()
	{
		try {
		return cfmMessage.getText();
		}
		catch (Exception e)
		{
			return(e.getMessage());
		}
	}
}
