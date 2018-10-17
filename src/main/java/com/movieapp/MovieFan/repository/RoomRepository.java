package com.movieapp.MovieFan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieapp.MovieFan.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

}
