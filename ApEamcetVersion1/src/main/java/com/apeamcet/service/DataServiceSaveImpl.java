package com.apeamcet.service;

import java.io.FileNotFoundException;	
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;





import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.apeamcet.dao.DataDao;
import com.apeamcet.domain.Data;
import com.apeamcet.exception.InvalidException;
import com.apeamcet.model.DataModel;
import com.apeamcet.util.Constants;
import com.apeamcet.validate.ValidateUpload;


@Service
public class DataServiceSaveImpl implements DataServiceSave {

	DataDao dataDao;
	@Inject
	DataServiceSaveImpl(DataDao dataDao){
		this.dataDao=dataDao;
	}
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.service.DataServiceSave#saveContents(org.springframework.web.multipart.MultipartFile, com.apeamcet.model.DataModel)
	 * saveContents validates the file type(Excel), Excel file headers with database column names. It then saves each record to the list and
	 * then saves the list to database.
	 */
	@Transactional
	public String saveContents(MultipartFile file, DataModel dataPojo) throws InvalidException {
				
			XSSFWorkbook offices;
			int rowValue=1;
			try {
				offices = new XSSFWorkbook(file.getInputStream());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			XSSFSheet worksheet=offices.getSheetAt(0);
			Iterator<Row> rite= worksheet.rowIterator();
				if(rite.hasNext()){
					XSSFRow row=(XSSFRow)rite.next();
						if(!ValidateUpload.validateHeader(row)){
								return Constants.CONST_ERROR_IN_EXCEL_FORMAT;
						}
				}
			Iterable<Data> dataList= new ArrayList<Data>();	
			while(rite.hasNext()){
					XSSFRow dataRow=(XSSFRow)rite.next();
					ArrayList<Integer> intList= new ArrayList<Integer>();
					ArrayList<String> strList=new ArrayList<String>();
					Iterator<Cell> cite = dataRow.cellIterator();
						while(cite.hasNext()){
							Cell cell = cite.next();
								switch(cell.getCellType()){
									case Cell.CELL_TYPE_STRING: strList.add(cell.getStringCellValue().toString());	break;
									case  Cell.CELL_TYPE_NUMERIC: intList.add((int) cell.getNumericCellValue());	break;
									case Cell.CELL_TYPE_BLANK: throw new InvalidException(Constants.CONST_ERROR_BLANK_DATA_CELLS); 
									default : throw new InvalidException(Constants.CONST_ERROR_IN_EXCEL_CELL);
								}	
						}
						rowValue++;
						Data data=new Data();
						//System.out.println("Int: "+intList.size()+"Str: "+ (int)strList.size());
						if((intList.size()<17)||(strList.size()<7)){
							return Constants.CONST_ERROR_INVALID_DATA+rowValue;
						}
						data.setCode(strList.get(0));
						data.setInstitutename(strList.get(1));
						data.setCoursecode(strList.get(2));
						data.setRegion(strList.get(3));
						data.setdistrict(strList.get(4));
						data.setPlace(strList.get(5));
						data.setType(strList.get(6));
						data.setOcb(intList.get(0));
						data.setOcg(intList.get(1));
						data.setScb(intList.get(2));
						data.setScg(intList.get(3));
						data.setStb(intList.get(4));
						data.setStg(intList.get(5));
						data.setBcab(intList.get(6));
						data.setBcag(intList.get(7));
						data.setBcbb(intList.get(8));
						data.setBcbg(intList.get(9));
						data.setBccb(intList.get(10));
						data.setBccg(intList.get(11));
						data.setBcdb(intList.get(12));
						data.setBcdg(intList.get(13));
						data.setBceb(intList.get(14));
						data.setBceg(intList.get(15));
						data.setYear(dataPojo.getYear());
						((ArrayList<Data>)dataList).add(data);
						//intList.clear();
						//strList.clear();
						
			}
			String type=dataPojo.getType();
			int year = dataPojo.getYear();
				if(dataPojo.getType().equalsIgnoreCase("All")){
					dataDao.deleteAll(year);
				}
				else{
					dataDao.delete(type, year);
				}
					dataDao.saveAll(dataList);
		return Constants.CONST_SUCCESSFULL;
	}
				
					
				
			
		/*
		 * (non-Javadoc)
		 * @see com.apeamcet.service.DataServiceSave#download()
		 * This method is used to download the data present in the database table.
		 */
	
	public List<Data> download(DataModel dataModel) throws FileNotFoundException {
		List<Data> dataList= new ArrayList<Data>();
		if(dataModel.getType().equalsIgnoreCase("All")){
			dataList= dataDao.retrieve(dataModel.getYear());
		}else{
		dataList =dataDao.retrieve(dataModel.getType(), dataModel.getYear());
		}
		return dataList;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.service.DataServiceSave#getData(com.apeamcet.model.DataModel)
	 * This method is used to retrieve the data base don the Normal user's request.
	 */
	
	public List<DataModel> getData(DataModel dataPojo, Pageable pageable) {
		
		List<Data> dataList= new ArrayList<Data>();
		List<DataModel> dataPojoList= new ArrayList<DataModel>();
		dataList=dataDao.getData(dataPojo.getCourseCode(), dataPojo.getRank(), dataPojo.getCategory(), dataPojo.getDistrict(), pageable);
		for(Data data:dataList){
			DataModel datapojo= new DataModel();
			switch(dataPojo.getCategory()){
			case "ocb": datapojo.setRank(data.getOcb()); break;
			case "ocg": datapojo.setRank(data.getOcg());break;
			case "scb": datapojo.setRank(data.getScb()); break;
			case "scg": datapojo.setRank(data.getScg());break;
			case "stb": datapojo.setRank(data.getStb()); break;
			case "stg": datapojo.setRank(data.getStg());break;
			case "bcab": datapojo.setRank(data.getBcab()); break;
			case "bcag": datapojo.setRank(data.getBcag());break;
			case "bcbb": datapojo.setRank(data.getBcbb()); break;
			case "bcbg": datapojo.setRank(data.getBcbg());break;
			case "bccb": datapojo.setRank(data.getBccb()); break;
			case "bccg": datapojo.setRank(data.getBccg());break;
			case "bcdb": datapojo.setRank(data.getBcdb()); break;
			case "bcdg": datapojo.setRank(data.getBcdg());break;
			case "bceb": datapojo.setRank(data.getBceb()); break;
			case "bceg": datapojo.setRank(data.getBceg());break;
			
			}
			datapojo.setCode(data.getCode());
			datapojo.setInstituteName(data.getInstitutename());
			datapojo.setCourseCode(data.getCoursecode());
			datapojo.setDistrict(data.getDistrict());
			datapojo.setPlace(data.getPlace());
			datapojo.setYear(data.getYear());
			datapojo.setType(data.getType());
			dataPojoList.add(datapojo);
		}
		return dataPojoList;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.service.DataServiceSave#getDistrictData(java.lang.String)
	 * Get data by district.
	 */
	@Override
	public List<DataModel> getDistrictData(String district,Pageable pageable) {
			List<Data> dataList= new ArrayList<Data>();
			dataList=dataDao.getDistrictData(district, pageable);
			List<DataModel> dataModelList = new ArrayList<DataModel>();
			for(Data data:dataList){
				DataModel dataModel= new DataModel();
				dataModel.setCode(data.getCode());
				dataModel.setInstituteName(data.getInstitutename());
				dataModel.setCourseCode(data.getCoursecode());
				dataModel.setPlace(data.getPlace());
				dataModel.setDistrict(data.getDistrict());
				dataModel.setType(data.getType());
				dataModelList.add(dataModel);
			}
			return dataModelList;
	}
	

}
