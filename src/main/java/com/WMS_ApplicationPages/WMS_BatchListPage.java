package com.WMS_ApplicationPages;

import java.awt.AWTException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WMS_Utilities.WMS_WebDriverUtilities;

public class WMS_BatchListPage extends WMS_WebDriverUtilities {
	WebDriver driver;
	WebDriverWait wait;

	public WMS_BatchListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	///////////////////////////////////////////////// PAGE OBJECTS
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	@FindBy(xpath = "//*[text()=' Batch : ']/following-sibling::*")
	public WebElement batchIdElement;

	@FindBy(xpath = "//*[@data-component-id='com-manh-cp-workrelease-Batch-filter-BatchId']//*")
	public WebElement batchNumberElement;

	@FindBy(xpath = "//*[@class='dm-flex-row-layout dm-fill-space card-row primary']")
	public WebElement batchRecordElement;

	@FindBy(xpath = "//*[text()='RELEASE ']")
	public WebElement releaseElement;

	@FindBy(xpath = "//*[text()=' Yes ']")
	public WebElement yesBtnElement;

	@FindBy(xpath = "//*[@class='toast positive-toast']")
	public WebElement toastMsgElement;

	@FindBy(xpath = "//*[@title='Refresh']")
	public WebElement refreshElement;

	@FindBy(xpath = "//*[text()='Batch List']")
	public WebElement btnbatch;

