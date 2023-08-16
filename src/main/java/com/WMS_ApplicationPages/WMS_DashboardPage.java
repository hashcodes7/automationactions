package com.WMS_ApplicationPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.xml.security.stax.ext.XMLSecurityConstants.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WMS_DashboardPage extends WMS_WebDriverUtilities {

	WebDriverWait wait;
	WebDriver driver;
	String batchNo;

	public WMS_DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	///////////////////////////////////////////////// PAGE OBJECTS
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	@FindBy(xpath = "//ion-menu-toggle")
	public WebElement startMenuToggleElement;
	
	@FindBy(xpath = "//ion-menu-toggle/ion-button")
	public WebElement clickMenuToggleElementTwo;

	@FindBy(xpath = "//input[@name='ion-input-0']")
	public WebElement menuSearchElement;

	@FindBy(xpath = "//*[contains(text(),'Wave run')]/ancestor::filter-field-header/following-sibling::ion-row/descendant::ion-input/input")
	public WebElement waveidsearch;
	
	@FindBy(xpath="//*[contains(text(),'ILPNs')]")
	public WebElement menuILPNsElement;
	
	@FindBy(xpath = "//span[@title='Wave run']/following-sibling::ion-button")
	public WebElement waveSearchExpandElement;

	@FindBy(xpath = "//button[@id='ASN']")
	public WebElement asnElement;

	@FindBy(xpath = "//button[@id='item']")
	public WebElement itemElement;

	@FindBy(xpath = "//button[@id='iLpn']")
	public WebElement lpnElement;

	@FindBy(xpath = "//*[@id='orders']")
	public WebElement ordersElement;
	
	@FindBy(xpath = "//*[contains(text(),'2022 6:04:42 AM PDT')]")
	public WebElement clickScrollBtn;
	
	@FindBy(xpath = "//*[text()='oLPNs']")
	public WebElement olpnsElement;
	
	@FindBy(xpath = "//ancestor::ion-list[@class='md list-md hydrated']/descendant::button[2]/ion-label")
	public WebElement parcelJournalElement;
	
	@FindBy(xpath = "//*[text()='MessageId ']")
	public WebElement parcelJournaObjlElement;
	
	@FindBy(xpath = "//*[text()='Transaction Identifier ']/ancestor::div [@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement TransactionTextElement;
	
	@FindBy(xpath = "//*[text()=' Clear All ']")
	public WebElement clearAllElement;
	
	@FindBy(xpath = "//ancestor::button[@class='clear-font clear-button ng-star-inserted']")
	public WebElement clearbtnElement;
	
	@FindBy(xpath = "//*[text()='Order ']/ancestor::div [@class='no-padding']/descendant::ion-input/input")
	public WebElement pressEnterOlpnElement;

	@FindBy(xpath = "//*[@class='menu-item ng-star-inserted']")
	public WebElement waveRunElement;

	@FindBy(xpath = "//*[@id='batch']")
	public WebElement batchListElement;

	@FindBy(xpath = "//*[@id='task']")
	public WebElement tasksElement;

	@FindBy(xpath = "//button[@id='wmMobile']")
	public WebElement wmMobileElement;

	@FindBy(xpath = "//*[@id='levipackstation']")
	public WebElement leviPackStationElement;

	@FindBy(xpath = "//ion-button[@title='Refresh']")
	public WebElement refreshElement;

	@FindBy(xpath = "//*[contains(text(),'DETAILS')]")
	public WebElement detailsBtnElement;
	
	@FindBy(xpath = "//ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']/descendant::div[@class='priorityCircle ng-star-inserted']")
	public WebElement recordStatusElement;
	
	/*
	 * @FindBy(xpath = "//*[contains(text(),' Provider Response : ')]") public
	 * WebElement checkProviderElement;
	 */

	@FindBy(xpath = "//span[contains(text(),' Provider Response : ')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::span[@class='field-value ng-star-inserted'][8]")
	public WebElement checkProviderElement;
	
	@FindBy(xpath = "//div[contains(@class,'switch-icon icon-background grid')]")
	public WebElement GridViewButton;

	@FindBy(xpath = "//*[@class='menu-item menu-parent menu-bold']")
	public WebElement ordarsmgmt;

	@FindBy(xpath = "//*[text()='Distribution Management']")
	public WebElement distrimgmt;

	@FindBy(xpath = "//*[text()='Order Management']")
	public WebElement ormgnt;

	@FindBy(xpath = "//*[text()='Orders']")
	public WebElement btnorders;

	@FindBy(xpath = "//span[@data-component-id='com-manh-cp-pickpack-DMOlpn-card-view-OrderPlanningRunId']")
	public WebElement selectWaveId;
	
	@FindBy(xpath = "//*[text()=' ShipRelease ']/ancestor::div[@class='dm-flex-row-layout dm-fill-space card-row primary sc-ion-focused']/descendant::span[10]")
	public WebElement getactionStatus1;
	
	@FindBy(xpath = "//*[text()=' Ship ']/ancestor::div[@class='dm-flex-row-layout dm-fill-space card-row primary']/descendant::span[10]")
	public WebElement getactionStatus2;
	
	@FindBy(xpath = "//*[text()=' RateShop ']/ancestor::div[@class='dm-flex-row-layout dm-fill-space card-row primary']/descendant::span[10]")
	public WebElement getactionStatus3;

	@FindBy(xpath = "//*[text()='Task']")
	public WebElement objTaskElement;
	
	@FindBy(xpath = "//ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']/descendant::div[@class='priorityCircle ng-star-inserted']")
	public WebElement waverunStatusElement;
	
	@FindBy(xpath = "//*[text()='Order ']/ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement orderSearchElement;
	
	@FindBy(xpath = "//span[@title='ASN']/following-sibling::ion-button")
	public WebElement asnSearchExpandElement;
	
	@FindBy(xpath = "//span[@title='Order']/following-sibling::ion-button")
	public WebElement orderSearchExpandElement;
	
	@FindBy(xpath = "//*[text()='Parcel End Of Day Requests']/ancestor::button")
	public WebElement endParcelElement;
	
	@FindBy(xpath = "//*[text()='Carrier ID ']/ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement carrierSearchElement;
	
	@FindBy(xpath = "//*[text()=' Message Type : ']/ancestor::div[@class='dm-flex-row-layout dm-fill-space card-row primary sc-ion-focused']/descendant::span[3]")
	public WebElement packCompleteElement;
	
	@FindBy(xpath = "//*[text()=' Message Type : ']/ancestor::div[@class='dm-flex-row-layout dm-fill-space card-row primary']/descendant::span[3]")
	public WebElement pickCompleteElement;
	
	@FindBy(xpath = "//ui-dm-hamburger/ion-content//*[text()='Location Inventory']")
	public WebElement inventoryElement;
	
	@FindBy(xpath = "//*[text()=' Select All Rows ']")
	public WebElement clickAllRecordElement;
	
	@FindBy(xpath = "//*[text()=' Related Links ']")
	public WebElement relatedlinksElement;
	
	@FindBy(xpath = "//*[text()=' Select All Locations ']")
	public WebElement clickAlllocationsElement;

	///////////////////////////////////////////////// PAGE Methods
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	public void clickMenuToggle() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(startMenuToggleElement));
			clickElement(startMenuToggleElement);
					
		} catch (Exception e) {
							System.out.println("inside menu toggle method");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", startMenuToggleElement);
				test.log(Status.PASS, "Clicked on menu Button");
			
		}
		

	}

	public void clickOnDetails() throws InterruptedException {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(detailsBtnElement));
			clickElement(detailsBtnElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", detailsBtnElement);
			WaitforPage(3000);
		}

	}

	public void clickRefresh() {
		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(refreshElement));
			clickElement(refreshElement);
			
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", refreshElement);
			
		}

	}
	
	public String getCurrentStatus() {
		String batchNo = getText(recordStatusElement);
		System.out.println("Current status is :" + batchNo);
		return batchNo;

	}
	
	@Test(invocationCount=20)
	public void clickRefreshMultipleTimes() throws InterruptedException {
		try {
			WaitforPage(3000);
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(refreshElement));
			clickElement(refreshElement);
			
		} catch (Exception e) {
			WaitforPage(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", refreshElement);
			
		}

	}
	public void enterMenuSearch(String waveSearch) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(menuSearchElement));
		enterText(menuSearchElement, waveSearch);



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
	
	public void wavesearch(String waveSearch, WMS_DashboardPage dashboardPage) throws InterruptedException {
		
		
		
		try {

			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(waveidsearch));
			enterText(waveidsearch, waveSearch);
			pressEnterKey(waveidsearch);
			pressEnterKey(waveidsearch);
			dashboardPage.clickRefresh();
			dashboardPage.clickRefresh();
		
		} catch (Exception e) {

			int i = 1;
			do {
				System.out.println(i);
				dashboardPage.clickRefresh();
				i++;
			} while (i <= 30);

		}

	}
		
	

	public void clickMenuBtn(WebElement MenuBtn) {
		try {
			new WebDriverWait(driver, 180).until(ExpectedConditions.elementToBeClickable(MenuBtn));
			clickElement(MenuBtn);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", asnElement);
		}

	}

	public void clickOrdersBtn() throws InterruptedException {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ordersElement));
			clickElement(ordersElement);
			Thread.sleep(5);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ordersElement);
			Thread.sleep(5);
		}

	}

	public void clickOnWaveRun() {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(waveRunElement));
			clickElement(waveRunElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", waveRunElement);
		}

	}

	public void clickOnBatchList() {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(batchListElement));
			clickElement(batchListElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", batchListElement);
		}

	}

	public void clickOnTasks() {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(tasksElement));
			clickElement(tasksElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", tasksElement);
		}

	}

	public void clickLeviPackStation() throws InterruptedException {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(leviPackStationElement));
			clickElement(leviPackStationElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", leviPackStationElement);
		}
		
	}

	public void clickWmMobileBtn() throws InterruptedException {

		try {
			new WebDriverWait(driver, 180).until(ExpectedConditions.elementToBeClickable(wmMobileElement));
			clickElement(wmMobileElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", wmMobileElement);
		}
		switchToWindows();

	}

	public void MouseclickOders() throws InterruptedException {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ordersElement));
			clickElement(ordersElement);
			Thread.sleep(5);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ordersElement);
			Thread.sleep(5);
		}

	}

	public void distbtn() throws InterruptedException {
		WaitforPage(4000);	
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(distrimgmt));
			clickElement(distrimgmt);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", distrimgmt);
		}

	}

	public void clickorderMagmnt() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(ormgnt));
			clickElement(ormgnt);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ormgnt);
		}

	}

	public void clickInventoryBtn() {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(inventoryElement));
			clickElement(inventoryElement);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", inventoryElement);
		}
	
	}
	
	
	public void ordersclick() {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(ordersElement));
			clickElement(ordersElement);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ordersElement);
		}
		new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(orderSearchExpandElement));
	}
	public void parcelEndOfdayBtn() {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(endParcelElement));
			clickElement(endParcelElement);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", endParcelElement);
		}
		new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(carrierSearchElement));
	}
	
	public void olpnclick() {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(olpnsElement));
			clickElement(olpnsElement);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", olpnsElement);
		}
		new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(pressEnterOlpnElement));
	}
	
	public void ParcelJournalclick() {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(parcelJournalElement));
			clickElement(parcelJournalElement);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", parcelJournalElement);
		}
		
	}
	
