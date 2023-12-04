package com.endava.springbooticek.service;
import com.endava.springbooticek.DTO.TaskDTO;
import com.endava.springbooticek.entity.LabelEntity;
import com.endava.springbooticek.entity.TaskEntity;
import com.endava.springbooticek.entity.UserEntity;
import com.endava.springbooticek.repository.LabelRepo;
import com.endava.springbooticek.repository.TaskRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private LabelRepo labelRepo;

    private TaskDTO mapToDTO(final TaskEntity task, final TaskDTO taskDTO) {
        taskDTO.setTitle(task.getTitle());
        taskDTO.setCompleted(task.getCompleted());
        Set<String> labels = new HashSet<>();
        for(LabelEntity label: task.getLabels()){
            labels.add(label.getTitle());
        }
        taskDTO.setLabels(labels);
        return taskDTO;
    }

    private TaskEntity mapToEntity(final TaskDTO taskDTO, final TaskEntity task){
        CustomUserDetails currentUser = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity user = userService.findByUsername(currentUser.getUsername());
        task.setUser(user);
        Set<LabelEntity> labels = new HashSet<>();
        if (taskDTO.getLabels() != null) {
            for (String label : taskDTO.getLabels()) {
                LabelEntity labelEntity;
                labelEntity = labelRepo.getLabelEntityByTitle(label);
                labels.add(labelEntity);
            }
        }
        task.setLabels(labels);
        task.setTitle(taskDTO.getTitle());
        task.setCompleted(taskDTO.getCompleted());
         return task;
    }

    @Transactional
    public TaskEntity add_task(TaskDTO taskDTO){
        TaskEntity task = new TaskEntity();
        mapToEntity(taskDTO,task);
        task.setDate(new Date());
        return taskRepo.save(task);
    }

    @Transactional
    public void delete_task(Long taskId){
        taskRepo.deleteById(taskId);
        }

    public List<TaskEntity> findAllTasksOfUser(Long userId) {
        return  taskRepo.findTasksByUserId(userId);
    }

    public List<TaskEntity> findTasksByLabels_Title(String label){
        List<TaskEntity> tasks = taskRepo.findTasksByLabels_Title(label);
        return tasks;
    }

    public TaskEntity findById(Long taskId){
        return taskRepo.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Task not found"));
    }
    }

