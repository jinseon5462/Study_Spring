package com.springboot.jdbc.dao;

import java.util.List;

import com.springboot.jdbc.dto.SampleDTO;

public interface ISampleDAO {
	public List<SampleDTO> getList();
	public SampleDTO getOne(Long no);
	public int regSample(String name, int age);
	public int deleteSample(Long no);
}
