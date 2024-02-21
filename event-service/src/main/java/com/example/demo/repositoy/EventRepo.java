package com.example.demo.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EventData;

public interface EventRepo extends JpaRepository<EventData, Integer>{
	EventData findByEventId(Integer eventId);
}
