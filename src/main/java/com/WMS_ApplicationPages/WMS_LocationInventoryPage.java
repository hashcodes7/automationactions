package com.WMS_ApplicationPages;


import java.util.List;
import java.util.concurrent.TimeUnit;
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

public class WMS_LocationInventoryPage extends WMS_WebDriverUtilities {

	WebDriverWait wait;
	WebDriver driver;

	public WMS_LocationInventoryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/////////////////////////////////////////////////  PAGE OBJECTS  //////////////////////////////////////////////////////////////	

	@FindBy(xpath="//span[@title='Location Barcode']/parent::filter-field-header/ion-button")
	public WebElement locationSearchElementExpand;
	
	@FindBy(xpath="//*[contains(text(),'Location Barcode')]/ancestor::div[@class='field-container no-padding']/descendant::input[@class='native-input sc-ion-input-md']")
	public WebElement locationSearchBarElement;
	
	@FindBy(xpath="name=ion-input-4")
	public WebElement locationSearchBarElement1;
	
	@FindBy(xpath="//*[text()='Item ']/ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement locationSearchItemElement;

	@FindBy(xpath="//*[text()='STORAGE']/ancestor::ion-item/descendant::ion-button")
	public WebElement recordExpandBarElement;

	@FindBy(xpath="//*[@class='ng-star-inserted item md in-list ion-focusable hydrated'][2]")
	public WebElement lpnElement;
	
	
	@FindBy(xpath = "//ui-dm-hamburger/ion-content//*[text()='Location Inventory']")
	public WebElement inventoryElement;
	
	@FindBy(xpath = "//*[text()=' Yes ']")
	public WebElement clickYesStatusElement;
	
	@FindBy(xpath = "//*[text()='BOOK COUNT ']")
	public WebElement clickBookElement;
	
	@FindBy(xpath = "//*[text()='Count:']/ancestor::div[@class='dm-flex-col-layout card-column dm-fill-space']/descendant::span[2]")
	public WebElement getUnitElement;
	
	@FindBy(xpath = "//*[text()='Inventory Count']")
	public WebElement btninventryCount;
	
	
	@FindBy(xpath = "//*[text()='APPLY CONDITIONS']")
	public WebElement applyCondElement;
	
	@FindBy(xpath = "//*[text()='REMOVE CONDITIONS']")
	public WebElement removeCondElement;
	
	@FindBy(xpath = "//*[text()='Inventory']")
	public WebElement inventCondElement;
	
	@FindBy(xpath = "//autocomplete/descendant::input[@placeholder='Please select Condition Codes']/ancestor::div[1]/button")
	public WebElement inventCondDropDownElement;
	
	@FindBy(xpath = "//*[text()=' Status : ']/ancestor::div[@class='dm-flex-row-layout field-row ng-star-inserted']/descendant::span")
	public WebElement clickStatusRecord;
	
//As x-path is changed as part of CD 67
	/*
	 * @FindBy(xpath =
	 * "//*[text()=' Status : ']/ancestor::div[@tabindex='0']/descendant::span[@class='field-value ng-star-inserted'][5]"
	 * ) public WebElement inventoryStatusElement;
	 */
	
	// 2167 25823
//changes as part of 67
    @FindBy(xpath = "//card-panel/div[1]/div/card-view/div/div[1]/div[1]")
    public WebElement inventoryStatusElement;
	
	
	@FindBy(xpath = "//*[contains(text(),'Location Inventory')]/ancestor::ion-list[@class='menu-no-padding md list-md hydrated']/descendant::button[2]")
	public WebElement btnLocCount;	
	
	@FindBy(xpath = "//*[text()='Location Barcode ']/ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement locBarSearchElement;
	
	@FindBy(xpath = "//*[text()='Location ']/ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement locIDSearchElement;
	
	
	@FindBy(xpath = "//span[contains(text(),'STORAGE')]/ancestor::ion-list[@class='md list-md hydrated']/descendant::div[@class='dm-flex-row-layout dm-fill-space card-row main-card isChild'][1]")
	public WebElement clickFirstStorage;
	
	@FindBy(xpath = "//span[contains(text(),'STORAGE')]/ancestor::ion-list[@class='md list-md hydrated']/descendant::div[@class='dm-flex-row-layout dm-fill-space card-row main-card isChild'][2]")
	public WebElement clickSecoundStorage;
	
	@FindBy(xpath="//*[text()='Damaged']")
	public WebElement btnDamaged; 
	
	@FindBy(xpath="//label/input[@type='checkbox']")
	public WebElement btnRemoveDamaged; 
	
	@FindBy(xpath="//ion-modal/descendant::button[contains(text(),'SUBMIT')]")
	public WebElement btnsummitElement;
	
	@FindBy(xpath = "//*[text()=' ACCEPT']")
	public WebElement AcceptendToteElement;
	
	@FindBy(xpath = "//*[text()='Display location ']/ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
    public WebElement displayLocSearchElement;
	
	@FindBy(xpath = "//*[contains(text(),'Remove Conditions')]")
	public WebElement insideremoveCondElement;
	
	@FindBy(xpath = "//*[text()='Count run ID ']/ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
    public WebElement CCIDSearchElement;
	
	@FindBy(xpath = "//card-panel/div[1]/div/card-view/div/div[1]/ancestor::div[1]/descendant::a")
	public WebElement getccidElement;
	
	
	
/////////////////////////////////////////////////  PAGE Methods  //////////////////////////////////////////////////////////////


	
	public void clickInventoryBtn() throws InterruptedException {
		
		
		WaitforPage(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", inventoryElement);
		
		

	}
	
	public void clickLocationInventorybtn() throws InterruptedException {
        try {
            new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(btnLocCount));
            clickElement(btnLocCount);
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", btnLocCount);
        }
    }
	
	public void inventoryLocBarsearch(String batchNo) throws InterruptedException {
        try {
            new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(locBarSearchElement));
            clickElement(locBarSearchElement);
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", locBarSearchElement);
        }
        enterText(locBarSearchElement, batchNo);
        pressEnterKey(locBarSearchElement);
        pressEnterKey(locBarSearchElement);
    }
	
	public void clickInventoryCount() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(btninventryCount));
			clickElement(btninventryCount);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", btninventryCount);
		}

	}
	
	public void inventoryBarsearch(String batchNo) throws InterruptedException {
		
		
		WaitforPage(2000);
		/* clickElement(locationSearchElementExpand); */
		enterText(locationSearchBarElement, batchNo);
		Thread.sleep(2000);
		pressEnterKey(locationSearchBarElement);
	
	}
	
	public void locInventoryExpBtn() throws InterruptedException {
		
		 try { 
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(recordExpandBarElement));
			clickElement(recordExpandBarElement);
			
			  } catch (Exception e) {
				  System.out.println("inside menu toggle method");
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("arguments[0].click();", recordExpandBarElement); }
			 
	}
	
		

	
	public int getTotalUnitCount() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(getUnitElement));
		String taskNo1 = getText(getUnitElement);
		System.out.println("The Unit Count is: " + taskNo1);
		return Integer.parseInt(taskNo1.replace(" Units", ""));
	}

	
	public void inventorysearch(String batchNo) throws InterruptedException {
		
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(locIDSearchElement));
		enterText(locIDSearchElement,batchNo);
		Thread.sleep(2000);
		pressEnterKey(locIDSearchElement);
		

	}

	public void clickStatusRecord() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(clickStatusRecord));
			clickElement(clickStatusRecord);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickStatusRecord);
		}

	}
	
	public void clickBook() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(clickBookElement));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].shadowRoot.querySelector(\"button\").click();", clickBookElement);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickBookElement);
		}

	}
	public void clickYesBtn() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(clickYesStatusElement));
			clickElement(clickYesStatusElement);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickYesStatusElement);
		}

	}
	
	public void pendingBookStatus(WMS_DashboardPage dashboardPage) throws InterruptedException {
        WaitforPage(5000);
        String Status = getText(inventoryStatusElement);
        System.out.println(Status);



       while (!Status.trim().equals("Pending Booking")) {
            dashboardPage.clickRefresh();
            WaitforPage(5000);
            Status = getText(inventoryStatusElement);
            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            System.out.println(Status);
        }
    }
	
