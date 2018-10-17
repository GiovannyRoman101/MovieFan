package com.movieapp.MovieFan.service;

import java.util.List;

import com.movieapp.MovieFan.entity.Movie;
import com.movieapp.MovieFan.entity.Room;
import com.movieapp.MovieFan.entity.Theater;

public interface TheaterService {

	List<Theater> read();

	Theater create(Theater theater);

	List<Theater> indexName(String name);

	List<Room> readRooms(String name);

	List<Movie> readTheaterMovies(String name);

	List<Room> readMovieRooms(String name, String moviename);

}
