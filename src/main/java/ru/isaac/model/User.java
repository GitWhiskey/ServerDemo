package ru.isaac.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Модель пользователя.
 *
 * Created by Maxon on 24.02.2017.
 */
@Component
public class User {
    private String id;
    private String name;
    private String username;
    private String password;
    private LocalDate birthday;

    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public User(String name, String username, String password, LocalDate birthday) {
        this();
        this.name = name;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
    }

    public String getId() {
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
        this.password = password;
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

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
