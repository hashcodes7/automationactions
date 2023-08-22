package com.WMS_ApplicationPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.batik.extension.svg.FlowDivElement;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.WMS_Utilities.WMS_WebDriverUtilities;

public class WMS_OrdersPage extends WMS_WebDriverUtilities {

	WebDriver driver;
	WebDriverWait wait;
	boolean Capture = true;

	public WMS_OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	///////////////////////////////////////////////// PAGE OBJECTS
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	@FindBy(xpath = "//*[@name='ion-input-2']")
	public WebElement ordersSearchElement;

	@FindBy(xpath = "//*[@class='title-container ng-star-inserted']/preceding-sibling::*")
	public WebElement startMenuToggleElement;

	@FindBy(xpath = "//*[text()=' Maximum status : ']/following-sibling::*")
	public WebElement orderStatusBeforeRunningWaveElement;

	@FindBy(xpath = "//*[@class='dm-flex-row-layout dm-fill-space card-row primary']")
	public WebElement orderRecordElement;

	@FindBy(xpath = "//*[@class='more-button ng-star-inserted md button button-solid ion-activatable ion-focusable hydrated']")
	public WebElement hamburgerElement;

	@FindBy(xpath = "//*[text()='RUN WAVE ']")
	public WebElement runWaveElement;

	@FindBy(xpath = "//*[contains(text(),'Record Selected ')]/ancestor::ion-grid[@class='footer-panel ng-star-inserted md hydrated']/descendant::span]")
	public WebElement olpnCountElement;

	@FindBy(xpath = "//*[text()=' oLPN : ']")
	public WebElement textOrderElement;

	@FindBy(xpath = "//*[@class='modal-container']//*[contains(@name,'ion-input')]")
	public WebElement orderPlanningElement;

	@FindBy(xpath = "//*[@data-component-id='com-manh-cp-dcorder-Order-dropdown-list-OPS-StandardWave']")
	public WebElement opsStandardWaveElement;

	@FindBy(xpath = "//*[@title='Refresh']")
	public WebElement refreshElement;

	@FindBy(xpath = "//*[text()='Run Wave']")
	public WebElement frameElement;

	@FindBy(xpath = "//*[@class='action-button ng-star-inserted'][15]")
	public WebElement insidedotsWave;

	@FindBy(xpath = "//*[text()='SUBMIT']")
	public WebElement submitElement;

	@FindBy(xpath = "//ion-item[1]/child::a[1]")
	public WebElement menifestedOlpnElement;

	@FindBy(xpath = "//*[text()=' Related Links ']")
	public WebElement relatedLinksElement;

	@FindBy(xpath = "//*[text()=' Run number : ']/ancestor::div[@class='dm-flex-col-layout dm-fill-space card-column ng-star-inserted']/descendant::span[2]")
	public WebElement shortageWRElement;

	@FindBy(xpath = "//datatable-row-wrapper[@class='datatable-row-wrapper'][1]/datatable-body-row/div/datatable-body-cell/div/label/input")
	public WebElement selectFirstElement;

	@FindBy(xpath = "//div[text()=' ALLOCATED ']/ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']/descendant::div[@class='width-45 ng-star-inserted']")
	public WebElement olpnSexpandBarElement;

	@FindBy(xpath = "//datatable-row-wrapper[@class='datatable-row-wrapper'][2]/datatable-body-row/div/datatable-body-cell/div/label/input")
	public WebElement secoundElement;

	@FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[3]/datatable-body-row/div/datatable-body-cell/div/label/input")
	public WebElement ThirdElement;

	@FindBy(xpath = "//*[text()='Printing Journal']")
	public WebElement printingJournalElement;

	@FindBy(xpath = "//*[text()='MHE Journal']/ancestor::ul[@class='breadcrumb']/descendant::li[1]")
	public WebElement returnPrintingElement;

	@FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell/div/label/input")
	public WebElement PJfirstRoeElement;

	@FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[2]/datatable-body-row/div/datatable-body-cell/div/label/input")
	public WebElement PJSecoundRoeElement;

	@FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[3]/datatable-body-row/div/datatable-body-cell/div/label/input")
	public WebElement PJthirdRowElement;

	@FindBy(xpath = "//*[text()='VIEW DOCUMENT ']")
	public WebElement viewDocElement;

	/*
	 * @FindBy(xpath = "//*[text()='oLPNs']") public WebElement olpnElement;
	 */

	@FindBy(xpath = "//*[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']")
	public WebElement expandBarElement;

	@FindBy(xpath = "//input[@name='ion-input-0']")
	public WebElement menuSearchElement;

	@FindBy(xpath = "//*[@class='modal-container']//div[@class='content']")
	public WebElement runWaveBoxElement;

	@FindBy(xpath = "//*[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']")
	public WebElement releasedStatusElement;

	@FindBy(xpath = "//*[@class='scroll-panel md hydrated']")
	public WebElement scrollPanelElement;

	@FindBy(xpath = "//*[@class='multi-select-dropdown md list-md list-lines-none list-md-lines-none hydrated']")
	public WebElement listElement;

