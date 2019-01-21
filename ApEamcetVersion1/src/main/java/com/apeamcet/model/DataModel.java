package com.apeamcet.model;

/*
 * This model class is used to get the data from user interface and also used to set the data onto user interface.
 */

public class DataModel {
	
	String Code;
	String InstituteName;
	String CourseCode;
	String Region;
	String District;
	String Place;
	String category;  //to take category from User
	Integer rank; // to take rank from user
	Integer page;
	Integer OCB;
	Integer OCG;
	Integer SCB;
	Integer SCG;
	Integer STB;
	Integer STG;
	Integer BCAB;
	Integer BCAG;
	Integer BCBB;
	Integer BCBG;
	Integer BCCB;
	Integer BCCG;
	Integer BCDB;
	Integer BCDG;
	Integer BCEB;
	Integer BCEG;
	String type;
	int year;
	
	/*
	 * Constructors
	 */
	public DataModel() {
		super();
	}
	public DataModel(int id, String code, String instituteName,
			String courseCode, String region, String district, String place,
			Integer oCB, Integer oCG, Integer sCB, Integer sCG, Integer sTB,
			Integer sTG, Integer bCAB, Integer bCAG, Integer bCBB, Integer bCBG,
			Integer bCCB, Integer bCCG, Integer bCDB, Integer bCDG, Integer bCEB,
			Integer bCEG, String type, int year, Integer rank, String category, Integer page) {
		super();
	
		Code = code;
		InstituteName = instituteName;
		CourseCode = courseCode;
		Region = region;
		District = district;
		Place = place;
		OCB = oCB;
		OCG = oCG;
		SCB = sCB;
		SCG = sCG;
		STB = sTB;
		STG = sTG;
		BCAB = bCAB;
		BCAG = bCAG;
		BCBB = bCBB;
		BCBG = bCBG;
		BCCB = bCCB;
		BCCG = bCCG;
		BCDB = bCDB;
		BCDG = bCDG;
		BCEB = bCEB;
		BCEG = bCEG;
		this.type=type;
		this.year=year;
		this.rank=rank;
		this.category=category;
		this.page=page;
	}
	
	
	/*
	 * Getters and Setters.
	 */
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getInstituteName() {
		return InstituteName;
	}
	public void setInstituteName(String instituteName) {
		InstituteName = instituteName;
	}
	public String getCourseCode() {
		return CourseCode;
	}
	public void setCourseCode(String courseCode) {
		CourseCode = courseCode;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	public Integer getOCB() {
		return OCB;
	}
	public void setOCB(Integer oCB) {
		OCB = oCB;
	}
	public Integer getOCG() {
		return OCG;
	}
	public void setOCG(Integer oCG) {
		OCG = oCG;
	}
	public Integer getSCB() {
		return SCB;
	}
	public void setSCB(Integer sCB) {
		SCB = sCB;
	}
	public Integer getSCG() {
		return SCG;
	}
	public void setSCG(Integer sCG) {
		SCG = sCG;
	}
	public Integer getSTB() {
		return STB;
	}
	public void setSTB(Integer sTB) {
		STB = sTB;
	}
	public Integer getSTG() {
		return STG;
	}
	public void setSTG(Integer sTG) {
		STG = sTG;
	}
	public Integer getBCAB() {
		return BCAB;
	}
	public void setBCAB(Integer bCAB) {
		BCAB = bCAB;
	}
	public Integer getBCAG() {
		return BCAG;
	}
	public void setBCAG(Integer bCAG) {
		BCAG = bCAG;
	}
	public Integer getBCBB() {
		return BCBB;
	}
	public void setBCBB(Integer bCBB) {
		BCBB = bCBB;
	}
	public Integer getBCBG() {
		return BCBG;
	}
	public void setBCBG(Integer bCBG) {
		BCBG = bCBG;
	}
	public Integer getBCCB() {
		return BCCB;
	}
	public void setBCCB(Integer bCCB) {
		BCCB = bCCB;
	}
	public Integer getBCCG() {
		return BCCG;
	}
	public void setBCCG(Integer bCCG) {
		BCCG = bCCG;
	}
	public Integer getBCDB() {
		return BCDB;
	}
	public void setBCDB(Integer bCDB) {
		BCDB = bCDB;
	}
	public Integer getBCDG() {
		return BCDG;
	}
	public void setBCDG(Integer bCDG) {
		BCDG = bCDG;
	}
	public Integer getBCEB() {
		return BCEB;
	}
	public void setBCEB(Integer bCEB) {
		BCEB = bCEB;
	}
	public Integer getBCEG() {
		return BCEG;
	}
	public void setBCEG(Integer bCEG) {
		BCEG = bCEG;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
}
