package com.example.service;

import com.example.model.FilmEntity;

public interface FilmService {
    Iterable<FilmEntity> findAll();
    FilmEntity findById(Long id);
}
