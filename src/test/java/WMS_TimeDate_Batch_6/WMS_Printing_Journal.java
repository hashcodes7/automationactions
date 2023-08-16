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
public class WMS_Printing_Journal extends WMS_TestBase {

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
	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();

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
			setReport("WMS_Printing_Journal_Set_Printer");
		}
	}

	@Test(priority = 0, dataProvider = "Printing_Journal", dataProviderClass = DataProviders.class)

	public void orderAllocation(String OrderNumber, String CompleteSpecs, String TaskGroup, String PrintType)
			throws InterruptedException, AWTException {

		if (!OrderNumber.equals(" ")) {
			if (CloseBrowser) {
				test = extent.createTest(":::WMS_Printing_Journal_Set_Printer:::");
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

			dashboardPage.clickMenuToggleElementTwo();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("orders");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			addSrceenShot("Login", test, Capture);

			dashboardPage.ordersclick();
			test.log(Status.PASS, "Clicked on Order Button");

			orderspage.enterOrdersSearch(OrderNumber, dashboardPage);
			test.log(Status.PASS, "Entered Order Search");

			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();

			String itemfromOrder1 = orderspage.getItemNoBYOrdersNo(OrderNumber);

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("olpns");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			dashboardPage.olpnclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clearAllBtn();
			
			orderspage.searchOlpntextbox(OrderNumber, dashboardPage);

			
			addSrceenShot("Login", test, Capture);

			String olpnfromOrder1 = orderspage.getOlpnsNumberFirst(OrderNumber);

			
			orderspage.clickOlpnsRecord();
			test.log(Status.PASS, "clicked on one record button");

			addSrceenShot("Login", test, Capture);

			orderspage.clickRelatedLinks();

			orderspage.selectPrintingJournal();

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wm mobile");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickWmbtn();
			test.log(Status.PASS, "Clicked on waverun Button");

			utilities.switchToWindows();

			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickSettingsButton();
			test.log(Status.PASS, "Clicked on Settings button");

			wvMobilePage.clickPrintJournalGroupRow();
			test.log(Status.PASS, "Clicked on Task Group");

			wvMobilePage.clicktaskgroupDropDownButton();
			test.log(Status.PASS, "Clicked on Task Group Dropdown");

			wvMobilePage.selectPrintGroup(TaskGroup);

			addSrceenShot("Login", test, Capture);

			wvMobilePage.clickGoBtn();

			wvMobilePage.clickDoneBtn();

			wvMobilePage.clickPrintBtn();

			wvMobilePage.clickLeviOutBoundBtn();

			wvMobilePage.enterOlpnsPrint(olpnfromOrder1); // olpnsNumber

			wvMobilePage.clickGoBtn();

			wvMobilePage.clickrequiredPrinter(dashboardPage, PrintType);

			utilities.closeCurrentWindow();

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("olpns");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			dashboardPage.olpnclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clearAllBtn();

			orderspage.searchOlpntextbox(OrderNumber, dashboardPage);

			addSrceenShot("Login", test, Capture);

			String olpnfromOrder2 = orderspage.getOlpnsNumberFirst(OrderNumber);
			addSrceenShot("Login", test, Capture);

			dashboardPage.clearAllBtn();

			orderspage.searchOlpnsNumber(olpnfromOrder2);

			orderspage.clickOlpnsRecord();
			test.log(Status.PASS, "clicked on one record button");

			addSrceenShot("Login", test, Capture);

			orderspage.clickRelatedLinks();

			orderspage.selectPrintingJournal();
			addSrceenShot("Login", test, Capture);

			// check completed status

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			String printeActualType = orderspage.getPrinterTypeVerify(PrintType);
			addSrceenShot("Login", test, Capture);

			String printerTypeActualStatus = orderspage.getPrinterStatusVerify(PrintType);
			addSrceenShot("Login", test, Capture);

			if (printerTypeActualStatus.equals(CompleteSpecs)) {

				System.out.println("The Printer is able to view and get completed status");
				test.log(Status.PASS, "The Printer is able to view and get completed status");
			}

		}
	}

		@AfterMethod
		public void setUpend() {

			extent.flush();
			driver.quit();
		}
	}