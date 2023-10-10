package com.WMS_ApplicationPages;

import java.awt.AWTException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
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

public class WMS_TasksPage extends WMS_WebDriverUtilities {

	WebDriverWait wait;
	WebDriver driver;

	public WMS_TasksPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	/////////////////////////////////////////////////  PAGE OBJECTS  //////////////////////////////////////////////////////////////	

	@FindBy(xpath="//*[@data-component-id='com-manh-cp-task-Task-lookup-dialog-filter-input-TaskDetail.OrderId']//*")
	public WebElement orderSearchElement;
	

	@FindBy(xpath="//*[@class='dm-flex-row-layout dm-fill-space card-row primary']")
	public WebElement taskRecordElement;
	
	@FindBy(xpath="//*[text()='ASSIGN ']")
	public WebElement assignBtnElement;
 
	@FindBy(xpath="//*[@placeholder='Current user']")
	public WebElement currentUserElement;
 
	@FindBy(xpath="//*[@class='more-button ng-star-inserted md button button-solid ion-activatable ion-focusable hydrated']")
	public WebElement hamburgerElement;
	
	@FindBy(xpath="//*[text()='Details']")
	public WebElement detailsElement;
	
	@FindBy(xpath="//*[text()='Assignable task groups']")
	public WebElement assignableTaskGroupElement;
	
	@FindBy(xpath="//*[text()='Assignable task group ']/ancestor::div[@class='expand-content ng-untouched ng-pristine ng-valid ng-star-inserted']/descendant::div[@class='manh-grid-cell left-align ng-star-inserted']")
	public WebElement getTaskGroupElement;
	
	@FindBy(xpath="//*[@class='icon-area ng-star-inserted']")
	public WebElement closeIconElement;
	
	@FindBy(xpath="//*[@slot='start']")
	public WebElement startMenuToggleElement;
	
	@FindBy(xpath = "//*[text()='Tasks']")
	public WebElement btntask;
	
	@FindBy(xpath = "//span[text()='Order ']/ancestor::filter-field-header/following-sibling::ion-row/descendant::ion-input/input")
	public WebElement TaskSearchElement;
	
	@FindBy(xpath = "//span[text()='Generation number ']/ancestor::div[@class='field-container no-padding']/descendant::ion-input/input")
	public WebElement WaveSearchElement;
	
	@FindBy(xpath = "//*[text()=' Priority : ']")
	public WebElement clicktaskrecord;
	
	@FindBy(xpath = "//*[text()=' SUBMIT ']")
	public WebElement submitElementAss;
	
	@FindBy(xpath = "//datatable-header/div/div[@class='datatable-row-center ng-star-inserted']")
	public WebElement tasksTableHeader;
	
	@FindBy(xpath = "//datatable-body/datatable-selection/datatable-scroller")
	public WebElement tasksTableBody;

	@FindBy(xpath = "//more-actions/*")
	public WebElement clicktaskthreedots;
	
	@FindBy(xpath = "//*[text()=' Task : ']/ancestor::div[@class='dm-flex-col-layout dm-fill-space card-column ng-star-inserted']/descendant::span[2]")
	public WebElement tasksidElement;
	
	@FindBy(xpath = "//*[text()=' Task : ']/ancestor::div[contains(@class,'dm-flex-col-layout')][1]/descendant::span[@class='field-value ng-star-inserted'][1]")
	public WebElement tasksNoElement;
	
	@FindBy(xpath = "//*[text()=' Related Links ']")
	public WebElement taskRLElememt;
	
	@FindBy(xpath = "//*[text()='Item']")
	public WebElement selectitemRLElememt;
	
	@FindBy(xpath = "//*[text()='Order ']")
	public WebElement objOrderElememt; 
	
	@FindBy(xpath = "//ion-button[@title='Refresh']")
	public WebElement refreshElement;
	
	
	@FindBy(xpath = "//ion-button[@data-component-id='com-manh-cp-dcorder-Order--more-actions']")
	public WebElement boxthreedots;
	
	@FindBy(xpath = "//*[text()='Task ']")
	public WebElement objtaskElememt;
	
	
	@FindBy(xpath = "//button[@data-component-id='com-manh-cp-task-Task-filter-field-header-clear-button']")
	public WebElement clearCalElement;   
	
	@FindBy(xpath = "//*[text()=' Related Links ']")
	public WebElement itemrelatedLinksElement;
	
	@FindBy(xpath = "//*[text()='Task Detail']")
	public WebElement taskDetailsElement;
	
	@FindBy(xpath = "//*[@class='ng-star-inserted item md in-list ion-focusable hydrated'][4]")
	public WebElement itemElement;
	
	@FindBy(xpath = "//*[text()=' Primary Barcode : ']/ancestor::div[@class='dm-flex-row-layout field-row ng-star-inserted']/descendant::span[2]")
	public WebElement itembarElement;


