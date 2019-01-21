package com.apeamcet.validate;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.springframework.web.multipart.MultipartFile;

import com.apeamcet.util.Constants;
import com.apeamcet.util.ExcelDataHeaders;

public class ValidateUpload {

	public static  String validateOfficeData(MultipartFile file){
		/*
		 * Check whether file is of excel type
		 */
		if(!file.getContentType().equals(Constants.CONST_EXCEL_SHEET_TYPE)){
		return Constants.CONST_ERROR_IN_FILE_TYPE;
		}
		/*
		 * Check whether file size is less than 10 MB
		 */
		if(file.getSize() > 10*1024*1024) {
			return Constants.CONST_ERROR_IN_FILE_SIZE;
		}
		return Constants.CONST_DATA_VALID;
	}
	
	
	/*
	 * Validates the Excel headers with database column names.
	 */
	public static boolean validateHeader(XSSFRow row) {
		int index=0;
		
		for(ExcelDataHeaders dataHead:ExcelDataHeaders.values()){
			if(dataHead.toString().equalsIgnoreCase(row.getCell(index).getStringCellValue())){
					index++;
				}
			else{
				return false;
			}
	}
		return true;
	}
	
	
}
