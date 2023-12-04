package com.endava.springbooticek.controller;

import com.endava.springbooticek.DTO.UserDTO;
import com.endava.springbooticek.entity.UserEntity;
import com.endava.springbooticek.repository.UserRepo;
import com.endava.springbooticek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDTO());
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerSave(@ModelAttribute("user") UserDTO userDTO, Model model) {
        if (userService.findByUsername(userDTO.getUsername()) != null){
            model.addAttribute("error", true);
            return "redirect:/register?error=true";
        }
        userService.save(userDTO);
        return "redirect:/home";
    }
}
