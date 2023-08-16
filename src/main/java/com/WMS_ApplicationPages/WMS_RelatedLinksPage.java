package com.WMS_ApplicationPages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.WMS_Utilities.WMS_WebDriverUtilities;



public class WMS_RelatedLinksPage extends WMS_WebDriverUtilities {

	WebDriverWait wait;
	WebDriver driver;
	String batchNo;

	public WMS_RelatedLinksPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	///////////////////////////////////////////////// PAGE OBJECTS
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	
	
	@FindBy(xpath = "//*[contains(text(),' Order line : ')]")
	public WebElement verifyOLElement;
	
	@FindBy(xpath = "//*[contains(text(),'Order Lines')]/ancestor::div[@class='popover-content sc-ion-popover-md']/descendant::a[1]")
	public WebElement clickOrdersLineElement;
	
	@FindBy(xpath = "//*[text()='Item ']/ancestor::filter-field-header/following-sibling::ion-row/descendant::ion-input/input")
	public WebElement enteritemsearch;
	
	@FindBy(xpath = "//*[text()='Order ']/ancestor::filter-field-header/following-sibling::ion-row/descendant::ion-input/input")
	public WebElement enterOrdersearchOLElement;
	
	@FindBy(xpath = "//*[contains(text(),' Item : ')]/ancestor::div[contains(@tabindex,'0')]/descendant::a[@class='link-label card-column ng-star-inserted'][3]")
	public WebElement getitemOneElement;

	@FindBy(xpath = "//*[contains(text(),' Item : ')]/ancestor::div[contains(@tabindex,'-1')]/descendant::a[@class='link-label card-column ng-star-inserted'][3]")
	public WebElement getitemSecoundElement;

	


	///////////////////////////////////////////////// PAGE Methods
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////


	
	public void clickOrdersLine() throws InterruptedException {

		try {
			new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(clickOrdersLineElement));
			clickElement(clickOrdersLineElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickOrdersLineElement);
		}
	new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(verifyOLElement));
	}

	public String getOlineByOrder(String Ordernumber) throws InterruptedException {
		WaitforPage(5000);
		WebElement allocatedElement1 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')][1]/descendant::span[@class='field-value ng-star-inserted'][2]"));

		String orderline = getText(allocatedElement1);

		System.out.println(orderline);

		return orderline;
	}
	
	public void itemOrdLinesearch(String batchNo) throws InterruptedException {
		
		WaitforPage(2000);
		try {
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(enteritemsearch));
			enterText(enteritemsearch, batchNo);
			pressEnterKey(enteritemsearch);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", enteritemsearch);
		}
		pressEnterKey(enteritemsearch);
		
	}
	
public void OrdLinesearchOrd(String batchNo) throws InterruptedException {
		
		WaitforPage(2000);
		try {
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(enterOrdersearchOLElement));
			enterText(enterOrdersearchOLElement, batchNo);
			pressEnterKey(enterOrdersearchOLElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", enterOrdersearchOLElement);
		}
		pressEnterKey(enterOrdersearchOLElement);
		
	}

public String getitemNumber1() { 
	String batchNo = getText(getitemOneElement);
	System.out.println("item Number is :" + batchNo);
	return batchNo;
	} 
public String getitemNumber2() {
	String batchNo = getText(getitemOneElement);
	System.out.println("item Number is :" + batchNo);
	return batchNo; 
	}
	
}