public String getbookingStatus() {
			
		String taskGroupNo = getText(inventoryStatusElement);
		System.out.println("Task Group Number is: "+taskGroupNo);
		
		return taskGroupNo;
	}


public void clickFirstStorageTab() {
	try {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(clickFirstStorage));
		clickElement(clickFirstStorage);
	} catch (Exception e) {
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickFirstStorage);
	}

}
public void clickSecoundStorageTab() {
	try {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(clickSecoundStorage));
		clickElement(clickSecoundStorage);
	} catch (Exception e) {
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickSecoundStorage);
	}

}

public void inventoryitemsearch(String itemfromOrder1) throws InterruptedException {
	
	
	WaitforPage(2000);
	
	enterText(locationSearchItemElement, itemfromOrder1);

	Thread.sleep(2000);
	
	pressEnterKey(locationSearchItemElement);

	

}
public void inventoryitemsearch1(String itemfromOrder1,String itemfromOrder2) throws InterruptedException {
	
	
	WaitforPage(2000);
	
	enterText(locationSearchItemElement, itemfromOrder1, itemfromOrder2);

	Thread.sleep(2000);
	
	pressEnterKey(locationSearchItemElement);

	

}


public void clickApplyCond() {
	try {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(applyCondElement));
		clickElement(applyCondElement);
	} catch (Exception e) {
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", applyCondElement);
	}

}
public void clickInventoryCond() {
	try {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(inventCondElement));
		clickElement(inventCondElement);
	} catch (Exception e) {
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", inventCondElement);
	}

}
public void clickInventoryConddropdown() throws InterruptedException {
	
	try {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(inventCondDropDownElement));
		clickElement(inventCondDropDownElement);
	} catch (Exception e) {
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", inventCondDropDownElement);
	}

}
 
	


  public void clickDamagedBtn() {
	  
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(btnDamaged));
			clickElement(btnDamaged);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", btnDamaged);
		}
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(btnsummitElement));
	}
 
