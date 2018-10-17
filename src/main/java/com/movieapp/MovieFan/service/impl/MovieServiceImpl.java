package com.movieapp.MovieFan.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.MovieFan.entity.Movie;
import com.movieapp.MovieFan.entity.Room;
import com.movieapp.MovieFan.repository.MovieRepository;
import com.movieapp.MovieFan.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
	private final MovieRepository repo;
	
	@Autowired
	public MovieServiceImpl(MovieRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Movie> readMovies() {
		List<Movie> movies = this.repo.findAll();
		return movies;
	}

	@Override
	public Movie createMovie(Movie movie) {
		return this.repo.saveAndFlush(movie);
	}


	@Override
	public List<Room> readMovieRoom(String name) {
		List<Movie> movies = this.repo.findAll();
		for(Movie movie : movies) {
			if(movie.getName().equalsIgnoreCase(name)) {
				return movie.getRoom();
			}
		}
		return null;
	}
	
	
}
