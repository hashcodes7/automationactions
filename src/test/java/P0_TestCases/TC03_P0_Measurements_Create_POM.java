package P0_TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Measurements_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public  class TC03_P0_Measurements_Create_POM extends WMS_TestBase{
	
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Measurements_Page MeasurementsPage;
	
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
			setReport("TC03_P0 Create POM points Template");
		}
	}
	@Test(priority = 0, dataProvider = "TC03_P0_Measurements_Create_POM", dataProviderClass = DataProviders.class)

	public void TC_03_P0_CreateNewPOMpoints(String TestType,String template,String pomdescription,String pomId) throws Exception {
		
		if (CloseBrowser) {
			test = extent.createTest(":::TC03_P0 Create POM points Template:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_161 to TC_166");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");	
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully "+ URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addSrceenShot("opened left panel", test, Capture);
			
			mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MEASUREMENTS.menu());
			test.log(Status.INFO, "Clicked on Measurements menu ");
			addSrceenShot("Clicked on Measurements menu ", test, Capture);
			
			Thread.sleep(5000);

			MeasurementsPage.SelectTemplate(template);
			test.log(Status.INFO, "Template is selected: "+template);
			addSrceenShot("Template is selected ", test, Capture);

			MeasurementsPage.Create_New_POMpoints(pomdescription,pomId,test);
			test.log(Status.INFO, "New POM template created with name:  "+pomdescription);
			addSrceenShot("New POM template created  ", test, Capture);
			
			Thread.sleep(5000);
			MeasurementsPage.POM_Template_Validation(pomdescription,test);
			test.log(Status.PASS, "Validated New POM template "+pomdescription);
			addSrceenShot("Validated New POM template  ", test, Capture);
			
			MeasurementsPage.Delete_pom(pomdescription, test);
			test.log(Status.PASS, "Deleted POM template "+pomdescription);
			addSrceenShot("POM template deleted ", test, Capture);
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addSrceenShot("Logout successful", test, Capture);
						
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

