package com.example.demo.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ValidateTicketRequest;
import com.example.demo.model.EventData;
import com.example.demo.model.Ticket;
import com.example.demo.model.User;
import com.example.demo.repository.EventRepo;
import com.example.demo.repository.TicketRepo;
import com.example.demo.repository.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class TicketService {
	
	@Autowired
	EventRepo er;
	
	@Autowired
	UserRepo ur;
	
	@Autowired
	TicketRepo tr;
	
	@Transactional
	public String refundTicket(int ticketId,int userId,int eventId) {
		Ticket ticketToBeRefunded = tr.findByTicketId(ticketId);
		if(ticketToBeRefunded != null) {
			if(ticketToBeRefunded.getUser().getUserId() == userId) {
				if(ticketToBeRefunded.getEventData().getEventId() == eventId) {
					if(ticketToBeRefunded.getTicketStatus().equals("Unused")) {
						ticketToBeRefunded.setTicketStatus("Passive");
						tr.save(ticketToBeRefunded);
						return "Uspesno deaktivirana karta!";
					}else {
						return "Karta je vec iskoristena / refundirana!";
					}
				}
				else {
					return "Ne postoji karta asocirana za taj dogadjaj!";
				}
			}
			else {
				return "Ova karta nije vasa! ( nije dobar userId )";
			}
		}else {
			return "Ne postoji takva karta!";
		}
	}
	
	@Transactional
	public String validateTicket(ValidateTicketRequest vtr) {
		Ticket ticketToBeValidated = tr.findByTicketId(vtr.getTicketId());
		try {
			if(ticketToBeValidated != null) {
				if(ticketToBeValidated.getUser().getUserId() == vtr.getUserId()) {
					if(ticketToBeValidated.getEventData().getEventId() == vtr.getEventId()) {
						//System.out.print("ticketToBe:"+ticketToBeValidated.getTicketId() + "vtr:" + vtr.getTicketId());
						//TODO 3 - Dodati u event ovaj da se povecava prihod od karata
						if(ticketToBeValidated.getTicketStatus().equals("Used")) {
							return "Ova karta je vec iskoristena!";
						}else if(ticketToBeValidated.getTicketStatus().equals("Passive")) {
							return "Ova karta nije u opticaju!";
						}else {
							ticketToBeValidated.setTicketStatus("Used");
							tr.save(ticketToBeValidated);
							return "Uspesno iskoriscena karta!";
						}
					}else {
						return "To nije karta za taj dogadjaj!";
					}
					
				}else {
					return "Morate priloziti licnu kartu / ovu kartu niste vi kupili!";
				}
				
			}else {
				return "Ta karta nije izdata/ne postoji!";
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			return "Doslo je do greske!";
		}
	}

	@Transactional
	public Ticket purchaseTicket(int eventId,int userId) {
		User user = ur.findByUserId(userId);
		if(user != null) {
			Ticket ticket = new Ticket();
			
			EventData eventData = er.findByEventId(eventId);
			if(eventData != null) {
				ticket.setEventData(eventData);
				int attendence = eventData.getAttendance() + 1;
				eventData.setAttendance(attendence);
				er.save(eventData);
			}else {
				return null;
			}
			Instant currentTimestamp = Instant.now();
	        Timestamp timestamp = Timestamp.from(currentTimestamp);
			ticket.setPurchasedAt(timestamp);
			
			BigDecimal bigDecimal = new BigDecimal(600);
			ticket.setTicketPrice(bigDecimal);
			
			ticket.setTicketStatus("Unused");
			
			ticket.setUser(user);
			tr.save(ticket);
			return ticket;
		}else {
			return null;
		}
	}
	
}
