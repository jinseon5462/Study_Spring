package com.example.jpa3.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa3.entity.Sample;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class SampleRepositoryTests {
	
	@Autowired
	private SampleRepository sampleRepository;
	
	//@Test
	public void insertTest() {
		//save(entity)
		Sample sample = new Sample();
		sample.setAge(55);
		sample.setName("곽춘배");
		sampleRepository.save(sample);
	}
	
	//@Test
	public void selectTest() {
		Long no = 1L;
		Optional<Sample> sample = sampleRepository.findById(no);
		if(sample.isPresent()) {
			Sample sp = sample.get();
			log.info(sp.toString());
		}
	}
	
	//@Test
	public void selectAllTest() {
		List<Sample> list = sampleRepository.findAll();
		for(Sample sample : list) {
			log.info(sample.toString());
		}
	}
	
	//@Test
	public void updateTest() {
		Sample sample = new Sample();
		sample.setNo(2L);
		sample.setName("엄복순");
		sample.setAge(22);
		Sample s = sampleRepository.save(sample);
		log.info(s.toString());
	}
	
	//@Test
	public void deleteTest() {
		 sampleRepository.deleteById(2L);
	}
	
	//@Test
	public void findByNameTest() {
		List<Sample> list = sampleRepository.findByNameOrderByAgeDesc("곽두팔");
		for(Sample sample : list) {
			log.info(sample.toString());
		}
	}
	
	//@Test
	public void findByNameEndsWidthTest() {
		List<Sample> list = sampleRepository.findByNameEndsWith("동");
		for(Sample sample : list) {
			log.info(sample.toString());
		}
	}
	
	//@Test
	public void findByNameStartsWidthTest() {
		List<Sample> list = sampleRepository.findByNameStartsWith("엄");
		for(Sample sample : list) {
			log.info(sample.toString());
		}
	}
	//@Test
	public void findByNameContainingTest() {
		List<Sample> list = sampleRepository.findByNameContaining("춘");
		for(Sample sample : list) {
			log.info(sample.toString());
		}
	}
	//@Test
	public void findByNameLikeTest() {
		String str = "춘";
		List<Sample> list = sampleRepository.findByNameLike("%" + str + "%");
		for(Sample sample : list) {
			log.info(sample.toString());
		}
	}
	//@Test
	public void findByAgeBetween() {
		List<Sample> list = sampleRepository.findByAgeBetween(10, 30);
		for(Sample sample : list) {
			log.info(sample.toString());
		}
	}
	//@Test
	public void findByAgeBetweenOrderByAgeDescTest() {
		List<Sample> list = sampleRepository.findByAgeBetweenOrderByAgeDesc(10, 30);
		for(Sample sample : list) {
			log.info(sample.toString());
		}
	}
	//@Test
	public void deleteSampleByNoLessThan() {
		sampleRepository.deleteSampleByNoLessThan(3L);
	}
	
	//@Test
	public void getCountTest() {
		int count = sampleRepository.getSampleCount();
		log.info("sample_count : " + count);
	}
	
	// SELECT * FROM sample_tbl ORDER BY age DESC
	//@Test
	public void getListOrderByAgeTest() {
		List<Sample> list = sampleRepository.getListOrderByAge();
		for(Sample sample : list) {
			log.info(sample.toString());
		}
	}
	
	//@Test
	public void getSamplesByNameTest() {
		String str = "%길%";
		List<Sample> list = sampleRepository.getSamplesByName(str);
		for(Sample sample : list) {
			log.info(sample.toString());
		}
	}
	//@Test
	public void getSamplesByNameTest2() {
		String str = "%길%";
		List<Sample> list = sampleRepository.getSamplesByName2(str);
		for(Sample sample : list) {
			log.info(sample.toString());
		}
	}
	//@Test
	public void getSamplesByNameTest3() {
		Sample sample = new Sample();
		sample.setName("곽춘배");
		sample.setAge(22);
		List<Sample> list = sampleRepository.getSamplesByName3(sample);
		for(Sample s : list) {
			log.info(s.toString());
		}
	}
	
	//@Test
	public void getNativeResult() {
	}
}
