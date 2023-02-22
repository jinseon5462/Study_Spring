package com.springboot.apitest.testapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apitest.mapper.MemberMapper;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
	
	@Autowired
	private MemberMapper mapper;
	
	@DeleteMapping("/member")
	public int deleteMember(int sno) {
		int result = mapper.deleteMember(sno);
		return result;
	}
}
