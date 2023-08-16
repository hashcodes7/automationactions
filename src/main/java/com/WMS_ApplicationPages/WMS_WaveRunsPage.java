package com.WMS_ApplicationPages;

import java.awt.AWTException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.batik.apps.rasterizer.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WMS_Utilities.WMS_WebDriverUtilities;

public class WMS_WaveRunsPage extends WMS_WebDriverUtilities {

	String batchNo;

	WebDriver driver;
	WebDriverWait wait;

	public WMS_WaveRunsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	///////////////////////////////////////////////// PAGE OBJECTS
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	@FindBy(xpath = "//*[text()='Wave run ']/ancestor::div[@class='no-padding']/descendant::ion-input/input")
	public WebElement waveRunSearchElement;

	@FindBy(xpath = "//*[@title='Completed']")
	public WebElement waveRunStatusElement;

	@FindBy(xpath = "//*[@class='dm-flex-row-layout dm-fill-space card-row primary']")
	public WebElement waveRecordElement;

	@FindBy(xpath = "//a[text()='Work Release Allocations']")
	public WebElement workRealeaseAllocationsElement;

	@FindBy(xpath = "//*[text()=' Status : ']/following-sibling::*")
	public WebElement workRealeaseStatusElement;

	/*
	 * @FindBy(
	 * xpath="//*[@class='neutral-button dm-flex-center dm-flex-col-layout ng-star-inserted']"
	 * )
	 * //div/div[@data-component-id='com-manh-cp-pickpack-DMOlpn-card-view-collapse-
	 * icon'] public WebElement expandBarElement;
	 */
	@FindBy(xpath = "//div[text()=' Created ']/ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']/descendant::div[@class='width-45 ng-star-inserted']")
	public WebElement expandBarElement;
	
	@FindBy(xpath = "//div[text()=' ALLOCATED ']/ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']/descendant::div[@class='width-45 ng-star-inserted']")
	public WebElement shortageexpandBarElement;

	@FindBy(xpath = "//*[@class='clear-button hvr-radial-out ng-star-inserted'][2]")
	public WebElement relatedLinksElement;

	@FindBy(xpath = "//*[text()=' Order Planning Run : ']/following-sibling::*")
	public WebElement orderNoElement;

	@FindBy(xpath = "//*[@menu='ui-dm-hamburger']")
	public WebElement menuElement;

	@FindBy(xpath = "//*[@class='refresh-button navbar-icons-button ng-star-inserted md button button-clear ion-activatable ion-focusable hydrated']")
	public WebElement refreshElement;

	@FindBy(xpath = "//*[text()='Wave Management']")
	public WebElement waveMgnt;

	@FindBy(xpath = "//*[text()='Wave Runs']")
	public WebElement btnwaverun;
	
	
	@FindBy(xpath = "//*[text()='Work Release Allocations']")
	public WebElement clickwrabtn;
	
	@FindBy(xpath = "//*[contains(text(),'Order ')]/ancestor::filter-field-header/following-sibling::ion-row/descendant::ion-input/input")
	public WebElement searchOrderPlanID;

	@FindBy(xpath = "//*[text()=' Order Planning Run : ']/ancestor::div[@class='dm-flex-col-layout dm-fill-space card-column ng-star-inserted']/descendant::span[6]")
	public WebElement selectWaveId;
	
	@FindBy(xpath = "//*[text()=' Order Planning Run : ']/ancestor::div[@class='dm-flex-col-layout dm-fill-space card-column ng-star-inserted']/descendant::span[6]")
	public WebElement selectwvwrunNo;
	
	
	@FindBy(xpath = "//*[text()=' Wave run : ']/ancestor::div[@tabindex='0']/descendant::span[@class='field-value ng-star-inserted'][1]")
	public WebElement getFirstWaveId;
	
	@FindBy(xpath = "//*[text()=' oLPN : ']/ancestor::div[@tabindex='0']/descendant::span[@class='field-value ng-star-inserted'][1]")
	public WebElement getOLPNSId;
	
	@FindBy(xpath = "//*[text()=' Wave run : ']/ancestor::div[@class='dm-flex-col-layout dm-fill-space card-column ng-star-inserted']/descendant::span[2]")
	public WebElement clickwaveRunID;
	
	@FindBy(xpath = "//*[text()=' Wave run : ']")
	public WebElement clickwaverecord;

	@FindBy(xpath = "//*[text()='Work Release Allocations']")
	public WebElement clickWRAElement;

	@FindBy(xpath = "//*[text()=' Related Links ']")
	public WebElement waverelatedLinksElement;

	@FindBy(xpath = "//datatable-header/div/div[@class='datatable-row-center ng-star-inserted']")
	public WebElement waveTableHeader;

	@FindBy(xpath = "//datatable-body/datatable-selection/datatable-scroller")
	public WebElement waveTableBody;

	@FindBy(xpath = "//*[text()=' Released ']")
	public WebElement objrelesedWRpage;

