package net.codejava.controller;


import net.codejava.model.User;
import net.codejava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping()
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/user")
    public String getUserPage2(ModelMap modelMap, Principal principal) {
        modelMap.addAttribute("user", service.loadUserByEmail(principal.getName()));
        return "userPage";
    }
    @GetMapping("/user/{id}")
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
    User user = service.get(id);
    modelMap.addAttribute("user", user);
    return "userPage";
}


}
