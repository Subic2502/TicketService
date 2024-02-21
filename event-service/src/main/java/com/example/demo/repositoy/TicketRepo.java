package com.example.demo.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer>{

}
