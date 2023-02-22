package com.springboot.apitest2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apitest2.mapper.IUserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/delete-api")
public class DeleteController {
	
	@Autowired
	IUserMapper mapper;
	
	@DeleteMapping("/user/{name}")
	public String deleteUser(@PathVariable String name) {
		log.info("delete name : " + name);
		int result = mapper.deleteByName(name);
		log.info("delete result : " + result);
		
		String msg = "";
		if(result == 1) {
			msg = "<span style='color: blue'>삭제 성공</span>";
		}else {
			msg = "<span style='color: red'>삭제 실패</span>";
		}
		
		return msg;
	}
}
