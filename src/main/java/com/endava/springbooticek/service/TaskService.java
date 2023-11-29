package com.endava.springbooticek.service;

import com.endava.springbooticek.entity.TaskEntity;
import com.endava.springbooticek.repository.TaskRepo;
import com.endava.springbooticek.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserRepo userRepo;

//    public TaskEntity createTask(TaskDTO task, Long userId){
//        UserEntity user = userRepo.findById(userId).get();
//
//        return taskRepo.save(task);
//    }

    public TaskEntity updateCompleted(Long task_id){
        TaskEntity task = taskRepo.findById(task_id).get();
        task.setCompleted(!task.getCompleted());
        return taskRepo.save(task);
    }

}
