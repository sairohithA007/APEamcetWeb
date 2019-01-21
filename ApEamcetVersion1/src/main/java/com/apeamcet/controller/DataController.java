package com.apeamcet.controller;
	
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.apeamcet.domain.Data;
import com.apeamcet.excel.ExcelDownload;
import com.apeamcet.exception.InvalidException;
import com.apeamcet.model.DataModel;
import com.apeamcet.service.DataServiceSave;
import com.apeamcet.util.Constants;
import com.apeamcet.validate.ValidateUpload;



@Controller
public class DataController {
	DataServiceSave dataServiceSave;
	
	private final Logger logger = Logger.getLogger(DataController.class.getName());
	@Inject
	public DataController(DataServiceSave dataServiceSave) {
		this.dataServiceSave=dataServiceSave;
	}
	
	/*
	 * The view to the upload the excel file is accessed from here
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public ModelAndView view(){
		ModelAndView modelAndView = new ModelAndView();
		DataModel dataPojo= new DataModel();
		modelAndView.setViewName(Constants.VIEW_DATAMANAGE);
		modelAndView.addObject(Constants.CONST_DATA_POJO, dataPojo);
		return modelAndView;
	}
	@RequestMapping("/download")
	@ResponseBody
	public ModelAndView viewDownload(){
		ModelAndView modelAndView = new ModelAndView();
		DataModel dataPojo= new DataModel();
		modelAndView.setViewName(Constants.VIEW_DOWNLOAD);
		modelAndView.addObject(Constants.CONST_DATA_POJO, dataPojo);
		return modelAndView;
	}
	
	@RequestMapping(value={"/home","/"})
	@ResponseBody
	public ModelAndView home(Model model){
		ModelAndView modelAndView = new ModelAndView();
		DataModel dataModel= new DataModel();
		modelAndView.setViewName(Constants.VIEW_MAINHOME);
		modelAndView.addObject(Constants.CONST_DATA_POJO, dataModel);
		model.addAttribute(Constants.CONST_DATA_COUNT, 0);
		return modelAndView;
	}
	/*
	 * The excel is validated and then the data from excel file is uploaded to database
	 */
	@RequestMapping(value="/uploaddata",headers = "content-type=multipart/*", method=RequestMethod.POST)
	public String handleFormUpload(@RequestParam("file") MultipartFile file, @ModelAttribute DataModel dataPojo, Model model,Map<String, Object> map)throws IOException {
		
		logger.log(Level.INFO,"Controller");
		String status = null;
		map.put(Constants.CONST_DATA_POJO, dataPojo);
		try{
        if (!file.isEmpty()) {
        	String check=ValidateUpload.validateOfficeData(file);
        	if(check.equals(Constants.CONST_DATA_VALID)){
        		try{
        			status=dataServiceSave.saveContents(file, dataPojo);
        		}catch(InvalidException invalidException){
        			return Constants.VIEW_DATAMANAGE;
        		}
            model.addAttribute(Constants.CONST_DATA_MESSAGE, status);
        	}
        	else{
        		 model.addAttribute(Constants.CONST_DATA_MESSAGE, check);
        	}
           }
        }catch(MultipartException multipartException){
        	logger.log(Level.SEVERE,multipartException.getMessage(), multipartException);
        } 
        return Constants.VIEW_DATAMANAGE;
    }
	
	/*
	 * The data present in database is retrieved in the form of list and passed to ExcelDownload class to generate a workbook(Excel Type) and download.
	 */
	@RequestMapping(value = "/downloadData", method = RequestMethod.POST)
	 public String generateExcel(HttpServletRequest request, HttpServletResponse response, @ModelAttribute DataModel dataPojo, Model model, Map<String, Object> map) throws Exception {
		List<Data> list = dataServiceSave.download(dataPojo);
		if(list.size()==0){
			model.addAttribute(Constants.CONST_DATA_MESSAGE,Constants.CONST_DATA_NOT_AVAILABLE);
			 map.put(Constants.CONST_DATA_POJO, dataPojo);
			
		}else{
			response.setHeader(Constants.CONST_EXCEL_CONTENT, Constants.CONST_EXCEL_ATTACHEMNT);
			response.setHeader(Constants.CONST_EXCEL_CONTENT_TYPE, Constants.CONST_EXCEL_SHEET_TYPE);
			XSSFWorkbook workbook=ExcelDownload.create(list);
			OutputStream outputStream=response.getOutputStream();
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		}
		return Constants.VIEW_DOWNLOAD;
	}
	
	
	

