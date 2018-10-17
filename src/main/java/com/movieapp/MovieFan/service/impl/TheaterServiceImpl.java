package com.movieapp.MovieFan.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.MovieFan.entity.Movie;
import com.movieapp.MovieFan.entity.Room;
import com.movieapp.MovieFan.entity.Theater;
import com.movieapp.MovieFan.repository.TheaterRepository;
import com.movieapp.MovieFan.service.TheaterService;

@Service
public class TheaterServiceImpl implements TheaterService {
	
	private final TheaterRepository repo;

	@Autowired
	public TheaterServiceImpl(TheaterRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Theater> read() {
		List<Theater> theaters = this.repo.findAll();
		Set<Theater> unqiueTheaters = new HashSet<Theater>(theaters);
		return new ArrayList<Theater>(unqiueTheaters);
		
	}

	@Override
	public Theater create(Theater theater) {
		return this.repo.saveAndFlush(theater);
		
	}


	@Override
	public List<Theater> indexName(String name) {
		List<Theater> theaters = new ArrayList<Theater>();
		for(Theater th : this.repo.findAll()) {
			if(name.equalsIgnoreCase(th.getName())) {
				theaters.add(th);
			}
		}
		return theaters;
		
	}

	@Override
	public List<Room> readRooms(String name) {
		List<Room> rooms = new ArrayList<Room>();
		for(Theater th : this.repo.findAll()) {
			if(name.equalsIgnoreCase(th.getName())) {
				rooms.addAll(th.getRooms());
			}
		}
		return rooms;
	}

	@Override
	public List<Movie> readTheaterMovies(String name) {
		List<Theater> theaters = this.repo.findAll();
		Set<Movie> movies = new HashSet<Movie>();
		
		for(Theater theater: theaters) {
			if(theater.getName().equalsIgnoreCase(name)) {
				for(Room room : theater.getRooms()) {
					movies.add(room.getMovie());
				}
			}
		}
		return new ArrayList<Movie> (movies);
	}

	@Override
	public List<Room> readMovieRooms(String name, String moviename) {
		
		Calendar now = Calendar.getInstance();
		Calendar movieTime = Calendar.getInstance();
		
		now.setTime(new Date());
		
		List<Theater> theaters = this.repo.findAll();
		List<Room> rooms = new ArrayList<Room>();
		
		for(Theater theater : theaters) {
			if(theater.getName().equalsIgnoreCase(name)) {
				
				for(Room room : theater.getRooms()) {
					
					if(room.getMovie().getName().equalsIgnoreCase(moviename)) {
						movieTime.setTime(room.getShowtime());
						if(now.get(Calendar.DAY_OF_YEAR) == movieTime.get(Calendar.DAY_OF_YEAR) &&
				                  now.get(Calendar.YEAR) == movieTime.get(Calendar.YEAR)) {
							rooms.add(room);
						}
					}
				}
			}
		}
		return rooms;
	}
	
	
}
