package com.springboot.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.springboot.transaction.dao.ITransaction1DAO;
import com.springboot.transaction.dao.ITransaction2DAO;

@Service
public class BuyTicketService{
	@Autowired
	ITransaction1DAO transaction1;
	
	@Autowired
	ITransaction2DAO transaction2;
	
	@Autowired
	TransactionTemplate tt;
	
	//@Transactional(propagation=Propagation.REQUIRED)
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int buy(String consumerId, int money, String error) {
		// 트랜잭션 설정
		//TransactionStatus status = tm.getTransaction(definition);
		try {
			tt.execute(new TransactionCallbackWithoutResult() {
	
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus arg0) {
					transaction1.pay(consumerId, money);
					
					// 의도적으로 에러 발생
					if(error.equals("1")) {
						int n = 10 / 0;
						
					}
					transaction2.pay(consumerId, money);
				}
			});
			//tm.commit(status);
			return 1;
		}catch(Exception e) {
			System.out.println("[PlatformTransaction Propagation] Rollback");
			//tm.rollback(status);
			return 0;
		}
	}
}
