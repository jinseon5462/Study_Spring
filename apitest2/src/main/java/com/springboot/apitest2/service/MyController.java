package com.springboot.apitest2.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyController {
	
	@GetMapping("/")
	public @ResponseBody String root() {
		return "hello Test~~";
	}
	
	@GetMapping("/testapi")
	public void testApi() {
		log.info("testapi......");
	}
}
