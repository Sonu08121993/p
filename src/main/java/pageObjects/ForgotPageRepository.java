package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPageRepository {

	public WebDriver driver;
public ForgotPageRepository(WebDriver driver) 
{
		this.driver=driver;
}

By Email = By.id("user_email");
By SendMeInstruction = By.cssSelector("input[type='submit']");


public WebElement Email()
{
	return driver.findElement(Email);
}

public WebElement SendMeInstruction()
{
	return driver.findElement(SendMeInstruction);
}






}