package com.waltersoft.reactiveweb.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Simple app for use in tests that has no dependencies */
@SpringBootApplication
public class WebFluxTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebFluxTestApplication.class, args);
  }
}
