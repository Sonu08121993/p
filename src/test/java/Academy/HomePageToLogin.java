package Academy;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Alpha.Demo;
import pageObjects.ForgotPageRepository;
import pageObjects.LandinPageRepository;
import pageObjects.loginPageRepository;
import resources.base;

public class HomePageToLogin extends base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initializa() throws IOException
	{
		driver=initializeDriver();
		log.info("driver is initialized");
		
	}

	@Test(dataProvider="getData")
	public void homePageNavigation(String Username,String Password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
		
		LandinPageRepository L = new LandinPageRepository(driver);
		
		loginPageRepository l=L.getLogin();
		log.info("Successfully landed to webpage"); 
		l.Email().sendKeys(Username);
		l.Password().sendKeys(Password);
		l.Submit().click();
		
		log.info("Successfully submited username and password");
		ForgotPageRepository fp = l.ForgotPassword();
		fp.Email().sendKeys("hh");
		fp.SendMeInstruction().click();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test shouild run
		//Column stands for how many values stands for each test
		Object[][] data = new Object[2][2];
		
		data[0][0] = "non restricted user";
		data[0][1] = "123456";
		
		
		data[1][0] = "restricted user";
		data[1][1] = "7879456";
		
		
		return data;	
	}
		
	@AfterTest
	public void teardown()
	{
		driver.close();
	}	
		
		
	
}
