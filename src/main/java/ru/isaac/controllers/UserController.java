package ru.isaac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.isaac.dao.UserDAO;
import ru.isaac.model.User;
import ru.isaac.model.UserRepository;

import java.time.LocalDate;

/**
 * Created by Maxon on 24.02.2017.
 */
@Controller
@RequestMapping("/UserList")
public class UserController {

//    @Autowired
//    private UserRepository repository;

    @Autowired
    private UserDAO repository;

    @RequestMapping("")
    public String getView(Model model) {
        model.addAttribute("users", repository.listUsers());
        return "UserList";
    }

    @RequestMapping(value = "/find")
    public String findUsersByUsername(@RequestParam("username") String username, Model model) {
        model.addAttribute("users", repository.listUsers());
        return "UserList :: user-list";
    }

    @RequestMapping(value = "/add")
    public String addDog(@RequestParam("userName") String dogName,
                         @RequestParam("userPass") String dogPass,
                         @RequestParam("userDate") String dogDateString,
                         @RequestParam("userLogin") String dogLogin,
                         Model model) {
        LocalDate dogDate = LocalDate.parse(dogDateString);
        repository.addUser(new User(dogName,dogLogin,dogPass,dogDate));
        model.addAttribute("users", repository.listUsers());
        return "UserList :: user-list";
    }

    @RequestMapping(value = "/AddUser")
    public String addUser() {
        return "AddUser";
    }
}
