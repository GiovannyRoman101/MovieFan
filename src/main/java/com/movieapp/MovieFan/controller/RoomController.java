package com.movieapp.MovieFan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.MovieFan.entity.Room;
import com.movieapp.MovieFan.service.RoomService;

@RestController
@RequestMapping("rooms")
@CrossOrigin
public class RoomController {
	
	private final RoomService roomService;
	
	@Autowired
	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Room create(@RequestBody Room room) {
		return this.roomService.create(room);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Room> read() {
		return this.roomService.read();
		
	}
	

}
