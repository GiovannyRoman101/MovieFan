package com.movieapp.MovieFan.service;

import com.movieapp.MovieFan.entity.Room;
import com.movieapp.MovieFan.entity.Ticket;
import com.movieapp.MovieFan.entity.User;

public interface UserService {

	User read(String email);

	User create(User user);

	User delete(String email);

	Ticket putTicket(String email, Room room);

}
