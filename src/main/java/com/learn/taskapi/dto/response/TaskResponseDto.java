package com.learn.taskapi.dto.response;

import com.learn.taskapi.entity.PriorityLevel;
import com.learn.taskapi.entity.TaskStatus;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskResponseDto {
  private Long id;
  private String title;
  private String description;
  private TaskStatus status;
  private PriorityLevel priority;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private Long userId;
}
