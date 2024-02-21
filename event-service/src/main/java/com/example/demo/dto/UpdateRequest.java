package com.example.demo.dto;

import java.sql.Timestamp;
import java.util.Date;

public class UpdateRequest {
	private String eventName;
	private Date eventDate;
	private String eventLocation;
	private String eventDescription;
	private Timestamp createdAt;
	private int attendence;
	
	
	
	@Override
	public String toString() {
		return "UpdateRequest [eventName=" + eventName + ", eventDate=" + eventDate + ", eventLocation=" + eventLocation
				+ ", eventDescription=" + eventDescription + ", createdAt=" + createdAt + ", attendence=" + attendence
				+ "]";
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public int getAttendence() {
		return attendence;
	}
	public void setAttendence(int attendence) {
		this.attendence = attendence;
	}
	public UpdateRequest(String eventName, Date eventDate, String eventLocation, String eventDescription,
			Timestamp createdAt, int attendence) {
		super();
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventLocation = eventLocation;
		this.eventDescription = eventDescription;
		this.createdAt = createdAt;
		this.attendence = attendence;
	}
	public UpdateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
