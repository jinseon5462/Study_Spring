package com.springboot.corstest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyController {
	
	@GetMapping("/")
	public @ResponseBody String root() {
		log.info("root...");
		return "hello";
	}
	
	@GetMapping("/main")
	public void main() {}
	
	@GetMapping("/main2")
	public void main2() {}
}
