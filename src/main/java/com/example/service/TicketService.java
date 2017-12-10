package com.example.service;

import com.example.model.TicketEntity;

import java.util.List;

public interface TicketService {
    Iterable<TicketEntity> findAll();
    List<TicketEntity> findByName(String firstName);
}
