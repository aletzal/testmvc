package com.example.service;

import com.example.model.FilmEntity;
import com.example.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Repository
@Transactional
public class FilmServiceImpl implements FilmService{

    @Autowired
    FilmRepository filmRepository;

    @Override
    public List<FilmEntity> findAll() {
        return (List<FilmEntity>) filmRepository.findAll();
    }

    @Override
    public FilmEntity findById(Long id) {
        return filmRepository.findById(id);
    }

    public void add(FilmEntity filmEntity){
        filmRepository.save(filmEntity);
    }
}
