package com.tmax.talkstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TalkstreamApplication {

  public static void main(String[] args) {
    SpringApplication.run(TalkstreamApplication.class, args);
  }

}
