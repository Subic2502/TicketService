package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UpdateRequest;
import com.example.demo.model.EventData;
import com.example.demo.repositoy.EventRepo;

@Service
public class EventService {
	
	@Autowired
	EventRepo er;
	
	public boolean createEvent(EventData eventToBeCreated) {
		//cuvanje novog eventa u bazu
		try {
			er.save(eventToBeCreated);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	public EventData updateEvent(int eventId,UpdateRequest updateRequest) {
		EventData ed = er.findByEventId(eventId);
		System.out.println(updateRequest);
		if(updateRequest.getEventName() != null) {
			ed.setEventName(updateRequest.getEventName());
			System.out.println("Uso eventname");
		}
		if(updateRequest.getEventLocation() != null) {
			ed.setEventLocation(updateRequest.getEventLocation());
			System.out.println("Uso lokacija");
		}
		if(updateRequest.getEventDescription() != null) {
			ed.setEventDescription(updateRequest.getEventDescription());
			System.out.println("Uso deksrip");
		}
		if(updateRequest.getEventDate() != null ) {
			ed.setEventDate(updateRequest.getEventDate());
			System.out.println("Uso datum");
		}
		if(updateRequest.getCreatedAt() != null) {
			ed.setCreatedAt(updateRequest.getCreatedAt());
			System.out.println("Uso createdat");
		}
		try {
			ed.setAttendance(updateRequest.getAttendence());
			er.save(ed);
			return ed;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean deleteEvent(int eventId) {
		EventData ed = er.findByEventId(eventId);
		try {
			er.delete(ed);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public int incrementAttendence(int eventId) {
		EventData ed = er.findByEventId(eventId);
		try {
			int attendence = ed.getAttendance();
			ed.setAttendance(attendence++);
			er.save(ed);
			return attendence++;
		}catch(Exception ex) {
			ex.printStackTrace();
			return -1;
		}
	}

	public List<EventData> returnEvents() {
		List<EventData> listOfEvents = er.findAll();
		return listOfEvents;
	}
}
