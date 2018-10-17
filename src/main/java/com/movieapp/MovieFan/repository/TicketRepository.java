package com.movieapp.MovieFan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.movieapp.MovieFan.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long>{

}
