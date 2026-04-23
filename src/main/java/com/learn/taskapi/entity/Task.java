package com.learn.taskapi.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String title;

  @Column(length = 1000)
  private String description;

  @Column(nullable = false, length = 20)
  @Enumerated(EnumType.STRING)
  private TaskStatus status;

  @Column(nullable = false, length = 20)
  @Enumerated(EnumType.STRING)
  private PriorityLevel priority;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(updatable = false)
  private LocalDateTime createdAt;

  @Column private LocalDateTime updatedAt;

  @PrePersist
  public void onCreate() {

    if (this.status == null) {
      this.status = TaskStatus.TODO;
    }

    if (this.priority == null) {
      this.priority = PriorityLevel.MEDIUM;
    }

    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  public void onUpdate() {
    this.updatedAt = LocalDateTime.now();
  }
}
