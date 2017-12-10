package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "Films")
public class FilmEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "year")
    private int year;



}
