package com.example.ai_interview_reminder.exception;

public class DuplicateTaskException extends RuntimeException{
    public DuplicateTaskException(String title){
        super("Task already exists with title"+ title);
    }
}
