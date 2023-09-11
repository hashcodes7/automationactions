package com.WMS_ApplicationPages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WMS_Utilities.WMS_WebDriverUtilities;

public class WMS_LPNPage extends WMS_WebDriverUtilities{


	WebDriver driver;

	public WMS_LPNPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/////////////////////////////////////////////////  PAGE OBJECTS  //////////////////////////////////////////////////////////////	


	@FindBy(xpath="//*[@class='native-input sc-ion-input-md' and @name='ion-input-18']")
	public WebElement lpnSearchElement;
	
	@FindBy(xpath="//span[@title='ASN']/following-sibling::ion-button")
	public WebElement ASNSearchElementExpand;
	
	@FindBy(xpath="//span[@title='ILPN']/following-sibling::ion-button")
	public WebElement LPNSearchElementExpand;

	@FindBy(xpath="//input[@name='ion-input-14']")
	public WebElement lpnAsnSearchElement;
	
	@FindBy(xpath="//*[contains(text(),'ILPNs')]")
	public WebElement menuILPNsElement;
	
	@FindBy(xpath="//span[@title='ASN']/parent::filter-field-header/parent::div//ion-input/input")
	public WebElement ASNSearchElement;
	
	@FindBy(xpath="//span[@title='ILPN']/parent::filter-field-header/parent::div//ion-input/input")
	public WebElement LPNSearchElement;
	
		
	@FindBy(xpath="//datatable-body/datatable-selection/datatable-scroller")
	public WebElement LPNTableBody;
	
	@FindBy(xpath="//datatable-header/div/div[@class='datatable-row-center ng-star-inserted']")
	public WebElement LPNTableHeader;


	@FindBy(xpath="//*[@menu='ui-dm-hamburger']")
	public WebElement lpnMenuToggleElement;
	
	@FindBy(xpath="//ion-checkbox[@data-component-id='com-manh-cp-dcinventory-ILpn-multi-select-filter-NotAllocated']/input")
	public WebElement notAllocatedElement;


	@FindBy(xpath="//*[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']")
	public WebElement LSNInTransitElement;

	@FindBy(xpath="//div[@title='Received']")
	public WebElement LSNReceivedElement;

	@FindBy(xpath="//a[@title='ASNs']")
	public WebElement asnLinkElement;
	
	@FindBy(xpath="//*[text()=' Related Links ']")
	public WebElement clickRelatedElement;
	
	@FindBy(xpath = "//*[text()='Receipt']")
    public WebElement clickReceiptElement;
	
	@FindBy(xpath = "//div[text()=' In Transit ']/ancestor::div[@class='neutral-button dm-flex-center dm-flex-col-layout card-icon-panel ng-star-inserted']/descendant::div[@class='width-45 ng-star-inserted']")
	public WebElement clickExpIlpnElement;
	
	@FindBy(xpath="//*[text()='LPN']")
	public WebElement clickILPNPageElement;
	
	@FindBy(xpath = "//*[text()='LPN']")
	public WebElement lpndropdownBody;
	
	@FindBy(xpath = "//*[contains(text(),' Shipped quantity (unit) : ')]/ancestor::div[@class='dm-flex-row-layout field-row ng-star-inserted']/descendant::span[@class='field-value ng-star-inserted']")
	public WebElement clickoneLPNElement;
	
	 @FindBy(xpath = "//*[contains(text(),' Shipped quantity (unit) : ')]/ancestor::div[@class='dm-flex-row-layout field-row ng-star-inserted']/descendant::span[@class='field-value ng-star-inserted']")
	    public WebElement clickTwoLPNElement;
	
	@FindBy(xpath="//*[text()=' Parent LPN : ']")
	public WebElement clickILPNrecordElement;
	
	@FindBy(xpath="//div[@role='dialog']/*//modal-header/*//button")
	public WebElement modalDialogClose;
	
	@FindBy(xpath="//ion-checkbox[@data-component-id='com-manh-cp-dcinventory-ILpn-multi-select-filter-NotAllocated']/input")
	public WebElement notAllocElement;
	
	@FindBy(xpath="//*[@class='icon-area ng-star-inserted']")
	public WebElement closeIconElement;
	
	@FindBy(xpath="//ion-checkbox[@data-component-id='com-manh-cp-dcinventory-ILpn-multi-select-filter-NotAllocated']")
	public WebElement clickNAElement;
	
