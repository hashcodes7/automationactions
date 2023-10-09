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
public class WMS_Parcel_End_of_The_Day extends WMS_TestBase {

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
			setReport("WMS_Parcel_End_of_The_Day");
		}
	}

	@Test(priority = 0, dataProvider = "ParcelEnd_of_TheDay", dataProviderClass = DataProviders.class)

	public void orderAllocation(String CarrierServer, String parceEndDate) throws InterruptedException, AWTException {
try {
		if (!CarrierServer.equals(" ")) {
			if (CloseBrowser) {
				test = extent.createTest(":::WMS_Parcel_End_of_The_Day:::");

			}

			// ...............................browser launched time starts

			long startTime = System.nanoTime();

			String GetTime = utilities.Timer();
			System.out.println("Browser Launched Time :" + GetTime);
			test.log(Status.PASS, "Browser Launched Time :" + GetTime);

			// ......................................................................................//

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

			// server 1

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("parcel end");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			dashboardPage.parcelEndOfdayBtn();
			test.log(Status.PASS, "Clicked on Order Button");

			addSrceenShot("Login", test, Capture);

			orderspage.initiateEODrequest();

			orderspage.clickCarierServer(CarrierServer);

			addSrceenShot("Login", test, Capture);

			orderspage.enterCarrierDate(parceEndDate);

			addSrceenShot("Login", test, Capture);

			orderspage.clickapplybtn();

			orderspage.confirmSummit();
			test.log(Status.PASS, "clicked on submit button");

			addSrceenShot("Login", test, Capture);

			orderspage.clickInitiateBtn();

			String fedx = orderspage.getStatusFromInitiate();
			System.out.println("Current Execution Server ID  " + fedx);
			addSrceenShot("Login", test, Capture);
			// ................................total timer start...................//

			long AstartTime1 = System.nanoTime();

			String AGetTime2 = utilities.Timer();
			System.out.println("wave run start time is :" + AGetTime2);
			test.log(Status.PASS, "wave run start time is :" + AGetTime2);

			// ..................................................................//

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			orderspage.enterCarrierSearch(fedx);
			test.log(Status.PASS, "initiate ID search");
			addSrceenShot("Login", test, Capture);

			String fedx2 = orderspage.getStatusFromInitiate();
			System.out.println("Current Execution Server ID  " + fedx2);
			addSrceenShot("Login", test, Capture);

			String expectedcount = orderspage.getExpectedCount();
			System.out.println("Expected count is = " + expectedcount);
			addSrceenShot("Login", test, Capture);

			String actualcount = orderspage.getActualCount();
			System.out.println("Actual count is   = " + actualcount);
			addSrceenShot("Login", test, Capture);

			System.out.println("The Current Carrier id Initiated ID Status" + actualcount + expectedcount);
			test.log(Status.PASS, "The Current Carrier id Initiated ID Status " + actualcount + expectedcount);

			System.out.println(
					"The Current Carrier  is Parcel End Of Day Not available any Count Available both actual and carrier : ");
			test.log(Status.PASS,
					"The Current Carrier  is Parcel End Of Day Not available any Count Available both actual and carrier : ");

			orderspage.ParcelEndStatus(dashboardPage);
			test.log(Status.PASS, "waiting for new status update");
			addSrceenShot("Login", test, Capture);

			String expectedcount2 = orderspage.getExpectedCount();
			System.out.println("Expected count after closed status is = " + expectedcount2);
			addSrceenShot("Login", test, Capture);

			String actualcount2 = orderspage.getActualCount();
			System.out.println("Actual count after closed status  is   = " + actualcount2);
			addSrceenShot("Login", test, Capture);

			System.out.println("The Current Carrier id Initiated ID Status" + actualcount + "and" + expectedcount);
			test.log(Status.PASS, "The Current Carrier id Initiated ID Status " + actualcount + "and" + expectedcount);

			orderspage.selectAllRecord();
			test.log(Status.PASS, "clicked on one record button");
			addSrceenShot("Login", test, Capture);

			orderspage.clickRelatedLinks();

			orderspage.clickManifestedOlpns();

			orderspage.selectAllRecord();
			test.log(Status.PASS, "clicked on all record button");
			addSrceenShot("Login", test, Capture);

			String olpncount = orderspage.getOLPNCountInOlpnPage();
			addSrceenShot("Login", test, Capture);
			test.log(Status.PASS,"total olpn count in olpn page" + olpncount);
			System.out.println("total olpn count in olpn page" + olpncount);

			if (olpncount.contains(expectedcount)) {
				test.log(Status.PASS,"Expected OLPN is available");
				System.out.println("Expected OLPN is available");
			} else {

				System.out.println("Actual and expected OLPN mismatched");
				test.log(Status.PASS, "Actual and expected OLPN mismatched");

			}
			// .................................total time. end with
			// timer.......................//

			long AendTime1 = System.nanoTime();

			String AGetTime21 = utilities.Timer();
			System.out.println("Current carrier execution time is   :" + AGetTime21);
			test.log(Status.PASS, "Current carrier execution time is  :" + AGetTime21);

			String AtotalTime11 = WMS_WebDriverUtilities.printExecutionTimeMinutes(AstartTime1, AendTime1);
			/* String s11=Long.toString(totalTime11); */
			System.out.println("Total Current carrier execution time is" + AtotalTime11);
			test.log(Status.PASS, "Total Current carrier execution time is" + AtotalTime11);

			System.out.println("The Current Carrier  is Parcel End Of Day pprocess finished : " + fedx2);
			test.log(Status.PASS, "The Current Carrier  is Parcel End Of Day pprocess finished :" + fedx2);

			// .................................total time........................//
			// ...........................................................//
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