public void searchTransactiontextbox(String order) throws InterruptedException {
		
		WaitforPage(3000);
		enterText(TransactionTextElement,order);
		pressEnterKey(TransactionTextElement);
		pressEnterKey(TransactionTextElement);
		
		
	}

public void leftScrollMovement() throws InterruptedException, AWTException {
	
	 Actions actions = new Actions(driver);
     //Retrieve WebElement 'Music' to perform mouse hover 
 	WebElement menuOption = driver.findElement(By.xpath("//*[contains(text(),'2022 6:04:42 AM PDT')]"));
 	//Mouse hover menuOption 'Music'
 	actions.moveToElement(menuOption).perform();
 	System.out.println("Done Mouse hover on 'Music' from Menu");
 	
 	
	
	
	
}
public void selectAlllocations() throws InterruptedException { 
	try { 
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickAlllocationsElement)); 
		clickElement(clickAlllocationsElement); 
		} 
	catch (Exception e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickAlllocationsElement); 
		}
	}

	public void clearAllBtn() throws InterruptedException {
		
		try {
			new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(clearAllElement));
			clickElement(clearAllElement);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clearAllElement);
		}
		 driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}
	
public void clearBtn() throws InterruptedException {
		
		try {
			new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(clearbtnElement));
			clickElement(clearbtnElement);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clearbtnElement);
		}
		WaitforPage(2000);
	}
	
	public String waverunid() {

		String batchNo = getText(selectWaveId);
		System.out.println("Wave Run Number is :" + batchNo);
		return batchNo;

	}
	
	
	
	
	public String getProviderResponse() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  String provideRes = checkProviderElement.getText();
			  System.out.println("Provider response displayed properly" + provideRes);
			  return provideRes;
			 
		
		

	}
	
	public String getShipStatus(String status) throws InterruptedException {
		new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(checkProviderElement));
		WebElement allocatedElement2= driver.findElement(By.xpath("//span[contains(text(),' Provider Response : ')]/ancestor::div[contains(@class,'dm-flex-col-layout')]["+2+"]/descendant::span[@class='field-value ng-star-inserted'][8]"));
		String action2 = getText(allocatedElement2);
		return action2;
		
		
	}

		
		
	
	
	public String getAllactionStatus2() {

		
		String action2 = getText(getactionStatus2);
		
		
		System.out.println("Parcel journal Action status verified by :" + action2);
		return action2;
		
		
	}
	
