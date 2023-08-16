package com.WMS_ApplicationPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WMS_Utilities.WMS_WebDriverUtilities;

public class WMS_WVMobilePage extends WMS_WebDriverUtilities {

	WebDriver driver;
	WebDriverWait wait;

	public WMS_WVMobilePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	///////////////////////////////////////////////// PAGE OBJECTS
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	@FindBy(xpath = "//ion-label[@data-component-id='disasterrecovery']")
	public WebElement disasterRecoveryElement;

	@FindBy(xpath = "//*[text()='LEVI Disposition']")
	public WebElement leviDispositionElement;

	@FindBy(xpath = "//*[text()='Confirm']")
	public WebElement clickSummitILPNElement;

	@FindBy(xpath = "//ion-item[@data-component-id='levisplitilpn']")
	public WebElement splitLPNElement;

	@FindBy(xpath = "//ion-item[@data-component-id='leviilpnconditioncodeapply']")
	public WebElement leviConditionCodeElement;

	@FindBy(xpath = "//*[text()='CYCLE COUNT']/ancestor::ion-list[@class='md list-md list-lines-inlet list-md-lines-inlet hydrated']/descendant::ion-label[text()='LEVI Cycle Count']")
	public WebElement leviCondCodeElement;

	@FindBy(xpath = "//*[text()='LEVI Print Outbound Documents']")
	public WebElement leviPrintOudboundElement;

	@FindBy(xpath = "//ion-item[@data-component-id='leviilpnconditioncoderemove']")
	public WebElement leviremoveCodeElement;

	@FindBy(xpath = "//ion-label[@data-component-id='inventorymanagementilpn']")
	public WebElement inventoryManagementIlpnElement;

	@FindBy(xpath = "//*[text()='Settings']")
	public WebElement settingsElement;

	@FindBy(xpath = "//*[text()='LEVI Create iLPN']")
	public WebElement clickcreateLeviElement;

	@FindBy(xpath = "/html/body/app-root/manh-overlay-container/autocomplete-overlay[3]/div[6]/ion-list/ion-item/ion-label")
	public WebElement clickuserIDElement;

	@FindBy(xpath = "//*[text()='LEVI Modify iLPN']")
	public WebElement clickModifyLeviElement;

	@FindBy(xpath = "//*[text()='Continue Count Action']")
	public WebElement clickContinueCountElement;

	@FindBy(xpath = "//*[@class='setting-value item md in-list ion-focusable hydrated' and @data-component-id='taskgroup']")
	public WebElement taskGroupElement;

	@FindBy(xpath = "//*[@data-component-id='taskgroup_lookupurl']")
	public WebElement chooseTaskGroupElement;

	@FindBy(xpath = "//*[text()='Go']")
	public WebElement goElement;
	
	@FindBy(xpath = "//*[contains(text(),'LEVI_Exception_Putwall_OB_Sort')]/ancestor::app-workflow/descendant::ion-button[@class='md button button-small button-solid ion-activatable ion-focusable hydrated']")
	public WebElement shadowgoElement;

	@FindBy(xpath = "//*[text()='Accept']")
	public WebElement acceptElement;

	@FindBy(xpath = "//*[text()='Continue Count Action']")
	public WebElement counterElement;

	@FindBy(xpath = "//*[text()='Done']")
	public WebElement doneElement;

	@FindBy(xpath = "//*[text()=' SAVE']")
	public WebElement saveElement;

	@FindBy(xpath = "//ion-label[@data-component-id='putaway']")
	public WebElement putAwayElement;

	@FindBy(xpath = "//*[@class='section-item item-label item md in-list ion-focusable hydrated'][3]")
	public WebElement tasksElement;

	@FindBy(xpath = "//*[text()=' Tasks ']")
	public WebElement entertasksElement;

	@FindBy(xpath = "//*[text()=' CHASE ']")
	public WebElement enterCaseElement;

	@FindBy(xpath = "//*[text()=' PRINT ']")
	public WebElement enterPrintElementElement;

	@FindBy(xpath = "//*[@class='menu-node'][5]/ion-item")
	public WebElement inentoryMgmttasksElement;

	@FindBy(xpath = "//*[text()='Enter Task']")
	public WebElement enterTaskElement;

	@FindBy(xpath = "//*[text()='LEVI Locate oLPN Cubby']")
	public WebElement enterCubbyElement;

	@FindBy(xpath = "//*[text()='LEVI Exception Putwall Sort']")
	public WebElement enterExputwallElement;

	@FindBy(xpath = "//*[text()='LEVI Create iLPN']")
	public WebElement createIlpnElement;

	@FindBy(xpath = "//*[text()='LEVI Modify iLPN']")
	public WebElement ModifyIlpnElement;

	@FindBy(xpath = "//ion-col[@class='md hydrated']/*")
	public WebElement getTaskNumberElement;

	@FindBy(xpath = "//*[@placeholder='Enter Task']")
	public WebElement enterTaskIdElement;

	@FindBy(xpath = "//*[@placeholder='Scan Container']")
	public WebElement enterContainerElement;

	@FindBy(xpath = "//*[@placeholder='Scan Sorter']")
	public WebElement enterChasewallElement;

	@FindBy(xpath = "//*[@placeholder='Scan Item']")
	public WebElement enteritemwallElement;

	@FindBy(xpath = "//*[@placeholder='Scan Source Container']")
	public WebElement enterSorceToteElement;

	@FindBy(xpath = "//*[@placeholder='Scan Location']")
	public WebElement enterDestChaseElement;

	@FindBy(xpath = "//*[text()='Go']//ancestor::div[2]/preceding-sibling::div//descendant::ion-col[2]")
	public WebElement enterWMitem1Element;

	@FindBy(xpath = "//ancestor::div[@class='datatable-body-cell-label']/descendant::span")
	public WebElement enterLeviitem1Element;

	@FindBy(xpath = "//*[@placeholder='Scan iLPN']")
	public WebElement enterToteElement;

	@FindBy(xpath = "//*[@placeholder='Scan Item']")
	public WebElement enterbarCodeElement;

	@FindBy(xpath = "//input[@data-component-id='acceptquantity_naturalquantityfield_units']")
	public WebElement enterQtyElement;

	@FindBy(xpath = "//*[text()='Tap To Confirm']")
	public WebElement tapToConfrimElement;

