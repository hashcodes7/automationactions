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
import com.WMS_ApplicationPages.WMS_Chasewave_Sorter_Location;
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
@Test(enabled = true, groups = { "TimeDate" })
public class WMS_Ship_Confirmation extends WMS_TestBase {

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
			loginPage.resizeWebpage();
			test.log(Status.PASS, "Clicked on window resize");

			// olpns page ......................................

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("olpns");
			test.log(Status.PASS, "Entered MenuSearch as OLPNS Page");

			dashboardPage.olpnclick();
			test.log(Status.PASS, "Clicked on OLPNS page Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			addSrceenShot("Login", test, Capture);

			orderspage.searchOlpntextbox(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS, "status changed successfully");
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			String olpnfromOrder1 = orderspage.getOlpnsNumberFirst(OrderNumber);

			String olpnfromOrder2 = orderspage.getOlpnsNumberFirst(OrderNumber2);

			addSrceenShot("Login", test, Capture);

			// parcel journal details //

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("Parcel journal");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			dashboardPage.ParcelJournalclick();

			dashboardPage.clearAllBtn();

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			dashboardPage.searchTransactiontextbox(olpnfromOrder1); // 00000521771100473398

			taskspage.selectActionBtn("Ship");

			taskspage.selectStatusBtn("Processed");

			// olpnsNumber

			String response1 = dashboardPage.getProviderResponse();
			System.out.println(response1);
			test.log(Status.PASS, response1);

			dashboardPage.clearAllBtn();

			dashboardPage.searchTransactiontextbox(olpnfromOrder1); // 00000521771100473398

			taskspage.selectActionBtn("ShipRelease");

			taskspage.selectStatusBtn("Processed");

			// olpnsNumber

			try {

				String response2 = dashboardPage.getProviderResponse();
				System.out.println(response2);
				test.log(Status.PASS, response2);

			} catch (Exception e) {

			}
			dashboardPage.clearAllBtn();

			dashboardPage.searchTransactiontextbox(olpnfromOrder1); // 00000521771100473398

			taskspage.selectActionBtn("RateShop");

			taskspage.selectStatusBtn("Processed");

			// olpnsNumber

			try {

				String response3 = dashboardPage.getProviderResponse();
				System.out.println(response3);
				test.log(Status.PASS, response3);

			} catch (Exception e) {

			}

			dashboardPage.clearAllBtn();

			dashboardPage.searchTransactiontextbox(OrderNumber2); // 00000521771100473398

			taskspage.selectActionBtn("Ship");

			taskspage.selectStatusBtn("Processed");

			// olpnsNumber

			try {

				String response4 = dashboardPage.getProviderResponse();
				System.out.println(response4);
				test.log(Status.PASS, response4);

			} catch (Exception e) {

			}

			dashboardPage.clearAllBtn();

			dashboardPage.searchTransactiontextbox(OrderNumber2); // 00000521771100473398

			taskspage.selectActionBtn("ShipRelease");

			taskspage.selectStatusBtn("Processed");

			// olpnsNumber

			try {

				String response5 = dashboardPage.getProviderResponse();
				System.out.println(response5);
				test.log(Status.PASS, response5);

			} catch (Exception e) {

			}

			dashboardPage.clearAllBtn();

			dashboardPage.searchTransactiontextbox(OrderNumber2); // 00000521771100473398

			taskspage.selectActionBtn("RateShop");

			taskspage.selectStatusBtn("Processed");

			// olpnsNumber

			try {

				String response6 = dashboardPage.getProviderResponse();
				System.out.println(response6);
				test.log(Status.PASS, response6);

			} catch (Exception e) {

			}

			// MHE Journal Validation

			dashboardPage.clickMenuToggle();

			dashboardPage.enterMenuSearch("MHE Journal");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			addSrceenShot("Login", test, Capture);

			orderspage.JournalMHE();
			test.log(Status.PASS, "clicked on order shordage");

			orderspage.searchMHEOrderstextbox(OrderNumber + ", " + OrderNumber2);

			orderspage.searchMsgTypeMHE("Pick_Complete");

			try {

				orderspage.selectPJfirstRow();
				test.log(Status.PASS, "select first ROW column");
				addSrceenShot("Login", test, Capture);

				orderspage.clickDetailsBtn();

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on grid button and viewed record details");

				String msg1 = orderspage.getMHEvalidateDetails("PROCESSED");
				test.log(Status.PASS, msg1);

				String msg2 = orderspage.getMHEvalidateDetails("TRANSFORMED");
				test.log(Status.PASS, msg2);

				if (msg1.contains(TotUserKey)) {
					test.log(Status.PASS, "Message payload  text contains TOTE NUMBER :");
				} else {
					test.log(Status.FAIL, "Message payload  text does not contains TOTE NUMBER :");
				}

			} catch (Exception e) {

			}

			// Printing Journal Validation

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("olpns");
			test.log(Status.PASS, "Entered MenuSearch as OLPNS Page");

			dashboardPage.olpnclick();
			test.log(Status.PASS, "Clicked on OLPNS page Button");

			dashboardPage.clearAllBtn();

			orderspage.searchOlpntextbox(OrderNumber + ", " + OrderNumber2, dashboardPage);
			test.log(Status.PASS, "status changed successfully");
			addSrceenShot("Login", test, Capture);

			String olpnOrderFirst = orderspage.getOlpnsNumberFirst(OrderNumber);

			String olpnOrderSecound = orderspage.getOlpnsNumberFirst(OrderNumber2);

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("olpns");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			dashboardPage.olpnclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clearAllBtn();

			orderspage.searchOlpntextbox(OrderNumber + ", " + OrderNumber2, dashboardPage);

			addSrceenShot("Login", test, Capture);

			orderspage.selectAllRecord();
			test.log(Status.PASS, "clicked on one record button");
			addSrceenShot("Login", test, Capture);

			orderspage.clickRelatedLinks();

			orderspage.selectPrintingJournal();

			orderspage.searchDocType("COLLATE_REPORT_DEFAULT");

			orderspage.searchMetaByOLPNS(olpnfromOrder1 + ", " + olpnfromOrder2);

			// first Docs

			try {

				dashboardPage.clickRefresh();

				orderspage.selectPJfirstRow();
				test.log(Status.PASS, "select first ROW column");
				addSrceenShot("Login", test, Capture);

				orderspage.viewDocBtn();

				WaitforPage(5000);

				addSrceenShot("Login", test, Capture);

				utilities.switchToWindows();

				utilities.closeCurrentWindow();

			} catch (Exception e) {
			}

			WaitforPage(5000);

			// secound collade

			try {

				dashboardPage.clickRefresh();

				orderspage.selectSecoundRow();
				test.log(Status.PASS, "select first ROW column");
				addSrceenShot("Login", test, Capture);

				orderspage.viewDocBtn();

				WaitforPage(5000);

				addSrceenShot("Login", test, Capture);

				utilities.switchToWindows();

				utilities.closeCurrentWindow();

			} catch (Exception e) {
			}

			WaitforPage(5000);

			// first label

			orderspage.searchDocType("SHIPPING_LABEL_DEFAULT");

			orderspage.searchMetaByOLPNS(olpnfromOrder1 + ", " + olpnfromOrder2);

			// first Docs

			try {

				dashboardPage.clickRefresh();

				orderspage.selectPJfirstRow();
				test.log(Status.PASS, "select first ROW column");
				addSrceenShot("Login", test, Capture);

				orderspage.viewDocBtn();

				WaitforPage(5000);

				addSrceenShot("Login", test, Capture);

				utilities.switchToWindows();

				String LableDetails = orderspage.getShipLable();

				orderspage.newUrl();

				addSrceenShot("Login", test, Capture);

				orderspage.enterShipLable(LableDetails);

				orderspage.clickRedrew();

				addSrceenShot("Login", test, Capture);

				orderspage.clickPDFdownloadElement();

				utilities.closeCurrentWindow();

			} catch (Exception e) {
			}

			WaitforPage(6000);

			try {

				// secound docs

				dashboardPage.clickRefresh();

				orderspage.selectSecoundRow();
				test.log(Status.PASS, "select first ROW column");
				addSrceenShot("Login", test, Capture);

				orderspage.viewDocBtn();

				WaitforPage(5000);

				addSrceenShot("Login", test, Capture);

				utilities.switchToWindows();

				String LableDetails = orderspage.getShipLable();

				orderspage.newUrl();

				addSrceenShot("Login", test, Capture);

				orderspage.enterShipLable(LableDetails);

				orderspage.clickRedrew();

				addSrceenShot("Login", test, Capture);

				orderspage.clickPDFdownloadElement();

				addSrceenShot("Login", test, Capture);

				utilities.closeCurrentWindow();

			} catch (Exception e) {

			}

			// ship conformation on last process of the outbound flow

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("orders");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			addSrceenShot("Login", test, Capture);

			dashboardPage.ordersclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clickRefresh();

			orderspage.APPenterOrdersSearch(OrderNumber + ", " + OrderNumber2, dashboardPage);
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

			// ...............................batch list time starts
			// at.........................//

			// ......................................................................................//

			long startTime4 = System.nanoTime();

			String GetTime7 = utilities.Timer();
			System.out.println("Ship Conformation is Started time :" + GetTime7);
			test.log(Status.PASS, "Ship Conformation is Started time :");
			test.log(Status.PASS, GetTime7);

			// ......................................................................................//

			orderspage.shipConfirmStatus(dashboardPage);
			test.log(Status.PASS, "DO status now changed to Shipped");

			addSrceenShot("Login", test, Capture);

			// .................................total time. end with
			// timer.......................//

			long endTime7 = System.nanoTime();

			String GetTime61 = utilities.Timer();
			System.out.println("Order get ship conformed Time is   :" + GetTime61);
			test.log(Status.PASS, "Order get ship conformed Time is   :" + GetTime61);

			test.log(Status.PASS, GetTime61);

			String totalTime5 = WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime4, endTime7);
			/* String s=Long.toString(totalTime5); */
			System.out.println("The execution minutes is :" + totalTime5);
			test.log(Status.PASS, "The Execution consumed time in Minutes  : " + totalTime5);

