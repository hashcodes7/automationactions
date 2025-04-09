package P1_Testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC167_P1_AssociateSupplierToSundries extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	MaterialPage materialPage;

	boolean Capture = true;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(PDS_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			materialPage = new MaterialPage(driver);
			setReport("TC167_P1_AssociateSupplierToSundries verification");
		}
	}

	@Test(priority = 0, dataProvider = "associateSupplier_Sundries_Data", dataProviderClass = DataProviders.class)
	public void P1_TC167_AssociateSupplierToSundries(String TestType, String materialType, String materialName, String supplier)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC167_P1_AssociateSupplierToSundries verification:::");
		}

		CloseBrowser = false;

		try {

			test.log(Status.INFO, "This test case covers P1 material module from TC167 to TC173");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " + PDS_URL);
			addSrceenShot("Login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left panel");
			test.log(Status.INFO, "Clicked on open Left panel");
			addSrceenShot("Clicked on open Left panel", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material");
			WaitforPage(4000);

//			String materialType = "Buttons";
			materialPage.selectMaterialType(materialType, test);
			System.out.println("Sundries Record Type Was choosen");
			test.log(Status.INFO, "Sundries Record Type Was choosen: " + materialType);
			addSrceenShot("Sundries Record Type Was choosen", test, Capture);
			WaitforPage(4000);

//			String materialName = "S231114 Button Demo_sundries_material_02";
			materialPage.searchMaterial(materialName, test);
			System.out.println("Searched for the Material");
			test.log(Status.INFO, "Searched for the Material: " + materialName);
			addSrceenShot("Searched for the Material", test, Capture);
			WaitforPage(4000);

//			String supplier = "3M INDUSTRIAL ADHESIVE & TAPES 603112 US";
			materialPage.addSupplier(supplier, test);
			System.out.println("Searched and selected supplier");
			test.log(Status.INFO, "Searched and selected supplier:: " + supplier);
			addSrceenShot("Searched and selected supplier:", test, Capture);
			WaitforPage(5000);

			boolean isSupplierInDropdown = materialPage.verifySupplierInDropdown(supplier, test);
			if (isSupplierInDropdown) {
				System.out.println("Supplier appears in the dropdown menu for the material.");
				test.log(Status.PASS, "Verification: Supplier appears in the dropdown menu for the material.");
				addSrceenShot("Supplier appears in the dropdown menu for the material", test, Capture);
			} else {
				System.out.println("Supplier does not appear in the dropdown menu for the material.");
				test.log(Status.FAIL, "Supplier does not appear in the dropdown menu for the material.");
				addSrceenShot("Supplier does not appear in the dropdown menu for the material", test, Capture);
			}

			boolean isNoColorInDropdown = materialPage.verifyNoColorInDropdown(test);
			if (isNoColorInDropdown) {
				System.out.println("'No color' created under 'Colors' tab for the material-supplier combination");
				test.log(Status.PASS,
						"Verification: 'No color' created under 'Colors' tab for the material-supplier combination");
				addSrceenShot("'No color' created under 'Colors' tab for the material-supplier combination", test,
						Capture);
			} else {
				System.out.println("'No color' does not appear in the Material color dropdown.");
				test.log(Status.FAIL, "'No color' does not appear in the Material color dropdown.");
				addSrceenShot("'No color' does not appear in the Material color dropdown", test, Capture);
			}

			boolean isPrimaryIndicatorSet = materialPage.verifyPrimaryIndicatorSet(test);
			if (isPrimaryIndicatorSet) {
				System.out.println(
						"Primary indicator on Material supplier is set to Yes for first Supplier added to Material.");
				test.log(Status.PASS,
						"Verification: Primary indicator on Material supplier is set to Yes for first Supplier added to Material.");
				addSrceenShot(
						"Primary indicator on Material supplier is set to Yes for first Supplier added to Material",
						test, Capture);
			} else {
				System.out.println(
						"Primary indicator on Material supplier is not set to Yes for first Supplier added to Material.");
				test.log(Status.FAIL,
						"Primary indicator on Material supplier is not set to Yes for first Supplier added to Material.");
				addSrceenShot(
						"Primary indicator on Material supplier is not set to Yes for first Supplier added to Material",
						test, Capture);
			}

			boolean isPriceUOMUpdated = materialPage.verifyPriceUOMUpdated(test);
			if (isPriceUOMUpdated) {
				System.out.println("Price UOM on Material Supplier is updated from UOM attribute on Material.");
				test.log(Status.PASS,
						"Verification: Price UOM on Material Supplier is updated from UOM attribute on Material.");
				addSrceenShot("Price UOM on Material Supplier is updated from UOM attribute on Material", test,
						Capture);
			} else {
				System.out.println("Price UOM on Material Supplier is not updated from UOM attribute on Material.");
				test.log(Status.FAIL, "Price UOM on Material Supplier is not updated from UOM attribute on Material.");
				addSrceenShot("Price UOM on Material Supplier is not updated from UOM attribute on Material", test,
						Capture);
			}
			
			boolean isStagingRowIdUpdated = materialPage.verifyStagingRowIdUpdated(supplier,test);
			if (isStagingRowIdUpdated) {
			    System.out.println("Material supplier staging row id is updated on the Material Supplier Details Page.");
			    test.log(Status.PASS, "Verification: Material supplier staging row id is updated on the Material Supplier Details Page.");
			    addSrceenShot("Material supplier staging row id is updated on the Material Supplier Details Page", test, Capture);
			} else {
			    System.out.println("Material supplier staging row id is not updated on the Material Supplier Details Page in PDS.");
			    test.log(Status.INFO, "Material supplier staging row id is not updated on the Material Supplier Details Page in PDS.");
			    addSrceenShot("Material supplier staging row id is not updated on the Material Supplier Details Page in PDS.", test, Capture);
			}

			WaitforPage(4000);
			
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