	@FindBy(xpath = "//*[text()='Pick Exception']")
    public WebElement pickExcepElement;

	@FindBy(xpath = "//*[@placeholder='Scan Cart']")
	public WebElement scanCartIdElement;

	//
	//@FindBy(xpath = "//button[@class='alert-button ion-focusable ion-activatable sc-ion-alert-md'][2]/child::span[@class='alert-button-inner sc-ion-alert-md']")
	@FindBy(xpath = "//span[contains(@class, 'alert-button-inner sc-ion-alert-md') and text() = 'Confirm']")
	public WebElement confirmElement;

	@FindBy(xpath = "//*[@type='text' and @placeholder='Scan Location']")
	public WebElement scanLocationElement;

	@FindBy(xpath = "//*[@type='text' and @placeholder='Scan Location']")
	public WebElement getLocationElement;

	@FindBy(xpath = "//*[contains(text(),'Item')]/ancestor::ion-item[@class='item-display-component active item md in-list ion-focusable hydrated']/descendant::ion-col[@class='value md hydrated']")
	public WebElement scanitemElement;

	@FindBy(xpath = "//*[@type='text' and @placeholder='Scan Item']")
	public WebElement textitemElement;

	@FindBy(xpath = "//*[@type='text' and @class='input-field ng-valid ng-dirty ng-touched']")
	public WebElement verifymultisunitsElement;

	@FindBy(xpath = "//input[@class='input-field ng-pristine ng-valid ng-touched']")
	public WebElement multisUnitsElement;

	@FindBy(xpath = "//*[@type='text' and @placeholder='Scan Location']")
	public WebElement DesLocationElement;

	@FindBy(xpath = "//*[@type='text' and @placeholder='Scan Container']")
	public WebElement DesContainerElement;

	@FindBy(xpath = "//*[@data-component-id='acceptlocation_barcodetextfield_location']")
	public WebElement scanLocationIdElement;

	@FindBy(xpath = "//*[contains(text(),'Units')]")
	public WebElement multiswrapUnitUIElement;

	@FindBy(xpath = "//*[text()=' SLOT1 ']")
	public WebElement wmslotoneElement;
//AR23.2 xpath got changes
	/*
	 * @FindBy(xpath =
	 * "//*[contains(text(),'Location')]/ancestor::ion-item[@class='active item md in-list ion-focusable hydrated']/descendant::ion-col[@class='value md hydrated']"
	 * ) public WebElement getLocElement;
	 */
	@FindBy(xpath = "//*[contains(text(),'Location')]/ancestor::ion-item[@class='active item-has-start-slot item md item-lines-default item-fill-none in-list hydrated']/descendant::ion-col[@class='value md hydrated']")
	public WebElement getLocElement;

	@FindBy(xpath = "//*[text()=' SLOT2 ']")
	public WebElement wmslotTwoElement;
	
	@FindBy(xpath = "//*[contains(text(),'Container')]/ancestor::ion-item[@class='active item md item-lines-default item-fill-none in-list hydrated']/descendant::ion-col[@class='value md hydrated']")
	public WebElement scanDesLocationIdElement;
//AR23.2 xpath change
	/*
	 * @FindBy(xpath =
	 * "//*[contains(text(),'Container')]/ancestor::ion-item[@class='active item md in-list ion-focusable hydrated']/descendant::ion-col[@class='value md hydrated']"
	 * ) public WebElement scanDesLocationIdElement;
	 */

	@FindBy(xpath = "//*[@type='text' and @placeholder='Scan Item']")
	public WebElement scanItemElement;

	@FindBy(xpath = "//*[@data-component-id='acceptquantity_quantityfield_units']")
	public WebElement unitsElement;

	@FindBy(xpath = "//*[@placeholder='Scan Tote']")
	public WebElement scanToteElement;

	@FindBy(xpath = "//*[@placeholder='Scan iLPN']")
	public WebElement conditionToteElement;

	@FindBy(xpath = "//*[@placeholder='Scan Location']")
	public WebElement enterLocationElement;

	@FindBy(xpath = "//*[@placeholder='Scan oLPN']")
	public WebElement enterOlpnElement;

	@FindBy(xpath = "//*[contains(text(),'Item')]/ancestor::ion-grid/descendant::input")
	public WebElement enterItemBarElement;

	@FindBy(xpath = "//*[text()='End of Container(s). (PPK::0078)']")
	public WebElement informationMessageElement;
	//ARI 23.2 changes
	/*
	 * @FindBy(xpath =
	 * "//*[contains(text(),'Destination Locatio')]/ancestor::ion-item[@class='active item md in-list ion-focusable hydrated']/descendant::ion-col[@class='value md hydrated']"
	 * ) public WebElement scanDestinationLocationIdElement;
	 */
	
	@FindBy(xpath = "//*[contains(text(),'Destination Location')]/ancestor::ion-item[@class='active item-has-start-slot item md item-lines-default item-fill-none in-list hydrated']/descendant::ion-col[@class='value md hydrated']")
	public WebElement scanDestinationLocationIdElement;

	@FindBy(xpath = "//*[contains(text(),'Location')]/ancestor::ion-item[@class='active item md in-list ion-focusable hydrated']/descendant::ion-col[@class='value md hydrated']")
	public WebElement scanDestinationDrElement;

	@FindBy(xpath = "//*[contains(text(),'Item')]/ancestor::ion-item[@class='item-display-component active item md in-list ion-focusable hydrated']/descendant::ion-col[@class='value md hydrated']")
	public WebElement scanitemsElement;

	/*
	 * @FindBy(xpath =
	 * "//*[@data-component-id='acceptlocation_barcodetextfield_location']") public
	 * WebElement scanLocationIdElement;
	 */
	@FindBy(xpath = "//*[text()='Ok']")
	public WebElement okElement;

	@FindBy(xpath = "//input[@data-component-id='acceptsourceilpn_barcodetextfield_sourceilpn']")
	public WebElement sourceiLPNElement;

	@FindBy(xpath = "//input[@data-component-id='acceptquantity_naturalquantityfield_units']")
	public WebElement availableUnitElement;
	
	@FindBy(xpath = "//ion-col[contains(@size, '6') and contains(@class, 'value md hydrated')]")
    public WebElement getCurrentUnitsElement;
	
