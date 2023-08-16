package com.WMS_ApplicationPages;

import java.util.List;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;





public class WMS_ItemPage extends WMS_WebDriverUtilities {
	WebDriverWait wait;
	WebDriver driver;
	
	public WMS_ItemPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
/////////////////////////////////////////////////  PAGE OBJECTS  //////////////////////////////////////////////////////////////	

	@FindBy(xpath="//span[@title='Item ID']/parent::filter-field-header/ion-button")
	public WebElement ItemSearchElementExpand;
	
	@FindBy(xpath="//span[@title='Item ID']/parent::filter-field-header/following-sibling::ion-row/*//input")
	public WebElement ItemSearchElement;
	
	@FindBy(xpath="//datatable-body/datatable-selection/datatable-scroller")
	public WebElement ItemTableBody;
	
	@FindBy(xpath="//datatable-header/*//div[@class='datatable-row-center ng-star-inserted']")
	public WebElement ItemTableHeader;
	
	@FindBy(xpath = "//*[text()='Items']")
	public WebElement btnitem;
	
	@FindBy(xpath = "//*[text()='Item ID ']/ancestor::filter-field-header/following-sibling::ion-row/descendant::ion-input/input")
	public WebElement enteritemsearch;
	
	@FindBy(xpath="//span[@title='Item ID']/following-sibling::ion-button")
	public WebElement enteritemsearchExpand;
	
	@FindBy(xpath = "//*[text()=' Related Links ']")
	public WebElement btnitemRelatedLinks;
	
	@FindBy(xpath = "//*[text()=' Primary Barcode : ']/ancestor::div[@class='dm-flex-row-layout field-row ng-star-inserted']/descendant::span[2]")
	public WebElement itembarElement;
	
	@FindBy(xpath="//span[@title='ILPN']/following-sibling::ion-button")
	public WebElement LPNSearchElementExpand;
	
	@FindBy(xpath = "//*[text()=' Primary Barcode : ']/ancestor::div[@tabindex='0']/descendant::span[8]")
	public WebElement itembarElement1;
	
	@FindBy(xpath = "//*[text()=' Primary Barcode : ']/ancestor::div[@tabindex='-1']/descendant::span[8]")
	public WebElement itembarElement2;
	
	@FindBy(xpath = "//*[text()=' Item ID : ']/ancestor::div[@tabindex='0']/descendant::span[2]")
	public WebElement itemElement1;
	
	@FindBy(xpath = "//*[text()=' Item ID : ']/ancestor::div[@tabindex='-1']/descendant::span[2]")
	public WebElement itemElement2;
		
	
	
/////////////////////////////////////////////////  PAGE Methods  //////////////////////////////////////////////////////////////

public void enterItemSearch(String ItemID) {
		
		try {
			
			//new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(ASNSearchElement));
			clickElement(ItemSearchElementExpand);
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(ItemSearchElement));
			clickElement(ItemSearchElement);			
			
		} catch (Exception e) {
			System.out.println("Connection Lag exception");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ItemSearchElementExpand);
			js.executeScript("arguments[0].click();", ItemSearchElement);
		}		
				    
		enterText(ItemSearchElement,ItemID);
		pressEnterKey(ItemSearchElement);
			
				
	}
public void clickitembutton() {
	try {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(btnitem));
		clickElement(btnitem);
	} catch (Exception e) {
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnitem);
	}

}

public void itemsearch(String batchNo) throws InterruptedException {
	
	WaitforPage(2000);
	try {
		if (enteritemsearchExpand.isDisplayed()) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(enteritemsearch));
		}else {
			clickElement(enteritemsearchExpand);	
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(enteritemsearch));
		}
		enterText(enteritemsearch, batchNo);
		pressEnterKey(enteritemsearch);
	} catch (Exception e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", enteritemsearch);
	}
	pressEnterKey(enteritemsearch);
	
}
	


public String getitemparcode() {
	new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(itembarElement));
	String taskNo = getText(itembarElement);
	System.out.println("Primary code is: "+taskNo);
	return taskNo;
}

public String multisgetitem1() {
	new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(itemElement1));
	String taskNo = getText(itemElement1);
	System.out.println("item ffirst is 1: "+taskNo);
	return taskNo;
}

public String multisgetitem2() {
	new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(itemElement2));
	String taskNo = getText(itemElement2);
	System.out.println("item secound  is 2: "+taskNo);
	return taskNo;
}

public String multisgetitemparcode1() {
	new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(itembarElement1));
	String taskNo = getText(itembarElement1);
	System.out.println("Primary code is 1: "+taskNo);
	return taskNo;
}

public String multisgetitemparcode2() {
	new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(itembarElement2));
	String taskNo = getText(itembarElement2);
	System.out.println("Primary code is 2: "+taskNo);
	return taskNo;
}
public void clickitemRKs() {
	try {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(btnitemRelatedLinks));
		clickElement(btnitemRelatedLinks);
	} catch (Exception e) {
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnitemRelatedLinks);
	}

}

public String getItemBarcodeNoBYOrdersNo(String itembardetails) throws InterruptedException {
	WaitforPage(5000);
	WebElement allocatedElement1= driver.findElement(By.xpath("//span[contains(text(),'"+itembardetails+"')]/ancestor::div[contains(@class,'dm-flex-col-layout')][1]/descendant::span[@class='field-value ng-star-inserted'][4]"));
	
	String itemNo1 = getText(allocatedElement1);
	
	
	System.out.println(itemNo1);
	
	
	return itemNo1;
  }

public String getItemoneFromTask() throws InterruptedException {
    
    new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(itemElement1));
    String taskNo = getText(itemElement1);
    System.out.println("item  is 1: "+taskNo);
    return taskNo;
    
  }



public String getItemTwoFromTask() throws InterruptedException {
    new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(itemElement2));
    String taskNo = getText(itemElement2);
    System.out.println("item  is 2: "+taskNo);
    return taskNo;
  }
}
