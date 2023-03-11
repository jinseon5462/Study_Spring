package com.springboot.transaction.service;

public interface IBuyTicketService {
	public int buy(String consumerId, int money, String error);
}
