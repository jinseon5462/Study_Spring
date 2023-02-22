package com.springboot.validator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@GetMapping("/")
	@ResponseBody
	public String root() {
		return "ValidationUtils (2)";
	}
	
	@GetMapping("/insertForm")
	public String insertForm() {
		return "createPage";
	}
	
	@PostMapping("/create")
	public String insert(@ModelAttribute("dto") ContentDTO dto, BindingResult result) {
		String page = "createDonePage";
		System.out.println(dto);
		
		ContentValidator validator = new ContentValidator();
		validator.validate(dto, result);
		if(result.hasErrors()) {
			System.out.println("getAllErrors : " + result.getAllErrors());
			if(result.getFieldError("writer") != null) {
				System.out.println("1 : " + result.getFieldError("writer").getCode());
			}
			if(result.getFieldError("content") != null) {
				System.out.println("2 : " + result.getFieldError("content").getCode());
			}
			page = "createPage";
		}
		return page;
	}
}
