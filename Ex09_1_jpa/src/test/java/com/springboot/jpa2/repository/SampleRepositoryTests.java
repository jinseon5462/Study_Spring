package com.springboot.jpa2.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.jpa2.entity.Sample;

@SpringBootTest
public class SampleRepositoryTests {
	
	@Autowired
	SampleRepository sampleRepository;
	
	//@Test
	public void autowiredTrue() {
		System.out.println(sampleRepository.getClass().getName());
	}
	
	//@Test
	public void insertTests() {
		IntStream.range(0, 20).forEach(i -> {
			Sample sample = Sample.builder()
					.name((i % 2 == 0)?"James" + i : "Anna" + i)
					.age(i + 10)
					.build();
			sampleRepository.save(sample);
		});
	}
	
	//@Test
	public void deleteAllTest() {
		sampleRepository.deleteAll();
	}
	
	//@Test
	public void deletetTest() {
		Long no = 22L;
		sampleRepository.deleteById(no);
	}
	
	//@Test
	public void selectOneTest() {
		Long no = 10L;
		//Sample s= sampleRepository.findById(no).orElseThrow();
		Optional<Sample> sample = sampleRepository.findById(no);
		
		if(sample.isPresent()) {
			Sample s = sample.get();
			System.out.println(s.toString());
		}
	}
	
	//@Test
	public void selectAll() {
		List<Sample> list = sampleRepository.findAll();
		for(Sample s : list) {
			System.out.println(s.toString());
		}
	}
	
	@Test
	public void updateTest() {
		Sample sample = new Sample();
		sample.setNo(1L);
		sample.setName("홍길동");
		sample.setAge(40);
		
		Sample result = sampleRepository.save(sample);
		System.out.println("result : " + result.toString());
	}
}
