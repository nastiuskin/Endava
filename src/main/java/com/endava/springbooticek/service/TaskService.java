package com.endava.springbooticek.service;

import com.endava.springbooticek.DTO.TaskDTO;
import com.endava.springbooticek.entity.LabelEntity;
import com.endava.springbooticek.entity.TaskEntity;
import com.endava.springbooticek.entity.UserEntity;
import com.endava.springbooticek.repository.TaskRepo;
import com.endava.springbooticek.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private LabelService labelService;

//    private TaskDTO mapToDTO(final TaskEntity task, final TaskDTO taskDTO) {
//        taskDTO.setTitle(task.getTitle());
//        taskDTO.setCompleted(task.getCompleted());
//        taskDTO.setLabels(task.getLabels());
//        return taskDTO;
//    }

//    private TaskEntity mapToEntity(final TaskDTO taskDTO, final TaskEntity task){
//        task.setCompleted(taskDTO.getCompleted());
//        task.setLabels(taskDTO.getLabels());
//        task.setTitle(taskDTO.getTitle());
//         return task;
//    }

    @Transactional
    public TaskEntity add_task(TaskDTO taskDTO){
            CustomUserDetails currentUser = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserEntity user = userService.findByUsername(currentUser.getUsername());
            TaskEntity task = new TaskEntity();
            task.setTitle(taskDTO.getTitle());
            task.setDate(new Date());
            Set<LabelEntity> labels = new HashSet<>();
            if (taskDTO.getLabels() != null) {
                for(String labelTitle: taskDTO.getLabels()){
                    if (labelTitle != null) {
                        LabelEntity label = labelService.getLabelEntityByTitle(labelTitle);
                        if(label != null){
                            labels.add(label);
                        }
                    }
                }
            }
            task.setLabels(labels);
            task.setCompleted(taskDTO.getCompleted());
            task.setUser(user);
            return taskRepo.save(task);
    }

    public void delete_task(Long id){
        taskRepo.deleteById(id);
    }

//    public List<TaskDTO> findAllTasksOfUser(Long userId){
//
//    }

}
