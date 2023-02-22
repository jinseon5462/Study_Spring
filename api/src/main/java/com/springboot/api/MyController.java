package com.springboot.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyController {
	
	@GetMapping("/")
	public @ResponseBody String root() {
		log.info("root...");
		return "index";
	}
	
	@GetMapping("/index")
	public String index() {
		log.info("index...");
		return "index";
	}
}
