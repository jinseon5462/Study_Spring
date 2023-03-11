package com.springboot.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class BuyAndLogService {

	@Autowired
	BuyTicketService buyTicket;
	
	@Autowired
	LogWriterService logWriter;
	
	@Autowired
	TransactionTemplate tt;
	
	public int buy(String consumerId, int amount, String error) {
		// 트랜잭션 설정
		//TransactionStatus status = tm.getTransaction(definition);
		try {
			tt.execute(new TransactionCallbackWithoutResult() {
	
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus arg0) {
					buyTicket.buy(consumerId, amount, error);
					
					// 의도적으로 에러 발생
					if(error.equals("2")) {
						int n = 10 / 0;
						
					}
					logWriter.write(consumerId, amount);
				}
			});
			return 1;
		}catch(Exception e) {
			System.out.println("[PlatformTransaction Propagation] Rollback");
			return 0;
		}
	}
	
}