	@FindBy(xpath = "//input[contains(@class, 'input-field ng-pristine ng-valid ng-touched') and contains(@type, 'tel')]")
    public WebElement DesLocUnitElement;

	@FindBy(xpath = "//input[@data-component-id='acceptquantity_quantityfield_units']")
	public WebElement checkUnitElement;

	@FindBy(xpath = "//input[@data-component-id='acceptdestinationilpn_barcodetextfield_destinationilpn']")
	public WebElement destinationiLPNElement;

	@FindBy(xpath = "//input[@data-component-id='acceptlocation_barcodetextfield_destinationlocation']")
	public WebElement verifydestinationElement;

	@FindBy(xpath = "//input[@data-component-id='acceptcontainerforsinglescan_barcodetextfield_container']")
	public WebElement scanContainerElement;

	@FindBy(xpath = "//input[@placeholder='Scan Source iLPN']")
	public WebElement ilpndrElement;

	@FindBy(xpath = "//ion-button[@data-component-id='action_settings_button']")
	public WebElement settingsButtonElement;

	@FindBy(xpath = "//*[text()='Scan Cart']/ancestor::ion-row/following-sibling::ion-row/ion-col/input")
	public WebElement elements;

	@FindBy(xpath = "//ion-col[@data-component-id='taskgroup']")
	public WebElement taskgroupButtonElement;

	@FindBy(xpath = "//ion-col[@data-component-id='printer']")
	public WebElement printJournalButtonElement;

	@FindBy(xpath = "//div[@data-component-id='eventcyclecount']")
	public WebElement eventCycleButtonElement;

	@FindBy(xpath = "//span[@class='dropdown-icon']")
	public WebElement taskgroupDropDownElement;

	@FindBy(xpath = "//ion-label[text()='LEVI Make Put Cart']")
	public WebElement makePutCartElement;

	@FindBy(xpath = "//input[@placeholder='Cart ID']")
	public WebElement acceptCartidElement;

	@FindBy(xpath = "//*[@data-component-id='verifypickcart_barcodetextfield_scancart']")
	public WebElement verifyCartidElement;

	@FindBy(xpath = "//input[@data-component-id='verifypickcart_barcodetextfield_scancart']")
	public WebElement verifyExCartElement;

	@FindBy(xpath = "//input[@data-component-id='acceptlocation_barcodetextfield_scanlocation']")
	public WebElement verifylocationElement;

	@FindBy(xpath = "//input[@data-component-id='acceptitem_barcodetextfield_scanitem']")
	public WebElement verifybarcodeElement;

	@FindBy(xpath = "//*[@placeholder='Scan Item']")
	public WebElement itemFrmSplitElement;

	@FindBy(xpath = "//input[@placeholder='Scan Container']")
	public WebElement acceptToteIDElement;

	@FindBy(xpath = "//*[contains(text(),'End Cart')]")
	public WebElement endCartButtonElement;

	@FindBy(xpath = "//ion-col[@data-component-id='acceptlocationforputcart_barcodetextfield_location']")
	public WebElement locationLabelElement;

	@FindBy(xpath = "//input[@data-component-id='acceptlocationforputcart_barcodetextfield_scanlocation']")
	public WebElement locationInputElement;

	@FindBy(xpath = "//input[@data-component-id='acceptsourceilpnwithitemforputcart_barcodetextfield_scancontainer']")
	public WebElement scanContainerInputElement;

	@FindBy(xpath = "//input[@data-component-id='acceptitemforputcart_barcodetextfield_scanitem']")
	public WebElement scanItemBarCodeInputElement;

	@FindBy(xpath = "//ion-col[@data-component-id='acceptsourceilpnwithitemforputcart_barcodetextfield_slot']")
	public WebElement slotTextElement;

	@FindBy(xpath = "//input[@data-component-id='acceptitem_barcodetextfield_item']")
	public WebElement itemBarCodeMulipleSKUElement;

	@FindBy(xpath = "//*[text()='WM Mobile']")
	public WebElement btnwmmobileElement;

	@FindBy(xpath = "//*[contains(text(),'Ok')]")
	public WebElement btnOKElement;

	@FindBy(xpath = "//*[text()='Employee Timeline']")
	public WebElement btnemTimeLineElement;

	@FindBy(xpath = "//*[text()='Add New']")
	public WebElement addNewUserElement;

	@FindBy(xpath = "//*[text()='Confirm']")
	public WebElement splitILPNElement;

	@FindBy(xpath = "//*[text()='Clock-in Clock-out']")
	public WebElement clockinClockOutElement;

	@FindBy(xpath = "//*[text()='Clock-out']")
	public WebElement ClockOutElement;

	@FindBy(xpath = "//*[text()=' Damaged ']")
	public WebElement btnDamaged;

	@FindBy(xpath = "//input[@placeholder='Date Time']")
	public WebElement btnCalandar;

	@FindBy(xpath = "//*[text()=' Event Cycle Count ']")
	public WebElement btnEventcycleElement;

	@FindBy(xpath = "//ancestor::ion-input[@class='ng-valid sc-ion-input-md-h sc-ion-input-md-s md hydrated ng-touched ng-dirty ion-valid ion-touched ion-dirty']/input")
	public WebElement enterManualElement;

	@FindBy(xpath = "//*[text()='Condition Code']/ancestor::ion-row/following-sibling::ion-row/ion-col/descendant::span")
	public WebElement clickConditionDropDown;

	@FindBy(xpath = "//span[@data-component-id='removeconditioncode_lookuptextfield_presentlookupmodal']")
	public WebElement clickRemoveDropDown;

	@FindBy(xpath = "//*[text()=' CYCLE COUNT ']")
	public WebElement cycleCountElement;

	@FindBy(xpath = "//input[@data-component-id='acceptquantity_naturalquantityfield_units']")
	public WebElement cycleCountUnitElement;

	@FindBy(xpath = "//span[@data-component-id='acceptreasoncode_lookuptextfield_presentlookupmodal']")
	public WebElement clickReasoneDropDown;

	@FindBy(xpath = "//*[contains(text(),' units')]")
	public WebElement getQtysizeID;
	/*
	 * //AR23.2
	 * 
	 * @FindBy(xpath =
	 * "//*[contains(text(),'Destination Location')]/ancestor::ion-item[@class='input-area item md in-list ion-focusable hydrated']/descendant::ion-col/input"
	 * ) public WebElement deslocationElement;
	 */
	
