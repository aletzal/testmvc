package com.example.model;


import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.*;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "Tickets")
public class TicketEntity {

    @TableGenerator(name = "ticket_Gen", initialValue = 10)
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ticket_Gen")
    private long id;

    @NotNull(message = "Выберите фильм")
    @ManyToOne
    @JoinColumn(name = "film_id")
    private FilmEntity film;

    @NotEmpty(message = "Введите ваше имя.")
    @Size(min = 3, max = 30, message = "Имя должно содержать от 3 до 30 символов.")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Введите email.")
    @Email(message = "Некорректный адрес email.")
    @Column(name = "email")
    private String email;

    @NumberFormat(style = Style.NUMBER)
//    @Positive(message = "значение не может быть <=0.")
//    @Min(value = 1,message = "Введите целое число от 1 до 3.")    // HSQLdb doesn't support token '>=', which is used by Hinernate ddl
//    @Max(value = 3, message = "Введите целое число от 1 до 3.")   // HSQLdb doesn't support token '<=', which is used by Hinernate ddl
    @Column(name = "hall")
    private int hall;

    @NumberFormat(style = Style.NUMBER)
//    @Positive (message = "значение не может быть <=0.")
//    @Min(value = 1,message = "Введите целое число от 1 до 30.")
//    @Max(value = 30, message = "Введите целое число от 1 до 30.")
    @Column(name = "row")
    private int row;

    @NumberFormat(style = Style.NUMBER)
//    @Positive (message = "значение не может быть <=0.")
//    @Min(value = 1,message = "Введите целое число от 1 до 80.")
//    @Max(value = 80, message = "Введите целое число от 1 до 80.")
    @Column(name = "place")
    private int place;

    @NotEmpty (message = "Введите статус.")
    @Pattern(regexp="^(accepted|paid|cancelled)$", message = "Неправильный статус")
    @Column(name = "status")
    private String status;

    public TicketEntity() {
    }

    public TicketEntity(FilmEntity film, @NotEmpty(message = "Пожалуйста, введите ваше имя.") @Size(min = 3, max = 30, message = "Имя должно содержать от 3 до 30 символов.") String name, @NotEmpty(message = "Пожалуйста, введите email.") @Email(message = "Некорректный адрес email.") String email, @Min(value = 1, message = "введите целое число от 1 до 3.") @Max(value = 3, message = "введите целое число от 1 до 3.") int hall, @Min(value = 1, message = "введите целое число от 1 до 30.") @Max(value = 30, message = "введите целое число от 1 до 30.") int row, @Min(value = 1, message = "введите целое число от 1 до 80.") @Max(value = 80, message = "введите целое число от 1 до 80.") int place, @NotEmpty(message = "Пожалуйста, введите статус.") String status) {
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

    public FilmEntity getFilm() {
        return film;
    }

    public void setFilm(FilmEntity film) {
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
                ", film=" + film +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", hall=" + hall +
                ", row=" + row +
                ", place=" + place +
                ", status='" + status + '\'' +
                '}';
    }
}
