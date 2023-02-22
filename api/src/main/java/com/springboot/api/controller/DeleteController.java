package com.springboot.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
	
	//http://localhost:9001/api/v1/delete-api/aaa
	@DeleteMapping("/{variable}")
	public String deleteVariable(@PathVariable String variable) {
		return variable;
	}
	
	//http://localhost:9001/api/v1/delete-api/request1?email=value
	@DeleteMapping("/request1")
	public String getParam(@RequestParam String email) {
		return "email : " + email;
	}
}
