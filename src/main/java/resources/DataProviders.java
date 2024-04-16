package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.ExtentReports;

import com.WMS_Utilities.WMS_GlobalProperties;

public class DataProviders implements WMS_GlobalProperties {

	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;
	public ExtentReports extent;
	
	
	@DataProvider(name = "WMS_PAST_Gift_Card")
    public static Iterator<Object[]> WMS_PAST_Gift_Card() throws InvalidFormatException, IOException {
        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        String filePath = System.getProperty("user.dir") + FILEPATH;
        File file = new File(filePath + "\\" + FILENAMESECOUND);
        FileInputStream inputStream = new FileInputStream(file);
        @SuppressWarnings("resource")
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet("PackWrap");
        int numOfRows = sheet.getLastRowNum();
        String OrderNumber, OrderNumber2, CompleteSpecs1, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
                CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1, TotUserKey2, TotUserKey3, TotUserKey4,
                LocationKey, CartUserKey1, CartUserKey2, CompleteSpecs8, CompleteSpecs9, PackStation, sortloc1,
                sortloc2, chasewall;
        for (int i = 1; i <= numOfRows; i++) {
            OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
            OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
            CompleteSpecs1 = sheet.getRow(i).getCell(2).getStringCellValue();
            CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
            CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
            CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
            CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
            CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
            CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
            TotUserKey1 = sheet.getRow(i).getCell(9).getStringCellValue();
            TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
            TotUserKey3 = sheet.getRow(i).getCell(11).getStringCellValue();
            TotUserKey4 = sheet.getRow(i).getCell(12).getStringCellValue();
            LocationKey = sheet.getRow(i).getCell(13).getStringCellValue();
            CartUserKey1 = sheet.getRow(i).getCell(14).getStringCellValue();
            CartUserKey2 = sheet.getRow(i).getCell(15).getStringCellValue();
            CompleteSpecs8 = sheet.getRow(i).getCell(16).getStringCellValue();
            CompleteSpecs9 = sheet.getRow(i).getCell(17).getStringCellValue();
            PackStation = sheet.getRow(i).getCell(18).getStringCellValue();
            sortloc1 = sheet.getRow(i).getCell(19).getStringCellValue();
            sortloc2 = sheet.getRow(i).getCell(20).getStringCellValue();
            chasewall = sheet.getRow(i).getCell(21).getStringCellValue();
            myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs1, CompleteSpecs2, CompleteSpecs3,
                    CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1, TotUserKey2,
                    TotUserKey3, TotUserKey4, LocationKey, CartUserKey1, CartUserKey2, CompleteSpecs8, CompleteSpecs9,
                    PackStation, sortloc1, sortloc2, chasewall });
        }
        return myData.iterator();
    }
	
		
	@DataProvider(name = "DR_Receiving")
    public static Iterator<Object[]> SingleSkuDRReceiving() throws InvalidFormatException, IOException {
                  ArrayList<Object[]> myData = new ArrayList<Object[]>();
                  String filePath = System.getProperty("user.dir") + FILEPATH;
          		File file = new File(filePath + "\\" + FILENAME);
          		FileInputStream inputStream = new FileInputStream(file);
          		@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	sheet = workbook.getSheet("ASN_Single_LPN");
	int numOfRows = sheet.getLastRowNum();
	String Asn_ID, Lpn_ID, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, CartID;

	for (int i = 1; i <= numOfRows; i++) {
		Asn_ID= sheet.getRow(i).getCell(0).getStringCellValue();
		Lpn_ID = sheet.getRow(i).getCell(1).getStringCellValue();
		CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
		CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
		CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
		ToteID1 = sheet.getRow(i).getCell(5).getStringCellValue();
		CartID = sheet.getRow(i).getCell(6).getStringCellValue();
						myData.add(new Object[] { Asn_ID, Lpn_ID, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, CartID });
	}
	return myData.iterator();
}
    @DataProvider(name = "Ship_Confirmation")
      public static Iterator<Object[]> Ship_Confirmation() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Ship_Con");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}
	
    
    @DataProvider(name = "Multi_DR_Receiving")
    public static Iterator<Object[]> MultiDRReceiving() throws InvalidFormatException, IOException {
        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        String filePath = System.getProperty("user.dir") + FILEPATH;
        File file = new File(filePath + "\\" + FILENAME);
        FileInputStream inputStream = new FileInputStream(file);
        @SuppressWarnings("resource")
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet("Multi_ASN_LPN");
        int numOfRows = sheet.getLastRowNum();
        String Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, ToteID2, CartID, itemID1, itemID2;
       for (int i = 1; i <= numOfRows; i++) {
                      Asn = sheet.getRow(i).getCell(0).getStringCellValue();
                       Lpn = sheet.getRow(i).getCell(1).getStringCellValue();
             CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
             CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
             CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
             ToteID1 = sheet.getRow(i).getCell(5).getStringCellValue();
             ToteID2 = sheet.getRow(i).getCell(6).getStringCellValue();
             CartID = sheet.getRow(i).getCell(7).getStringCellValue();
             itemID1 = sheet.getRow(i).getCell(8).getStringCellValue();
             itemID2 = sheet.getRow(i).getCell(9).getStringCellValue();
            
            myData.add(new Object[] { Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, ToteID2, CartID, itemID1, itemID2 });
        }
        return myData.iterator();
    }

    
    @DataProvider(name = "Multi_DR_Receiving_SC")
    public static Iterator<Object[]> Multi_DR_Receiving_SC() throws InvalidFormatException, IOException {
        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        String filePath = System.getProperty("user.dir") + FILEPATH;
        File file = new File(filePath + "\\" + FILENAME);
        FileInputStream inputStream = new FileInputStream(file);
        @SuppressWarnings("resource")
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet("Mult_SC");
        int numOfRows = sheet.getLastRowNum();
        String Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, ToteID2, CartID, itemID1, itemID2;
       for (int i = 1; i <= numOfRows; i++) {
                      Asn = sheet.getRow(i).getCell(0).getStringCellValue();
                       Lpn = sheet.getRow(i).getCell(1).getStringCellValue();
             CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
             CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
             CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
             ToteID1 = sheet.getRow(i).getCell(5).getStringCellValue();
             ToteID2 = sheet.getRow(i).getCell(6).getStringCellValue();
             CartID = sheet.getRow(i).getCell(7).getStringCellValue();
             itemID1 = sheet.getRow(i).getCell(8).getStringCellValue();
             itemID2 = sheet.getRow(i).getCell(9).getStringCellValue();
            
            myData.add(new Object[] { Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, ToteID2, CartID, itemID1, itemID2 });
        }
        return myData.iterator();
    }

	@DataProvider(name = "ReceivingInput")
	public static Iterator<Object[]> fetchData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Sheet1");
		int numOfRows = sheet.getLastRowNum();
		String userName, password, menuSearch, Asn, relatedLink, Lpn, menuSearch1;
		for (int i = 0; i < numOfRows; i++) {
			userName = sheet.getRow(i).getCell(1).getStringCellValue();
			password = sheet.getRow(i).getCell(2).getStringCellValue();
			menuSearch = sheet.getRow(i).getCell(3).getStringCellValue();
			Asn = sheet.getRow(i).getCell(4).getStringCellValue();
			relatedLink = sheet.getRow(i).getCell(5).getStringCellValue();
			menuSearch1 = sheet.getRow(i).getCell(6).getStringCellValue();
			Lpn = sheet.getRow(i).getCell(7).getStringCellValue();
			myData.add(new Object[] { userName, password, menuSearch, Asn, relatedLink, menuSearch1, Lpn });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PutAwayInput")
	public static Iterator<Object[]> fetchData1() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Sheet2");
		int numOfRows = sheet.getLastRowNum();
		String userName, password, menuSearch, taskGroup, cartId, containerId, itemId;
		for (int i = 1; i < numOfRows; i++) {
			userName = sheet.getRow(i).getCell(1).getStringCellValue();
			password = sheet.getRow(i).getCell(2).getStringCellValue();
			menuSearch = sheet.getRow(i).getCell(3).getStringCellValue();
			taskGroup = sheet.getRow(i).getCell(4).getStringCellValue();
			cartId = sheet.getRow(i).getCell(5).getStringCellValue();
			containerId = sheet.getRow(i).getCell(6).getStringCellValue();
			itemId = sheet.getRow(i).getCell(7).getStringCellValue();
			myData.add(new Object[] { userName, password, menuSearch, taskGroup, cartId, containerId, itemId });
		}
		return myData.iterator();
	}

	@DataProvider(name = "RunWaveInput")
	public static Iterator<Object[]> fetchData2() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("RunWave");
		int numOfRows = sheet.getLastRowNum();
		String userName, password, menuSearch, order, menuSearch1, menuSearch2;
		for (int i = 1; i <= numOfRows; i++) {
			userName = sheet.getRow(i).getCell(1).getStringCellValue();
			password = sheet.getRow(i).getCell(2).getStringCellValue();
			menuSearch = sheet.getRow(i).getCell(3).getStringCellValue();
			order = sheet.getRow(i).getCell(4).getStringCellValue();
			menuSearch1 = sheet.getRow(i).getCell(5).getStringCellValue();
			menuSearch2 = sheet.getRow(i).getCell(6).getStringCellValue();
			myData.add(new Object[] { userName, password, menuSearch, order, menuSearch1, menuSearch2 });
		}
		return myData.iterator();
	}

	@DataProvider(name = "TaskAssigningInput")
	public static Iterator<Object[]> taskAssigningData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Sheet5");
		int numOfRows = sheet.getLastRowNum();
		String userName, password, menuSearch, order, menuSearch1, taskGroup, cartId, itemId, units, toteId,
				destinationLocationId;
		for (int i = 1; i <= numOfRows; i++) {
			userName = sheet.getRow(i).getCell(1).getStringCellValue();
			password = sheet.getRow(i).getCell(2).getStringCellValue();
			menuSearch = sheet.getRow(i).getCell(3).getStringCellValue();
			order = sheet.getRow(i).getCell(4).getStringCellValue();
			menuSearch1 = sheet.getRow(i).getCell(5).getStringCellValue();
			taskGroup = sheet.getRow(i).getCell(6).getStringCellValue();
			cartId = sheet.getRow(i).getCell(7).getStringCellValue();
			itemId = sheet.getRow(i).getCell(8).getStringCellValue();
			units = sheet.getRow(i).getCell(9).getStringCellValue();
			toteId = sheet.getRow(i).getCell(10).getStringCellValue();
			destinationLocationId = sheet.getRow(i).getCell(11).getStringCellValue();
			myData.add(new Object[] { userName, password, menuSearch, order, menuSearch1, taskGroup, cartId, itemId,
					units, toteId, destinationLocationId });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PickingOrdersInput")
	public static Iterator<Object[]> pickingOrders() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Sheet4");
		int numOfRows = sheet.getLastRowNum();
		String userName, password, menuSearch, tote, itemBarCode, actualweight, menuSearch1, order;
		for (int i = 1; i <= numOfRows; i++) {
			userName = sheet.getRow(i).getCell(1).getStringCellValue();
			password = sheet.getRow(i).getCell(2).getStringCellValue();
			menuSearch = sheet.getRow(i).getCell(3).getStringCellValue();
			tote = sheet.getRow(i).getCell(4).getStringCellValue();
			itemBarCode = sheet.getRow(i).getCell(5).getStringCellValue();
			actualweight = sheet.getRow(i).getCell(6).getStringCellValue();
			menuSearch1 = sheet.getRow(i).getCell(7).getStringCellValue();
			order = sheet.getRow(i).getCell(8).getStringCellValue();
			myData.add(new Object[] { userName, password, menuSearch, tote, itemBarCode, actualweight, menuSearch1,
					order });
		}
		return myData.iterator();
	}

	@DataProvider(name = "ASNVerification")
	public static Iterator<Object[]> fetchASNData() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("ASN_LPN_PO_ITEM_BARCODE");
		int numOfRows = sheet.getLastRowNum();
		String Asn, Lpn, VerifyItemid, VerifyASNSpecs, VerifyLPN, TotUserKey, TotStart, CartUserKey, LastLpn;

		for (int i = 1; i <= numOfRows; i++) {

			Asn = sheet.getRow(i).getCell(0).getStringCellValue();
			Lpn = sheet.getRow(i).getCell(1).getStringCellValue();
			VerifyItemid = sheet.getRow(i).getCell(2).getStringCellValue();
			VerifyASNSpecs = sheet.getRow(i).getCell(3).getStringCellValue();
			VerifyLPN = sheet.getRow(i).getCell(4).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(5).getStringCellValue();
			TotStart = sheet.getRow(i).getCell(6).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(7).getStringCellValue(); // SinglegiftCard
			LastLpn = sheet.getRow(i).getCell(8).getStringCellValue();

			myData.add(new Object[] { Asn, Lpn, VerifyItemid, VerifyASNSpecs, VerifyLPN, TotUserKey, TotStart,
					CartUserKey, LastLpn });
		}
		return myData.iterator();
	}

	@DataProvider(name = "SinglesBagOrder_Cartoon")
	public static Iterator<Object[]> SingleBagGC() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SinBagGc");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}
	@DataProvider(name = "SinglesBagOrder_PackStation_One")
	public static Iterator<Object[]> SingleBagOne() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SinBag_1");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "SinglesBagOrder_PackStation_Two")
	public static Iterator<Object[]> SingleBagPakTwo() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SinBag_2");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "SinglesBagOrder_PackStation_Three")
	public static Iterator<Object[]> SinglesBagPackThree() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SinBag_3");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "SinglegiftCard")
	public static Iterator<Object[]> singlegiftCard() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SingGifCard");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "SingleWrap")
	public static Iterator<Object[]> singlesWrap() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SingWGP");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "SingleExport")
	public static Iterator<Object[]> singlesExport() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SingExp");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "SingleCartons")
	public static Iterator<Object[]> singleCartons() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(7).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(8).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(9).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(12).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(13).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey,
					CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}
	
	@DataProvider(name = "MultiBag_GC")
	public static Iterator<Object[]> Multibags_2() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("MBag_GC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(15).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey,
					CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}
	
	@DataProvider(name = "WMS_MultiBag_GiftCard")
	public static Iterator<Object[]> Multibags_GiftCard() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("MBag_GiftCard");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(15).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey,
					CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}


	@DataProvider(name = "MultiGift_2Units")
	public static Iterator<Object[]> MultiGift_2() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("M_Gift_2");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}
		@DataProvider(name = "WMS_Multis_Gift_Wrap")
	public static Iterator<Object[]> Multis_gift_wrap() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("M_Gift_Wrp");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(7).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(8).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(9).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(12).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(13).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey,
					CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	
	@DataProvider(name = "WMS_Multi_Gift_Wrap")public static Iterator<Object[]> Multis_GiftWrap() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("MBag_GiftWrap");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2,TotUserKey3,TotUserKey4, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			TotUserKey3 = sheet.getRow(i).getCell(11).getStringCellValue();
			TotUserKey4 = sheet.getRow(i).getCell(12).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(13).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(14).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(15).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(16).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(17).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2,TotUserKey3,TotUserKey4, LocationKey, CartUserKey,
					CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "WMS_Multis_Export")
	public static Iterator<Object[]> Multis_Export() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("MBag_Export");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(15).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey,
					CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}


	@DataProvider(name = "Positive_Adjusment")
	public static Iterator<Object[]> Positive_Adjusments() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Positive_Adj");
		int numOfRows = sheet.getLastRowNum();
		String TOTEID, ITEMBAR;

		for (int i = 1; i <= numOfRows; i++) {

			TOTEID = sheet.getRow(i).getCell(0).getStringCellValue();
			ITEMBAR = sheet.getRow(i).getCell(1).getStringCellValue();

			myData.add(new Object[] { TOTEID, ITEMBAR, });
		}
		return myData.iterator();
	}

	@DataProvider(name = "blind_receiving")
	public static Iterator<Object[]> blindReceiving() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Blind_R");
		int numOfRows = sheet.getLastRowNum();
		String TOTEID;

		for (int i = 1; i <= numOfRows; i++) {

			TOTEID = sheet.getRow(i).getCell(0).getStringCellValue();

			myData.add(new Object[] { TOTEID });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Add_and_Remove_Condition")
	public static Iterator<Object[]> AddandRemove() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("ARcond");
		int numOfRows = sheet.getLastRowNum();
		String TOTEID;

		for (int i = 1; i <= numOfRows; i++) {

			TOTEID = sheet.getRow(i).getCell(0).getStringCellValue();

			myData.add(new Object[] { TOTEID });
		}
		return myData.iterator();
	}
	

	@DataProvider(name = "cycle_Count_UserDirected")
	public static Iterator<Object[]> cycleCount() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Cycle_User");
		int numOfRows = sheet.getLastRowNum();
		String LOCATION, ITEM, LOCATIONID;

		for (int i = 1; i <= numOfRows; i++) {

			LOCATION = sheet.getRow(i).getCell(0).getStringCellValue();
			ITEM = sheet.getRow(i).getCell(1).getStringCellValue();
			LOCATIONID = sheet.getRow(i).getCell(2).getStringCellValue();

			myData.add(new Object[] { LOCATION, ITEM, LOCATIONID });
		}
		return myData.iterator();
	}

	@DataProvider(name = "cycle_Recounts")
	public static Iterator<Object[]> cycleReCountas() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Cycle_Rec");
		int numOfRows = sheet.getLastRowNum();
		String LOCATION, ITEM, LOCATIONID;

		for (int i = 1; i <= numOfRows; i++) {

			LOCATION = sheet.getRow(i).getCell(0).getStringCellValue();
			ITEM = sheet.getRow(i).getCell(1).getStringCellValue();
			LOCATIONID = sheet.getRow(i).getCell(2).getStringCellValue();

			myData.add(new Object[] { LOCATION, ITEM, LOCATIONID });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Negative_Adjusment")
	public static Iterator<Object[]> Negative_Adjusment() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Negative_Adj");
		int numOfRows = sheet.getLastRowNum();
		String TOTEID, ITEMBAR;

		for (int i = 1; i <= numOfRows; i++) {

			TOTEID = sheet.getRow(i).getCell(0).getStringCellValue();
			ITEMBAR = sheet.getRow(i).getCell(1).getStringCellValue();

			myData.add(new Object[] { TOTEID, ITEMBAR, });
		}
		return myData.iterator();
	}

		@DataProvider(name = "RateShop")
	public static Iterator<Object[]> rateshop() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("RS");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(7).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(8).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(9).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(12).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(13).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey,
					CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "RateShop_Validation")
	public static Iterator<Object[]> rateShop() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("RateShop");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PickShort_Singles_bag")
	public static Iterator<Object[]>picksortSB() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pick_SB");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}
	
	@DataProvider(name = "PickShort_Singles_Carton")
	public static Iterator<Object[]>picksortSingleCarton() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pick_SC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}
	
		
	@DataProvider(name = "PickShort_Singles_Gift_Card")
	public static Iterator<Object[]> singleGiftCard_pick_Short() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pick_SGC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}
	
	@DataProvider(name = "Cancel_Olpns")
	public static Iterator<Object[]> Cancel_Olpns() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Can_Olpn");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber,OrderNumber2, CompleteSpecs2, CompleteSpecs3;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
					myData.add(new Object[] { OrderNumber,OrderNumber2,  CompleteSpecs2, CompleteSpecs3 });
		}
		return myData.iterator();
	}	


	@DataProvider(name = "WMS_Cancel_Order")
	public static Iterator<Object[]> WMS_Cancel_Order1() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Can_Ord");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs2, CompleteSpecs3;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(2).getStringCellValue();
					myData.add(new Object[] { OrderNumber,  CompleteSpecs2, CompleteSpecs3 });
		}
		return myData.iterator();
	}
	
		

	@DataProvider(name = "PackShorts_SingleBag_Cartons")
    public static Iterator<Object[]> singleBag_Cartons_PackShort() throws InvalidFormatException, IOException {
        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        String filePath = System.getProperty("user.dir") + FILEPATH;
        File file = new File(filePath + "\\" + FILENAMESECOUND);
        FileInputStream inputStream = new FileInputStream(file);
        @SuppressWarnings("resource")
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet("Pack_SCP");
        int numOfRows = sheet.getLastRowNum();
        String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
                CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
                PackStation;
       for (int i = 1; i <= numOfRows; i++) {
           OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
            OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
            CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
            CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
            CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
            CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
            CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
            CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
            CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
            TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
            TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
            LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
            CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
            CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
            CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
            PackStation = sheet.getRow(i).getCell(15).getStringCellValue();



           myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
                    CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey,
                    CompleteSpecs8, CompleteSpecs9, PackStation });
        }
        return myData.iterator();
    }
    
    @DataProvider(name = "PackShorts_Singles_bags")
    public static Iterator<Object[]> singles_bag_PackShort() throws InvalidFormatException, IOException {
        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        String filePath = System.getProperty("user.dir") + FILEPATH;
        File file = new File(filePath + "\\" + FILENAMESECOUND);
        FileInputStream inputStream = new FileInputStream(file);
        @SuppressWarnings("resource")
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet("Pack_SBP");
        int numOfRows = sheet.getLastRowNum();
        String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
                CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
                PackStation;
       for (int i = 1; i <= numOfRows; i++) {
           OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
            OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
            CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
            CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
            CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
            CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
            CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
            CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
            CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
            TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
            TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
            LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
            CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
            CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
            CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
            PackStation = sheet.getRow(i).getCell(15).getStringCellValue();



           myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
                    CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey,
                    CompleteSpecs8, CompleteSpecs9, PackStation });
        }
        return myData.iterator();
    }
	@DataProvider(name = "ParcelEnd_of_TheDay")
	public static Iterator<Object[]> ParcelEnd() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Par_EOD");
		int numOfRows = sheet.getLastRowNum();
		String CarrierServer, ParcelEndDate;

		for (int i = 1; i <= numOfRows; i++) {

			CarrierServer = sheet.getRow(i).getCell(0).getStringCellValue();

			ParcelEndDate = sheet.getRow(i).getCell(1).getStringCellValue();

			myData.add(new Object[] { CarrierServer, ParcelEndDate });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Fill_And_Kill_Wave")
	public static Iterator<Object[]> fill_and_kill() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Fill_Kill");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs });
		}
		return myData.iterator();
	}
	
	@DataProvider(name = "Single_SKU")
	public static Iterator<Object[]> SingleSKULPN() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("ASN_LPN");
		int numOfRows = sheet.getLastRowNum();
		String Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, CartID ;

		for (int i = 1; i <= numOfRows; i++) {

			Asn= sheet.getRow(i).getCell(0).getStringCellValue();
			Lpn = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			ToteID1 = sheet.getRow(i).getCell(5).getStringCellValue();
			CartID = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, CartID });
		}
		return myData.iterator();
	}
	
	@DataProvider(name = "Single_SKU_SC")
	public static Iterator<Object[]> Single_SKU_SC() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("SSku_SC");
		int numOfRows = sheet.getLastRowNum();
		String Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, CartID ;

		for (int i = 1; i <= numOfRows; i++) {

			Asn= sheet.getRow(i).getCell(0).getStringCellValue();
			Lpn = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			ToteID1 = sheet.getRow(i).getCell(5).getStringCellValue();
			CartID = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { Asn, Lpn, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, ToteID1, CartID });
		}
		return myData.iterator();
	}
	

	@DataProvider(name = "PackShorts_Single_Export")
	public static Iterator<Object[]> singles_Export_PackShort() throws InvalidFormatException, IOException {
		 ArrayList<Object[]> myData = new ArrayList<Object[]>();
	        String filePath = System.getProperty("user.dir") + FILEPATH;
	        File file = new File(filePath + "\\" + FILENAMESECOUND);
	        FileInputStream inputStream = new FileInputStream(file);
	        @SuppressWarnings("resource")
	        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	        sheet = workbook.getSheet("Pack_SEP");
	        int numOfRows = sheet.getLastRowNum();
	        String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
	                CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
	                PackStation;
	       for (int i = 1; i <= numOfRows; i++) {
	           OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
	            OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
	            CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
	            CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
	            CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
	            CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
	            CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
	            CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
	            CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
	            TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
	            TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
	            LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
	            CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
	            CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
	            CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
	            PackStation = sheet.getRow(i).getCell(15).getStringCellValue();



	           myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
	                    CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey,
	                    CompleteSpecs8, CompleteSpecs9, PackStation });
	        }
	        return myData.iterator();
	    }
	@DataProvider(name = "Printing_Journal")
	public static Iterator<Object[]> printing_Journal() throws InvalidFormatException, IOException {
		 ArrayList<Object[]> myData = new ArrayList<Object[]>();
	        String filePath = System.getProperty("user.dir") + FILEPATH;
	        File file = new File(filePath + "\\" + FILENAMESECOUND);
	        FileInputStream inputStream = new FileInputStream(file);
	        @SuppressWarnings("resource")
	        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	        sheet = workbook.getSheet("P-Jour");
	        int numOfRows = sheet.getLastRowNum();
	     		String OrderNumber, CompleteSpecs, TaskGroup, PrintType;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			TaskGroup = sheet.getRow(i).getCell(2).getStringCellValue();
			PrintType = sheet.getRow(i).getCell(3).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, TaskGroup, PrintType });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Large_Wave")
	public static Iterator<Object[]> LargeWave_Task_release() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Lr_Wave");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, OrderNumber3, OrderNumber4, OrderNumber5, OrderNumber6, OrderNumber7,
				OrderNumber8, OrderNumber9, OrderNumber10, OrderNumber11, OrderNumber12, OrderNumber13, OrderNumber14,
				OrderNumber15, OrderNumber16, OrderNumber17, OrderNumber18, CompleteSpecs, CompleteSpecs2,
				CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1,
				TotUserKey2, TotUserKey3, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			OrderNumber3 = sheet.getRow(i).getCell(2).getStringCellValue();
			OrderNumber4 = sheet.getRow(i).getCell(3).getStringCellValue();
			OrderNumber5 = sheet.getRow(i).getCell(4).getStringCellValue();
			OrderNumber6 = sheet.getRow(i).getCell(5).getStringCellValue();
			OrderNumber7 = sheet.getRow(i).getCell(6).getStringCellValue();
			OrderNumber8 = sheet.getRow(i).getCell(7).getStringCellValue();
			OrderNumber9 = sheet.getRow(i).getCell(8).getStringCellValue();
			OrderNumber10 = sheet.getRow(i).getCell(9).getStringCellValue();
			OrderNumber11 = sheet.getRow(i).getCell(10).getStringCellValue();
			OrderNumber12 = sheet.getRow(i).getCell(11).getStringCellValue();
			OrderNumber13 = sheet.getRow(i).getCell(12).getStringCellValue();
			OrderNumber14 = sheet.getRow(i).getCell(13).getStringCellValue();
			OrderNumber15 = sheet.getRow(i).getCell(14).getStringCellValue();
			OrderNumber16 = sheet.getRow(i).getCell(15).getStringCellValue();
			OrderNumber17 = sheet.getRow(i).getCell(16).getStringCellValue();
			OrderNumber18 = sheet.getRow(i).getCell(17).getStringCellValue();

			CompleteSpecs = sheet.getRow(i).getCell(18).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(19).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(20).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(21).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(22).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(23).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(24).getStringCellValue();

			TotUserKey1 = sheet.getRow(i).getCell(25).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(26).getStringCellValue();
			TotUserKey3 = sheet.getRow(i).getCell(27).getStringCellValue();

			LocationKey = sheet.getRow(i).getCell(28).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(29).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(30).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(31).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(32).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, OrderNumber3, OrderNumber4, OrderNumber5, OrderNumber6,
					OrderNumber7, OrderNumber8, OrderNumber9, OrderNumber10, OrderNumber11, OrderNumber12,
					OrderNumber13, OrderNumber14, OrderNumber15, OrderNumber16, OrderNumber17, OrderNumber18,
					CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, CompleteSpecs6,
					CompleteSpecs7, TotUserKey1, TotUserKey2, TotUserKey3, LocationKey, CartUserKey, CompleteSpecs8,
					CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "DO_SingleBag")
	public static Iterator<Object[]> DOsinglebag() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("DO_SB");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation, TaskGroup, PrintType;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(7).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(8).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(9).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(12).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(13).getStringCellValue();
			TaskGroup = sheet.getRow(i).getCell(14).getStringCellValue();
			PrintType = sheet.getRow(i).getCell(15).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey,
					CompleteSpecs8, CompleteSpecs9, PackStation, TaskGroup, PrintType });
		}
		return myData.iterator();
	}

	@DataProvider(name = "PackShorts__Multis_Gift_Wrap")
	public static Iterator<Object[]> singles_GiftWrap_PackShort() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pack-Wrap");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, OrderNumber3, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
				CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1, TotUserKey2, TotUserKey3, LocationKey,
				CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			OrderNumber3 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(8).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(9).getStringCellValue();

			TotUserKey1 = sheet.getRow(i).getCell(10).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(11).getStringCellValue();
			TotUserKey3 = sheet.getRow(i).getCell(12).getStringCellValue();

			LocationKey = sheet.getRow(i).getCell(13).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(14).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(15).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(16).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(17).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, OrderNumber3, CompleteSpecs, CompleteSpecs2,
					CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1,
					TotUserKey2, TotUserKey3, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}
	
	@DataProvider(name = "PickSort_MultiBag_Corton")
	public static Iterator<Object[]> PickSort_MultiBag_Corton() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pick_MB_Corton");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(15).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey,
					CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}


	@DataProvider(name = "PickShort_Multis_Export")
	public static Iterator<Object[]> PickShort_Multis_Export() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pick_MExport");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(13).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(14).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(15).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, TotUserKey2, LocationKey, CartUserKey,
					CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}


	@DataProvider(name = "PackShort_Multis_Gift_Card")
	public static Iterator<Object[]> Pack_Multis_GiftCard_PackShort() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pack_GC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, OrderNumber3, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
				CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1, TotUserKey2, TotUserKey3, LocationKey,
				CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			OrderNumber3 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(8).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(9).getStringCellValue();

			TotUserKey1 = sheet.getRow(i).getCell(10).getStringCellValue();
			TotUserKey2 = sheet.getRow(i).getCell(11).getStringCellValue();
			TotUserKey3 = sheet.getRow(i).getCell(12).getStringCellValue();

			LocationKey = sheet.getRow(i).getCell(13).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(14).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(15).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(16).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(17).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, OrderNumber3, CompleteSpecs, CompleteSpecs2,
					CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1,
					TotUserKey2, TotUserKey3, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}

	@DataProvider(name = "Clock_In_Clock_Out")
	public static Iterator<Object[]> clock_In_Out() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAME);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("ClockInOut");
		int numOfRows = sheet.getLastRowNum();
		String UserId, TimeIn, OutTime;

		for (int i = 1; i <= numOfRows; i++) {

			UserId = sheet.getRow(i).getCell(0).getStringCellValue();
			TimeIn = sheet.getRow(i).getCell(1).getStringCellValue();
			OutTime = sheet.getRow(i).getCell(2).getStringCellValue();

			myData.add(new Object[] { UserId, TimeIn, OutTime });
		}
		return myData.iterator();
	}
	@DataProvider(name = "Alternate_Pick_Location")
	public static Iterator<Object[]> Alternate_Pick_Location() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pick_AltLoca");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}
	

	@DataProvider(name = "FE2D_RateShop_Validation")
	public static Iterator<Object[]> rateShopFE2D() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMEFIRST);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("FE2D");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "DHEP_RateShop_Validation")
	public static Iterator<Object[]> rateShopDHEP() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMEFIRST);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("DHEP");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "FEPO_RateShop_Validation")
	public static Iterator<Object[]> rateShopFEPO() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMEFIRST);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("FEPO");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "FEGC_RateShop_Validation")
	public static Iterator<Object[]> rateShopFEGC() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMEFIRST);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("FEGC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "FGHD_RateShop_Validation")
	public static Iterator<Object[]> rateShopFGHD() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMEFIRST);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("FGHD");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "ONTRAC_RateShop_Validation")
	public static Iterator<Object[]> rateShopONTRAC() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMEFIRST);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("ONTRAC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}

	@DataProvider(name = "USSG_RateShop_Validation")
	public static Iterator<Object[]> rateShopUSSG() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMEFIRST);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("USSG");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}
	
	@DataProvider(name = "USFC_RateShop_Validation")
	public static Iterator<Object[]> rateShopUSFC() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMEFIRST);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("USFC");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5, ShipVia;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(5).getStringCellValue();
			ShipVia = sheet.getRow(i).getCell(6).getStringCellValue();

			myData.add(new Object[] { OrderNumber, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
					CompleteSpecs5, ShipVia });
		}
		return myData.iterator();
	}
	
	@DataProvider(name = "PickShort_Singles_Gift_Wrap")
	public static Iterator<Object[]> singleGift_Wrap_pick_Short() throws InvalidFormatException, IOException {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String filePath = System.getProperty("user.dir") + FILEPATH;
		File file = new File(filePath + "\\" + FILENAMESECOUND);
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("Pick_SGW");
		int numOfRows = sheet.getLastRowNum();
		String OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4, CompleteSpecs5,
				CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey, CartUserKey, CompleteSpecs8, CompleteSpecs9,
				PackStation;

		for (int i = 1; i <= numOfRows; i++) {

			OrderNumber = sheet.getRow(i).getCell(0).getStringCellValue();
			OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
			CompleteSpecs = sheet.getRow(i).getCell(2).getStringCellValue();
			CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
			CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
			CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
			CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
			CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
			CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
			TotUserKey = sheet.getRow(i).getCell(9).getStringCellValue();
			LocationKey = sheet.getRow(i).getCell(10).getStringCellValue();
			CartUserKey = sheet.getRow(i).getCell(11).getStringCellValue();
			CompleteSpecs8 = sheet.getRow(i).getCell(12).getStringCellValue();
			CompleteSpecs9 = sheet.getRow(i).getCell(13).getStringCellValue();
			PackStation = sheet.getRow(i).getCell(14).getStringCellValue();

			myData.add(new Object[] { OrderNumber, OrderNumber2, CompleteSpecs, CompleteSpecs2, CompleteSpecs3,
					CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey, LocationKey,
					CartUserKey, CompleteSpecs8, CompleteSpecs9, PackStation });
		}
		return myData.iterator();
	}
	
	
	
	@DataProvider(name = "PickSort_MultiBag_Corton_2slot")
    public static Iterator<Object[]> PickSort_MultiBag_Corton_2slot() throws InvalidFormatException, IOException {
        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        String filePath = System.getProperty("user.dir") + FILEPATH;
        File file = new File(filePath + "\\" + FILENAMESECOUND);
        FileInputStream inputStream = new FileInputStream(file);
        @SuppressWarnings("resource")
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet("Pick_MB_Corton_2slot");
        int numOfRows = sheet.getLastRowNum();
        String OrderNumber1, OrderNumber2, CompleteSpecs1, CompleteSpecs2, CompleteSpecs3, CompleteSpecs4,
                CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1, TotUserKey2, TotUserKey3, LocationKey,
                CartUserKey1, CartUserKey2, CompleteSpecs8, CompleteSpecs9, PackStation;

        for (int i = 1; i <= numOfRows; i++) {

            OrderNumber1 = sheet.getRow(i).getCell(0).getStringCellValue();
            OrderNumber2 = sheet.getRow(i).getCell(1).getStringCellValue();
            CompleteSpecs1 = sheet.getRow(i).getCell(2).getStringCellValue();
            CompleteSpecs2 = sheet.getRow(i).getCell(3).getStringCellValue();
            CompleteSpecs3 = sheet.getRow(i).getCell(4).getStringCellValue();
            CompleteSpecs4 = sheet.getRow(i).getCell(5).getStringCellValue();
            CompleteSpecs5 = sheet.getRow(i).getCell(6).getStringCellValue();
            CompleteSpecs6 = sheet.getRow(i).getCell(7).getStringCellValue();
            CompleteSpecs7 = sheet.getRow(i).getCell(8).getStringCellValue();
            TotUserKey1 = sheet.getRow(i).getCell(9).getStringCellValue();
            TotUserKey2 = sheet.getRow(i).getCell(10).getStringCellValue();
            TotUserKey3 = sheet.getRow(i).getCell(11).getStringCellValue();
            LocationKey = sheet.getRow(i).getCell(12).getStringCellValue();
            CartUserKey1 = sheet.getRow(i).getCell(13).getStringCellValue();
            CartUserKey2 = sheet.getRow(i).getCell(14).getStringCellValue();
            CompleteSpecs8 = sheet.getRow(i).getCell(15).getStringCellValue();
            CompleteSpecs9 = sheet.getRow(i).getCell(16).getStringCellValue();
            PackStation = sheet.getRow(i).getCell(17).getStringCellValue();
            

            myData.add(new Object[] { OrderNumber1, OrderNumber2, CompleteSpecs1, CompleteSpecs2, CompleteSpecs3,
                    CompleteSpecs4, CompleteSpecs5, CompleteSpecs6, CompleteSpecs7, TotUserKey1, TotUserKey2,
                    TotUserKey3, LocationKey, CartUserKey1, CartUserKey2, CompleteSpecs8, CompleteSpecs9, PackStation,
                     });
        }
        return myData.iterator();
    }
	
}
