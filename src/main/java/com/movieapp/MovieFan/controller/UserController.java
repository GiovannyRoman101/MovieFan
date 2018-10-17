package com.movieapp.MovieFan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.MovieFan.entity.Room;
import com.movieapp.MovieFan.entity.Ticket;
import com.movieapp.MovieFan.entity.User;
import com.movieapp.MovieFan.service.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {
	
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user){
		return this.userService.create(user);
	}
	
	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public User read(@PathVariable String email){
		return this.userService.read(email);
	}
	
	@RequestMapping(value = "/{email}", method = RequestMethod.DELETE)
	public User delete(@PathVariable String email){
		return this.userService.delete(email);
	}
	
	@RequestMapping(value = "/{email}/tickets",method = RequestMethod.PUT)
	public Ticket putTicket(@PathVariable String email, @RequestBody Room room) {
		return this.userService.putTicket(email,room);
	}


}
