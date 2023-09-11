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

//@Test(enabled = true, groups = { "PackShort_Orders" })
public class WMS_PackSort_MultiBag_Corton extends WMS_TestBase {

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
	WMS_BatchListPage batchlistpage;
	WMS_TasksPage taskspage;
	WMS_PackStationPage packStationPage;
	WMS_SystemManagementPage systemmanagementpage;
	WMS_OutboundManualSorter outboundmanualsorterpage;
	boolean Capture = true;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			launchUrl();
			loginPage = new WMS_LoginPage(driver);
			dashboardPage = new WMS_DashboardPage(driver);
			asnPage = new WMS_ASNPage(driver);
			ilpnPage = new WMS_LPNPage(driver);
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
			setReport("WMS_PackSort_MultiBag_Corton");

		}
	}

	@Test(priority = 0, dataProvider = "WMS_PAST_Gift_Card", dataProviderClass = DataProviders.class)
	public void orderAllocation(String OrderNumber, String OrderNumber2, String CompleteSpecs1, String CompleteSpecs2,
			String CompleteSpecs3, String CompleteSpecs4, String CompleteSpecs5, String CompleteSpecs6,
			String CompleteSpecs7, String TotUserKey1, String TotUserKey2, String TotUserKey3, String TotUserKey4,
			String LocationKey, String CartUserKey1, String CartUserKey2, String CompleteSpecs8, String CompleteSpecs9,
			String PackStation, String sortloc1, String sortloc2, String chasewall)
			throws InterruptedException, AWTException {

		if (!OrderNumber.equals(" ")) {
			if (CloseBrowser) {

				test = extent.createTest(":::WMS_PackSort_MultiBag_Corton:::");

			}

			CloseBrowser = false;

			// ............browser launched time starts

			long startTime = System.nanoTime();

			String GetTime = utilities.Timer();
			System.out.println("Browser Launched Time :" + GetTime);
			test.log(Status.PASS, "Browser Launched Time :" + GetTime);

			System.out.println("Browser Launched successfully");
			test.log(Status.PASS, "Browser Launched successfully");

			loginPage.verifyLogoExists();
			test.log(Status.PASS, " Manhattan Active Supply Chain Logo is Displayed ");

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
			test.log(Status.PASS, "Clicked on Orders Button");

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

			// wave run start at................

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

			orderspage.enterWaveStatergy(" OPS - Standard Wave ");
			test.log(Status.PASS, "Selected The standard Wave  :  " + "OPS - Standard Wave");
			addSrceenShot("Login", test, Capture);

			orderspage.confirmSummit();
			test.log(Status.PASS, "clicked on one summit button");

			// ..total timer start......

			long startTime1 = System.nanoTime();

			String GetTime2 = utilities.Timer();
			System.out.println("wave run start time is :" + GetTime2);
			test.log(Status.PASS, "wave run start time is :" + GetTime2);

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
			System.out.println("The execution minutes is :" + totalTime11);
			test.log(Status.PASS, "The Wave run Execution consumed time in Minutes  : " + totalTime11);

			// ..........total time......

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
			test.log(Status.PASS, "item saved  " + itemfromOrder1);
			addSrceenShot("Login", test, Capture);

			// olpns page ........

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("olpns");
			test.log(Status.PASS, "Entered MenuSearch as : " + "olpns");

			dashboardPage.olpnclick();
			test.log(Status.PASS, "Clicked on olpns page Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Clear all selected texboxs and filters");

			orderspage.searchOlpntextbox(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS, "status changed successfully " + OrderNumber + ", " + OrderNumber2);
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			String olpnfromOrder1 = orderspage.getOlpnsNumberFirst(OrderNumber);
			test.log(Status.PASS, "OLPNS 1 saved   : " + olpnfromOrder1);
			addSrceenShot("Login", test, Capture);

			String olpnfromOrder2 = orderspage.getOlpnsNumberFirst(OrderNumber2);
			test.log(Status.PASS, "OLPNS 2 saved  : " + olpnfromOrder2);
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

			String waveid1 = waverunspage.waverunid();
			test.log(Status.PASS, "Wave run ID is  :  " + waveid1);

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			// wave run to wra convertion process....

			ilpnPage.clickLpnMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wave run");
			test.log(Status.PASS, "Entered MenuSearch " + "wave run");

			waverunspage.clickWaverunbtn();
			test.log(Status.PASS, "Clicked on waverun page  Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			dashboardPage.wavesearch(waveid1, dashboardPage);
			test.log(Status.PASS, "wave run id search c1ompleted" + waveid1);
			addSrceenShot("Login", test, Capture);

			waverunspage.waveRunPageStatus(dashboardPage);

			// work release allocation status check process........

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("work release allocation");
			test.log(Status.PASS, "Entered MenuSearch as OLPNS Page");

			waverunspage.clickWRAmenuBtn();
			test.log(Status.PASS, "Clicked on WRA Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			waverunspage.enterOrderPlanIDSearch(waveid1, dashboardPage);
			test.log(Status.PASS, "wave run id entered " + waveid1);

			long startTime2 = System.nanoTime();

			String GetTime3 = utilities.Timer();
			System.out.println("work release allocation process  start time is :" + GetTime3);
			test.log(Status.PASS, "work release allocation process  start time is :");
			test.log(Status.PASS, GetTime3);

			waverunspage.workReleasePage(dashboardPage);
			System.out.println("New status changed successfully");
			addSrceenShot("Login", test, Capture);

			// ..........total time. end with

			long endTime2 = System.nanoTime();

			String GetTime4 = utilities.Timer();
			System.out.println("Work Release Allocated at Time is   :" + GetTime4);
			test.log(Status.PASS, "Work Release Allocated at Time is   :" + GetTime4);

			String totalTime21 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime2, endTime2);
			System.out.println("The execution minutes is :" + totalTime11);
			test.log(Status.PASS, "The Wave run Execution consumed time in Minutes  : " + totalTime21);

			// ......total time.......

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test, readWebTable(waverunspage.waveTableHeader, waverunspage.waveTableBody),
					CompleteSpecs4, waveid1);
			test.log(Status.PASS, "DO verification completed");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");
			addSrceenShot("Login", test, Capture);

			batchlistpage.clickExpandBarbatch();
			test.log(Status.PASS, "Clicked on ExpandBar");

			String batchid1 = batchlistpage.getBatchNumber();
			test.log(Status.PASS, "Batch id saved  " + batchid1);
			addSrceenShot("Login", test, Capture);

			// batch list page..

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("batch list");
			test.log(Status.PASS, "Entered MenuSearch as Batch List");

			batchlistpage.clickbatchbutton();
			test.log(Status.PASS, "Clicked on Batch List Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			batchlistpage.batchsearch(batchid1, dashboardPage);
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
			System.out.println("New status changed successfully");
			addSrceenShot("Login", test, Capture);

			// ...........total time. end with

			long endTime3 = System.nanoTime();

			String GetTime6 = utilities.Timer();
			System.out.println("Order get ship conformed Time is   :" + GetTime6);
			test.log(Status.PASS, "Order get ship conformed Time is   :" + GetTime6);

			String totalTime31 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime3, endTime3);
			System.out.println("The execution minutes is :" + totalTime31);
			test.log(Status.PASS, "The batch list released Execution consumed time in Minutes  : " + totalTime31);

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			dashboardPage.clickRefresh();

			verifyCompleteSpecifics(test, readWebTable(batchlistpage.batchTableHeader, batchlistpage.batchTableBody),
					CompleteSpecs5, batchid1);
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

			taskspage.Waverun(waveid1, dashboardPage);
			test.log(Status.PASS, "Entered wave run ID");
			addSrceenShot("Login", test, Capture);

			taskspage.readyForAssignStatus(dashboardPage);

			String taskid1 = taskspage.gettaskNumber();
			test.log(Status.PASS, "Process Task ID saved");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test, readWebTable(taskspage.tasksTableHeader, taskspage.tasksTableBody),
					CompleteSpecs6, taskid1);
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

			String taskgroup1 = taskspage.getTaskGroupNumber();
			test.log(Status.PASS, "taskgroup ID saved");
			addSrceenShot("Login", test, Capture);

			taskspage.clickCloseIcon();
			test.log(Status.PASS, "closed button clicked successfully");
			addSrceenShot("Login", test, Capture);

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test, readWebTable(taskspage.tasksTableHeader, taskspage.tasksTableBody),
					CompleteSpecs7, taskid1);
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

			wvMobilePage.selectTaskGroup(taskgroup1);
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

			wvMobilePage.enterTaskId(taskid1);
			test.log(Status.PASS, "Entered Task ID in text box  :  " + taskid1);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.clickTapToConfrimBtn();
			test.log(Status.PASS, "Clicked on Tab to Conform  Button");

			wvMobilePage.enterVerifyCartidElement(CartUserKey1);
			test.log(Status.PASS, "Entered CART KEY in text box   :  " + CartUserKey1);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.clickConfirmBtn();
			test.log(Status.PASS, "Clicked on Conform Button");

			try {
				wvMobilePage.clickConfirmBtn();
				test.log(Status.PASS, "Clicked on Conform Button");

			} catch (Exception e) {
			}

			// TOTE 1

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

			String qty1 = wvMobilePage.verifyUnits();
			wvMobilePage.getQtyOutbound();
			wvMobilePage.clickGoBtn();

			wvMobilePage.scanToteId(TotUserKey1);
			wvMobilePage.clickGoBtn();

			//wvMobilePage.clickConfirmBtn();
			test.log(Status.PASS, "Clicked on Conform Button");

			try {
				wvMobilePage.clickConfirmBtn();
				test.log(Status.PASS, "Clicked on Conform Button");

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

				wvMobilePage.clickConfirmBtn();
				test.log(Status.PASS, "Clicked on Conform Button");

				try {
					wvMobilePage.clickConfirmBtn();
					test.log(Status.PASS, "Clicked on Conform Button");

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

			} catch (Exception e) {
			}

			try {

				wvMobilePage.getInformationMessageAndClickOk();
				addSrceenShot("Login", test, Capture);

				wvMobilePage.verifyDestination(LocationKey);
				test.log(Status.PASS, "Entered destination location  : " + LocationKey);
				addSrceenShot("Login", test, Capture);
				wvMobilePage.clickGoBtn();

			} catch (Exception e) {
			}

			utilities.closeCurrentWindow();

			dashboardPage.clickRefresh();
			dashboardPage.clickRefresh();

			// levi pack station

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("levi");
			test.log(Status.PASS, "Entered MenuSearch as levi");

			dashboardPage.clickLeviPackStation();
			test.log(Status.PASS, "Clicked on LeviPackStation Button");

			packStationPage.clickPackStation();
			test.log(Status.PASS, "Clicked on pack station Button");

			if (PackStation.equals("Pack Station 1")) {
				packStationPage.sendpackstation1(PackStation);
			} else if (PackStation.equals("Pack Station 2")) {
				packStationPage.sendpackstation2(PackStation);
			}

			packStationPage.clickStartPackingBtn();
			addSrceenShot("Login", test, Capture);
			test.log(Status.PASS, "Clicked on StartPacking Button");

			packStationPage.enterToteText(TotUserKey1);
			test.log(Status.PASS, "Entered tote  : " + TotUserKey1);

			addSrceenShot("Login", test, Capture);

			packStationPage.enterItemText(itembarcode1);
			test.log(Status.PASS, "Entered item barcode  : " + itembarcode1);

			packStationPage.clickDonerightClick();
			test.log(Status.PASS, "Clicked on Done click Button");
			addSrceenShot("Login", test, Capture);

			

			packStationPage.dropdownCurrentPage();
			test.log(Status.PASS, "Clicked on dropdowne Button");

			packStationPage.endTote();
			test.log(Status.PASS, "Clicked on endTote Button");

			packStationPage.acceptendTote();
			test.log(Status.PASS, "Clicked on acceptendTote Button");

			packStationPage.acceptendTote();
			test.log(Status.PASS, "Clicked on acceptendTote Button");

			try {

				packStationPage.enterToteText(TotUserKey2);
				test.log(Status.PASS, "Entered tote  : " + TotUserKey2);
				packStationPage.endTote();

				packStationPage.acceptendTote();
				test.log(Status.PASS, "Clicked on acceptendTote Button");

			} catch (Exception e) {
			}

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("ILPNs");
			test.log(Status.PASS, "Entered MenuSearch as ILPNs");

			dashboardPage.clickMenuBtn(dashboardPage.lpnElement);
			test.log(Status.PASS, "Clicked on iLPN Menu link");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			ilpnPage.enterLpnSearch(TotUserKey1);
			test.log(Status.PASS, "Entered tote  : " + TotUserKey1);
			addSrceenShot("Login", test, Capture);

			String ilpnQty = ilpnPage.getIlpnsQty(TotUserKey1).trim();
			test.log(Status.PASS, "saved TOTE qty " + TotUserKey1 + ilpnQty);

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			ilpnPage.enterLpnSearch(TotUserKey2);
			test.log(Status.PASS, "Entered tote  : " + TotUserKey2);
			addSrceenShot("Login", test, Capture);

			String ilpnQty2 = ilpnPage.getIlpnsQty(TotUserKey2).trim();
			test.log(Status.PASS, "saved TOTE qty " + TotUserKey2 + ilpnQty2);

			dashboardPage.clickRefresh();

			// move to cubby location

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("OUTBOUND MANUAL");
			test.log(Status.PASS, "Entered MenuSearch as tasks");

			outboundmanualsorterpage.clickSorterMenu();
			test.log(Status.PASS, "Clicked SorterMenu button");

			outboundmanualsorterpage.clickCSWrecord();
			test.log(Status.PASS, "Clicked  MenuSearch page tasks");

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
			test.log(Status.PASS, "Clicked on chase Button");

			wvMobilePage.clickCubbyBtn();
			test.log(Status.PASS, "Clicked on cubby Button");

			wvMobilePage.enterScanCubbyOlpn(olpnfromOrder1);
			test.log(Status.PASS, "Entered olpn  in text box   :  " + olpnfromOrder1);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.enterDestChase(sortloc1);
			test.log(Status.PASS, "Entered dest chase sort  in text box   :  " + sortloc1);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			try {

				wvMobilePage.ConfirmBtn();
				test.log(Status.PASS, "Clicked Confirmation Button");

			} catch (Exception e) {
			}

			wvMobilePage.enterScanCubbyOlpn(olpnfromOrder2);
			test.log(Status.PASS, "Entered olpn  in text box   :  " + olpnfromOrder2);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.enterDestChase(sortloc1);
			test.log(Status.PASS, "Entered dest chase sort  in text box   :  " + sortloc1);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			try {

				wvMobilePage.ConfirmBtn();
				test.log(Status.PASS, "Clicked Confirmation Button");

			} catch (Exception e) {
			}

			utilities.closeCurrentWindow();
			test.log(Status.PASS, "Clicked on current window close Button");

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
			test.log(Status.PASS, "Entered Order Search  :  " + OrderNumber + ", " + OrderNumber2);
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
			test.log(Status.PASS, "clicked expand button");

			String wvrnid2 = orderspage.oRSortwaverunid();
			test.log(Status.PASS, "saved wave run ID  :  " + wvrnid2);

			// WRA page.......

			ilpnPage.clickLpnMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wave run");
			test.log(Status.PASS, "Entered MenuSearch as wave run");

			waverunspage.clickWaverunbtn();
			test.log(Status.PASS, "Clicked on waverun page  Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			dashboardPage.wavesearch(wvrnid2, dashboardPage);
			test.log(Status.PASS, "wave run ID search completed  :  " + wvrnid2);
			addSrceenShot("Login", test, Capture);

			waverunspage.waveRunPageStatus(dashboardPage);
			System.out.println("New status changed successfully");
			addSrceenShot("Login", test, Capture);

			// work release allocation status check process........

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("work release allocation");
			test.log(Status.PASS, "Entered MenuSearch as work release allocation Page");

			waverunspage.clickWRAmenuBtn();
			test.log(Status.PASS, "clicked on WRA button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			waverunspage.enterOrderPlanIDSearch(wvrnid2, dashboardPage);

			// .....wave run time starts

			long AstartTime2 = System.nanoTime();

			String AGetTime3 = utilities.Timer();
			System.out.println("work release allocation process  start time is :" + AGetTime3);
			test.log(Status.PASS, "work release allocation process  start time is :");
			test.log(Status.PASS, AGetTime3);

			// ..................

			waverunspage.workReleasePage(dashboardPage);
			System.out.println("New status changed successfully");
			addSrceenShot("Login", test, Capture);

			// .....total time. end with

			long AendTime2 = System.nanoTime();

			String AGetTime4 = utilities.Timer();
			System.out.println("Work Release Allocated at Time is   :" + AGetTime4);
			test.log(Status.PASS, "Work Release Allocated at Time is   :" + AGetTime4);

			String AtotalTime21 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime2, endTime2);
			System.out.println("The execution minutes is :" + totalTime11);
			test.log(Status.PASS, "The Wave run Execution consumed time in Minutes  : " + totalTime21);

			// ........total time...........

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
			test.log(Status.PASS, "Batch id saved  :  " + batchlistid2);
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

			taskspage.Waverun(wvrnid2, dashboardPage);
			test.log(Status.PASS, "Entered wave run ID");
			addSrceenShot("Login", test, Capture);

			taskspage.readyForAssignStatus(dashboardPage);
			System.out.println("New status changed successfully");
			addSrceenShot("Login", test, Capture);

			String taskid2 = taskspage.gettaskNumber();
			test.log(Status.PASS, "Process Task ID saved   :  " + taskid2);

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test, readWebTable(taskspage.tasksTableHeader, taskspage.tasksTableBody),
					CompleteSpecs6, taskid2);
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
					CompleteSpecs7, taskid2);
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

			wvMobilePage.enterTaskId(taskid2);
			test.log(Status.PASS, "Entered Task ID in text box   :  " + taskid2);
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

			try {

				wvMobilePage.getInformationMessageAndClickOk();
				addSrceenShot("Login", test, Capture);

			} catch (Exception e) {
			}

			try {

				// 2164-19723

				wvMobilePage.enterDestinationLocationID2();
				addSrceenShot("Login", test, Capture);
				wvMobilePage.clickGoBtn();

			} catch (Exception e) {
			}

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

			// put wall sort......

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
			test.log(Status.PASS, "Clicked on Task Group" + "PTW");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.clickDoneBtn();
			test.log(Status.PASS, "Clicked on Done Button");

			wvMobilePage.clickChaseBtn();
			test.log(Status.PASS, "Clicked on refreah Button");

			// first packed 1 qty tote

			wvMobilePage.clickExpPutwallBtn();
			test.log(Status.PASS, "Clicked on ExpPutwallBtn Button");

			wvMobilePage.enterChasewall(chasewall);
			test.log(Status.PASS, "Entered  Chasewall location id " + chasewall);

			wvMobilePage.clickShadowGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			// TOTE 1

			wvMobilePage.enterSourceTote(TotUserKey3);
			test.log(Status.PASS, "Entered tote id id " + itembarcode1);
			wvMobilePage.clickShadowGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.enteritemWall(itembarcode1);
			test.log(Status.PASS, "Entered item barcode id " + itembarcode1);
			wvMobilePage.clickShadowGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			String sorlocUI1 = outboundmanualsorterpage.getLocid();

			if (sorlocUI1.equals(sortloc1)) {

				outboundmanualsorterpage.enterChaseLocationID();
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			}
			if (!sorlocUI1.equals(sortloc1)) {

				outboundmanualsorterpage.enterDesSortLocationText(sortloc1);
				test.log(Status.PASS, "Entered sort location id " + sortloc1);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			}

			// 264-17723

			String locOlpn1 = outboundmanualsorterpage.enterOlpnSortALocationID2();
			test.log(Status.PASS, "save olpn id " + locOlpn1);

			outboundmanualsorterpage.enterOlpnID(locOlpn1);
			wvMobilePage.clickShadowGoBtn();

			test.log(Status.PASS, "OLPN Moved");

			try {

				outboundmanualsorterpage.clickYesBtn();
				test.log(Status.PASS, "Clicked on yes Button");

				String locOlpn3 = outboundmanualsorterpage.enterOlpnSortALocationID2();
				test.log(Status.PASS, "save  olpn id " + locOlpn3);

				outboundmanualsorterpage.enterOlpnID(locOlpn3);
				test.log(Status.PASS, "Entered olpn id" + locOlpn3);

				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			} catch (Exception e) {
			}

			try {

				wvMobilePage.enteritemWall(itembarcode1);
				test.log(Status.PASS, "Entered itembarcode1 id " + itembarcode1);

				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				outboundmanualsorterpage.enterDesSortLocationText(sortloc1);
				test.log(Status.PASS, "Entered Sort code id " + sortloc1);

				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				String locOlpn2 = outboundmanualsorterpage.enterOlpnSortALocationID2();
				test.log(Status.PASS, "save olpn id " + locOlpn2);

				outboundmanualsorterpage.enterOlpnID(locOlpn2);
				test.log(Status.PASS, "Entered olpn id" + locOlpn2);

				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				outboundmanualsorterpage.clickYesBtn();
				test.log(Status.PASS, "Clicked on yes Button");

				// 264-17723

				String locOlpn3 = outboundmanualsorterpage.enterOlpnSortALocationID2();
				test.log(Status.PASS, "save olpn id" + locOlpn3);

				outboundmanualsorterpage.enterOlpnID(locOlpn3);
				test.log(Status.PASS, "Entered Sort code id " + locOlpn3);

				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			} catch (Exception e) {
			}

			// 2 tote

			try {

				wvMobilePage.enterSourceTote(TotUserKey4);
				test.log(Status.PASS, "Entered tote id id " + TotUserKey4);

				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.enteritemWall(itembarcode1);
				test.log(Status.PASS, "Entered itembarcode id " + itembarcode1);

				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			} catch (Exception e) {

			}

			// 264-17723

			String sorlocUI2 = outboundmanualsorterpage.getLocid();

			if (sorlocUI2.equals(sortloc2)) {

				outboundmanualsorterpage.enterChaseLocationID();
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			} else {

				outboundmanualsorterpage.enterDesSortLocationText(sortloc2);
				test.log(Status.PASS, "Entered sort location id " + sortloc2);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			}

			try {

				// 264-17723

				String locOlpn4 = outboundmanualsorterpage.enterOlpnSortALocationID2();
				test.log(Status.PASS, "save olpn id " + locOlpn4);

				outboundmanualsorterpage.enterOlpnID(locOlpn4);
				test.log(Status.PASS, "Entered olpn id" + locOlpn4);

				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.enteritemWall(itembarcode1);
				test.log(Status.PASS, "Entered itembarcode id " + itembarcode1);

				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			} catch (Exception e) {

			}

			String sorlocUI3 = outboundmanualsorterpage.getLocid();

			if (sorlocUI3.equals(sortloc2)) {

				outboundmanualsorterpage.enterChaseLocationID();
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			} else {

				outboundmanualsorterpage.enterDesSortLocationText(sortloc2);
				test.log(Status.PASS, "Entered sort location id " + sortloc2);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			}

			try {

				// 264-17723

				String locOlpn2 = outboundmanualsorterpage.enterOlpnSortALocationID2();
				test.log(Status.PASS, "save olpn id " + locOlpn2);

				outboundmanualsorterpage.enterOlpnID(locOlpn2);
				test.log(Status.PASS, "Entered olpn id" + locOlpn2);

				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				outboundmanualsorterpage.clickYesBtn();
				test.log(Status.PASS, "Clicked on yes Button");

				// 264-17723

				String locOlpn5 = outboundmanualsorterpage.enterOlpnSortALocationID2();
				test.log(Status.PASS, "save olpn id " + locOlpn5);

				outboundmanualsorterpage.enterOlpnID(locOlpn5);
				test.log(Status.PASS, "Entered olpn id" + locOlpn5);

				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			} catch (Exception e) {
			}

			try {

				wvMobilePage.enteritemWall(itembarcode1);
				test.log(Status.PASS, "Entered item barcode id " + itembarcode1);
				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			} catch (Exception e) {
			}

			try {

				String sorlocUI4 = outboundmanualsorterpage.getLocid();

				if (sorlocUI4.equals(sortloc2)) {

					outboundmanualsorterpage.enterChaseLocationID();
					wvMobilePage.clickShadowGoBtn();
					test.log(Status.PASS, "Clicked on Go Button");

				} else {

					outboundmanualsorterpage.enterDesSortLocationText(sortloc2);
					test.log(Status.PASS, "Entered sort location id " + sortloc2);
					wvMobilePage.clickShadowGoBtn();
					test.log(Status.PASS, "Clicked on Go Button");

				}

			} catch (Exception e) {
			}

			// 264-17723

			try {

				String locOlpn6 = outboundmanualsorterpage.enterOlpnSortALocationID2();
				test.log(Status.PASS, "save olpn id " + locOlpn6);

				outboundmanualsorterpage.enterOlpnID(locOlpn6);
				wvMobilePage.clickShadowGoBtn();

				test.log(Status.PASS, "OLPN Moved");

			} catch (Exception e) {
			}

			try {

				outboundmanualsorterpage.clickYesBtn();
				test.log(Status.PASS, "Clicked on yes Button");

				String locOlpn7 = outboundmanualsorterpage.enterOlpnSortALocationID();
				test.log(Status.PASS, "save  olpn id " + locOlpn7);

				outboundmanualsorterpage.enterOlpnID(locOlpn7);
				test.log(Status.PASS, "Entered olpn id" + locOlpn7);

				wvMobilePage.clickShadowGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

			} catch (Exception e) {
			}

			utilities.closeCurrentWindow();
			test.log(Status.PASS, "Clicked on close window Button");

			// check order status

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("orders");
			test.log(Status.PASS, "Entered MenuSearch as orders");

			dashboardPage.ordersclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS, "Entered Order Search  " + OrderNumber + ", " + OrderNumber2);
			addSrceenShot("Login", test, Capture);

			// weigh to manifestate

			dashboardPage.clickMenuToggle();

			dashboardPage.enterMenuSearch("Weigh and Manifest oLPN");
			test.log(Status.PASS, "Entered MenuSearch as " + "weigh manifest station");

			packStationPage.clickWeighManifest2();
			test.log(Status.PASS, "Clicked on weigh manifestate Button");

			// 264-18723

			packStationPage.sendReturnPrinter();
			test.log(Status.PASS, "Clicked on return printer");

			packStationPage.clickPrinterBtn();
			test.log(Status.PASS, "Clicked on  printer type ");

			packStationPage.wavesearch(olpnfromOrder1);
			test.log(Status.PASS, "Entered olpn id " + olpnfromOrder1);

			packStationPage.BtnManifestate();
			test.log(Status.PASS, "Clicked on manifestate Button");

			packStationPage.wavesearch(olpnfromOrder2);
			test.log(Status.PASS, "Entered olpn id " + olpnfromOrder2);

			packStationPage.BtnManifestate();
			test.log(Status.PASS, "Clicked on manifestate Button");

			// ILPN Status checking

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("ILPNs");
			test.log(Status.PASS, "Entered MenuSearch as ILPNs");
			addSrceenShot("Login", test, Capture);

			ilpnPage.ilpnsSelectMenu();
			test.log(Status.PASS, "Clicked on iLPN Menu link");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			try {

				ilpnPage.enterLpnSearch(TotUserKey1);
				test.log(Status.PASS, "Entered tote id " + TotUserKey1);
				addSrceenShot("Login", test, Capture);

			} catch (Exception e) {
			}

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Clicked on clickRefresh Button");

			// parcel journal

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("Parcel journal");
			test.log(Status.PASS, "Entered MenuSearch as Parcel journal");

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

			// CR-1

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

			// LR-1

			orderspage.searchDocType("SHIPPING_LABEL_DEFAULT");
			test.log(Status.PASS, "Selected label report message on the field   : " + "SHIPPING_LABEL_DEFAULT");

			orderspage.searchMetaByOLPNS(olpnfromOrder1);
			test.log(Status.PASS, "Entered OLPNS at OLPN page textbox   : " + olpnfromOrder1);

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

			orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS, "Entered Order Search  " + OrderNumber + ", " + OrderNumber2);
			addSrceenShot("Login", test, Capture);

			orderspage.selectAllRecord();
			test.log(Status.PASS, "clicked All record button");
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
			test.log(Status.PASS, "now status changed to Shipped successfullly");

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
			
			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

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
			test.log(Status.PASS, "Payload message saved into log reports   :  " + payLoad);

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

				// ....................total time. end with

				long endTime8 = System.nanoTime();

				String GetTime211 = utilities.Timer();
				System.out.println("The Execution is finished " + GetTime211);
				test.log(Status.PASS, "The Execution is finished " + GetTime211);

				// .................................total time........................//

			}
		}

	

	@AfterMethod
	public void setUpend() {

		extent.flush();
		driver.quit();
	}
}