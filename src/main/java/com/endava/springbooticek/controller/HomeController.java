package com.endava.springbooticek.controller;

import com.endava.springbooticek.entity.UserEntity;
import com.endava.springbooticek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/home")
    @PreAuthorize("hasRole('USER')")
    public String home(Model model, Principal principal) {
        UserEntity user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "home";
    }
}
