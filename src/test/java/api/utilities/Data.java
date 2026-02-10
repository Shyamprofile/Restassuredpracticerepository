package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data {

// Fetches data for post request from excel sheet	
	@DataProvider
	public static String [][] fetchdata() throws IOException {
	File file= new File ("D:\\jsondata/DataforRestAssuredTesting.xlsx");
	FileInputStream fis =new FileInputStream(file);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet= workbook.getSheet("Data");
	int rownum= sheet.getLastRowNum();
	int colnum= sheet.getRow(rownum).getLastCellNum();
	DataFormatter dft =new DataFormatter();
	String apidat[][]= new String[rownum][colnum];
	for(int i=1; i<=rownum; i++) {
		for(int j=0; j<colnum ; j++) {
			apidat[i-1][j]=dft.formatCellValue(sheet.getRow(i).getCell(j));
			System.out.print(dft.formatCellValue(sheet.getRow(i).getCell(j)) +"||");
		}
		System.out.println();
		}
	return apidat;
	}
//Only fetches data of username from excel sheet for retreiving get requests
	@DataProvider(name ="getdata")
	public static String [][] getdata() throws IOException {
	File file= new File ("D:\\jsondata/DataforRestAssuredTesting.xlsx");
	FileInputStream fis =new FileInputStream(file);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet= workbook.getSheet("Data");
	int rownum= sheet.getLastRowNum();
	int colnum= sheet.getRow(rownum).getLastCellNum();
	DataFormatter dft =new DataFormatter();
	String apidat[][]= new String[rownum][1];
	for(int i=1; i<=rownum; i++) {
		for(int j=0; j<colnum ; j++) {
			apidat[i-1][0]=dft.formatCellValue(sheet.getRow(i).getCell(0));
		}
	}
	return apidat;
	}	}

