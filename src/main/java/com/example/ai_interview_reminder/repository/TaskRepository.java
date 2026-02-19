package com.example.ai_interview_reminder.repository;

import com.example.ai_interview_reminder.entity.Priority;
import com.example.ai_interview_reminder.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface TaskRepository extends JpaRepository<Task, Long> {
    long countByCompletedTrue();
    long countByCompletedFalse();
    long countByPriority(Priority priority);
    boolean existsByTitleAndDeadline(String title, LocalDateTime deadline);

}
