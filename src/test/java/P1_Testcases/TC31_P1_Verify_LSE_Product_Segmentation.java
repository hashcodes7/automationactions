package P1_Testcases;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Colorway_page;

import com.WMS_ApplicationPages.Copy_carryover_page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC31_P1_Verify_LSE_Product_Segmentation extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	Colorway_page Colorwaypage;


	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	boolean Capture = true;
	private String global_URL;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();
	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			global_URL = Global_URL;
			LaunchSpecific_URL(global_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage = new Colorway_page(driver);


			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			setReport("TC31_P1_Verify_LSE_Product_Segmentation");
		}
	}

	@Test(priority = 0, dataProvider = "TC31_P1_Verify_LSE_Product_Segmentation", dataProviderClass = DataProviders.class)
	public void P1_TC08_Verify_LSE_Product_Segmentation(String TestType, String season, String linesheetview,
			String colorWay, String businessObject) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC31_P1_Verify_LSE_Product_Segmentation:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers P1 Colorway module from TC31");

			System.out.println("login to flex PLM application successfully ");
			test.log(Status.INFO, "login to flex PLM application successfully: URL -  " + global_URL);
			addSrceenShot("login successful", test, Capture);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addSrceenShot("opened left panel", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			WaitforPage(4000);

//			String season = "Levi's S1 2023 Male Accessories";
			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "Season selected: " + season);
			addSrceenShot("Season selected:" + season, test, Capture);
			WaitforPage(4000);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(4000);

//			String linesheetview = "Adoption";
			LineSheetEditPage.filter_View_Change(linesheetview, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview);
			addSrceenShot("Linesheet view changed", test, Capture);
			WaitforPage(5000);

//			String colorWay = "0WPGZ-0011 LUCEE TEST213";
			Colorwaypage.SelectColorway(colorWay, test);
			test.log(Status.INFO, "colorway selected: " + colorWay);
			addSrceenShot("colorway selected", test, Capture);

			Colorwaypage.editColorWay();
			test.log(Status.INFO, "Clicked On Edit Colorway from the Menu");
			addSrceenShot("Clicked On Edit Colorway from the Menu", test, Capture);
			WaitforPage(5000);

			// Store all product segmentation LSE values in a list
			List<String> lseValues = Colorwaypage.getLSEValues(test);
			test.log(Status.INFO, "Stored LSE values: " + String.join(", ", lseValues));
			addSrceenShot("Stored LSE values", test, Capture);

			String Brand = Colorwaypage.getBrand();
			System.out.println("Brand Value: " + Brand);
			test.log(Status.INFO, "Brand Value: " + Brand);

			String ProductCategory = Colorwaypage.getProductCategory();
			System.out.println("Product Category Value: " + ProductCategory);
			test.log(Status.INFO, "Product Category Value: " + ProductCategory);

			String ConsumerGroup1 = Colorwaypage.getConsumerGroup1();
			System.out.println("Consumer Group1: " + ConsumerGroup1);
			test.log(Status.INFO, "Consumer Group1: " + ConsumerGroup1);

			Colorwaypage.openNewTabAndNavigateToBusinessObject(global_URL, test);
			System.out.println("Opened new tab and navigated to the Business Object Library");
			test.log(Status.INFO, "Opened new tab and navigated to the Business Object Library");
			addSrceenShot("Opened new tab and navigated to the Business Object Library", test, Capture);
			WaitforPage(4000);

//			String businessObject = "Product Segmentation";
			Colorwaypage.selctBusinessObject(businessObject);
			System.out.println("Selected Business Object: " + businessObject);
			test.log(Status.INFO, "Selected Business Object: " + businessObject);
			addSrceenShot("Selected Business Object: ", test, Capture);
			WaitforPage(4000);

			Colorwaypage.fillProductSegmentationLSEDetails(Brand, ProductCategory, ConsumerGroup1, test);
			test.log(Status.INFO, "Filled in Product Segmentation details");
			addSrceenShot("Filled in Product Segmentation details", test, Capture);
			WaitforPage(4000);

			List<String> tableValues = Colorwaypage.getTableValues(test);
			test.log(Status.INFO,
					"Lookup Tables\\Product Segmentation table values: " + String.join(", ", tableValues));
			addSrceenShot("Lookup Tables\\Product Segmentation table values", test, Capture);

			boolean allValuesPresent = true;
			List<String> missingValues = new ArrayList<>();
			for (int i = 1; i < lseValues.size(); i++) { // Start from index 1 to skip the first empty value
				if (!tableValues.contains(lseValues.get(i))) {
					allValuesPresent = false;
					missingValues.add(lseValues.get(i));

				}
			}

			if (allValuesPresent) {
				test.log(Status.PASS, "All LSE values are present in the Lookup Table\\Product Segmentation table");
				test.log(Status.PASS, "LSE Product Segmentation values are derived from Brand: " + Brand
						+ ", Product Category: " + ProductCategory + ", Consumer Group 1: " + ConsumerGroup1);
				addSrceenShot("All LSE values are present in the Lookup Tables\\Product Segmentation table", test,
						Capture);
			} else {
				test.log(Status.FAIL, "Some LSE values are missing in the Lookup Tables\\Product Segmentation table");
				addSrceenShot("Some LSE values are missing in the Lookup Tables\\Product Segmentation table", test,
						Capture);
				test.log(Status.INFO, "Missing LSE values: " + String.join(", ", missingValues));

			}
			WaitforPage(4000);

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
