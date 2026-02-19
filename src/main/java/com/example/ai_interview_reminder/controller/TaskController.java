package com.example.ai_interview_reminder.controller;

import com.example.ai_interview_reminder.entity.Task;
import com.example.ai_interview_reminder.service.TaskService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @PostMapping
    public Task createTask(@Valid @RequestBody Task task){
        return taskService.createTask(task);
    }
    @GetMapping
    public List<Task>getAllTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }
    @PutMapping("/{id}/complete")
    public Task completeTask(@PathVariable Long id){
        return taskService.completeTask(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id)
    {
        taskService.deleteTask(id);
    }
    @GetMapping("/analytics")
    public Map<String, Long> getAnalytics() {
        return taskService.getTaskAnalytics();
    }

}