public void clickSummitBtn() {
	try {
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(btnsummitElement));
		clickElement(btnsummitElement);
	} catch (Exception e) {
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnsummitElement);
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
public void clickRemoveCond() {
	try {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(removeCondElement));
		clickElement(removeCondElement);
	} catch (Exception e) {
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", removeCondElement);
	}

}
public void clickRemoveDamagedBtn() {
	try {
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(btnRemoveDamaged));
		clickElement(btnRemoveDamaged);
	} catch (Exception e) {
		System.out.println("inside menu toggle method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnRemoveDamaged);
	}
	
}

public void locSoragesearch(String batchNo) throws InterruptedException { 
	try { new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(displayLocSearchElement)); 
	clickElement(displayLocSearchElement); 
	} 
	catch (Exception e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", displayLocSearchElement); 
		} enterText(displayLocSearchElement, batchNo);
		pressEnterKey(displayLocSearchElement); 
		}



public void insideRemoveCondbtn() { 
	try { 
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(insideremoveCondElement)); 
		clickElement(insideremoveCondElement); 
		} 
	catch (Exception e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click();", insideremoveCondElement);
		} 
	}

public void Cidsearch(String batchNo, WMS_DashboardPage dashboardPage) throws InterruptedException {

    try {

        new WebDriverWait(driver, 35).until(ExpectedConditions.visibilityOf(CCIDSearchElement));
        enterText(CCIDSearchElement, batchNo);
        pressEnterKey(CCIDSearchElement);
        pressEnterKey(CCIDSearchElement);
        dashboardPage.clickRefresh();
        dashboardPage.clickRefresh();
    
    } catch (Exception e) {

    }
}

public String getCCINumber() {

    new WebDriverWait(driver, 35).until(ExpectedConditions.visibilityOf(getccidElement));
    String taskGroupNo = getText(getccidElement);
    System.out.println("Task Group Number is: " + taskGroupNo);



    return taskGroupNo;
}


}

