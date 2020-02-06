package com.aykhan.feignclientexample.services;

import com.aykhan.feignclientexample.clients.TestClient;
import com.aykhan.feignclientexample.entities.Question;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(TestService.class)
class TestServiceTest {

  @MockBean
  private TestClient testClient;

  @Autowired
  private TestService testService;

  @Test
  void getAllQuestions() {
    List<Question> data = new ArrayList<Question>();
    data.add(Question.builder().id(1).build());

    when(testClient.getAllQuestion())
        .thenReturn(data);

    List<Question> res = testService.getAllQuestions();

    assertThat(res.size()).isEqualTo(1);
    assertThat(res.get(0).getId()).isEqualTo(1);

  }

  @Test
  void getAllQuestionsEmptyData() {
    List<Question> data = null;
    when(testClient.getAllQuestion()).thenReturn(data);

    assertThatThrownBy(() -> testService.getAllQuestions())
        .isInstanceOf(NullPointerException.class)
        .hasMessage("empty list");
  }
}