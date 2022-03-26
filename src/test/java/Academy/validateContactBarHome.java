package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandinPageRepository;
import pageObjects.loginPageRepository;
import resources.base;

public class validateContactBarHome extends base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initializa() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("driver is initialized and landed to webpage");
	}

	@Test
	public void homePageNavigation() throws IOException
	{
	LandinPageRepository L = new LandinPageRepository(driver);
		Assert.assertTrue(L.getContact().isDisplayed());
		log.info("Successfully validated element displayed");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

		
		
		
	
}
