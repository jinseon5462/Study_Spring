package com.restapi.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.exam.dto.UserDTO;
import com.restapi.exam.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/exam/put-api")
@Slf4j
public class PutController {
	@Autowired
	private IUserService service;
	
	@PutMapping("/user/{name}")
	public String updateUser(@PathVariable String name, @RequestBody UserDTO user) {
		log.info(name + ", " + user.toString());
		int result = service.updateUser(name, user);
		if(result == 1) {
			return "<span style='color: green;'>수정성공!</span>";
		}else {
			return "<span style='color: red;'>수정실패...</span>";
		}
	}
}