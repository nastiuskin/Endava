package com.endava.springbooticek.controller;

import com.endava.springbooticek.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

//    @PostMapping
//    public ResponseEntity createTask(@RequestBody TaskDTO taskDTO,
//                                     @RequestParam Long userId){
//        try{
//            return ResponseEntity.ok(taskService.createTask(taskDTO, userId));
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body("An error occured");
//        }
//    }

//    @PutMapping("/id")
//    public ResponseEntity updateCompleted(@RequestParam Long id){
//        try{
//            return ResponseEntity.ok(taskService.updateCompleted(id));
//        } catch (Exception e){
//            return ResponseEntity.badRequest().body("An error occured");
//        }
//    }
}
