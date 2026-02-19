package com.example.ai_interview_reminder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(
        name = "tasks",
        uniqueConstraints = @UniqueConstraint(columnNames = {"title", "deadline"})
)

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String title;

    private String description;
    @NotNull
    private LocalDateTime deadline;

    @Enumerated(EnumType.STRING)

    @NotNull
    private Priority priority;

    private boolean completed = false;

    private LocalDateTime createdAt = LocalDateTime.now();


}

