package com.megatron.lib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataHandlers {

	public static void SetDataToProperties(String filename, String Key , String Value, String Comment)
	{
try {
			File f = new File("./config-data/" + filename + ".property");
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			prop.setProperty(Key, Value);
			FileOutputStream fos = new FileOutputStream(f);
			//String Value = prop.get("TV").toString();
			prop.store(fos, Comment);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public static String getDatafromProperties(String filename, String Key)
	{
		
		String data = null;
try {
	File f = new File("./config-data/" + filename + ".property");
	FileInputStream fis = new FileInputStream(f);
	Properties prop = new Properties();
	prop.load(fis);
	data = (String)prop.get(Key);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
return data;
		}
	
	public static String getDataFromExcel(String filename, String SheetName, int rowindex, int cellindex)
	{
	String data = null;
try {
	File f = new File("./test-data/" + filename + ".xlsx");
	FileInputStream fis = new FileInputStream(f);
	Workbook wb = WorkbookFactory.create(fis);
	org.apache.poi.ss.usermodel.Sheet st = wb.getSheet(SheetName);
	Row R = st.getRow(rowindex);
	Cell C = R.getCell(cellindex);
	data =  C.toString();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
return data;
		}
	
	public static void setDatatoExcel(String filename, String SheetName, int rowindex, int cellindex, String data)
	{
try {
	File f = new File("./test-data/" + filename + ".xlsx");
	FileInputStream fis = new FileInputStream(f);
	Workbook wb = WorkbookFactory.create(fis);
	org.apache.poi.ss.usermodel.Sheet st = wb.getSheet(SheetName);
	Row R = st.getRow(rowindex);
	Cell C = R.getCell(cellindex);
	C.setCellValue(data);
	FileOutputStream fos = new FileOutputStream(f);
wb.write(fos);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
}
