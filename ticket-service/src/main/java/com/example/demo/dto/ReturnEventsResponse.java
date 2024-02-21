package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.EventData;

public class ReturnEventsResponse {
	String naslov;
	List<EventData> listOfEvents;
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public List<EventData> getListOfEvents() {
		return listOfEvents;
	}
	public void setListOfEvents(List<EventData> listOfEvents) {
		this.listOfEvents = listOfEvents;
	}
	public ReturnEventsResponse(String naslov, List<EventData> listOfEvents) {
		super();
		this.naslov = naslov;
		this.listOfEvents = listOfEvents;
	}
	public ReturnEventsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Napomena:" + naslov + "\nSlobodno za kupiti:\n" + listOfEvents;
	}
	
	
}
