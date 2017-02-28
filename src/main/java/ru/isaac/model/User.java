package ru.isaac.model;

import org.springframework.stereotype.Component;
import ru.isaac.security.SecurityConfiguration;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Модель пользователя.
 *
 * Created by Maxon on 24.02.2017.
 */
@Component
@Entity
@Table(name = "user" )
public class User {
    @Id
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "birthday")
    private LocalDate birthday;

    public User(String name, String username, String password, LocalDate birthday) {
        this.name = name;
        this.username = username;
        setPassword(password); // для шифровки
        this.birthday = birthday;
    }

    public User() {
     this.id = this.id + 1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null) {
            this.password = SecurityConfiguration.passwordEncoder().encode(password);
        }
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
