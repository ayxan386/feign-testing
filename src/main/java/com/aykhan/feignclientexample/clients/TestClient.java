package com.aykhan.feignclientexample.clients;

import com.aykhan.feignclientexample.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "http://localhost:5001/", name = "questionRepo")
public interface TestClient {

  @GetMapping("/api/question")
  List<Question> getAllQuestion();

}
