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
//import com.movieapp.MovieFan.entity.Movie;
import com.movieapp.MovieFan.entity.Room;
import com.movieapp.MovieFan.entity.Theater;
import com.movieapp.MovieFan.service.TheaterService;

@RestController
@RequestMapping("theaters")
@CrossOrigin
public class TheaterController {
	
	private final TheaterService theaterService;
	
	@Autowired
	public TheaterController(TheaterService theaterService) {
		this.theaterService = theaterService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Theater> read(){
		return this.theaterService.read();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Theater create(@RequestBody Theater theater){
		return this.theaterService.create(theater);
	}
	@RequestMapping (value = "/{name}", method = RequestMethod.GET)
	public List<Theater> indexName(@PathVariable String name){
		return this.theaterService.indexName(name);
	}
	@RequestMapping (value = "/{name}/movies", method = RequestMethod.GET)
	public List<Movie> readTheaterMovies(@PathVariable String name){
		return this.theaterService.readTheaterMovies(name);
	}
	
	@RequestMapping (value = "/{name}/movies/{moviename}/rooms", method = RequestMethod.GET)
	public List<Room> readMovieRooms(@PathVariable String name,@PathVariable String moviename){
		return this.theaterService.readMovieRooms(name,moviename);
	}
	
	@RequestMapping (value = "/{name}/rooms", method = RequestMethod.GET)
	public List<Room> readRooms(@PathVariable String name){
		return this.theaterService.readRooms(name);
	}

}
