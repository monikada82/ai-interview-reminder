package com.example.ai_interview_reminder.service;

import com.example.ai_interview_reminder.entity.Task;
import com.example.ai_interview_reminder.repository.TaskRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ReminderScheduler {
    private final TaskRepository taskRepository;

    public ReminderScheduler(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Runs every 60 seconds
    @Scheduled(fixedRate = 60000)
    public void checkUpcomingDeadlines() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextHour = now.plusHours(1);

        List<Task> tasks = taskRepository.findAll();

        for (Task task : tasks) {
            if (!task.isCompleted()
                    && task.getDeadline() != null
                    && task.getDeadline().isAfter(now)
                    && task.getDeadline().isBefore(nextHour)) {

                System.out.println(" Reminder: Task \""
                        + task.getTitle()
                        + "\" is due at "
                        + task.getDeadline());
            }
        }
    }
}
