package com.example.jpa3.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.jpa3.entity.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long>{
	// 기본 CRUD 기능을 제공해준다 : EntityManager
	// C(등록) : 생성 -> save(entity), R(전체읽기) : findAll(), R(개별) : findById(숫자), U(수정) : save(entity), D(삭제) : deleteById(숫자), deleteAll()
	
	// 이름으로 검색 - findByName(String)
	public List<Sample> findByNameOrderByAgeDesc(String name);
	public List<Sample> findByNameEndsWith(String keyword);
	public List<Sample> findByNameStartsWith(String keyword);
	public List<Sample> findByNameContaining(String keyword);
	public List<Sample> findByAge(String keyword);
	public List<Sample> findByNameLike(String keyword);
	public List<Sample> findByAgeBetween(int start, int end);
	public List<Sample> findByAgeBetweenOrderByAgeDesc(int start, int end);
	@Transactional
	public void deleteSampleByNoLessThan(Long no);
	@Query("SELECT COUNT(*) FROM Sample")
	public int getSampleCount();
	
	// JPQL : Java Persistence Query Language
	// SELECT * FROM sample_tbl ORDER BY age DESC
	@Query("SELECT s FROM Sample as s ORDER BY s.age DESC")
	public List<Sample> getListOrderByAge();
	
	// SELECT * FROM tbl_sample WHERE name LIKE '~';
	@Query("SELECT s FROM Sample s WHERE s.name LIKE ?1")
	public List<Sample> getSamplesByName(String str);
	
	@Query("SELECT s FROM Sample s WHERE s.name LIKE :kkk")
	public List<Sample> getSamplesByName2(@Param("kkk") String str);
	
	@Query("SELECT s FROM Sample s WHERE s.name = :#{#param.name}")
	public List<Sample> getSamplesByName3(@Param("param") Sample sample);
	
}
