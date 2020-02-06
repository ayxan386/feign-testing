package com.aykhan.feignclientexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseDto<T> {
  private T data;
  private String message;
}
