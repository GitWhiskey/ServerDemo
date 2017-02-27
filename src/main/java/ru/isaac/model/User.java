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
@Table(name = "User" )
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;

    private String name;
    private String username;
    private String password;
    private LocalDate birthday;

    public User(String name, String username, String password, LocalDate birthday) {
        this();
        this.name = name;
        this.username = username;
        setPassword(password); // для шифровки
        this.birthday = birthday;
    }

    public User() {
        this.id = UUID.randomUUID().toString();
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

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
