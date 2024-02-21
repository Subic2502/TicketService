package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ReturnEventsResponse;
import com.example.demo.dto.UpdateRequest;
import com.example.demo.model.EventData;
import com.example.demo.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {

	@Autowired
	EventService es;
	
	@PostMapping("/createEvent/")
	public boolean createEvent(@RequestBody EventData eventToBeCreated) {
		boolean created = es.createEvent(eventToBeCreated);
		return created;
	}
	
	@PostMapping("/updateEvent/{eventId}")
	public String updateEvent(@PathVariable int eventId,@RequestBody UpdateRequest updateRequest) {
		EventData ed = es.updateEvent(eventId,updateRequest);
		if(ed != null) {
			return "Promenjeni event" + ed;
		}else {
			return "Doslo je do greske!";
		}
	}
	
	@PostMapping("/deleteEvent/{eventId}")
	public boolean deleteEvent(@PathVariable int eventId) {
		boolean deleted = es.deleteEvent(eventId);
		return deleted;
	}
	@PostMapping("/returnEvents/")
	public ReturnEventsResponse returnEvents() {
		System.out.println("Uslo u returnEvents");
		List<EventData> returnedEvents = es.returnEvents();
		String returnedString = "Da biste kupili kartu za dogadjaj kucajte http://localhost:8800/purchaseTicket/{eventId}";
		ReturnEventsResponse rer = new ReturnEventsResponse(returnedString, returnedEvents);
		System.out.println(rer);
		return rer;
	}
}
