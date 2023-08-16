package WMS_SinglesPackSort_Batch_8;

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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.WMS_ASNPage;
import com.WMS_ApplicationPages.WMS_BatchListPage;
import com.WMS_ApplicationPages.WMS_DashboardPage;
import com.WMS_ApplicationPages.WMS_DisasterRecoveryPage;
import com.WMS_ApplicationPages.WMS_ItemPage;
import com.WMS_ApplicationPages.WMS_LPNPage;
import com.WMS_ApplicationPages.WMS_LoginPage;
import com.WMS_ApplicationPages.WMS_OrdersPage;
import com.WMS_ApplicationPages.WMS_OutboundManualSorter;
import com.WMS_ApplicationPages.WMS_PackStationPage;
import com.WMS_ApplicationPages.WMS_SystemManagementPage;
import com.WMS_ApplicationPages.WMS_TasksPage;
import com.WMS_ApplicationPages.WMS_WVMobilePage;
import com.WMS_ApplicationPages.WMS_WaveRunsPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups = { "PackShort_Orders" })
public class WMS_Multis_Gift_Card_PackShort extends WMS_TestBase {

	WebDriver driver;
	WMS_LoginPage loginPage;
	WMS_DashboardPage dashboardPage;
	WMS_ASNPage asnPage;
	WMS_LPNPage ilpnPage;
	WMS_ItemPage itemPage;
	WMS_OrdersPage orderspage;
	WMS_WVMobilePage wvMobilePage;
	WMS_DisasterRecoveryPage discoverRecovery;
	WMS_WebDriverUtilities utilities;
	WMS_WaveRunsPage waverunspage;
	WMS_TestBase testbasepage;
	WMS_LPNPage lsnPage;
	WMS_BatchListPage batchlistpage;
	WMS_TasksPage taskspage;
	WMS_PackStationPage packStationPage;
	WMS_SystemManagementPage systemmanagementpage;
	WMS_OutboundManualSorter outboundmanualsorterpage;

	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			launchUrl();
			loginPage = new WMS_LoginPage(driver);
			dashboardPage = new WMS_DashboardPage(driver);
			asnPage = new WMS_ASNPage(driver);
			ilpnPage = new WMS_LPNPage(driver);
			lsnPage = new WMS_LPNPage(driver);
			itemPage = new WMS_ItemPage(driver);
			wvMobilePage = new WMS_WVMobilePage(driver);
			discoverRecovery = new WMS_DisasterRecoveryPage(driver);
			utilities = new WMS_WebDriverUtilities(driver);
			waverunspage = new WMS_WaveRunsPage(driver);
			orderspage = new WMS_OrdersPage(driver);
			waverunspage = new WMS_WaveRunsPage(driver);
			batchlistpage = new WMS_BatchListPage(driver);
			taskspage = new WMS_TasksPage(driver);
			packStationPage = new WMS_PackStationPage(driver);
			systemmanagementpage = new WMS_SystemManagementPage(driver);
			outboundmanualsorterpage = new WMS_OutboundManualSorter(driver);
			setReport("WMS_Multis_Gift_Card_PackShort_Putwall_Exception");

		}
	}

	@Test(priority = 0, dataProvider = "WMS_PAST_Gift_Card", dataProviderClass = DataProviders.class)
	public void orderAllocation(String OrderNumber,String OrderNumber2, String CompleteSpecs1, String CompleteSpecs2,String CompleteSpecs3,
			String CompleteSpecs4,String CompleteSpecs5,String CompleteSpecs6,String CompleteSpecs7, String TotUserKey1,String TotUserKey2,
			String TotUserKey3,String TotUserKey4,String LocationKey, String CartUserKey1,String CartUserKey2,String CompleteSpecs8,String CompleteSpecs9,
			String PackStation, String sortloc1, String sortloc2, String chasewall)
			throws InterruptedException, AWTException {

		if (!OrderNumber.equals(" ")) {
			if (CloseBrowser) {

				test = extent.createTest(":::WMS_Multis_Gift_Card_PackShort_Putwall_Exception:::");

			}

			CloseBrowser = false;

			long startTime = System.nanoTime();
			System.out.println("Execution Start time is  : " + startTime);

			String GetTime = utilities.Timer();
			System.out.println("< Multies_Gift_Card_Full_shipping_1_Orders_1_item_Chase_Wave >"
					+ "< Execution Start time :   > :" + GetTime);
			test.log(Status.PASS, "< Multies_Gift_Card_Full_shipping_1_Orders_1_item_Chase_Wave >"
					+ "< Execution Start time :   > :" + GetTime);

			loginPage.verifyLogoExists();
			test.log(Status.PASS, "< Manhattan Active Supply Chain Logo is Displayed >");

			loginPage.enterUserName(USERNAME);
			test.log(Status.PASS, "Entered Username");
			addSrceenShot("Login", test, Capture);

			loginPage.clickSubmitUserName();
			test.log(Status.PASS, "Clicked on Submit Button");

			loginPage.enterPassword(PASSWORD);
			test.log(Status.PASS, "Entered Password");
			addSrceenShot("Login", test, Capture);

			loginPage.clickLogin();
			test.log(Status.PASS, "Clicked on Login Button");
			
			loginPage.resizeWebpage();
			test.log(Status.PASS, "Window resize");

			// orders page check orders status and details

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("orders");
			test.log(Status.PASS, "Entered MenuSearch as : " + "orders");

			dashboardPage.ordersclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Clear all selected texboxs and filters");

			dashboardPage.resizeWebpage();
			test.log(Status.PASS, "resized webpage expected size");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS, "Entered Order Search  :  " + OrderNumber + ", " + OrderNumber2);
			addSrceenShot("Login", test, Capture);

			verifyCompleteSpecifics(test, readWebTable(orderspage.OrderTableHeader, orderspage.orderTableBody),
					CompleteSpecs1, OrderNumber);
			test.log(Status.PASS, "DO verification completed");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			// wave run start at.........................................

			orderspage.selectAllRecord();
			test.log(Status.PASS, "clicked on one record button");
			addSrceenShot("Login", test, Capture);

			try {

				orderspage.clickToolRunwaveBtn();
				test.log(Status.PASS, "clicked on run wave button");

			} catch (Exception e) {

				orderspage.btnThreedots();
				test.log(Status.PASS, "clicked on one threeDots button");

				orderspage.clickRunwaveInsideDots();
				test.log(Status.PASS, "clicked runwave at inside Dots");
				addSrceenShot("Login", test, Capture);

			}

			orderspage.enterWaveStatergy("OPS - Standard Wave");
			test.log(Status.PASS, "Selected The standard Wave  :  " +  "OPS - Standard Wave");
			addSrceenShot("Login", test, Capture);

			orderspage.confirmSummit();
			test.log(Status.PASS, "clicked on one summit button");

			// ................................total timer start...................//

			long startTime1 = System.nanoTime();

			String GetTime2 = utilities.Timer();
			System.out.println("wave run start time is :" + GetTime2);
			test.log(Status.PASS, "wave run start time is :" + GetTime2);

			// ..................................................................//

			orderspage.olpnreleaseStatusTwoOrders(dashboardPage, OrderNumber, OrderNumber2);
			test.log(Status.PASS, "waiting for new status update");

			test.log(Status.PASS, "waiting for new status update");
			System.out.println("New status changed successfully");
			addSrceenShot("Login", test, Capture);

			// ...............total time. end with

			long endTime1 = System.nanoTime();

			String GetTime21 = utilities.Timer();
			System.out.println("Wave run started at Time is   :" + GetTime21);
			test.log(Status.PASS, "Wave run started at Time is   :" + GetTime21);

			String totalTime11 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime1, endTime1);
			/* String s11=Long.toString(totalTime11); */
			System.out.println("The execution minutes is :" + totalTime11);
			test.log(Status.PASS, "The Wave run Execution consumed time in Minutes  : " + totalTime11);

			// .................total time......

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			verifyCompleteSpecifics(test, readWebTable(orderspage.OrdAllocaTabHeader, orderspage.OrdAllocaTabBody),
					CompleteSpecs2, OrderNumber);
			test.log(Status.PASS, "DO verification completed");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			addSrceenShot("Login", test, Capture);

			String itemfromOrder1 = orderspage.getItemNoBYOrdersNo(OrderNumber);


			// olpns page ......................................

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("OLPNS");
			test.log(Status.PASS, "Entered MenuSearch as : " + "OLPNS");

			dashboardPage.olpnclick();
			test.log(Status.PASS, "Clicked on OLPNS page Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Clear all selected texboxs and filters");

			orderspage.searchOlpntextbox(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS, "status changed successfully");
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			String olpnfromOrder1 = orderspage.getOlpnsNumberFirst(OrderNumber);
			test.log(Status.PASS, "saved olpn 1   : " + olpnfromOrder1);
			addSrceenShot("Login", test, Capture);

			String olpnfromOrder2 = orderspage.getOlpnsNumberFirst(OrderNumber2);
			test.log(Status.PASS, "saved olpn 1   : " + olpnfromOrder1);
			addSrceenShot("Login", test, Capture);

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test, readWebTable(orderspage.OrdAllocaTabHeader, orderspage.OrdAllocaTabBody),
					CompleteSpecs3, OrderNumber);
			test.log(Status.PASS, "DO verification completed");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");
			addSrceenShot("Login", test, Capture);

			waverunspage.clickExpandBar();
			test.log(Status.PASS, "Clicked on ExpandBar");
			addSrceenShot("Login", test, Capture);

			String wvrnid = waverunspage.waverunid();
			test.log(Status.PASS, "Saved wave run ID   :  " +  wvrnid);

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			// wave run to wra convertion process.............................//

			ilpnPage.clickLpnMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wave run");
			test.log(Status.PASS, "Entered MenuSearch as wave run");

			waverunspage.clickWaverunbtn();
			test.log(Status.PASS, "Clicked on waverun page  Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			dashboardPage.wavesearch(wvrnid,dashboardPage);// WaveId
			test.log(Status.PASS, "wave run ID search completed");
			addSrceenShot("Login", test, Capture);

			waverunspage.waveRunPageStatus(dashboardPage);

			// work release allocation status check process........

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("work release allocation");
			test.log(Status.PASS, "Entered MenuSearch as OLPNS Page");

			waverunspage.clickWRAmenuBtn();

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			waverunspage.enterOrderPlanIDSearch(wvrnid, dashboardPage);

			// ....
			long startTime2 = System.nanoTime();

			String GetTime3 = utilities.Timer();
			System.out.println("work release allocation process  start time is :" + GetTime3);
			test.log(Status.PASS, "work release allocation process  start time is :");
			test.log(Status.PASS, GetTime3);

			waverunspage.workReleasePage(dashboardPage);
			test.log(Status.PASS, "waiting for new status update");

			test.log(Status.PASS, "waiting for new status update");
			System.out.println("New status changed successfully");
			addSrceenShot("Login", test, Capture);

			// ..........total time. end with

			long endTime2 = System.nanoTime();

			String GetTime4 = utilities.Timer();
			System.out.println("Work Release Allocated at Time is   :" + GetTime4);
			test.log(Status.PASS, "Work Release Allocated at Time is   :" + GetTime4);

			String totalTime21 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime2, endTime2);
			/* String s11=Long.toString(totalTime11); */
			System.out.println("The execution minutes is :" + totalTime11);
			test.log(Status.PASS, "The Wave run Execution consumed time in Minutes  : " + totalTime21);

			// .................................total time........................//

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test, readWebTable(waverunspage.waveTableHeader, waverunspage.waveTableBody),
					CompleteSpecs4, wvrnid);
			test.log(Status.PASS, "DO verification completed");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");
			addSrceenShot("Login", test, Capture);

			batchlistpage.clickExpandBarbatch();
			test.log(Status.PASS, "Clicked on ExpandBar");

			String batchlistid = batchlistpage.getBatchNumber();
			test.log(Status.PASS, "Batch id saved");
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("batch list");
			test.log(Status.PASS, "Entered MenuSearch as Batch List");

			batchlistpage.clickbatchbutton();
			test.log(Status.PASS, "Clicked on Batch List Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			batchlistpage.batchsearch(batchlistid, dashboardPage); // B20220118001999 //batchlistid
			test.log(Status.PASS, "Entered Batch List current ID");
			addSrceenShot("Login", test, Capture);

			batchlistpage.selectonebatcRC();
			test.log(Status.PASS, "Clicked on one record");

			batchlistpage.clickReleaseBtn();
			test.log(Status.PASS, "Clicked on release button");
			addSrceenShot("Login", test, Capture);

			batchlistpage.clickYesBtn();
			test.log(Status.PASS, "Clicked on Yes button");
			addSrceenShot("Login", test, Capture);

			// ..........batch list time starts

			long startTime3 = System.nanoTime();

			String GetTime5 = utilities.Timer();
			System.out.println("work release allocation process  start time is :" + GetTime5);
			test.log(Status.PASS, "work release allocation process  start time is :");
			test.log(Status.PASS, GetTime5);

			// ......................................................................................//

			batchlistpage.batchReleaseStatus(dashboardPage);
			test.log(Status.PASS, "waiting for new status update");

			test.log(Status.PASS, "waiting for new status update");
			System.out.println("New status changed successfully");
			addSrceenShot("Login", test, Capture);

			// ...........total time. end with

			long endTime3 = System.nanoTime();

			String GetTime6 = utilities.Timer();
			System.out.println("Order get ship conformed Time is   :" + GetTime6);
			test.log(Status.PASS, "Order get ship conformed Time is   :" + GetTime6);

			String totalTime31 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime3, endTime3);
			/* String s31=Long.toString(totalTime31); */
			System.out.println("The execution minutes is :" + totalTime31);
			test.log(Status.PASS, "The batch list released Execution consumed time in Minutes  : " + totalTime31);

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			dashboardPage.clickRefresh();

			verifyCompleteSpecifics(test, readWebTable(batchlistpage.batchTableHeader, batchlistpage.batchTableBody),
					CompleteSpecs5, batchlistid);
			addSrceenShot("Login", test, Capture);

			// assign task........

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("tasks");
			test.log(Status.PASS, "Entered MenuSearch as tasks");

			taskspage.clicktaskbutton();
			test.log(Status.PASS, "Clicked  MenuSearch page tasks");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			taskspage.enterTaskorderSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS, "Entered wave run ID");
			addSrceenShot("Login", test, Capture);

			taskspage.readyForAssignStatus(dashboardPage);

			String taskiddetails = taskspage.gettaskNumber();
			test.log(Status.PASS, "Process Task ID saved");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test, readWebTable(taskspage.tasksTableHeader, taskspage.tasksTableBody),
					CompleteSpecs6, taskiddetails);
			test.log(Status.PASS, "Batch List Table Content Saved");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			taskspage.selectonetaskRC();
			test.log(Status.PASS, "selected single order tab");
			addSrceenShot("Login", test, Capture);

			taskspage.clickAssignBtn();
			test.log(Status.PASS, "Clicked on assign Button");

			taskspage.enterCurrentUser(USERNAME);
			test.log(Status.PASS, "Entered Username");

			taskspage.selectonetaskRC();
			test.log(Status.PASS, "selected single order tab");
			addSrceenShot("Login", test, Capture);

			taskspage.btntaskThreedots();
			test.log(Status.PASS, "clicked on one threeDots button");

			taskspage.clickDetailsBtn();
			test.log(Status.PASS, "clicked on details button");
			addSrceenShot("Login", test, Capture);

			taskspage.clickAssignableTaskGroup();
			test.log(Status.PASS, "clicked on assigned expand bar");

			String taskgroup = taskspage.getTaskGroupNumber();
			test.log(Status.PASS, "taskgroup ID saved");
			addSrceenShot("Login", test, Capture);

			taskspage.clickCloseIcon();
			test.log(Status.PASS, "closed button clicked successfully");
			addSrceenShot("Login", test, Capture);

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test, readWebTable(taskspage.tasksTableHeader, taskspage.tasksTableBody),
					CompleteSpecs7, taskiddetails);
			test.log(Status.PASS, "Task page all order Table Content Saved");
			addSrceenShot("Login", test, Capture);

			// item page retrive item bar details

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("items");
			test.log(Status.PASS, "Entered MenuSearch as item");

			itemPage.clickitembutton();
			test.log(Status.PASS, "clicked on item button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			itemPage.itemsearch(itemfromOrder1); // ItemNumber
			test.log(Status.PASS, "Entered item IDs on Item Serach box");
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();

			String itembarcode1 = itemPage.getItemBarcodeNoBYOrdersNo(itemfromOrder1);
			test.log(Status.PASS, "first item barcode is saved");

			// ...picking

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wm mobile");
			test.log(Status.PASS, "Entered MenuSearch as WM Menu");

			wvMobilePage.clickWmbtn();
			test.log(Status.PASS, "Clicked on WM Mobile button");
			addSrceenShot("Login", test, Capture);

			utilities.switchToWindows();
			test.log(Status.PASS, "Window switched successfully");

			wvMobilePage.clickSettingsButton();
			test.log(Status.PASS, "Clicked on WM Settings button");

			wvMobilePage.clickTaskGroupRow();
			test.log(Status.PASS, "Clicked on Regerding Task Group");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clicktaskgroupDropDownButton();
			test.log(Status.PASS, "Clicked on Task Group Dropdown");

			wvMobilePage.selectTaskGroup(taskgroup);
			test.log(Status.PASS, "Clicked on Task Group");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.clickDoneBtn();
			test.log(Status.PASS, "Clicked on Done Button");

			wvMobilePage.clicktasksBtn();
			test.log(Status.PASS, "Clicked on Task Button");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickEnterTaskBtn();
			test.log(Status.PASS, "Entered Task button text box column");

			wvMobilePage.enterTaskId(taskiddetails); 
			test.log(Status.PASS, "Entered Task ID in text box  :  " + taskiddetails);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.clickTapToConfrimBtn();
			test.log(Status.PASS, "Clicked on Tab to Conform  Button");

			// Enter cart No :

			wvMobilePage.enterVerifyCartidElement(CartUserKey1);
			test.log(Status.PASS, "Entered CART KEY in text box   :  " + CartUserKey1);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			try {

				wvMobilePage.MultipleConfirmationBtn();

			} catch (Exception e) {
			}

			// TOTE 1

			// Enter Location

			String LocBar = wvMobilePage.getLocBarcode();
			test.log(Status.PASS, "system selected Storage Location is   : " + LocBar);

			wvMobilePage.enterLocationID();
			test.log(Status.PASS, "Entered Current Location Barcode");

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.enteritemBar(itembarcode1);
			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");
			test.log(Status.PASS, "Entered item barcode at textbox  : " + itembarcode1);

			wvMobilePage.getQtyOutbound();
			wvMobilePage.clickGoBtn();

			wvMobilePage.scanToteId(TotUserKey1);
			wvMobilePage.clickGoBtn();

			try {

				wvMobilePage.MultipleConfirmationBtn();

			} catch (Exception e) {
			}

			try {

				// TOTE 2

				wvMobilePage.enterLocationID();
				test.log(Status.PASS, "Entered Current Location Barcode");

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.enteritemBar(itembarcode1);
				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");
				test.log(Status.PASS, "Entered item barcode at textbox  : " + itembarcode1);

				wvMobilePage.getQtyOutbound();
				wvMobilePage.clickGoBtn();

				wvMobilePage.scanToteId(TotUserKey2);
				wvMobilePage.clickGoBtn();

				try {

					wvMobilePage.MultipleConfirmationBtn();

				} catch (Exception e) {
				}

			} catch (Exception e) {
			}

			wvMobilePage.getInformationMessageAndClickOk();
			addSrceenShot("Login", test, Capture);

			wvMobilePage.verifyDestination(LocationKey);
			test.log(Status.PASS, "Entered destination location  : " + LocationKey);
			addSrceenShot("Login", test, Capture);
			wvMobilePage.clickGoBtn();

			wvMobilePage.verifyDestination(LocationKey);
			test.log(Status.PASS, "Entered destination location  : " + LocationKey);
			addSrceenShot("Login", test, Capture);
			wvMobilePage.clickGoBtn();

			utilities.closeCurrentWindow();

			dashboardPage.clickRefresh();
			dashboardPage.clickRefresh();

			// levi pack station

			dashboardPage.clickMenuToggle();

			dashboardPage.enterMenuSearch("levi");

			dashboardPage.clickLeviPackStation();
			test.log(Status.PASS, "Clicked on LeviPackStation Button");

			packStationPage.clickPackkStation();

			if (PackStation.equals("Pack Station 1")) {
				packStationPage.sendpackstation1(PackStation);
			} else if (PackStation.equals("Pack Station 2")) {
				packStationPage.sendpackstation2(PackStation);
			}

			packStationPage.clickStartPackingBtn();
			addSrceenShot("Login", test, Capture);
			test.log(Status.PASS, "Clicked on StartPacking Button");

			packStationPage.enterToteText(TotUserKey1);
			addSrceenShot("Login", test, Capture);

			packStationPage.enterItemText(itembarcode1);
			test.log(Status.PASS, "Entered item barcode  : " + itembarcode1);

			packStationPage.clickDonerightClick();
			test.log(Status.PASS, "Clicked on Done click Button");
			addSrceenShot("Login", test, Capture);

			packStationPage.enterSerialNumber(packStationPage.autoGenSerialNo());
			test.log(Status.PASS, "Entered serial number  : ");
			addSrceenShot("Login", test, Capture);

			packStationPage.clickGoBtnPack();
			test.log(Status.PASS, "Clicked on Go Button");
			addSrceenShot("Login", test, Capture);

			packStationPage.serialConform();
			test.log(Status.PASS, "Clicked on Serial Confirm");
			addSrceenShot("Login", test, Capture);

			packStationPage.dropdownCurrentPage();

			packStationPage.endTote();

			packStationPage.acceptendTote();

			packStationPage.acceptendTote();

			try {

				packStationPage.enterToteText(TotUserKey2);

				packStationPage.endTote();

				packStationPage.acceptendTote();

			} catch (Exception e) {
			}

			// move to cubby location

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("OUTBOUND MANUAL");
			test.log(Status.PASS, "Entered MenuSearch as tasks");

			outboundmanualsorterpage.clickSorterMenu();
			test.log(Status.PASS, "Clicked  MenuSearch page tasks");

			outboundmanualsorterpage.clickCSWrecord();

			// move olpn into cubby loccation

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wm mobile");
			test.log(Status.PASS, "Entered MenuSearch as WM Menu");

			wvMobilePage.clickWmbtn();
			test.log(Status.PASS, "Clicked on WM Mobile button");
			addSrceenShot("Login", test, Capture);

			utilities.switchToWindows();
			test.log(Status.PASS, "Window switched successfully");

			wvMobilePage.clickChaseBtn();

			wvMobilePage.clickCubbyBtn();

			wvMobilePage.enterScanCubbyOlpn(olpnfromOrder1);
			test.log(Status.PASS, "Entered olpn  in text box   :  " +  olpnfromOrder1);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.enterDestChase(sortloc1);

			test.log(Status.PASS, "Entered dest chase sort  in text box   :  " +  sortloc1);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			try {

				wvMobilePage.ConfirmBtn();
				test.log(Status.PASS, "Clicked Confirmation Button");

			} catch (Exception e) {
			}

			wvMobilePage.enterScanCubbyOlpn(olpnfromOrder2);
			test.log(Status.PASS, "Entered olpn  in text box   :  " +  olpnfromOrder2);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.enterDestChase(sortloc2);

			test.log(Status.PASS, "Entered dest chase sort  in text box   :   " + sortloc2);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			try {

				wvMobilePage.ConfirmBtn();
				test.log(Status.PASS, "Clicked Confirmation Button");

			} catch (Exception e) {
			}

			utilities.closeCurrentWindow();

			// After cubby movement to Start chase wave

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("orders");
			test.log(Status.PASS, "Entered MenuSearch as orders");

			dashboardPage.ordersclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS, "Entered Order Search  :  " +  OrderNumber + ", " + OrderNumber2);
			addSrceenShot("Login", test, Capture);

			orderspage.selectAllRecord();
			test.log(Status.PASS, "clicked on one record button");
			addSrceenShot("Login", test, Capture);

			orderspage.clickRelatedLinks();
			test.log(Status.PASS, "clicked on order related links");

			orderspage.clickOrderShordage();
			test.log(Status.PASS, "clicked on order shordage");

			orderspage.selectAllRecord();
			test.log(Status.PASS, "clicked on one record button");
			addSrceenShot("Login", test, Capture);

			orderspage.selectChaseWaveBtn();
			test.log(Status.PASS, "clicked on chase wave btn");

			orderspage.enterChaseWave();
			test.log(Status.PASS, "selected OPS chase wave");

			orderspage.confirmSummit();
			test.log(Status.PASS, "clicked on one summit button");

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			orderspage.clickExpandBarolpns();

			String wvrnid2 = orderspage.oRSortwaverunid();
			test.log(Status.PASS, "saved wave run ID  :  " +  wvrnid2);

			// wave run to wra convertion process.............................//

			ilpnPage.clickLpnMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wave run");
			test.log(Status.PASS, "Entered MenuSearch as wave run");

			waverunspage.clickWaverunbtn();
			test.log(Status.PASS, "Clicked on waverun page  Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			dashboardPage.wavesearch(wvrnid2,dashboardPage);// WaveId
			test.log(Status.PASS, "wave run ID search completed  :  " + wvrnid2);
			addSrceenShot("Login", test, Capture);

			waverunspage.waveRunPageStatus(dashboardPage);

			// work release allocation status check process........

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("work release allocation");
			test.log(Status.PASS, "Entered MenuSearch as work release allocation Page");

			waverunspage.clickWRAmenuBtn();

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			waverunspage.enterOrderPlanIDSearch(wvrnid2, dashboardPage);

			// .....wave run time starts

			long AstartTime2 = System.nanoTime();

			String AGetTime3 = utilities.Timer();
			System.out.println("work release allocation process  start time is :" + AGetTime3);
			test.log(Status.PASS, "work release allocation process  start time is :");
			test.log(Status.PASS, AGetTime3);

			// ......................................................................................//

			waverunspage.workReleasePage(dashboardPage);
			test.log(Status.PASS, "waiting for new status update");

			test.log(Status.PASS, "waiting for new status update");
			System.out.println("New status changed successfully");
			addSrceenShot("Login", test, Capture);

			// .....total time. end with

			long AendTime2 = System.nanoTime();

			String AGetTime4 = utilities.Timer();
			System.out.println("Work Release Allocated at Time is   :" + AGetTime4);
			test.log(Status.PASS, "Work Release Allocated at Time is   :" + AGetTime4);

			String AtotalTime21 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime2, endTime2);
			/* String s11=Long.toString(totalTime11); */
			System.out.println("The execution minutes is :" + totalTime11);
			test.log(Status.PASS, "The Wave run Execution consumed time in Minutes  : " + totalTime21);

			// .................................total time........................//

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test, readWebTable(waverunspage.waveTableHeader, waverunspage.waveTableBody),
					CompleteSpecs4, wvrnid2);
			test.log(Status.PASS, "DO verification completed");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");
			addSrceenShot("Login", test, Capture);

			batchlistpage.clickExpandBarbatch();
			test.log(Status.PASS, "Clicked on ExpandBar");

			String batchlistid2 = batchlistpage.getBatchNumber();
			test.log(Status.PASS, "Batch id saved  :  " +  batchlistid2);
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("batch list");
			test.log(Status.PASS, "Entered MenuSearch as Batch List");

			batchlistpage.clickbatchbutton();
			test.log(Status.PASS, "Clicked on Batch List Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			batchlistpage.batchsearch(batchlistid2, dashboardPage); // B20220118001999 //batchlistid
			test.log(Status.PASS, "Entered Batch List current ID");
			addSrceenShot("Login", test, Capture);

			batchlistpage.selectonebatcRC();
			test.log(Status.PASS, "Clicked on one record");

			batchlistpage.clickReleaseBtn();
			test.log(Status.PASS, "Clicked on release button");
			addSrceenShot("Login", test, Capture);

			batchlistpage.clickYesBtn();
			test.log(Status.PASS, "Clicked on Yes button");
			addSrceenShot("Login", test, Capture);

			// ...............batch list time starts

			long AstartTime3 = System.nanoTime();

			String AGetTime5 = utilities.Timer();
			System.out.println("work release allocation process  start time is :" + AGetTime5);
			test.log(Status.PASS, "work release allocation process  start time is :");
			test.log(Status.PASS, AGetTime5);

			batchlistpage.batchReleaseStatus(dashboardPage);
			test.log(Status.PASS, "waiting for new status update");

			test.log(Status.PASS, "waiting for new status update");
			System.out.println("New status changed successfully");
			addSrceenShot("Login", test, Capture);

			// ...............total time. end with

			long AendTime3 = System.nanoTime();

			String AGetTime6 = utilities.Timer();
			System.out.println("Order get ship conformed Time is   :" + AGetTime6);
			test.log(Status.PASS, "Order get ship conformed Time is   :" + AGetTime6);

			String AtotalTime31 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime3, endTime3);
			/* String s31=Long.toString(totalTime31); */
			System.out.println("The execution minutes is :" + AtotalTime31);
			test.log(Status.PASS, "The batch list released Execution consumed time in Minutes  : " + totalTime31);

			// ..........total time.........

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			dashboardPage.clickRefresh();

			verifyCompleteSpecifics(test, readWebTable(batchlistpage.batchTableHeader, batchlistpage.batchTableBody),
					CompleteSpecs5, batchlistid2);
			addSrceenShot("Login", test, Capture);

			// assign task..........

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("tasks");
			test.log(Status.PASS, "Entered MenuSearch as tasks");

			taskspage.clicktaskbutton();
			test.log(Status.PASS, "Clicked  MenuSearch page tasks");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			taskspage.enterTaskorderSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS, "Entered wave run ID  :  " + OrderNumber + ", " + OrderNumber2);
			addSrceenShot("Login", test, Capture);

			taskspage.readyForAssignStatus(dashboardPage);

			String taskiddetails2 = taskspage.gettaskNumber();
			test.log(Status.PASS, "Process Task ID saved   :  " + taskiddetails2);

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test, readWebTable(taskspage.tasksTableHeader, taskspage.tasksTableBody),
					CompleteSpecs6, taskiddetails2);
			test.log(Status.PASS, "Batch List Table Content Saved");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			taskspage.selectonetaskRC();
			test.log(Status.PASS, "selected single order tab");
			addSrceenShot("Login", test, Capture);

			taskspage.clickAssignBtn();
			test.log(Status.PASS, "Clicked on assign Button");

			taskspage.enterCurrentUser(USERNAME);
			test.log(Status.PASS, "Entered Username");

			taskspage.selectonetaskRC();
			test.log(Status.PASS, "selected single order tab");
			addSrceenShot("Login", test, Capture);

			taskspage.btntaskThreedots();
			test.log(Status.PASS, "clicked on one threeDots button");

			taskspage.clickDetailsBtn();
			test.log(Status.PASS, "clicked on details button");
			addSrceenShot("Login", test, Capture);

			taskspage.clickAssignableTaskGroup();
			test.log(Status.PASS, "clicked on assigned expand bar");

			String taskgroup2 = taskspage.getTaskGroupNumber();
			test.log(Status.PASS, "taskgroup ID saved");
			addSrceenShot("Login", test, Capture);

			taskspage.clickCloseIcon();
			test.log(Status.PASS, "closed button clicked successfully");
			addSrceenShot("Login", test, Capture);

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test, readWebTable(taskspage.tasksTableHeader, taskspage.tasksTableBody),
					CompleteSpecs7, taskiddetails2);
			test.log(Status.PASS, "Task page all order Table Content Saved");
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wm mobile");
			test.log(Status.PASS, "Entered MenuSearch as WM Menu");

			wvMobilePage.clickWmbtn();
			test.log(Status.PASS, "Clicked on WM Mobile button");
			addSrceenShot("Login", test, Capture);

			utilities.switchToWindows();
			test.log(Status.PASS, "Window switched successfully");

			wvMobilePage.clickSettingsButton();
			test.log(Status.PASS, "Clicked on WM Settings button");

			wvMobilePage.clickTaskGroupRow();
			test.log(Status.PASS, "Clicked on Regerding Task Group");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clicktaskgroupDropDownButton();
			test.log(Status.PASS, "Clicked on Task Group Dropdown");

			wvMobilePage.selectTaskGroup(taskgroup2);
			test.log(Status.PASS, "Clicked on Task Group   :  " + taskgroup2);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.clickDoneBtn();
			test.log(Status.PASS, "Clicked on Done Button");

			wvMobilePage.clicktasksBtn();
			test.log(Status.PASS, "Clicked on Task Button");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickEnterTaskBtn();
			test.log(Status.PASS, "Entered Task button text box column");

			wvMobilePage.enterTaskId(taskiddetails2); // Task: WRPICK0000009090
			test.log(Status.PASS, "Entered Task ID in text box   :  " + taskiddetails2);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.clickTapToConfrimBtn();
			test.log(Status.PASS, "Clicked on Tab to Conform  Button");

			try {

				wvMobilePage.MultipleConfirmationBtn();

			} catch (Exception e) {
			}

			// Enter cart No :

			wvMobilePage.enterVerifyCartidElement(CartUserKey2);
			test.log(Status.PASS, "Entered Cart id in text box    :  " + CartUserKey2);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			try {

				wvMobilePage.MultipleConfirmationBtn();

			} catch (Exception e) {
			}

			// Slot 1

			wvMobilePage.enterLocationID();
			test.log(Status.PASS, "Entered Current Location Barcode");

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.enteritemBar(itembarcode1);
			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");
			test.log(Status.PASS, "Entered item barcode at textbox  : " + itembarcode1);

			wvMobilePage.getQtyOutbound();
			wvMobilePage.clickGoBtn();
			
			test.log(Status.PASS, "Clicked on Go Button");
			test.log(Status.PASS, "Entered qty at textbox  : " + "1");

			wvMobilePage.scanToteId(TotUserKey3);
			test.log(Status.PASS, "Destination Location Entered : " + TotUserKey3);
			wvMobilePage.clickGoBtn();

			// Slot 2

			try {

			

				wvMobilePage.enterLocationID();
				test.log(Status.PASS, "Entered Current Location Barcode");

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.enteritemBar(itembarcode1);
				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");
				test.log(Status.PASS, "Entered item barcode at textbox  : " + itembarcode1);

				wvMobilePage.getQtyOutbound();
				wvMobilePage.clickGoBtn();
				
				test.log(Status.PASS, "Clicked on Go Button");
				test.log(Status.PASS, "Entered qty at textbox  : " + "1");

				wvMobilePage.scanToteId(TotUserKey4);
				test.log(Status.PASS, "Destination Location Entered : " + TotUserKey4);
				wvMobilePage.clickGoBtn();


				

			} catch (Exception e) {
			}

			wvMobilePage.getInformationMessageAndClickOk();
			addSrceenShot("Login", test, Capture);

			wvMobilePage.enterDestinationLocationID();
			addSrceenShot("Login", test, Capture);
			wvMobilePage.clickGoBtn();

			utilities.closeCurrentWindow();

			// olpns page ......................................

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("olpns");
			test.log(Status.PASS, "Entered MenuSearch as OLPNS Page");

			dashboardPage.olpnclick();
			test.log(Status.PASS, "Clicked on OLPNS page Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			orderspage.searchOlpntextbox(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS, "status changed successfully");
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			// put wall sort by chase wave in wm mobile

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wm mobile");
			test.log(Status.PASS, "Entered MenuSearch as WM Menu");

			wvMobilePage.clickWmbtn();
			test.log(Status.PASS, "Clicked on WM Mobile button");
			addSrceenShot("Login", test, Capture);

			utilities.switchToWindows();
			test.log(Status.PASS, "Window switched successfully");

			wvMobilePage.clickSettingsButton();
			test.log(Status.PASS, "Clicked on WM Settings button");

			wvMobilePage.clickTaskGroupRow();
			test.log(Status.PASS, "Clicked on Regerding Task Group");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clicktaskgroupDropDownButton();
			test.log(Status.PASS, "Clicked on Task Group Dropdown");

			wvMobilePage.selectTaskGroup("PTW");
			test.log(Status.PASS, "Clicked on Task Group");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.clickDoneBtn();
			test.log(Status.PASS, "Clicked on Done Button");

			wvMobilePage.clickChaseBtn();

			// first packed 1 qty tote

			wvMobilePage.clickExpPutwallBtn();

			wvMobilePage.enterChasewall(chasewall);

			wvMobilePage.clickShadowGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			// TOTE 1

			wvMobilePage.enterSourceTote(TotUserKey3);
			wvMobilePage.clickShadowGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.enteritemWall(itembarcode1);
			wvMobilePage.clickShadowGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			try {

				outboundmanualsorterpage.enterChaseLocationID();
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			} catch (Exception e) {

				outboundmanualsorterpage.enterDesSortLocationText(sortloc1);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			}

			String locOlpn1 = outboundmanualsorterpage.enterOlpnSortALocationID();

			outboundmanualsorterpage.enterOlpnID(locOlpn1);
			wvMobilePage.clickShadowGoBtn();
			test.log(Status.PASS, "OLPN Moved");

			try {

				outboundmanualsorterpage.clickYesBtn();

				String locOlpn3 = outboundmanualsorterpage.enterOlpnSortALocationID();
				outboundmanualsorterpage.enterOlpnID(locOlpn3);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			} catch (Exception e) {

				wvMobilePage.enteritemWall(itembarcode1);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				outboundmanualsorterpage.enterDesSortLocationText(sortloc1);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				String locOlpn2 = outboundmanualsorterpage.enterOlpnSortALocationID();
				outboundmanualsorterpage.enterOlpnID(locOlpn2);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				outboundmanualsorterpage.clickYesBtn();

				String locOlpn3 = outboundmanualsorterpage.enterOlpnSortALocationID();
				outboundmanualsorterpage.enterOlpnID(locOlpn3);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			}

			// secound qty

			try {

				wvMobilePage.enterSourceTote(TotUserKey4);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.enteritemWall(itembarcode1);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				try {

					outboundmanualsorterpage.enterChaseLocationID();
					wvMobilePage.clickShadowGoBtn();
					test.log(Status.PASS, "Clicked on Go Button");

				} catch (Exception e) {

					outboundmanualsorterpage.enterDesSortLocationText(sortloc2);
					wvMobilePage.clickShadowGoBtn();
					test.log(Status.PASS, "Clicked on Go Button");

				}

				String locOlpn4 = outboundmanualsorterpage.enterOlpnSortALocationID();
				outboundmanualsorterpage.enterOlpnID(locOlpn4);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.enteritemWall(itembarcode1);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				try {

					outboundmanualsorterpage.enterChaseLocationID();
					wvMobilePage.clickShadowGoBtn();
					test.log(Status.PASS, "Clicked on Go Button");

				} catch (Exception e) {

					outboundmanualsorterpage.enterDesSortLocationText(sortloc2);
					wvMobilePage.clickShadowGoBtn();
					test.log(Status.PASS, "Clicked on Go Button");

				}

				String locOlpn2 = outboundmanualsorterpage.enterOlpnSortALocationID();
				outboundmanualsorterpage.enterOlpnID(locOlpn2);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				outboundmanualsorterpage.clickYesBtn();

				String locOlpn5 = outboundmanualsorterpage.enterOlpnSortALocationID();
				outboundmanualsorterpage.enterOlpnID(locOlpn5);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			} catch (Exception e) {

				wvMobilePage.enteritemWall(itembarcode1);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				outboundmanualsorterpage.enterChaseLocationID();
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				String locOlpn2 = outboundmanualsorterpage.enterOlpnSortALocationID();
				outboundmanualsorterpage.enterOlpnID(locOlpn2);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				outboundmanualsorterpage.clickYesBtn();

				String locOlpn5 = outboundmanualsorterpage.enterOlpnSortALocationID();
				outboundmanualsorterpage.enterOlpnID(locOlpn5);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			}

			utilities.closeCurrentWindow();

			// check order status

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("orders");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			dashboardPage.ordersclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS, "Entered Order Search");
			addSrceenShot("Login", test, Capture);

			// weigh to manifestate

			dashboardPage.clickMenuToggle();

			dashboardPage.enterMenuSearch("weigh manifest station");
			test.log(Status.PASS, "Entered MenuSearch as ILPNs");

			packStationPage.clickWeighManifestBtn();

			packStationPage.sendReturnPrinter();

			packStationPage.clickPrinterBtn();

			packStationPage.wavesearch(olpnfromOrder1);

			packStationPage.BtnManifestate();

			packStationPage.wavesearch(olpnfromOrder2);

			packStationPage.BtnManifestate();

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("orders");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			dashboardPage.ordersclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS, "Entered Order Search");
			addSrceenShot("Login", test, Capture);

			// ILPN Status checking

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("ILPNs");
			addSrceenShot("Login", test, Capture);
			test.log(Status.PASS, "Entered MenuSearch as ILPNs");

			addSrceenShot("Login", test, Capture);

			ilpnPage.ilpnsSelectMenu();
			test.log(Status.PASS, "Clicked on iLPN Menu link");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			lsnPage.enterLpnSearch(TotUserKey1);

			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();
			
			// parcel journal

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("Parcel journal");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			dashboardPage.ParcelJournalclick();
			addSrceenShot("Login", test, Capture);

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Clicked on clear Button");

			dashboardPage.searchTransactiontextbox(olpnfromOrder1);
			test.log(Status.PASS, "Entered OLPN number at page of textbox : " + olpnfromOrder1);
			addSrceenShot("Login", test, Capture);

			// olpnsNumber

			try {

				taskspage.selectShipBtn("Ship");
				test.log(Status.PASS, "Clicked on Ship Button");
			} catch (Exception e) {
			}

			addSrceenShot("Login", test, Capture);

			try {
				String ship1 = dashboardPage.getShipStatus("1");
				System.out.println(ship1);
				test.log(Status.PASS, "Saved response message  : " + " < Ship > " + ship1);
			} catch (Exception e) {
			}

			addSrceenShot("Login", test, Capture);

			try {
				String ship2 = dashboardPage.getShipStatus("2");
				System.out.println(ship2);
				test.log(Status.PASS, "Saved response message  : " + " < Ship > " + ship2);
			} catch (Exception e) {
			}

			addSrceenShot("Login", test, Capture);

			dashboardPage.clearAllBtn();

			try {

				taskspage.selectShipBtn("ShipRelease");
				test.log(Status.PASS, "Clicked on ShipRelease Button");

			} catch (Exception e) {
			}

			addSrceenShot("Login", test, Capture);

			try {
				String ShipRelease1 = dashboardPage.getShipStatus("1");
				System.out.println(ShipRelease1);
				test.log(Status.PASS, "Saved response message  : " + " < ShipRelease >" + ShipRelease1);
			} catch (Exception e) {
			}

			addSrceenShot("Login", test, Capture);

			try {
				String ShipRelease2 = dashboardPage.getShipStatus("2");
				System.out.println(ShipRelease2);
				test.log(Status.PASS, "Saved response message  : " + " < ShipRelease >" + ShipRelease2);
			} catch (Exception e) {
			}

			addSrceenShot("Login", test, Capture);

			dashboardPage.clearAllBtn();

			try {

				taskspage.selectShipBtn("RateShop");
				test.log(Status.PASS, "Clicked on RateShop Button");
			} catch (Exception e) {
			}
			addSrceenShot("Login", test, Capture);

			try {
				String RateShop1 = dashboardPage.getShipStatus("1");
				System.out.println(RateShop1);
				test.log(Status.PASS, "Saved response message  : " + " < RateShop >" + RateShop1);
			} catch (Exception e) {
			}
			addSrceenShot("Login", test, Capture);
			try {
				String RateShop2 = dashboardPage.getShipStatus("2");
				System.out.println(RateShop2);
				test.log(Status.PASS, "Saved response message  : " + " < RateShop >" + RateShop2);
			} catch (Exception e) {
			}

			addSrceenShot("Login", test, Capture);

			System.out.println("Current OLPN parcel end validation is  completed  :  " + olpnfromOrder1);
			test.log(Status.PASS, "Current OLPN parcel end validation is  completed  :  " + olpnfromOrder1);

			// MHE Journal Validation

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("MHE Journal");
			test.log(Status.PASS, "Entered MenuSearch as MHE   : " + "MHE Journal");
			addSrceenShot("Login", test, Capture);

			orderspage.JournalMHE();
			test.log(Status.PASS, "clicked MHE Journal button");

			orderspage.searchMHEOrderstextbox(OrderNumber);
			test.log(Status.PASS, "Entered order at MHE journal page transcation textbox   : " + "MHE Journal");
			addSrceenShot("Login", test, Capture);

			orderspage.searchMsgTypeMHE("Pick_Complete");
			test.log(Status.PASS, "clicked Pick Complete button");

			try {

				orderspage.selectPJfirstRow("1");
				test.log(Status.PASS, "select first ROW column");
				addSrceenShot("Login", test, Capture);

				orderspage.clickDetailsBtn();
				test.log(Status.PASS, "clicked on Details button");

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				String msg1 = orderspage.getMHEvalidateDetails("ERROR");
				test.log(Status.PASS, msg1);

				String msg2 = orderspage.getMHEvalidateDetails("TRANSFORMED");
				test.log(Status.PASS, msg2);

				if (msg1.contains(TotUserKey1)) {

					test.log(Status.PASS, "Message payload  text contains TOTE NUMBER :" + TotUserKey1);
				} else {

					test.log(Status.INFO, "Message payload  text contains TOTE NUMBER :" + TotUserKey1);
				}

			} catch (Exception e) {

			}

			// Printing Journal Validation

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("olpns");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			dashboardPage.olpnclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Clicked on clear All Button");

			orderspage.searchOlpntextbox(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS, "Entered order at order textbox   : " + OrderNumber);
			addSrceenShot("Login", test, Capture);

			orderspage.selectAllRecord();
			test.log(Status.PASS, "clicked on one record button");
			addSrceenShot("Login", test, Capture);

			orderspage.clickRelatedLinks();
			test.log(Status.PASS, "clicked on related links button");
			addSrceenShot("Login", test, Capture);

			orderspage.selectPrintingJournal();
			test.log(Status.PASS, "selected printing journal option from Related Links");

			orderspage.searchDocType("COLLATE_REPORT_DEFAULT");
			test.log(Status.PASS, "Selected collate report message on the field   : " + "COLLATE_REPORT_DEFAULT");

			orderspage.searchMetaByOLPNS(olpnfromOrder1);
			test.log(Status.PASS, "Entered OLPNS at OLPN page textbox   : " + olpnfromOrder1);

			// first Docs

			try {

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "clicked refresh button");

				orderspage.selectPJfirstRow("1");
				test.log(Status.PASS, "select first ROW column");
				addSrceenShot("Login", test, Capture);

				orderspage.viewDocBtn();
				test.log(Status.PASS,
						"clicked on view button and opened new tab & PDF file able to view human readable format");
				addSrceenShot("Login", test, Capture);

				WaitforPage(6000);

				utilities.switchToWindows();
				test.log(Status.PASS, "switched new tab button");

				utilities.closeCurrentWindow();
				test.log(Status.PASS, "closed current window button");

			} catch (Exception e) {
			}

			WaitforPage(6000);

			// first label

			orderspage.searchDocType("SHIPPING_LABEL_DEFAULT");

			orderspage.searchMetaByOLPNS(olpnfromOrder1);

			// first Docs

			try {

				dashboardPage.clickRefresh();

				orderspage.selectPJfirstRow("1");
				test.log(Status.PASS, "select first ROW column");
				addSrceenShot("Login", test, Capture);

				orderspage.viewDocBtn();
				test.log(Status.PASS,
						"clicked on view button and opened new tab & shipping label programming code copy to paste new tab by label viewer  webpage");
				addSrceenShot("Login", test, Capture);

				WaitforPage(6000);

				utilities.switchToWindows();
				test.log(Status.PASS, "switched new tab button");

				String LableDetails = orderspage.getShipLable();
				test.log(Status.PASS, "copy to page label message both console and report log : " + LableDetails);

				orderspage.newUrl();
				test.log(Status.PASS, "opened label viewer URL on new TAb");
				addSrceenShot("Login", test, Capture);

				orderspage.enterShipLable(LableDetails);
				test.log(Status.PASS, "Label code pasted into label viewer web page : " + LableDetails);

				orderspage.clickRedrew();
				test.log(Status.PASS, "clicked on redrew to view human readable format");
				addSrceenShot("Login", test, Capture);

				orderspage.clickPDFdownloadElement();
				test.log(Status.PASS, "click download button to download PDF from web page");

				utilities.closeCurrentWindow();
				test.log(Status.PASS, "closed current window button");

			} catch (Exception e) {
			}

			WaitforPage(6000);

			// ship conformation on last process of the outbound flow

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("orders");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			addSrceenShot("Login", test, Capture);

			dashboardPage.ordersclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clickRefresh();

			orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2,dashboardPage);
			test.log(Status.PASS, "Entered Order Search");

			addSrceenShot("Login", test, Capture);

			orderspage.selectAllRecord();
			test.log(Status.PASS, "clicked on one record button");
			addSrceenShot("Login", test, Capture);

			orderspage.btnThreedots();
			test.log(Status.PASS, "clicked on one threeDots button");

			orderspage.clickshipbutton(test);
			test.log(Status.PASS, "clicked on ship confirm button");

			addSrceenShot("Login", test, Capture);

			long startTime4 = System.nanoTime();

			String GetTime7 = utilities.Timer();
			System.out.println("Ship Conformation is Started time :" + GetTime7);
			test.log(Status.PASS, "Ship Conformation is Started time :");
			test.log(Status.PASS, GetTime7);

			orderspage.shipConfirmStatus(dashboardPage);
			test.log(Status.PASS, "DO status now changed to Shipped");

			addSrceenShot("Login", test, Capture);

			// sysm mgmt

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("system management");
			test.log(Status.PASS, "Entered MenuSearch as system management");

			systemmanagementpage.clickSystemMgmtBtn();
			test.log(Status.PASS, "Clicked on system management button");

			utilities.switchToWindows();

			// tranlog

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("tranlog details");
			test.log(Status.PASS, "Entered MenuSearch as ILPNs");

			systemmanagementpage.clickTranlogDetailsBtn();
			test.log(Status.PASS, "Clicked on tranlog details Button from menu search");
			addSrceenShot("Login", test, Capture);

			systemmanagementpage.enterTranlogToteIDSearch(OrderNumber + ", " + OrderNumber2);
			test.log(Status.PASS, "Entered tranlogsearchbox as order  : " + OrderNumber + ", " + OrderNumber2);
			addSrceenShot("Login", test, Capture);

			systemmanagementpage.bulkRfreshPage(dashboardPage);
			test.log(Status.PASS, "bulk refresh completed");


			systemmanagementpage.clickTranFirstRecordBtn();
			test.log(Status.PASS, "Clicked on first button");

			systemmanagementpage.clickPayLoadBtn();
			test.log(Status.PASS, "Clicked on payload button from bottom menu");
			addSrceenShot("Login", test, Capture);

			systemmanagementpage.clicklinebtn();
			test.log(Status.PASS, "Clicked on convert text line button inside payload message");
			String payLoad = systemmanagementpage.getInnerTextMessage();
			addSrceenShot("Login", test, Capture);

			System.out.println(payLoad);
			test.log(Status.PASS, "Payload message saved into log reports-------------->" + payLoad);

			if (payLoad.contains("Full ShipConfirm")) {
				test.log(Status.PASS, "Payload text contains " + "Full ShipConfirm");
				addSrceenShot("Login", test, Capture);
			} else {
				test.log(Status.INFO, "Payload text does not contain " + "Full ShipConfirm");
				addSrceenShot("Login", test, true);
			}

			if (payLoad.contains(OrderNumber)) {
				test.log(Status.PASS, "Payload text contains " + OrderNumber);
				addSrceenShot("Login", test, Capture);
			} else {
				test.log(Status.INFO, "Payload text does not contain " + OrderNumber);
				addSrceenShot("Login", test, true);
			}

			long endTime88 = System.nanoTime();

			String GetTime211 = utilities.Timer();
			System.out.println(
					" < Testcase execution completed  >  : " + " < WMS_Multis_Gift_Card_PackShort_Putwall_Exception > "
							+ "Execution completed time :  " + GetTime211);
			test.log(Status.PASS,
					" < Testcase execution completed  >  : " + " < WMS_Multis_Gift_Card_PackShort_Putwall_Exception > "
							+ "Execution completed time :  " + GetTime211);
		}
	}

	@AfterMethod
	public void setUpend() {

		extent.flush();
		driver.quit();
	}
}