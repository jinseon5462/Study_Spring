package com.springboot.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.springboot.transaction.dao.ITransaction1DAO;
import com.springboot.transaction.dao.ITransaction2DAO;

@Service
public class BuyTicketService implements IBuyTicketService{
	@Autowired
	ITransaction1DAO transaction1;
	
	@Autowired
	ITransaction2DAO transaction2;
	
	@Autowired
	PlatformTransactionManager tm;
	
	@Autowired
	TransactionDefinition definition;
	
	@Override
	public int buy(String consumerId, int money, String error) {
		// 트랜잭션 설정
		TransactionStatus status = tm.getTransaction(definition);
		try {
			transaction1.pay(consumerId, money);
			
			// 의도적으로 에러 발생
			if(error.equals("1")) {
				int n = 10 / 0;
				
			}
			transaction2.pay(consumerId, money);
			
			tm.commit(status);
			return 1;
		}catch(Exception e) {
			System.out.println("[PlatformTransactionManager] Rollback");
			tm.rollback(status);
			return 0;
		}
	}
}
