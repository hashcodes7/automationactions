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
public class WMS_LPN_Multi_SKU extends WMS_TestBase {

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
			setReport("TC01_IB_DR_Receiving_Multis_Sku");

		}
	}

	@Test(priority = 0, dataProvider = "Multi_DR_Receiving", dataProviderClass = DataProviders.class)

	public void ASNExecuteCart(String Asn, String Lpn, String CompleteSpecs, String CompleteSpecs2,
			String CompleteSpecs3, String ToteID1, String ToteID2, String CartID, String itemID1, String itemID2)
			throws InterruptedException, AWTException {

		try {
			
		if (!Asn.equals(" ")) {
			if (CloseBrowser) {

				test = extent.createTest(":::TC01_IB_DR_Receiving_Multis_Sku:::");

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
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("ASNs");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				asnPage.asnSelectMenu();

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				asnPage.enterAsnSearch(Asn);
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Successfuly Searced for ASN " + Asn);

				String status = dashboardPage.getCurrentStatus();
				test.log(Status.PASS, "Clicked on ASNS Button" + status);
				System.out.println("ilpn page ASNs status is :" + status);

				String TotalQty = asnPage.verifyShippedQty();

				System.out.println("the total qty in ASN is" + TotalQty);

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on gridview" + Asn);
				addSrceenShot("Login", test, Capture);

				readWebTable(asnPage.ASNTableHeader, asnPage.ASNTableBody);

				dashboardPage.clickRefresh();

				orderspage.selectAllRecord();
				test.log(Status.PASS, "clicked on one record button");
				addSrceenShot("Login", test, Capture);

				// lpn

				lpnPage.clickRelatedLinksILPN();

				lpnPage.clickILPN();

				String status2 = dashboardPage.getCurrentStatus();
				System.out.println("asns page lpn status is :" + status2);
				test.log(Status.PASS, "Cleared Selected Filter");
				addSrceenShot("Login", test, Capture);

				lpnPage.clickExpandBarLPN();

				String itemQtr1 = lpnPage.verifyItemOneQty();

				System.out.println("First item qty : " + itemQtr1);

				String itemQtr2 = lpnPage.verifyItemTwoQty();

				System.out.println("Secound item  qty : " + itemQtr2);

				String item1 = lpnPage.getitemIDIlpn();

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on gridview " + Asn);
				addSrceenShot("Login", test, Capture);

				readWebTable(asnPage.ASNTableHeader, asnPage.ASNTableBody);

				// ILPN Status checking

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

				String status3 = dashboardPage.getCurrentStatus();
				System.out.println("ilpn page lpn status is :" + status3);
				test.log(Status.PASS, "ilpn page lpn status is :");
				addSrceenShot("Login", test, Capture);

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on gridview " + Asn);
				addSrceenShot("Login", test, Capture);

				readWebTable(asnPage.ASNTableHeader, asnPage.ASNTableBody);

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

				// ASN Status checking after DR

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("ASNs");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				asnPage.asnSelectMenu();

				asnPage.enterAsnSearch(Asn);
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Successfuly Searced for ASN " + Asn);

				String status5 = dashboardPage.getCurrentStatus();
				System.out.println("ilpn page lpn status is :" + status5);
				test.log(Status.PASS, "ASNS page lpn status is :");
				addSrceenShot("Login", test, Capture);

				orderspage.selectAllRecord();
				test.log(Status.PASS, "clicked on one record button");
				addSrceenShot("Login", test, Capture);

				lpnPage.clickRelatedLinksILPN();

				lpnPage.clickDrpReceip();

				String itemcode1 = asnPage.receipitem1();

				System.out.println("item from 1 column" + itemcode1);

				String itemcode2 = asnPage.receipitem2();

				System.out.println("item from 2 column" + itemcode2);

				// item page retrive item bar details

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("items");
				test.log(Status.PASS, "Entered MenuSearch as item");

				itemPage.clickitembutton();
				test.log(Status.PASS, "clicked on item button");

				dashboardPage.clearAllBtn();
				test.log(Status.PASS, "Cleared Selected Filter");

				itemPage.itemsearch(itemcode1 + ", " + itemcode2); // ItemNumber
				test.log(Status.PASS, "Entered item IDs on Item Serach box");
				addSrceenShot("Login", test, Capture);

				String itembar1 = itemPage.multisgetitemparcode1();

				String itembar2 = itemPage.multisgetitemparcode2();

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

				wvMobilePage.enteritemBarFrmSplit(itembar1);
				test.log(Status.PASS, "Entered  on itemqty1");

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.enterQtyIlpn(itemQtr1); // itemQtr1

				test.log(Status.PASS, "Entered  on itemqty1");

				wvMobilePage.clickGoBtn();

				wvMobilePage.enterIlpnTote(ToteID1);
				test.log(Status.PASS, "Entered  on Tote1");

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.confirmationBtn();

				// SECOUND ITEM 2

				wvMobilePage.enterDRilpnTote(Lpn);

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.enterQtyIlpn(itemQtr2); // itemQtr2

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.enterIlpnTote(ToteID2);
				test.log(Status.PASS, "Entered  on Tote2");

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.confirmationBtn();
				test.log(Status.PASS, "Clicked on confirmation Button");

				utilities.closeCurrentWindow();

				// ILPN Status checking

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

				String status31 = dashboardPage.getCurrentStatus();
				System.out.println("ilpn page lpn status is :" + status31);
				test.log(Status.PASS, "ilpn page lpn status is :");
				addSrceenShot("Login", test, Capture);

				utilities.toggleGridView(dashboardPage.GridViewButton);
				test.log(Status.PASS, "Clicked on gridview " + Asn);
				addSrceenShot("Login", test, Capture);

				readWebTable(asnPage.ASNTableHeader, asnPage.ASNTableBody);

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
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.clickOKbutton();
				test.log(Status.PASS, "Clicked on Go Button");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.enterScanContainer(ToteID2);

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.clickOKbutton();
				test.log(Status.PASS, "Clicked on ok Button");

				addSrceenShot("Login", test, Capture);

				utilities.closeCurrentWindow();

				// Choose task group as PTW

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("WM Mobile");
				test.log(Status.PASS, "Entered MenuSearch as WM Mobile");
				addSrceenShot("Login", test, Capture);

				dashboardPage.clickWmMobileBtn();
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Clicked on WM Mobile Button");

				wvMobilePage.clickSettingsButton();
				test.log(Status.PASS, "Clicked on Settings button");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickTaskGroupRow();
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Clicked on Task Group");

				wvMobilePage.clicktaskgroupDropDownButton();
				test.log(Status.PASS, "Clicked on Task Group Dropdown");

				wvMobilePage.selectTaskGroup("PTW");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.clickDoneBtn();
				test.log(Status.PASS, "Clicked on Done Button");

				// WM Mobile-> PUTAWAY -

				wvMobilePage.clickPutAwayBtn();
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Clicked on WM Mobile Button");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickMakePutCart();
				addSrceenShot("Login", test, Capture);

				wvMobilePage.enterAcceptCartidElement(CartID);
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");

				wvMobilePage.enterAcceptToteIDElement(ToteID1);
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.enterAcceptToteIDElement(ToteID2);
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "Clicked on Go Button");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickendCartButton();
				test.log(Status.PASS, "Clicked eND Button");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.confirmationBtn();
				test.log(Status.PASS, "Clicked Confirmation Button");

				// enter loc putway

				wvMobilePage.entergetLoc();
				test.log(Status.PASS, "entered location");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "entered go ");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.enterDrDestinationToteID();
				test.log(Status.PASS, "entered tote");
				addSrceenShot("Login", test, Capture);

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "entered go ");
				addSrceenShot("Login", test, Capture);

				String itemNo1WM = wvMobilePage.getitemNumber1WMmobile();
				test.log(Status.PASS, "displayed item no from wm mobile");

				if (itemNo1WM.equals(itemcode1)) {
					wvMobilePage.enterItemIDbarcodePutwall(itembar1); // itembarcode
					wvMobilePage.clickGoBtn();
					test.log(Status.PASS, "entered go ");

				} else if (!itemNo1WM.equals(itemcode1)) {

					wvMobilePage.enterItemIDbarcodePutwall(itembar2); // itembarcode
					wvMobilePage.clickGoBtn();
					test.log(Status.PASS, "entered go ");

				}

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "entered go ");

				// SECOUND TOTE

				wvMobilePage.entergetLoc();
				test.log(Status.PASS, "entered location");

				wvMobilePage.clickGoBtn();

				wvMobilePage.enterDrDestinationToteID();
				test.log(Status.PASS, "entered tote");

				wvMobilePage.clickGoBtn();
				test.log(Status.PASS, "entered go btn");

				String itemNo2WM = wvMobilePage.getitemNumber1WMmobile();
				test.log(Status.PASS, "displayed item no from wm mobile");

				if (itemNo2WM.equals(itemcode2)) {
					wvMobilePage.enterItemIDbarcodePutwall(itembar2); // itembarcode
					wvMobilePage.clickGoBtn();
					test.log(Status.PASS, "entered go ");

				} else if (!itemNo1WM.equals(itemcode1)) {

					wvMobilePage.enterItemIDbarcodePutwall(itembar1); // itembarcode
					wvMobilePage.clickGoBtn();
					test.log(Status.PASS, "entered go ");

				}

				wvMobilePage.clickGoBtn();

				utilities.closeCurrentWindow();

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("ASNs");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				asnPage.asnSelectMenu();

				asnPage.enterAsnSearch(Asn);
				addSrceenShot("Login", test, Capture);
				test.log(Status.PASS, "Successfuly Searced for ASN " + Asn);

				String status7 = dashboardPage.getCurrentStatus();
				System.out.println("ilpn page ASNs status is :" + status7);

				orderspage.selectAllRecord();
				test.log(Status.PASS, "clicked on one record button");
				addSrceenShot("Login", test, Capture);

				orderspage.btnThreedots();
				test.log(Status.PASS, "clicked on one threeDots button");

				asnPage.clickVryASNbutton(test);

				asnPage.clickVeriFyBtninsideThreeDots();

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "clicked refresh");

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "clicked refresh");

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "clicked refresh");

				dashboardPage.clickRefresh();
				test.log(Status.PASS, "clicked refresh");

				String status8 = dashboardPage.getCurrentStatus();
				System.out.println("ilpn page ASNs status is :" + status8);

				// tranlog details

				dashboardPage.clickMenuToggle();
				test.log(Status.PASS, "Clicked on menu Button");

				dashboardPage.enterMenuSearch("system management");
				test.log(Status.PASS, "Entered MenuSearch as ASNs");

				systemmanagementpage.clickSystemMgmtBtn();
				test.log(Status.PASS, "clicked system management as ASNs");
				addSrceenShot("Login", test, Capture);

				utilities.switchToWindows();

				dashboardPage.clickMenuToggle();

				dashboardPage.enterMenuSearch("tranlog details");
				test.log(Status.PASS, "Entered tranlog details button");
				addSrceenShot("Login", test, Capture);

				systemmanagementpage.clickTranlogDetailsBtn();
				test.log(Status.PASS, "Entered tranlog details button from menu");
				addSrceenShot("Login", test, Capture);

				systemmanagementpage.enterTranlogToteIDSearch(Asn);
				addSrceenShot("Login", test, Capture);

				systemmanagementpage.enterMesgPaySearch("PIX_XIN_InventoryAdjustment_QA");
				test.log(Status.PASS, "filterd tranlog verify text");
				addSrceenShot("Login", test, Capture);

				systemmanagementpage.bulkRfreshPage(dashboardPage);

				utilities.toggleGridView(dashboardPage.GridViewButton);

				addSrceenShot("Login", test, Capture);

				systemmanagementpage.clickTranFirstRecordBtn();

				addSrceenShot("Login", test, Capture);

				systemmanagementpage.clickPayLoadBtn();

				addSrceenShot("Login", test, Capture);

				systemmanagementpage.clicklinebtn();
				addSrceenShot("Login", test, Capture);

				addSrceenShot("Login", test, Capture);

				String payLoad = systemmanagementpage.getInnerTextMessage();
				addSrceenShot("Login", test, Capture);

				System.out.println(payLoad);

				if (payLoad.contains("Verify_ASN")) {
					test.log(Status.PASS, "Payload text contains " + "Verify_ASN");
					addSrceenShot("Login", test, Capture);
				} else {
					test.log(Status.INFO, "Payload text hhas contain " + "Verify_ASN");
					addSrceenShot("Login", test, true);
				}

				if (payLoad.contains(Asn)) {
					test.log(Status.PASS, "Payload text contains " + Asn);
					addSrceenShot("Login", test, Capture);
				} else {
					test.log(Status.INFO, "Payload text hhas contain " + Asn);
					addSrceenShot("Login", test, true);
				
				}
				utilities.closeCurrentWindow();
					
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