	@FindBy(xpath="//div[@class='dm-flex-col-layout dm-fill-space card-column ng-star-inserted']/descendant::span[14]")
	public WebElement getilpnQtyElement;
	
	@FindBy(xpath="//div[@class='dm-flex-col-layout dm-fill-space card-column ng-star-inserted']/descendant::span[13]")
	public WebElement btnIlpnElement;
	
	@FindBy(xpath="//div[@class='dm-flex-col-layout dm-fill-space card-column ng-star-inserted']/descendant::span")
	public WebElement selectIlpnElement; 
	

	@FindBy(xpath="//*[text()=' Item : ']/ancestor::div[@class='dm-flex-row-layout field-row card-column link-height ng-star-inserted']/a")
	public WebElement getIlpnItemElement;
	
	@FindBy(xpath="//*[text()='ILPNs']")
	public WebElement clickIlpnItemElement;
	
	@FindBy(xpath = "//span[text()='ASN: ']/ancestor::ion-grid/descendant::span[2]")
	public WebElement asnBlindResv;
	
	@FindBy(xpath = "//span[contains(text(),'ILPN :')]/following-sibling::span")
	public WebElement getILPNSpage;
	
	/////////////////////////////////////////////////  PAGE Methods  //////////////////////////////////////////////////////////////


	/*
	 * Put Cart Data Preparation
	 */
	public List <HashMap<String, String>> returnLPNTableforPutCart(List <HashMap<String, String>> itemDataTable,String TotStart,String TOTKey,String CartKey,int CartSlot,String Lpn,List<HashMap<String, String>> data_ItemTable){
		int TOTint;
		int Cartint;
		int TOTstartint;
		int Numberoftotes;
		String Slot;
		
		if(data_ItemTable==null) {
			data_ItemTable = new ArrayList<HashMap<String, String>>();
			if(!TotStart.equals(" ")) {
				TOTint=Integer.parseInt(TotStart);
				TOTstartint=Integer.parseInt(TotStart);
			}else {
				TOTstartint=1;
				TOTint=1;
			}
			Cartint=0;
		}else {
			TOTstartint=getMinTotint(data_ItemTable);
			TOTint=getMaxTotint(data_ItemTable);
			Cartint=getMaxCartint(data_ItemTable);
		}
		System.out.println("--------ItemTableStart-------------");
		String TOTString="";
		String CartString="";
		
		
		for(HashMap<String, String> row : itemDataTable) {
			HashMap<String, String> dataRow = new HashMap<String, String>();
			dataRow.put("Lpn",Lpn);
			System.out.println("Lpn :"+Lpn);
			dataRow.put("Item", row.get("Item"));
			System.out.println("Item :"+dataRow.get("Item"));
			dataRow.put("ItemBarCode", "");
			System.out.println("ItemBarCode :"+dataRow.get("ItemBarCode"));
			dataRow.put("SplitQuantity", row.get("On hand quantity").split(" ")[0].trim());
			System.out.println("SplitQuantity :"+dataRow.get("SplitQuantity"));
			//System.out.println(Integer.toString(TOTint).length());
			if(Integer.toString(TOTint).length()<=1) {
				TOTString = "0" + Integer.toString(TOTint);
			}else {
				TOTString = Integer.toString(TOTint);
			}
			
			dataRow.put("ToteID","TOTE"+TOTKey+ TOTString );
			System.out.println("ToteID :"+dataRow.get("ToteID"));
			
			dataRow.put("EndCart","No" );
			
			
			
				Numberoftotes=TOTint-TOTstartint + 1;
				
				
				Slot=Integer.toString(100000 + (Numberoftotes)).substring(1);
				dataRow.put("CartSlot",Slot );
				System.out.println("CartSlot :"+dataRow.get("CartSlot"));
				
								
				if(Numberoftotes%CartSlot==0) {
					dataRow.put("EndCart","Yes" );
				}
				
				if(Numberoftotes%CartSlot==1) {
					Cartint++;
				}
				
				if(Cartint<10) {
					
					CartString = "0" + Cartint;
					System.out.println("CartString :" + CartString);
				}else {
					CartString = Integer.toString(Cartint);
					System.out.println("CartString :"+CartString);
				}
					
				
			
			
			
			System.out.println("EndCart :"+dataRow.get("EndCart"));
			
			TOTint++;
			dataRow.put("CartID","CART"+CartKey+ CartString );
			System.out.println("CartID :"+dataRow.get("CartID"));
			data_ItemTable.add(dataRow);
		}
		
		System.out.println("--------ItemTableEnd-------------");
		
		return data_ItemTable;
	}
	
