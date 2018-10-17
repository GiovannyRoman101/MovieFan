package com.movieapp.MovieFan.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "RoomNumber")
	private int roomNumber;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Movie movie;
	
	@Column(name = "TicketAvailable")
	private int ticketAvailable;
	
	@Column(name = "ShowTime")
	private Date showtime;
	
	@JsonIgnore
	@OneToMany(mappedBy = "rooms" ,fetch=FetchType.LAZY)
	private List<Ticket> tickets;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Theater theater;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getTicketAvailable() {
		return ticketAvailable;
	}

	public void setTicketAvailable(int ticketAvailable) {
		this.ticketAvailable = ticketAvailable;
	}

	public Date getShowtime() {
		return showtime;
	}

	public void setShowtime(Date showtime) {
		this.showtime = showtime;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	

}