	@FindBy(xpath = "//*[text()='Item ']/ancestor::filter-field-header/following-sibling::ion-row/descendant::ion-input/input")
	public WebElement enteritemsearch;
	
	@FindBy(xpath = "//*[text()='Task ']/ancestor::filter-field-header/following-sibling::ion-row/descendant::ion-input/input")
	public WebElement taskidsearch;
	
	@FindBy(xpath = "//ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']/descendant::div[@class='priorityCircle ng-star-inserted']")
	public WebElement waverunStatusElement;
	
	@FindBy(xpath = "//*[@title='Generation number']/ancestor::filter-field-header/following-sibling::ion-row/descendant::ion-input/input")
    public WebElement Generationnumber;
	
/////////////////////////////////////////////////  PAGE Methods  //////////////////////////////////////////////////////////////

	public void enterOrderSearch(String order) throws InterruptedException {
		enterText(orderSearchElement,order);
		try {
			clickElement(orderSearchElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", orderSearchElement);
		}
		pressEnterKey(orderSearchElement);
		Thread.sleep(2000);
	}
	
	public void selectShipBtn(String text) throws InterruptedException {
        WebElement allocatedElement2= driver.findElement(By.xpath("//*[contains(text(),'"+text+"')]/ancestor::div[@class='row-container ng-star-inserted']/descendant::ion-checkbox"));
                clickElement(allocatedElement2);
                WaitforPage(4000);
            }
	
	public void scrollPage() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView();", orderSearchElement);
		
	}
	
	
	
	public void selectTaskRecord() {
		try {
			new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(taskRecordElement));
			clickElement(taskRecordElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", taskRecordElement);
		}

	}
	

	public void clickAssignBtn() {
		try {
			clickElement(assignBtnElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", assignBtnElement);
		}


	}
	
	public void enterCurrentUser(String userName) throws InterruptedException {
		
		WaitforPage(4000);
		enterText(currentUserElement,userName);
		
		pressEnterKey(currentUserElement);
		WaitforPage(4000);
		
		
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
	
	public void clickDetailsBtn() {
		try {
			clickElement(detailsElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", detailsElement);
		}


	}
	
	public void clickAssignableTaskGroup() {
		try {
			clickElement(assignableTaskGroupElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", assignableTaskGroupElement);
		}


	}
	
	
	
	public String getTaskGroupNumber() {
		
		String taskGroupNo = getText(getTaskGroupElement);
		System.out.println("Task Group Number is: "+taskGroupNo);
		
		return taskGroupNo;
	}
	
	
	public void clickCloseIcon() {
		try {
			clickElement(closeIconElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", closeIconElement);
		}


	}
	

	public void clickMenuToggle() {
		try {
			clickElement(startMenuToggleElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", startMenuToggleElement);
		}


	}
	
	public void clicktaskbutton() {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(btntask));
			clickElement(btntask);
		} catch (Exception e) {
			System.out.println("inside menu toggle method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", btntask);
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
	
public void TasksPageStatus(WMS_DashboardPage dashboardPage) throws InterruptedException {
	
	
	while (true){
	    
	    try {
	    	String Status2 = getText(waverunStatusElement);
	    } catch (Exception e) {
	    	
	    	dashboardPage.clickRefresh();
			WaitforPage(2000);
	    }
	    
	    }
		
}
		
public void readyForAssignStatus(WMS_DashboardPage dashboardPage) throws InterruptedException {
	
	WaitforPage(2000);
	String Status2 = getText(waverunStatusElement);
	System.out.println(Status2);
	
	

	while (!Status2.trim().equals("Ready For Assign...")) {
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


	public void enterTaskorderSearch(String order, WMS_DashboardPage dashboardpage) throws InterruptedException {
		
		
		try {

			new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(TaskSearchElement));
			enterText(TaskSearchElement, order);
			pressEnterKey(TaskSearchElement);
			pressEnterKey(TaskSearchElement);
			dashboardpage.clickRefresh();
			dashboardpage.clickRefresh();
			
			
		} catch (Exception e) {

			int i = 1;
			do {
				System.out.println(i);
				dashboardpage.clickRefresh();
				i++;
			} while (i <= 50);

		}

	}

		
	public void selectActionBtn(String text) throws InterruptedException {
		
		
		
		WebElement allocatedElement2= driver.findElement(By.xpath("//*[contains(text(),'"+text+"')]/ancestor::div[@class='row-container ng-star-inserted']/descendant::ion-checkbox"));
				
				clickElement(allocatedElement2);
				
				
				
				WaitforPage(4000);

			}
	
public void selectStatusBtn(String text) throws InterruptedException {
		
		
		
	WebElement allocatedElement2= driver.findElement(By.xpath("//*[contains(text(),'"+text+"')]/ancestor::div[@class='row-container ng-star-inserted']/descendant::ion-checkbox"));
	
	clickElement(allocatedElement2);
	
	
	
	WaitforPage(4000);

			}
	public void enterWaveSearch(String order, WMS_DashboardPage dashboardpage) throws InterruptedException {

		try {

		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(WaveSearchElement));
			clickElement(WaveSearchElement);
			
		} catch (Exception e) {
			System.out.println("Connection Lag exception");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", WaveSearchElement);

		}

		enterText(WaveSearchElement, order);
		pressEnterKey(WaveSearchElement);
		pressEnterKey(WaveSearchElement);
		}
	
	public void selectonetaskRC() {
		
		
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(clicktaskrecord));
			clickElement(clicktaskrecord);
			
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clicktaskrecord);
		}
}
	
	public void clickassignSubmit() throws InterruptedException {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(submitElementAss));
			clickElement(submitElementAss);
			Thread.sleep(1000);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", submitElementAss);
			Thread.sleep(1000);
		}

	}
	
	public void btntaskThreedots() throws AWTException, InterruptedException {
		
	
		  
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(clicktaskthreedots));
			clickElement(clicktaskthreedots);
			
			
			
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clicktaskthreedots);
			
		
		}
		
	}
			public String gettaskNumber() {
				String batchNo = getText(tasksidElement);
				System.out.println("Wave Batch Number is :" + batchNo);
				return batchNo;

			}
			
			

