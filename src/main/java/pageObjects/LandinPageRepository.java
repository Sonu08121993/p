package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandinPageRepository {

	public WebDriver driver;
	
public LandinPageRepository(WebDriver driver) 
{
		this.driver=driver;
}

private By Login = By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
private By Title = By.cssSelector("div[class='text-center'] h2");
private By Contact = By.linkText("CONTACT");
private By Header = By.cssSelector(".video-banner h3");

public loginPageRepository getLogin()
{
	 driver.findElement(Login).click();
	 return new loginPageRepository(driver);
 
}

public WebElement getTitle()
{
	return driver.findElement(Title);
}

public WebElement getContact()
{
	return driver.findElement(Contact);
}

public WebElement getHeader()
{
	return driver.findElement(Header);
}



}