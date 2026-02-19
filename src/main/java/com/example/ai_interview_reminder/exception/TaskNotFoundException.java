package com.example.ai_interview_reminder.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Long id){
        super("Task not found with id"+id);
    }
}