	@FindBy(xpath = "//*[text()='Wave run ']")
	public WebElement objWaverunText;

	@FindBy(xpath = "//button[@data-component-id='com-manh-cp-pickpack-DMOlpn-header-panel-relatedLinks'][1]")
	public WebElement clickwaveRL;

	@FindBy(xpath = "//*[text()='oLPN ']")
	public WebElement objOlpnElememt;

	@FindBy(xpath = "//span[text()=' Status : ']/ancestor::div[@class='dm-flex-row-layout field-row ng-star-inserted']/descendant::span[@class='field-value ng-star-inserted']")
	public WebElement helpforTaskingElement1;
	
	@FindBy(xpath = "//ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']/descendant::div")
	public WebElement cancelTextStatus;

	@FindBy(xpath = "//*[text()=' Ready For Tasking ']")
	public WebElement helpforTaskingElement2;
	
	@FindBy(xpath = "//ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']/descendant::div[@class='priorityCircle ng-star-inserted']")
	public WebElement waverunStatusElement;
	
	@FindBy(xpath = "//*[text()=' Status : ']/ancestor::div[@class='dm-flex-row-layout dm-fill-space card-row primary']")
	public WebElement workReleaseStatus;
	
	
	///////////////////////////////////////////////// PAGE Methods
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	public String getOrderNumber() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(orderNoElement));
		String orderNo = getText(orderNoElement);
		System.out.println("Order No is: " + orderNo);
		return orderNo;
	}

	public void WorlReleaseAllocationReleaseStatus(WMS_DashboardPage dashboardPage) throws InterruptedException {
        WaitforPage(2000);
        String Status2 = getText(helpforTaskingElement1);
        System.out.println(Status2);
        while (!Status2.trim().equals("Released")) {
            dashboardPage.clickRefresh();
            WaitforPage(2000);
            Status2 = getText(helpforTaskingElement1);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            System.out.println(Status2);
            System.out.println("waiting for new status change");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");// 333333333333333000000
            LocalDateTime now = LocalDateTime.now();
            String SerialNo = dtf.format(now).toString() + "0";
            System.out.println("Execution Time is  : " + SerialNo);
        }
    }
	public void enterWaveRunSearch(String orderNo) throws InterruptedException {

		WaitforPage(2000);
		
		enterText(waveRunSearchElement, orderNo);

		Thread.sleep(2000);
		pressEnterKey(waveRunSearchElement);
		
	}

	public void sysoutstatus() {

		try {
			new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(orderNoElement));
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
			System.out.println("Allocated");
		}
	}

	public void getWaveRunStatus() {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(waveRunStatusElement));
		String waveStatus = getText(waveRunStatusElement);
		System.out.println("Wave is in :" + waveStatus);

	}

	public void selectWaveRecord() {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(waveRecordElement));
			clickElement(waveRecordElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", waveRecordElement);
		}

	}

	public void selectWorkRealeaseAllocations() throws InterruptedException {
		if (Display(workRealeaseAllocationsElement)) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(workRealeaseAllocationsElement));
			try {
				clickElement(workRealeaseAllocationsElement);
				Thread.sleep(5000);
			} catch (Exception e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", workRealeaseAllocationsElement);
				Thread.sleep(5000);
			}

		}

	}

	public void workReleaseAllocationStatus() {
		if (Display(workRealeaseStatusElement)) {
			new WebDriverWait(driver, 500).until(ExpectedConditions.visibilityOf(workRealeaseStatusElement));
			String workReleaseStatus = getText(workRealeaseStatusElement);
			System.out.println("Work Release Allocation Starus is in :" + workReleaseStatus);

		}

	}

	public void clickExpandBar() {
		
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(expandBarElement));
			try {
				clickElement(expandBarElement);
			} catch (Exception e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", expandBarElement);
			}
		

	}
	
	
	
	public void clickExpandBarShortage() {
		
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(shortageexpandBarElement));
		try {
			clickElement(shortageexpandBarElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", shortageexpandBarElement);
		}
	

}
	
	public void clickWRAmenuBtn() {
		
		
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(clickwrabtn));
			clickElement(clickwrabtn);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickwrabtn);
		}
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

}

	public void clickRelatedLinks() throws InterruptedException {
		try {
			new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(relatedLinksElement));
			clickElement(relatedLinksElement);
			Thread.sleep(1000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", relatedLinksElement);
			Thread.sleep(1000);
		}

	}

	public void clickMenuToggle() {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(menuElement));
			clickElement(menuElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", menuElement);
		}

	}
	
	public void enterOrderPlanIDSearch(String order, WMS_DashboardPage dashboardPage) throws InterruptedException {
		
		try {

			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(searchOrderPlanID));
			enterText(searchOrderPlanID, order);
			pressEnterKey(searchOrderPlanID);
			pressEnterKey(searchOrderPlanID);
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
		

	public void clickRefresh() {
		try {
			Thread.sleep(2000);
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(refreshElement));
			clickElement(refreshElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", refreshElement);
		}

	}

	public void clickWaveMagmnt() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(waveMgnt));
			clickElement(waveMgnt);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", waveMgnt);
		}

	}

	public void clickWaverunbtn() {

		try {
			clickElement(btnwaverun);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", btnwaverun);
		}

	}
	


	public String waverunid() {

		String batchNo = getText(selectWaveId);
		System.out.println("Wave Run Number is :" + batchNo);
		return batchNo;

	}
	
	public String waverunNoShortage() {

		String batchNo = getText(selectwvwrunNo);
		System.out.println("Wave Run Number is :" + batchNo);
		return batchNo;

	}
	
	public String Olpnsid() {

		String batchNo = getText(getOLPNSId);
		System.out.println("OLPNS ID  is :" + batchNo);
		return batchNo;

	}
	
	
	public String getFirstwaverunid() {

		String batchNo = getText(getFirstWaveId);
		System.out.println("Wave Run Number is :" + batchNo);
		return batchNo;

	}
	
	public String waverunidfromWRpage() {

		String batchNo = getText(clickwaveRunID);
		
		System.out.println("Wave Run Number is :" + batchNo);
		
		return batchNo;

	}


	public void selectonewaverecord() throws InterruptedException {
		Thread.sleep(2000);

		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickwaverecord));
			clickElement(clickwaverecord);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickwaverecord);
		}

	}

	public void selectWorkRelAllocation() {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(clickWRAElement));
			clickElement(clickWRAElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickWRAElement);
		}
		driver.manage().timeouts().implicitlyWait(350, TimeUnit.SECONDS);

	}

	public void wrRelatedLinks() throws InterruptedException {
		try {
			new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(waverelatedLinksElement));
			clickElement(waverelatedLinksElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", waverelatedLinksElement);
		}

		new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(waverelatedLinksElement));

	}
	
	
	public void waitforWorkReleaseAllocatio(WMS_DashboardPage dashboardPage) throws InterruptedException {
		
		
		WaitforPage(2000);
		String Status2 = getText(workReleaseStatus);
		System.out.println(Status2);
		
		

		while (!Status2.trim().equals(" Status : ")) {
			dashboardPage.clickRefresh();
			WaitforPage(2000);
			Status2 = getText(workReleaseStatus);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			System.out.println(Status2);

			System.out.println("waiting for status change");
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");// 333333333333333000000
			LocalDateTime now = LocalDateTime.now();
			String SerialNo = dtf.format(now).toString()+"0";
			System.out.println("Execution Time is  : "+SerialNo);

		}

	}
	
