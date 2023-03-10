package com.example.comobj;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.comobj.domain.SampleVO;

@Controller
public class MyController {
	
	@GetMapping("/")
	public @ResponseBody String root() {
		return "Command Object 연습";
	}
	
	@GetMapping("/index")
	public void index() {}
	
	@GetMapping("/regForm")
	public void regForm() {}
	
	//@PostMapping("/reg.do")
	public @ResponseBody String regDo(SampleVO sample) {
		return "name : " + sample.getName() + "/ age : " + sample.getAge();
	}
	
	//@PostMapping("/reg.do")
	public @ResponseBody String regDo1(HttpServletRequest request) {
		SampleVO sample = new SampleVO();
		String name = request.getParameter("name");
		sample.setName(name);
		int age = Integer.parseInt(request.getParameter("age"));
		sample.setAge(age);
		//HttpSession session = request.getSession();
		return "name : " + sample.getName() + "/ age : " + sample.getAge();
	}
	
	//@PostMapping("/reg.do")
	public @ResponseBody String regDo2(@RequestParam("name") String friend_name, @RequestParam int age) {
		String name = "홍길동";
		return "나는 " + name + " 친구이름은 " + friend_name + "/ age : " + age;
	}
	//@PostMapping("/reg.do")
	public String regDo3(SampleVO sample) {
		// command(파라미터전용) 객체일 경우 뷰까지 자동으로 전달이 된다. 
		return "result";
	}
	//@PostMapping("/reg.do")
	public String regDo4(@ModelAttribute("vo") SampleVO sample) {
		// command(파라미터전용) 객체일 경우 뷰까지 자동으로 전달이 된다. 
		return "result";
	}
	
	@PostMapping("/reg.do")
	public String regDo5(@ModelAttribute("name") String name, @ModelAttribute("age") int age, Model model) {
		//model.addAttribute("name", name);
		//model.addAttribute("age", age);
		
		return "result";
	}
}
