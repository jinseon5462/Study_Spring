package com.springboot.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.transaction.dao.ITransaction3DAO;

@Service
public class LogWriterService {
	
	@Autowired
	ITransaction3DAO transaction3;
	
	public int write(String consumerId, int amount) {
		try {
			transaction3.pay(consumerId, amount);
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}
	
}
