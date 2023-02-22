package com.springboot.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.transaction.dao.ITransaction1DAO;
import com.springboot.transaction.dao.ITransaction2DAO;

@Service
public class BuyTicketService implements IBuyTicketService{
	@Autowired
	ITransaction1DAO transaction1;
	
	@Autowired
	ITransaction2DAO transaction2;
	
	@Override
	public int buy(String consumerId, int money, String error) {
		
		try {
			transaction1.pay(consumerId, money);
			
			// 의도적으로 에러 발생
			if(error.equals("1")) {
				int n = 10 / 0;
				
			}
			transaction2.pay(consumerId, money);
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}
}
