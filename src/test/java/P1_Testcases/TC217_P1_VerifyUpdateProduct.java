package P1_Testcases;

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
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC217_P1_VerifyUpdateProduct extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;

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
			LaunchSpecific_URL(Global_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("TC217_P1_UpdateProduct verification");
		}
	}

	@Test(priority = 0, dataProvider = "updateProductData", dataProviderClass = DataProviders.class)
	public void P1_TC217_VerifyUpdateProduct(String TestType, String season, String productName,
			String updatedProductName, String updatedBrandHierarchy, String updatedClassValue,
			String updatedSubClassValue, String updatedProSubCat1, String updatedProSubCat2, String updatedConsumer,
			String updatedConsumerGrp1, String updatedConsumerGrp2, String updatedCustomsClassification)
			throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC217_P1_UpdateProduct verification:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This test case covers P1 Product module from TC217 to TC219");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: - URL-" + Global_URL);
			addSrceenShot("Login successful", test, Capture);

			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String season = "Levi's S1 2023 Male Accessories";
			mainMenuPage.chooseMySeasonType(season);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + season);
			addSrceenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

			try {

//				String productName = "New_Test_Aum_02";
				lineSheetPage.filterProductByName(productName, test);
				System.out.println("Clicked on product name");
				test.log(Status.INFO, "Clicked on product name: " + productName);
				addSrceenShot("Clicked on product name", test, Capture);

				Assert.assertTrue(productPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
				System.out.println("PC5 Details Page is displayed");
				test.log(Status.PASS, "PC5 Details Page is displayed: " + productName);
				addSrceenShot("PC5 Details Page is displayed", test, Capture);

				productPage.editProduct();
				test.log(Status.INFO, "Clicked on Update Product from the Actions dropdown");
				addSrceenShot("Clicked on Update Product from the Actions dropdown", test, Capture);
				WaitforPage(5000);

//				String updatedProductName = "New_Test_Aum_03";
//				String updatedBrandHierarchy = "RT Premium";
//				String updatedClassValue = "Bags";
//				String updatedSubClassValue = "Backpack";
//				String updatedProSubCat1 = "Bags";
//				String updatedProSubCat2 = "Backpack";
//				String updatedConsumer = "Mens";
//				String updatedConsumerGrp1 = "Adult Mens";
//				String updatedConsumerGrp2 = "Regular";
//				String updatedCustomsClassification = "Accessories";

				productPage.updateProduct(updatedProductName, updatedBrandHierarchy, updatedClassValue,
						updatedSubClassValue, updatedProSubCat1, updatedProSubCat2, updatedConsumer,
						updatedConsumerGrp1, updatedConsumerGrp2, updatedCustomsClassification, test);
				test.log(Status.INFO, "Updated product details");
				addSrceenShot("Updated product details", test, Capture);
				WaitforPage(4000);

				productPage.clikOnSaveBtn();
				test.log(Status.INFO, "Clicked on save button successfully");
				addSrceenShot("Clicked on save button successfully", test, Capture);
				WaitforPage(2000);

				// Verify product update
				boolean isUpdated = productPage.verifyUpdatedProductAttributes(updatedProductName,
						updatedBrandHierarchy, updatedClassValue, updatedSubClassValue, updatedProSubCat1,
						updatedProSubCat2, updatedConsumer, updatedConsumerGrp1, updatedConsumerGrp2,
						updatedCustomsClassification, test);
				if (isUpdated) {
					test.log(Status.PASS, "Product update verification--- Product is updated with updated attributes.");
					addSrceenShot("Product update verification", test, Capture);
				} else {
					test.log(Status.FAIL, "Product update verification: Failed");
					addSrceenShot("Product update verification", test, Capture);
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

		} catch (

		Exception e) {
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