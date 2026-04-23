package com.learn.taskapi.service;

import com.learn.taskapi.dto.request.UserRegisterRequestDto;
import com.learn.taskapi.dto.response.UserResponseDto;
import com.learn.taskapi.entity.User;
import com.learn.taskapi.exception.ResourceNotFoundException;
import com.learn.taskapi.mapper.UserMapper;
import com.learn.taskapi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserResponseDto register(UserRegisterRequestDto request) {

    User user = UserMapper.toEntity(request);

    User savedUser = userRepository.save(user);

    return UserMapper.toDto(savedUser);
  }

  public UserResponseDto getUserById(Long id) {

    User user =
        userRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    return UserMapper.toDto(user);
  }
}
