package com.apeamcet.repo;

import java.util.List;	

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;	

import com.apeamcet.domain.Data;



public interface DataRepo extends JpaRepository<Data, Long> {
	//Data findByCode(String code);
	void deleteByTypeAndYear(String type, int year);

	void deleteByYear(int year);
	
	List<Data> findByDistrict(String district,Pageable pageable);
	
	/*
	 * The below methods are written to retrieve the data from database based on District and CourseCode and range of ranks.
	 */
	
	List<Data> findByDistrictAndCoursecodeAndOcbGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);

	List<Data> findByDistrictAndCoursecodeAndOcgGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);

	List<Data> findByDistrictAndCoursecodeAndScbGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);

	List<Data> findByDistrictAndCoursecodeAndScgGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);

	List<Data> findByDistrictAndCoursecodeAndStbGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);

	List<Data> findByDistrictAndCoursecodeAndStgGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);

	List<Data> findByDistrictAndCoursecodeAndBcabGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);

	List<Data> findByDistrictAndCoursecodeAndBcbbGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);

	List<Data> findByDistrictAndCoursecodeAndBcagGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);

	List<Data> findByDistrictAndCoursecodeAndBcbgGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);

	List<Data> findByDistrictAndCoursecodeAndBccbGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);

	List<Data> findByDistrictAndCoursecodeAndBccgGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);

	List<Data> findByDistrictAndCoursecodeAndBcdbGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);

	List<Data> findByDistrictAndCoursecodeAndBcdgGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);

	List<Data> findByDistrictAndCoursecodeAndBcebGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);

	List<Data> findByDistrictAndCoursecodeAndBcegGreaterThan(String district,
			String coursecode, Integer rank, Pageable pageable);
	/*
	 * The below methods are written to retrieve the data from database based on CourseCode and range of ranks.
	 */
	List<Data> findByCoursecodeAndOcbGreaterThan(String coursecode, Integer rank, Pageable pageable);

	List<Data> findByCoursecodeAndOcgGreaterThan(String coursecode, Integer rank, Pageable pageable);

	List<Data> findByCoursecodeAndScbGreaterThan(String coursecode, Integer rank, Pageable pageable);

	List<Data> findByCoursecodeAndScgGreaterThan(String coursecode, Integer rank, Pageable pageable);

	List<Data> findByCoursecodeAndStbGreaterThan(String coursecode, Integer rank, Pageable pageable);

	List<Data> findByCoursecodeAndStgGreaterThan(String coursecode, Integer rank, Pageable pageable);

	List<Data> findByCoursecodeAndBcabGreaterThan(String coursecode,
			Integer rank, Pageable pageable);

	List<Data> findByCoursecodeAndBcagGreaterThan(String coursecode, Integer rank, Pageable pageable);

	List<Data> findByCoursecodeAndBcbbGreaterThan(String coursecode,
			Integer rank, Pageable pageable);

	List<Data> findByCoursecodeAndBcbgGreaterThan(String coursecode,
			Integer rank, Pageable pageable);

	List<Data> findByCoursecodeAndBccbGreaterThan(String coursecode,
			Integer rank, Pageable pageable);

	List<Data> findByCoursecodeAndBccgGreaterThan(String coursecode,
			Integer rank, Pageable pageable);

	List<Data> findByCoursecodeAndBcdbGreaterThan(String coursecode,
			Integer rank, Pageable pageable);

	List<Data> findByCoursecodeAndBcdgGreaterThan(String coursecode,
			Integer rank, Pageable pageable);

	List<Data> findByCoursecodeAndBcebGreaterThan(String coursecode,
			Integer rank, Pageable pageable);

	List<Data> findByCoursecodeAndBcegGreaterThan(String coursecode,
			Integer rank, Pageable pageable);

	List<Data> findByTypeAndYear(String type, Integer year);

	List<Data> findByYear(int year);

	
	
	

	
}
