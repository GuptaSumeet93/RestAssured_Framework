package api.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import groovy.transform.Undefined.EXCEPTION;

public class ExcelUtility {
	
	

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	
	public XSSFRow row;
	public XSSFCell cell;
	
	public CellStyle  style;
	String path;

	
	
	public  ExcelUtility (String path)
	{
      this.path=path;
	}
	
	public int getRowCount(String ExcelUserData) throws IOException
	{
		
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(ExcelUserData);
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
		
		
	}

	
	public int getCellCount(String ExcelUserData, int rownum) throws IOException
	{
		
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(ExcelUserData);
		row=sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
		
		
	}
	

	public String getCellData(String ExcelUserData, int rownum,int colnum) throws IOException
	{
		
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(ExcelUserData);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
               DataFormatter formatter=new DataFormatter();
               String data;

              try {
                        	data=formatter.formatCellValue(cell);

	
                   }

              catch(Exception e)
                 
                   {
                     	data="";
                   }
		  
		workbook.close();
		fi.close();
		return data;
		
		
	}
	
	
	public void setCellData (String ExcelUserData, int rownum, int colnum, String data ) throws IOException
	{
		File excelFile=new File(path);
		
		if(!excelFile.exists()) //If file not exist then create new file
		{
			
			workbook=new XSSFWorkbook(fi);
			fo=new FileOutputStream(path);
			workbook.write(fo);
		}
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		
		if(workbook.getSheetIndex(ExcelUserData)==-1); //If file not exist then create new file
		  workbook.createSheet(ExcelUserData);
			sheet=workbook.getSheet(ExcelUserData);		
			
			if(sheet.getRow(rownum)==null)
				sheet.createRow(rownum);
			row=sheet.getRow(rownum);
			
			cell=row.createCell(colnum);
			cell.setCellValue(data);
			
			fo=new FileOutputStream(path);
			
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
				
	}
	
	public void fillRedColor (String ExcelUserData, int rownum, int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		
		
			
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(ExcelUserData);		
			row=sheet.getRow(rownum);
			cell=row.createCell(colnum);

			
			style=workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			
			fo=new FileOutputStream(path);
			workbook.write(fo);
	
			
			cell.setCellStyle(style);
			
			
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
				
	}
		
	
	
	
		
	}
	