public void waveRunPageStatus(WMS_DashboardPage dashboardPage) throws InterruptedException {
		
		
		WaitforPage(2000);
		String Status2 = getText(waverunStatusElement);
		System.out.println(Status2);
		
		

		while (!Status2.trim().equals("Completed")) {
			dashboardPage.clickRefresh();
			WaitforPage(2000);
			Status2 = getText(waverunStatusElement);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			System.out.println(Status2);

			System.out.println("waiting for status change");
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");// 333333333333333000000
			LocalDateTime now = LocalDateTime.now();
			String SerialNo = dtf.format(now).toString()+"0";
			System.out.println("Execution Time is  : "+SerialNo);

		}

	}

	public void workReleasePage(WMS_DashboardPage dashboardPage) throws InterruptedException {
		
	
			WaitforPage(2000);
			String Status2 = getText(helpforTaskingElement1);
			System.out.println(Status2);

			while (!Status2.trim().equals("Held For Tasking")) {
				dashboardPage.clickRefresh();
				WaitforPage(2000);
				Status2 = getText(helpforTaskingElement1);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				System.out.println(Status2);

				System.out.println("waiting for new status change");
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");// 333333333333333000000
				LocalDateTime now = LocalDateTime.now();
				String SerialNo = dtf.format(now).toString()+"0";
				System.out.println("Execution Time is  : "+SerialNo);


			}

		}

	
	public void workReleaseCancelPage(WMS_DashboardPage dashboardPage) throws InterruptedException {
		
		
		WaitforPage(2000);
		String Status2 = getText(cancelTextStatus);
		System.out.println(Status2);

		while (!Status2.trim().equals("Cancelled")) {
			dashboardPage.clickRefresh();
			WaitforPage(2000);
			Status2 = getText(cancelTextStatus);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			System.out.println(Status2);

			System.out.println("status changed succesfully");

		}

	}
		
	 

	public void WorkRealeAllocation() throws InterruptedException {
		

		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickWRAElement));
			clickElement(clickWRAElement);

			pressEnterKey(clickWRAElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickWRAElement);

		}
		

		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}

	public void implicitywaits() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	}

	public void clickWaveRelatedLinks() {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(clickwaveRL));
			clickElement(clickwaveRL);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickwaveRL);
		}

	}
	public void clickWaverunpagebtn() {

		try {
			clickElement(btnwaverun);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", btnwaverun);
		}

	}

}

