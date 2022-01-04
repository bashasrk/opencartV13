package testCases;

// Adding sample comment

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {

		
	@Test(groups= {"regression","master"})
	public void test_account_Registration() throws IOException
	{
		logger.info("Starting TC_001_AccountRegistration");
		
		logger.debug("Capturing debug logs.....");
		
		logger.info("Opening app URL.....");
		
		driver.get(rb.getString("appURL")); // Get URL from config.properties file
		
		driver.manage().window().maximize();
		
		
		HomePage hp=new HomePage(driver);
		logger.info("Clicking on MyAccount link.....");
		hp.clickMyAccount();
		
		logger.info("Clicking on Register link.....");
		hp.clickRegister();
		
		logger.info("Providing user details.....");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName("John");
		logger.info("Provided First Name ");
		
		regpage.setLastName("Canedy");
		logger.info("Provided Last Name ");
		
		regpage.setEmail(randomestring()+"@gmail.com");
		logger.info("Provided Email ");
		
		regpage.setTelephone("65656565");
		logger.info("Provided Telephone ");
		
		regpage.setPassword("abcxyz");
		logger.info("Provided Password ");
		
		regpage.setConfirmPassword("abcxyz");
		logger.info("Provided Confrmed Password ");
		
		regpage.setPrivacyPolicy();
		logger.info("Set Privacy Policy ");
		
		regpage.clickContinue();
		logger.info("Clicked on Continue ");
		
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account Registration Success ");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "test_accout_Registration"); 
			logger.error("Account Registration Failed ");
			Assert.assertTrue(false);
		}
				
		logger.info(" Finished TC_001_AccountRegistration ");
	}
		
}
