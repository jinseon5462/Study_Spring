package com.springboot.apitest.testapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apitest.mapper.MemberMapper;
import com.springboot.apitest.vo.UserVO;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
	
	@Autowired
	private MemberMapper mapper;
	
	@PutMapping("/member")
	public int updateMemeber(UserVO member) {
		int result = mapper.updateMember(member);
		return result;
	}
}
