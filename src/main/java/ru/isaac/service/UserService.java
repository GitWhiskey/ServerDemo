package ru.isaac.service;

import ru.isaac.model.User;

import java.util.List;

public interface UserService {

        public void addUser(User user);
        public void updateUser(User user);
        public List<User> listUsers();
        public User getUserById(User user);
        public void removeUser(User user);

    }

