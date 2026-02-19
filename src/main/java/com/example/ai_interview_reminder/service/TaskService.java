package com.example.ai_interview_reminder.service;
import java.util.HashMap;
import java.util.Map;

import com.example.ai_interview_reminder.entity.Priority;
import com.example.ai_interview_reminder.entity.Task;
import com.example.ai_interview_reminder.exception.DuplicateTaskException;
import com.example.ai_interview_reminder.exception.TaskNotFoundException;
import com.example.ai_interview_reminder.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    // Constructor Injection
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Create task
    public Task createTask(Task task) {

        boolean exists = taskRepository
                .existsByTitleAndDeadline(task.getTitle(), task.getDeadline());

        if (exists) {
            throw new DuplicateTaskException(task.getTitle());
        }

        return taskRepository.save(task);
    }


    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get task by ID
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    // Mark task as completed
    public Task completeTask(Long id) {
        Task task = getTaskById(id);
        task.setCompleted(true);
        return taskRepository.save(task);
    }

    // Delete task
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    public Map<String, Long> getTaskAnalytics() {

        Map<String, Long> stats = new HashMap<>();

        stats.put("totalTasks", taskRepository.count());
        stats.put("completedTasks", taskRepository.countByCompletedTrue());
        stats.put("pendingTasks", taskRepository.countByCompletedFalse());
        stats.put("highPriorityTasks", taskRepository.countByPriority(Priority.HIGH));

        return stats;
    }

}
