package com.endava.springbooticek.service;


import com.endava.springbooticek.entity.UserEntity;
import com.endava.springbooticek.DTO.UserDTO;
import com.endava.springbooticek.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserEntity findByUsername(String userName){
        return userRepo.findByUsername(userName);
    }

    public UserEntity save(UserDTO userDTO){
        UserEntity user = new UserEntity(userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword()));
        return userRepo.save(user);
    }

}
