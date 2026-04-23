package com.learn.taskapi.dto.request;

import com.learn.taskapi.entity.PriorityLevel;
import com.learn.taskapi.entity.TaskStatus;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskUpdateRequestDto {
  @NotBlank(message = "Title is required")
  @Size(min = 3, max = 100)
  private String title;

  @Size(max = 1000)
  private String description;

  private TaskStatus status;
  private PriorityLevel priority;
}
