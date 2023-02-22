package com.springboot.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@GetMapping("/")
	@ResponseBody
	public String root() {
		return "Spring security";
	}
	
	@GetMapping("/index")
	public void index() {
		
	}
	
	@GetMapping("/guest/welcome")
	public String welcome1() {
		return "guest/welcome1";
	}
	
	@GetMapping("/member/welcome")
	public String welcome2() {
		return "member/welcome2";
	}
	
	@GetMapping("/admin/welcome")
	public String welcome3() {
		return "admin/welcome3";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "security/loginForm";
	}
	@GetMapping("/loginError")
	public String loginError() {
		return "security/loginError";
	}
}
