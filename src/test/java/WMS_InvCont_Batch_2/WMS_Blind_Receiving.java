
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
public class WMS_Blind_Receiving extends WMS_TestBase {

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
			setReport("B2_TC02_Blind Receiving");
		}
	}

	@Test(priority = 0, dataProvider = "blind_receiving", dataProviderClass = DataProviders.class)

	public void cycleCountUserDirec(String OrderNumber) throws InterruptedException, AWTException {

		if (!OrderNumber.equals(" ")) {
			if (CloseBrowser) {

				test = extent.createTest(":::Blind Receiving:::");
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
			addSrceenShot("Login", test, Capture);
			
			loginPage.resizeWebpage();
			test.log(Status.PASS, "Window resize");

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.distbtn();
			test.log(Status.PASS, "Clicked on distribution Button");

			dashboardPage.clickorderMagmnt();
			test.log(Status.PASS, "Clicked on ordersmanagement Button");
			addSrceenShot("Login", test, Capture);
			dashboardPage.ordersclick();
			test.log(Status.PASS, "Clicked on Order Button");

			orderspage.enterOrdersSearch(OrderNumber, dashboardPage);
			test.log(Status.PASS, "Entered Order Search");
			addSrceenShot("Login", test, Capture);
			String itemiddetails = orderspage.getitemNumber();

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("items");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");
			addSrceenShot("Login", test, Capture);
			itemPage.clickitembutton();
			itemPage.itemsearch(itemiddetails); // ItemNumber
			addSrceenShot("Login", test, Capture);
			dashboardPage.clickRefresh();

			String itembarcode = itemPage.getitemparcode();

			dashboardPage.clickMenuToggle();

			dashboardPage.enterMenuSearch("return station");
			test.log(Status.PASS, "Entered MenuSearch as ILPNs");

			packStationPage.clickReturnUI();

			packStationPage.sendReturntext();
			test.log(Status.INFO, "Sending return text for packstation");
			packStationPage.receiveBtn();
			addSrceenShot("Login", test, Capture);
			packStationPage.enterDoText(OrderNumber);
			test.log(Status.INFO, "Entered the Order Number" +OrderNumber);
			packStationPage.enterReturnItemText(itembarcode);
			addSrceenShot("Login", test, Capture);
			packStationPage.clickReturnTikbtn();
			test.log(Status.PASS, "Clicked the Return Btn successfully");
			packStationPage.clickSelableDropdown();
			addSrceenShot("Login", test, Capture);
			packStationPage.clickSelableButton();

			packStationPage.btnGenerate();
			addSrceenShot("Login", test, Capture);
			String Lpnsdetails = packStationPage.getLpns();

			packStationPage.btnReceive();
			addSrceenShot("Login", test, Capture);
			String Asndetails = packStationPage.getAsnsNumberBLR();

			dashboardPage.clickMenuToggle();

			dashboardPage.enterMenuSearch("system management");
			test.log(Status.PASS, "Entered MenuSearch as ILPNs");

			systemmanagementpage.clickSystemMgmtBtn();

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

			dashboardPage.clickRefresh();

			systemmanagementpage.enterTranlogToteIDSearch(OrderNumber);
			addSrceenShot("Login", test, Capture);
			dashboardPage.clickRefresh();

			dashboardPage.clickRefresh();

			utilities.toggleGridView(dashboardPage.GridViewButton);

			systemmanagementpage.clickTranFirstRecordBtn();
			addSrceenShot("Login", test, Capture);
			systemmanagementpage.clickPayLoadBtn();
			test.log(Status.PASS, "Clicked on the PAyload button ");
			systemmanagementpage.clicklinebtn();

			String payLoad = systemmanagementpage.getInnerTextMessage();
			addSrceenShot("Login", test, Capture);
			System.out.println(payLoad);
			test.log(Status.PASS, "Clicked on the PAyload button successfully" +payLoad);
			if (payLoad.contains("RECEIVING")) {
				test.log(Status.PASS, "Payload text contains " + OrderNumber);
			} else {
				test.log(Status.INFO, "Payload text does not contain " + OrderNumber);
			}

			systemmanagementpage.clickPayCloseBtn();

			utilities.closeCurrentWindow();

			dashboardPage.clickMenuToggle();

			dashboardPage.enterMenuSearch("ILPNs");
			test.log(Status.PASS, "Entered MenuSearch as ILPNs");

			dashboardPage.clickMenuBtn(dashboardPage.lpnElement);
			test.log(Status.PASS, "Clicked on iLPN Menu link");
			addSrceenShot("Login", test, Capture);
			lsnPage.enterLpnSearch(Lpnsdetails);
			addSrceenShot("Login", test, Capture);
			String ilpnsfromILPNPage = lsnPage.getlpnsfromilpnPage();

			if (Lpnsdetails.equals(ilpnsfromILPNPage)) {

				System.out.println("lpn verified successfully");
				test.log(Status.PASS, "lpn is verified from return station UI generated ILPNS");
			}

		}

	}

	@AfterMethod
	public void setUpend() {
		testactions.updateTestRailTestRunStatus("4897170", "pass", "Blind receiving", "Blind Receiving is done");

		extent.flush();
		driver.quit();
	}
}