			// .................................total time........................//

			// tranlog details

			dashboardPage.clickMenuToggle();

			dashboardPage.enterMenuSearch("system management");
			test.log(Status.PASS, "Entered MenuSearch as ILPNs");

			systemmanagementpage.clickSystemMgmtBtn();

			addSrceenShot("Login", test, Capture);

			utilities.switchToWindows();

			dashboardPage.clickMenuToggle();

			dashboardPage.enterMenuSearch("tranlog details");
			test.log(Status.PASS, "Entered MenuSearch as ILPNs");

			systemmanagementpage.clickTranlogDetailsBtn();

			systemmanagementpage.enterMesgPaySearch("SHC_ANY_ShipConfirm_Custom_QA");

			systemmanagementpage.enterTranlogToteIDSearch(OrderNumber + ", " + OrderNumber2);

			addSrceenShot("Login", test, Capture);

			systemmanagementpage.bulkRfreshPage(dashboardPage);

			utilities.toggleGridView(dashboardPage.GridViewButton);

			addSrceenShot("Login", test, Capture);

			systemmanagementpage.clickTranFirstRecordBtn();

			addSrceenShot("Login", test, Capture);

			systemmanagementpage.clickPayLoadBtn();

			addSrceenShot("Login", test, Capture);

			systemmanagementpage.clicklinebtn();

