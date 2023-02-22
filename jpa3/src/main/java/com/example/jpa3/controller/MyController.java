package com.example.jpa3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jpa3.entity.Sample;
import com.example.jpa3.repository.SampleRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyController {
	
	@Autowired
	private SampleRepository sampleRepository;
	
	// http://localhost:8090/
	@GetMapping("/")
	public String root() {	// 자바 일반클래스 : 포조라고 부른다.
		return "hello";	// 응답의 종류 1. 페이지(view - jsp), 2. 순수 데이터(AJAX)
	}
	
	// http://localhost:8090/index
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/searchForm")
	public void searchForm() {}
	
	@PostMapping("/search.do")
	@ResponseBody
	public List<Sample> getSearchList(String sel, String keyword){
		List<Sample> list = new ArrayList<>();
//		if(sel == "name") {
//			list = sampleRepository.findByNameContaining(keyword);
//		}else {
//			list = sampleRepository.findByAge(keyword);
//		}
		Sample sample = new Sample();
		return list;
	}
	
}
