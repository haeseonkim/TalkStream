package com.tmax.talkstream.controller;

import com.tmax.talkstream.dto.TempDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @GetMapping("/test")
  public ResponseEntity<TempDto> test(){
    return ResponseEntity.ok(
      TempDto.builder()
        .name("juno!")
        .build());
  }
}
