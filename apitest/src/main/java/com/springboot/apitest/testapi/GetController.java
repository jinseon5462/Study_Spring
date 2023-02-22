package com.springboot.apitest.testapi;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apitest.mapper.MemberMapper;
import com.springboot.apitest.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
	
	@Autowired
	private MemberMapper mapper;
	
	@GetMapping("/list")
	public ArrayList<UserVO> getList(){
		ArrayList<UserVO> list = mapper.getList();
		return list;
	}
	
	@GetMapping("/user/{name}")
	public String getUser(@PathVariable String name) {
		log.info("getUser....." + name);
		UserVO user = mapper.selectByName(name);
		log.info(user.toString());
		return "<span style='color: blue'>" + user.toString() + "</span>";
	}
}