public String getAllactionStatus3() {

		
		String action3 = getText(getactionStatus3);
		
		
		System.out.println("Parcel journal Action status verified by :" + action3);
		return action3;
		
		
	}
	public void clickMenuJs() throws InterruptedException {

		WaitforPage(4000);	

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.querySelector(\"ion-button[data-component-id='navbar-component-navbar-view-navbar-section-menu-toggle-button']\").shadowRoot.querySelector(\"button\").click();");

		
		WaitforPage(4000);
	}
	
	
	public void bulkRfreshPage(WMS_DashboardPage dashboardPage) throws InterruptedException {
		
		dashboardPage.clickRefresh();

		WaitforPage(3000);

		dashboardPage.clickRefresh();
		WaitforPage(3000);
		dashboardPage.clickRefresh();

		WaitforPage(5000);

		dashboardPage.clickRefresh();
		
		dashboardPage.clickRefresh();

		WaitforPage(3000);

		dashboardPage.clickRefresh();
		WaitforPage(3000);
		dashboardPage.clickRefresh();
		
	}

	public void clickMenuToggleElementTwo() throws InterruptedException {
		WaitforPage(3000);
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", clickMenuToggleElementTwo);
		WaitforPage(3000);

	}


	public String getPackkComplete() {
		String batchNo = getText(packCompleteElement);
		System.out.println("Wave Batch Number is :" + batchNo);
		return batchNo;

	}
	
	public void selectAllRecord() throws InterruptedException {
        try {
            new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickAllRecordElement));
            clickElement(clickAllRecordElement);
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", clickAllRecordElement);
        }
    }
	
	public void clickRelatedLinks() throws InterruptedException { 
		try { 
			new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(relatedlinksElement));
			clickElement(relatedlinksElement);
			}
		catch (Exception e) { 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", relatedlinksElement);
			}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	public void resizeWebpage() throws AWTException, InterruptedException {
        WaitforPage(2000);
        Robot robot = new Robot();
        System.out.println("About to zoom out");
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
        }
    }
	
	public String getPickComplete() {
		String batchNo = getText(pickCompleteElement);
		System.out.println("Wave Batch Number is :" + batchNo);
		return batchNo;

	}
}

	