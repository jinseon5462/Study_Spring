package com.springboot.apitest.testapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apitest.mapper.MemberMapper;
import com.springboot.apitest.vo.UserVO;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
	
	@Autowired
	private MemberMapper mapper;
	
	@PostMapping("/member")
	public int regMember(UserVO member) {
		int result = mapper.regMember(member);
		return result;
	}
	
	@PostMapping("/member2")
	public UserVO getMember(int sno) {
		UserVO member = mapper.getMember(sno);
		return member;
	}
	
}
