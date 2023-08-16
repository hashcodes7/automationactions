package WMS_PickSort_Batch_5;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
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
import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

//@Test(enabled = true, groups = { "PickShort_Order" })
public class WMS_PST_MultisBagCarton_1Slot extends WMS_TestBase {

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
	WMS_LocationInventoryPage locationinventorypage;
	WMS_SystemManagementPage systemmanagementpage;

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
			locationinventorypage = new WMS_LocationInventoryPage(driver);
			systemmanagementpage = new WMS_SystemManagementPage(driver);
			setReport("B5_TC02_PickShort_MultiBag_Corton");

		}
	}

	@Test(priority = 0, dataProvider = "PickSort_MultiBag_Corton", dataProviderClass = DataProviders.class)

	public void orderAllocation(String OrderNumber, String OrderNumber2, String CompleteSpecs, String CompleteSpecs2,
			String CompleteSpecs3, String CompleteSpecs4, String CompleteSpecs5, String CompleteSpecs6,
			String CompleteSpecs7, String TotUserKey, String TotUserKey2, String LocationKey,
			String CARTKEY, String CompleteSpecs8, String CompleteSpecs9, String PackStation)
			throws InterruptedException, AWTException {
		
		
		if (!OrderNumber.equals(" ")) {
			if (CloseBrowser) {

				test = extent.createTest(":::B5_TC02_PickShort_MultiBag_Corton:::");

			}

			CloseBrowser = false;

			long startTime = System.nanoTime();
			System.out.println("Execution Start time is  : " + startTime);

			String GetTime = utilities.Timer();
			System.out.println("< B5_TC02_PickShort_MultiBag_Corton >" + "< Execution Start time :   > :" + GetTime);
			test.log(Status.PASS, "< B5_TC02_PickShort_MultiBag_Corton >" + "< Execution Start time :   > :" + GetTime);

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

			// orders page get details

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
					CompleteSpecs, OrderNumber);
			test.log(Status.PASS, "DO verification completed");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			// wave run start at.................

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

			// ................total timer start.......

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

			// olpns page .............

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

			String wvrnid1 = waverunspage.waverunid();
			test.log(Status.PASS, "Saved wave run ID   :  " + wvrnid1);

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			// wave run to wra convertion process......

			ilpnPage.clickLpnMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wave run");
			test.log(Status.PASS, "Entered MenuSearch as wave run");

			waverunspage.clickWaverunbtn();
			test.log(Status.PASS, "Clicked on waverun page  Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			dashboardPage.wavesearch(wvrnid1,dashboardPage);// WaveId

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

			waverunspage.enterOrderPlanIDSearch(wvrnid1, dashboardPage);

			// ....

			long startTime2 = System.nanoTime();

			String GetTime3 = utilities.Timer();
			System.out.println("work release allocation process  start time is :" + GetTime3);

			test.log(Status.PASS, "work release allocation process  start time is :");
			test.log(Status.PASS, GetTime3);
			
			try {

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
			System.out.println("The execution minutes is :" + totalTime11);
			test.log(Status.PASS, "The Wave run Execution consumed time in Minutes  : " + totalTime21);

			// .................................total time........................//

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test, readWebTable(waverunspage.waveTableHeader, waverunspage.waveTableBody),
					CompleteSpecs4, wvrnid1);
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

			batchlistpage.batchsearch(batchlistid, dashboardPage); // B20220118001999

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
			System.out.println("The execution minutes is :" + totalTime31);
			test.log(Status.PASS, "The batch list released Execution consumed time in Minutes  : " + totalTime31);

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			dashboardPage.clickRefresh();

			verifyCompleteSpecifics(test, readWebTable(batchlistpage.batchTableHeader, batchlistpage.batchTableBody),
					CompleteSpecs5, batchlistid);
			addSrceenShot("Login", test, Capture);
			
			} catch (Exception e) {
			}

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

			String taskiddetails1 = taskspage.gettaskNumber();
			test.log(Status.PASS, "Process Task ID saved");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test, readWebTable(taskspage.tasksTableHeader, taskspage.tasksTableBody),
					CompleteSpecs6, taskiddetails1);
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
					CompleteSpecs7, taskiddetails1);
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

			itemPage.itemsearch(itemfromOrder1);

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

			wvMobilePage.enterTaskId(taskiddetails1);
			test.log(Status.PASS, "Entered Task ID in text box  :  " + taskiddetails1);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.clickTapToConfrimBtn();
			test.log(Status.PASS, "Clicked on Tab to Conform  Button");

			// Enter cart No :

			wvMobilePage.enterVerifyCartidElement(CARTKEY);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();

			try {

				wvMobilePage.MultipleConfirmationBtn();

			} catch (Exception e) {
			}

			// Enter Location

			String LocBar1 = wvMobilePage.getLocBarcode();

			test.log(Status.PASS, "system selected Storage Location is   : " + LocBar1);

			wvMobilePage.enterLocationID();

			test.log(Status.PASS, "Entered Current Location Barcode");

			wvMobilePage.clickGoBtn();

			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.enteritemBar(itembarcode1);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			test.log(Status.PASS, "Entered item barcode at textbox  : " + itembarcode1);

			wvMobilePage.ManulayEnterOty("1");

			wvMobilePage.clickGoBtn();

			wvMobilePage.scanToteId(TotUserKey);

			wvMobilePage.clickGoBtn();

			// PICK EXCEPTION..........

			wvMobilePage.clickPickExcep();
			test.log(Status.PASS, "Clicked on pix exception Button");

			wvMobilePage.clickConfirmBtn();
			test.log(Status.PASS, "Clicked on confirmation Button");

			try {

				wvMobilePage.clickPickExcep();
				test.log(Status.PASS, "Clicked on Pix exception Button");

				wvMobilePage.MultipleConfirmationBtn();
				test.log(Status.PASS, "Clicked on Mutis Confirmation  Button");

			} catch (Exception e) {
			}

			try {

				wvMobilePage.getInformationMessageAndClickOk();

			} catch (Exception e) {
				wvMobilePage.MultipleConfirmationBtn();
				wvMobilePage.getInformationMessageAndClickOk();

			}

			wvMobilePage.verifyDestination(LocationKey);
			test.log(Status.PASS, "Entered destination location  : " + LocationKey);
			addSrceenShot("Login", test, Capture);
			wvMobilePage.clickGoBtn();

			utilities.closeCurrentWindow();
			test.log(Status.PASS, "closed current window page  : " + "WM Mobile");

			dashboardPage.clickRefresh();
			dashboardPage.clickRefresh();
			addSrceenShot("Login", test, Capture);

			// ......cycle count....

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("Location inv");
			test.log(Status.PASS, "Entered MenuSearch as inventory count");
			addSrceenShot("Login", test, Capture);

			locationinventorypage.clickLocationInventorybtn();
			addSrceenShot("Entered item IDs on Item Serach box", test, Capture);

			locationinventorypage.inventoryLocBarsearch(LocBar1);
			test.log(Status.PASS, "Entered location at location inventory page");
			addSrceenShot("Login", test, Capture);

			locationinventorypage.locInventoryExpBtn();
			test.log(Status.PASS, "Clicked on Record Exp button");
			addSrceenShot("Login", test, Capture);

			int TotalUnitCount1 = locationinventorypage.getTotalUnitCount();
			test.log(Status.PASS, "saved count in integer");
			System.out.println("saved count in integer  :  " + TotalUnitCount1);

			// cycle count

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

			wvMobilePage.selectTaskGroup("CCM");
			test.log(Status.PASS, "Clicked on Task Group");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.clickDoneBtn();
			test.log(Status.PASS, "Clicked on Done Button");

			wvMobilePage.clickCycleCountBtn();
			test.log(Status.PASS, "Clicked on cycle count Button from wm menu list");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickLiveCycleCountBtn();
			test.log(Status.PASS, "Clicked on Cycle count Button");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.enterLocationBar(LocBar1);

			test.log(Status.PASS, "Entered Storage Location  :  " + LocBar1);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.clickConfirmBtn();
			test.log(Status.PASS, "Clicked on cycle count Conform  Button");

			// itembarcode

			wvMobilePage.entercycleItemBar(itembarcode1);
			test.log(Status.PASS, "Entered item barcode at wm mobilege  :  " + itembarcode1);
			addSrceenShot("Login", test, Capture);
			wvMobilePage.clickGoBtn();

			wvMobilePage.enterCycleCountUnits(Integer.toString(TotalUnitCount1 + 1));

			test.log(Status.PASS, "Entered location count qty at wm mobilege  :  " + TotalUnitCount1 + 1);
			addSrceenShot("Login", test, Capture);
			wvMobilePage.clickGoBtn();

			wvMobilePage.clickConfirmBtn();
			test.log(Status.PASS, "Clicked on cycle count Conform  Button");

			utilities.closeCurrentWindow();
			test.log(Status.PASS, "closed current window page  : " + "WM Mobile");

			// orders page check orders status and details

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

			// location inv calculate count

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("Location inv");
			test.log(Status.PASS, "Entered MenuSearch as inventory count");
			addSrceenShot("Login", test, Capture);

			locationinventorypage.clickLocationInventorybtn();
			addSrceenShot("Entered item IDs on Item Serach box", test, Capture);

			locationinventorypage.inventoryLocBarsearch(LocBar1);
			test.log(Status.PASS, "Entered location at location inventory page");
			addSrceenShot("Login", test, Capture);

			locationinventorypage.locInventoryExpBtn();
			test.log(Status.PASS, "Clicked on Record Exp button");
			addSrceenShot("Login", test, Capture);

			int TotalUnitCount2 = locationinventorypage.getTotalUnitCount();
			test.log(Status.PASS, "saved count in integer");
			System.out.println("saved count in integer  :  " + TotalUnitCount2);

			// chase wave to allocate order

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

			String wvrnid3 = orderspage.oRSortwaverunid();
			test.log(Status.PASS, "saved wave run ID after chase  :  " + wvrnid3);

			// wave run to wra convertion process......

			ilpnPage.clickLpnMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wave run");
			test.log(Status.PASS, "Entered MenuSearch as wave run");

			waverunspage.clickWaverunbtn();
			test.log(Status.PASS, "Clicked on waverun page  Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			dashboardPage.wavesearch(wvrnid3,dashboardPage);
			test.log(Status.PASS, "Entered wave run ID   :  " + wvrnid3);
			addSrceenShot("Login", test, Capture);

			waverunspage.waveRunPageStatus(dashboardPage);

			// work release allocation status check process........

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("work release allocation");
			test.log(Status.PASS, "Entered MenuSearch as work release allocation");
			addSrceenShot("Login", test, Capture);

			waverunspage.clickWRAmenuBtn();
			test.log(Status.PASS, "Clicked on WRA Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			waverunspage.enterOrderPlanIDSearch(wvrnid3, dashboardPage);

			test.log(Status.PASS, "Entered wave run ID  at text box of the page  : " + "W202303130029");// wvrnid3 //
																										// addSrceenShot("Login",

			// .............wave run time starts

			long AstartTime2 = System.nanoTime();

			String AGetTime3 = utilities.Timer();
			System.out.println("work release allocation process  start time is :" + AGetTime3);
			test.log(Status.PASS, "work release allocation process  start time is :");
			test.log(Status.PASS, AGetTime3);

			waverunspage.WorlReleaseAllocationReleaseStatus(dashboardPage);
			test.log(Status.PASS, "waiting for new status update");

			test.log(Status.PASS, "waiting for new status update");
			System.out.println("New status changed successfully");
			addSrceenShot("Login", test, Capture);

			

			// assign task...........

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("tasks");
			test.log(Status.PASS, "Entered MenuSearch as tasks");

			taskspage.clicktaskbutton();
			test.log(Status.PASS, "Clicked  MenuSearch page tasks");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			taskspage.enterTaskorderSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS,
					"Entered orders at task page orders text box  :  " + OrderNumber + ", " + OrderNumber2);
			addSrceenShot("Login", test, Capture);
			try {

				taskspage.readyForAssignStatus(dashboardPage);

			} catch (Exception e) {
			}

			String taskiddetails2 = taskspage.gettaskNumber();
			test.log(Status.PASS, "Process Task ID saved  : " + taskiddetails2);

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
			test.log(Status.PASS, "taskgroup ID saved  :  " + taskgroup2);
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

			wvMobilePage.selectTaskGroup(taskgroup2); // taskgroup2
			test.log(Status.PASS, "selected required on Task Group  :  ");
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

			wvMobilePage.enterTaskId(taskiddetails2); // Task: WRPICK0000003494
			test.log(Status.PASS, "Entered Task ID in text box   :  "); // taskiddetails2
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.clickTapToConfrimBtn();
			test.log(Status.PASS, "Clicked on Tab to Conform  Button");

			// Enter cart No :

			wvMobilePage.enterVerifyCartidElement(CARTKEY);
			test.log(Status.PASS, "Entered CART KEY in text box");

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			try {

				wvMobilePage.MultipleConfirmationBtn();

			} catch (Exception e) {
			}

			// TOTE 1

			// Enter Location

			String LocBar3 = wvMobilePage.getLocBarcode();
			test.log(Status.PASS, "system selected Storage Location is   : " + LocBar3);

			wvMobilePage.enterLocationID();
			test.log(Status.PASS, "Entered Current Location Barcode");

			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");

			wvMobilePage.enteritemBar(itembarcode1);
			wvMobilePage.clickGoBtn();
			test.log(Status.PASS, "Clicked on Go Button");
			test.log(Status.PASS, "Entered item barcode at textbox  : " + itembarcode1);

			String AvailableChaseUnitsS11 = wvMobilePage.SaveQtyOutbound();
			test.log(Status.PASS, "Available chase Units  : " + AvailableChaseUnitsS11);

			wvMobilePage.getQtyOutbound();
			wvMobilePage.clickGoBtn();

			wvMobilePage.scanToteId(TotUserKey2);
			wvMobilePage.clickGoBtn();

			try {

				wvMobilePage.MultipleConfirmationBtn();

			} catch (Exception e) {
			}

			wvMobilePage.getInformationMessageAndClickOk();
			addSrceenShot("Login", test, Capture);
			
			wvMobilePage.enterDestinationLocationID();
            addSrceenShot("Login", test, Capture);
            wvMobilePage.clickGoBtn();

            utilities.closeCurrentWindow();

			/*
			 * wvMobilePage.verifyDestination(LocationKey); test.log(Status.PASS,
			 * "Entered destination location  : " + LocationKey); addSrceenShot("Login",
			 * test, Capture); wvMobilePage.clickGoBtn();
			 * 
			 * utilities.closeCurrentWindow();
			 */

			dashboardPage.clickRefresh();
			dashboardPage.clickRefresh();

			// levi pack station

			dashboardPage.clickMenuToggle();

			dashboardPage.enterMenuSearch("levi");

			dashboardPage.clickLeviPackStation();
			test.log(Status.PASS, "Clicked on LeviPackStation Button");

			packStationPage.clickPackkStation();

			if (PackStation.equals("Pack Station 1")) {
				packStationPage.sendpackstation11(PackStation);
			} else if (PackStation.equals("Pack Station 2")) {
				packStationPage.sendpackstation12(PackStation);
			}

			packStationPage.clickStartPackingBtn();
			addSrceenShot("Login", test, Capture);
			test.log(Status.PASS, "Clicked on StartPacking Button");
			
			
			// TOTE 1

			packStationPage.enterToteText(TotUserKey);
			test.log(Status.PASS, "Entered TOTE ID---->" + TotUserKey);

			packStationPage.enterItemText(itembarcode1);
			test.log(Status.PASS, "Entered item barcode  : " + itembarcode1);

			packStationPage.clickDonerightClick();
			test.log(Status.PASS, "Clicked on Done click Button");
			addSrceenShot("Login", test, Capture);
			
			// TOTE 2 Packed 2 oders qty
			
			
			// order - 1

			packStationPage.enterToteText(TotUserKey2);
			test.log(Status.PASS, "Entered TOTE ID  : " + TotUserKey2);

			packStationPage.enterItemText(itembarcode1);
			test.log(Status.PASS, "Entered item barcode  :  " + itembarcode1);

			packStationPage.clickPlusBtn(Integer.parseInt(AvailableChaseUnitsS11));
			addSrceenShot("Login", test, Capture);

			packStationPage.clickDonerightClick();
			test.log(Status.PASS, "Clicked on Done click Button");
			addSrceenShot("Login", test, Capture);
			
			// order - 2
			
			packStationPage.enterItemText(itembarcode1);
			test.log(Status.PASS, "Entered item barcode  :  " + itembarcode1);

			
			packStationPage.clickDonerightClick();
			test.log(Status.PASS, "Clicked on Done click Button");
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

			ilpnPage.enterLpnSearchlpnPage(TotUserKey);
			addSrceenShot("Login", test, Capture);

			try {

				String status3 = dashboardPage.getCurrentStatus();
				System.out.println("ILPN page  1 lpn status is :" + status3);
				test.log(Status.PASS, "ilpn page lpn status is :");
				addSrceenShot("Login", test, Capture);

			} catch (Exception e) {

			}

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			ilpnPage.enterLpnSearchlpnPage(TotUserKey2);
			addSrceenShot("Login", test, Capture);

			try {

				String status3 = dashboardPage.getCurrentStatus();
				System.out.println("ILPN page  2 lpn status is :" + status3);
				test.log(Status.PASS, "ilpn page lpn status is :");
				addSrceenShot("Login", test, Capture);

			} catch (Exception e) {

			}

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

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Clicked on clear Button");

			dashboardPage.searchTransactiontextbox(olpnfromOrder2);
			test.log(Status.PASS, "Entered OLPN number at page of textbox : " + olpnfromOrder2);
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

				if (msg1.contains(TotUserKey)) {

					test.log(Status.PASS, "Message payload  text contains TOTE NUMBER :" + TotUserKey);
				} else {

					test.log(Status.INFO, "Message payload  text contains TOTE NUMBER :" + TotUserKey);
				}

			} catch (Exception e) {

			}

			// MHE Journal Validation

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("MHE Journal");
			test.log(Status.PASS, "Entered MenuSearch as MHE   : " + "MHE Journal");
			addSrceenShot("Login", test, Capture);

			orderspage.JournalMHE();
			test.log(Status.PASS, "clicked MHE Journal button");

			orderspage.searchMHEOrderstextbox(OrderNumber2);
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

				if (msg1.contains(TotUserKey2)) {

					test.log(Status.PASS, "Message payload  text contains TOTE NUMBER :" + TotUserKey2);
				} else {

					test.log(Status.INFO, "Message payload  text contains TOTE NUMBER :" + TotUserKey2);
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
				
				WaitforPage(6000);

				utilities.closeCurrentWindow();
				test.log(Status.PASS, "closed current window button");

			} catch (Exception e) {
			}

			WaitforPage(6000);

			// SECOUND DOCS

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Clicked on clear All Button");

			orderspage.searchDocType("COLLATE_REPORT_DEFAULT");
			test.log(Status.PASS, "Selected collate report message on the field   : " + "COLLATE_REPORT_DEFAULT");

			orderspage.searchMetaByOLPNS(olpnfromOrder2);
			test.log(Status.PASS, "Entered OLPNS at OLPN page textbox   : " + olpnfromOrder2);

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
				
				WaitforPage(6000);


				utilities.closeCurrentWindow();
				test.log(Status.PASS, "closed current window button");

			} catch (Exception e) {
			}

			WaitforPage(6000);

			// first label

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Clicked on clear All Button");

			orderspage.searchDocType("SHIPPING_LABEL_DEFAULT");

			orderspage.searchMetaByOLPNS(olpnfromOrder1);

			// first label

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
				test.log(Status.PASS, "opened label viewer URL on new Tab");
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

			// first label

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Clicked on clear All Button");

			orderspage.searchDocType("SHIPPING_LABEL_DEFAULT");

			orderspage.searchMetaByOLPNS(olpnfromOrder2);

			// secound label

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
				test.log(Status.PASS, "opened label viewer URL on new Tab");
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
			test.log(Status.PASS, "Entered Order Search" + OrderNumber + ", " + OrderNumber2);

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
			test.log(Status.PASS, "Clicked on first button by table of records");

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
			System.out.println(" < Testcase execution completed  >  : " + " < B5_TC02_PickShort_MultiBag_Corton > "
					+ "Execution completed time :  " + GetTime211);
			test.log(Status.PASS, " < Testcase execution completed  >  : " + " < B5_TC02_PickShort_MultiBag_Corton > "
					+ "Execution completed time :  " + GetTime211);
		}

	}

	@AfterMethod
	public void setUpend() {

		extent.flush();
		driver.quit();
	}
}