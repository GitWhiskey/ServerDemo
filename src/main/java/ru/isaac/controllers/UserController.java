package ru.isaac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.isaac.model.UserRepository;

/**
 * Created by Maxon on 24.02.2017.
 */
@Controller
@RequestMapping("/UserList")
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("")
    public String getView(Model model) {
        model.addAttribute("users", repository.findAll());
        return "UserList";
    }

    @RequestMapping(value = "/find")
    public String findUsersByUsername(@RequestParam("username") String username, Model model) {
        model.addAttribute("users", repository.findByUsername(username));
        return "UserList :: user-list";
    }
}
