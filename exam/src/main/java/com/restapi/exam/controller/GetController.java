package com.restapi.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.exam.dto.UserDTO;
import com.restapi.exam.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/exam/get-api")
@Slf4j
//@CrossOrigin("*")
@CrossOrigin(origins = {"http://localhost:8090", "http://localhost:8091"})
public class GetController {

	@Autowired
	private IUserService service;
	
	@GetMapping("/user/{name}")
	public UserDTO getUser(@PathVariable String name) {
		UserDTO user = service.getUser(name);
		return user;
	}
}
