package com.example.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  private static final Logger LOGGER = LogManager.getLogger(Controller.class);

  @GetMapping("/ping")
  public String ping() throws InterruptedException {

    LOGGER.info("Pong response sent.");

    return "pong";
  }
}
