package com.learn.taskapi.repository;

import com.learn.taskapi.entity.Task;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
  List<Task> findByUserId(Long userId);
}
