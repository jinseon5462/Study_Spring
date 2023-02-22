package com.restapi.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.exam.dto.UserDTO;
import com.restapi.exam.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/exam/post-api")
@Slf4j
public class PostController {
	
	@Autowired
	private IUserService service;
	
	@PostMapping("/user")
	public int regUser(@RequestBody UserDTO user) {
		int result = service.regUser(user);
		return result;
	}
}
