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
public class WMS_Cancel_Order extends WMS_TestBase {

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
	boolean Capture=true;

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
			waverunspage = new WMS_WaveRunsPage(driver);
			batchlistpage = new WMS_BatchListPage(driver);
			taskspage = new WMS_TasksPage(driver);
			packStationPage = new WMS_PackStationPage(driver);
			systemmanagementpage = new WMS_SystemManagementPage(driver);
			setReport("WMS_Cancel_Order");

		}
	}

	@Test(priority = 0, dataProvider = "WMS_Cancel_Order", dataProviderClass = DataProviders.class)


	public void orderAllocation(String OrderNumber, String CompleteSpecs2,
			String CompleteSpecs3) throws InterruptedException, AWTException {
try {
	if (!OrderNumber.equals(" ")) {
			if (CloseBrowser) {

				test = extent.createTest(":::WMS_Cancel_Order:::");

			}

			CloseBrowser = false;

			// ...............................browser launched time starts

			long startTime = System.nanoTime();

			String GetTime = utilities.Timer();
			System.out.println("Browser Launched Time :" + GetTime);
			test.log(Status.PASS, "Browser Launched Time :" + GetTime);

			// ......................................................................................//

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

			// orders page check orders status and details

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.distbtn();
			test.log(Status.PASS, "Clicked on distribution Button");

			dashboardPage.clickorderMagmnt();
			test.log(Status.PASS, "Clicked on ordersmanagement Button");

			dashboardPage.ordersclick();
			test.log(Status.PASS, "Clicked on Order Button");
			
			addSrceenShot("Login", test, Capture);

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			orderspage.enterOrdersSearch(OrderNumber, dashboardPage);
			test.log(Status.PASS, "Entered Order Search");
			
			addSrceenShot("Login", test, Capture);

			verifyCompleteSpecifics(test, readWebTable(orderspage.OrderTableHeader, orderspage.orderTableBody),
					CompleteSpecs2, OrderNumber);
			test.log(Status.PASS, "DO verification completed");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			String itemiddetails = orderspage.getitemNumber();
			
			addSrceenShot("Login", test, Capture);

			orderspage.selectOrderrecord();
			test.log(Status.PASS, "clicked on one record button");
			
			addSrceenShot("Login", test, Capture);

			orderspage.btnThreedots();
			test.log(Status.PASS, "clicked on one threeDots button");

			orderspage.btnCancelOrders();
			
			addSrceenShot("Login", test, Capture);

			orderspage.clickreasonBtn("Customer Service Initiated");
			
			addSrceenShot("Login", test, Capture);

			orderspage.confirmSummit();
			test.log(Status.PASS, "clicked on one summit button");
			
			addSrceenShot("Login", test, Capture);

			orderspage.orderCancelStatus(dashboardPage);
			
			addSrceenShot("Login", test, Capture);

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test,
					readWebTable(orderspage.canlStatusElementHeader, orderspage.canlStatusElemenbody), CompleteSpecs3,
					OrderNumber);
			test.log(Status.PASS, "DO verification completed");

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("items");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			itemPage.clickitembutton();
			
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();

			itemPage.itemsearch(itemiddetails); // ItemNumber

			dashboardPage.clickRefresh();

			String itembarcode = itemPage.getitemparcode();
			
			addSrceenShot("Login", test, Capture);

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
			
			addSrceenShot("Login", test, Capture);

			systemmanagementpage.enterTranlogToteIDSearch(OrderNumber);
			
			addSrceenShot("Login", test, Capture);

			systemmanagementpage.bulkRfreshPage(dashboardPage);
			
			systemmanagementpage.enterTranlogToteIDSearch(OrderNumber);
			
			addSrceenShot("Login", test, Capture);
			
			systemmanagementpage.bulkRfreshPage(dashboardPage);
			
			systemmanagementpage.enterTranlogToteIDSearch(OrderNumber);

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

			if (payLoad.contains("Cancelled")) {
				test.log(Status.PASS, "Payload text contains " + OrderNumber);
			} else {
				test.log(Status.INFO, "Payload text does not contain " + OrderNumber);
			}
			CloseBrowser = true;
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
