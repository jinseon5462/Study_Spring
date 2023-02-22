package com.restapi.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.exam.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/exam/delete-api")
@Slf4j
public class DeleteController {
	
	@Autowired
	private IUserService service;
	
	@DeleteMapping("/user/{name}")
	public String deleteUser(@PathVariable String name) {
		log.info("DELETE Controller\n이름 : " + name);
		int result = service.deleteUser(name);
		if(result == 1) {
			return "<span style='color: green;'>삭제성공!</span>";
		}else {
			return "<span style='color: red;'>삭제실패...</span>";
		}
	}
}
