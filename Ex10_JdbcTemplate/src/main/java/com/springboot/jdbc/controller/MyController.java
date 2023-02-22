package com.springboot.jdbc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.jdbc.dao.ISampleDAO;
import com.springboot.jdbc.dto.SampleDTO;

@Controller
public class MyController {
	
	@Autowired
	private ISampleDAO dao;
	
	@GetMapping("/")
	@ResponseBody
	public String root() {
		return "JDBC API";
	}
	
	@GetMapping("/index")
	public void index() {}
	
	@GetMapping("/list")
	public void list(Model model) {
		List<SampleDTO> list = dao.getList();
		model.addAttribute("list", list);
	}
	
	@GetMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		String sno = request.getParameter("no");
		Long no = Long.parseLong(sno);
		
		SampleDTO sample = dao.getOne(no);
		model.addAttribute("sample", sample);
		return "view";
	}
}
