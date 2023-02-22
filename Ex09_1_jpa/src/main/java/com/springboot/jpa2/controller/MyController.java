package com.springboot.jpa2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyController {

	
	@GetMapping("/")
	@ResponseBody
	public String root() {
		log.info("root...");
		return "Hello~~ JPA2";
	}
	
	@GetMapping("/index")
	public void index() {
		log.info("index...");
	}
}
