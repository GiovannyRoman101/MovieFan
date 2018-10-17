package com.movieapp.MovieFan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.movieapp.MovieFan.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{

}
