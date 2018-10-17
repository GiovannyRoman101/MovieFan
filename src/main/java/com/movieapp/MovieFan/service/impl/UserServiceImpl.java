package com.movieapp.MovieFan.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.commons.validator.routines.EmailValidator;

import com.movieapp.MovieFan.entity.AccountType;
import com.movieapp.MovieFan.entity.Room;
import com.movieapp.MovieFan.entity.Ticket;
import com.movieapp.MovieFan.entity.User;
import com.movieapp.MovieFan.repository.UserRepository;
import com.movieapp.MovieFan.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private final UserRepository repo;

	@Autowired
	public UserServiceImpl(UserRepository repo) {
		this.repo = repo;
	}

	@Override
	public User create(User user) {
		if(EmailValidator.getInstance().isValid(user.getEmail())) {
			if(user.getEmail().toLowerCase().contains("admin")) {
				user.setType(AccountType.ADMIN);
			}
			else {
				user.setType(AccountType.USER);
			}
			return this.repo.saveAndFlush(user);
		}
		return null;
	}
	
	@Override
	public User read(String email) {
		List<User> users = this.repo.findAll();
		for (User account : users) {
			if (email.equals(account.getEmail())) {
				return account;
			}
		}
		return null;
	}

	@Override
	public User delete(String email) {
		List<User> users = this.repo.findAll();
		User acc_termination= null;
		for (User account : users) {
			if (email.equals(account.getEmail())) {
				acc_termination = account;
			}
		}
		if(acc_termination != null) {
			this.repo.delete(acc_termination);
		}
		return acc_termination;
	}

	@Override
	public Ticket putTicket(String email, Room room) {
		List<User> users = this.repo.findAll();
		for(User user : users ) {
			if(user.getEmail().equalsIgnoreCase(email)) {
				List<Ticket> tickets = user.getTickets();
				Ticket ticsav = new Ticket(user,new Date(),room);
				tickets.add(ticsav);
				user.setTickets(tickets);
				this.repo.saveAndFlush(user);
			}
		}
		return null;
		
	}

	

}
