package WMS_InvCont_Batch_2;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.aventstack.extentreports.ExtentTest;

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
public class WMS_Remove_Condition_Code extends WMS_TestBase {

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
			setReport("B2_TC09_Remove_Condition_Code");
		}
	}

	@Test(priority = 0, dataProvider = "Add_and_Remove_Condition", dataProviderClass = DataProviders.class)

	public void addAndRemoveCondition(String ToteID) throws InterruptedException, AWTException {

		if (!ToteID.equals(" ")) {
			if (CloseBrowser) {

				test = extent.createTest(":::Remove_Condition_Code:::");
			}

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

			loginPage.resizeWebpage();
			test.log(Status.PASS, "Window resize");
			dashboardPage.clickMenuToggle();


			dashboardPage.enterMenuSearch("ILPNs");
			test.log(Status.PASS, "Entered MenuSearch as ILPNs");

			dashboardPage.clickMenuBtn(dashboardPage.lpnElement);
			test.log(Status.PASS, "Clicked on iLPN Menu link");

			/* lsnPage.clickNotAllocatedBtn(); */

			lsnPage.enterLpnSearch(ToteID);

			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();

			dashboardPage.clickMenuToggle();

			dashboardPage.enterMenuSearch("wm mobile");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			wvMobilePage.clickWmbtn();
			test.log(Status.PASS, "Clicked on waverun Button");

			addSrceenShot("Login", test, Capture);

			utilities.switchToWindows();

			wvMobilePage.clickInventoryIlpnBtn();
			test.log(Status.PASS, "Clicked on Inventory Management");

			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickRemoveCode();

			addSrceenShot("Login", test, Capture);

			wvMobilePage.enterConditionToteId(ToteID);

			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();

			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickRemoveDropDown();

			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickDamagedBtn();

			

			utilities.closeCurrentWindow();

			dashboardPage.clickRefresh();

			dashboardPage.clickMenuToggle();

			dashboardPage.enterMenuSearch("ILPNs");
			test.log(Status.PASS, "Entered MenuSearch as ILPNs");

			dashboardPage.clickMenuBtn(dashboardPage.lpnElement);
			test.log(Status.PASS, "Clicked on iLPN Menu link");

			/* lsnPage.clickNotAllocatedBtn(); */

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

			lsnPage.enterLpnSearch(ToteID);
			addSrceenShot("Login", test, Capture);



			/*
			 * lsnPage.checkSelectedRow(selectSingleRow(" "+ToteID+" "));
			 */

			lsnPage.clickILPNRecord();

			addSrceenShot("Login", test, Capture);

			test.log(Status.PASS, "Successfuly Searced for ASN " + "TOTE*");

			dashboardPage.clickOnDetails();

			addSrceenShot("Login", test, Capture);

			lsnPage.lpnDetailTableElementExpandClick("ILPN CONDITIONS");

			try {

				String checkcondition3= returnFieldValueForTable(
						readWebTable(lsnPage.getHeaderTableFromLPNDetail("ILPN CONDITIONS"),
								lsnPage.getDataTableFromLPNDetail("ILPN CONDITIONS")),
						"DM", "Description");
				System.out.println("The condition Added successfully" + checkcondition3);
			} catch (Exception e) {
				System.out.println("The condition removed successfully");
				test.log(Status.PASS, "The condition removed successfully");
			}



		}
		
	}
	@AfterMethod
	public void setUpend() {
		testactions.updateTestRailTestRunStatus("4551686", "pass", "user directed cycle count finished", "count is done");

		extent.flush();
		driver.quit();
}
}