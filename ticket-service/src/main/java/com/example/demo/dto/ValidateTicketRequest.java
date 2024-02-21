package com.example.demo.dto;

public class ValidateTicketRequest {
	int userId;
	int eventId;
	int ticketId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public ValidateTicketRequest(int userId, int eventId, int ticketId) {
		super();
		this.userId = userId;
		this.eventId = eventId;
		this.ticketId = ticketId;
	}
	public ValidateTicketRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
