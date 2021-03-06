package com.example.service;

import com.example.model.TicketEntity;
import com.example.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("jpaTicketEntityService")
@Repository
@Transactional
public class TicketServiceImpl implements TicketService{

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<TicketEntity> findAll() {
        return (List<TicketEntity>) ticketRepository.findAll();
    }

    @Override
    public List<TicketEntity> findByName(String name) {
        return ticketRepository.findByName(name);
    }

    public TicketEntity findById(Long id) {
        return ticketRepository.findOne(id);
    }

    public void add(TicketEntity ticketEntity){
        ticketRepository.save(ticketEntity);
    }
    public void delete(Long id){
        ticketRepository.delete(id);
    }
}
