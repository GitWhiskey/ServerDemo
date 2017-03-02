package ru.isaac.dao;

import ru.isaac.model.User;

import java.util.List;

public interface UserDAO {
    public void addUser(User user);

    public void updateUser(User user);

    public List<User> listUsers();

    public User getUserById(int id);

    public void removeUser(int id);

    public List<User> findByUsername(String username);
}
