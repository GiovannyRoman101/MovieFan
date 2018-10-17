package com.movieapp.MovieFan.service;

import java.util.List;

import com.movieapp.MovieFan.entity.Room;

public interface RoomService {

	Room create(Room room);

	List<Room> read();

}
