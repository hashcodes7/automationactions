package com.WMS_Utilities;



import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;



public class WMS_TestBase implements WMS_GlobalProperties {

	WebDriver driver;
	public ExtentReports extent;
	public ExtentHtmlReporter htmlReporter;
	public ExtentTest test;
	public boolean CloseBrowser=true;

	public WebDriver invokeBrowser() throws InterruptedException {


		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability(ChromeOptions.CAPABILITY,options);
		//System.setProperty(CHROME_KEY,CHROME_PATH);
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,"50"));
		System.out.println("get browser size  -- Keys.CONTROL,\"80\"" );
		//driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,"0"));
		System.out.println("get browser size  -- Keys.CONTROL,\"0\"" );
		/*
		 * for(int i=0; i<5; i++){
		 * driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,"80")
		 * ); }
		 */
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("document.body.style.transform='scale(0.4)';");
		 * System.out.println("get browser size  -- Keys.CONTROL,\"0\"" );
		 */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;

	}


	public void launchUrl() {

		driver.get(URL);

	}

	public void launchUr2() {

		driver.get(URL2);

	}

	
	public void URLTimeStamp() {

		driver.get(URLTimeScreenSots);

	}


	public void openNewWindow() {
		
		
	
String n = Keys.chord(Keys.CONTROL,Keys.ENTER);
driver.findElement(By.id("open-tab")).sendKeys(n);


}
	/*
	 * Creates an array of HashMaps with columnname-rowvalue pair with the webtable
	 */
	public List <HashMap<String, String>> readWebTable(WebElement headerTable, WebElement dataTable){


		List<HashMap<String, String>> data_WebTable = new ArrayList<HashMap<String, String>>();
		List<WebElement> headerFields = null;



		headerFields = headerTable.findElements(By.xpath("./datatable-header-cell/div/span/span"));
		List<WebElement> dataRows = dataTable.findElements(By.xpath("./datatable-row-wrapper/datatable-body-row/div[contains(@class,'datatable-row-center')]"));	

		for(WebElement row : dataRows) {
			HashMap<String, String> dataRow = new HashMap<String, String>();
			List<WebElement> dataFields = row.findElements(By.xpath("./datatable-body-cell/div/div"));

			if (headerFields.size() == dataFields.size()) {
				for (int i = 0; i < headerFields.size(); i++) {
					dataRow.put(headerFields.get(i).getAttribute("innerText").trim(), dataFields.get(i).getAttribute("innerText").trim());
					System.out.println(headerFields.get(i).getAttribute("innerText").trim()+":"+dataFields.get(i).getAttribute("innerText").trim());
				}
				System.out.println("-------------------");
				data_WebTable.add(dataRow);
			}

		}
		//System.out.println("-------------------");
		return data_WebTable;		
	}

	public String returnFieldValueForTable(List <HashMap<String, String>> data_ItemTable,String Key,String Field){
		String FieldValue=null;

		for(HashMap<String, String> row : data_ItemTable) {

			if(row.containsValue(Key)) {
				if(row.containsKey(Field)) {
					System.out.println("::::ReturnFieldValue::::");
					FieldValue=row.get(Field);
					System.out.println(Field+":"+row.get(Field));
				}
			}
		}
		return FieldValue;
	}

	/*
	 * Select Single row from table using a key
	 */
	public WebElement selectSingleRow(String Key) {
		String FindStringStart = "//*[contains(text(),'";
		String FindStringEnd = "')]/parent::div/parent::datatable-body-cell/parent::div/parent::datatable-body-row/div[@class='datatable-row-group datatable-row-left ng-star-inserted']/datatable-body-cell/div/label/input";
		String FindElementString= FindStringStart + Key + FindStringEnd;
		WebElement getCheckBox;

		getCheckBox = driver.findElement(By.xpath(FindElementString));
		return getCheckBox;
	}

	/*
	 * Get LPN Expected Data
	 */
	public String getUserInputFieldData(String CompleteSpecs,String fieldName)
	{  
		String returnFieldVal = null;
		for(String fieldValueVerify: CompleteSpecs.split("-")) {
			//Split user input
			String verificationFieldValue[] = fieldValueVerify.split(":");
			if(verificationFieldValue[0].equals(fieldName)) {
				returnFieldVal=verificationFieldValue[1];
			}
		}
		return returnFieldVal;
	}

	/*
	 * Verify data for Key from application data table based on user input
	 */

	public void verifyCompleteSpecifics(ExtentTest testParam, List <HashMap<String, String>> data_WebTable,String CompleteSpecs,String Key) {
		boolean found = false;
		testParam.log(Status.INFO, "Searching for Key " + Key);
		//Print log after verification from application table
		for(HashMap<String, String> row : data_WebTable) {
			//if key matches then check verification value
			if(row.containsValue(Key)) {
				//if verification field does'nt exist then user fault
				System.out.println("Found Key " + Key);
				testParam.log(Status.PASS,"Found Key " + Key);

				found=true;
				//split the User input - each two contains Key Value pair to be checked
				for(String fieldValueVerify: CompleteSpecs.split("-")) {
					//System.out.println(fieldValueVerify);

					//Split user input
					String verificationFieldValue[] = fieldValueVerify.split(":");

					if(row.containsKey(verificationFieldValue[0])) {
						testParam.log(Status.PASS, "Field Value "+verificationFieldValue[0]+" exists" );
						//check field value
						if(row.get(verificationFieldValue[0]).equals(verificationFieldValue[1])) {
							testParam.log(Status.PASS, "Expected value for "+verificationFieldValue[0] + " : " + verificationFieldValue[1]+" matches actual value :" + row.get(verificationFieldValue[0]) );
							System.out.println("Expected value for "+verificationFieldValue[0] + " : " + verificationFieldValue[1]+" matches actual value :" + row.get(verificationFieldValue[0]));
						}else {
							testParam.log(Status.PASS, "Expected value for "+verificationFieldValue[0]+" : "+ verificationFieldValue[1]+" doesnt match actual value :" + row.get(verificationFieldValue[0]) );
							System.out.println("Expected value for "+verificationFieldValue[0]+" : "+ verificationFieldValue[1]+" doesnt match actual value :" + row.get(verificationFieldValue[0]) );
						}
					}else{
						testParam.log(Status.INFO, "Field Value "+verificationFieldValue[0]+" doesnt exist" );
						System.out.println("Field Value "+verificationFieldValue[0]+" doesnt exist" );

					}

				}

				if(found) {
					break;
				}
			}
		}

		if(!found) {
			testParam.log(Status.FAIL, "Field Value "+Key+" doesnt exist" );
			System.out.println("Field Value "+Key+" doesnt exist" );
		}
	}

	public void WaitforPage(int i) throws InterruptedException {
		Thread.sleep(i);
	}

	
	public void addSrceenShot(String TestName,ExtentTest testparam, boolean Capture)  {
		
		
		
		if(Capture)	{
			try {
				WMS_WebDriverUtilities webdriverUtils = new WMS_WebDriverUtilities(driver);
				
				
				String screenshotpath = webdriverUtils.takeScreenshot(TestName);
				testparam.addScreenCaptureFromPath(screenshotpath);
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");// 333333333333333000000
				LocalDateTime now = LocalDateTime.now();
				String SerialNo = dtf.format(now).toString()+"0";
				System.out.println("Execution Time is  : "+SerialNo);
				
			}catch(Exception e) {
				System.out.println("Screenshot Failed");
			}
		
			
		}
	}
	
	
	

	public String autoGenSerialNo() throws InterruptedException {

		WaitforPage(4000);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddmmSSSSddSSSS");// 333333333333333000000
		LocalDateTime now = LocalDateTime.now();
		String SerialNo = dtf.format(now).toString()+"0";
		System.out.println("Test case Number is : "+SerialNo);
		WaitforPage(4000);
		return SerialNo;


	}

	public void setReport(String ReportName) throws InterruptedException {
		System.out.println("ReportName is : "+ReportName);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\"+ ReportName + autoGenSerialNo()+".html");
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		htmlReporter.config().setDocumentTitle("WMS Automation");
		htmlReporter.config().setReportName("WMS Automation-Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		

	}



	@BeforeTest

	public void CreateSummary() {

		System.out.println("Statrting test");


	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()){
			test.log(Status.FAIL, "Test Case Failed Is "+result.getName());
			test.log(Status.FAIL, "Test Case Failed Is "+result.getThrowable());			
			WMS_WebDriverUtilities webdriverUtils = new WMS_WebDriverUtilities(driver);
			String screenshotpath = webdriverUtils.takeScreenshot(result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
		}else if (result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP, "Test Case Skipped Is "+result.getName());	
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Passed Is "+result.getName());	
		}
		if(CloseBrowser) {
			driver.quit();
			extent.flush();
		}

	}


	@AfterTest

	public void tearDown() {

		if(CloseBrowser) {
			 driver.quit(); 
			extent.flush();
		}



	}



}
