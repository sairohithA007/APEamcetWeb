package com.apeamcet.dao;

import java.util.List;	

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.apeamcet.domain.Data;
import com.apeamcet.repo.DataRepo;


@Repository
public class DataDaoImpl implements DataDao {
	@Autowired
	DataRepo dataRepo;
	public void save(Data data) {
		dataRepo.save(data);
	}
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.dao.DataDao#delete(java.lang.String, int)
	 * This method is used to delete the data present in the table Data, based on type and year.
	 */
	public void delete(String type, int year) {
		dataRepo.deleteByTypeAndYear(type, year);
	}
	public Long total(){
		return dataRepo.count();
	}
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.dao.DataDao#retrieveAll()
	 * This method is used to retrieve all the data present in table Data.
	 */
	public java.util.List<Data> retrieve(String type, Integer year) {
		return dataRepo.findByTypeAndYear(type, year);
	}
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.dao.DataDao#deleteAll(int)
	 * This method used to delete the data present in table Data, based on year.
	 */
	public void deleteAll(int year) {
		dataRepo.deleteByYear(year);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.dao.DataDao#getData(java.lang.String, java.lang.Integer, java.lang.String, java.lang.String)
	 * This method is used to retrieve the data based on User's request from the table Data. 
	 */
	
	public List<Data> getData(String coursecode,Integer rank, String category, String district, Pageable pageable){
		switch(category){
		case "ocb":	if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndOcbGreaterThan(coursecode, rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndOcbGreaterThan(district, coursecode,rank, pageable);
					}
		case "ocg": if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndOcgGreaterThan(coursecode, rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndOcgGreaterThan(district, coursecode, rank, pageable);
					}
		case "scb":if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndScbGreaterThan(coursecode, rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndScbGreaterThan(district, coursecode,rank, pageable);
					}
		case "scg":if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndScgGreaterThan(coursecode, rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndScgGreaterThan(district, coursecode, rank, pageable);
					}
		case "stb":if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndStbGreaterThan(coursecode, rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndStbGreaterThan(district, coursecode,rank, pageable);
					}
		case "stg":if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndStgGreaterThan(coursecode, rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndStgGreaterThan(district, coursecode, rank, pageable);
					}
		case "bcab":if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndBcabGreaterThan(coursecode, rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndBcabGreaterThan(district, coursecode, rank, pageable);
					}
		case "bcag":if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndBcagGreaterThan(coursecode, rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndBcagGreaterThan(district, coursecode, rank, pageable);
					}
		case "bcbb":if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndBcbbGreaterThan(coursecode,rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndBcbbGreaterThan(district, coursecode, rank, pageable);
					}
		case "bcbg":if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndBcbgGreaterThan(coursecode, rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndBcbgGreaterThan(district, coursecode, rank, pageable);
					}
		case "bccb":if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndBccbGreaterThan(coursecode,rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndBccbGreaterThan(district, coursecode, rank, pageable);
					}
		case "bccg":if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndBccgGreaterThan(coursecode, rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndBccgGreaterThan(district, coursecode, rank, pageable);
					}
		case "bcdb":if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndBcdbGreaterThan(coursecode, rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndBcdbGreaterThan(district, coursecode, rank, pageable);
					}
		case "bcdg":if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndBcdgGreaterThan(coursecode, rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndBcdgGreaterThan(district, coursecode, rank, pageable);
					}
		case "bceb":if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndBcebGreaterThan(coursecode, rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndBcebGreaterThan(district, coursecode, rank, pageable);
					}
		case "bceg":if(district.equalsIgnoreCase("All")){
						return dataRepo.findByCoursecodeAndBcegGreaterThan(coursecode, rank, pageable);
					} else{
						return dataRepo.findByDistrictAndCoursecodeAndBcegGreaterThan(district, coursecode, rank, pageable);
					}
		}
		return null;
		
	}
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.dao.DataDao#saveAll(java.lang.Iterable)
	 * This method is used to save list of records as batch upload to the table Data.
	 */
	public void saveAll(Iterable<Data> dataList) {
		dataRepo.save(dataList);
	}
	/*
	 * (non-Javadoc)
	 * @see com.apeamcet.dao.DataDao#getDistrictData(java.lang.String)
	 * 
	 */
	@Override
	public List<Data> getDistrictData(String district,Pageable pageable) {
		return dataRepo.findByDistrict(district, pageable);
	}
	@Override
	public List<Data> retrieve(int year) {
		return dataRepo.findByYear(year);
	}
	
	
}
