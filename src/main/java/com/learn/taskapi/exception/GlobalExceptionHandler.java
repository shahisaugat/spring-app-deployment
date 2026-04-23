package com.learn.taskapi.exception;

import com.learn.taskapi.dto.ApiResponse;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ApiResponse<Map<String, String>> handleValidationException(
      MethodArgumentNotValidException ex) {

    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult()
        .getFieldErrors()
        .forEach(
            error -> {
              errors.put(error.getField(), error.getDefaultMessage());
            });

    return new ApiResponse<>("fail", "Validation failed", errors);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ApiResponse<String> handleNotFound(ResourceNotFoundException ex) {
    return new ApiResponse<>("fail", ex.getMessage(), null);
  }

  @ExceptionHandler(Exception.class)
  public ApiResponse<String> handleGenericException(Exception ex) {

    return new ApiResponse<>("error", ex.getMessage(), null);
  }
}
