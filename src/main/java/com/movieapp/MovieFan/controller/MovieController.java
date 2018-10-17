package com.movieapp.MovieFan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.MovieFan.entity.Movie;
import com.movieapp.MovieFan.entity.Room;
import com.movieapp.MovieFan.service.MovieService;

@RestController
@RequestMapping("movies")
@CrossOrigin
public class MovieController {
	private final MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public List<Movie> readMovies(){
		return this.movieService.readMovies();
	}
	
	@RequestMapping( method = RequestMethod.POST)
	public Movie createMovie(@RequestBody Movie movie) {
		return this.movieService.createMovie(movie);
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public List<Room> readMovieRoom (@PathVariable String name){
		return this.movieService.readMovieRoom(name);
	}
	
	
}
