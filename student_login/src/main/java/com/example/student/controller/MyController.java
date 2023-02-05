package com.example.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.student.mapper.StudentMapper;
import com.example.student.vo.StudentVO;

@Controller
public class MyController {
	
	@Autowired
	private StudentMapper mapper;
	
	@GetMapping("/")
	public String root() {
		return "/index";
	}
	
	@GetMapping("/loginForm")
	public void loginForm() {}
	
	@GetMapping("/signUpForm")
	public void signUpForm() {}
	
	@PostMapping("/goSignUpForm")
	public String goSignUpForm(StudentVO student, Model model) {
		model.addAttribute("student", student);
		return "/signUpForm";
	}
	
	@GetMapping("/searchStudent")
	public void searchStudent() {}
	
	@PostMapping("/search.do")
	public @ResponseBody StudentVO searchDo(@RequestParam("sno") int sno, @RequestParam("name") String name) {
		StudentVO student = mapper.selectOne(sno, name);
		return student;
	}
	
	@GetMapping("/main")
	public void main() {}
	
	@PostMapping("/login.do")
	public String loginDo(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model, HttpServletRequest request) {
		int result = mapper.loginCheck(id, pw);
		model.addAttribute("result", result);
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			return "/index";
		}
		return "loginForm";
	}
	
	@PostMapping("/idCheck.do")
	public @ResponseBody int idCheckDo(String id) {
		System.out.println("아이디 : " + id);
		int result = mapper.idCheck(id);
		return result;
	}
	
	@PostMapping("/signUp.do")
	public String signUpDo(StudentVO student, Model model) {
		int result = mapper.signUp(student);
		model.addAttribute("result", result);
		return "signUpForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/index";
	}
}
