package com.endava.springbooticek.controller;

import com.endava.springbooticek.DTO.UserDTO;
import com.endava.springbooticek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @Autowired
//    private UserDetailsService userDetailsService;

    @GetMapping("/home")
    public String home(Model model) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
//        model.addAttribute("userdetail", userDetails);
        model.addAttribute("userdetail", new UserDTO());
        return "home";
    }

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
    public String registerSave(@ModelAttribute("user") UserDTO userDTO) {
        if (userService.findByUsername(userDTO.getUsername()) != null)
            return "redirect:/login";
        userService.save(userDTO);
        return "redirect:/home";
    }
}
