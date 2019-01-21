package com.apeamcet.dao;

import java.util.List;	

import org.springframework.data.domain.Pageable;

import com.apeamcet.domain.Data;



public interface DataDao {
	public void save(Data data);
	public void delete(String type, int year);
	public Long total();
	public List<Data> retrieve(String type, Integer year);
	public void deleteAll(int i);
	public List<Data> getData(String branch,Integer rank, String category, String District, Pageable pageable);
	public void saveAll(Iterable<Data> dataList);
	public List<Data> getDistrictData(String district,Pageable pageable);
	public List<Data> retrieve(int year);
}
