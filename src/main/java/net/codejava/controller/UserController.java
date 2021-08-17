package net.codejava.controller;


import net.codejava.model.User;
import net.codejava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;


    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    User user = service.get(id);
    model.addAttribute("user", user);
    return "userPage";
}


}
