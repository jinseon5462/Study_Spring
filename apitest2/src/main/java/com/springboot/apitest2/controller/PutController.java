package com.springboot.apitest2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apitest2.mapper.IUserMapper;
import com.springboot.apitest2.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/put-api/")
public class PutController {

	@Autowired
	IUserMapper mapper;
	
	@PutMapping("/user/{name}")
	public String modifyUser(@PathVariable String name, @RequestBody UserVO user) {
		log.info("name : " + name);
		log.info("user : " + user);
		
		int result = mapper.updateByName(name, user);
		String msg = "";
		
		if(result == 1) {
			msg = "<span style='color: blue'>수정 성공</span>";
		}else {
			msg = "<span style='color: red'>수정 실패</span>";
		}
		
		return msg;
	}
	
	@PutMapping("/user/map/{name}")
	public String modifyUser1(@PathVariable String name, @RequestBody UserVO user) {
		log.info("modifyUser1..... ");
		
		log.info("name : " + name);
		log.info("user : " + user);
		
		Map<String, Object> params = new HashMap<>();
		params.put("name", name);
		params.put("user", user);
		
		int result = mapper.updateByName1(params);
		String msg = "";
		
		if(result == 1) {
			msg = "<span style='color: blue'>수정 성공</span>";
		}else {
			msg = "<span style='color: red'>수정 실패</span>";
		}
		
		return msg;
	}
}
