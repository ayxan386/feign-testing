package com.aykhan.feignclientexample.controllers;

import com.aykhan.feignclientexample.dto.ResponseDto;
import com.aykhan.feignclientexample.entities.Question;
import com.aykhan.feignclientexample.services.ChangeQuestionService;
import com.aykhan.feignclientexample.services.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class TestController {
  private final TestService testService;
  private final ChangeQuestionService service;

  @Autowired
  public TestController(TestService testService, ChangeQuestionService service) {
    this.testService = testService;
    this.service = service;
  }

  @GetMapping("/getAllTests")
  public ResponseEntity<ResponseDto<List<Question>>> getAllQuestions() {
    return ResponseEntity.ok(new ResponseDto<>(testService
        .getAllQuestions()
        .stream()
        .map(service::isCorrect)
        .collect(Collectors.toList()), ""));
  }

  @PostMapping("/delete/{id}")
  public ResponseEntity<String> deleteQuestion(@PathVariable("id") int id) {
    testService.delete(id);
    return ResponseEntity.ok("Question deleted");
  }
}