	@FindBy(xpath = "//*[text()='Order ']/ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement orderSearchElement;

	@FindBy(xpath = "//*[text()='End of Day Request ID ']/ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement carrierSearchElement;

	@FindBy(xpath = "//*[text()='End of Day requested date ']/ancestor::div[@class='form-field-container ng-untouched ng-pristine ng-invalid ng-star-inserted width-33 dateonly']/descendant::ion-input/input")
	public WebElement carrierInputDateElement;

	@FindBy(xpath = "//*[text()='Order ']/ancestor::div[@class='no-padding']/descendant::ion-input/input")
	public WebElement ordersLineSearchElement;

	@FindBy(xpath = "//span[@title='Order']/following-sibling::ion-button")
	public WebElement orderSearchExpandElement;

	@FindBy(xpath = "//datatable-header/div/div[contains(@class,'datatable-row-center')]")
	public WebElement OrderTableHeader;

	@FindBy(xpath = "//datatable-header/div/div[@class='datatable-row-center ng-star-inserted']")
	public WebElement canlStatusElementHeader;

	@FindBy(xpath = "//datatable-header/div/div[@class='datatable-row-center ng-star-inserted']")
	public WebElement OrdAllocaTabHeader;

	@FindBy(xpath = "//datatable-body/datatable-selection/datatable-scroller")
	public WebElement canlStatusElemenbody;

	@FindBy(xpath = "//datatable-body/datatable-selection/datatable-scroller")
	public WebElement orderTableBody;

	@FindBy(xpath = "//datatable-body/datatable-selection/datatable-scroller")
	public WebElement OrdAllocaTabBody;

	@FindBy(xpath = "//div[@class='neutral-button dm-flex-center']")
	public WebElement clickbackelement;

	@FindBy(xpath = "//*[text()='Run Wave']")
	public WebElement clickrunwave;

	@FindBy(xpath = "//*[text()='Cancel Order']")
	public WebElement clickCancelbtn;

	@FindBy(xpath = "//*[text()='Order planning strategy ']")
	public WebElement objOrderPlaning;

	@FindBy(xpath = "//div[@class='dm-flex-row-layout dm-fill-space card-row primary sc-ion-focused']")
	public WebElement clickonerecord;

	@FindBy(xpath = "//*[text()=' Select All Rows ']")
	public WebElement clickAllRecordElement;

	@FindBy(xpath = "//*[text()='RUN ']")
	public WebElement clickChasewaveelement;

	@FindBy(xpath = "//*[text()=' oLPN : ']")
	public WebElement clickOlpnRecord;

	@FindBy(xpath = "//*[text()='DETAILS ']")
	public WebElement clickdetailsBtn;

	@FindBy(xpath = "//*[text()='Order Failures']")
	public WebElement clickOrderFailureBtn;

	@FindBy(xpath = "//ion-button[contains(text(),'DETAILS ')]")
	public WebElement orddetails;

	@FindBy(xpath = "//ion-button[contains(text(),'DETAILS ')]")
	public WebElement olpnsdetails;

	@FindBy(xpath = "//ion-button[contains(text(),'ADDITIONAL INFORMATION ')]")
	public WebElement clickaddinfo;

	@FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell/div/label/input")
	public WebElement selectmheValElement;

	@FindBy(xpath = "//input[@name='ion-input-21']")
	public WebElement strgElement;

	@FindBy(xpath = "//*[text()='Run Wave']")
	public WebElement clicktext;

	@FindBy(xpath = "//ion-input[@data-component-id='com-manh-cp-dcorder-order-dynamic-ui-builder-dropdown-PlanningStrategyId']/input")
	public WebElement clicktextstatergy;

	@FindBy(xpath = "//*[text()='OPS - Standard Wave']")
	public WebElement selectStdwave;

	@FindBy(xpath = "//*[text()=' Related Links ']")
	public WebElement ordrelatedLinksElement;

	@FindBy(xpath = "//*[text()=' Initiate End of Day Request ']")
	public WebElement endofDayRequestElement;

	@FindBy(xpath = "//*[text()=' oLPN Type : ']")
	public WebElement selectOlpnsRecElement;

	@FindBy(xpath = "//div[@class='datatable-row-center datatable-row-group']")
	public WebElement clickMessageElement;

	@FindBy(xpath = "//*[@class='submit ion-float-right ng-star-inserted md button button-solid ion-activatable ion-focusable hydrated']")
	public WebElement confirmSummitElement;

	@FindBy(xpath = "//*[text()='oLPNs']")
	public WebElement olpnElement;

	@FindBy(xpath = "//*[text()='PROCESSED']")
	public WebElement processElement;
	/*
	 * AR 23.2
	 * 
	 * @FindBy(xpath =
	 * "//*[@class='ng-star-inserted item md in-list ion-focusable hydrated'][6]")
	 * public WebElement orderShortageElement;
	 */
	
	@FindBy(xpath = "//*[@class='ng-star-inserted item md item-lines-default item-fill-none in-list hydrated'][6]")
    public WebElement orderShortageElement;

	@FindBy(xpath = "//ancestor::ion-list[@class='md list-md hydrated']/descendant::button[3]")
	public WebElement mheJournalElement;

	@FindBy(xpath = "//*[text()=' Order line : ']")
	public WebElement OrderShorElememt;

	@FindBy(xpath = "//div[@class='buttons']/button[1]")
	public WebElement redrewElement;

	@FindBy(xpath = "//div[@class='buttons']/button[@id='downloadPdf']")
	public WebElement pdfDownloadElement;

	@FindBy(xpath = "//*[text()=' Item : ']/ancestor::div[@class='dm-flex-row-layout field-row ng-star-inserted']/descendant::span[@class='field-value ng-star-inserted']")
	public WebElement itemidElement;

	@FindBy(xpath = "//*[text()=' Item : ']/ancestor::div[@class='dm-flex-row-layout field-row card-column link-height ng-star-inserted']/descendant::a[@class='link-label card-column ng-star-inserted']")
	public WebElement itemordersLineElement;

	@FindBy(xpath = "//ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']/descendant::div[@class='priorityCircle ng-star-inserted']")
	public WebElement statusgetElement;

	@FindBy(xpath = "//*[text()='Ship Confirm']")
	public WebElement clickship;

	@FindBy(xpath = "//ion-col[@class='selected-label ng-star-inserted md hydrated']/child::span[@class='ng-star-inserted']")
	public WebElement takeOlpnCountElement;

	@FindBy(xpath = "//*[contains(text(),' Expected oLPN count : ')]/ancestor::div[@class='dm-flex-row-layout dm-fill-space card-row primary']/descendant::span[@class='field-value ng-star-inserted'][8]")
	public WebElement expectedcountElement;

	@FindBy(xpath = "//*[contains(text(),' Actual End of Day Request count : ')]/ancestor::div[@class='dm-flex-row-layout dm-fill-space card-row primary']/descendant::span[@class='field-value ng-star-inserted'][9]")
	public WebElement actualcountElement;

	@FindBy(xpath = "//pre[@style='word-wrap: break-word; white-space: pre-wrap;']")
	public WebElement clickshipLableDetails;

	@FindBy(xpath = "//*[text()=' PROCESSED ']/ancestor::datatable-body-row/descendant::div[14]")
	public WebElement getpickfirstElement;

	@FindBy(xpath = "//textarea[@spellcheck='false']")
	public WebElement enterShipLableElement;

	@FindBy(xpath = "//*[text()=' Error description : ']/ancestor::div[@class='dm-flex-row-layout field-row ng-star-inserted']/descendant::span[2]")
	public WebElement failureGettextElement;

	@FindBy(xpath = "//*[text()='Order ']/ancestor::div [@class='no-padding']/descendant::ion-input/input")
	public WebElement pressEnterOlpnOrderElement;

	@FindBy(xpath = "//*[text()='Metadata ']/ancestor::div [@class='field-container no-padding']/descendant::input[@class='native-input sc-ion-input-md']")
	public WebElement MetaTextElement;

	@FindBy(xpath = "//*[text()='Document Template ']/ancestor::div [@class='field-container no-padding']/descendant::input[@class='native-input sc-ion-input-md']")
	public WebElement DocsTextElement;

	@FindBy(xpath = "//*[text()='Payload ']/ancestor::div [@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement clickMHEjourOrderElement;

	@FindBy(xpath = "//*[text()='Message Type ']/ancestor::div[@class='field-container no-padding']/descendant::input")
	public WebElement MHEmsgElement;

	@FindBy(xpath = "//*[text()='oLPN ']/ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement pressEnterOlpnElement;

	@FindBy(xpath = "//*[text()=' oLPN Type : ']")
	public WebElement objOlpnElememt;

	@FindBy(xpath = "//*[text()=' oLPN Type : ']")
	public WebElement enterShipLabletext;

	@FindBy(xpath = "//ion-button[@data-component-id='com-manh-cp-dcorder-Order--more-actions']")
	public WebElement boxthreedots;

	@FindBy(xpath = "//*[text()='Order ']")
	public WebElement objOrderElememt;

	@FindBy(xpath = "//more-actions/ancestor::div[1]/dm-action[@style='visibility: visible; height: initial;'][2]/ion-button")
	public WebElement detailsBtnElememt;

	@FindBy(xpath = "//*[contains(text(),' SUBMI')]")
	public WebElement objsummitElememt;

	@FindBy(xpath = "//ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']/descendant::div[@class='priorityCircle ng-star-inserted']")
	public WebElement allocatedElement;

	@FindBy(xpath = "//*[contains(text(),' End of Day Request status : ')]/ancestor::div[@class='dm-flex-row-layout dm-fill-space card-row primary'][1]/descendant::span[8]")
	public WebElement ParcelEndStatusElement;

	@FindBy(xpath = "//ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']/descendant::div")
	public WebElement shipElementStatus;

	@FindBy(xpath = "//ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']/descendant::div")
	public WebElement ManifestateStatus;

	@FindBy(xpath = "//*[text()='Manifested']")
	public WebElement manifeststeTextElememt;

	@FindBy(xpath = "//*[text()='Total Original Ordered Quantity (in Units):']/ancestor::div[@class='dm-flex-col-layout-layout field-row']/descendant::span[@class='field-value']")
	public WebElement getQuantity;

	@FindBy(xpath = "//*[@class='icon-area ng-star-inserted']")
	public WebElement closeIconElement;

	@FindBy(xpath = "//span[text()='Reason code ']/ancestor::ion-grid/descendant::ion-input/input")
	public WebElement clickCancelReason;

	@FindBy(xpath = "//span[text()='Carrier ID ']/ancestor::ion-grid/descendant::ion-input/input")
	public WebElement clickcarrierdropdown;

	@FindBy(xpath = "//span[text()='End of Day requested date ']/ancestor::ion-grid[@class='grid ng-star-inserted md hydrated']/descendant::ion-input/input")
	public WebElement clickcarrierEODdropdown;

	@FindBy(xpath = "//ancestor::ion-col[@class='md hydrated']/input")
	public WebElement clickcarrierDatedropdown;

	@FindBy(xpath = "//*[text()='Customer Service Initiated']")
	public WebElement selectReasonElememt;

	@FindBy(xpath = "//span[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'order planning')]/ancestor::ion-grid/descendant::ion-input/input")
	public WebElement clicktWR;

	@FindBy(xpath = "//*[@placeholder='Search']")
	public WebElement sendInnerElememt;

	@FindBy(xpath = "//ancestor::div[@class='right']/")
	public WebElement clickApplyElememt;

	@FindBy(xpath = "//*[text()=' OPS - Standard Wave ']")
	public WebElement selectOpsElememt;
	
	@FindBy(xpath = "//*[text()=' OPS - PO Box and Export Wave ']")
	public WebElement selectOpsExpElememt;
	
	

	@FindBy(xpath = "//*[text()=' OPS - Fill or Kill Wave ']")
	public WebElement selectFillandKillElememt;

	@FindBy(xpath = "//*[text()=' OPS - Chase Wave ']")
	public WebElement selectOpsChaseWaveElememt;

	@FindBy(xpath = "//*[text()='ORDER QUANTITY SUMMARY ']")
	public WebElement clickOrderQtyElememt;

	@FindBy(xpath = "//*[text()=' OK ']")
	public WebElement clickOKElememt;

	@FindBy(xpath = "//ion-input[@data-component-id='com-manh-cp-dcorder-order-dynamic-ui-builder-dropdown-PlanningStrategyId']>input")
	public WebElement enterWaveInboxElememt;

	@FindBy(xpath = "//*[text()='RUN WAVE ']")
	public WebElement toolRunwaveElement;

	@FindBy(xpath = "//ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']/descendant::div")
	public WebElement cancelStatusElement1;

	@FindBy(xpath = "//*[@class='ng-star-inserted item md in-list ion-focusable hydrated'][1]")
	public WebElement itemElement;

	@FindBy(xpath = "//*[text()=' Primary Barcode : ']/ancestor::div[@class='dm-flex-row-layout field-row ng-star-inserted']/descendant::span[2]")
	public WebElement itembarElement;

	@FindBy(xpath = "//*[text()=' Item : ']/ancestor::div[@class='dm-flex-row-layout field-row card-column link-height ng-star-inserted']/descendant::a")
	public WebElement clickItemElement;

	@FindBy(xpath = "//*[text()='Additional Information']/ancestor::div[@class='expand-header-container ng-star-inserted']/descendant::ion-icon")
	public WebElement clickAddInfoRateshopElement;
	
	@FindBy(xpath = "//*[text()='oLPN Details']/ancestor::div[@class='expand-header-container ng-star-inserted']/descendant::ion-icon")
	public WebElement clickOlpnDetailsElement;
	
	@FindBy(xpath = "//*[contains(text(),'CANCEL OLPN ')]/ancestor::div[@class='modal-footer light']/descendant::ion-button[8]")
	public WebElement clickcancelOlpnElement;
	
	@FindBy(xpath = "//*[contains(text(),'Reason Code')]/ancestor::div[@class='modal-container']/descendant::input")
	public WebElement clickcancelreasonElement;
	
	@FindBy(xpath = "//ion-list[@class='multi-select-dropdown md list-md list-lines-none list-md-lines-none hydrated']/descendant::p[2]")
	public WebElement clickcancelreasonTypeElement;

	@FindBy(xpath = "//*[text()='Shipping Information']/ancestor::div[@class='expand-header-container ng-star-inserted']/descendant::ion-icon")
	public WebElement clickShipInfoElement;
//CD 65 change
	@FindBy(xpath = "//*[text()='OMS Designated Ship Via :']/ancestor::div[@class='labelHeader']/descendant::div[@class='field-value ng-star-inserted']")
	//@FindBy(xpath = "//*[text()='OMS Designated Ship Via :']/ancestor::ion-row[@class='labelHeader md hydrated']/descendant::span[2]")
	public WebElement omsDesgShip;

	@FindBy(xpath = "//*[text()='Carrier :']/ancestor::ion-row[@class='labelHeader md hydrated']/descendant::span[2]")
	public WebElement clickCarrierElement;

	@FindBy(xpath = "//*[text()='ORDER']/ancestor::div[@class='modal-header light']/descendant::ion-icon")
	public WebElement RateShopCloseIcon;

	@FindBy(xpath = "//*[@class='icon-area ng-star-inserted']")
	public WebElement closeIconRateElement;

	@FindBy(xpath = "//*[text()='Ship Via:']/ancestor::ion-row[@class='labelHeader md hydrated']/descendant::a")
	public WebElement olpnShipDetailsBtnStatus;

	@FindBy(xpath = "//*[text()=' Ship Via : ']/ancestor::div[@class='dm-flex-row-layout field-row ng-star-inserted']/descendant::span[2]")
	public WebElement olpnShipRecordElement;

	@FindBy(xpath = "//*[text()=' Created ']/ancestor::div[@tabindex='0']/descendant::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']")
	public WebElement olpnsRecordfirst;

	@FindBy(xpath = "//*[text()=' Created ']/ancestor::div[@tabindex='-1']/descendant::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']")
	public WebElement olpnsRecordsecond;

	@FindBy(xpath = "//*[text()=' Item ID : ']/ancestor::div[@tabindex='-1']/descendant::span[2]")
	public WebElement olpnsRecordThird;

	@FindBy(xpath = "//single-date-selection")
	public WebElement applybutton;

	@FindBy(xpath = "//*[text()=' oLPN : ']/ancestor::div[contains(@class,'dm-flex-row-layout dm-fill-space card-row primary')][1]/descendant::span[@class='field-value ng-star-inserted']")
	public WebElement olpnsFirstElement;

	@FindBy(xpath = "//*[text()=' oLPN : ']/ancestor::div[contains(@class,'dm-flex-row-layout dm-fill-space card-row primary')][1]/descendant::span[@class='field-value ng-star-inserted']")
	public WebElement olpnsSecoundElement;

	@FindBy(xpath = "//span[contains(text(),' Total LPN Quantity : ')]/ancestor::div[contains(@class,'dm-flex-col-layout')][1]/descendant::div/span")
	public WebElement olpnOrderStatus;

	///////////////////////////////////////////////// PAGE Methods
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	public void clickMenuToggle() {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(startMenuToggleElement));
			clickElement(startMenuToggleElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", startMenuToggleElement);
		}

	}

	public void clickitemNo() {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(clickItemElement));
			clickElement(clickItemElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickItemElement);
		}
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(itembarElement));
	}

