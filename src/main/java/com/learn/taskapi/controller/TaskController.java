package com.learn.taskapi.controller;

import com.learn.taskapi.dto.ApiResponse;
import com.learn.taskapi.dto.request.TaskCreateRequestDto;
import com.learn.taskapi.dto.response.TaskResponseDto;
import com.learn.taskapi.service.TaskService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping
  public ApiResponse<TaskResponseDto> createTask(@Valid @RequestBody TaskCreateRequestDto request) {

    TaskResponseDto response = taskService.createTask(request);

    return new ApiResponse<>("success", "Task created successfully", response);
  }

  @GetMapping("/{id}")
  public ApiResponse<TaskResponseDto> getTask(@PathVariable Long id) {

    TaskResponseDto response = taskService.getTaskById(id);

    return new ApiResponse<>("success", "Task fetched successfully", response);
  }

  @GetMapping("/user/{userId}")
  public ApiResponse<List<TaskResponseDto>> getTasksByUser(@PathVariable Long userId) {

    List<TaskResponseDto> response = taskService.getTasksByUser(userId);

    return new ApiResponse<>("success", "Tasks fetched successfully", response);
  }

  @DeleteMapping("/{id}")
  public ApiResponse<Void> deleteTask(@PathVariable Long id) {

    taskService.deleteTask(id);

    return new ApiResponse<>("success", "Task deleted successfully", null);
  }
}
