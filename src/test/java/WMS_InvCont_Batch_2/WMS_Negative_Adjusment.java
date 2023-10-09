package WMS_InvCont_Batch_2;

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

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;


@Test(enabled = true, groups = { "Inventory" })
public class WMS_Negative_Adjusment extends WMS_TestBase {

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
	boolean Capture=true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();

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
			locationinventorypage = new WMS_LocationInventoryPage(driver);
			systemmanagementpage = new WMS_SystemManagementPage(driver);
			setReport("B2_TC07_WMS_Negative_Adjusment");
		}
	}

	@Test(priority = 0, dataProvider = "Negative_Adjusment", dataProviderClass = DataProviders.class)

	public void cycleCountUserDirec(String TOTEID, String ITEMBAR) throws InterruptedException, AWTException {
try {
		if (!TOTEID.equals(" ")) {
			if (CloseBrowser) {
				test = extent.createTest(":::WMS_Negative_Adjusment:::");
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
			test.log(Status.PASS, "Window resize");

			addSrceenShot("Login", test, Capture);

			dashboardPage.clickMenuToggle();


			dashboardPage.enterMenuSearch("ILPNs");
			test.log(Status.PASS, "Entered MenuSearch as ILPNs");

			dashboardPage.clickMenuBtn(dashboardPage.lpnElement);
			test.log(Status.PASS, "Clicked on iLPN Menu link");



			lsnPage.enterLpnSearch(TOTEID);


			addSrceenShot("Login", test, Capture);

			String itemIDdetais = lsnPage.getitemIDIlpn();

			int qtyTote=lsnPage.getIlpnQty();


			addSrceenShot("Login", test, Capture);

			lsnPage.clickIlpnRecord();
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wm mobile");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			wvMobilePage.clickWmbtn();
			test.log(Status.PASS, "Clicked on waverun Button");


			addSrceenShot("Login", test, Capture);

			utilities.switchToWindows();

			wvMobilePage.clickInventoryIlpnBtn();
			test.log(Status.PASS, "Clicked on Inventory Management");

			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickLeviMotifyBtn();


			addSrceenShot("Login", test, Capture);

			wvMobilePage.enterIlpnTote(TOTEID);

			wvMobilePage.clickGoBtn();
			addSrceenShot("Login", test, Capture);

			int actualQty = wvMobilePage.reduceQty();

			wvMobilePage.enterQtyIlpn("1");


			wvMobilePage.clickGoBtn();

			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickReasonDropDown();

			wvMobilePage.clickEventCycleBtn();

			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			wvMobilePage.clickGoBtn();

			/*
			 * try {
			 * 
			 * wvMobilePage.clickGoBtn();
			 * 
			 * addSrceenShot("Login", test, Capture); } catch (Exception e) {
			 * addSrceenShot("Login", test, Capture);
			 * 
			 * }
			 */


			utilities.closeCurrentWindow();

			dashboardPage.clickRefresh();

			dashboardPage.clickRefresh();

			dashboardPage.clickMenuToggle();

			dashboardPage.enterMenuSearch("ILPNs");
			test.log(Status.PASS, "Entered MenuSearch as ILPNs");

			dashboardPage.clickMenuBtn(dashboardPage.lpnElement);
			test.log(Status.PASS, "Clicked on iLPN Menu link");

			lsnPage.enterLpnSearch(TOTEID);

			addSrceenShot("Login", test, Capture);

			lsnPage.bulkRfreshPage(dashboardPage);

			qtyTote=lsnPage.getIlpnQty();

			lsnPage.clickIlpnRecord();

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

			systemmanagementpage.enterTranlogToteIDSearch(itemIDdetais);

			addSrceenShot("Login", test, Capture);


			systemmanagementpage.bulkRfreshPage(dashboardPage);

			systemmanagementpage.enterTranlogToteIDSearch(itemIDdetais);

			systemmanagementpage.bulkRfreshPage(dashboardPage);

			utilities.toggleGridView(dashboardPage.GridViewButton);

			addSrceenShot("Login", test, Capture);

			systemmanagementpage.clickTranFirstRecordBtn();

			addSrceenShot("Login", test, Capture);

			systemmanagementpage.clickPayLoadBtn();

			addSrceenShot("Login", test, Capture);

			systemmanagementpage.clicklinebtn();

			addSrceenShot("Login", test, Capture);



			String payLoad=systemmanagementpage.getInnerTextMessage();

			System.out.println(payLoad);

			String qtyPayLoad = Integer.toString(actualQty - 1);

			if(payLoad.contains("\"Quantity\":\""+qtyPayLoad+"\"")) {
				test.log(Status.PASS, "Payload text contains \"Quantity\":\""+qtyPayLoad+"\"");
			}else {
				test.log(Status.INFO, "Payload text does not contain \"Quantity\":\""+qtyPayLoad+"\"");
			}

			if(payLoad.contains(TOTEID)) {
				test.log(Status.PASS, "Payload text contains " + TOTEID);
			}else {
				test.log(Status.INFO, "Payload text does not contain " + TOTEID);
			}




		}
}
catch (Exception e) {
	System.out.println("Test case failed due to application slowness"+ e);
	test.log(Status.FAIL, "Test case failed due to application slowness");
}

	}

	@AfterMethod
	public void setUpend() {
		//testactions.updateTestRailTestRunStatus("4897113", "pass", "Negative Adjusment", "Negative Adjusment is done");

		extent.flush();
		driver.quit();
	}
}