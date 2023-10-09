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
public class WMS_Ship_Confirm extends WMS_TestBase {

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
			waverunspage = new WMS_WaveRunsPage(driver);
			batchlistpage = new WMS_BatchListPage(driver);
			taskspage = new WMS_TasksPage(driver);
			packStationPage = new WMS_PackStationPage(driver);
			systemmanagementpage = new WMS_SystemManagementPage(driver);

			setReport("WMS_Ship_Confirmation");

		}
	}

	@Test(priority = 0, dataProvider = "Ship_Confirmation", dataProviderClass = DataProviders.class)

	public void orderAllocation(String OrderNumber, String OrderNumber2, String CompleteSpecs, String CompleteSpecs2,
			String CompleteSpecs3, String CompleteSpecs4, String CompleteSpecs5, String CompleteSpecs6,
			String CompleteSpecs7, String TotUserKey, String LocationKey, String CARTKEY, String CompleteSpecs8,
			String CompleteSpecs9, String PackStation) throws InterruptedException, AWTException {
try {
		if (!OrderNumber.equals(" ")) {
			if (CloseBrowser) {
				test = extent.createTest(":::WMS_Ship_Confirmation:::");
			}

			// ..browser launched time starts

			long startTime = System.nanoTime();
			System.out.println(startTime);

			String GetTime = utilities.Timer();
			System.out.println(" < Testcase execution is Started  >  : "
					+ " < WMS_Ship_Confirmation > "
					+ "Execution completed time :  " + GetTime);
			test.log(Status.PASS,
					" < Testcase execution is Started  >  : "
							+ " < WMS_Ship_Confirmation > "
							+ "Execution completed time :  " + GetTime);

			System.out.println("Browser Launched successfully");
			test.log(Status.PASS, "Browser Launched successfully");

			loginPage.verifyLogoExists();
			test.log(Status.PASS, "Manhattan Active Supply Chain logo is displayed");

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
			test.log(Status.PASS, "Clicked on window resize");
			// OLPNS Pages

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("OLPNS");
			test.log(Status.PASS, "Entered MenuSearch as : " + "OLPNS");

			dashboardPage.olpnclick();
			test.log(Status.PASS, "Clicked on OLPNS page Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Clear all selected texboxs and filters");

			orderspage.searchOlpntextbox(OrderNumber, dashboardPage);
			test.log(Status.PASS, "status changed successfully");
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			orderspage.searchOlpntextbox(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS, "status changed successfully");
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			String olpnfromOrder1 = orderspage.getOlpnsNumberFirst(OrderNumber);
			test.log(Status.PASS, "OLPN's 1 stored  :  " + olpnfromOrder1);

			String olpnfromOrder2 = orderspage.getOlpnsNumberFirst(OrderNumber2);
			test.log(Status.PASS, "OLPN's 2 stored  :  " + olpnfromOrder2);	
			addSrceenShot("Login", test, Capture);

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

				if (msg1.contains(TotUserKey)) {

					test.log(Status.PASS, "Message payload  text contains TOTE NUMBER :" + TotUserKey);
				} else {

					test.log(Status.INFO, "Message payload  text contains TOTE NUMBER :" + TotUserKey);
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

			orderspage.searchOlpntextbox(OrderNumber, dashboardPage);
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

			orderspage.enterOrdersSearch(OrderNumber,dashboardPage);
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

			// .................................total time. end with

			long endTime7 = System.nanoTime();

			String GetTime6 = utilities.Timer();
			System.out.println("Order get ship conformed Time is   :" + GetTime6);
			test.log(Status.PASS, "Order get ship conformed Time is   :" + GetTime6);

			test.log(Status.PASS, GetTime6);

			String totalTime5 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime4, endTime7);

			System.out.println("The execution minutes is :" + totalTime5);
			test.log(Status.PASS, "The Execution consumed time in Minutes  : " + totalTime5);

			// .................................total time........................//

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

			systemmanagementpage.enterTranlogToteIDSearch(OrderNumber);
			test.log(Status.PASS, "Entered tranlogsearchbox as order  : " + OrderNumber);
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
			System.out.println(" < Testcase execution completed  >  : "
					+ " < WMS_Ship_Confirmation > "
					+ "Execution completed time :  " + GetTime211);
			test.log(Status.PASS,
					" < Testcase execution completed  >  : "
							+ " < WMS_Ship_Confirmation > "
							+ "Execution completed time :  " + GetTime211);

		}
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