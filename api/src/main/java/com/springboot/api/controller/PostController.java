package com.springboot.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.UserDTO;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
	
	//http://localhost:9001/api/v1/post-api/domain
	@PostMapping("/domain")
	public String postExample() {
		return "Hello Post API";
	}
	
	@PostMapping("/user")
	//@RequestBody : HTTP의 Body 내용을 해당 어노테이션이 지정한 객체에 매핑하는 역할 수행
	public String postUser(@RequestBody Map<String, Object> postData) {
		StringBuilder sb = new StringBuilder();
		
		postData.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		return sb.toString();
	}
	
	//http://localhost:9001/api/v1/post-api/user2
	@PostMapping("/user2")
	public String postUserDTO(@RequestBody UserDTO user) {
		return user.toString();
	}
	
}
