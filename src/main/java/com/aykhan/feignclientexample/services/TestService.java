package com.aykhan.feignclientexample.services;

import com.aykhan.feignclientexample.clients.TestClient;
import com.aykhan.feignclientexample.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

  private final TestClient testClient;

  @Autowired
  public TestService(TestClient testClient) {
    this.testClient = testClient;
  }

  public List<Question> getAllQuestions() {
    if (testClient.getAllQuestion() == null) {
      throw new NullPointerException("empty list");
    }
    return testClient.getAllQuestion();
  }

  public void delete(int id) {
    Question question = Question.builder()
        .id(0).build();
  }
}