	public int getMaxCartint(List <HashMap<String, String>> data_ItemTable) {
		int Maxint=-1;
		int HoldRowint=0;
		
		for(HashMap<String, String> row : data_ItemTable) {
			HoldRowint=Integer.parseInt(row.get("CartID").substring(row.get("CartID").length() - 2));
			
			if(Maxint<HoldRowint) {
				Maxint=HoldRowint;
			}
		}
		
		return Maxint;
	}
	
	public int getCountCartRow(List <HashMap<String, String>> data_ItemTable,String CartID) {
		int HoldRowint=0;
		
		for(HashMap<String, String> row : data_ItemTable) {
						
			if(row.get("CartID").equals(CartID)) {
				HoldRowint++;
			}
		}
		
		return HoldRowint;
	}
	
	public int getMaxTotint(List <HashMap<String, String>> data_ItemTable) {
		int Maxint=-1;
		int HoldRowint=0;
		
		for(HashMap<String, String> row : data_ItemTable) {
			HoldRowint=Integer.parseInt(row.get("ToteID").substring(row.get("ToteID").length() - 2));
			
			if(Maxint<HoldRowint) {
				Maxint=HoldRowint;
			}
		}
		
		return Maxint + 1;
	}
	
	public int getMinTotint(List <HashMap<String, String>> data_ItemTable) {
		int Minint=100;
		int HoldRowint=0;
		
		for(HashMap<String, String> row : data_ItemTable) {
			HoldRowint=Integer.parseInt(row.get("ToteID").substring(row.get("ToteID").length() - 2));
			
			if(Minint>HoldRowint) {
				Minint=HoldRowint;
			}
		}
		
		return Minint;
	}
	
	public List <HashMap<String, String>> updateLPNTableforPutCart(List <HashMap<String, String>> data_ItemTable,String Lpn,String Key,String Field,String Val){
		for(HashMap<String, String> row : data_ItemTable) {
			
			if(row.containsValue(Lpn) && row.containsValue(Key)) {
				if(row.containsKey(Field)) {
					row.put(Field, Val);
					break;
				}
			}
		}
		
		for(HashMap<String, String> row : data_ItemTable) {
			
			if(row.containsValue(Key)) {
				if(row.containsKey(Field)) {
					System.out.println(Field+":"+Val);
					
				}
			}
		}
		return data_ItemTable;
	}
	
	public String getFieldValueForLPNTable(List <HashMap<String, String>> data_ItemTable,String Key1,String Key2,String Field){
		String FieldValue=null;
		
		for(HashMap<String, String> row : data_ItemTable) {
			
			if(row.containsValue(Key1) && row.containsValue(Key2)) {
				if(row.containsKey(Field)) {
					System.out.println("::::ReturnFieldValue::::");
					FieldValue=row.get(Field);
					System.out.println(Field+":"+row.get(Field));
				}
			}
		}
		return FieldValue;
	}
	
	
	public WebElement getHeaderTableFromLPNDetail(String Key) {
		String findelementstring ="//div[@class='expand-header-container'][span='"+ Key + "']/parent::expand-child/div[@class='expand-content ng-star-inserted']/div[@class='scroll-panel ng-star-inserted']/*//datatable-header/*//div[@class='datatable-row-center ng-star-inserted']";
		WebElement header = driver.findElement(By.xpath(findelementstring));
		return header;	
	}
	
	public WebElement getDataTableFromLPNDetail(String Key) {
		String findelementstring ="//div[@class='expand-header-container'][span='" + Key + "']/parent::expand-child/div[@class='expand-content ng-star-inserted']/div[@class='scroll-panel ng-star-inserted']/*//datatable-body/*//datatable-scroller";
		WebElement tablebody = driver.findElement(By.xpath(findelementstring));
		return tablebody;	
	}
	
