package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		
		return "Hello SpringBoot";
	}
	
	@RequestMapping("/test1")
	public String test1() {
		return "test1";
	}
}
