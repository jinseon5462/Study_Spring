package com.restapi.cors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyController {
	
	@GetMapping("/")
	public @ResponseBody String root() {
		return "Exam";
	}
	
	@GetMapping("/index")
	public void index() {}
	
	@GetMapping("/index2")
	public void index2() {}
}