	/*
	 * The agricultural seat allotment list is retrieved here. 
	 */
	@RequestMapping(value="/getAgriculturalData", method=RequestMethod.POST)
	 public String getAgrall(@ModelAttribute DataModel dataPojo,Map<String, Object> map){
		dataPojo.setPage(dataPojo.getPage() == null ? 0 :dataPojo.getPage());
		org.springframework.data.domain.Sort sort = new org.springframework.data.domain.Sort(Direction.ASC, dataPojo.getCategory());
		   Pageable pageable= new PageRequest(dataPojo.getPage(),10, sort);
		List<DataModel> dataPojoList = dataServiceSave.getData(dataPojo,pageable);
		 map.put(Constants.CONST_DATA_LIST, dataPojoList);
		 map.put(Constants.CONST_DATA_POJO, dataPojo);
		 map.put(Constants.CONST_ROWS_COUNT,dataPojoList.size());
		 map.put(Constants.CONST_PAGE_VALUE, dataPojo.getPage());
		 return Constants.VIEW_AGRICULTURAL;
	 }
	
	/*
	 * The Engineering seat allotment list is retrieved here. 
	 */
	@RequestMapping(value="/getEngData", method=RequestMethod.POST)
	 public String getEngall(@ModelAttribute DataModel dataModel,Map<String, Object> map){
		dataModel.setPage(dataModel.getPage() == null ? 0 :dataModel.getPage());
		org.springframework.data.domain.Sort sort = new org.springframework.data.domain.Sort(Direction.ASC, dataModel.getCategory());
		   Pageable pageable= new PageRequest(dataModel.getPage(),10, sort);
		   List<DataModel> dataPojoList = dataServiceSave.getData(dataModel,pageable);
		 map.put(Constants.CONST_DATA_LIST, dataPojoList);
		 map.put(Constants.CONST_ROWS_COUNT,dataPojoList.size());
		 map.put(Constants.CONST_PAGE_VALUE, dataModel.getPage());
		 return Constants.VIEW_ENGINEERING;
	 }
	
	/*
	 * The medical seat allotment list is retrieved here. 
	 */
	@RequestMapping(value="/getMedData", method=RequestMethod.POST)
	 public String getMedall(@ModelAttribute DataModel dataPojo,Map<String, Object> map){
		dataPojo.setPage(dataPojo.getPage() == null ? 0 :dataPojo.getPage());
		org.springframework.data.domain.Sort sort = new org.springframework.data.domain.Sort(Direction.ASC, dataPojo.getCategory());
		   Pageable pageable= new PageRequest(dataPojo.getPage(),10, sort);
		List<DataModel> dataPojoList = dataServiceSave.getData(dataPojo,pageable);
		 map.put(Constants.CONST_DATA_LIST, dataPojoList);
		 map.put(Constants.CONST_DATA_POJO, dataPojo);
		 map.put(Constants.CONST_ROWS_COUNT,dataPojoList.size());
		 map.put(Constants.CONST_PAGE_VALUE, dataPojo.getPage());
		 return Constants.VIEW_MEDICAL;
	 }
	
	/*
	 * This method is used to get data based on district.
	 */
	@RequestMapping(value="/getDistrictData/{district}", method=RequestMethod.GET)
	 public String getDistrict(@PathVariable String district, @ModelAttribute DataModel dataModel,Map<String, Object> map, Model model){
		dataModel.setPage(dataModel.getPage() == null ? 0 :dataModel.getPage());
		dataModel.setDistrict(district);
		org.springframework.data.domain.Sort sort = new org.springframework.data.domain.Sort(Direction.ASC, "ocb");
		   Pageable pageable= new PageRequest(dataModel.getPage(),10, sort);
		List<DataModel> dataPojoList = dataServiceSave.getDistrictData(district, pageable);
		model.addAttribute(Constants.CONST_DATA_COUNT, dataPojoList.size());
		 map.put(Constants.CONST_PAGE_VALUE, dataModel.getPage());
		 map.put(Constants.CONST_DISTRICT, dataModel.getDistrict());
		 map.put(Constants.CONST_DATA_LIST, dataPojoList);
		 map.put(Constants.CONST_ROWS_COUNT,dataPojoList.size());
		 map.put(Constants.CONST_DATA_POJO, dataModel);
		 return Constants.VIEW_MAINHOME;
	 }
	
	
	/*
	 * This method is used to get data based on district by javaScript form-submit.
	 */
	@RequestMapping(value="/getDistrictData", method=RequestMethod.POST)
	 public String getDistrictData( @ModelAttribute DataModel dataModel,Map<String, Object> map, Model model){
		dataModel.setPage(dataModel.getPage() == null ? 0 :dataModel.getPage());
		org.springframework.data.domain.Sort sort = new org.springframework.data.domain.Sort(Direction.ASC, "ocb");
		Pageable pageable= new PageRequest(dataModel.getPage(), 10,sort);
		List<DataModel> dataPojoList = dataServiceSave.getDistrictData(dataModel.getDistrict(), pageable);
		model.addAttribute(Constants.CONST_DATA_COUNT, dataPojoList.size());
		map.put(Constants.CONST_PAGE_VALUE, dataModel.getPage());
		 map.put(Constants.CONST_DISTRICT, dataModel.getDistrict());
		 map.put(Constants.CONST_DATA_LIST, dataPojoList);
		 map.put(Constants.CONST_ROWS_COUNT,dataPojoList.size());
		 map.put(Constants.CONST_DATA_POJO, dataModel);
		 return Constants.VIEW_MAINHOME;
	 }
	
