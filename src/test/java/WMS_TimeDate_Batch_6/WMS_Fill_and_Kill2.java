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
import com.WMS_ApplicationPages.WMS_RelatedLinksPage;
import com.WMS_ApplicationPages.WMS_SystemManagementPage;
import com.WMS_ApplicationPages.WMS_TasksPage;
import com.WMS_ApplicationPages.WMS_WVMobilePage;
import com.WMS_ApplicationPages.WMS_WaveRunsPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

public class WMS_Fill_and_Kill2 extends WMS_TestBase {

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
	WMS_RelatedLinksPage relatedlinkspage;
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
			systemmanagementpage = new WMS_SystemManagementPage(driver);
			relatedlinkspage = new WMS_RelatedLinksPage(driver);
			locationinventorypage = new WMS_LocationInventoryPage(driver);
			setReport("WMS_Fill_And_Kill_Wave");

		}
	}

	@Test(priority = 0, dataProvider = "Fill_And_Kill_Wave", dataProviderClass = DataProviders.class)

	public void orderAllocation(String OrderNumber, String OrderNumber2, String CompleteSpecs)
			throws InterruptedException, AWTException {

		if (!OrderNumber.equals(" ")) {
			if (CloseBrowser) {

				test = extent.createTest(":::WMS_Fill_And_Kill_Wave:::");

			}
			CloseBrowser = false;

			long startTime = System.nanoTime();
			System.out.println("Execution Start time is  : " + startTime);

			String GetTime = utilities.Timer();
			System.out.println("< WMS_Fill_And_Kill_Wave >" + "< Execution Start time :   > :" + GetTime);
			test.log(Status.PASS, "< WMS_Fill_And_Kill_Wave >" + "< Execution Start time :   > :" + GetTime);

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

			// orders page get details

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("orders");
			test.log(Status.PASS, "Entered MenuSearch as : " + "orders");

			dashboardPage.ordersclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Clear all selected texboxs and filters");

			orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2,dashboardPage);
			test.log(Status.PASS, "Entered Order Search at order text box : " + OrderNumber + ", " + OrderNumber2);
			addSrceenShot("Login", test, Capture);

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test, readWebTable(orderspage.OrderTableHeader, orderspage.orderTableBody),
					CompleteSpecs, OrderNumber);
			test.log(Status.INFO, "DO verification completed");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");
			addSrceenShot("Login", test, Capture);

			// orders Line Page page check orders status and details

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("orders");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			dashboardPage.ordersclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2,dashboardPage);
			test.log(Status.PASS, "Entered Order Search  :  " + OrderNumber + ", " + OrderNumber2);
			addSrceenShot("Login", test, Capture);

			dashboardPage.selectAllRecord();
			test.log(Status.PASS, "clicked on one record button");

			dashboardPage.clickRelatedLinks();
			test.log(Status.PASS, "clicked on Related Links button");
			addSrceenShot("Login", test, Capture);

			relatedlinkspage.clickOrdersLine();
			test.log(Status.PASS, "clicked on order line button");

			// 1 order in 1 tem order line qty

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			relatedlinkspage.OrdLinesearchOrd(OrderNumber);
			test.log(Status.PASS, "Entered Order Search  :  " + OrderNumber);
			addSrceenShot("Login", test, Capture);

			String itemfromOrder1 = relatedlinkspage.getitemNumber1();
			System.out.println("first item barcode is saved   :   " + itemfromOrder1);
			test.log(Status.PASS, "first item barcode is saved    :   " + itemfromOrder1);

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			relatedlinkspage.OrdLinesearchOrd(OrderNumber2);
			test.log(Status.PASS, "Entered Order Search  :  " + OrderNumber2);
			addSrceenShot("Login", test, Capture);

			String itemfromOrder2 = relatedlinkspage.getitemNumber2();
			System.out.println("first item barcode is saved   :  " + itemfromOrder2);
			test.log(Status.PASS, "Secound item barcode is saved   :  " + itemfromOrder2);

			

			// check status on orders bage

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("orders");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");
			addSrceenShot("Login", test, Capture);

			dashboardPage.ordersclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2,dashboardPage);
			test.log(Status.PASS, "Entered Order Search  :  " + OrderNumber + ", " + OrderNumber2);
			addSrceenShot("Login", test, Capture);

			orderspage.selectAllRecord();
			test.log(Status.PASS, "clicked on one record button");
			addSrceenShot("Login", test, Capture);

			try {

				orderspage.clickToolRunwaveBtn();
				test.log(Status.PASS, "clicked on run wave button");
				addSrceenShot("Login", test, Capture);

			} catch (Exception e) {

				orderspage.btnThreedots();
				test.log(Status.PASS, "clicked on one threeDots button");

				orderspage.clickRunwaveInsideDots();
				test.log(Status.PASS, "clicked runwave at inside Dots");
				addSrceenShot("Login", test, Capture);
				

			}

			orderspage.enterWaveStatergy("OPS - Standard Wave");
			test.log(Status.PASS, "Selected standard Wave staterg   :  " + "OPS - Standard Wave");
			addSrceenShot("Login", test, Capture);
			

			orderspage.confirmSummit();
			test.log(Status.PASS, "clicked on Summit button");
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");
			addSrceenShot("Login", test, Capture);

			// wave run page

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wave run");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");
			addSrceenShot("Login", test, Capture);

			waverunspage.clickWaverunpagebtn();
			test.log(Status.PASS, "Clicked on Order Button");

			String canWaveRunID = waverunspage.waverunidfromWRpage();
			test.log(Status.PASS, "Saved cancel wave run ID   :  " + canWaveRunID);

			waverunspage.enterWaveRunSearch(canWaveRunID);
			test.log(Status.PASS, "Enter wave run ID   :  " + canWaveRunID);
			addSrceenShot("Login", test, Capture);

			// location inventory

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("location inventory");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			locationinventorypage.clickLocationInventorybtn();
			test.log(Status.PASS, "Clicked on Location inventory Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			locationinventorypage.inventoryitemsearch(itemfromOrder1);
			test.log(Status.PASS, "Entered item Search  :  " + itemfromOrder1);
			addSrceenShot("Login", test, Capture);

			locationinventorypage.locSoragesearch("M-Z0*");
			test.log(Status.PASS, "Entered item Search  :  " + "M-Z0*");
			addSrceenShot("Login", test, Capture);

			dashboardPage.selectAlllocations();
			test.log(Status.PASS, "selected on all locations");

			try {

				orderspage.btnThreedots();
				test.log(Status.PASS, "clicked on one ThreeDots button");
				addSrceenShot("Login", test, Capture);

				locationinventorypage.insideRemoveCondbtn();
				test.log(Status.PASS, "Clicked on remove condition Button indide three dots");
				addSrceenShot("Login", test, Capture);
				
			} catch (Exception e) {

				locationinventorypage.clickRemoveCond();
				test.log(Status.PASS, "Clicked on remove condition Button");
				addSrceenShot("Login", test, Capture);

			}
			addSrceenShot("Login", test, Capture);

			locationinventorypage.clickInventoryCond();
			test.log(Status.PASS, "Clicked on inventory Condition");

			locationinventorypage.clickRemoveDamagedBtn();
			test.log(Status.PASS, "Clicked on damage Button");
			addSrceenShot("Login", test, Capture);

			locationinventorypage.clickSummitBtn();
			test.log(Status.PASS, "Clicked on demage Button");
			addSrceenShot("Login", test, Capture);

			locationinventorypage.acceptendTote();
			test.log(Status.PASS, "Clicked on Accep TOTE");
			addSrceenShot("Login", test, Capture);

			// check status on orders bage

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("orders");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");
			addSrceenShot("Login", test, Capture);

			dashboardPage.ordersclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			orderspage.enterOrdersSearch(OrderNumber + ", " + OrderNumber2,dashboardPage);
			test.log(Status.PASS, "Entered Order Search  :  " + OrderNumber + ", " + OrderNumber2);
			addSrceenShot("Login", test, Capture);

			orderspage.selectAllRecord();
			test.log(Status.PASS, "clicked on select all record button");
			addSrceenShot("Login", test, Capture);

			try {

				orderspage.clickToolRunwaveBtn();
				test.log(Status.PASS, "clicked on run wave button below menu bar");
				addSrceenShot("Login", test, Capture);

			} catch (Exception e) {

				orderspage.btnThreedots();
				test.log(Status.PASS, "clicked on one ThreeDots button");

				orderspage.clickRunwaveInsideDots();
				test.log(Status.PASS, "clicked runwave at inside three Dots button");
				addSrceenShot("Login", test, Capture);

			}

			orderspage.enterFillandKillWave("OPS - Fill or Kill");
			test.log(Status.PASS, "Selected standard Wave statergy   :  " + "OPS - Fill or Kill Ecomm Wave");
			addSrceenShot("Login", test, Capture);

			orderspage.confirmSummit();
			test.log(Status.PASS, "clicked on one summit button");

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			orderspage.enterOrdersSearch(OrderNumber2,dashboardPage);
			test.log(Status.PASS, "Entered Order Search   :  " + OrderNumber2);
			addSrceenShot("Login", test, Capture);

			orderspage.orderCancelStatus(dashboardPage);
			addSrceenShot("Login", test, Capture);

			// orders page check orders status and details

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			orderspage.enterOrdersSearch(OrderNumber2,dashboardPage);
			test.log(Status.PASS, "Entered Order Search   :  " + OrderNumber2);
			addSrceenShot("Login", test, Capture);

			orderspage.selectAllRecord();
			test.log(Status.PASS, "clicked on select all record button");

			orderspage.orderRelatedLinks();
			test.log(Status.PASS, "clicked on related links button");

			orderspage.clickOrderfailure();
			test.log(Status.PASS, "clicked on order failure");

			orderspage.expandFailureOrder(OrderNumber2);
			test.log(Status.PASS, "Expand failed Order  :  " + OrderNumber2);

			String ordFailone = orderspage.getTextOrdersFailureNo1();
			test.log(Status.PASS, "Wave failed Status from Order failure Error page :" + ordFailone);
			addSrceenShot("Login", test, Capture);

			// sysm mgmt

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("system management");
			test.log(Status.PASS, "Entered MenuSearch as system management");
			addSrceenShot("Login", test, Capture);

			systemmanagementpage.clickSystemMgmtBtn();
			test.log(Status.PASS, "Clicked on system management button");

			utilities.switchToWindows();

			// tranlog

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("tranlog details");
			test.log(Status.PASS, "Entered MenuSearch as ILPNs");
			addSrceenShot("Login", test, Capture);

			systemmanagementpage.clickTranlogDetailsBtn();
			test.log(Status.PASS, "Clicked on tranlog details Button from menu search");
			addSrceenShot("Login", test, Capture);

			systemmanagementpage.enterTranlogToteIDSearch(OrderNumber);
			test.log(Status.PASS, "Entered tranlogsearchbox as order  : " + OrderNumber);
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

			if (payLoad.contains(OrderNumber)) {
				test.log(Status.PASS, "Payload text contains " + OrderNumber);
			} else {
				test.log(Status.INFO, "Payload text does not contain " + OrderNumber);
			}

			if (payLoad.contains("Order is allocated with an inventory in WM")) {
				test.log(Status.PASS, "Payload text contains " + "Order is allocated with an inventory in WM");
			} else {
				test.log(Status.INFO, "Payload text does not contain " + "Order is allocated with an inventory in WM");
			}

			long endTime88 = System.nanoTime();

			String GetTime211 = utilities.Timer();
			System.out.println(" < Testcase execution completed  >  : " + " < WMS_Fill_and_Kill > "
					+ "Execution completed time :  " + GetTime211);
			test.log(Status.PASS, " < Testcase execution completed  >  : " + " < WMS_Fill_and_Kill > "
					+ "Execution completed time :  " + GetTime211);

		}

	}

	@AfterMethod
	public void setUpend() {

		extent.flush();
		driver.quit();
	}
}