package com.endava.springbooticek.service;


import com.endava.springbooticek.entity.UserEntity;
import com.endava.springbooticek.DTO.UserDTO;
import com.endava.springbooticek.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
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

    public UserEntity findById(Long id){
        return userRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    private UserDTO mapToDTO(final UserEntity user, final UserDTO userDTO){
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(userDTO.getPassword());
        return userDTO;
    }

    private UserEntity mapToUserEntity(final UserDTO userDTO, final UserEntity user){
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return user;
    }


}
