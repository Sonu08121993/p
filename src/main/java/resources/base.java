package resources;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		//System.getProperty("user.dir)-->it is used that to use the path operates in every machine
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
	    prop.load(fis);
	    
	    //mvn test -Dbrowser=chrome
	    //String browserName=System.getProperty("browser");//if we use this instead of prop.getProperty the system will go and check
	    //mvn test command shown above and execute that browser instead of going to data.properties file and search browser.
	    //The advantage of doing this is business people don't need to go and change browser in data.properties. they can
	    //easily excecute different browser from maven command in jenkins.
	    
	    
	   String browserName = prop.getProperty("browser");
	   System.out.println(browserName);
	
	if(browserName.contains("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		if(browserName.contains("headless"))//add another parameters in jenkins..and for cmd mvn test -Dbrowser=chromeheadless
		{
		options.addArguments("--headless");
		}
        driver = new ChromeDriver(options);
	}
	else if(browserName.equals("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\driver\\geckodriver.exe");
        driver = new FirefoxDriver();
	}
	else if(browserName.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\driver\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	
	}
	
	public String getscreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcs = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+ "\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(srcs,new File(destinationFile));
		
		return destinationFile;// this step is done for attching screenshot path in local machine and push in extent report for
		//attaching screenshot 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
