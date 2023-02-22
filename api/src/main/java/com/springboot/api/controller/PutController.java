package com.springboot.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/put-api")
@Slf4j
public class PutController {
	//http://localhost:9001/api/v1/put-api/user
	@PutMapping("/user")
	public String postUser(@RequestBody Map<String, Object> postData) {
		StringBuilder sb = new StringBuilder();
		
		postData.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		return sb.toString();
	}
	
	//http://localhost:9001/api/v1/put-api/user1
	@PutMapping("/user1")
	public String postUserDTO(@RequestBody UserDTO user) {
		return user.toString();
	}
	
	//http://localhost:9001/api/v1/put-api/user2
	@PutMapping("/user2")
	public UserDTO postUserDTO2(@RequestBody UserDTO user) {
		log.info("/user2...");
		return user;
	}
}
