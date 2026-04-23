package com.learn.taskapi.service;

import com.learn.taskapi.dto.request.TaskCreateRequestDto;
import com.learn.taskapi.dto.response.TaskResponseDto;
import com.learn.taskapi.entity.Task;
import com.learn.taskapi.entity.User;
import com.learn.taskapi.exception.ResourceNotFoundException;
import com.learn.taskapi.mapper.TaskMapper;
import com.learn.taskapi.repository.TaskRepository;
import com.learn.taskapi.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  private final TaskRepository taskRepository;
  private final UserRepository userRepository;

  public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
    this.taskRepository = taskRepository;
    this.userRepository = userRepository;
  }

  public TaskResponseDto createTask(TaskCreateRequestDto request) {

    User user =
        userRepository
            .findById(request.getUserId())
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    Task task = TaskMapper.toEntity(request);

    task.setUser(user);

    Task savedTask = taskRepository.save(task);

    return TaskMapper.toDto(savedTask);
  }

  public TaskResponseDto getTaskById(Long id) {

    Task task =
        taskRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

    return TaskMapper.toDto(task);
  }

  public List<TaskResponseDto> getTasksByUser(Long userId) {

    List<Task> tasks = taskRepository.findByUserId(userId);

    return tasks.stream().map(TaskMapper::toDto).collect(Collectors.toList());
  }

  public void deleteTask(Long id) {

    if (!taskRepository.existsById(id)) {
      throw new ResourceNotFoundException("Task not found");
    }

    taskRepository.deleteById(id);
  }
}
