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

public class WMS_OutboundManualSorter extends WMS_WebDriverUtilities {

	WebDriverWait wait;
	WebDriver driver;

	public WMS_OutboundManualSorter(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	///////////////////////////////////////////////// PAGE OBJECTS
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	@FindBy(xpath = "//span[contains(text(),'Description ')]/ancestor::div[@class='field-container no-padding']/descendant::ion-input[@class='search-text-input-margin ng-untouched ng-pristine ng-valid sc-ion-input-md-h sc-ion-input-md-s md hydrated ion-untouched ion-pristine ion-valid']/input")
	public WebElement searchdescribeElement;

	@FindBy(xpath = "//*[contains(text(),'Outbound Manual Sorter')]/ancestor::ion-list[@class='md list-md hydrated']/descendant::div/ion-list")
	public WebElement clickSorterMenuElement;

	@FindBy(xpath = "//*[contains(text(),' Chase Putwall 01 ')]")
	public WebElement putwallCSElement;

	@FindBy(xpath = "//*[contains(text(),'DETAILS ')]")
	public WebElement detailsPCWElement;

	@FindBy(xpath = "//*[contains(text(),'Yes')]")
	public WebElement yesWElement;
	
	
	@FindBy(xpath = "//*[contains(text(),' Yes ')]")
	public WebElement yesWElementinsideShadow;

	@FindBy(xpath = "//button[@class='icon-area ng-star-inserted']/ion-icon")
	public WebElement closeElement;

	@FindBy(xpath = "//ion-icon[@class='expand-header-icon md hydrated']")
	public WebElement clickPlusElement;

	@FindBy(xpath = "//ion-icon[@class='close']")
	public WebElement clickCloseCubbyElement;

	@FindBy(xpath = "//*[contains(text(),'Locatio')]/ancestor::ion-item[@class='active item md in-list ion-focusable hydrated']/descendant::ion-col[@class='value md hydrated']")
	public WebElement scanLocationIdElement;

	@FindBy(xpath = "//*[@type='text' and @placeholder='Scan Sort Location']")
	public WebElement scanWallLocationElement;

	@FindBy(xpath = "//*[contains(text(),'oLPN')]/ancestor::ion-item[@class='active item md in-list ion-focusable hydrated']/descendant::ion-col[@class='value md hydrated']")
	public WebElement scanOlpnIdElement;

	@FindBy(xpath = "//*[@placeholder='Scan Container']")
	public WebElement scanWallolpnElement;
	
	@FindBy(xpath = "//*[@placeholder='Scan Container']")
	public WebElement scanPUTWALLolpnElement;
	
	@FindBy(xpath = "//*[contains(text(),'Locatio')]/ancestor::ion-item[@class='active item md in-list ion-focusable hydrated']/descendant::ion-col[@class='value md hydrated']")
	public WebElement scanChaseElement;


	///////////////////////////////////////////////// PAGE Methods
	///////////////////////////////////////////////// //////////////////////////////////////////////////////////////

	public void searSorterDescribe(String text) throws InterruptedException {

		new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(searchdescribeElement));

		enterText(searchdescribeElement, text);
		clickElement(searchdescribeElement);
		pressEnterKey(searchdescribeElement);
		pressEnterKey(searchdescribeElement);

	}

	public void clickCSWrecord() {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(putwallCSElement));
			clickElement(putwallCSElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", putwallCSElement);
		}

	}

	public void clickDetailsBtn() {
		try {
			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(detailsPCWElement));
			clickElement(detailsPCWElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", detailsPCWElement);
		}

	}

	public void clickYesBtn() throws InterruptedException {

        WaitforPage(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"ion-content > div > wm-workflow-list > ion-list > div > div:nth-child(6) > div.guided-display.user-inputs-wrapper > div > boolean-field > ion-item > ion-grid > ion-row:nth-child(2) > ion-col > ion-buttons > ion-button.yes-button.boolean-button.disable-hover.md.button.button-small.button-clear.ion-activatable.ion-focusable.hydrated\").shadowRoot.querySelector(\"button > span\").click();");

		WaitforPage(4000);
		
	}


	

	public void closekPlusBtn() throws InterruptedException {

		WaitforPage(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", closeElement);

	}

	public void clickPlusBtn() {
		try {
			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(clickPlusElement));
			clickElement(clickPlusElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickPlusElement);
		}

	}

	public void clickCloseCubbyBtn() {
		try {
			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(scanLocationIdElement));
			clickElement(scanLocationIdElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", scanLocationIdElement);
		}

	}

	public String checkChaseLoc(String chstype) throws InterruptedException {

		WaitforPage(3000);

		WebElement chscheck = driver.findElement(By.xpath("//*[text()='" + chstype + "']"));

		String checkchase = getText(chscheck);
		System.out.println("chase wave details 1 : " + checkchase);
		return checkchase;

	}
	
	public void enterDesSortLocationText(String text) {

		
		new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(scanWallLocationElement));
		enterText(scanWallLocationElement, text);

	}
	
	public void enterChaseLocationID() {
        String text = getText(scanChaseElement);
        String DestinationLocationIdText = text.replaceAll("\\-", "");
        System.out.println(DestinationLocationIdText);
        enterText(scanWallLocationElement, DestinationLocationIdText);
    }
	

	public void enterDesSortLocationID() {

		String text = getText(scanLocationIdElement);

		String DestinationLocationIdText = text.replaceAll("\\-", "");

		System.out.println(DestinationLocationIdText);

		enterText(scanWallLocationElement, DestinationLocationIdText);

	}
	
public String enterOlpnSortALocationID() throws InterruptedException {
		
		WaitforPage(3000);
		
		String text1 = getText(scanOlpnIdElement);

		String DestinationLocationIdText = text1.replaceAll("\\-", "");
		
		return text1;

		/*
		 * System.out.println(DestinationLocationIdText);
		 * 
		 * enterText(scanPUTWALLolpnElement, DestinationLocationIdText);
		 * 
		 * WaitforPage(3000);
		 */

		
	}

	public void enterOlpnID(String loc) throws InterruptedException {
		
		WaitforPage(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"document.querySelector(\"wm-workflow-list > ion-list > div > div:nth-child(6) > div.guided-display.user-inputs-wrapper > div > text-input > ion-item > ion-grid > ion-row:nth-child(2) > ion-col:nth-child(1) > input\").value='" + loc + "'");

		WaitforPage(4000);
		
	}

	public void dropdownCubbyPage(String view) throws InterruptedException, AWTException {

		Thread.sleep(3000);
		WebElement chscheck = driver.findElement(By.xpath("//*[text()='" + view + "']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", chscheck);

		Thread.sleep(3000);

	}

	public void clickSorterMenu() throws InterruptedException {

		WaitforPage(4000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.querySelector(\"#ObManualSorter\").click();");

		WaitforPage(4000);

	}
}
