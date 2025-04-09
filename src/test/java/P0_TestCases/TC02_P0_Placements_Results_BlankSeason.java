package P0_TestCases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CustomLoaders_page;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC02_P0_Placements_Results_BlankSeason extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	CustomLoaders_page customLoadersPage;
	
	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();
	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			customLoadersPage = new CustomLoaders_page(driver);
			
			setReport("TC02_P0 Verify Error message for blank seasoncode in placement file");
		}
	}

	@Test(priority = 0,dataProvider = "TC_02_P0_Placements_Results_BlankSeason", dataProviderClass = DataProviders.class)
	public void P0_TC_02_Placement_BlankSeasonCode(String TestType,String uploadFilepath,String resultFilepath,String filetype) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC02_P0 Verify Error message for blank seasoncode in placement file:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This Testcase covers TC_189 to TC_190");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully"+URL);
			test.log(Status.INFO, "login to flex PLM application successfully"+URL);
			
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.LibraryMenu(MainMenuEnum.REPORTS.menu(), MainMenuEnum.REPORTS_LoadFile.menu());
			test.log(Status.INFO, "Clicked on Reports Load file ");
			addSrceenShot("Clicked on Reports Load file ", test, Capture);
			
			WaitforPage(2000);
			customLoadersPage.selectFileType(filetype);
			test.log(Status.INFO, "File type selected is:   "+filetype);
			addSrceenShot("File type selected ", test, Capture);
			
			customLoadersPage.uploadFile(uploadFilepath);
			System.out.println("file uploaded");
			test.log(Status.INFO, "File uploaded");
			addSrceenShot("File uploaded", test, Capture);
			Thread.sleep(5000);
			
			String result=customLoadersPage.ValidatePlacementLoaderResult(resultFilepath);
			String[] str=result.split(",");
			if(str[0].equalsIgnoreCase("Error")) {
				test.log(Status.INFO, "Result is: "+str[0]);
				test.log(Status.INFO, "Message is: "+str[1]);
				if(str[1].equals("Season Code is not provided in the load file")) {
					test.log(Status.PASS, "Correct Error message is populating in sheet");
				}
			}
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);
			
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addSrceenShot("Clicked on Logout successful", test, Capture);
			
		} catch (Exception e) {
			System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness");
		throw e;
		}
	}
	
	@AfterMethod
	public void setUpend() {
		extent.flush();
		driver.quit();
	}

}
