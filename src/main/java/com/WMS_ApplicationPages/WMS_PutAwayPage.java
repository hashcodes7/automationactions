package com.WMS_ApplicationPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WMS_Utilities.WMS_WebDriverUtilities;

public class WMS_PutAwayPage extends WMS_WebDriverUtilities{


	WebDriver driver;

	public WMS_PutAwayPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/////////////////////////////////////////////////  PAGE OBJECTS  //////////////////////////////////////////////////////////////

	@FindBy(xpath="//*[text()='LEVI Make Put Cart']")
	public WebElement leviMakePutCartElement;


	@FindBy(xpath="//*[@type='text' and @placeholder='Cart ID']")
	public WebElement scanCartIdElement;

	@FindBy(xpath="//*[text()='Go']")
	public WebElement goElement;

	@FindBy(xpath="//*[@placeholder='Scan Container']")
	public WebElement scanContainerElement;

	@FindBy(xpath="//*[text()='End Cart']")
	public WebElement endCartElement;

	@FindBy(xpath="//*[@type='text' and @placeholder='Scan Location']")
	public WebElement scanLocationElement;

	@FindBy(xpath="//*[@class='value md hydrated' and @data-component-id='acceptlocationforputcart_barcodetextfield_location']")
	public WebElement scanLocationIdElement;

	@FindBy(xpath="//*[@type='text' and @placeholder='Scan Item']")
	public WebElement scanItemElement;

	@FindBy(xpath="//*[text()='Confirm']")
	public WebElement confirmElement;

	@FindBy(xpath="//input[@type='tel']")
	public WebElement availableQtyElement;


	/////////////////////////////////////////////////  PAGE Methods  //////////////////////////////////////////////////////////////


	public void clickLeviMakePutCart() {
		try {
			clickElement(leviMakePutCartElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", leviMakePutCartElement);
		}

	}

	public void clickConfirmBtn() {
		try {
			new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(confirmElement));
			clickElement(confirmElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", confirmElement);
		}

	}

	public void scanCartId(String cartId) {

		enterText(scanCartIdElement,cartId);

	}

	public void clickGoBtn() throws InterruptedException {

		try {
			clickElement(goElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", goElement);
		}
	}

	public void scanContainerId(String containerId) throws InterruptedException {
		new WebDriverWait(driver,50).until(ExpectedConditions.visibilityOf(scanContainerElement));
			enterText(scanContainerElement,containerId);
			Thread.sleep(1000);	
	}


	public void scanItemId(String itemId) {

		enterText(scanItemElement,itemId);

	}



	public void clickEndCartBtn() {

		try {
			new WebDriverWait(driver,120).until(ExpectedConditions.visibilityOf(endCartElement));
			clickElement(endCartElement);
			new WebDriverWait(driver,300).until(ExpectedConditions.visibilityOf(confirmElement));
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", endCartElement);
			new WebDriverWait(driver,300).until(ExpectedConditions.visibilityOf(confirmElement));
		}

	}



	public void enterLocationID() {
		new WebDriverWait(driver,50).until(ExpectedConditions.visibilityOf(scanLocationIdElement));
		String text= getText(scanLocationIdElement);

		String LocationIdText=text.replaceAll("\\-", "");

		System.out.println(LocationIdText);

		enterText(scanLocationElement,LocationIdText);

	}


	public void getAvailableQty() {
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(availableQtyElement));
		String text= getText(availableQtyElement);
		System.out.println("Available item quantity is :"+text);
		pressEnterKey(availableQtyElement);
	}







}
