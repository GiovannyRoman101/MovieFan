package com.movieapp.MovieFan.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@Column(name = "purchaseDate")
	private Date purchaseDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Room rooms;
	
	public Ticket() {
	}
	
	public Ticket(long id, User user, Date purchaseDate, Room rooms) {
		this.id = id;
		this.user = user;
		this.purchaseDate = purchaseDate;
		this.rooms = rooms;
	}



	public Ticket(User user, Date purchaseDate, Room rooms) {
		this.user = user;
		this.purchaseDate = purchaseDate;
		this.rooms = rooms;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Room getRooms() {
		return rooms;
	}

	public void setRooms(Room rooms) {
		this.rooms = rooms;
	}
	
}