	public WebElement getDataTableShip(String Key) {
		String findelementstring ="//div[@class='expand-header-container'][span='" + Key + "']/parent::expand-child/div[@class='expand-content ng-star-inserted']/div[@class='scroll-panel ng-star-inserted']/*//datatable-body/*//datatable-scroller";
		WebElement tablebody = driver.findElement(By.xpath(findelementstring));
		return tablebody;	
	}
	
	
	
	
	  public void enterLpnSearch(String ILpn){
		  try {
	           //clickElement(LPNSearchElement);
	           if (LPNSearchElementExpand.isDisplayed()) {
	           new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(LPNSearchElement));
	            clickElement(LPNSearchElement);
	           enterText(LPNSearchElement, ILpn);
	            pressEnterKey(LPNSearchElement);
	            pressEnterKey(LPNSearchElement);
	           }
	           else {
	        	   clickElement(LPNSearchElement);
	        	   new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(LPNSearchElement));
		            clickElement(LPNSearchElement);
		           enterText(LPNSearchElement, ILpn);
		            pressEnterKey(LPNSearchElement);
		            pressEnterKey(LPNSearchElement);
	        	   
	           }
	       } catch (Exception e) {
				System.out.println("Connection Lag exception");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", LPNSearchElement);
				 pressEnterKey(LPNSearchElement);
		            pressEnterKey(LPNSearchElement);
			}
	  }
		  	
	public void checkSelectedRow(WebElement checkTablerow) {
		   try {
			   System.out.println("Check Box Click");
				   new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(checkTablerow));
				   clickElement(checkTablerow);
		   } catch (Exception e) {
				System.out.println("Connection Lag exception");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", checkTablerow);
			}
	   }
	
	public void enterLpnSearchlpnPage(String Asn) {
        enterText(lpnAsnSearchElement, Asn);
        try {
            new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(lpnAsnSearchElement));
            clickElement(lpnAsnSearchElement);
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", lpnAsnSearchElement);
        }
        pressTabKey(lpnAsnSearchElement);
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
	
	public void closeLPNDetailsModal() {
		   try {
				   new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(modalDialogClose));
				   clickElement(modalDialogClose);
		   } catch (Exception e) {
				System.out.println("Connection Lag exception");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", modalDialogClose);
			}
	   }
	
	
	
	public void lpnDetailTableElementExpandClick(String Key) {
		String FindStringStart = "//span[contains(text(),'";
		String FindStringEnd = "')]";
		String FindElementString= FindStringStart + Key + FindStringEnd;
		WebElement plusButton;
		
		plusButton = driver.findElement(By.xpath(FindElementString));
		
		try {
			   new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(plusButton));
			   clickElement(plusButton);
	   } catch (Exception e) {
			System.out.println("Connection Lag exception");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", plusButton);
		}
		
	}
	
	public String getAsnSearchVal() {
		
		try {
			
			//new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(ASNSearchElement));
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(ASNSearchElement));
			return ASNSearchElement.getAttribute("value");
			
			
			
		} catch (Exception e) {
			System.out.println("exception");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return (String)js.executeScript("return arguments[0].value;", ASNSearchElement);
			
		}
			
				
	}
	
public String getAsnsNoBlnRecive() {
		
		String taskGroupNo = getText(asnBlindResv);
		System.out.println("Asns Number is: "+taskGroupNo);
		
		return taskGroupNo;
	}

