package com.aykhan.feignclientexample.controllers;

import com.aykhan.feignclientexample.repository.QuestionRepository;
import com.aykhan.feignclientexample.services.ChangeQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ChangeQuestionController.class)
@RunWith(SpringRunner.class)
class ChangeQuestionControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  ChangeQuestionService service;

  @MockBean
  QuestionRepository repository;

  @Test
  void changeQuestion() throws Exception {
    when(repository.save(Mockito.any()))
        .thenReturn(null);

    mockMvc.perform(post("/changeName/{id}", 1)
        .content("\"newName\"")
        .characterEncoding("UTF-8")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

}