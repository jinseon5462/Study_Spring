package com.springboot.apitest2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apitest2.mapper.IUserMapper;
import com.springboot.apitest2.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/get-api/")
//@CrossOrigin("*")
//@CrossOrigin(origins = {"http://localhost:8090", "http://localhost:8091"})
public class GetController {
	
	@Autowired
	IUserMapper mapper;
	
	//http://localhost:9001/api/get-api/user/cucu
	@GetMapping("/user/{name}")
	public String getUser(@PathVariable String name) {
		log.info("getUser....." + name);
		UserVO user = mapper.selectByName(name);
		log.info(user.toString());
		return "<span style='color: blue'>" + user.toString() + "</span>";
	}
	
}
