package com.learn.taskapi.mapper;

import com.learn.taskapi.dto.request.UserRegisterRequestDto;
import com.learn.taskapi.dto.response.UserResponseDto;
import com.learn.taskapi.entity.User;

public class UserMapper {

  public static User toEntity(UserRegisterRequestDto dto) {
    User user = new User();
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    user.setPassword(dto.getPassword());
    return user;
  }

  public static UserResponseDto toDto(User user) {
    return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
  }
}
