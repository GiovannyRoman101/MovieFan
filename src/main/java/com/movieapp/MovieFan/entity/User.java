package com.movieapp.MovieFan.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "User",uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "acc_type")
	private AccountType type;
	
	@OneToMany(mappedBy = "user" ,fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Ticket> tickets;
	
	
	
	public User() {
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public User(long id, String email, String password, AccountType type, List<Ticket> tickets) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.type = type;
		this.tickets = tickets;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}
	
	
	
}
