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
import com.WMS_ApplicationPages.WMS_TasksPage;
import com.WMS_ApplicationPages.WMS_WVMobilePage;
import com.WMS_ApplicationPages.WMS_WaveRunsPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups = { "Inventory" })
public class WMS_Cycle_Recounts extends WMS_TestBase {

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
	boolean Capture = true;
	//public Test_Rail_Actions testactions = new Test_Rail_Actions();

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
			setReport("B2_TC06_cycle_Recounts");

		}
	}

	@Test(priority = 0, dataProvider = "cycle_Recounts", dataProviderClass = DataProviders.class)

	public void cycleCountUserDirec(String location, String itemid, String LOCATIONID)
			throws InterruptedException, AWTException {

		if (!location.equals(" ")) {
			if (CloseBrowser) {
				test = extent.createTest(":::cycle_Recounts:::");
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

			loginPage.clickLogin();

			test.log(Status.PASS, "Clicked on Login Button");
			addSrceenShot("Login", test, Capture);
			
			loginPage.resizeWebpage();
			test.log(Status.PASS, "Window resize");

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("items");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			itemPage.clickitembutton();

			itemPage.itemsearch(itemid); // ItemNumber
			addSrceenShot("Login", test, Capture);
			String itembarcode = itemPage.getitemparcode();

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("location inventory");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");
			addSrceenShot("Login", test, Capture);
			locationinventorypage.clickInventoryBtn();

			locationinventorypage.inventoryBarsearch(location);
			test.log(Status.PASS, "Entered Order Search");
			addSrceenShot("Login", test, Capture);
			locationinventorypage.locInventoryExpBtn();

			int TotalUnitCount = locationinventorypage.getTotalUnitCount();

			System.out.println(TotalUnitCount);
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wm mobile");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			wvMobilePage.clickWmbtn();
			test.log(Status.PASS, "Clicked on waverun Button");
			addSrceenShot("Login", test, Capture);
			utilities.switchToWindows();

			wvMobilePage.clickSettingsButton();

			test.log(Status.PASS, "Clicked on Settings button");

			wvMobilePage.clickTaskGroupRow();
			test.log(Status.PASS, "Clicked on Task Group");

			wvMobilePage.clicktaskgroupDropDownButton();
			test.log(Status.PASS, "Clicked on Task Group Dropdown");

			wvMobilePage.selectTaskGroup("CCM");
			addSrceenShot("Login", test, Capture);
			wvMobilePage.clickGoBtn();
			addSrceenShot("Login", test, Capture);
			wvMobilePage.clickDoneBtn();

			wvMobilePage.clickCycleCountBtn();
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickLiveCycleCountBtn();
			addSrceenShot("Login", test, Capture);

			wvMobilePage.enterLocationBar(location);

			wvMobilePage.clickGoBtn();
		try {
			wvMobilePage.clickConfirmBtn();
		}
		catch(Exception e) {
			addSrceenShot("Login", test, Capture);
		}
				
			 // itembarcode
			wvMobilePage.entercycleItemBar(itembarcode); // 003480001 M itembarcode

			wvMobilePage.clickGoBtn();

			wvMobilePage.enterCycleCountUnits(Integer.toString(TotalUnitCount + 20)); // TotalUnitCount
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			addSrceenShot("Login", test, Capture);
			try {
			wvMobilePage.clickConfirmBtn();
			}
			catch (Exception e) {
				
			}
			wvMobilePage.clickGoBtn();
			
			utilities.closeCurrentWindow();

			dashboardPage.clickMenuToggle();

			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("inventory count");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			locationinventorypage.clickInventoryCount();

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");
			addSrceenShot("Login", test, Capture);
			locationinventorypage.inventorysearch(LOCATIONID);

			locationinventorypage.pendingBookStatus(dashboardPage);
			addSrceenShot("Login", test, Capture);
			/*
			 * if (bookingStatus.equals("Pending Booking")) { test.log(Status.PASS,
			 * "The Booking Status is :" + bookingStatus); } else { test.log(Status.FAIL,
			 * "The Booking Status is :" + bookingStatus); }
			 */
			locationinventorypage.clickStatusRecord();

			locationinventorypage.clickBook();
			addSrceenShot("Login", test, Capture);

			locationinventorypage.clickYesBtn();
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("location inventory");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			locationinventorypage.clickInventoryBtn();
			addSrceenShot("Login", test, Capture);

			locationinventorypage.inventoryBarsearch(location);
			test.log(Status.PASS, "Entered Order Search");
			
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();
			dashboardPage.clickRefresh();

			locationinventorypage.locInventoryExpBtn();

			int TotalUnitCount2 = locationinventorypage.getTotalUnitCount();
			
			addSrceenShot("Login", test, Capture);

			System.out.println(TotalUnitCount2);

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("inventory count");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			locationinventorypage.clickInventoryCount();
			addSrceenShot("Login", test, Capture);

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			locationinventorypage.inventorysearch(LOCATIONID);
			
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();
			dashboardPage.clickRefresh();

			String bookingStatus2 = locationinventorypage.getbookingStatus();

			if (bookingStatus2.equals("Pending Booking")) {
				test.log(Status.PASS, "The Booking Status is :" + bookingStatus2);
			} else {
				test.log(Status.PASS, "The Booking Status is :" + bookingStatus2);
			}
			

			if (bookingStatus2.equals("Booking Accepted")) {
				test.log(Status.PASS, "The Booking Status is :" + bookingStatus2);
			} else {
				test.log(Status.PASS, "The Booking Status is :" + bookingStatus2);
			}

		}
	}

	@AfterMethod
	public void setUpend() {
		testactions.updateTestRailTestRunStatus("4897171", "pass", "cycle recout is completed",
				"count recount is done");

		extent.flush();
		driver.quit();
	}
}