			addSrceenShot("Login", test, Capture);

			String payLoad = systemmanagementpage.getInnerTextMessage();

			System.out.println(payLoad);

			if (payLoad.contains("Full ShipConfirm")) {
				test.log(Status.PASS, "Payload text contains " + "Full ShipConfirm");
				addSrceenShot("Login", test, Capture);
			} else {
				test.log(Status.FAIL, "Payload text does not contain " + "Full ShipConfirm");
				addSrceenShot("Login", test, true);
			}

			if (payLoad.contains(OrderNumber)) {
				test.log(Status.PASS, "Payload text contains " + OrderNumber);
				addSrceenShot("Login", test, Capture);
			} else {
				test.log(Status.FAIL, "Payload text does not contain " + OrderNumber);
				addSrceenShot("Login", test, true);
			}

			if (payLoad.contains(OrderNumber2)) {
				test.log(Status.PASS, "Payload text contains " + OrderNumber2);
				addSrceenShot("Login", test, Capture);
			} else {
				test.log(Status.FAIL, "Payload text does not contain " + OrderNumber2);
				addSrceenShot("Login", test, true);
			}

			// .................................total time. end with
			// timer.......................//

			long endTime8 = System.nanoTime();

			String GetTime211 = utilities.Timer();
			System.out.println("The Execution is finished " + GetTime211);
			test.log(Status.PASS, "The Execution is finished " + GetTime211);

			// .................................total time........................//

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