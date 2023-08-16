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
import org.testng.annotations.Listeners;
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
public class WMS_Cycle_Count_userdirected extends WMS_TestBase {

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
			setReport("B2_TC05_cycle_Count_UserDirected");

		}
	}

	@Test(priority = 0, dataProvider = "cycle_Count_UserDirected", dataProviderClass = DataProviders.class)

	public void cycleCountUserDirec(String location, String itemid, String LOCATIONID)
			throws InterruptedException, AWTException {

		if (!location.equals(" ")) {
			if (CloseBrowser) {
				test = extent.createTest(":::cycle_Count_UserDirected:::");
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
			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("items");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			itemPage.clickitembutton();

			itemPage.itemsearch(itemid); // ItemNumber

			addSrceenShot("Login", test, Capture);

			String itembarcode = itemPage.getitemparcode();
			addSrceenShot("Login", test, Capture);
			utilities.closeCurrentWindow();

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("location inventory");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			locationinventorypage.clickInventoryBtn();
			addSrceenShot("Login", test, Capture);

			locationinventorypage.inventoryBarsearch(location);
			test.log(Status.PASS, "Entered Order Search");

			locationinventorypage.locInventoryExpBtn();
			addSrceenShot("Login", test, Capture);

			int TotalUnitCount = locationinventorypage.getTotalUnitCount();
			test.log(Status.PASS, "get total unit count"+TotalUnitCount);
			System.out.println(TotalUnitCount);

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wm mobile");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickWmbtn();
			test.log(Status.PASS, "Clicked on WM mobile Button");
			addSrceenShot("Login", test, Capture);

			utilities.switchToWindows();

			wvMobilePage.clickSettingsButton();
			test.log(Status.PASS, "Clicked on Settings button");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickTaskGroupRow();
			test.log(Status.PASS, "Clicked on Task Group");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clicktaskgroupDropDownButton();
			test.log(Status.PASS, "Clicked on Task Group Dropdown");
			addSrceenShot("Login", test, Capture);

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

			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();
			addSrceenShot("Login", test, Capture);

		   wvMobilePage.clickConfirmBtn();

			// itembarcode

			wvMobilePage.entercycleItemBar(itembarcode); // 003480001 M itembarcode

			wvMobilePage.clickGoBtn();
			addSrceenShot("Login", test, Capture);
			wvMobilePage.enterCycleCountUnits(Integer.toString(TotalUnitCount + 2)); // TotalUnitCount

			wvMobilePage.clickGoBtn();
			addSrceenShot("Login", test, Capture);
			wvMobilePage.clickConfirmBtn();
			addSrceenShot("Login", test, Capture);
			utilities.closeCurrentWindow();

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("inventory count");
			test.log(Status.PASS, "Clicked on menu Button");
			addSrceenShot("Login", test, Capture);
			locationinventorypage.clickInventoryCount();
			test.log(Status.PASS, "Entered MenuSearch as ASNs");
			

			locationinventorypage.inventorysearch(LOCATIONID);
			test.log(Status.PASS, "Entered MenuSearch as inventory Search");
			addSrceenShot("Login", test, Capture);
			String bookingStatus = locationinventorypage.getbookingStatus();
			test.log(Status.INFO,"The Booking Status is :" + bookingStatus);
			System.out.println("The Booking Status is :" + bookingStatus);
			addSrceenShot("Login", test, Capture);
			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");
			addSrceenShot("Login", test, Capture);
			dashboardPage.enterMenuSearch("location inventory");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");
			addSrceenShot("Login", test, Capture);
			locationinventorypage.clickInventoryBtn();
			test.log(Status.PASS, "Clicked on Inventory button");

			locationinventorypage.inventoryBarsearch(location);
			test.log(Status.PASS, "Entered Order Search");
			addSrceenShot("Login", test, Capture);
			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Clicked on Referesh button");

			locationinventorypage.locInventoryExpBtn();
			test.log(Status.PASS, "Clicked on Record Exp button");
			addSrceenShot("Login", test, Capture);
			int TotalUnitCount2 = locationinventorypage.getTotalUnitCount();

			System.out.println(TotalUnitCount2);
			addSrceenShot("Login", test, Capture);
			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("inventory count");
			test.log(Status.PASS, "Entered MenuSearch as inventory count");
			addSrceenShot("Login", test, Capture);
			locationinventorypage.clickInventoryCount();

			locationinventorypage.inventorysearch(LOCATIONID);
			
			addSrceenShot("Login", test, Capture);
			String bookingStatus2 = locationinventorypage.getbookingStatus();
			test.log(Status.INFO,"The Booking Status is :" + bookingStatus2);
			System.out.println("The Booking Status is :" + bookingStatus2);
			// 1 - pass
			// 5 - fail

			// itembarcode

		}

	}

	@AfterMethod
	public void setUpend() {
		testactions.updateTestRailTestRunStatus("4551685", "pass", "user directed cycle count finished",
				"count is done");

		extent.flush();
		driver.quit();
	}
}