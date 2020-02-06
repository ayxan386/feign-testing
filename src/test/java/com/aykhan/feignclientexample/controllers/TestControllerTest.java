package com.aykhan.feignclientexample.controllers;

import com.aykhan.feignclientexample.entities.Question;
import com.aykhan.feignclientexample.services.ChangeQuestionService;
import com.aykhan.feignclientexample.services.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
@RunWith(SpringRunner.class)
public class TestControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  private TestService testClient;
  @MockBean
  private ChangeQuestionService service;

  @Test
  public void getAllQuestions() throws Exception {
    List<Question> data = new ArrayList<Question>();
    data.add(Question.builder().id(1).build());
    when(testClient.getAllQuestions()).thenReturn(data);
    mockMvc.perform(get("/getAllTests")

        .accept(APPLICATION_JSON)
    ).andExpect(status().isOk());
  }

  @Test
  public void deleteQuestion() throws Exception {
    mockMvc.perform(post("/delete/1")
        .accept(APPLICATION_JSON)
    ).andExpect(status().isOk());
  }
}