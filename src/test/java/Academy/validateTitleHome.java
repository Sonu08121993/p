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

public class validateTitleHome extends base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	LandinPageRepository L;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("driver is initialized");
		
	}

	@Test
	public void validateTitle() throws IOException
	{
		L= new LandinPageRepository(driver);
		Assert.assertEquals(L.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated text message");
	}
	
	@Test
	public void validateHeader() throws IOException
	{
		L= new LandinPageRepository(driver);
		Assert.assertEquals(L.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Successfully validated header message");
	}
	

	
@AfterTest
public void teardown()
{
	driver.close();
	driver=null;
}
		
		
		
	
}
