package ru.isaac.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Maxon on 23.02.2017.
 */
@RestController
public class BasicController {

    @RequestMapping("/greet")
    public String greet(@RequestParam("name") String name) {
        return "<h1>Hello, mr " + name + "!<h1>";
    }
}
