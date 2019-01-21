package com.apeamcet.excel;

import java.util.List;		
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.apeamcet.domain.Data;
import com.apeamcet.model.DataModel;
import com.apeamcet.util.Constants;
import com.apeamcet.util.ExcelDataHeaders;
import com.apeamcet.util.ExcelDistrictHeaders;
import com.apeamcet.util.ExcelHeadersForUsers;

public class ExcelDownload {
	private static final Logger logger = Logger.getLogger(ExcelDownload.class.getName());
	public static XSSFWorkbook create(List<Data> data1){
		 XSSFWorkbook workbook = null;
		 try{
		  workbook = new XSSFWorkbook();
	     XSSFSheet spreadsheet = workbook.createSheet(Constants.CONST_DOWNLOAD_FILE_NAME);
	     int rowIndex=0,columnIndex=0;
	     XSSFRow row =spreadsheet.createRow(rowIndex);
	     for(ExcelDataHeaders dataHeaders:ExcelDataHeaders.values()){
    	  XSSFCell cell=row.createCell(columnIndex);
    	  cell.setCellValue(dataHeaders.toString());
    	  columnIndex++;
      }
      for(Data data:data1){
    	  row=spreadsheet.createRow(++rowIndex);  
    	  
    	  XSSFCell id1=row.createCell(0);
	      id1.setCellValue(data.getCode());
	      XSSFCell code1=row.createCell(1);
	      code1.setCellValue(data.getInstitutename());
	      XSSFCell name1=row.createCell(2);
	      name1.setCellValue(data.getCoursecode());
	      XSSFCell region1=row.createCell(3);
	      region1.setCellValue(data.getRegion());
	      XSSFCell district1=row.createCell(4);
	      district1.setCellValue(data.getDistrict());
	      XSSFCell place1=row.createCell(5);
	      place1.setCellValue(data.getPlace());
	      XSSFCell ocb1=row.createCell(6);
	      ocb1.setCellValue(data.getOcb());
	      XSSFCell ocg1=row.createCell(7);
	      ocg1.setCellValue(data.getOcg());
	      XSSFCell scb1=row.createCell(8);
	      scb1.setCellValue(data.getScb());
	      XSSFCell scg1=row.createCell(9);
	      scg1.setCellValue(data.getScg());
	      XSSFCell stb1=row.createCell(10);
	      stb1.setCellValue(data.getStb());
	      XSSFCell stg1=row.createCell(11);
	      stg1.setCellValue(data.getStg());
	      XSSFCell bcab1=row.createCell(12);
	      bcab1.setCellValue(data.getBcab());
	      XSSFCell bcag1=row.createCell(13);
	      bcag1.setCellValue(data.getBcag());
	      XSSFCell bcbb1=row.createCell(14);
	      bcbb1.setCellValue(data.getBcbb());
	      XSSFCell bcbg1=row.createCell(15);
	      bcbg1.setCellValue(data.getBcbg());
	      XSSFCell bccb1=row.createCell(16);
	      bccb1.setCellValue(data.getBccb());
	      XSSFCell bccg1=row.createCell(17);
	      bccg1.setCellValue(data.getBccg());
	      XSSFCell bcdb1=row.createCell(18);
	      bcdb1.setCellValue(data.getBcdb());
	      XSSFCell bcdg1=row.createCell(19);
	      bcdg1.setCellValue(data.getBcdg());
	      XSSFCell bceb1=row.createCell(20);
	      bceb1.setCellValue(data.getBceb());
	      XSSFCell bceg1=row.createCell(21);
	      bceg1.setCellValue(data.getBceg());
	      XSSFCell type1=row.createCell(22);
	      type1.setCellValue(data.getType());
	      XSSFCell year1=row.createCell(23);
	      year1.setCellValue(data.getYear());
	      
	     
      }
		}catch(Exception exception){
			logger.log(Level.SEVERE,exception.getMessage(), exception);
		}
		
		return workbook;
	}
	public static XSSFWorkbook createUserData(List<DataModel> list) {
		 XSSFWorkbook workbook = null;
		 try{
		  workbook = new XSSFWorkbook();
	     XSSFSheet spreadsheet = workbook.createSheet(Constants.CONST_DOWNLOAD_FILE_NAME);
	     int rowIndex=0,columnIndex=0;
	     XSSFRow row =spreadsheet.createRow(rowIndex);
	     for(ExcelHeadersForUsers dataHeaders:ExcelHeadersForUsers.values()){
    	  XSSFCell cell=row.createCell(columnIndex);
    	  cell.setCellValue(dataHeaders.toString());
    	  columnIndex++;
      }
      for(DataModel data:list){
    	  row=spreadsheet.createRow(++rowIndex);  
    	  
    	  XSSFCell code=row.createCell(0);
	      code.setCellValue(data.getCode());
	      XSSFCell name=row.createCell(1);
	      name.setCellValue(data.getInstituteName());
	      XSSFCell branch=row.createCell(2);
	      branch.setCellValue(data.getCourseCode());
	      XSSFCell district=row.createCell(3);
	     district.setCellValue(data.getDistrict());
	     XSSFCell place=row.createCell(4);
	      place.setCellValue(data.getPlace());
	      XSSFCell rank=row.createCell(5);
	      rank.setCellValue(data.getRank());
	      
	     
      }
		}catch(Exception exception){
			logger.log(Level.SEVERE,exception.getMessage(), exception);
		}
		
		return workbook;
	}
	
	public static XSSFWorkbook createDistrictUserData(List<DataModel> list) {
		 XSSFWorkbook workbook = null;
		 try{
		  workbook = new XSSFWorkbook();
	     XSSFSheet spreadsheet = workbook.createSheet(Constants.CONST_DOWNLOAD_FILE_NAME);
	     int rowIndex=0,columnIndex=0;
	     XSSFRow row =spreadsheet.createRow(rowIndex);
	     for(ExcelDistrictHeaders dataHeaders:ExcelDistrictHeaders.values()){
   	  XSSFCell cell=row.createCell(columnIndex);
   	  cell.setCellValue(dataHeaders.toString());
   	  columnIndex++;
     }
     for(DataModel data:list){
   	  row=spreadsheet.createRow(++rowIndex);  
   	  
   	  XSSFCell code=row.createCell(0);
	      code.setCellValue(data.getCode());
	      XSSFCell name=row.createCell(1);
	      name.setCellValue(data.getInstituteName());
	      XSSFCell branch=row.createCell(2);
	      branch.setCellValue(data.getCourseCode());
	      XSSFCell district=row.createCell(3);
	     district.setCellValue(data.getDistrict());
	     XSSFCell place=row.createCell(4);
	      place.setCellValue(data.getPlace());
     }
		}catch(Exception exception){
			logger.log(Level.SEVERE,exception.getMessage(), exception);
		}
		
		return workbook;
	}
	
}
