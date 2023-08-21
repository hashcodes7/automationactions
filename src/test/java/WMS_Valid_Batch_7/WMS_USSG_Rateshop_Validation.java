package WMS_Valid_Batch_7;

import java.awt.AWTException;
import resources.DataProviders;

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
import org.testng.annotations.DataProvider;
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
import com.WMS_ApplicationPages.WMS_TasksPage;
import com.WMS_ApplicationPages.WMS_WVMobilePage;
import com.WMS_ApplicationPages.WMS_WaveRunsPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;



@Test(enabled = true, groups = { "Rateshop" })
public class WMS_USSG_Rateshop_Validation extends WMS_TestBase {

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
			setReport("USSG_RateShop_Validation");

		}
	}

	@Test(priority = 0, dataProvider = "USSG_RateShop_Validation", dataProviderClass = DataProviders.class)

	public void orderAllocation(String OrderNumber, String CompleteSpecs, String CompleteSpecs2, String CompleteSpecs3,
			 String CompleteSpecs4, String CompleteSpecs5, String shipviaData) throws InterruptedException, AWTException {
try {
		if (!OrderNumber.equals(" ")) {
			if (CloseBrowser) {
				test = extent.createTest("::RateShop_Validation_USSG::");
			}

			CloseBrowser = false;

			// ...............................browser launched time starts
			// at.........................//

			long startTime = System.nanoTime();
			System.out.println(startTime);

			String GetTime = utilities.Timer();
			System.out.println("Browser Launched Time :" + GetTime);
			test.log(Status.PASS, "Browser Launched Time :" + GetTime);

			//......................................................................................//


			System.out.println("Browser Launched successfully");
			test.log(Status.PASS, "Browser Launched successfully");

			loginPage.verifyLogoExists();
			test.log(Status.PASS, "Manhattan Active Supply Chain logo is displayed");

			loginPage.enterUserName(USERNAME);
			test.log(Status.PASS, "Entered Username");
			addSrceenShot("Login", test, Capture);

			loginPage.clickSubmitUserName();
			test.log(Status.PASS, "Clicked on Submit Button");

			loginPage.enterPassword(PASSWORD);
			test.log(Status.PASS, "Entered Password");
			addSrceenShot("Login", test, Capture);

			loginPage.clickLogin();
			test.log(Status.PASS, "Clicked on Login Button");


			loginPage.resizeWebpage();
			test.log(Status.PASS, "Window resize");


			//  orders page check orders status and details			

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("orders");
			test.log(Status.PASS, "Entered MenuSearch as ASNs");

			dashboardPage.ordersclick();
			test.log(Status.PASS, "Clicked on Order Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			orderspage.enterOrdersSearch(OrderNumber, dashboardPage);
			test.log(Status.PASS, "Entered Order Search");
			addSrceenShot("Login", test, Capture);

			
			verifyCompleteSpecifics(test, readWebTable(orderspage.OrderTableHeader, orderspage.orderTableBody),
					CompleteSpecs, OrderNumber);
			test.log(Status.PASS, "DO verification completed");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			orderspage.selectOrderrecord();
			test.log(Status.PASS, "clicked on one record button");

			addSrceenShot("Login", test, Capture);

			// check rateshop validation

			orderspage.clickOLPNsDetails();
			test.log(Status.PASS, "clicked on order details button");

			orderspage.clickaddinfoRateShop();
			test.log(Status.PASS, "clicked on additional information button");

			addSrceenShot("Login", test, Capture);

			String shipvia = orderspage.verifyomsdesg();

			orderspage.clickCloseIcon();
			dashboardPage.clickRefresh();
			
			dashboardPage.clickRefresh();
			orderspage.selectAllRecord();
			test.log(Status.PASS, "clicked on one record button");
			addSrceenShot("Login", test, Capture);
						try {

				orderspage.clickToolRunwaveBtn();
				test.log(Status.PASS, "clicked on run wave button");
				addSrceenShot("Login", test, Capture);

			} catch (Exception e) {

				orderspage.btnThreedots();
				test.log(Status.PASS, "clicked on one threeDots button");

				orderspage.clickRunwaveInsideDots();
				test.log(Status.PASS, "clicked runwave at inside Dots");
				addSrceenShot("Login", test, Capture);

			}

			orderspage.enterWaveStatergy(" OPS - Standard Wave ");
			test.log(Status.PASS, "Selected The standard Wave");
			addSrceenShot("Login", test, Capture);

			orderspage.confirmSummit();
			test.log(Status.PASS, "clicked on one summit button");
			addSrceenShot("Login", test, Capture);
					//................................total timer start...................//

					long startTime1 = System.nanoTime();

					String GetTime2 = utilities.Timer();
					System.out.println("wave run start time is :"+GetTime2);
					test.log(Status.PASS, "wave run start time is :"+GetTime2);
					

					//..................................................................//			


					orderspage.olpnreleaseStatus(dashboardPage);
					test.log(Status.PASS, "waiting for new status update");

					test.log(Status.PASS, "waiting for new status update");
					System.out.println("New status changed successfully");
					addSrceenShot("Login", test, Capture);

					//.................................total time. end with timer.......................//			

			
					long endTime1 = System.nanoTime();

					String GetTime21 = utilities.Timer();
					System.out.println("Wave run started at Time is   :"+ GetTime21);
					test.log(Status.PASS, "Wave run started at Time is   :"+GetTime21);
					
					

					String totalTime11 =WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime1, endTime1);
					/* String s11=Long.toString(totalTime11); */
					System.out.println("The execution minutes is :"+totalTime11);  
					test.log(Status.PASS, "The Wave run Execution consumed time in Minutes  : "+ totalTime11);
					
					
					
					//.................................total time........................//		

				//  orders page check orders status and details			

					dashboardPage.clickMenuToggle();
					test.log(Status.PASS, "Clicked on menu Button");

					dashboardPage.enterMenuSearch("orders");
					test.log(Status.PASS, "Entered MenuSearch as ASNs");

					dashboardPage.ordersclick();
					test.log(Status.PASS, "Clicked on Order Button");

					dashboardPage.clearAllBtn();
					test.log(Status.PASS, "Cleared Selected Filter");

					utilities.toggleGridView(dashboardPage.GridViewButton);
					test.log(Status.PASS, "Clicked on grid button and viewed record details");

					orderspage.enterOrdersSearch(OrderNumber, dashboardPage);
					test.log(Status.PASS, "Entered Order Search");
					addSrceenShot("Login", test, Capture);

					
					verifyCompleteSpecifics(test, readWebTable(orderspage.OrderTableHeader, orderspage.orderTableBody),
							CompleteSpecs, OrderNumber);
					test.log(Status.PASS, "DO verification completed");

					utilities.toggleGridView(dashboardPage.GridViewButton);
					test.log(Status.PASS, "Clicked on grid button and viewed record details");

					orderspage.selectOrderrecord();
					test.log(Status.PASS, "clicked on one record button");

					addSrceenShot("Login", test, Capture);

					// check rateshop validation

					orderspage.clickOLPNsDetails();
					test.log(Status.PASS, "clicked on order details button");

					orderspage.clickaddinfoRateShop();
					test.log(Status.PASS, "clicked on additional information button");

					addSrceenShot("Login", test, Capture);

					String shipvia2 = orderspage.verifyomsdesg();

					orderspage.clickCloseIcon();
					
			
					
			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("olpns");
			test.log(Status.PASS, "Entered MenuSearch as OLPNS Page");

			dashboardPage.olpnclick();
			test.log(Status.PASS, "Clicked on OLPNS page Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			orderspage.searchOlpntextbox(OrderNumber, dashboardPage);
			test.log(Status.PASS, "status changed successfully");
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");
			
			
			orderspage.clickOlpnsRecord();

			addSrceenShot("Login", test, Capture);

			String shipviaOLPNSrecordpage = orderspage.shipViaOlpnsRecord();

			orderspage.clickOLPNsDetails();
			test.log(Status.PASS, "clicked on order details button");

			addSrceenShot("Login", test, Capture);

			
		try {
			
			String shipviaOLPNDetailsBtn = orderspage.verifyOlpnDetailsBtn();
			
			if (shipviaData.equals(shipviaOLPNDetailsBtn)) {
				test.log(Status.PASS, "Ship via checked successfully from Olpns Details Page Expected: " + shipviaData
						+ " and Actual: " + shipviaOLPNDetailsBtn);
				//addSrceenShot("Login", test, Capture);
			} else {
				test.log(Status.INFO, "Ship via checked successfully from Olpns Details Page Expected: " + shipviaData
						+ " and Actual: " + shipviaOLPNDetailsBtn);
				addSrceenShot("Login", test, true);
			}
			
			
			
		} catch (Exception e) {
			
			
		}
				

			orderspage.clickCloseIcon();


			waverunspage.clickExpandBar();
			test.log(Status.PASS, "Clicked on ExpandBar");
			addSrceenShot("Login", test, Capture);

			String wvrnid = waverunspage.waverunid();
			test.log(Status.PASS, "saved wave run ID");

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");

			// wave run to wra convertion process.............................//

			lsnPage.clickLpnMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("wave run");
			test.log(Status.PASS, "Entered MenuSearch as wave run");

			waverunspage.clickWaverunbtn();
			test.log(Status.PASS, "Clicked on waverun page  Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			dashboardPage.wavesearch(wvrnid,dashboardPage);// WaveId
			test.log(Status.PASS, "wave run ID search completed");
			addSrceenShot("Login", test, Capture);

			waverunspage.waveRunPageStatus(dashboardPage);

			// work release allocation status check process........

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("work release allocation");
			test.log(Status.PASS, "Entered MenuSearch as OLPNS Page");

			waverunspage.clickWRAmenuBtn();

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			waverunspage.enterOrderPlanIDSearch(wvrnid,dashboardPage);

			//...............................wave run time starts at.........................//

			long startTime2 = System.nanoTime();

			String GetTime3 = utilities.Timer();
			System.out.println("work release allocation process  start time is :"+GetTime3);
			test.log(Status.PASS, "work release allocation process  start time is :");
			test.log(Status.PASS, GetTime3);

			//......................................................................................//


			waverunspage.workReleasePage(dashboardPage);
			test.log(Status.PASS, "waiting for new status update");

			test.log(Status.PASS, "waiting for new status update");
			System.out.println("New status changed successfully");
			addSrceenShot("Login", test, Capture);


			//.................................total time. end with timer.......................//			

			

			long endTime2 = System.nanoTime();

			String GetTime4 = utilities.Timer();
			System.out.println("Work Release Allocated at Time is   :"+ GetTime4);
			test.log(Status.PASS, "Work Release Allocated at Time is   :"+GetTime4);
			
			

			
			
			String totalTime21 =WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime2, endTime2);
			/* String s11=Long.toString(totalTime11); */
			System.out.println("The execution minutes is :"+totalTime11);  
			test.log(Status.PASS, "The Wave run Execution consumed time in Minutes  : "+ totalTime21);
			
		

			//.................................total time........................//		


			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			verifyCompleteSpecifics(test, readWebTable(waverunspage.waveTableHeader, waverunspage.waveTableBody),
					CompleteSpecs4, wvrnid);
			test.log(Status.PASS, "DO verification completed");

			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");
			addSrceenShot("Login", test, Capture);

			batchlistpage.clickExpandBarbatch();
			test.log(Status.PASS, "Clicked on ExpandBar");

			String batchlistid = batchlistpage.getBatchNumber();
			test.log(Status.PASS, "Batch id saved");
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("batch list");
			test.log(Status.PASS, "Entered MenuSearch as Batch List");

			batchlistpage.clickbatchbutton();
			test.log(Status.PASS, "Clicked on Batch List Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			batchlistpage.batchsearch(batchlistid,dashboardPage); // B20220118001999 //batchlistid
			test.log(Status.PASS, "Entered Batch List current ID");
			addSrceenShot("Login", test, Capture);

			batchlistpage.selectonebatcRC();
			test.log(Status.PASS, "Clicked on one record");

			batchlistpage.clickReleaseBtn();
			test.log(Status.PASS, "Clicked on release button");
			addSrceenShot("Login", test, Capture);

			batchlistpage.clickYesBtn();
			test.log(Status.PASS, "Clicked on Yes button");
			addSrceenShot("Login", test, Capture);



			//...............................batch list time starts at.........................//

			long startTime3 = System.nanoTime();

			String GetTime5 = utilities.Timer();
			System.out.println("work release allocation process  start time is :"+ GetTime5);
			test.log(Status.PASS, "work release allocation process  start time is :");
			test.log(Status.PASS, GetTime5);

			//......................................................................................//




			batchlistpage.batchReleaseStatus(dashboardPage);
			test.log(Status.PASS, "waiting for new status update");

			test.log(Status.PASS, "waiting for new status update");
			System.out.println("New status changed successfully");
			addSrceenShot("Login", test, Capture);



			//.................................total time. end with timer.......................//			

			long endTime3 = System.nanoTime();

			String GetTime6 = utilities.Timer();
			System.out.println("Order get ship conformed Time is   :"+ GetTime6);
			test.log(Status.PASS, "Order get ship conformed Time is   :"+GetTime6);
			
			

			String totalTime31 =WMS_WebDriverUtilities.printExecutionTimeMinutes(startTime3, endTime3);
			/* String s31=Long.toString(totalTime31); */
			System.out.println("The execution minutes is :"+totalTime31);  
			test.log(Status.PASS, "The batch list released Execution consumed time in Minutes  : "+ totalTime31);
			
			
			
			

			//.................................total time........................//		


			utilities.toggleGridView(dashboardPage.GridViewButton);
			test.log(Status.PASS, "Clicked on grid button and viewed record details");

			dashboardPage.clickRefresh();

			verifyCompleteSpecifics(test, readWebTable(batchlistpage.batchTableHeader, batchlistpage.batchTableBody),
					CompleteSpecs5, batchlistid);
			addSrceenShot("Login", test, Capture);


//.............................................................................//
			
			dashboardPage.clickMenuToggle();
			test.log(Status.PASS, "Clicked on menu Button");

			dashboardPage.enterMenuSearch("olpns");
			test.log(Status.PASS, "Entered MenuSearch as OLPNS Page");

			dashboardPage.olpnclick();
			test.log(Status.PASS, "Clicked on OLPNS page Button");

			dashboardPage.clearAllBtn();
			test.log(Status.PASS, "Cleared Selected Filter");

			orderspage.searchOlpntextbox(OrderNumber, dashboardPage);
			test.log(Status.PASS, "status changed successfully");
			addSrceenShot("Login", test, Capture);

			dashboardPage.clickRefresh();
			test.log(Status.PASS, "Page refresh completed");
			
			
			orderspage.clickOlpnsRecord();

			addSrceenShot("Login", test, Capture);

			String shipviaOLPNSrecordpage2 = orderspage.shipViaOlpnsRecord();

			orderspage.clickOLPNsDetails();
			test.log(Status.PASS, "clicked on order details button");

			addSrceenShot("Login", test, Capture);

			
		try {
			
			String shipviaOLPNDetailsBtn2 = orderspage.verifyOlpnDetailsBtn();
			
			if (shipviaData.equals(shipviaOLPNDetailsBtn2)) {
				test.log(Status.PASS, "Ship via checked successfully from Olpns Details Page Expected: " + shipviaData
						+ " and Actual: " + shipviaOLPNDetailsBtn2);
				//addSrceenShot("Login", test, Capture);
			} else {
				test.log(Status.INFO, "Ship via checked successfully from Olpns Details Page Expected: " + shipviaData
						+ " and Actual: " + shipviaOLPNDetailsBtn2);
				addSrceenShot("Login", test, true);
			}
			
			
			
		} catch (Exception e) {
			
			
		}
				

			orderspage.clickCloseIcon();

			if (shipviaData.equals(shipvia)) {
				test.log(Status.PASS, "Ship via checked successfully from Orders Page Expected: " + shipviaData
						+ " and Actual: " + shipvia);
				//addSrceenShot("Login", test, Capture);
			} else {
				test.log(Status.INFO, "Ship via checked successfully from Orders Page Expected: " + shipviaData
						+ " and Actual: " + shipvia);
				addSrceenShot("Login", test, true);
			}

			
			
			

			if (shipviaData.equals(shipviaOLPNSrecordpage)) {
				test.log(Status.PASS, "Ship via checked successfully from OLPNS Record Page Expected: " + shipviaData
						+ " and Actual: " + shipviaOLPNSrecordpage);
				//addSrceenShot("Login", test, Capture);
			} else {
				test.log(Status.INFO, "Ship via checked successfully from OLPNS Record Page Expected: " + shipviaData
						+ " and Actual: " + shipviaOLPNSrecordpage);
				addSrceenShot("Login", test, true);
			}

			if (shipviaData.equals(shipvia2)) {
				test.log(Status.PASS, "Ship via checked successfully from OLPNS Details Page After WRA Expected: "
						+ shipviaData + " and Actual: " + shipvia2);
				//addSrceenShot("Login", test, Capture);
			} else {
				test.log(Status.INFO, "Ship via checked successfully from OLPNS Details Page After WRA Expected: "
						+ shipviaData + " and Actual: " + shipvia2);
				addSrceenShot("Login", test, true);
			}

			if (shipviaData.equals(shipviaOLPNSrecordpage2)) {
				test.log(Status.PASS, "Ship via checked successfully from OLPNS Record Page After WRA Expected: "
						+ shipviaData + " and Actual: " + shipviaOLPNSrecordpage2);
				//addSrceenShot("Login", test, Capture);
			} else {
				test.log(Status.INFO, "Ship via checked successfully from OLPNS Record Page Expected: " + shipviaData
						+ " and Actual: " + shipviaOLPNSrecordpage2);
				addSrceenShot("Login", test, true);
			}

			

			System.out.println("ShipVia Succesfully verified");
			test.log(Status.PASS, "ShipVia Succesfully verified");

		
		}
	}
	catch (Exception e) {
		System.out.println("Test case got failed"+ e);
		test.log(Status.FAIL, "Test case got failed");
	}
		
	}

	

		@AfterMethod
		public void setUpend() {
			testactions.updateTestRailTestRunStatus("4897169", "pass", "USSG RATESHOP VALIDATION", "USSG RATESHOP VALIDATION is done");

			extent.flush();
			driver.quit();
		}
	}
