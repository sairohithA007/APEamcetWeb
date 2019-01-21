package com.apeamcet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
 * Entity class which is used to update the database table(Data).
 */
@Entity
public class Data {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@Column
	String code;
	@Column
	String institutename;
	@Column
	String coursecode;
	@Column
	String region;
	@Column
	String district;
	@Column
	String place;
	@Column
	Integer ocb;
	@Column
	Integer ocg;
	@Column
	Integer scb;
	@Column
	Integer scg;
	@Column
	Integer stb;
	@Column
	Integer stg;
	@Column
	Integer bcab;
	@Column
	Integer bcag;
	@Column
	Integer bcbb;
	@Column
	Integer bcbg;
	@Column
	Integer bccb;
	@Column
	Integer bccg;
	@Column
	Integer bcdb;
	@Column
	Integer bcdg;
	@Column
	Integer bceb;
	@Column
	Integer bceg;
	@Column
	String type;
	@Column
	int year;
	
	public Data() {
		super();
	}

	public Data(int id, String code, String institutename, String coursecode,
			String region, String district, String place, Integer ocb,
			Integer ocg, Integer scb, Integer scg, Integer stb, Integer stg,
			Integer bcab, Integer bcag, Integer bcbb, Integer bcbg, Integer bccb,
			Integer bccg, Integer bcdb, Integer bcdg, Integer bceb, Integer bceg,
			String type, int year) {
		super();
		this.id = id;
		this.code = code;
		this.institutename = institutename;
		this.coursecode = coursecode;
		this.region = region;
		this.district = district;
		this.place = place;
		this.ocb = ocb;
		this.ocg = ocg;
		this.scb = scb;
		this.scg = scg;
		this.stb = stb;
		this.stg = stg;
		this.bcab = bcab;
		this.bcag = bcag;
		this.bcbb = bcbb;
		this.bcbg = bcbg;
		this.bccb = bccb;
		this.bccg = bccg;
		this.bcdb = bcdb;
		this.bcdg = bcdg;
		this.bceb = bceb;
		this.bceg = bceg;
		this.type = type;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInstitutename() {
		return institutename;
	}

	public void setInstitutename(String institutename) {
		this.institutename = institutename;
	}

	public String getCoursecode() {
		return coursecode;
	}

	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDistrict() {
		return district;
	}

	public void setdistrict(String district) {
		this.district = district;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Integer getOcb() {
		return ocb;
	}

	public void setOcb(Integer ocb) {
		this.ocb = ocb;
	}

	public Integer getOcg() {
		return ocg;
	}

	public void setOcg(Integer ocg) {
		this.ocg = ocg;
	}

	public Integer getScb() {
		return scb;
	}

	public void setScb(Integer scb) {
		this.scb = scb;
	}

	public Integer getScg() {
		return scg;
	}

	public void setScg(Integer scg) {
		this.scg = scg;
	}

	public Integer getStb() {
		return stb;
	}

	public void setStb(Integer stb) {
		this.stb = stb;
	}

	public Integer getStg() {
		return stg;
	}

	public void setStg(Integer stg) {
		this.stg = stg;
	}

	public Integer getBcab() {
		return bcab;
	}

	public void setBcab(Integer bcab) {
		this.bcab = bcab;
	}

	public Integer getBcag() {
		return bcag;
	}

	public void setBcag(Integer bcag) {
		this.bcag = bcag;
	}

	public Integer getBcbb() {
		return bcbb;
	}

	public void setBcbb(Integer bcbb) {
		this.bcbb = bcbb;
	}

	public Integer getBcbg() {
		return bcbg;
	}

	public void setBcbg(Integer bcbg) {
		this.bcbg = bcbg;
	}

	public Integer getBccb() {
		return bccb;
	}

	public void setBccb(Integer bccb) {
		this.bccb = bccb;
	}

	public Integer getBccg() {
		return bccg;
	}

	public void setBccg(Integer bccg) {
		this.bccg = bccg;
	}

	public Integer getBcdb() {
		return bcdb;
	}

	public void setBcdb(Integer bcdb) {
		this.bcdb = bcdb;
	}

	public Integer getBcdg() {
		return bcdg;
	}

	public void setBcdg(Integer bcdg) {
		this.bcdg = bcdg;
	}

	public Integer getBceb() {
		return bceb;
	}

	public void setBceb(Integer bceb) {
		this.bceb = bceb;
	}

	public Integer getBceg() {
		return bceg;
	}

	public void setBceg(Integer bceg) {
		this.bceg = bceg;
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
	
}
