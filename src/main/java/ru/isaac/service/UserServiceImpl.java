package ru.isaac.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isaac.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public List<User> listUsers() {
        return null;
    }

    @Override
    public User getUserById(User user) {
        return null;
    }

    @Override
    public void removeUser(User user) {

    }
}