	@RequestMapping(value = "/getEngUserData", method = RequestMethod.POST)
	 public String generateExcelForUserEng(HttpServletRequest request, HttpServletResponse response, @ModelAttribute DataModel dataModel, Model model, Map<String, Object> map) throws Exception {
		org.springframework.data.domain.Sort sort = new org.springframework.data.domain.Sort(Direction.ASC, dataModel.getCategory());
		Pageable pageable= new PageRequest(0,500,sort);
		List<DataModel> list = dataServiceSave.getData(dataModel,pageable);
		
			response.setHeader(Constants.CONST_EXCEL_CONTENT, Constants.CONST_EXCEL_ATTACHEMNT);
			response.setHeader(Constants.CONST_EXCEL_CONTENT_TYPE, Constants.CONST_EXCEL_SHEET_TYPE);
			XSSFWorkbook workbook=ExcelDownload.createUserData(list);
			OutputStream outputStream=response.getOutputStream();
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		
		return Constants.VIEW_ENGINEERING;
	}
	@RequestMapping(value = "/getMedUserData", method = RequestMethod.POST)
	 public String generateExcelForUserMed(HttpServletRequest request, HttpServletResponse response, @ModelAttribute DataModel dataModel, Model model, Map<String, Object> map) throws Exception {
		org.springframework.data.domain.Sort sort = new org.springframework.data.domain.Sort(Direction.ASC, dataModel.getCategory());
		Pageable pageable= new PageRequest(0,100,sort);
		List<DataModel> list = dataServiceSave.getData(dataModel,pageable);
		
			response.setHeader(Constants.CONST_EXCEL_CONTENT, Constants.CONST_EXCEL_ATTACHEMNT);
			response.setHeader(Constants.CONST_EXCEL_CONTENT_TYPE, Constants.CONST_EXCEL_SHEET_TYPE);
			XSSFWorkbook workbook=ExcelDownload.createUserData(list);
			OutputStream outputStream=response.getOutputStream();
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		return Constants.VIEW_MEDICAL;
	}
	
	@RequestMapping(value = "/getAgrUserData", method = RequestMethod.POST)
	 public String generateExcelForUserAgr(HttpServletRequest request, HttpServletResponse response, @ModelAttribute DataModel dataModel, Model model, Map<String, Object> map) throws Exception {
		org.springframework.data.domain.Sort sort = new org.springframework.data.domain.Sort(Direction.ASC, dataModel.getCategory());
		Pageable pageable= new PageRequest(0,25,sort);
		List<DataModel> list = dataServiceSave.getData(dataModel,pageable);
		
			response.setHeader(Constants.CONST_EXCEL_CONTENT, Constants.CONST_EXCEL_ATTACHEMNT);
			response.setHeader(Constants.CONST_EXCEL_CONTENT_TYPE, Constants.CONST_EXCEL_SHEET_TYPE);
			XSSFWorkbook workbook=ExcelDownload.createUserData(list);
			OutputStream outputStream=response.getOutputStream();
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		return Constants.VIEW_AGRICULTURAL;
	}
	
	@RequestMapping(value="/getDistUserData", method=RequestMethod.POST)
	 public String getDistUserData(HttpServletRequest request, HttpServletResponse response, @ModelAttribute DataModel dataModel) throws IOException{
		String fileName= "attachment; filename="+dataModel.getDistrict()+".xlsx";
		response.setHeader(Constants.CONST_EXCEL_CONTENT,fileName);
		response.setHeader(Constants.CONST_EXCEL_CONTENT_TYPE, Constants.CONST_EXCEL_SHEET_TYPE);
		org.springframework.data.domain.Sort sort = new org.springframework.data.domain.Sort(Direction.ASC, "ocb");
		Pageable pageable= new PageRequest(0, 500, sort);
		List<DataModel> list = dataServiceSave.getDistrictData(dataModel.getDistrict(), pageable);
		XSSFWorkbook workbook=ExcelDownload.createDistrictUserData(list);
		OutputStream outputStream=response.getOutputStream();
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
		 return Constants.VIEW_MAINHOME;
	 }
	
}
