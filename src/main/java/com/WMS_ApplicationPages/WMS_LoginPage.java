package com.WMS_ApplicationPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.WMS_Utilities.WMS_WebDriverUtilities;


public class WMS_LoginPage extends WMS_WebDriverUtilities{
	
	WebDriver driver;
	
	public WMS_LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void resizeWebpage() throws AWTException, InterruptedException { 
		WaitforPage(2000);
		Robot robot = new Robot(); 
		System.out.println("About to zoom out");
		for (int i = 0; i < 2; i++)	{
			robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		
				} 
		robot.keyRelease(KeyEvent.VK_CONTROL);
		}


	/////////////////////////////////////////////////  PAGE OBJECTS  //////////////////////////////////////////////////////////////

	@FindBy(xpath="//div[@alt='Logo']")
	public WebElement logoElement;

	@FindBy(xpath="//input[@id='login-username']")
	@CacheLookup
	public WebElement userNameElement;

	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	public WebElement submitUserNameElement;

	@FindBy(xpath="//input[@id='login-password']")
	@CacheLookup
	public WebElement passwordElement;

	@FindBy(xpath="//input[@class='button']")
	@CacheLookup
	public WebElement loginBtnElement;



	/////////////////////////////////////////////////  PAGE Methods  //////////////////////////////////////////////////////////////	

	
	@SuppressWarnings("unused")
	public void verifyLogoExists() {
		
		new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(logoElement));
		boolean logoVisisbility = logoElement.isDisplayed();
		
	
		if(logoVisisbility= true){
			System.out.println("Manhattan Active Supply Chain logo is displayed");
			
		}
		else {
			System.out.println("Manhattan Active Supply Chain logo is not displayed");
		
		}
	}


	public void enterUserName(String userName) {
	
		new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(userNameElement));
		enterText(userNameElement,userName);
		userNameElement.sendKeys(Keys.TAB);
	}
	
	public void clickSubmitUserName() {
		new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(submitUserNameElement));
		clickElement(submitUserNameElement);

	}

	public void enterPassword(String password) {
		new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(passwordElement));
		enterText(passwordElement,password);
	}

	public void clickLogin() {

			new WebDriverWait(driver,100).until(ExpectedConditions.visibilityOf(loginBtnElement));
			clickElement(loginBtnElement);
		
		
	}








}

