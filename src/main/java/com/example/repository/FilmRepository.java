package com.example.repository;

import com.example.model.FilmEntity;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<FilmEntity,Long>{
    FilmEntity findById(Long id);
}
