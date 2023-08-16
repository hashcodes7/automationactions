package com.WMS_ApplicationPages;


import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class WMS_SystemManagementPage extends WMS_WebDriverUtilities {

	WebDriverWait wait;
	WebDriver driver;

	public WMS_SystemManagementPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/////////////////////////////////////////////////  PAGE OBJECTS  //////////////////////////////////////////////////////////////	

	
	@FindBy(xpath = "//*[text()='System Management']")
	public WebElement clickSysMgntElement;
	
	@FindBy(xpath = "//*[text()='Tranlog Details']")
	public WebElement clickTranlogDetailsElement;
	
	
	@FindBy(xpath = "//*[text()=' Status : ']/ancestor::div[@class='dm-flex-row-layout field-row ng-star-inserted']/descendant::span")
	public WebElement clickTranlogFirstElement;
	
	@FindBy(xpath ="//*[contains(text(),'Message Type ')]/ancestor::ngx-datatable/descendant::div[@class='datatable-body-cell-label'][1]/child::label[1]")
	public WebElement clickTranlogElement;
	
	@FindBy(xpath = "//*[text()='VIEW PAYLOAD ']")
	public WebElement clickViewElement;
	
	@FindBy(xpath = "//*[text()=' Close ']")
	public WebElement clickClosePaybtn;
	
	@FindBy(xpath="//*[text()='Location Barcode ']/ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement locationSearchBarElement;

	@FindBy(xpath="//*[text()='STORAGE']/ancestor::ion-item/descendant::ion-button")
	public WebElement recordExpandBarElement;

	@FindBy(xpath="//*[@class='ng-star-inserted item md in-list ion-focusable hydrated'][2]")
	public WebElement lpnElement;
	
	
	@FindBy(xpath = "//*[@id='inventory']")
	public WebElement inventoryElement;
	
	@FindBy(xpath = "//button[@class='jsoneditor-compact']")
	public WebElement clickWhitespaceElement;
	
	
	@FindBy(xpath = "div[class=' ace_editor ace-jsoneditor']")
	public WebElement getMessageElement;
	
	@FindBy(xpath = "//*[text()=' Yes ']")
	public WebElement clickYesStatusElement;
	
	@FindBy(xpath = "//*[text()='BOOK COUNT ']")
	public WebElement clickBookElement;
	
	@FindBy(xpath = "//*[text()='Count:']/ancestor::div[@class='dm-flex-col-layout card-column dm-fill-space']/descendant::span[2]")
	public WebElement getUnitElement;
	
	@FindBy(xpath = "//*[text()='Inventory Count']")
	public WebElement btninventryCount;
	
	@FindBy(xpath = "//*[text()=' Status : ']/ancestor::div[@class='dm-flex-row-layout field-row ng-star-inserted']/descendant::span")
	public WebElement clickStatusRecord;
	

	@FindBy(xpath = "//*[text()=' Status : ']/ancestor::div[@class='dm-flex-row-layout field-row ng-star-inserted']/descendant::span[2]")
	public WebElement inventoryStatusElement;
	
	
	@FindBy(xpath = "//*[text()='Location ']/ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement locIDSearchElement;
	
	@FindBy(xpath = "//div[contains(@class,'switch-icon icon-background grid')]")
	public WebElement GridViewButton;
	
	@FindBy(xpath = "//*[text()='Search ']/ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement tranlogSearchElement;
	
	@FindBy(xpath = "//*[text()='Message Type ']/ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement messagePayElement;
	
	@FindBy(xpath = "//div[@class=' ace_editor ace-jsoneditor']")
	public WebElement innerText;
	
	
	
	@FindBy(xpath="//input[@data-component-id='acceptquantity_naturalquantityfield_units']")
	public WebElement enterQtyElement;
	
/////////////////////////////////////////////////  PAGE Methods  //////////////////////////////////////////////////////////////

	public void enterTranlogToteIDSearch(String menuSearch) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(tranlogSearchElement));
		enterText(tranlogSearchElement, menuSearch);



		}
	
	public void enterMesgPaySearch(String menuSearch) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(messagePayElement));
		enterText(messagePayElement, menuSearch);
		pressTabKey(messagePayElement);



		}
	
	public void clickSystemMgmtBtn() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(clickSysMgntElement));
			clickElement(clickSysMgntElement);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickSysMgntElement);
		
		}

	}
	
	public void clickTranlogDetailsBtn() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(clickTranlogDetailsElement));
			clickElement(clickTranlogDetailsElement);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickTranlogDetailsElement);
		}
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(GridViewButton));
	}
	
	
	
	public void clickTranFirstRecordBtn() throws InterruptedException {
		
		 try { 
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickTranlogFirstElement));
			clickElement(clickTranlogFirstElement);
			
			  } catch (Exception e) {
				  System.out.println("inside menu toggle method");
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("arguments[0].click();", clickTranlogFirstElement); }
			 
	}
	
	public void clickTranRecordBtn() throws InterruptedException {
		
		 try { 
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickTranlogElement));
			clickElement(clickTranlogElement);
			
			  } catch (Exception e) {
				  System.out.println("inside menu toggle method");
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("arguments[0].click();", clickTranlogElement); }
			 
	}
		
	public void clickPayLoadBtn() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(clickViewElement));
			clickElement(clickViewElement);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickViewElement);
		}

	}
	
	public void clickPayCloseBtn() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(clickClosePaybtn));
			clickElement(clickClosePaybtn);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickViewElement);
		}

	}
public String getTextMessage() {
		
		String taskGroupNo = getText(getMessageElement);
		System.out.println("Task Group Number is: "+taskGroupNo);
		
		return taskGroupNo;
	}

public void clickPayLoadlineBtn() {
	try {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(clickWhitespaceElement));
		clickElement(clickWhitespaceElement);
		
	} catch (Exception e) {
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickWhitespaceElement);
	}

}
public void clicklinebtn() throws InterruptedException {

	WaitforPage(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.querySelector(\"button[title='Compact JSON data, remove all whitespaces (Ctrl+Shift+I)']\").click();");
		WaitforPage(4000);

	}
public String getInnerTextMessage() throws InterruptedException {

	WaitforPage(4000);

	JavascriptExecutor js = (JavascriptExecutor) driver;

	String innerTxt = (String) js
			.executeScript("return document.querySelector(\".ace_editor.ace-jsoneditor\").innerText;");
	WaitforPage(4000);
	return innerTxt;

}


public void bulkRfreshPage(WMS_DashboardPage dashboardPage) throws InterruptedException {
	
	dashboardPage.clickRefresh();

	WaitforPage(3000);

	dashboardPage.clickRefresh();
	
	WaitforPage(3000);
	
	dashboardPage.clickRefresh();

	WaitforPage(3000);

	
	  dashboardPage.clickRefresh();
	  
	  dashboardPage.clickRefresh();
	  
		/* WaitforPage(3000); */
	  
		/*
		 * dashboardPage.clickRefresh();
		 * 
		 * WaitforPage(3000);
		 * 
		 * dashboardPage.clickRefresh();
		 * 
		 * WaitforPage(3000);
		 * 
		 * dashboardPage.clickRefresh();
		 * 
		 * WaitforPage(3000);
		 * 
		 * dashboardPage.clickRefresh(); WaitforPage(3000);
		 * 
		 * 
		 * dashboardPage.clickRefresh(); WaitforPage(3000);
		 * 
		 * dashboardPage.clickRefresh(); WaitforPage(3000);
		 * 
		 * dashboardPage.clickRefresh();
		 */
}

}




	