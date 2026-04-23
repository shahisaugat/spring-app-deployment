package com.learn.taskapi.controller;

import com.learn.taskapi.dto.ApiResponse;
import com.learn.taskapi.dto.request.UserRegisterRequestDto;
import com.learn.taskapi.dto.response.UserResponseDto;
import com.learn.taskapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ApiResponse<UserResponseDto> registerUser(
      @Valid @RequestBody UserRegisterRequestDto request) {
    UserResponseDto response = userService.register(request);

    return new ApiResponse<>("success", "User registered successfully", response);
  }

  @GetMapping("/{id}")
  public ApiResponse<UserResponseDto> getUser(@PathVariable Long id) {

    UserResponseDto response = userService.getUserById(id);

    return new ApiResponse<>("success", "User fetched successfully", response);
  }
}
