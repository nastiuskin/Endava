package com.endava.springbooticek.repository;

import com.endava.springbooticek.DTO.TaskDTO;
import com.endava.springbooticek.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity,Long> {
    void deleteById(Long id);
    List<TaskEntity> findTasksByUserId(Long userId);
    List<TaskEntity> findTasksByLabels_Title(String label);

}