	public void clickRunwaveInsideDots() {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(insidedotsWave));
			clickElement(insidedotsWave);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", insidedotsWave);
		}

	}

	public void enterOrdersSearch(String text, WMS_DashboardPage dashboardPage) throws InterruptedException {

		try {

			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(orderSearchElement));
			enterText(orderSearchElement, text);
			pressEnterKey(orderSearchElement);
			pressEnterKey(orderSearchElement);
			dashboardPage.clickRefresh();
			dashboardPage.clickRefresh();

		} catch (Exception e) {

			int i = 1;
			do {
				System.out.println(i);
				dashboardPage.clickRefresh();
				i++;
			} while (i <= 100);

		}

	}

	public void APPenterOrdersSearch(String text, WMS_DashboardPage dashboardPage) throws InterruptedException {

		try {

			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(orderSearchElement));
			enterText(orderSearchElement, text);
			pressEnterKey(orderSearchElement);
			pressEnterKey(orderSearchElement);
			dashboardPage.clickRefresh();
			dashboardPage.clickRefresh();

		} catch (Exception e) {

		}

	}

	public void checkOrderStatusBeforeRunningWave() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(orderStatusBeforeRunningWaveElement));
		String text = getText(orderStatusBeforeRunningWaveElement);
		System.out.println("Order status is in :" + text);
	}

	public String actualCountOlpn() throws InterruptedException {
		WaitforPage(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(document.querySelector(\"div > footer-actions > ion-grid > ion-row > ion-col.selected-label.ng-star-inserted.md.hydrated > span\").innerText();");
		WaitforPage(4000);
		return null;
	}

	public void selectOrderRecord() throws InterruptedException {
		Thread.sleep(500);
		if (Display(orderRecordElement)) {
			try {
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(orderRecordElement));
				clickElement(orderRecordElement);
			} catch (Exception e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", orderRecordElement);
			}

		}

	}

	public void selectHamburgerOption() {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(hamburgerElement));
			clickElement(hamburgerElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", hamburgerElement);
		}

	}

	public void clickRunWaveBtn() {
		try {
			clickElement(runWaveElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", runWaveElement);
		}

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(runWaveBoxElement));
	}

	public void clickOrderPlanningStategy() {
		if (Display(runWaveBoxElement)) {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(runWaveBoxElement));
			clickElement(runWaveBoxElement);

			if (Display(orderPlanningElement)) {
				new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(orderPlanningElement));
				clickElement(orderPlanningElement);
			}
		}
	}

	public void clickOpsStandardWave() {
		if (Display(listElement)) {
			clickElement(listElement);

		}
	}

	public void clickRefresh() throws InterruptedException {
		if (Display(refreshElement)) {
			try {
				clickElement(refreshElement);
				Thread.sleep(3000);
			} catch (Exception e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", refreshElement);
				Thread.sleep(3000);
			}

		}
	}

	public void clickSubmit() throws InterruptedException {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(submitElement));
			clickElement(submitElement);
			Thread.sleep(1000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", submitElement);
			Thread.sleep(1000);
		}

	}

	public void clickManifestedOlpns() throws InterruptedException {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(menifestedOlpnElement));
			clickElement(menifestedOlpnElement);
			Thread.sleep(1000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", menifestedOlpnElement);
			Thread.sleep(1000);
		}

	}

	public void clickRelatedLinks() {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(relatedLinksElement));
			clickElement(relatedLinksElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", relatedLinksElement);
		}

	}

	public void selectPrintingJournal() throws InterruptedException {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(printingJournalElement));
			clickElement(printingJournalElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", printingJournalElement);
		}
		WaitforPage(4000);
	}

	public void selectPJfirstRow() throws InterruptedException {

		WaitforPage(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"div > datatable-body > datatable-selection > datatable-scroller > datatable-row-wrapper:nth-child(1) > datatable-body-row > div.datatable-row-group.datatable-row-left > datatable-body-cell > div > label > input[type=checkbox]\").click();");

		WaitforPage(3000);

	}

	public void PJSecoundRow1() throws InterruptedException {

		WaitforPage(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"div > datatable-body > datatable-selection > datatable-scroller > datatable-row-wrapper:nth-child(2) > datatable-body-row > div.datatable-row-group.datatable-row-left > datatable-body-cell > div > label > input[type=checkbox]\").click();");

		WaitforPage(3000);

	}

	public void selectSecoundRow() throws InterruptedException {

		WaitforPage(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"div > datatable-body > datatable-selection > datatable-scroller > datatable-row-wrapper:nth-child(2) > datatable-body-row > div.datatable-row-group.datatable-row-left > datatable-body-cell > div > label > input[type=checkbox]\").click();");

		WaitforPage(3000);

	}

	public String oRSortwaverunid() {

		String batchNo = getText(shortageWRElement);
		System.out.println("Wave Run Number is :" + batchNo);
		return batchNo;

	}

	public void clickExpandBarolpns() {

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(olpnSexpandBarElement));
		try {
			clickElement(olpnSexpandBarElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", olpnSexpandBarElement);
		}

	}

	public void selectThirdRow() throws InterruptedException {

		if (secoundElement.isDisplayed()) {

			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(selectFirstElement));
			clickElement(selectFirstElement);
		} else if (!secoundElement.isDisplayed()) {

			System.out.println("there are no first row document");

		}

	}

	public void dropdownCurrentPageMHE() throws InterruptedException, AWTException {

		// to perform Scroll on application using Selenium

	}

	public void selectMHEBack() throws InterruptedException {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(returnPrintingElement));
			clickElement(returnPrintingElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", returnPrintingElement);
		}
		WaitforPage(4000);
	}

	public void selectPJSecoundRow() {
		try {
			WaitforPage(3000);
			clickElement(PJSecoundRoeElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", PJSecoundRoeElement);
		}

	}

	public void selectPJthirdRow() {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(PJthirdRowElement));
			clickElement(PJthirdRowElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", PJthirdRowElement);
		}

	}

	public void viewDocBtn() throws InterruptedException {

		WaitforPage(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"div.dm-flex-col-layout.dm-fill-space.right-panel > div > footer-actions > ion-grid > ion-row > ion-col.no-wrap.pr-15.md.hydrated > div > div > dm-action:nth-child(2) > ion-button\").shadowRoot.querySelector(\"button\").click();");

		WaitforPage(10000);
	}

	public String getPrinterTypeVerify(String printerType) throws InterruptedException {
		WaitforPage(5000);
		WebElement allocatedElement1 = driver.findElement(By.xpath("//span[contains(text(),'" + printerType
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')][3]/descendant::span[@class='field-value ng-star-inserted'][2]"));

		String itemNo1 = getText(allocatedElement1);

		System.out.println(itemNo1);

		return itemNo1;
	}

	public String getPrinterStatusVerify(String printerTypeStatus) throws InterruptedException {
		WaitforPage(5000);
		WebElement allocatedElement1 = driver.findElement(By.xpath("//span[contains(text(),'" + printerTypeStatus
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')][1]/descendant::span[@class='field-value ng-star-inserted'][1]"));

		String itemNo1 = getText(allocatedElement1);

		System.out.println(itemNo1);

		return itemNo1;
	}

	public void clickoLPNs() throws InterruptedException {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(olpnElement));
			clickElement(olpnElement);
			Thread.sleep(1000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", olpnElement);
			Thread.sleep(1000);
		}

	}

	public void clickOrderShordage() throws InterruptedException {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(orderShortageElement));
			clickElement(orderShortageElement);
			Thread.sleep(1000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", orderShortageElement);
			Thread.sleep(1000);
		}
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(OrderShorElememt));
	}

	public void JournalMHE() throws InterruptedException {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(mheJournalElement));
			clickElement(mheJournalElement);
			Thread.sleep(1000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", mheJournalElement);
			Thread.sleep(1000);
		}
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(clickMHEjourOrderElement));
	}

	public void clickRedrew() throws InterruptedException {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(redrewElement));
			clickElement(redrewElement);
			Thread.sleep(1000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", redrewElement);
			Thread.sleep(1000);
		}
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(redrewElement));
	}

	public void clickPDFdownloadElement() throws InterruptedException {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(pdfDownloadElement));
			clickElement(pdfDownloadElement);
			Thread.sleep(1000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", pdfDownloadElement);
			Thread.sleep(1000);
		}
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(pdfDownloadElement));
	}

	public void searchMHEOrderstextbox(String order) throws InterruptedException {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickMHEjourOrderElement));
		enterText(clickMHEjourOrderElement, order);
		pressEnterKey(clickMHEjourOrderElement);
		pressEnterKey(clickMHEjourOrderElement);

		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}

	public void searchMsgTypeMHE(String order) throws InterruptedException {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(MHEmsgElement));
		enterText(MHEmsgElement, order);
		pressEnterKey(MHEmsgElement);
		pressEnterKey(MHEmsgElement);

		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}
	
	public void selectPJfirstRow(String i) throws InterruptedException {
        WebElement allocatedElement2 = driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + i
                + "]/datatable-body-row/div/datatable-body-cell/div/label/input"));
        clickElement(allocatedElement2);
        addSrceenShot("Login", test, Capture);
        WaitforPage(4000);
    }

	public void clickExpandOption() {
		if (Display(expandBarElement)) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(expandBarElement));
			try {
				clickElement(expandBarElement);
			} catch (Exception e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", expandBarElement);
			}
		}

	}

	public void singleclick() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", orderSearchElement);
		js.executeScript("arguments[0].click();", orderSearchElement);
	}

	public void clickrecordbtn() {
		try {
			clickElement(clickbackelement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickbackelement);
		}

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(clickbackelement));
	}

	public void clickOLPNsDetails() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(orddetails));
			clickElement(orddetails);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", orddetails);
		}

	}

	public void clickaddinfo() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(clickaddinfo));
			clickElement(clickaddinfo);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickaddinfo);
		}

	}

	public void clickFirstrow() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(selectmheValElement));
			clickElement(selectmheValElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", selectmheValElement);
		}

	}

	public void clickaddinfoRateShop() throws InterruptedException {

		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(clickAddInfoRateshopElement));
			clickElement(clickAddInfoRateshopElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickAddInfoRateshopElement);
		}

	}
	
	public void clickolpnDetailsplus() throws InterruptedException {

		try {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].scrollIntoView();", clickOlpnDetailsElement);

			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(clickOlpnDetailsElement));
			clickElement(clickOlpnDetailsElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickOlpnDetailsElement);
		}

	}
	
	public void clickcancelOlpns() throws InterruptedException {

		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(clickcancelOlpnElement));
			clickElement(clickcancelOlpnElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickcancelOlpnElement);
		}

	}
	
	public void clickcancelreason() throws InterruptedException {

		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(clickcancelreasonElement));
			clickElement(clickcancelreasonElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickcancelreasonElement);
		}

	}
	
	public void clickcancelreasontype() throws InterruptedException {

		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(clickcancelreasonTypeElement));
			clickElement(clickcancelreasonTypeElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickcancelreasonTypeElement);
		}

	}
		
	
	public void clickShippingInfo() throws InterruptedException {

		WaitforPage(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickShipInfoElement);
		WaitforPage(4000);

	}

	public void clickCloseRateshopWind() throws InterruptedException {

		WaitforPage(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()");
		WaitforPage(4000);

	}

	public void clickCloseIcon() {
		try {
			clickElement(closeIconRateElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", closeIconRateElement);
		}

	}

	public void btnCancelOrders() throws InterruptedException {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickCancelbtn));
			clickElement(clickCancelbtn);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickCancelbtn);

		}
		WaitforPage(2000);
	}

	public void selectOrderrecord() throws InterruptedException {

		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(clickonerecord));
			clickElement(clickonerecord);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickonerecord);
		}

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

	public void selectChaseWaveBtn() throws InterruptedException {

		WaitforPage(4000);
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickChasewaveelement));
			clickElement(clickChasewaveelement);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickChasewaveelement);
		}

	}

	public void clickOlpnsRecord() throws InterruptedException {

		WaitforPage(2000);
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickOlpnRecord));
			clickElement(clickOlpnRecord);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickOlpnRecord);
		}

	}

	public void selectShipedrecord() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(manifeststeTextElememt));
			clickElement(clickonerecord);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickonerecord);
		}

	}

	public void clicktextBox() throws InterruptedException {

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", clicktextstatergy);

	}

	public void enterWaveStatergy(String OrderN) throws InterruptedException {

        WaitforPage(4000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", clicktWR);

        new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(clicktWR));

        enterText(sendInnerElememt, OrderN);

        new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(sendInnerElememt));
        
        WebElement allocatedElement1 = driver.findElement(By.xpath("//*[text()='"+OrderN+"']"));

        js.executeScript("arguments[0].click();", allocatedElement1);

        Thread.sleep(2000);

    }
	public void enterWaveStatergyExport(String selectstg) throws InterruptedException {

		WaitforPage(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", clicktWR);

		WaitforPage(4000);

		enterText(sendInnerElememt, selectstg);

		WaitforPage(4000);

		js.executeScript("arguments[0].click();", selectOpsExpElememt);

		Thread.sleep(2000);

	}

	public void enterFillandKillWave(String selectstg) throws InterruptedException {

		WaitforPage(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", clicktWR);

		WaitforPage(4000);

		enterText(sendInnerElememt, selectstg);

		WaitforPage(4000);

		js.executeScript("arguments[0].click();", selectFillandKillElememt);

		Thread.sleep(2000);

	}

	public void enterChaseWave() throws InterruptedException {

		WaitforPage(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", clicktWR);

		WaitforPage(4000);

		js.executeScript("arguments[0].click();", selectOpsChaseWaveElememt);

		Thread.sleep(2000);

	}

	public void btnThreedots() throws AWTException, InterruptedException {

		WaitforPage(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"more-actions>ion-button\").shadowRoot.querySelector(\"button\").click()");

		WaitforPage(2000);

	}

	public void clickInitiateBtn() throws AWTException, InterruptedException {

		WaitforPage(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"div:nth-child(4) > multi-select-filter > div > ion-row > div > div:nth-child(1) > div.checkbox-col > ion-checkbox\").shadowRoot.querySelector(\"button\").click();");

		WaitforPage(8000);

	}

	public void confirmSummit() throws AWTException, InterruptedException {

		WaitforPage(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click()", objsummitElememt);

		WaitforPage(3000);

	}

	public void orderCancelStatus(WMS_DashboardPage dashboardPage) throws InterruptedException {
		WaitforPage(5000);
		String Status = getText(cancelStatusElement1);
		System.out.println(Status);

		while (!Status.trim().equals("Cancelled")) {
			dashboardPage.clickRefresh();
			WaitforPage(5000);
			Status = getText(cancelStatusElement1);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			System.out.println(Status);
		}

	}

	public void selectitemRelatedLinks() throws InterruptedException {
		try {
			new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(itemElement));
			clickElement(itemElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", itemElement);
		}
		new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(itembarElement));
	}

	public void orderRelatedLinks() throws InterruptedException {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(ordrelatedLinksElement));
			clickElement(ordrelatedLinksElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ordrelatedLinksElement);
		}

	}

	public void initiateEODrequest() throws InterruptedException {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(endofDayRequestElement));
			clickElement(endofDayRequestElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", endofDayRequestElement);
		}

	}

	public void selectOneOlpnSRec() throws InterruptedException {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(selectOlpnsRecElement));
			clickElement(selectOlpnsRecElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", selectOlpnsRecElement);
		}

	}

	public void clickMessagecloumn() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

	}

	public void selectOLnpFromRelatedLinks() throws InterruptedException {

		try {

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			/*
			 * new WebDriverWait(driver,
			 * 60).until(ExpectedConditions.visibilityOf(olpnElement));
			 */
			clickElement(olpnElement);

			pressEnterKey(olpnElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", olpnElement);

		}

	}

	public void searchOlpntextbox(String text, WMS_DashboardPage dashboardPage) throws InterruptedException {

		try {

			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(pressEnterOlpnOrderElement));
			enterText(pressEnterOlpnOrderElement, text);
			pressEnterKey(pressEnterOlpnOrderElement);
			pressEnterKey(pressEnterOlpnOrderElement);
			dashboardPage.clickRefresh();
			dashboardPage.clickRefresh();
			dashboardPage.clickRefresh();

			pressEnterOlpnOrderElement.isDisplayed();
		} catch (Exception e) {

			while (!pressEnterOlpnOrderElement.isDisplayed()) {
				dashboardPage.clickRefresh();
				WaitforPage(2000);
				pressEnterOlpnOrderElement.isDisplayed();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				System.out.println("waiting for status change");

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");// 333333333333333000000
				LocalDateTime now = LocalDateTime.now();
				String SerialNo = dtf.format(now).toString() + "0";
				System.out.println("Execution Time is  : " + SerialNo);

			}

		}
	}

	public void searchDocType(String text) throws InterruptedException {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(DocsTextElement));
		enterText(DocsTextElement, text);
		pressEnterKey(DocsTextElement);
		pressEnterKey(DocsTextElement);

		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}

	public void searchMetaByOLPNS(String text) throws InterruptedException {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(MetaTextElement));
		enterText(MetaTextElement, text);
		pressEnterKey(MetaTextElement);
		pressEnterKey(MetaTextElement);

		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}

	public void enterShipLable(String text) throws InterruptedException {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(enterShipLableElement));
		enterText(enterShipLableElement, text);

		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}

	public void searchOlpnsNumber(String order) throws InterruptedException {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pressEnterOlpnElement));
		enterText(pressEnterOlpnElement, order);
		pressEnterKey(pressEnterOlpnElement);
		pressEnterKey(pressEnterOlpnElement);

		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}

	public String getitemNumber() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(itemidElement));
		String taskNo1 = getText(itemidElement);
		System.out.println("ITEM Number is: " + taskNo1);
		return taskNo1;
	}

	public String getOlpnsNumberFirst(String Ordernumber) throws InterruptedException {
		WaitforPage(5000);
		WebElement allocatedElement1 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber
				+ "')]/ancestor::div[contains(@class,'dm-flex-row-layout dm-fill-space card-row ')][1]/descendant::span[@class='field-value ng-star-inserted']"));

		String itemNo1 = getText(allocatedElement1);

		System.out.println(itemNo1);

		return itemNo1;
	}
	
	public String getOlpnsQty(String Ordernumber) throws InterruptedException {
		WaitforPage(5000);
		WebElement allocatedElement1 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber +"')]/ancestor::div[contains(@class,'dm-flex-row-layout dm-fill-space card-row ')][1]/descendant::span[20]"));

		String itemNo1 = getText(allocatedElement1);

		System.out.println(itemNo1);

		return itemNo1;
	}

	public String getitemNumberOrdersLine() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(itemordersLineElement));
		String taskNo1 = getText(itemordersLineElement);
		System.out.println("ITEM Number is: " + taskNo1);
		return taskNo1;
	}

	public void clickshipbutton(ExtentTest test) throws InterruptedException {

		WaitforPage(2000);
		try {
			new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(clickship));
			clickElement(clickship);
		} catch (Exception e) {
			test.log(Status.INFO, "Note : The menu is not in the visible range");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickship);
		}

	}

	public String getStatusFromInitiate() throws InterruptedException {

		WaitforPage(5000);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(statusgetElement));
		String taskNo1 = getText(statusgetElement);
		System.out.println("get initiate status  : " + taskNo1);
		return taskNo1;
	}

	public String getExpectedCount() throws InterruptedException {

		if (Display(expectedcountElement)) {

			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(expectedcountElement));
			String taskNo1 = getText(expectedcountElement);
			System.out.println("Expected Count is : " + taskNo1);
			return taskNo1;

		} else {

			System.out.println("no counts available or Zero Expected count ) ");
		}
		return null;

	}

	public String getActualCount() throws InterruptedException {

		if (Display(actualcountElement)) {

			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(actualcountElement));
			String taskNo1 = getText(actualcountElement);
			System.out.println("Actual Count is :" + taskNo1);
			return taskNo1;
		} else {

			System.out.println("no counts available or Zero Expected count ) ");
		}
		return null;

	}

	public String getOLPNCountInOlpnPage() throws InterruptedException {
		
		if (Display(actualcountElement)) {

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(takeOlpnCountElement));
		String taskNo1 = getText(takeOlpnCountElement);
		String LocationIdText = taskNo1.replace("Record Selected", "");
		System.out.println("Olpn count in OLPN Page is: " + LocationIdText);
		return LocationIdText;
		} else {

			System.out.println("no counts available or Zero Expected count ) ");
		}
		return null;

	}
	

	public void ParcelEndStatus(WMS_DashboardPage dashboardPage) throws InterruptedException {
		WaitforPage(5000);
		String Status = getText(allocatedElement);
		System.out.println(Status);

		while (!Status.trim().equals("Closed") && !Status.trim().equals("Failed")
				&& !Status.trim().equals("Cancelled")) {
			dashboardPage.clickRefresh();
			WaitforPage(5000);
			Status = getText(ParcelEndStatusElement);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			System.out.println(Status);
		}

	}

	public void olpnreleaseStatus(WMS_DashboardPage dashboardPage) throws InterruptedException {
		WaitforPage(5000);
		String Status = getText(allocatedElement);
		System.out.println(Status);

		while (!Status.trim().equals("Allocated")) {
			dashboardPage.clickRefresh();
			WaitforPage(5000);
			Status = getText(allocatedElement);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			System.out.println(Status);
		}
	}

	public void olpnreleaseStatusTwoOrders(WMS_DashboardPage dashboardPage, String Ordernumber, String Ordernumber2)
			throws InterruptedException {
		WaitforPage(5000);
		WebElement allocatedElement1 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement2 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber2
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));

		String Status1 = getText(allocatedElement1);
		String Status2 = getText(allocatedElement2);

		System.out.println(Status1);
		System.out.println(Status2);

		while (!(Status1.trim().equals("Allocated") && Status2.trim().equals("Allocated"))) {
			dashboardPage.clickRefresh();

			WaitforPage(5000);

			allocatedElement1 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement2 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber2
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));

			Status1 = getText(allocatedElement1);
			Status2 = getText(allocatedElement2);

			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			System.out.println(Status1);
			System.out.println(Status2);

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");// 333333333333333000000
			LocalDateTime now = LocalDateTime.now();
			String SerialNo = dtf.format(now).toString() + "0";
			System.out.println("Execution Time is  : " + SerialNo);

		}
	}

	public void olpnreleaseStatusThreeOrders(WMS_DashboardPage dashboardPage, String Ordernumber, String Ordernumber2,
			String Ordernumber3) throws InterruptedException {
		WaitforPage(5000);
		WebElement allocatedElement1 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement2 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber2
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement3 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber3
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		String Status1 = getText(allocatedElement1);
		String Status2 = getText(allocatedElement2);
		String Status3 = getText(allocatedElement3);

		System.out.println(Status1);
		System.out.println(Status2);
		System.out.println(Status3);

		while (!(Status1.trim().equals("Allocated") && Status2.trim().equals("Allocated")
				&& Status3.trim().equals("Allocated"))) {
			dashboardPage.clickRefresh();

			WaitforPage(5000);

			allocatedElement1 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement2 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber2
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement3 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber3
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));

			Status1 = getText(allocatedElement1);
			Status2 = getText(allocatedElement2);
			Status3 = getText(allocatedElement3);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			System.out.println(Status1);
			System.out.println(Status2);
			System.out.println(Status3);
		}
	}

	public void LWolpnreleaseStatusThreeOrders(WMS_DashboardPage dashboardPage, String Ordernumber, String Ordernumber2,
			String Ordernumber3, String Ordernumber4, String Ordernumber5, String Ordernumber6, String Ordernumber7,
			String Ordernumber8, String Ordernumber9, String Ordernumber10, String Ordernumber11, String Ordernumber12,
			String Ordernumber13, String Ordernumber14, String Ordernumber15, String Ordernumber16,
			String Ordernumber17, String Ordernumber18) throws InterruptedException {
		WaitforPage(5000);
		WebElement allocatedElement1 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement2 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber2
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement3 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber3
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement4 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber4
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement5 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber5
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement6 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber6
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement7 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber7
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement8 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber8
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement9 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber9
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement10 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber10
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement11 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber11
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement12 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber12
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement13 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber13
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement14 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber14
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement15 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber15
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement16 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber16
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement17 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber17
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
		WebElement allocatedElement18 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber18
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));

		String Status1 = getText(allocatedElement1);
		String Status2 = getText(allocatedElement2);

		String Status3 = getText(allocatedElement1);
		String Status4 = getText(allocatedElement2);
		String Status5 = getText(allocatedElement3);
		String Status6 = getText(allocatedElement1);
		String Status7 = getText(allocatedElement2);
		String Status8 = getText(allocatedElement3);
		String Status9 = getText(allocatedElement1);
		String Status10 = getText(allocatedElement2);
		String Status11 = getText(allocatedElement3);
		String Status12 = getText(allocatedElement1);
		String Status13 = getText(allocatedElement2);
		String Status14 = getText(allocatedElement3);
		String Status15 = getText(allocatedElement1);
		String Status16 = getText(allocatedElement2);
		String Status17 = getText(allocatedElement3);
		String Status18 = getText(allocatedElement3);
		System.out.println(Status1);
		System.out.println(Status2);
		System.out.println(Status3);
		System.out.println(Status4);
		System.out.println(Status5);
		System.out.println(Status6);
		System.out.println(Status7);
		System.out.println(Status8);
		System.out.println(Status9);
		System.out.println(Status10);
		System.out.println(Status11);
		System.out.println(Status12);
		System.out.println(Status13);
		System.out.println(Status14);
		System.out.println(Status15);
		System.out.println(Status16);
		System.out.println(Status17);
		System.out.println(Status18);

		while (!(Status1.trim().equals("Allocated") && Status2.trim().equals("Allocated")
				&& Status3.trim().equals("Allocated"))) {
			dashboardPage.clickRefresh();

			WaitforPage(5000);

			allocatedElement1 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement2 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber2
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement3 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber3
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement4 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber4
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement5 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber5
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement6 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber6
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement7 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber7
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement8 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber8
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement9 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber9
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement10 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber10
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement11 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber11
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement12 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber12
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement13 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber13
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement14 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber14
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement15 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber15
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement16 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber16
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement17 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber17
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			allocatedElement18 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber18
					+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')]/descendant::div[@class='priorityCircle ng-star-inserted']"));
			Status1 = getText(allocatedElement1);
			Status2 = getText(allocatedElement2);
			Status3 = getText(allocatedElement3);
			Status4 = getText(allocatedElement1);
			Status5 = getText(allocatedElement2);
			Status6 = getText(allocatedElement3);
			Status7 = getText(allocatedElement1);
			Status8 = getText(allocatedElement2);
			Status9 = getText(allocatedElement3);
			Status10 = getText(allocatedElement1);
			Status11 = getText(allocatedElement2);
			Status12 = getText(allocatedElement3);
			Status13 = getText(allocatedElement1);
			Status14 = getText(allocatedElement2);
			Status15 = getText(allocatedElement3);
			Status16 = getText(allocatedElement1);
			Status17 = getText(allocatedElement2);
			Status18 = getText(allocatedElement3);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			System.out.println(Status1);
			System.out.println(Status2);
			System.out.println(Status3);
			System.out.println(Status4);
			System.out.println(Status5);
			System.out.println(Status6);
			System.out.println(Status7);
			System.out.println(Status8);
			System.out.println(Status9);
			System.out.println(Status10);
			System.out.println(Status11);
			System.out.println(Status12);
			System.out.println(Status13);
			System.out.println(Status14);
			System.out.println(Status15);
			System.out.println(Status16);
			System.out.println(Status17);
			System.out.println(Status18);
		}
	}

	public void shipConfirmStatus(WMS_DashboardPage dashboardPage) throws InterruptedException {
		WaitforPage(5000);
		String Status = getText(shipElementStatus);
		System.out.println(Status);

		while (!Status.trim().equals("Shipped")) {
			dashboardPage.clickRefresh();
			WaitforPage(5000);
			Status = getText(shipElementStatus);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			System.out.println(Status);
		}

	}

	public void ManifestateConfirmStatus(WMS_DashboardPage dashboardPage) throws InterruptedException {
		WaitforPage(5000);
		String Status = getText(ManifestateStatus);
		System.out.println(Status);

		while (!Status.trim().equals("Manifested")) {
			dashboardPage.clickRefresh();
			WaitforPage(5000);
			Status = getText(ManifestateStatus);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			System.out.println(Status);
		}

	}

	public void detailsBtn() throws AWTException, InterruptedException {

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(boxthreedots));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"ion-button[data-component-id='com-manh-cp-dcorder-Order-footer-panel-Details']\").shadowRoot.querySelector(\"button\").click();");

		Thread.sleep(4000);

	}

	public String getQtyNumber() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(getQuantity));
		String taskNo1 = getText(getQuantity);
		System.out.println("TOtal Qty: " + taskNo1);
		return taskNo1;
	}

	public void clickOk() throws AWTException, InterruptedException {

		WaitforPage(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", clickOKElememt);
		WaitforPage(4000);

	}

	public void clickClose() {
		try {
			clickElement(closeIconElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", closeIconElement);
		}

	}

	public void btnrunwave() throws InterruptedException {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickrunwave));
			clickElement(clickrunwave);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickrunwave);

		}
		WaitforPage(2000);
	}

	public void clickReasonDropDown() {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(clickCancelReason));
			clickElement(clickCancelReason);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickCancelReason);
		}
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(selectReasonElememt));
	}

	public void clickreasonBtn(String menuSearch) throws InterruptedException {

		WaitforPage(3000);
		try {

			clickElement(clickCancelReason);
			enterText(clickCancelReason, menuSearch);
			clickElement(selectReasonElememt);
		} catch (Exception e) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickCancelReason);

		}
		WaitforPage(3000);
	}

	public void clickCarierServer(String carrierSearch) throws InterruptedException {

		WaitforPage(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", clickcarrierdropdown);

		WaitforPage(4000);

		WebElement allocatedElement1 = driver.findElement(
				By.xpath("//p[contains(translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'"
						+ carrierSearch.replaceAll("_", " ").toUpperCase() + "')]"));

		js.executeScript("arguments[0].click();", allocatedElement1);

		System.out.println("Carrier selected successfully");

	}

	public void clickWR() throws InterruptedException {

		WaitforPage(3000);
		try {

			clickElement(clicktWR);

			clickElement(selectReasonElememt);
		} catch (Exception e) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clicktWR);

		}
		WaitforPage(3000);
	}

	public void clickDetailsBtn() throws InterruptedException {
		WaitforPage(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", detailsBtnElememt);
		WaitforPage(4000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void clickToolRunwaveBtn() throws InterruptedException {

		WaitforPage(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", toolRunwaveElement);
		WaitforPage(4000);

	}

	public void clickGetQty() throws InterruptedException {
		WaitforPage(3000);
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", clickOrderQtyElememt);
		WaitforPage(3000);

	}

	public void enterOrdersLineSearch(String order) throws InterruptedException {

		System.out.println("outside");
		try {

			System.out.println("if");

			clickElement(ordersLineSearchElement);
			pressEnterKey(ordersLineSearchElement);
			pressEnterKey(ordersLineSearchElement);

		} catch (Exception e) {

			System.out.println("else");

			clickElement(ordersLineSearchElement);
			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(ordersLineSearchElement));
			/* clickElement(orderSearchElement); */

		}

		enterText(ordersLineSearchElement, order);
		pressEnterKey(ordersLineSearchElement);
		pressEnterKey(ordersLineSearchElement);

	}

	public void clickDetails() {
		try {
			clickElement(clickdetailsBtn);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickdetailsBtn);
		}

	}

	public String verifyomsdesg() throws InterruptedException {

		String omsDesgShipvia = getText(omsDesgShip);
		System.out.println("Shipvia in Orders Page :" + omsDesgShipvia);
		return omsDesgShipvia;

	}

	public String checkCarrierMessage() throws InterruptedException {

		String omsDesgShipvia = getText(clickCarrierElement);
		System.out.println("Shipvia in Orders Page :" + omsDesgShipvia);
		return omsDesgShipvia;

	}

	public String verifyOlpnDetailsBtn() throws InterruptedException {

		String omsDesgShipvia = getText(olpnShipDetailsBtnStatus);
		System.out.println("Shipvia in OLPNS Details Page :" + omsDesgShipvia);
		return omsDesgShipvia;

	}

	public String shipViaOlpnsRecord() throws InterruptedException {

		String omsDesgShipvia = getText(olpnShipRecordElement);
		System.out.println("OMS Designated Shipvia is :" + omsDesgShipvia);
		return omsDesgShipvia;
	}

	public String getItemNoBYOrdersNo(String Ordernumber) throws InterruptedException {
		WaitforPage(5000);
		WebElement allocatedElement1 = driver.findElement(By.xpath("//a[contains(text(),'" + Ordernumber
				+ "')]/ancestor::div[contains(@class,'dm-flex-col-layout')][1]/descendant::span[@class='field-value ng-star-inserted'][2]"));

		String itemNo1 = getText(allocatedElement1);

		System.out.println(itemNo1);

		return itemNo1;
	}

	public String getMHEvalidateDetails(String message) throws InterruptedException {
		WaitforPage(5000);
		WebElement allocatedElement6 = driver.findElement(By.xpath("//span[contains(text(),'" + message
				+ "')]//ancestor::div[contains(@class,'dm-flex-col-layout')][2]/descendant::span[@class='field-value ng-star-inserted'][6]"));

		String messageDetails = getText(allocatedElement6);

		System.out.println("MHE validate message details is : " + messageDetails);

		return messageDetails;
	}

	public void enterCarrierSearch(String order) throws InterruptedException {

		System.out.println("outside");
		try {

			System.out.println("if");

			pressEnterKey(carrierSearchElement);

		} catch (Exception e) {

			System.out.println("else");

			clickElement(carrierSearchElement);
			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(carrierSearchElement));

		}

		enterText(carrierSearchElement, order);
		pressEnterKey(carrierSearchElement);
		pressEnterKey(carrierSearchElement);
	}

	public void enterCarrierDate(String order) throws InterruptedException {

		WaitforPage(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + order + "';", clickcarrierEODdropdown);

		WaitforPage(4000);
		js.executeScript("arguments[0].click();", clickcarrierEODdropdown);

		WaitforPage(4000);

	}

	public void clickapplybtn() throws InterruptedException {
		WaitforPage(3000);

		System.out.println("ClickApplyButton");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WaitforPage(4000);

		js.executeScript(
				"arguments[0].shadowRoot.querySelector(\"modal-container > div > modal-footer > div > div.right > button.active-button.float-right.ion-float-right\").click();",
				applybutton);
		WaitforPage(4000);
		/*
		 * js.
		 * executeScript("arguments[0].shadowRoot.querySelector(\"modal-container > div > modal-footer > div > div.right > button.active-button.float-right.ion-float-right\").click();"
		 * ,applybutton);
		 * 
		 * WaitforPage(4000);
		 */
	}

	public void clickOrderfailure() {
		try {
			clickElement(clickOrderFailureBtn);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickOrderFailureBtn);
		}

	}

	public void expandFailureOrder(String ordersfailure) throws InterruptedException {

		WaitforPage(5000);
		WebElement allocatedElement1 = driver.findElement(By.xpath("//a[contains(text(),'" + ordersfailure
				+ "')]/ancestor::card-view//div[contains(@class,'dm-flex-col-layout')][1]/div"));

		clickElement(allocatedElement1);

	}

	public String getTextOrdersFailureNo1() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(failureGettextElement));
		String taskNo1 = getText(failureGettextElement);
		System.out.println("Order No 1 failure status: " + taskNo1);
		return taskNo1;
	}

	public String getTextOrdersFailureNo2() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(failureGettextElement));
		String taskNo1 = getText(failureGettextElement);
		System.out.println("Order No 2 failure status: " + taskNo1);
		return taskNo1;
	}

	public String getShipLable() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(clickshipLableDetails));
		String taskNo1 = getText(clickshipLableDetails);
		System.out.println("Order No 2 failure status: " + taskNo1);
		return taskNo1;
	}

	public String getpictDetailsFirst() {

		String taskNo1 = getText(getpickfirstElement);
		System.out.println("Order No 2 failure status: " + taskNo1);
		return taskNo1;
	}

	public void newUrl() {

		driver.get(URL2);
	}

}
