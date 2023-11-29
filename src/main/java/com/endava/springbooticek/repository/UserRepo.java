package com.endava.springbooticek.repository;

import com.endava.springbooticek.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    public UserEntity findByUsername(String userName);
}
