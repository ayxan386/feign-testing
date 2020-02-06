package com.aykhan.feignclientexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignclientexampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(FeignclientexampleApplication.class, args);
  }

}
