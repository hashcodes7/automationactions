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

public class WMS_ASNPage extends WMS_WebDriverUtilities {

	WebDriverWait wait;
	WebDriver driver;

	public WMS_ASNPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/////////////////////////////////////////////////  PAGE OBJECTS  //////////////////////////////////////////////////////////////	

	@FindBy(xpath="//span[@title='ASN']/following-sibling::ion-button")
	public WebElement ASNSearchElementExpand;
	
	@FindBy(xpath="//span[@title='ASN']/parent::filter-field-header/parent::div//ion-input/input")
	public WebElement ASNSearchElement;

	@FindBy(xpath="//*[@class='dm-flex-col-layout dm-fill-space card-column ng-star-inserted'][1]/*[@class='dm-flex-row-layout field-row ng-star-inserted'][1]")
	public WebElement ASNElement;

	@FindBy(xpath="//*[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']")
	public WebElement ASNInTransitElement;
	
	@FindBy(xpath="//datatable-body/datatable-selection/datatable-scroller")
	public WebElement ASNTableBody;
	
	@FindBy(xpath="//datatable-header/div/div[@class='datatable-row-center ng-star-inserted']")
	public WebElement ASNTableHeader;
	
	
	@FindBy(xpath="//button[@class='clear-button hvr-radial-out'][2]")
	public WebElement relatedLinksElement;

	@FindBy(xpath="//button[@id='wmMobile']")
	public WebElement wmMobileElement;
	
	@FindBy(xpath="//*[contains(text(),'ASNs')]")
	public WebElement menuAsnElement;
	
	@FindBy(xpath="//*[contains(text(),' Print Variance ')]/ancestor::ion-col[@class='footer-padding-bottom ion-float-right md hydrated']/descendant::ion-button[2]")
	public WebElement clickVeryAsnElement;
	
	@FindBy(xpath="//*[contains(text(),'ILPNs')]")
	public WebElement menuILPNsElement;


	@FindBy(xpath="//*[@class='ng-star-inserted item md in-list ion-focusable hydrated'][2]")
	public WebElement lpnElement;

	@FindBy(xpath="//div[@title='In Receiving']")
	public WebElement ASNInReceivingElement;
	
	@FindBy(xpath="//*[@class='dm-flex-row-layout dm-fill-space card-row primary']")
	public WebElement asnRecordElement;
	
	@FindBy(xpath="//*[@class='more-button ng-star-inserted md button button-solid ion-activatable ion-focusable hydrated']")
	public WebElement hamburgerElement;

	@FindBy(xpath="//button[@class='action-button ng-star-inserted'][14]")
	public WebElement verifyAsnElement;
	
	@FindBy(xpath="//*[text()=' Verify ']")
	public WebElement verifyBtnElement;
	
	@FindBy(xpath="//div[@title='Verified']")
	public WebElement asnVerifiedElement;
	
	@FindBy(xpath="//*[contains(text(),' Shipped quantity : ')]/ancestor::div[@class='dm-flex-row-layout field-row ng-star-inserted']/descendant::span[@class='field-value ng-star-inserted']")
	public WebElement cmpleteshipElement;
	
	@FindBy(xpath="//*[@class='toast positive-toast']")
	public WebElement toastMsgElement;
	
	@FindBy(xpath="//*[@class='refresh-button navbar-icons-button ng-star-inserted md button button-clear ion-activatable ion-focusable hydrated']")
	public WebElement refreshElement;
	
	@FindBy(xpath = "//*[text()='Verify ASN']")
	public WebElement clickverify;
	
	@FindBy(xpath="//*[contains(text(),' Item : ')]/ancestor::div[contains(@class,'dm-flex-row-layout dm-fill-space')][@tabindex='0']/descendant::a")
    public WebElement itemReceiptElement1;
    
    @FindBy(xpath="//*[contains(text(),' Item : ')]/ancestor::div[contains(@class,'dm-flex-row-layout dm-fill-space')][@tabindex='-1']/descendant::a")
    public WebElement itemReceiptElement2;

	/////////////////////////////////////////////////  PAGE Methods  //////////////////////////////////////////////////////////////

