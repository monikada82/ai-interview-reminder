package com.example.ai_interview_reminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AiInterviewReminderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiInterviewReminderApplication.class, args);
	}

}
