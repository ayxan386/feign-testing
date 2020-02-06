package com.aykhan.feignclientexample.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Question")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRedis {
  private int id;
  private String question;
}