	public String verifyShippedQty() throws InterruptedException {

		WaitforPage(2000);

		String text = getText(cmpleteshipElement);



		return text;

		
	}
	public void enterAsnSearch(String Asn) {
		
		try {
				
				//clickElement(ASNSearchElementExpand);
				if (ASNSearchElementExpand.isDisplayed()) {
				
				new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(ASNSearchElement));
				}else {
				clickElement(ASNSearchElementExpand); 
				new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(ASNSearchElement));
				//clickElement(ASNSearchElement);
				}	
			
		} catch (Exception e) {
			System.out.println("Connection Lag exception");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ASNSearchElementExpand);
			js.executeScript("arguments[0].click();", ASNSearchElement);
		}
		
				    
		enterText(ASNSearchElement,Asn);
		pressEnterKey(ASNSearchElement);
		pressEnterKey(ASNSearchElement);
				
	}
	
	public void clickVeriFyBtninsideThreeDots() throws InterruptedException {

		
	try {
		new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(clickVeryAsnElement));
		clickElement(clickVeryAsnElement);
	} catch (Exception e) {
		test.log(Status.INFO, "Note : The menu is not in the visible range");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickVeryAsnElement);
	}
	WaitforPage(8000);
}
	
	public void clickCloseBtn() throws InterruptedException {

		WaitforPage(4000);	

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.querySelector(\"#ion-overlay-19 > div > verify-popup > ion-header > ion-toolbar > ion-title > ion-icon\").click();");

		
		WaitforPage(4000);
	}
	
	
	public void clickVryASNbutton(ExtentTest test) throws InterruptedException {

		WaitforPage(2000);
		try {
			new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(clickverify));
			clickElement(clickverify);
		} catch (Exception e) {
			test.log(Status.INFO, "Note : The menu is not in the visible range");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickverify);
		}

	}
    
	public void asnStatusBeforeReceiving() {
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(ASNInTransitElement));
		String asnStatus=ASNInTransitElement.getText();
		System.out.println("Asn is in"+" "+asnStatus+" "+"status");
	}

	
	public void asnStatusAfterReceiving() {
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(ASNInReceivingElement));
		String asnStatus=ASNInReceivingElement.getText();
		System.out.println("Asn is in"+" "+asnStatus+" "+"status");
	}
	
	public void asnStatusAfterVerified() {
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(asnVerifiedElement));
		String asnStatus=asnVerifiedElement.getText();
		System.out.println("Asn is in"+" "+asnStatus+" "+"status");
	}
	
	public void selectAsnRecord() {
		try {
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(asnRecordElement));
			clickElement(asnRecordElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", asnRecordElement);
		}
	
	}
	
	public void selectHamburgerOption() {
		try {
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(hamburgerElement));
			clickElement(hamburgerElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", hamburgerElement);
		}
	
	}
	
	public void clickVerifyAsnBtn() {
		try {
			clickElement(verifyAsnElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", verifyAsnElement);
		}
	
	}
	
	public void clickVerifyBtn() {
		try {
			new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(verifyBtnElement));
			clickElement(verifyBtnElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", verifyBtnElement);
		}
		
	
	}

	public void selectRelatedLinks(String relatedLink) {
		try {
			new WebDriverWait(driver,80).until(ExpectedConditions.visibilityOf(relatedLinksElement));
			clickElement(relatedLinksElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", relatedLinksElement);
		}

	}

	public void selectLnpFromRelatedLinks() {
		try {
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(lpnElement));
			clickElement(lpnElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", lpnElement);
		}
	
	}
	public void asnSelectMenu() {
		try {
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(menuAsnElement));
			clickElement(menuAsnElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", menuAsnElement);
		}
	
	}
	
public String receipitem1() throws InterruptedException {
        
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(itemReceiptElement1));
        String taskNo1 = getText(itemReceiptElement1);
        System.out.println("item id is 1: "+taskNo1);
        return taskNo1;
    }



   public String receipitem2() {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(itemReceiptElement2));
        String taskNo = getText(itemReceiptElement2);
        System.out.println("item ID is 2: "+taskNo);
        return taskNo;
    }

	public void ilpnsSelectMenu() {
		try {
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(menuILPNsElement));
			clickElement(menuILPNsElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", menuILPNsElement);
		}
	
	}


	public void clickWmMobileBtn() throws InterruptedException {

		try {
			new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(wmMobileElement));
			clickElement(wmMobileElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", wmMobileElement);
		}
		switchToWindows();
		
	}
	
	
	public void verifyToastMsg() {
	String message=	getText(toastMsgElement);
	System.out.println(message);
		
	}
	
	public void clickRefresh() {
		try {
			Thread.sleep(500);
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(refreshElement));
			clickElement(refreshElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", refreshElement);
		}
		
	}



}
