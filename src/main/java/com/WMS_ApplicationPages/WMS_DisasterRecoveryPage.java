package com.WMS_ApplicationPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WMS_Utilities.WMS_WebDriverUtilities;

public class WMS_DisasterRecoveryPage extends WMS_WebDriverUtilities {

	WebDriver driver;

	public WMS_DisasterRecoveryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/////////////////////////////////////////////////  PAGE OBJECTS  //////////////////////////////////////////////////////////////

	@FindBy(xpath="//ion-item[@data-component-id='levidrreceivinglpn']")
	public WebElement receivingLpnElement;
	
	@FindBy(xpath="//input[@data-component-id='acceptlpn_barcodetextfield_lpn']")
	public WebElement scanLpnElement;
	
	@FindBy(xpath="//*[text()='Go'][@data-component-id='acceptlpn_barcodetextfield_go']")
	public WebElement goElement_acceptlpn;
	
	@FindBy(xpath="//*[@data-component-id='action_back_button']")
	public WebElement actionBaackElement;

	/////////////////////////////////////////////////  PAGE Methods  //////////////////////////////////////////////////////////////


	public void clickReceivingLpn() {
		try {
			new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(receivingLpnElement));
			clickElement(receivingLpnElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", receivingLpnElement);
		}

	}
	
	

	public void scanLpn(String Lpn) {
		new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(scanLpnElement));
			enterText(scanLpnElement,Lpn);
	}
	
	public void clickGoBtn(WebElement goElement) throws InterruptedException {

		try {
			clickElement(goElement);
			//new WebDriverWait(driver,20).until(ExpectedConditions.invisibilityOf(goElement));
			//Thread.sleep(2000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", goElement);
			//new WebDriverWait(driver,20).until(ExpectedConditions.invisibilityOf(goElement));
			//Thread.sleep(2000);
		}

	}

	public void clickActionBackBtn() throws InterruptedException  {

		try {
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(actionBaackElement));
			clickElement(actionBaackElement);
			Thread.sleep(2000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", actionBaackElement);
			Thread.sleep(2000);
		}

	}

	
















}
