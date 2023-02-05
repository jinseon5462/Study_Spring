package com.example.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.student.mapper.StudentMapper;
import com.example.student.vo.StudentVO;

@Controller
public class MyController {
	@Autowired
	private StudentMapper mapper;
	
	// index페이지
	@GetMapping("/")
	public String root() {
		return "/index";
	}
	
	// 로그인폼으로 이동
	@GetMapping("/loginForm")
	public void loginForm() {}
	
	// 로그인 실행
	@PostMapping("/login.do")
	public @ResponseBody int loginDo(StudentVO student, HttpServletRequest request) {
		int result = mapper.login(student);
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", student.getId());
			return result;
		}else {
			return result;
		}
	}
	
	// 회원가입폼으로 이동
	@GetMapping("/signUpForm")
	public void signUpForm() {}
	
	// 회원가입 학생확인
	@PostMapping("/studentCheck.do")
	public @ResponseBody int studentCheckDo(int sno, String name) {
		int result = mapper.studentCheck(sno, name);
		return result;
	}
	
	// 회원가입 아이디 중복확인
	@PostMapping("/idCheck.do")
	public @ResponseBody int idCheckDo(String id) {
		int result = mapper.checkId(id);
		return result;
	}
	
	// 회원가입 실행
	@PostMapping("/signUp.do")
	public @ResponseBody int signUpDo(StudentVO student) {
		int result = mapper.signUp(student);
		return result;
	}
	
	// 로그아웃
	@GetMapping("/logout.do")
	public String logoutDo(HttpSession session) {
		session.invalidate();
		return "/index";
	}
}