public String getlpnsfromilpnPage() {
	
	String taskGroupNo = getText(getILPNSpage);
	System.out.println("ILPNS page ILPN Number is: "+taskGroupNo);
	
	return taskGroupNo;
}
	
    public void enterAsnSearch(String Asn) {
		
		try {
			if (ASNSearchElementExpand.isDisplayed()) {
			
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(ASNSearchElement));
			}else {
			clickElement(ASNSearchElementExpand); 
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(ASNSearchElement));
			//clickElement(ASNSearchElement);
			}	
		
			/*
			 * //new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(
			 * ASNSearchElement)); clickElement(ASNSearchElementExpand); new
			 * WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(
			 * ASNSearchElement)); clickElement(ASNSearchElement);
			 */
			
			
		} catch (Exception e) {
			System.out.println("exception");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ASNSearchElementExpand);
			js.executeScript("arguments[0].click();", ASNSearchElement);
		}
		
				    
		enterText(ASNSearchElement,Asn);
		pressEnterKey(ASNSearchElement);
			
				
	}

	public void enterLpnAsnSearch(String Asn) {
		enterText(lpnAsnSearchElement,Asn);
		try {
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(lpnAsnSearchElement));
			clickElement(lpnAsnSearchElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", lpnAsnSearchElement);
		}
		pressTabKey(lpnAsnSearchElement);
	}

	public void lsnStatusBeforeReceiving() {
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(LSNInTransitElement));
		String lsnStatus=LSNInTransitElement.getText();
		System.out.println("LPN is in"+" "+lsnStatus+" "+"status");
	}

	public void lsnStatusAfterReceiving() {
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(LSNReceivedElement));
		String lsnStatus=LSNReceivedElement.getText();
		System.out.println("LPN is in"+" "+lsnStatus+" "+"status");
	}

	public void clickAsnLink() throws InterruptedException {
		if(Display(asnLinkElement)) {
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(asnLinkElement));
			clickElement(asnLinkElement);
			Thread.sleep(500);
		}

	}

	public void clickLpnMenuToggle() {
		try {
			new WebDriverWait(driver,180).until(ExpectedConditions.elementToBeClickable(lpnMenuToggleElement));
			clickElement(lpnMenuToggleElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", lpnMenuToggleElement);
		}


	}
	
	public void clickRelatedLinksILPN() {
		try {
			new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(clickRelatedElement));
			clickElement(clickRelatedElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickRelatedElement);
		}


	}
	
	public void clickDrpReceip() {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(clickReceiptElement));
            clickElement(clickReceiptElement);
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", clickReceiptElement);
        }
	}
	
	public void clickILPN() {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(lpndropdownBody));
			clickElement(lpndropdownBody);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", lpndropdownBody);
		}

	}
	
public void clickExpandBarLPN() {
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(clickExpIlpnElement));
		try {
			clickElement(clickExpIlpnElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickExpIlpnElement);
		}
	

}
	
	public void clickILPNPage() {
		try {
			new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(clickILPNPageElement));
			clickElement(clickILPNPageElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickILPNPageElement);
		}


	}

	public void clickNotAllocatedBtn() {

		try {
			new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(clickNAElement));
			clickElement(clickNAElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", clickNAElement);
		}

	}

	public void clickClose() {
		try {
			clickElement(closeIconElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", closeIconElement);
		}


	}

	public int getIlpnQty() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(getilpnQtyElement));
		String taskNo1 = getText(getilpnQtyElement);
		System.out.println("The Unit Count is: " + taskNo1);
		return Integer.parseInt(taskNo1.replace(" Units", ""));
	}
	public void clickIlpnRecord() {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(btnIlpnElement));
			clickElement(btnIlpnElement);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", btnIlpnElement);

		}
		
	}
	
	public void clickOneRecordIlpn() {

		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(selectIlpnElement));
			clickElement(selectIlpnElement);

		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", selectIlpnElement);

		}
	
	}
	public String getitemIDIlpn() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(getIlpnItemElement));
		String taskNo1 = getText(getIlpnItemElement).trim();
		System.out.println("The Unit Count is: " + taskNo1);
		return taskNo1;
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
	public void clickIlpnBtn() {
		try {
			new WebDriverWait(driver,180).until(ExpectedConditions.elementToBeClickable(lpnMenuToggleElement));
			clickElement(lpnMenuToggleElement);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", lpnMenuToggleElement);
		}
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(LPNSearchElement));

	}
	public void clickILPNRecord() {
		   try {
				   new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(clickILPNrecordElement));
				   clickElement(clickILPNrecordElement);
		   } catch (Exception e) {
				System.out.println("Connection Lag exception");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", clickILPNrecordElement);
			}
	   }
	
	public String verifyItemOneQty() throws InterruptedException {

		WaitforPage(3000);

		String text = getText(clickoneLPNElement);



		return text;

		
	}
	
	 public String verifyItemTwoQty() throws InterruptedException {
	       WaitforPage(3000);
	       String text = getText(clickTwoLPNElement);
	       return text;
	       
	    }
	 public String getIlpnsQty(String Ordernumber) throws InterruptedException {
	        WaitforPage(5000);
	        WebElement allocatedElement1 = driver.findElement(By.xpath("//*[contains(text(),'" + Ordernumber
	                + "')]/ancestor::div[contains(@class,'dm-flex-row-layout dm-fill')]/descendant::div[11]/span[@class='field-value ng-star-inserted']"));

	        String itemNo1 = getText(allocatedElement1);

	        System.out.println(itemNo1);

	        return itemNo1;
	    }
	 
}



  
 