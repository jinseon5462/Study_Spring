package com.example.mybatis.controller;

import java.util.ArrayList;

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
		return "redirect:list";
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
	@GetMapping("/list")
	public void goList() {}
	
	@GetMapping("/getList.do")	// http://localhost:8081/list
	public @ResponseBody ArrayList<UserVO> list() {
		ArrayList<UserVO> list = mapper.getList();
		return list;
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
