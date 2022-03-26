package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPageRepository {

	public WebDriver driver;
public loginPageRepository(WebDriver driver) 
{
		this.driver=driver;
}

By Email = By.id("user_email");

By Password = By.id("user_password");

By Submit = By.cssSelector("input[value='Log In']");

By ForgotPassword = By.cssSelector(".link-below-button");


public WebElement Email()
{
	return driver.findElement(Email);
}

public WebElement Password()
{
	return driver.findElement(Password);
}


public WebElement Submit()
{
	return driver.findElement(Submit);
}

public ForgotPageRepository ForgotPassword()
{
	 driver.findElement(ForgotPassword).click();;
	 return new ForgotPageRepository(driver);
	  
	
}







}