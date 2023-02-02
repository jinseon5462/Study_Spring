package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@GetMapping("/")
	public @ResponseBody String root() {
		return "JSP in Gradle";
	}
	
	@GetMapping("/test1")	// localhost:8081/test1
	public String test1() {
		return "test1";		// /WEB-INF/views/test1.jsp
	}
	
	@GetMapping("/test2")	// localhost:8081/test1
	public String test2() {
		return "sub/test2";	// /WEB-INF/views/sub/test2.jsp
	}
}
