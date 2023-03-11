package com.springboot.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.transaction.service.IBuyTicketService;

@Controller
public class MyController {
	
	@Autowired
	IBuyTicketService buyTicket;
	
	@GetMapping("/")
	@ResponseBody
	public String root() {
		return "Transaction Manager 연습2";
	}
	
	@GetMapping("/buy_ticket")
	public void buy_ticket() {
		
	}
	
	@GetMapping("/buy_ticket_card")
	public String buy_ticket_card(@RequestParam("consumerId") String consumerId,
								  @RequestParam("amount") int amount,
								  @RequestParam("error") String error,
								  Model model) {
		
		int nResult = buyTicket.buy(consumerId, amount, error);
		model.addAttribute("consumerId", consumerId);
		model.addAttribute("amount", amount);
		
		if(nResult == 1) {
			return "buy_ticket_end";
		}else {
			return "buy_ticket_error";
		}
	}
	
}
