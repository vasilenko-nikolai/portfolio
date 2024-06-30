package ru.vasilenkonikolai.portfolio.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "username")
    private String username;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Email
    @Column(name = "email")
    private String email;


    @Column(name = "phone_number")
    @Size(min = 10, max = 10)
    private String phoneNumber;


    public Person(String username, String name, String surname, String password, String email, String phoneNumber) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull @Size(min = 3, max = 50) String getUsername() {
        return username;
    }

    public void setUsername(@NotNull @Size(min = 3, max = 50) String username) {
        this.username = username;
    }

    public @NotNull @Size(min = 2, max = 50) String getName() {
        return name;
    }

    public void setName(@NotNull @Size(min = 2, max = 50) String name) {
        this.name = name;
    }

    public @NotNull @Size(min = 2, max = 50) String getSurname() {
        return surname;
    }

    public void setSurname(@NotNull @Size(min = 2, max = 50) String surname) {
        this.surname = surname;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public @NotNull @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email String email) {
        this.email = email;
    }

    public @Size(min = 10, max = 10) String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Size(min = 10, max = 10) String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

