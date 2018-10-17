package com.movieapp.MovieFan.service;

import java.util.List;

import com.movieapp.MovieFan.entity.Movie;
import com.movieapp.MovieFan.entity.Room;

public interface MovieService {

	List<Movie> readMovies();

	Movie createMovie(Movie movie);

	List<Room> readMovieRoom(String name);

}