public void taskRelatedLinks1() throws InterruptedException {
	try {
		new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(taskRLElememt));
		clickElement(taskRLElememt);
	} catch (Exception e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", taskRLElememt);
	}

	

}


public void SelectRLitem() throws InterruptedException {
	try {
		new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(selectitemRLElememt));
		clickElement(selectitemRLElememt);
	} catch (Exception e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", selectitemRLElememt);
	}

	new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(itembarElement));

}
			
			public void clickCleaarBtn() throws InterruptedException {
				
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(objtaskElememt));

				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript(
						"document.querySelector(\"div[class='field-container no-padding'] button[class='clear-font clear-button ng-star-inserted enable-clear-button']\").click()");

			}
			public void itemRelatedLinks() throws InterruptedException {
				try {
					new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(itemrelatedLinksElement));
					clickElement(itemrelatedLinksElement);
				} catch (Exception e) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", itemrelatedLinksElement);
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

			public String getMultisTasksNo(String Ordernumber) throws InterruptedException {
				WaitforPage(5000);
				WebElement allocatedElement1= driver.findElement(By.xpath("//a[contains(text(),'"+Ordernumber+"')]/ancestor::div[contains(@class,'dm-flex-col-layout')][1]/descendant::span[@class='field-value ng-star-inserted'][2]"));
				
				String itemNo1 = getText(allocatedElement1);
				
				
				System.out.println(itemNo1);
				
				
				return itemNo1;
			  }

			public String getWaveRunNumber() {
				String batchNo = getText(tasksNoElement);
				System.out.println("Wave Batch Number is :" + batchNo);
				return batchNo;

			}
			
			public void itemsearch(String batchNo) throws InterruptedException {
				
				WaitforPage(2000);
				try {
					new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(enteritemsearch));
					enterText(enteritemsearch, batchNo);
					pressEnterKey(enteritemsearch);
				} catch (Exception e) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", enteritemsearch);
				}
				pressEnterKey(enteritemsearch);
				
			}

public void TaskIDsearch(String batchNo) throws InterruptedException {
				
				WaitforPage(2000);
				try {
					new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(taskidsearch));
					enterText(taskidsearch, batchNo);
					pressEnterKey(taskidsearch);
				} catch (Exception e) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", taskidsearch);
				}
				pressEnterKey(taskidsearch);
				
			}

public void taskRelatedLinks() throws InterruptedException {
	try {
		new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(itemrelatedLinksElement));
		clickElement(itemrelatedLinksElement);
	} catch (Exception e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", itemrelatedLinksElement);
	}
	new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(taskDetailsElement));
}

public void selectTasksDetails() throws InterruptedException {
	try {
		new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(taskDetailsElement));
		clickElement(taskDetailsElement);
	} catch (Exception e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", taskDetailsElement);
	}
	new WebDriverWait(driver, 80).until(ExpectedConditions.visibilityOf(taskDetailsElement));
}

public void Waverun(String text, WMS_DashboardPage dashboardPage) throws InterruptedException {

    try {

        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(Generationnumber));
        enterText(Generationnumber, text);
        pressEnterKey(Generationnumber);
        pressEnterKey(Generationnumber);
        dashboardPage.clickRefresh();

    } catch (Exception e) {

        int i = 1;
        do {
            System.out.println(i);
            dashboardPage.clickRefresh();
            i++;
        } while (i <= 25);

    }

}


}

		

	
