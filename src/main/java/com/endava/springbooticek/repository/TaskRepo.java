package com.endava.springbooticek.repository;

import com.endava.springbooticek.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity,Long> {
    public void deleteById(Long id);
}
