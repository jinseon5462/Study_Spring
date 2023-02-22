package com.springboot.jdbc.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.jdbc.dto.SampleDTO;

@SpringBootTest
public class SampleDAOTests {
	
	@Autowired
	SampleDAO dao;
	
	@Test
	public void getListTests() {
		List<SampleDTO> list = dao.getList();
		for(SampleDTO sample : list) {
			System.out.println(sample);
		}
	}
}
