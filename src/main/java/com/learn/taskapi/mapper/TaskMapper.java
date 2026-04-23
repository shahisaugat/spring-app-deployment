package com.learn.taskapi.mapper;

import com.learn.taskapi.dto.request.TaskCreateRequestDto;
import com.learn.taskapi.dto.response.TaskResponseDto;
import com.learn.taskapi.entity.Task;

public class TaskMapper {

  public static Task toEntity(TaskCreateRequestDto dto) {
    Task task = new Task();
    task.setTitle(dto.getTitle());
    task.setDescription(dto.getDescription());
    task.setStatus(dto.getStatus());
    task.setPriority(dto.getPriority());
    return task;
  }

  public static TaskResponseDto toDto(Task task) {

    Long userId = null;
    if (task.getUser() != null) {
      userId = task.getUser().getId();
    }

    return new TaskResponseDto(
        task.getId(),
        task.getTitle(),
        task.getDescription(),
        task.getStatus(),
        task.getPriority(),
        task.getCreatedAt(),
        task.getUpdatedAt(),
        userId);
  }
}
