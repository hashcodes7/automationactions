package com.WMS_ApplicationPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

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

public class WMS_PackStationPage extends WMS_WebDriverUtilities {

	WebDriverWait wait;
	WebDriver driver;

	public WMS_PackStationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	///////////////////////////////////////////////// PAGE OBJECTS
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	@FindBy(xpath = "//*[text()='Pack Station 2']")
	public WebElement packStation2Element;

	@FindBy(xpath = "//*[text()='End Tote']")
	public WebElement endToteElement;

	@FindBy(xpath = "//*[text()=' ACCEPT']")
	public WebElement AcceptendToteElement;

	@FindBy(xpath = "//*[text()=' OK ']")
	public WebElement OKToteElement;

	@FindBy(xpath = "//*[text()='Pack Station 1']")
	public WebElement packStation1Element;

	/*
	 * @FindBy(xpath = "//*[text()=' Levi Return Station 1 ']") public WebElement
	 * returnStation1Element;
	 */

	@FindBy(xpath = "//div[contains(@class,'switch-icon icon-background grid')]")
	public WebElement rstation3Element;

	@FindBy(xpath = "//*[text()='Pack Station 3']")
	public WebElement packStation3Element;

	@FindBy(xpath = "//*[text()=' Sellable ']")
	public WebElement btnSellableElement;
	
	@FindBy(xpath = "//*[text()='Weigh Manifest Station']")
	public WebElement btnWmanifetElement;
	
	@FindBy(xpath = "//*[text()='SELECT PRINTER ZONE']/ancestor::div[@class='modal-wrapper sc-ion-modal-md']/descendant::div/button")
	public WebElement prtBtnElement;

	@FindBy(xpath = "//*[text()='Pack Station 1']/ancestor::ion-list[@class='md list-md hydrated']/descendant::ion-item")
	public WebElement selectptrBtnElement;

	@FindBy(xpath = "//ion-label[text()='Select Disposition ']/ancestor::ion-col/descendant::ion-label[2]")
	public WebElement clickSelableElement;

	@FindBy(xpath = "//*[text()=' Generate ']")
	public WebElement clickGenerateElement;
	
	@FindBy(xpath = "//*[text()='SET PRINTER']")
	public WebElement clicksetprinterElement;

	@FindBy(xpath = "//ion-button[contains(text(),'RECEIVE')]")
	public WebElement clickReceiveElement;

	@FindBy(xpath = "//ion-label[text()='LPN']/ancestor::ion-row[1]/descendant::ion-input/input")
	public WebElement getLpnsElement;

	@FindBy(xpath = "//span[text()='ASN: ']/ancestor::ion-grid/descendant::span[2]")
	public WebElement getBLRasnsNo;

	@FindBy(xpath = "//*[text()=' Generate ']")
	public WebElement getasnElement;

	@FindBy(xpath = "//*[@CLASS='icon-box svg-icon']")
	public WebElement packStationDropdownElement;

	@FindBy(xpath = "//ion-label[contains(text(),'Select Disposition')]/ancestor::ion-col/popup-dropdown/ion-label")
	public WebElement clickDepositionElement;

	@FindBy(xpath = "//*[@placeholder='Select']")
	public WebElement packStationOptionElement;

	//AR23.2 changes
	/*
	 * @FindBy(xpath =
	 * "//*[@class='md footer-md hydrated']//*[text()='START PACKING']") public
	 * WebElement startPackingBtnElement;
	 */
	
	@FindBy(xpath = "//*[contains(text(),'START PACKING')]/ancestor::scan-pack-popup[@class='ion-page']/descendant::ion-button[@class='neutral-button dm-footer-btn ion-float-right md button button-solid ion-activatable ion-focusable hydrated']")
	public WebElement startPackingBtnElement;

	@FindBy(xpath = "//*[text()='Tote']/following-sibling::*//*")
	public WebElement toteElement;

	@FindBy(xpath = "//div[contains(text(),'RR')]/ancestor::ion-col/following-sibling::ion-col[1]/descendant::ion-input/input")
	public WebElement doElement;

	@FindBy(xpath = "//*[text()='Item ']/following-sibling::*//*")
	public WebElement itemElement;

