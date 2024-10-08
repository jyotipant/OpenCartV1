package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.HomePage;
import pageObjects.AccountCreationPage;

public class TC001_AccountRegistrationTest extends BaseClass
{

	@Test
	public void verify_account_registration()	
	{
		
		logger.info("Start of the first test case");
		HomePage hp= new HomePage(driver);
		logger.info("clicking on Myaccount");
		hp.myAccount();
		hp.register();
		
		AccountCreationPage create=new AccountCreationPage(driver);
		create.setFirstName(randomString().toUpperCase());
		create.setLastName(randomString().toUpperCase());
		create.setEmail(randomString()+"@gmail.com");
		create.setTelephone(randomNumber());
		
		String passwrd=randomAlphaNumeric();
		
		String actualpwd=create.setPassword(passwrd);
		String cnfirmpwd=create.setConfirmPwd(passwrd);
		
		create.setCheckbox();
		logger.info("click on save button");
		create.setContinue();
		
		Assert.assertEquals(actualpwd, cnfirmpwd);
		
		String validateMessage=create.confirmationMessage();
	/*	if(validateMessage.equals("Your Account has Been Created!"))
		{
			Assert.assertTrue(false);
		}
		else
		{
			logger.error("Test failed");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		
		Assert.assertEquals(validateMessage, "Your Account has Been Created!");
		} */
		
	}
		//logger.info("test case has been completed");
	}
	
	
		
		