	@FindBy(xpath = "//*[contains(text(),'Destination Location')]/ancestor::ion-item[@class='input-area item md item-lines-default item-fill-none in-list ion-focusable hydrated']/descendant::ion-col/input")
    public WebElement deslocationElement;

	@FindBy(xpath = "//*[text()=' SAVE']")
	public WebElement clickSavebtn;
	
	@FindBy(xpath = "//*[contains(text(),'M-IND')]/ancestor::ion-item[@class='active item md in-list ion-focusable hydrated']/descendant::ion-col[@class='value md hydrated']")
	public WebElement checkWaveDetails;

	@FindBy(xpath = "//*[text()='Employee:']/ancestor::modal-item[@class='employee-selector']/descendant::ion-input/input")
	public WebElement employeeNameElement;

	 @FindBy(xpath = "//*[contains(text(),'Units')]/ancestor::ion-router-outlet[@id='content']/descendant::ion-col[@class='value md hydrated' and @size='6']")
	public WebElement getQtyOutboundElement;
	 
	 @FindBy(xpath = "//*[contains(text(),'Enter Quantity')]/ancestor::div[@class='guided-display user-inputs-wrapper']/descendant::ion-col[@class='md hydrated']/input")
	 public WebElement enterUnitOutboundElement;
	 
	 
	 
	
	// input[@data-component-id='acceptitem_barcodetextfield_item']
	// CartID
	// ion-col[@data-component-id='acceptsourceilpnwithitemforputcart_barcodetextfield_cartid']
	// Slot
	// ion-col[@data-component-id='acceptsourceilpnwithitemforputcart_barcodetextfield_slot']
	// ItemBarCode
	// input[@data-component-id='acceptitemforputcart_barcodetextfield_scanitem']
	// Click go

