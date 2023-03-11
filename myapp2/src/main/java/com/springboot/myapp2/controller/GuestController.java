package com.springboot.myapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/guest")
@Slf4j
public class GuestController {
	
	@GetMapping("/main")
	public void guest_main() {
		log.info("guest...main...");
	}
}