	@FindBy(xpath = "//ion-label[contains(text(),'ITEM')]/ancestor::ion-col/following-sibling::ion-col/descendant::ion-input/input")
	public WebElement returnItemElement;

	@FindBy(xpath = "//*[@class='quantity']")
	public WebElement quantityElement;
	
	@FindBy(xpath = "//*[contains(text(),'Manifest Information')]/ancestor::ion-grid[@class='md hydrated']/descendant::ion-input/input")
	public WebElement enterpackOLPNElement;


	@FindBy(xpath = "//*[@class='margin-bottom md hydrated']")
	public WebElement tickElement;

	@FindBy(xpath = "//*[@class='margin-bottom md hydrated']")
	public WebElement PlusElement;

	@FindBy(xpath = "//*[text()='Estimated Weight (lb)']/following-sibling::*")
	public WebElement estimatedWeightElement;

	@FindBy(xpath = "//*[@name='ion-input-7']")
	public WebElement actualWeightElement;

	@FindBy(xpath = "//*[text()=' MANIFEST ']/ancestor::ion-button")
	public WebElement manifestBtnElement;

	@FindBy(xpath = "//ion-button[contains(text(),'CONFIRM')]")
	public WebElement clickWrapInstElement;

	@FindBy(xpath = "//span[contains(text(),'ORDER DETAILS')]")
	public WebElement waitmanifestBtnElement;

	@FindBy(xpath = "//modal-footer/descendant::ion-button[contains(text(),'CONFIRM')]")
	public WebElement serialconfirmbtn;

	/*
	 * @FindBy(xpath =
	 * "//modal-footer/descendant::ion-button[contains(text(),'CONFIRM')]") public
	 * WebElement confirmbtn;
	 */
	@FindBy(xpath = "//*[@class='toast positive-toast']")
	public WebElement toastMsgElement;

	@FindBy(xpath = "//*[@title='Pack Station']/preceding-sibling::*")
	public WebElement startMenuToggleElement;

	@FindBy(xpath = "//*[@data-component-id='com-manh-cp-dcorder-Order-filter-OrderId']//*")
	public WebElement ordersSearchElement;

	
	@FindBy(xpath = "//*[@title='Manifested']")
	public WebElement manifestElement;
	
	@FindBy(xpath = "//div[@class='input-box light']/*//input[@class='native-input sc-ion-input-md']")
    public WebElement clickpackStationElement;

	@FindBy(xpath = "//*[text()=' Priority : ']")
	public WebElement clickonerecord;

	@FindBy(xpath = "//*[text()='Ship Confirm']")
	public WebElement clickship;

	//AR 23.2 changes
	//@FindBy(xpath = "//div[@class='modal-wrapper sc-ion-modal-md']/*//input[@class='native-input sc-ion-input-md']")
  //  public WebElement clickpackStationElement;

	@FindBy(xpath = "//input[@placeholder='Select']")
	public WebElement sendtext;
	
	@FindBy(xpath = "//input[@placeholder='Select' and @class='native-input sc-ion-input-md']")
	public WebElement sendtext1;

	@FindBy(xpath = "//button[@class='icon-box ng-star-inserted svg-icon']")
	public WebElement sendreturntext;

	@FindBy(xpath = "//*[text()='SELECT A PACK STATION']")
    public WebElement objPackstation;

	@FindBy(xpath = "//*[text()='START RECEIVING ']")
	public WebElement startReceivingElement;

	@FindBy(xpath = "//*[text()='Return Station UI']")
	public WebElement objreturnPackstation;

	@FindBy(xpath = "//ion-button[@data-component-id='com-manh-cp-dcorder-packStationOrder-content-reset-btn']")
	public WebElement objResetBtn;

	@FindBy(xpath = "//*[text()='Item:']/ancestor::div[@class='content']/descendant::ion-input/input")
	public WebElement serialTextBox;

	@FindBy(xpath = "//span[contains(text(),'Pack Station')]/ancestor::div[@class='right-panel']/descendant::div[@class='checkbox-container']/ion-button")
	public WebElement clickdonebtn;

