package com.endava.springbooticek.controller;

import com.endava.springbooticek.DTO.TaskDTO;
import com.endava.springbooticek.entity.TaskEntity;
import com.endava.springbooticek.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add_task")
    public String add_task(@ModelAttribute("task")TaskDTO taskDTO, @RequestParam("currentLabel") String currentLabel, Model model){
        TaskEntity task = taskService.add_task(taskDTO);
        Long userId = task.getUser().getId();
        model.addAttribute("task", task);
        model.addAttribute("userId", task.getUser().getId());
        if ("all".equals(currentLabel)) {
            return "redirect:/" + userId + "/tasks/all";
        } else {
            return "redirect:/" + userId + "/tasks/" + currentLabel;
        }
    }

    @PostMapping("/delete_task/{taskId}")
    public String delete_task(@PathVariable Long taskId, @RequestParam("currentLabel") String currentLabel){
        Long userId = taskService.findById(taskId).getUser().getId();
        taskService.delete_task(taskId);
        if ("all".equals(currentLabel)) {
            return "redirect:/" + userId + "/tasks/all";
        } else {
            return "redirect:/" + userId + "/tasks/" + currentLabel;
        }
    }

    @GetMapping("/{userId}/tasks/all")
    public String findAllTasksOfUser(@PathVariable Long userId, Model model){
        List<TaskEntity> tasks = taskService.findAllTasksOfUser(userId);
        model.addAttribute("tasks", tasks);
        model.addAttribute("userId", userId);
        return "tasks";
    }

    @GetMapping("/{userId}/tasks/{label}")
    public String findAllTasksOfOneLabel(@PathVariable Long userId,@PathVariable String label, Model model){
        List<TaskEntity> tasks = taskService.findTasksByLabels_Title(label);
        model.addAttribute("tasks", tasks);
        model.addAttribute("userId", userId);
        return "tasks";
    }
}
