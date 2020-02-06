package com.aykhan.feignclientexample.services;

import com.aykhan.feignclientexample.entities.Question;
import com.aykhan.feignclientexample.entities.QuestionRedis;
import com.aykhan.feignclientexample.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeQuestionService {
  private final QuestionRepository repository;

  @Autowired
  public ChangeQuestionService(QuestionRepository repository) {
    this.repository = repository;
  }


  public String changeQuestion(int id, String newQuestion) {
    repository.save(new QuestionRedis(id, newQuestion));
    return "success";
  }

  public Question isCorrect(Question q) {
    return repository
        .findById(q.getId())
        .map(t -> {
          q.setQuestion(t.getQuestion());
          return q;
        })
        .orElse(q);
  }
}
