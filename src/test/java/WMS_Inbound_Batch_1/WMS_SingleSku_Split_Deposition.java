package WMS_Inbound_Batch_1;

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
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
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

@Test(enabled = true, groups = { "Inbound" })
public class WMS_SingleSku_Split_Deposition extends WMS_TestBase {

	WebDriver driver;
	WMS_LoginPage loginPage;
	WMS_DashboardPage dashboardPage;
	WMS_ASNPage asnPage;
	WMS_LPNPage lpnPage;
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
	WMS_Chasewave_Sorter_Location chasewaveSorterPage;

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
			lpnPage = new WMS_LPNPage(driver);
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
			chasewaveSorterPage = new WMS_Chasewave_Sorter_Location(driver);
			systemmanagementpage = new WMS_SystemManagementPage(driver);
			setReport("DR_Receiving_Single_Split Deposition");

		}
	}

	@Test(priority = 0, dataProvider = "Single_SKU_SC", dataProviderClass = DataProviders.class)
	public void ASNExecuteCart(String Asn, String Lpn, String CompleteSpecs, String CompleteSpecs2,
			String CompleteSpecs3, String ToteID1, String CartID) throws InterruptedException, AWTException {

		if (!Asn.equals(" ")) {
			if (CloseBrowser) {

				test = extent.createTest(":::TC04_IB_DR_Receiving_Single_Sku:::");

			}

			CloseBrowser = false;

			// ...............................browser launched time starts

		

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

				// ASN Status checking

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("ASNs");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				asnPage.asnSelectMenu();

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				asnPage.enterAsnSearch(Asn);
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Successfuly Searced for ASN " + Asn);

				String status = dashboardPage.getCurrentStatus();
				System.out.println("ilpn page ASNs status is :" + status);

				String TotalQty = asnPage.verifyShippedQty();

				System.out.println("the total qty in ASN is" + TotalQty);

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on gridview" + Asn);
				addSrceenShot("Login", test, Capture);

				readWebTable(asnPage.ASNTableHeader, asnPage.ASNTableBody);

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on gridview" + Asn);
				addSrceenShot("Login", test, Capture);

				dashboardPage.clickRefresh();

				orderspage.selectAllRecord();
				test.log(Status.PASS, "clicked on one record button");
				addSrceenShot("Login", test, Capture);

				// lpn

				lpnPage.clickRelatedLinksILPN();

				lpnPage.clickILPN();

				String status2 = dashboardPage.getCurrentStatus();
				System.out.println("LPN page ASNs status is :" + status2);

				lpnPage.clickExpandBarLPN();

				String itemQtr1 = lpnPage.verifyItemOneQty();

				System.out.println("First item qty : " + itemQtr1);

				String item1 = lpnPage.getitemIDIlpn();

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on gridview " + Asn);
				addSrceenShot("Login", test, Capture);

				readWebTable(lpnPage.LPNTableHeader, lpnPage.LPNTableBody);

				// ILPN Status checking

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("ILPNs");
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Entered MenuSearch as ILPNs");

				asnPage.ilpnsSelectMenu();
				test.log(Status.PASS, "Clicked on iLPN Menu link");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				lpnPage.enterAsnSearch(Asn);
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Successfuly Searced for ASN " + Asn);

				String status3 = dashboardPage.getCurrentStatus();
				System.out.println("ilpn page lpn status is :" + status3);

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on gridview " + Asn);
				addSrceenShot("Login", test, Capture);

				readWebTable(lpnPage.LPNTableHeader, lpnPage.LPNTableBody);

				orderspage.selectAllRecord();
				test.log(Status.PASS, "clicked on one record button");
				addSrceenShot("Login", test, Capture);

				// item page retrive item bar details

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("items");
				test.log(Status.PASS, "Entered MenuSearch as item");

				itemPage.clickitembutton();
				test.log(Status.PASS, "clicked on item button");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				itemPage.itemsearch(item1); // ItemNumber
				test.log(Status.PASS, "Entered item IDs on Item Serach box");
				addSrceenShot("Login", test, Capture);

				String itembar1 = itemPage.multisgetitemparcode1();

				/// DR receiving ///

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("WM Mobile");
				test.log(Status.PASS, "Entered MenuSearch as WM Mobile");

				dashboardPage.clickWmMobileBtn();
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Clicked on WM Mobile Button");

				wvMobilePage.clickDisasterRecovery();
				test.log(Status.PASS, "Clicked on Disaster Recovery");

				discoverRecovery.clickReceivingLpn();
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Clicked on LPN Recieving");

				discoverRecovery.scanLpn(Lpn);

				wvMobilePage.clickGoBtn();

				test.log(Status.PASS, "Entered LPN for scanning");

				utilities.closeCurrentWindow();

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("ILPNs");
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Entered MenuSearch as ILPNs");

				asnPage.ilpnsSelectMenu();
				test.log(Status.PASS, "Clicked on iLPN Menu link");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				lpnPage.enterAsnSearch(Asn);
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Successfuly Searced for ASN " + Asn);

				String status4 = dashboardPage.getCurrentStatus();
				System.out.println("ilpn page lpn current status is :" + status4);

				lpnPage.clickILPNRecord();

				addSrceenShot("Login", test, Capture);

				test.log(Status.PASS, "Successfuly Searced for ASN " + "TOTE*");

				dashboardPage.clickOnDetails();
				lpnPage.lpnDetailTableElementExpandClick("ILPN CONDITIONS");

				addSrceenShot("Login", test, Capture);

				String checkcondition = returnFieldValueForTable(
						readWebTable(lpnPage.getHeaderTableFromLPNDetail("ILPN CONDITIONS"),
								lpnPage.getDataTableFromLPNDetail("ILPN CONDITIONS")),
						"DM", "Description");
				System.out.println("The condition Added successfully" + checkcondition);

				addSrceenShot("Login", test, Capture);

				lpnPage.clickClose();

				// ASN Status checking after DR

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("ASNs");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				asnPage.asnSelectMenu();

				asnPage.enterAsnSearch(Asn);
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Successfuly Searced for ASN " + Asn);

				String status5 = dashboardPage.getCurrentStatus();
				System.out.println("ilpn page ASNs status is :" + status);

				orderspage.selectAllRecord();
				test.log(Status.PASS, "clicked on one record button");
				addSrceenShot("Login", test, Capture);

				// lpn after DR

				lpnPage.clickRelatedLinksILPN();

				lpnPage.clickILPN();

				String status6 = dashboardPage.getCurrentStatus();
				System.out.println("LPN page ASNs status is :" + status6);

				// Go to wm mobile page for split ilpn

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("WM Mobile");
				test.log(Status.PASS, "Entered MenuSearch as WM Mobile");

				dashboardPage.clickWmMobileBtn();
				test.log(Status.PASS, "Clicked on WM Mobile Button");

				wvMobilePage.clickinventoryManagementIlpn();
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Clicked on Inventory Management");

				wvMobilePage.clickSplitLPN();
				test.log(Status.PASS, "Clicked on LPN Split");

				// FIRST ITEM 1
				wvMobilePage.enterDRilpnTote(Lpn);

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");
				
				wvMobilePage.enterQtyIlpn(itemQtr1); //itemQtr1
				test.log(Status.PASS, "Entered  on itemqty1");
				
				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.enterIlpnTote(ToteID1);
				test.log(Status.PASS, "Entered  on Tote1");

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.confirmationBtn();
				test.log(Status.PASS, "Clicked on confirmation Button");

				utilities.closeCurrentWindow();

				// ILPN Status checking

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("ILPNs");
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Entered MenuSearch as ILPNs");

				asnPage.ilpnsSelectMenu();
				test.log(Status.PASS, "Clicked on iLPN Menu link");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				lpnPage.enterAsnSearch(Asn);
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Successfuly Searced for ASN " + Asn);

				String status71 = dashboardPage.getCurrentStatus();
				System.out.println("ilpn page lpn status is :" + status71);

				// disposition of single tote

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("WM Mobile");
				test.log(Status.PASS, "Entered MenuSearch as WM Mobile");

				dashboardPage.clickWmMobileBtn();
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Clicked on WM Mobile Button");

				wvMobilePage.clickinventoryManagementIlpn();
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Clicked on Inventory Management");

				wvMobilePage.clickLeviDisposition();
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Clicked on LeviDisposition");

				wvMobilePage.enterScanContainer(ToteID1);

				wvMobilePage.clickGoBtn();

				wvMobilePage.clickOKbutton();
				test.log(Status.PASS, "Clicked on ok Button");

				addSrceenShot("Login", test, Capture);

				utilities.closeCurrentWindow();

				// ILPN Status checking

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("ILPNs");
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Entered MenuSearch as ILPNs");

				asnPage.ilpnsSelectMenu();
				test.log(Status.PASS, "Clicked on iLPN Menu link");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				lpnPage.enterAsnSearch(Asn);
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Successfuly Searced for ASN " + Asn);

				String status7 = dashboardPage.getCurrentStatus();
				test.log(Status.PASS, "Clicked on ASNS Button" + status7);
				System.out.println("ilpn page lpn status is :" + status7);

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on gridview " + Asn);
				addSrceenShot("Login", test, Capture);

				readWebTable(lpnPage.LPNTableHeader, lpnPage.LPNTableBody);

				orderspage.selectAllRecord();
				test.log(Status.PASS, "Split and Deposition is completed");
				addSrceenShot("Login", test, Capture);

				utilities.closeCurrentWindow();
	}
			
	}

	

	@AfterMethod
	public void setUpend() {

		extent.flush();
		driver.quit();
	}
}
