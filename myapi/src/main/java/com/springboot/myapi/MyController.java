package com.springboot.myapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@GetMapping("/")
	@ResponseBody
	public String root() {
		return "hello World";
	}
	@GetMapping("/index")
	public String root1() {
		return "/index";
	}
}