	@FindBy(xpath = "//span[contains(text(),'LEVI RETURN STATION')]/ancestor::div[@class='right-panel']/descendant::div[@class='checkbox-container']/ion-button")
	public WebElement clickreturnbtn;

	@FindBy(xpath = "//modal-content/descendant::ion-button")
	public WebElement clickGoBtnElement;

	@FindBy(xpath = "//ion-button[contains(@class,'increment-decrement-buttons')]")
	public WebElement clickPlusElement;

	@FindBy(xpath = " ORDER DETAILS ")
	public WebElement clickdropPage;

	///////////////////////////////////////////////// PAGE Methods
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	public void selectPackStationOptionRecord() {

		if (Display(packStation2Element)) {
			new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(packStation2Element));
			try {
				clickElement(packStation2Element);
			} catch (Exception e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", packStation2Element);
			}
		}

	}

	public void acceptendTote() {

		try {
			new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(AcceptendToteElement));
			clickElement(AcceptendToteElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", AcceptendToteElement);
		}
	}

	public void oKendTote() {

		try {
			new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(OKToteElement));
			clickElement(OKToteElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", OKToteElement);
		}
	}

	public void endTote() {

		try {
			new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(endToteElement));
			clickElement(endToteElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", endToteElement);
		}
	}

	public void clickPackStationDropdown() throws InterruptedException {
		if (Display(packStationDropdownElement)) {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(packStationDropdownElement));
			try {
				clickElement(packStationDropdownElement);
			} catch (Exception e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", packStationDropdownElement);
			}
		}

	}

	public void clickStartPackingBtn() {

		

		try {
			new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(startPackingBtnElement));
			clickElement(startPackingBtnElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", startPackingBtnElement);

		}
	}

	public void enterToteText(String tote) throws InterruptedException {
		
		Thread.sleep(8000);
		
		if (Display(toteElement)) {
			new WebDriverWait(driver, 12).until(ExpectedConditions.visibilityOf(toteElement));
			enterText(toteElement, tote);
			pressEnterKey(toteElement);
			
			Thread.sleep(6000);

		}else {
			
			System.out.println("text box not present");
		}
		
	}

	public void enterDoText(String tote) throws InterruptedException {
		if (Display(doElement)) {
			Thread.sleep(3000);
			new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(doElement));
			enterText(doElement, tote);
			pressEnterKey(doElement);

		}

	}
