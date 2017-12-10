package com.example.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Tickets")
public class TicketEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Film name.")
    @Column(name = "film")
    private String film;

    @NotEmpty(message = "Пожалуйста, введите ваше имя.")
    @Size(min = 3, max = 30, message = "Имя должно содержать от 3 до 30 символов.")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Пожалуйста, введите email.")
    @Email(message = "Некорректный адрес email.")
    @Column(name = "email")
    private String email;

    @Positive(message = "значение не может быть <=0.")
    @Column(name = "hall")
    private int hall;

    @Positive (message = "значение не может быть <=0.")
    @Column(name = "row")
    private int row;

    @Positive (message = "значение не может быть <=0.")
    @Column(name = "place")
    private int place;

    @NotEmpty (message = "Пожалуйста, введите статус.")
    @Column(name = "status")
    private String status;

    public TicketEntity() {
    }

    public TicketEntity(String film, String name, String email, int hall, int row, int place, String status) {
        this.film = film;
        this.name = name;
        this.email = email;
        this.hall = hall;
        this.row = row;
        this.place = place;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "id=" + id +
                ", film='" + film + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", hall=" + hall +
                ", row=" + row +
                ", place=" + place +
                ", status='" + status + '\'' +
                '}';
    }
}
