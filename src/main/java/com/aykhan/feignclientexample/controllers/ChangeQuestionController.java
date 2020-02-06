package com.aykhan.feignclientexample.controllers;

import com.aykhan.feignclientexample.services.ChangeQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/changeName")
public class ChangeQuestionController {

  private final ChangeQuestionService service;

  public ChangeQuestionController(ChangeQuestionService service) {
    this.service = service;
  }

  @PostMapping("/{id}")
  public ResponseEntity<String> changeQuestion(@PathVariable int id, @RequestBody String newQuestion) {
    return ResponseEntity.ok(service.changeQuestion(id, newQuestion));
  }

}