public void wavesearch(String waveSearch) throws InterruptedException {
		
	Thread.sleep(3000);
			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(enterpackOLPNElement));
			enterText(enterpackOLPNElement, waveSearch);
			pressEnterKey(enterpackOLPNElement);
			pressEnterKey(enterpackOLPNElement);
			
			Thread.sleep(3000);
	}
		
	
	public void enterItemText(String itemBarCode) throws InterruptedException {
		
       Thread.sleep(3000);
		
		if (Display(itemElement)) {
			new WebDriverWait(driver, 12).until(ExpectedConditions.visibilityOf(itemElement));
			enterText(itemElement, itemBarCode);
			pressEnterKey(itemElement);
			
			Thread.sleep(6000);

		}else {
			
			System.out.println("text box not present");
		}
		
	}
		
	

	public void enterReturnItemText(String itemBarCode) throws InterruptedException {
		if (Display(returnItemElement)) {
			WaitforPage(5000);
			// new
			// WebDriverWait(driver,120).until(ExpectedConditions.visibilityOf(itemElement));
			enterText(returnItemElement, itemBarCode);
			pressEnterKey(returnItemElement);
		}
		WaitforPage(5000);

	}

	public void getQuantityNumber() {
		String quantityNo = getText(quantityElement);
		System.out.println("Quantity Displayed Is: " + quantityNo);
	}

	public void clickPlusBtn(int Qty) throws InterruptedException {

		System.out.println("===============================out" + Integer.toString(Qty));

		for (int i = 0; i < Qty; i++) {

			System.out.println("===============================in" + Integer.toString(Qty));

			WaitforPage(7000);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", clickPlusElement);

			System.out.println("===============================click" + Integer.toString(Qty));

			WaitforPage(7000);

		}
	}

	/*
	 * js.executeScript(
	 * "document.querySelector(\"ion-button[data-component-id='com-manh-cp-dcorder-pack-station-view-grid-incrementquantity-btn']\").shadowRoot.querySelector(\"button\").click();"
	 * );
	 */

	public void clickTicBtn() {

		try {
			new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(tickElement));
			clickElement(tickElement);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", tickElement);

		}

	}

	public void getEstimatedWeightText() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(estimatedWeightElement));
		String weight = getText(estimatedWeightElement).toString();
		System.out.println("Estimated Weight Is: " + weight);

	}

	public void enterActualWeightText(String actualweight) throws InterruptedException {
		if (Display(tickElement)) {
			Thread.sleep(10000);
			enterText(actualWeightElement, actualweight);
			pressEnterKey(actualWeightElement);
		}

	}

	public void clickManifestBtn() throws InterruptedException {
		try {
			new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(manifestBtnElement));
			clickElement(manifestBtnElement);
			Thread.sleep(2000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", manifestBtnElement);
			Thread.sleep(2000);
		}

	}

	public void verifyToastMsg() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(toastMsgElement));
		String message = getText(toastMsgElement);
		System.out.println("Pack Sation Operation ststus is: " + message);

	}

	public void clickMenuToggle() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(startMenuToggleElement));
			clickElement(startMenuToggleElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", startMenuToggleElement);
		}
	}

	public void enterOrdersSearch(String order) throws InterruptedException {
		enterText(ordersSearchElement, order);
		try {
			clickElement(ordersSearchElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ordersSearchElement);
		}
		pressTabKey(ordersSearchElement);
		pressEnterKey(ordersSearchElement);
		new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(manifestElement));
	}

	public void getOrderStatus() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(manifestElement));
		String orderStatus = getText(manifestElement).toString();
		System.out.println("Order Status Is: " + orderStatus);

	}

	public void clickDonerightClick() throws AWTException, InterruptedException {

		WaitforPage(6000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", clickdonebtn);
		WaitforPage(6000);

	}

	public void clickReturnTikbtn() throws AWTException, InterruptedException {

		WaitforPage(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", clickreturnbtn);
		WaitforPage(4000);

	}

	public void btnshipconform() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickonerecord));
			clickElement(clickship);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickship);
		}

	}

	public void selectrecord() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clickonerecord));
			clickElement(clickonerecord);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickonerecord);
		}

	}

	public void clickPackkStation() throws InterruptedException {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(objPackstation));
			clickElement(clickpackStationElement);

			Thread.sleep(2000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickpackStationElement);
		}

	}

	public void clickReturnUI() throws InterruptedException {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(objreturnPackstation));
			clickElement(objreturnPackstation);

			Thread.sleep(2000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", objreturnPackstation);
		}

	}

	
	public void clickSelectDisposition() throws InterruptedException {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(clickDepositionElement));
			clickElement(clickDepositionElement);

			Thread.sleep(2000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickDepositionElement);
		}

	}

	public void clickSelableButton() throws InterruptedException {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(btnSellableElement));
			clickElement(btnSellableElement);

			Thread.sleep(2000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", btnSellableElement);
		}

	}

	public void clickWeighManifestBtn() throws InterruptedException {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(btnWmanifetElement));
			clickElement(btnWmanifetElement);

			Thread.sleep(2000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", btnWmanifetElement);
		}

	}

	
	public void clickSelableDropdown() throws InterruptedException {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(clickSelableElement));
			clickElement(clickSelableElement);

			Thread.sleep(2000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickSelableElement);
		}

	}

	public void btnReceive() throws InterruptedException {

		WaitforPage(3000);
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", clickReceiveElement);
		WaitforPage(3000);

	}

	public void btnGenerate() throws InterruptedException {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(clickGenerateElement));
			clickElement(clickGenerateElement);

			Thread.sleep(2000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickGenerateElement);
		}

		WaitforPage(4000);

	}

	public String getAsnsNumberBLR() {

		String taskGroupNo = getText(getBLRasnsNo);
		System.out.println("Asns Number is: " + taskGroupNo);

		return taskGroupNo;
	}

	public String getLpns() throws InterruptedException {

		WaitforPage(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String LpnNo = (String) js.executeScript("return document.querySelector(\"input[placeholder='LPNs']\").value;");

		WaitforPage(1000);

		System.out.println("Lpns is: " + LpnNo);

		return LpnNo;
	}

	public void sendReturntext() throws InterruptedException {

		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript(
				"document.querySelector(\"div > scan-return-popup > ion-content > form > autocomplete > div > button\").click();");
		WaitforPage(4000);

		jse.executeScript(
				"document.querySelector(\"div.popover.dynamic.ng-star-inserted > ion-list > ion-item > ion-label\").click();");

	}

	public void sendReturnPrinter() throws InterruptedException {

try {
	
		WaitforPage(4000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", prtBtnElement);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(selectptrBtnElement));
		WaitforPage(5000);
		
		js.executeScript("arguments[0].click();", selectptrBtnElement);
		
} catch (Exception e) {
	
	WaitforPage(4000);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", prtBtnElement);

	new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(selectptrBtnElement));
	WaitforPage(5000);
	
	js.executeScript("arguments[0].click();", selectptrBtnElement);
	
	
   }

		
	}
	
	public void clickPrinterBtn() throws AWTException, InterruptedException {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(clicksetprinterElement));
			clickElement(clicksetprinterElement);

			Thread.sleep(2000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clicksetprinterElement);
		}

		WaitforPage(4000);

	}

	public void receiveBtn() throws AWTException, InterruptedException {

		WaitforPage(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click()", startReceivingElement);

	}

	public void sendpackstation2(String menuSearch) throws InterruptedException {

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(sendtext));

		enterText(sendtext, menuSearch);

		clickElement(packStation2Element);

	}
	
	public void sendpackstation12(String menuSearch) throws InterruptedException {

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(sendtext));

		enterText(sendtext1, menuSearch);

		clickElement(packStation2Element);

	}

	public void sendpackstation3(String menuSearch) throws InterruptedException {

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(sendtext));

		enterText(sendtext, menuSearch);

		clickElement(packStation3Element);

	}

	public void sendpackstation1(String menuSearch) throws InterruptedException {

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(sendtext));

		enterText(sendtext, menuSearch);

		clickElement(packStation1Element);

	}
	public void sendpackstation11(String menuSearch) throws InterruptedException {

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(sendtext));

		enterText(sendtext1, menuSearch);

		clickElement(packStation1Element);

	}

	public String autoGenSerialNo() throws InterruptedException {

		WaitforPage(4000);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddmmSSSSddSSSS");// 333333333333333000000
		LocalDateTime now = LocalDateTime.now();
		String SerialNo = dtf.format(now).toString() + "0";
		System.out.println("serial number is" + SerialNo);
		WaitforPage(4000);
		return SerialNo;

	}

	public void enterSerialNumber(String userName) throws InterruptedException {
		enterText(serialTextBox, userName);
		WaitforPage(8000);

	}

	public void clickGoBtnPack() throws InterruptedException {

		WaitforPage(3000);
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", clickGoBtnElement);
		WaitforPage(3000);

	}

	public void serialConform() throws InterruptedException {

		WaitforPage(4000);
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", serialconfirmbtn);
		WaitforPage(4000);

	}

	public void resetBtn() throws InterruptedException {

		WaitforPage(4000);

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(objResetBtn));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"ion-button[data-component-id='com-manh-cp-dcorder-packStationOrder-content-reset-btn']\").shadowRoot.querySelector(\"button\").click();");

		WaitforPage(4000);

	}

	public void orderInstrucConBtn() throws InterruptedException {

		WaitforPage(5000);
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", clickWrapInstElement);
		WaitforPage(5000);

	}

	public void BtnManifestate() throws InterruptedException {

		WaitforPage(7000);
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", manifestBtnElement);
		WaitforPage(5000);

		WaitforPage(5000);
	}

	public void dropdownCurrentPage() throws InterruptedException, AWTException {

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", endToteElement);

		Thread.sleep(3000);

	}
	
	public void clickNormalPlusBtn() throws InterruptedException {

        try {

            WaitforPage(7000);

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", clickPlusElement);

            System.out.println("===============================click");

            WaitforPage(7000);

        } catch (Exception e) {

        }
    }

}
