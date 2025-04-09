package P1_Testcases;

import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Measurements_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC06_P1_Techpack_GenerateTechpack_usingMeasurementsPage extends WMS_TestBase{
	
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Measurements_Page MeasurementsPage;
	LineSheetPage lineSheetPage;
	
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
			LaunchSpecific_URL(Admin_URL_STG);
			
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			MeasurementsPage= new Measurements_Page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			lineSheetPage = new LineSheetPage(driver);
			
			setReport("TC06_P1_Techpack_GenerateTechpack_usingMeasurementsPage");
		}
	}
	@Test(priority = 0, dataProvider = "TC06_P1_Techpack_GenerateTechpack_usingMeasurementsPage", dataProviderClass = DataProviders.class)

	public void P1_TC06_Techpack_GenerateTechpack_usingMeasurementsPage(String TestType,String season,String linesheetview,String filterproduct
			,String source,String specifications,String  requesttype) throws Exception {
		
		if (CloseBrowser) {
			test = extent.createTest(":::TC06_P1_Techpack_GenerateTechpack_usingMeasurementsPage:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_277 to TC_280");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");	
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully and The URL is: "+ Admin_URL_STG);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addSrceenShot("opened left panel", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			MeasurementsPage.SeasonDropdown(season);
			test.log(Status.INFO, "Season value seleted:"+season);
			addSrceenShot("Season value seleted"+season, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			dashboardPage.closeLeftPanel();
			test.log(Status.INFO, "Closed Left panel");
			addSrceenShot("Closed Left panel", test, Capture);
			
			Thread.sleep(1000); 

			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addSrceenShot("Linesheet view changed", test, Capture);

			MeasurementsPage.filter_product(filterproduct,test);
			test.log(Status.INFO, "clicked on product "+filterproduct);
			addSrceenShot("clicked on product ", test, Capture);
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);

			MeasurementsPage.selectSource(source,test);
			test.log(Status.INFO, "Selected source "+source);
			addSrceenShot("Selected source "+source, test, Capture);
			System.out.println("Selected source "+source);
			Thread.sleep(3000);
			MeasurementsPage.selectSpecifications(specifications,test);
			test.log(Status.INFO, "Selected specifications "+specifications);
			addSrceenShot("Selected specifications "+specifications, test, Capture);
			System.out.println("Selected specifications "+specifications);
			Thread.sleep(3000);
			MeasurementsPage.NavigetTo_measurementSummary();
			test.log(Status.INFO, "Navigated to specifications summary page ");
			addSrceenShot("Navigated to specifications summary page  ", test, Capture);
			System.out.println("Navigated to specifications summary page   ");
			WaitforPage(10000);
			
			String components=MeasurementsPage.NavigateTo_GenerateTechpack();
			test.log(Status.INFO, "Navigated to specifications techpack page ");
			addSrceenShot("Navigated to specifications techpack page  ", test, Capture);
			System.out.println("Navigated to specifications techpack page   ");
			Thread.sleep(3000);
			
			MeasurementsPage.Validate_AvailableComponents(components,test);
			test.log(Status.PASS, "Validations successful for specification components ");
			addSrceenShot("Validations successful for specification components  ", test, Capture);
			System.out.println("Validations successful for specification components ");
			
			Thread.sleep(2000);
			
			MeasurementsPage.GenerateTechpack_UsingMeasurements(requesttype,test);
			test.log(Status.PASS, "Techpack generated successfully and the file is downloaded ");
			addSrceenShot("Techpack generated successfully and the file is downloaded  ", test, Capture);
			System.out.println("Techpack generated successfully and the file is downloaded ");
			Thread.sleep(3000);
			
			MeasurementsPage.NavigetTo_measurementSummary();
			Thread.sleep(3000);
			
			MeasurementsPage.Validate_generatedTechPack(test);
			test.log(Status.PASS, "Validation successful and the file is downloaded ");
			addSrceenShot("Validation successful and the file is downloaded   ", test, Capture);
			System.out.println("Validation successful and the file is downloaded  ");
			
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
