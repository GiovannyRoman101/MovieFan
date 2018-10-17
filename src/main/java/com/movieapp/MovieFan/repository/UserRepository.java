package com.movieapp.MovieFan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.movieapp.MovieFan.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
