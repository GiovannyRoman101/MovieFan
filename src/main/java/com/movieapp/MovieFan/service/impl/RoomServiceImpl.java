package com.movieapp.MovieFan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.MovieFan.entity.Room;
import com.movieapp.MovieFan.repository.RoomRepository;
import com.movieapp.MovieFan.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	private final RoomRepository repo;

	@Autowired
	public RoomServiceImpl(RoomRepository repo) {
		this.repo = repo;
	}

	@Override
	public Room create(Room room) {
		return this.repo.saveAndFlush(room);
	}

	@Override
	public List<Room> read() {
		return this.repo.findAll();
	}
	
	
}
