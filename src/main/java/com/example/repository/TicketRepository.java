package com.example.repository;

import com.example.model.TicketEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<TicketEntity, Long> {
    List<TicketEntity> findByName (String name);
}
