package com.springboot.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.UserDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController		// @Controller + @ResponseBody
@RequestMapping("/api/v1/get-api")
public class GetController {
	
	//http://localhost:9001/api/v1/get-api/hello
	//@RequestMapping(value = "/hello", method=ReqeustMethod.GET)
	@GetMapping("/hello")
	public String getHello() {
		return "Hello World";
	}
	
	
	//http://localhost:9001/api/v1/get-api/variable1/aaa
	//@GetMapping("/variable1/{홍길동}")
	@GetMapping("/variable1/{variable}")
	public String getVariable(@PathVariable("variable") String var) {
		
		return var;
	}
	
	//http://localhost:9001/api/v1/get-api/request1?name=value1&email=value2&organization=value3
	@ApiOperation(value = "GET 메서드 예제", notes = "@RequestParam을 활용한 GET Method" )
	@GetMapping("/request1")
	public String getRequestParam1(
				@ApiParam(value="이름", required=true) @RequestParam String name,
				@ApiParam(value="이메일", required=true) @RequestParam String email,
				@ApiParam(value="회사", required=true) @RequestParam String organization
			) {
		
		return name + " | " + email + " | " + organization;
	}

	//http://localhost:9001/api/v1/get-api/request2?key1=value1&key2=value2
	@GetMapping("/request2")
	public String getRequestParam2(@RequestParam Map<String, String> param) {
		StringBuilder sb = new StringBuilder();
		param.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	//http://localhost:9001/api/v1/get-api/request3?name=value1&email=value2&organization=value3
	@GetMapping("/request3")
	public String requestParam3(UserDTO user) {
		return user.toString();
	}
}