	///////////////////////////////////////////////// PAGE Methods
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	public void enterAcceptCartidElement(String CartID) {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(acceptCartidElement));
			clickElement(acceptCartidElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", acceptCartidElement);
		}
		enterText(acceptCartidElement, CartID);

	}

	public void enterItemBarCodeMulipleSKUElement(String ItemBarCode) {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(itemBarCodeMulipleSKUElement));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", itemBarCodeMulipleSKUElement);

			enterText(itemBarCodeMulipleSKUElement, ItemBarCode);
			clickGoBtn();
		} catch (Exception e) {
			System.out.println("Single SKU");
		}

	}

	public void enterscanItemBarCodeInputElement(String ItemBarCode) {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(scanItemBarCodeInputElement));
			clickElement(scanItemBarCodeInputElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", scanItemBarCodeInputElement);
		}
		enterText(scanItemBarCodeInputElement, ItemBarCode);

	}

	public void enterScanContainerInputElement(String ToteID) {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(scanContainerInputElement));
			clickElement(scanContainerInputElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", scanContainerInputElement);
		}
		enterText(scanContainerInputElement, ToteID);

	}

	public void enterLocationInputElement(String Location) {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(locationInputElement));
			clickElement(locationInputElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", locationInputElement);
		}
		enterText(locationInputElement, Location);

	}

	public String getLocationLabelElement() {

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(locationLabelElement));
		return getText(locationLabelElement).replace("-", "");

	}

	public String getSlotTextElement() {

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(slotTextElement));
		return getText(slotTextElement);

	}

	public void enterAcceptToteIDElement(String ToteID) {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(acceptToteIDElement));
			clickElement(acceptToteIDElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", acceptToteIDElement);
		}
		enterText(acceptToteIDElement, ToteID);

	}

	public void enterScanContainer(String Tote) {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(scanContainerElement));
			clickElement(scanContainerElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", scanContainerElement);
		}
		enterText(scanContainerElement, Tote);
	}

	public void enterDRilpnTote(String Tote) {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(ilpndrElement));
			clickElement(ilpndrElement);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ilpndrElement);
		}
		enterText(ilpndrElement, Tote);
	}

	public void selectTaskGroup(String option) {
		WebElement wbDropOption = null;
		try {
			String dropOption = option.toLowerCase();
			wbDropOption = driver.findElement(
					By.xpath("//setting-popover/*//button[ion-label[@data-component-id='" + dropOption + "']]"));
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(wbDropOption));
			clickElement(wbDropOption);
			System.out.println("Normal Click");
		} catch (Exception e) {
			System.out.println("js Click");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", wbDropOption);
		}

	}

	public void selectPrintGroup(String option) {
		WebElement wbDropOption = null;
		try {
			String dropOption = option.toLowerCase();
			System.out.println("enter xpath: " + "//setting-popover/*//button[ion-label[@data-component-id='"
					+ dropOption.replace(" ", "").toLowerCase() + "']]");

			wbDropOption = driver.findElement(By.xpath("//setting-popover/*//button[ion-label[@data-component-id='"
					+ dropOption.replace(" ", "").toLowerCase() + "']]"));
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(wbDropOption));
			clickElement(wbDropOption);
			System.out.println("Normal Click");

		} catch (Exception e) {

			System.out.println("enter xpath");
			System.out.println("js Click");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", wbDropOption);
		}

	}

	public void clicktaskgroupDropDownButton() {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(taskgroupDropDownElement));
			clickElement(taskgroupDropDownElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", taskgroupDropDownElement);
		}

	}

	public void clickendCartButton() {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(endCartButtonElement));
			clickElement(endCartButtonElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", endCartButtonElement);
		}

	}

	public void clickSettingsButton() {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(settingsButtonElement));
			clickElement(settingsButtonElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", settingsButtonElement);
		}

	}

	public void clickMakePutCart() {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(makePutCartElement));
			clickElement(makePutCartElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", makePutCartElement);
		}

	}

	public void clickTaskGroupRow() {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(taskgroupButtonElement));
			clickElement(taskgroupButtonElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", taskgroupButtonElement);
		}

	}

	public void clickPrintJournalGroupRow() {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(printJournalButtonElement));
			clickElement(printJournalButtonElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", printJournalButtonElement);
		}

	}

	public void clickReasonCode() {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(taskgroupButtonElement));
			clickElement(taskgroupButtonElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", taskgroupButtonElement);
		}

	}

	public void clickEventCyleCount() {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(eventCycleButtonElement));
			clickElement(eventCycleButtonElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", eventCycleButtonElement);
		}

	}

	public void enterSourceiLPN(String iLPN) {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(sourceiLPNElement));
			clickElement(sourceiLPNElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", sourceiLPNElement);
		}
		enterText(sourceiLPNElement, iLPN);

	}

	public void enterAvailableUnit(String Unit) {

		try {
			new WebDriverWait(driver, 12).until(ExpectedConditions.visibilityOf(availableUnitElement));
			clickElement(availableUnitElement);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", availableUnitElement);
		}

		enterText(availableUnitElement, Unit);

	}
	
	public void enterAvailableUnit1(String Unit) throws InterruptedException {

		 


        WaitforPage(3000);

 

        String text2 = getText(getCurrentUnitsElement);

        String LocationIdText = text2.trim().replace(" Units", "");

 

        enterText(DesLocUnitElement, LocationIdText);

 

        WaitforPage(3000);

 

    }

	public void enterDestinationiLPN(String Tote) {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(destinationiLPNElement));
			clickElement(destinationiLPNElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", destinationiLPNElement);
		}
		enterText(destinationiLPNElement, Tote);
	}

	public void clickSplitLPN() {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(splitLPNElement));
			clickElement(splitLPNElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", splitLPNElement);
		}

	}

	public void clickRemoveCode() {
		try {
			new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(leviremoveCodeElement));
			clickElement(leviremoveCodeElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", leviremoveCodeElement);
		}

	}

	public void clickConditionCode() {
		try {
			new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(leviConditionCodeElement));
			clickElement(leviConditionCodeElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", leviConditionCodeElement);
		}

	}

	public void clickLiveCycleCountBtn() throws InterruptedException {

		try {
			new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(leviCondCodeElement));
			clickElement(leviCondCodeElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", leviCondCodeElement);
		}

	}

	public void clickLeviOutBoundBtn() {
		try {
			new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(leviPrintOudboundElement));
			clickElement(leviPrintOudboundElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", leviPrintOudboundElement);
		}

	}

	public void clickLeviDisposition() {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(leviDispositionElement));
			clickElement(leviDispositionElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", leviDispositionElement);
		}

	}

	public void clickDisasterRecovery() {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(disasterRecoveryElement));
			clickElement(disasterRecoveryElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", disasterRecoveryElement);
		}

	}

	public void clickinventoryManagementIlpn() {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(inventoryManagementIlpnElement));
			clickElement(inventoryManagementIlpnElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", inventoryManagementIlpnElement);
		}

	}

	public void clickSettingsBtn() {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(settingsElement));
			clickElement(settingsElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", settingsElement);
		}

	}

	public void clickTaskGroup() {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(taskGroupElement));
			clickElement(taskGroupElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", taskGroupElement);
		}

	}

	public void chooseTaskGroup(String taskGroup) {
		enterText(chooseTaskGroupElement, taskGroup);

	}
	
	public void ManulayEnterOty(String text) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(enterUnitOutboundElement));
        enterText(enterUnitOutboundElement, text);
    }

	public void clickGoBtn() throws InterruptedException {

		try {
			new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(goElement));
			clickElement(goElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", goElement);
		}
		Thread.sleep(5000);

	}
	
	public void MultipleConfirmationBtn() throws InterruptedException {
        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(confirmElement));
        String status1 = confirmElement.getText();
        if (status1.contains(status1)) {
            while (status1.contains(status1)) {
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                clickElement(confirmElement);
                status1 = confirmElement.getText();
                System.out.println(status1);
                System.out.println("Again Confirmation button presents");
            }
        }
    }
	
	public void clickShadowGoBtn() throws InterruptedException {

		WaitforPage(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", shadowgoElement);
		WaitforPage(4000);
	}

	public void clickAcceptBtn() throws InterruptedException {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(acceptElement));
			clickElement(acceptElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", acceptElement);
		}
		Thread.sleep(8000);
		// new WebDriverWait(driver, 5000);

	}

	public void clickCountAction() throws InterruptedException {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(counterElement));
			clickElement(counterElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", counterElement);
		}
		Thread.sleep(8000);
		// new WebDriverWait(driver, 5000);

	}

	public void clickDoneBtn() throws InterruptedException {
		WaitforPage(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", doneElement);
		WaitforPage(4000);

	}

	public void clickPutAwayBtn() {
		try {
			clickElement(putAwayElement);
		} catch (Exception e) {
			System.out.println("Putaway js click");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", putAwayElement);
		}

	}

	public void clicktasksBtn() {

		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(entertasksElement));
			clickElement(entertasksElement);
			pressEnterKeyAWT(entertasksElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", entertasksElement);

		}

	}

	public void clickChaseBtn() {

		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(enterCaseElement));
			clickElement(enterCaseElement);
			pressEnterKeyAWT(enterCaseElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", enterCaseElement);

		}

	}

	public void clickPrintBtn() {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(enterPrintElementElement));
			clickElement(enterPrintElementElement);
			pressEnterKeyAWT(enterPrintElementElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", enterPrintElementElement);

		}

	}

	public void clickInventoryIlpnBtn() {

		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(inentoryMgmttasksElement));
			clickElement(inentoryMgmttasksElement);
			pressEnterKeyAWT(inentoryMgmttasksElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", inentoryMgmttasksElement);

		}

	}

	public void clickModifyInventoryIlpnBtn() {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(inentoryMgmttasksElement));
			clickElement(inentoryMgmttasksElement);
			pressEnterKeyAWT(inentoryMgmttasksElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", inentoryMgmttasksElement);

		}

	}

	public void clickCubbyBtn() {

		try {
			new WebDriverWait(driver, 6).until(ExpectedConditions.visibilityOf(enterCubbyElement));
			clickElement(enterCubbyElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", enterCubbyElement);
		}

	}

	public void clickExpPutwallBtn() {

		try {
			new WebDriverWait(driver, 6).until(ExpectedConditions.visibilityOf(enterExputwallElement));
			clickElement(enterExputwallElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", enterExputwallElement);
		}

	}

	public void clickEnterTaskBtn() {

		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(enterTaskElement));
			clickElement(enterTaskElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", enterTaskElement);
		}

	}
	
		

	public void clickLeviIlpnbtn() {
		try {
			clickElement(createIlpnElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", createIlpnElement);
		}

	}

	public void modifyLeviIlpnbtn() {
		try {
			clickElement(ModifyIlpnElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ModifyIlpnElement);
		}

	}

	public String getTaskNumber() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(enterTaskIdElement));
		String taskNo = getText(enterTaskIdElement);
		System.out.println("Task Number is: " + taskNo);
		return taskNo;
	}

	public String getitemNumber1WMmobile() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(enterWMitem1Element));
		String taskNo = getText(enterWMitem1Element);
		System.out.println("item Number 1 WM  is: " + taskNo);
		return taskNo.trim();
	}

	public String getitemNumberFrmLevi() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(enterLeviitem1Element));
		String taskNo = getText(enterLeviitem1Element);
		System.out.println("item Number 1 WM  is: " + taskNo);
		return taskNo.trim();
	}

	public String wmSlotOne() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(wmslotoneElement));
		String taskNo1 = getText(wmslotoneElement);
		System.out.println("single tote present " + taskNo1);
		return taskNo1.trim();
	}

	public String wmSlotTwo() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(wmslotTwoElement));
		String taskNo2 = getText(wmslotTwoElement);
		System.out.println("double tote present " + taskNo2);
		return taskNo2.trim();
	}

	public void enterTaskId(String taskNo) {

		enterText(enterTaskIdElement, taskNo);
	}

	public void enterScanCubbyOlpn(String taskNo) {

		enterText(enterContainerElement, taskNo);
	}

	public void enterChasewall(String taskNo) {

		enterText(enterChasewallElement, taskNo);
	}

	public void enteritemWall(String taskNo) {

		enterText(enteritemwallElement, taskNo);
	}

	public void enterSourceTote(String taskNo) {

		enterText(enterSorceToteElement, taskNo);
	}

	public String removebarDestChase(String chaseid1) {

		String chase2 = chaseid1.replaceAll("\\-", "");

		System.out.println(chase2);

		return chase2;

	}

	public void enterDestChase(String chaseid1) {

		enterText(enterDestChaseElement, chaseid1);

	}

	public void enterIlpnTote(String taskNo) {

		enterText(enterToteElement, taskNo);
	}

	public void enterIlpnBar(String taskNo) {

		enterText(enterbarCodeElement, taskNo);
	}

	public void enterQtyIlpn(String i) {

		enterText(enterQtyElement, i);
	}

	public void clickTapToConfrimBtn() {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(tapToConfrimElement));
			clickElement(tapToConfrimElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", tapToConfrimElement);
		}

	}

	

	public void clickPickExcep() {
        try {
            new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(pickExcepElement));
            clickElement(pickExcepElement);
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", pickExcepElement);
        }



   }
	
	public void ConfirmBtn() throws InterruptedException {
        try {
            new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(confirmElement));
            clickElement(confirmElement);
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", confirmElement);
        }
    }
	
	public void scanCartId(String cartId) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(tapToConfrimElement));
		enterText(scanCartIdElement, cartId);

	}

	public void clickConfirmBtn() throws InterruptedException {

		WaitforPage(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", confirmElement);
			WaitforPage(5000);
		}

	public void clickPixSortConfirmBtn() throws InterruptedException {

		WaitforPage(4000);

	JavascriptExecutor js = (JavascriptExecutor) driver;

	js.executeScript(
			"document.querySelector(\"div > div.alert-button-group.sc-ion-alert-md > button:nth-child(2) > span\").click();");
	WaitforPage(4000);
	}
	
	
	public void clickSortConfirmBtn() throws InterruptedException {

		WaitforPage(4000);

	JavascriptExecutor js = (JavascriptExecutor) driver;

	js.executeScript(
			"document.querySelector(\"div > div.alert-button-group.sc-ion-alert-md > button:nth-child(2) > span\").click();");
	WaitforPage(4000);
	}
	
	public void enterLocationID() {

		String text = getText(scanLocationIdElement);

		String LocationIdText = text.replaceAll("\\-", "");

		System.out.println(LocationIdText);

		enterText(scanLocationElement, LocationIdText);

	}

	public String displayLocationID() {

		String text = getText(scanLocationIdElement);

		String LocationIdText = text.replaceAll("\\-", "");

		System.out.println(LocationIdText);
		return LocationIdText;

	}

	public String getLocBarcode() {

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(scanLocationIdElement));
		String text = getText(scanLocationIdElement);

		String LocationIdText = text.replaceAll("\\-", "");

		System.out.println("The Location Barcode is" + LocationIdText);
		return LocationIdText;

	}

	public String verifyUnits() throws InterruptedException {

		WaitforPage(2000);

		String text = getText(multiswrapUnitUIElement);

		String LocationIdText = text.trim().replace(" Units", "");

		System.out.println(LocationIdText);
		return LocationIdText;

	}

	public void enterDesLocationID() throws InterruptedException {

		WaitforPage(4000);

		String text = getText(scanDesLocationIdElement);

		String LocationIdText = text.replaceAll("\\-", "");

		System.out.println(LocationIdText);

		enterText(DesLocationElement, LocationIdText);

	}

	public void enterDestinationLocationID(String destinationLocationId) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(scanLocationElement));
		enterText(scanLocationElement, destinationLocationId);

	}

	public void scanItemId(String itemId) {

		enterText(scanItemElement, itemId);

	}

	public void enterUnits(String units) {
		enterText(unitsElement, units);

	}

	public void scanToteId(String toteId) {
		enterText(scanToteElement, toteId);

	}

	public void enterConditionToteId(String toteId) {
		enterText(conditionToteElement, toteId);

	}

	public void enterLocationBar(String toteId) {
		enterText(enterLocationElement, toteId);

	}

	public void enterOlpnsPrint(String toteId) {
		enterText(enterOlpnElement, toteId);

	}

	public void entercycleItemBar(String toteId) {
		enterText(enterItemBarElement, toteId);

	}

	public void getInformationMessageAndClickOk() throws InterruptedException {

		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(informationMessageElement));
			clickElement(okElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", okElement);

		}

		WaitforPage(4000);
	}

	public void enterDestinationLocationID() {

		String text = getText(scanDestinationLocationIdElement);

		String DestinationLocationIdText = text.replaceAll("\\-", "");
		System.out.println(DestinationLocationIdText);

		enterText(scanLocationElement, DestinationLocationIdText);

	}

	public void enterDrDestinationLocationID() {

		String text = getText(scanDestinationDrElement);

		String DestinationLocationIdText = text.replaceAll("\\-", "");
		System.out.println(DestinationLocationIdText);

		enterText(scanLocationElement, DestinationLocationIdText);

	}

	public void entergetLoc() throws InterruptedException {

		WaitforPage(3000);

		String text2 = getText(getLocElement);

		String LocationIdText = text2.replaceAll("\\-", "");

		System.out.println(LocationIdText);

		enterText(DesLocationElement, LocationIdText);

	}

	public void enterDrDestinationToteID() throws InterruptedException {

		WaitforPage(4000);

		String text1 = getText(scanDesLocationIdElement);

		String LocationIdText = text1.replaceAll("\\-", "");

		System.out.println(LocationIdText);

		enterText(DesContainerElement, LocationIdText);

	}

	public String enterItemID() {

		String item = getText(scanitemElement);

		return item;

	}

	public void enterItemIDbarcodePutwall(String text) {

		enterText(textitemElement, text);

	}

	public void clickWmbtn() {
		try {
			new WebDriverWait(driver, 6).until(ExpectedConditions.elementToBeClickable(btnwmmobileElement));
			clickElement(btnwmmobileElement);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", btnwmmobileElement);
		}

	}

	public void clickOKbutton() throws InterruptedException {
		WaitforPage(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"div > div.alert-button-group.sc-ion-alert-md > button > span\").click();");
		WaitforPage(4000);

	}

	public void clickEmpTimeLine() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(btnemTimeLineElement));
			clickElement(btnemTimeLineElement);
		} catch (Exception e) {
			System.out.println("inside menu toggle method ET line");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", btnemTimeLineElement);
		}

	}

	public void addNewUser() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(addNewUserElement));
			clickElement(addNewUserElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", addNewUserElement);
		}

	}

	public void EndconfirmationBtn() throws InterruptedException {

		WaitforPage(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"#ion-overlay-39 > div > div.alert-button-group.sc-ion-alert-md > button:nth-child(2)\").click();");
		WaitforPage(2000);

	}

	public void confirmationBtn() throws InterruptedException {

		WaitforPage(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"div > div.alert-button-group.sc-ion-alert-md > button:nth-child(2)\").click();");
		WaitforPage(2000);

	}

	public void CockoutDropDown() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(ClockOutElement));
			clickElement(ClockOutElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ClockOutElement);
		}

	}

	public void CockInoutDropDown() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(clockinClockOutElement));
			clickElement(clockinClockOutElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clockinClockOutElement);
		}

	}

	public void clickConditionDropDown() {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(clickConditionDropDown));
			clickElement(clickConditionDropDown);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickConditionDropDown);
		}

	}

	public void clickRemoveDropDown() {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(clickRemoveDropDown));
			clickElement(clickRemoveDropDown);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickRemoveDropDown);
		}
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(btnDamaged));
	}

	public void clickDamagedBtn() throws InterruptedException {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(btnDamaged));
			clickElement(btnDamaged);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", btnDamaged);
		}
		Thread.sleep(3000);
	}

	public void SettingsButton() throws InterruptedException {
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"#content > app-menu > ion-footer > ion-toolbar > ion-buttons > ion-button:nth-child(1)\").click()");

		Thread.sleep(6000);
	}

	public void enterTaskid(String menuSearch) throws InterruptedException {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(getTaskNumberElement));
		enterText(getTaskNumberElement, menuSearch);
		Thread.sleep(2000);
		pressEnterKey(getTaskNumberElement);

	}

	public void enterEmployeeName(String menuSearch) throws InterruptedException {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(employeeNameElement));
		enterText(employeeNameElement, menuSearch);
		Thread.sleep(2000);
		pressEnterKey(employeeNameElement);

	}

	public void oneclicktask() throws AWTException, InterruptedException {

		WebElement element = driver.findElement((By) entertasksElement);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void enterVerifyCartidElement(String cart) throws InterruptedException {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(elements));
		enterText(elements, cart);
		Thread.sleep(2000);
		pressEnterKey(elements);

		

	}

	public void enterExportCartidElement(String menuSearch) {

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(verifyCartidElement));
		enterText(verifyCartidElement, menuSearch);

	}

	public void enterVerifylocation() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebElement locationElement = (WebElement) jse
				.executeScript("return document.querySelector(\"ion-col\").shadowRoot.querySelector(\"input\");");

		String js = "arguments[0].setAttribute('value', 'MZ0202210G01')";

		((JavascriptExecutor) driver).executeScript(js, locationElement);
	}
	
	public void getQtyOutbound() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(getQtyOutboundElement));
        String taskNo = getText(getQtyOutboundElement);
        String LocationIdText = taskNo.trim().replace(" Units", "");
        enterText(enterUnitOutboundElement, LocationIdText);
    }
	
	public String SaveQtyOutbound() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(getQtyOutboundElement));
        String taskNo = getText(getQtyOutboundElement);
        String LocationIdText = taskNo.trim().replace(" Units", "");
        return LocationIdText;
    }

	public void enteritemBar(String menuSearch) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(verifybarcodeElement));
		enterText(verifybarcodeElement, menuSearch);
	}

	public void enteritemBarFrmSplit(String menuSearch) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(itemFrmSplitElement));
		enterText(itemFrmSplitElement, menuSearch);
	}

	public void verifyAvailableUnit(String Unit) {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(checkUnitElement));
			clickElement(checkUnitElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", checkUnitElement);
		}
		enterText(checkUnitElement, Unit);

	}

	public void enterCycleCountUnits(String Unit) {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(cycleCountUnitElement));
			clickElement(cycleCountUnitElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", cycleCountUnitElement);
		}
		enterText(cycleCountUnitElement, Unit);

	}

	public boolean wmVeryDestID() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(checkWaveDetails));
		boolean taskNo1 = checkWaveDetails.isDisplayed();
		System.out.println("single tote present " + taskNo1);
		return taskNo1;


	}
	
	
	public void verifyDestination(String Tote) throws InterruptedException {

		WaitforPage(3000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].value='" + Tote + "'", deslocationElement);
		WaitforPage(3000);
	}

	public void clickSaveBtn() throws InterruptedException {

		WaitforPage(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", saveElement);
		WaitforPage(4000);

	}

	public void clickCycleCountBtn() throws AWTException {

		try {
			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(cycleCountElement));
			clickElement(cycleCountElement);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", cycleCountElement);

		}

	}

	public void clickBackBtn() throws InterruptedException {

		WaitforPage(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"ion-buttons[data-component-id='action_back_button']\").shadowRoot.querySelector(\"button\").click();");
		WaitforPage(4000);

	}

	public void enterTime(String timeIn) throws InterruptedException {

		WaitforPage(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"single-date-selection\").shadowRoot.querySelector(\"modal-container > div > div > modal-content > ion-row:nth-child(3) > ion-row.range-container.md.hydrated > ion-col:nth-child(2) > div > input\").value=\""
						+ timeIn + "\"");
		WaitforPage(2000);

	}

	public void enterTimeOut(String timeOut) throws InterruptedException {

		WaitforPage(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"div > div.two-col-grid > modal-item.ng-star-inserted > div:nth-child(2) > div > ion-input > input\").value=\""
				+ timeOut + "\"");
				//"document.querySelector(\"single-date-selection\").shadowRoot.querySelector(\"modal-container > div > div > modal-content > ion-row:nth-child(3) > ion-row.range-container.md.hydrated > ion-col:nth-child(2) > div > input\").value=\""
						//+ timeOut + "\"");
		WaitforPage(2000);

	}

	public void clickApplybtnIn() throws InterruptedException {

		WaitforPage(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"single-date-selection\").shadowRoot.querySelector(\"modal-container > div > modal-footer > div > div.right > button.active-button.float-right.ion-float-right\").click();");
		WaitforPage(4000);

	}

	public void clickApplybtnOut() throws InterruptedException {

		WaitforPage(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"single-date-selection\").shadowRoot.querySelector(\"modal-container > div > modal-footer > div > div.right > button.active-button.float-right.ion-float-right\").click();");
		WaitforPage(4000);

	}

	public void clicksaveBtn() {

		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(clickcreateLeviElement));
			clickElement(clickcreateLeviElement);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickcreateLeviElement);

		}

	}

	public void clickLeviCreateBtn() {

		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(clickcreateLeviElement));
			clickElement(clickcreateLeviElement);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickcreateLeviElement);

		}

	}

	public void clickLeviMotifyBtn() {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(clickModifyLeviElement));
			clickElement(clickModifyLeviElement);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickModifyLeviElement);

		}
	}

	public void clickReasonDropDown() {
		try {
			new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(clickReasoneDropDown));
			clickElement(clickReasoneDropDown);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickReasoneDropDown);
		}
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(btnEventcycleElement));
	}

	public void clickEventCycleBtn() throws InterruptedException {

		try {
			new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(btnEventcycleElement));
			clickElement(btnEventcycleElement);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", btnEventcycleElement);
		}
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(doneElement));
		WaitforPage(3000);
	}

	public int reduceQty() throws InterruptedException, AWTException {

		int initialQty = Integer.parseInt(getText(getQtysizeID).replace(" units", ""));

		return initialQty;

	}

	public void clickrequiredPrinter(WMS_DashboardPage dashboardPage, String printType) throws InterruptedException {
		WaitforPage(5000);

		WebElement allocatedElement2 = driver.findElement(By.xpath("//*[text()='" + " " + printType + " " + "']"));

		clickElement(allocatedElement2);

	}

	public void continueCountBtn() {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(clickContinueCountElement));
			clickElement(clickContinueCountElement);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickContinueCountElement);

		}
	}

	public void clickSummitILPNM() throws InterruptedException {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(clickSummitILPNElement));
			clickElement(clickSummitILPNElement);
		} catch (Exception e) {
			System.out.println("Connection Lag exception");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickSummitILPNElement);

		}
		WaitforPage(5000);

	}

	public void enterUserId(String userId) throws InterruptedException, AWTException {

		Robot robot = new Robot();
		WebElement key = driver.findElement(By.xpath("//input[@placeholder='Select Employees']"));

		key.sendKeys(userId);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void clickUserId() throws InterruptedException, AWTException {

		WaitforPage(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
			//	"document.querySelector(\"body > app-root > manh-overlay-container > autocomplete-overlay:nth-child(3) > div.popover.dynamic.ng-star-inserted > ion-list > ion-item > ion-label\").click();");
		"document.querySelector('body > app-root > manh-overlay-container > autocomplete-overlay:nth-child(3) > div.popover.dynamic.ng-star-inserted > ion-list > ion-item > ion-label').click();");
				//"document.querySelector(\"body > app-root > manh-overlay-container > autocomplete-overlay:nth-child(3) > div.popover.dynamic > ion-list > ion-item > ion-label\").click();");

	}

	public void clickCalendarOutBtn() throws InterruptedException {

		WaitforPage(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"#ion-overlay-38 > add-cico-modal > modal-container > div > div > modal-content > form > div > div.two-col-grid > modal-item.ng-star-inserted > div:nth-child(2) > div > button > ion-icon\").shadowRoot.querySelector(\"div\").click();");
				
				//"document.querySelector(\"div > add-cico-modal > modal-container > div > div > modal-content > form > div > div.two-col-grid > modal-item:nth-child(3) > div:nth-child(2) > div > button\").click();");
	}

	public void clicOKBtn() throws InterruptedException {

		WaitforPage(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(document.querySelector(\"div > div.alert-button-group.sc-ion-alert-md > button > span\").click();");
	}

	public void clickCalendarInBtn() throws InterruptedException {

		WaitforPage(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"div > div.two-col-grid > modal-item:nth-child(3) > div:nth-child(2) > div > button > ion-icon\").shadowRoot.querySelector(\"div\").click();");
				//"document.querySelector(\"div > add-cico-modal > modal-container > div > div > modal-content > form > div > div.two-col-grid > modal-item:nth-child(3) > div:nth-child(2) > div > button\").click();");
	}

}
