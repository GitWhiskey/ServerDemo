package ru.isaac.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maxon on 24.02.2017.
 */
//@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public boolean removeUser(User user) {
        return users.remove(user);
    }

    public List<User> findAll() {
        return users;
    }

    public List<User> findByUsername(String username) {
        if (username == null || username.isEmpty()) {
            return findAll();
        } else {
            return users.stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList());
        }
    }
}
