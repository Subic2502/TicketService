package com.example.demo.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the tickets database table.
 * 
 */
@Entity
@Table(name="tickets")
@NamedQuery(name="Ticket.findAll", query="SELECT t FROM Ticket t")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ticket_id")
	private int ticketId;

	@Column(name="purchased_at")
	private Timestamp purchasedAt;

	@Column(name="ticket_price")
	private BigDecimal ticketPrice;

	@Column(name="ticket_status")
	private String ticketStatus;

	//bi-directional many-to-one association to EventData
	@ManyToOne
	@JoinColumn(name="event_id")
	private EventData eventData;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Ticket() {
	}
	

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", purchasedAt=" + purchasedAt + ", ticketPrice=" + ticketPrice
				+ ", ticketStatus=" + ticketStatus + ", eventData=" + eventData + ", user=" + user + "]";
	}


	public int getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Timestamp getPurchasedAt() {
		return this.purchasedAt;
	}

	public void setPurchasedAt(Timestamp purchasedAt) {
		this.purchasedAt = purchasedAt;
	}

	public BigDecimal getTicketPrice() {
		return this.ticketPrice;
	}

	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getTicketStatus() {
		return this.ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public EventData getEventData() {
		return this.eventData;
	}

	public void setEventData(EventData eventData) {
		this.eventData = eventData;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}