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
public class WMS_Clock_In extends WMS_TestBase {

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
			systemmanagementpage = new WMS_SystemManagementPage(driver);
			setReport("B2_TC03_WMS_Clock_In");
		}
	}

	@Test(priority = 0, dataProvider = "Clock_In_Clock_Out", dataProviderClass = DataProviders.class)

	public void addAndRemoveCondition(String UserId, String TimeIn, String OutTime)
			throws InterruptedException, AWTException {

		if (!UserId.equals(" ")) {
			if (CloseBrowser) {
				test = extent.createTest("::: WMS_Clock_In:::");
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

			dashboardPage.enterMenuSearch("employee time");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			wvMobilePage.clickEmpTimeLine();
			test.log(Status.PASS, "Clicked on waverun Button");

			addSrceenShot("Login", test, Capture);

			wvMobilePage.addNewUser();
			test.log(Status.PASS, "Clicked on addNewUser");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.CockInoutDropDown();
			test.log(Status.PASS, "Clicked on Clock in clock out");
			addSrceenShot("Login", test, Capture);

			wvMobilePage.enterUserId(UserId);
			addSrceenShot("Login", test, Capture);
			wvMobilePage.clickUserId();

			wvMobilePage.clickCalendarInBtn();

			wvMobilePage.enterTime(TimeIn);
			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickApplybtnIn();

			wvMobilePage.clickSaveBtn();
			addSrceenShot("Login", test, Capture);
			
			addSrceenShot("Login", test, Capture);
			
			utilities.closeCurrentWindow();

		}
		/*
		 * CloseBrowser = true; testactions.updateTestRailTestRunStatus("4897135",
		 * "pass", "singles bag pack-3", "singles bag pack-3 is done");
		 */
	}
	@AfterMethod
	public void setUpend() {

		extent.flush();
		driver.quit();
	}

}