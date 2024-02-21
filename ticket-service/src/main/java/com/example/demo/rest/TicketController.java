package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ValidateTicketRequest;
import com.example.demo.model.Ticket;
import com.example.demo.model.User;
import com.example.demo.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

	@Autowired
	TicketService ts;
	
	@PostMapping("/purchaseTicket/{eventId}/{userId}")
	 public String purchaseTicket(@PathVariable int eventId,@PathVariable int userId) {
		Ticket ticket = ts.purchaseTicket(eventId,userId);
		if(ticket != null) {
			return "Uspesno! Vasa karta je:"+ticket;
		}else {
			return "Doslo je do greske, karta nije kupljena!";
		}
	}
	
	@PostMapping("/validateTicket/")
	 public String validateTicket(@RequestBody ValidateTicketRequest vtr) {
		String validatedString = ts.validateTicket(vtr);
		return validatedString;
	}
	
	@PostMapping("/refundTicket/{ticketId}/{userId}/{eventId}")
	public String refundTicket(@PathVariable int ticketId,@PathVariable int userId,@PathVariable int eventId) {
		String validatedString = ts.refundTicket(ticketId,userId,eventId);
		return validatedString;
	}
	
}
