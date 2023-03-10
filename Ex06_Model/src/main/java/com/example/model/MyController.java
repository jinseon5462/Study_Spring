package com.example.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@GetMapping("/")
	public @ResponseBody String root() {
		return "Ex06 model...";
	}
	
	@GetMapping("/index")
	public void index() {
		
	}
	
	@GetMapping("/test1")
	public String test1(Model model) {
		//데이터만 설정한다.
		model.addAttribute("name", "홍길동");
		
		return "test1";
	}
	
	@GetMapping("/mv")
	public ModelAndView test2() {
		//데이터와 뷰를 동시에 설정한다.
		ModelAndView mv = new ModelAndView();
		List<String> list = new ArrayList<>();
		
		list.add("test1");
		list.add("test2");
		list.add("test3");
		
		mv.addObject("lists", list);
		mv.addObject("ObjectTest", "테스트입니다.");
		mv.addObject("name", "홍길동");
		mv.setViewName("view/myView");
		return mv;
	}
}
