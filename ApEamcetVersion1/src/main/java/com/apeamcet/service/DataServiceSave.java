package com.apeamcet.service;

import java.io.FileNotFoundException;	
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;	

import com.apeamcet.domain.Data;
import com.apeamcet.exception.InvalidException;
import com.apeamcet.model.DataModel;



public interface DataServiceSave {
	public String saveContents(MultipartFile file, DataModel dataPojo) throws InvalidException;
	public List<Data> download(DataModel dataModel) throws FileNotFoundException;
	public List<DataModel> getData(DataModel dataPojo, Pageable pageable);
	//public List<DataPojo> getAgrData(DataPojo dataPojo);
	public List<DataModel> getDistrictData(String dsitrict, Pageable pageable);
//	/public List<Data> downloadUserData(DataModel dataModel);
}
