package com.springboot.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.jdbc.dto.SampleDTO;

@Repository
public class SampleDAO implements ISampleDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<SampleDTO> getList(){
		String sql = "SELECT * FROM sample_tbl";
		List<SampleDTO> list = jdbcTemplate.query(
					sql,
					new BeanPropertyRowMapper<SampleDTO>(SampleDTO.class)
				);
		return list;
	}

	@Override
	public SampleDTO getOne(Long no) {
		String sql = "SELECT * FROM sample_tbl WHERE no = " + no;
		SampleDTO sample = jdbcTemplate.queryForObject(	// db에서 자료 하나만 얻어올 때.
				sql,
				new BeanPropertyRowMapper<SampleDTO>(SampleDTO.class)
				);
		return null;
	}

	@Override
	public int regSample(String name, int age) {
		String sql = "INSERT INTO sample_tbl (name, age) VALUES (?, ?)";
		int result = 0;
		result = jdbcTemplate.update(sql, name, age);
		return result;
	}

	@Override
	public int deleteSample(Long no) {
		String sql = "DELETE FROM sample_tbl WHERE no = ?";
		int result = 0;
		result = jdbcTemplate.update(sql, no);
		return result;
	}
}
