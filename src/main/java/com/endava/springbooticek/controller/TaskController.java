package com.endava.springbooticek.controller;

import com.endava.springbooticek.DTO.TaskDTO;
import com.endava.springbooticek.entity.TaskEntity;
import com.endava.springbooticek.service.TaskService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add_task")
    public String add_task(@ModelAttribute("task")TaskDTO taskDTO, Model model){
        TaskEntity task = taskService.add_task(taskDTO);
        model.addAttribute("task", task);
        return "add_task";
    }

    @GetMapping("/delete_task/{taskId}")
    public String delete_task(@PathVariable Long taskId){
//        taskService.delete_task(taskId);
        return "delete_task";
    }
}
