package com.movieapp.MovieFan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieapp.MovieFan.entity.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Long>{

}
