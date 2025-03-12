package com.codewithamit.blogappapis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoApiHit {

  @GetMapping("/api/server/start")
  public ResponseEntity<String> autoHitApiEveryFiveMinute(){
    return ResponseEntity.ok("Server Up");
  }
}