	@FindBy(xpath = "//ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement batchidsearch;

	@FindBy(xpath = "//ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout ng-star-inserted']/descendant::div[@class='width-45 ng-star-inserted']/*")
	public WebElement blexpandBarElement;
	
	@FindBy(xpath = "//*[text()=' Batch ID : ']")
	public WebElement clickbatchrecord;
	
	@FindBy(xpath = "//datatable-header/div/div[@class='datatable-row-center ng-star-inserted']")
	public WebElement batchTableHeader;
	
	@FindBy(xpath = "//datatable-body/datatable-selection/datatable-scroller")
	public WebElement batchTableBody;

	
	@FindBy(xpath="//button[@data-component-id='com-manh-cp-workrelease-Batch-header-panel-relatedLinks']")
	public WebElement batchrelatedLinksElement;
	
	@FindBy(xpath="//*[@class='ng-star-inserted item md in-list ion-focusable hydrated'][1]")
	public WebElement clickTaskElement;
	

	@FindBy(xpath = "//div[@data-component-id='com-manh-cp-workrelease-Batch-card-view-StatusDescription']")
	public WebElement objreadystatus;
	
	@FindBy(xpath = "//ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']/descendant::div")
	public WebElement batchTextStatus;
	
	@FindBy(xpath = "//*[text()='Item ']/ancestor::filter-field-header/following-sibling::ion-row/descendant::ion-input/input")
	public WebElement WRitemSearchElement;
	
	@FindBy(xpath = "//*[text()=' Select All Rows ']")
	public WebElement clickAllRecordElement;
	
	@FindBy(xpath = "//*[text()='Work Release Allocations']")
	public WebElement clickWRAElement;
	

	///////////////////////////////////////////////// PAGE Methods
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	public String getBatchNumber() {
		String batchNo = getText(batchIdElement);
		System.out.println("Wave Batch Number is :" + batchNo);
		return batchNo;

	}

	public void enterBatchIdSearch(String batchNo) throws InterruptedException {
		enterText(batchNumberElement, batchNo);
		try {
			clickElement(batchNumberElement);
			Thread.sleep(1000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", batchNumberElement);
		}
		pressTabKey(batchNumberElement);
		Thread.sleep(1000);
	}

	public void selectBatchRecord() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(batchRecordElement));
			clickElement(batchRecordElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", batchRecordElement);
		}

	}
	public void sysoutstatus() {
		try {
			new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(toastMsgElement));
		} catch (Exception e) {
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
		System.out.println("Allocated");
		}
	}
	public void clickReleaseBtn() {
		try {
			clickElement(releaseElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", releaseElement);
		}
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}

	public void clickYesBtn() throws InterruptedException {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(yesBtnElement));
			clickElement(yesBtnElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", yesBtnElement);
		}
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

	}
	
	

	public void verifyToastMsg() {
		String message = getText(toastMsgElement);
		System.out.println(message);

	}

	public void clickRefresh() throws InterruptedException {
		if (Display(refreshElement)) {
			try {
				clickElement(refreshElement);
				Thread.sleep(10000);
			} catch (Exception e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", refreshElement);
				Thread.sleep(10000);

			}
		}
	}

	public void batchsearch(String batchNo, WMS_DashboardPage dashboardPage) throws InterruptedException {
		
		try {

			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(batchidsearch));
			enterText(batchidsearch, batchNo);
			pressEnterKey(batchidsearch);
			pressEnterKey(batchidsearch);
			dashboardPage.clickRefresh();
			dashboardPage.clickRefresh();
			

			

		} catch (Exception e) {

			int i = 1;
			do {
				System.out.println(i);
				dashboardPage.clickRefresh();
				i++;
			} while (i <= 50);

		}

	}
		
		

	

	public void clickbatchbutton() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(btnbatch));
			clickElement(btnbatch);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", btnbatch);
		}
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}

	public void clickExpandBarbatch() throws InterruptedException {
		
WaitforPage(3000);
			try {
				
				System.out.println("expand button searched");
				new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(blexpandBarElement));
				clickElement(blexpandBarElement);
				
				System.out.println("clicked expand button");
			} catch (Exception e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", blexpandBarElement);
			}
			

		
			
		}

	
	
	public void selectonebatcRC() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickbatchrecord));
			clickElement(clickbatchrecord);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickbatchrecord);
		}
		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
}
	
	public void BatchRelatedLinks() throws InterruptedException {
		try {
			new WebDriverWait(driver,80).until(ExpectedConditions.visibilityOf(batchrelatedLinksElement));
			clickElement(batchrelatedLinksElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", batchrelatedLinksElement);
		}
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		
		}
	
	public void BatchRelatedbtn() throws InterruptedException {

	try {
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(clickTaskElement));
		clickElement(clickTaskElement);
		
		
		pressEnterKey(clickTaskElement);
	} catch (Exception e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickTaskElement);
		 
	}
	/*
	 * new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(
	 * objrelesedWRpage));
	 */
	 
	 driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
}
	
	public void batchReleaseStatus(WMS_DashboardPage dashboardPage) throws InterruptedException {
		WaitforPage(8000);
		String Status= getText(batchTextStatus); 
		System.out.println(Status);
		  
		  while(!Status.trim().equals("Released")) {
		  dashboardPage.clickRefresh(); 
		  WaitforPage(8000);
		  Status= getText(batchTextStatus); 
		  driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS); 
		  System.out.println(Status); 
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");// 333333333333333000000
			LocalDateTime now = LocalDateTime.now();
			String SerialNo = dtf.format(now).toString()+"0";
			System.out.println("Execution Time is  : "+SerialNo);
		  }
	
	}
	public void wRitemSearch(String batchNo) throws InterruptedException {
		
		WaitforPage(2000);
		try {
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(WRitemSearchElement));
			enterText(WRitemSearchElement, batchNo);
			pressEnterKey(WRitemSearchElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", WRitemSearchElement);
		}
		pressEnterKey(WRitemSearchElement);
		
	}
	public String getBatchListNoByThreeOrders(String batchIDdetails) throws InterruptedException {
		WaitforPage(5000);
		WebElement allocatedElement1= driver.findElement(By.xpath("//a[contains(text(),'"+batchIDdetails+"')]/ancestor::div[contains(@class,'dm-flex-row-layout')]/descendant::span[@class='field-value ng-star-inserted'][16]"));
		
		String itemNo1 = getText(allocatedElement1);
		
		
		System.out.println(itemNo1);
		
		
		return itemNo1;
	  }

	public void selectAllRecord() throws InterruptedException {

		WaitforPage(4000);
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickAllRecordElement));
			clickElement(clickAllRecordElement);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickAllRecordElement);
		}

	
	}
	
	public void clickWRApage() throws InterruptedException {

		WaitforPage(4000);
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickWRAElement));
			clickElement(clickWRAElement);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickWRAElement);
		}

	
	}
	public void clickExpandMultiRecords(String Ordernumber) throws InterruptedException {
		
		
			
			System.out.println("expand button searched");
			
			WebElement allocatedElement1= driver.findElement(By.xpath("//span[contains(text(),'"+Ordernumber+"')]/ancestor::div[contains(@class,'dm-flex-col-layout')][1]/ancestor::div[1]/descendant::div[contains(@class,'card-icon ng-star-inserted')]"));
			clickElement(allocatedElement1);
			
			System.out.println("expand button clicked JS");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", allocatedElement1);
			
		
	}
		
		

}
	

