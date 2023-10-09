package WMS_TimeDate_Batch_6;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.WMS_ASNPage;
import com.WMS_ApplicationPages.WMS_BatchListPage;
import com.WMS_ApplicationPages.WMS_DashboardPage;
import com.WMS_ApplicationPages.WMS_DisasterRecoveryPage;
import com.WMS_ApplicationPages.WMS_ItemPage;
import com.WMS_ApplicationPages.WMS_LPNPage;
import com.WMS_ApplicationPages.WMS_LocationInventoryPage;
import com.WMS_ApplicationPages.WMS_LoginPage;
import com.WMS_ApplicationPages.WMS_OrdersPage;
import com.WMS_ApplicationPages.WMS_PackStationPage;
import com.WMS_ApplicationPages.WMS_SystemManagementPage;
import com.WMS_ApplicationPages.WMS_TasksPage;
import com.WMS_ApplicationPages.WMS_WVMobilePage;
import com.WMS_ApplicationPages.WMS_WaveRunsPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import resources.DataProviders;
@Test(enabled = true, groups = { "TimeDate" })
public class WMS_Fill_and_Kill extends WMS_TestBase {

	WebDriver driver;
	WMS_LoginPage loginPage;
	WMS_DashboardPage dashboardPage;
	WMS_ASNPage asnPage;
	WMS_LPNPage lsnPage;
	WMS_ItemPage itemPage;
	WMS_OrdersPage orderspage;
	WMS_WVMobilePage wvMobilePage;
	WMS_DisasterRecoveryPage discoverRecovery;
	WMS_WebDriverUtilities utilities;
	WMS_WaveRunsPage waverunspage;
	WMS_TestBase testbasepage;
	WMS_BatchListPage batchlistpage;
	WMS_TasksPage taskspage;
	WMS_PackStationPage packStationPage;
	WMS_LocationInventoryPage locationinventorypage;
	WMS_SystemManagementPage systemmanagementpage;
	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	int CartSlot = 6;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			launchUrl();
			loginPage = new WMS_LoginPage(driver);
			dashboardPage = new WMS_DashboardPage(driver);
			asnPage = new WMS_ASNPage(driver);
			lsnPage = new WMS_LPNPage(driver);
			itemPage = new WMS_ItemPage(driver);
			wvMobilePage = new WMS_WVMobilePage(driver);
			discoverRecovery = new WMS_DisasterRecoveryPage(driver);
			utilities = new WMS_WebDriverUtilities(driver);
			waverunspage = new WMS_WaveRunsPage(driver);
			orderspage = new WMS_OrdersPage(driver);
			batchlistpage = new WMS_BatchListPage(driver);
			taskspage = new WMS_TasksPage(driver);
			packStationPage = new WMS_PackStationPage(driver);
			locationinventorypage = new WMS_LocationInventoryPage(driver);
			systemmanagementpage = new WMS_SystemManagementPage(driver);
			setReport("WMS_Fill_and_Kill");
		}
	}

	@Test(priority = 0, dataProvider = "Fill_And_Kill_Wave", dataProviderClass = DataProviders.class)

	public void orderAllocation(String OrderNumber, String OrderNumber2, String CompleteSpecs )
			throws InterruptedException, AWTException {
try {
		if (!OrderNumber.equals(" ")) {
			if (CloseBrowser) {
				test = extent.createTest(":::WMS_Fill_and_Kill:::");
			}

			CloseBrowser = false;

			loginPage.verifyLogoExists();
			test.log(Status.PASS, "Manhattan Active Supply Chain logo is displayed");

			loginPage.enterUserName(USERNAME);
			test.log(Status.PASS, "Entered Username");

			loginPage.clickSubmitUserName();
			test.log(Status.PASS, "Clicked on Submit Button");

			loginPage.enterPassword(PASSWORD);
			test.log(Status.PASS, "Entered Password");

			addSrceenShot("Login", test, Capture);

			loginPage.clickLogin();
			test.log(Status.PASS, "Clicked on Login Button");

			
			  dashboardPage.clickMenuToggleElementTwo(); test.log(Status.PASS,
			  "Clicked on menu Button");
			  
			  dashboardPage.enterMenuSearch("orders"); test.log(Status.PASS,
			  "Entered MenuSearch as ASNs");
			  
			  dashboardPage.ordersclick(); test.log(Status.PASS,
			  "Clicked on Order Button");
			  
			  utilities.toggleGridView(dashboardPage.GridViewButton); test.log(Status.PASS,
			  "Clicked on grid button and viewed record details");
			  
			  orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
			  test.log(Status.PASS, "Entered Order Search");
			  
			  addSrceenShot("Login", test, Capture);
			  
			  dashboardPage.clickRefresh();
			  
			  verifyCompleteSpecifics(test, readWebTable(orderspage.OrderTableHeader,
			  orderspage.orderTableBody), CompleteSpecs, OrderNumber);
			  test.log(Status.PASS, "DO verification completed");
			  
			  utilities.toggleGridView(dashboardPage.GridViewButton); test.log(Status.PASS,
			  "Clicked on grid button and viewed record details");
			  
			  String itemfromOrder1 = orderspage.getItemNoBYOrdersNo(OrderNumber);
			  
			  String itemfromOrder2 = orderspage.getItemNoBYOrdersNo(OrderNumber2);
			  
			  dashboardPage.clickMenuToggle(); test.log(Status.PASS,
			  "Clicked on menu Button");
			  
			  dashboardPage.enterMenuSearch("location inventory"); test.log(Status.PASS,
			  "Entered MenuSearch as ASNs");
			  
			  locationinventorypage.clickInventoryBtn();
			  
				
				  locationinventorypage.inventoryitemsearch1(itemfromOrder1,itemfromOrder2);
				  test.log(Status.PASS, "Entered Order Search");
				  
				  locationinventorypage.clickFirstStorageTab();
				  locationinventorypage.clickSecoundStorageTab();
				
			  locationinventorypage.clickApplyCond();
			  
			  locationinventorypage.clickInventoryCond();
			  
			  locationinventorypage.clickInventoryConddropdown();
			  
			  
			  locationinventorypage.clickDamagedBtn();
			  
			  locationinventorypage.clickSummitBtn();
			  locationinventorypage.acceptendTote();
				/*
				 * try { locationinventorypage.acceptendTote(); }
				 * 
				 * catch (Exception e){
				 * 
				 * }
				 */
			  
			  dashboardPage.clickMenuToggleElementTwo(); test.log(Status.PASS,
			  "Clicked on menu Button");
			  
			  dashboardPage.enterMenuSearch("orders"); test.log(Status.PASS,
			  "Entered MenuSearch as ASNs");
			  
			  dashboardPage.ordersclick(); test.log(Status.PASS,
			  "Clicked on Order Button");
			  
			  utilities.toggleGridView(dashboardPage.GridViewButton); test.log(Status.PASS,
			  "Clicked on grid button and viewed record details");
			  
			  orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
			  test.log(Status.PASS, "Entered Order Search");
			  
			  addSrceenShot("Login", test, Capture);
			  
			  dashboardPage.clickRefresh();
			  
			  verifyCompleteSpecifics(test, readWebTable(orderspage.OrderTableHeader,
			  orderspage.orderTableBody), CompleteSpecs, OrderNumber);
			  test.log(Status.PASS, "DO verification completed");
			  
			  utilities.toggleGridView(dashboardPage.GridViewButton); test.log(Status.PASS,
			  "Clicked on grid button and viewed record details");
			  
			  
			  
			  orderspage.selectAllRecord(); test.log(Status.PASS,
			  "clicked on one record button");
			  
			  addSrceenShot("Login", test, Capture);
			  
			  orderspage.clickToolRunwaveBtn(); test.log(Status.PASS,
			  "clicked on run wave button");
			  
			  orderspage.enterWaveStatergy("OPS - Standard Wave"); test.log(Status.PASS,
			  "Selected standard Wave statergy");
			  
			  addSrceenShot("Login", test, Capture);
			  
			  orderspage.confirmSummit(); test.log(Status.PASS,
			  "clicked on one summit button");
			  
			  dashboardPage.clickRefresh();
			  
			  
			  
			  
			  dashboardPage.clickMenuToggleElementTwo(); test.log(Status.PASS,
			  "Clicked on menu Button");
			  
			  dashboardPage.enterMenuSearch("wave run"); test.log(Status.PASS,
			  "Entered MenuSearch as ASNs");
			  
			  waverunspage.clickWaverunpagebtn(); test.log(Status.PASS,
			  "Clicked on Order Button");
			  
			  
			  
			  String canWaveRunID = waverunspage.waverunidfromWRpage();
			  
			  
			  
			  
			  waverunspage.enterWaveRunSearch(canWaveRunID);
			  
			  waverunspage.workReleaseCancelPage(dashboardPage);
			 
				
				
				
				
				dashboardPage.clickMenuToggleElementTwo();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("orders");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				dashboardPage.ordersclick();
				test.log(Status.PASS, "Clicked on Order Button");

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
				test.log(Status.PASS, "Entered Order Search");

				addSrceenShot("Login", test, Capture);
			
		
				orderspage.selectAllRecord(); test.log(Status.PASS, "clicked on one record button");
				
				orderspage.orderRelatedLinks();
				
				orderspage.clickOrderfailure();
				
				
				orderspage.expandFailureOrder(OrderNumber);
				
				String ordFailone = orderspage.getTextOrdersFailureNo1();
				test.log(Status.PASS, "waved order failed status :"+ordFailone);
				
				addSrceenShot("Login", test, Capture);
				
				
				orderspage.expandFailureOrder(OrderNumber2);
				
				String ordFailTwo = orderspage.getTextOrdersFailureNo2();
				
				
				test.log(Status.PASS, "waved order failed status :"+ordFailTwo);
				
				addSrceenShot("Login", test, Capture);
				
				
				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("location inventory");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				locationinventorypage.clickInventoryBtn();

				locationinventorypage.inventoryitemsearch(itemfromOrder1); //085130124 2932  //itemfromOrder1
				test.log(Status.PASS, "Entered Order Search");
				
							
				 locationinventorypage.clickFirstStorageTab();			  
				  locationinventorypage.clickSecoundStorageTab();
				 				
				locationinventorypage.clickRemoveCond();
				
				locationinventorypage.clickInventoryCond();
				
				locationinventorypage.clickRemoveDamagedBtn();
				
				
				
				locationinventorypage.clickSummitBtn();
				try {
				locationinventorypage.acceptendTote();
				}
				catch (Exception e) {
					
				}
				
				dashboardPage.clickMenuToggleElementTwo();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("orders");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				dashboardPage.ordersclick();
				test.log(Status.PASS, "Clicked on Order Button");

				

				orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
				test.log(Status.PASS, "Entered Order Search");

				addSrceenShot("Login", test, Capture);

				
				  orderspage.selectAllRecord(); test.log(Status.PASS,
				  "clicked on one record button");
				  
				  addSrceenShot("Login", test, Capture);
				  
				  orderspage.clickToolRunwaveBtn(); test.log(Status.PASS,
				  "clicked on run wave button");
				  
				  orderspage.enterFillandKillWave("OPS - Fill or Kill Wave"); test.log(Status.PASS,
				  "Selected standard Wave statergy");
				  
				  addSrceenShot("Login", test, Capture);
				  
				  orderspage.confirmSummit(); test.log(Status.PASS,
				  "clicked on one summit button");
				  
				  dashboardPage.clickRefresh();
					
					dashboardPage.clickRefresh();
					
					dashboardPage.clickRefresh();
					
					dashboardPage.clickRefresh();
					
					
					dashboardPage.clickMenuToggle();

					dashboardPage.enterMenuSearch("system management");
					test.log(Status.PASS, "Entered MenuSearch as ILPNs");

					systemmanagementpage.clickSystemMgmtBtn();

					utilities.switchToWindows();

					dashboardPage.clickMenuToggle();

					dashboardPage.enterMenuSearch("tranlog details");
					test.log(Status.PASS, "Entered MenuSearch as ILPNs");

					systemmanagementpage.clickTranlogDetailsBtn();

					systemmanagementpage.enterTranlogToteIDSearch(OrderNumber2);
					
					
					systemmanagementpage.bulkRfreshPage(dashboardPage);
					
					systemmanagementpage.enterTranlogToteIDSearch(OrderNumber + ", " +OrderNumber2);
					
					systemmanagementpage.bulkRfreshPage(dashboardPage);
					
					

					utilities.toggleGridView(dashboardPage.GridViewButton);

					systemmanagementpage.clickTranFirstRecordBtn();

					systemmanagementpage.clickPayLoadBtn();

					systemmanagementpage.clicklinebtn();
					
					

					String payLoad=systemmanagementpage.getInnerTextMessage();
					
					System.out.println(payLoad);
					
					if (payLoad.contains(OrderNumber)) {
						test.log(Status.PASS, "Payload text contains " + OrderNumber);
						addSrceenShot("Login", test, Capture);
					} else {
						test.log(Status.FAIL, "Payload text does not contain " + OrderNumber);
						addSrceenShot("Login", test, true);
					}
					if(payLoad.contains("Order is allocated with an inventory in WM")) {
						test.log(Status.PASS, "Payload text contains " + "Order is allocated with an inventory in WM");
					}else {
						test.log(Status.FAIL, "Payload text does not contain " + "Order is allocated with an inventory in WM");
					}
					
					
					if(payLoad.contains(OrderNumber2)) {
						test.log(Status.PASS, "Payload text contains " + OrderNumber2);
					}else {
						test.log(Status.FAIL, "Payload text does not contain " + OrderNumber2);
					}
					
					if(payLoad.contains("Order is allocated with an inventory in WM")) {
						test.log(Status.PASS, "Payload text contains " + "Order is allocated with an inventory in WM");
					}else {
						test.log(Status.FAIL, "Payload text does not contain " + "Order is allocated with an inventory in WM");
					}
					
				 		

			
			
			}
			 CloseBrowser = true; 
}
catch (Exception e) {
	System.out.println("Test case failed due to application slowness"+ e);
	test.log(Status.FAIL, "Test case failed due to application slowness");
}
		}
	
	@AfterMethod
	public void setUpend() {

		extent.flush();
		driver.quit();
	}

	}


