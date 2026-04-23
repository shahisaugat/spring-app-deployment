package com.learn.taskapi.dto.request;

import com.learn.taskapi.entity.PriorityLevel;
import com.learn.taskapi.entity.TaskStatus;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskCreateRequestDto {
  @NotBlank(message = "Title is required")
  @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
  private String title;

  @Size(max = 1000, message = "Description must not exceed 1000 characters")
  private String description;

  private TaskStatus status;
  private PriorityLevel priority;

  @NotNull(message = "UserId is required")
  private Long userId;
}
