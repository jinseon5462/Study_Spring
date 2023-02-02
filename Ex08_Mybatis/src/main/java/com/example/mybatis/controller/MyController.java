package com.example.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.vo.UserVO;

@Controller
public class MyController {
	
	@Autowired
	UserMapper mapper;
	
	@GetMapping("/")
	public @ResponseBody String root() {
		return "Mybatis 연습";
	}
	
	@GetMapping("/index")
	public void index() {}
	
	@GetMapping("/regForm")
	public void regForm() {}
	
	@PostMapping("/reg.do")
	public String regDo(UserVO user) {
		mapper.insert(user);
		return "redirect:list";
	}
	
	@GetMapping("/list")	// http://localhost:8081/list
	public void list(Model model) {
		List<UserVO> list = mapper.getList();
		model.addAttribute("list", list);
	}
	@GetMapping("/updateForm")
	public void updateForm(String id, Model model) {
		UserVO user = mapper.selectOne(id);
		model.addAttribute("user", user);
	}
	
	@PostMapping("/update.do")
	public String updateDo(UserVO user) {
		mapper.update(user);
		return "redirect:list";
	}
	
	@GetMapping("/delete.do")
	public String deleteDo(String id) {
		mapper.delete(id);
		return "redirect:list";
	}
}
