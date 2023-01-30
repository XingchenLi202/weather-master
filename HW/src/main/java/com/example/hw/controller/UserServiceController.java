package com.example.hw.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceController {

   @Value("8002")
   private int randomServerPort;

   @GetMapping("/users/port")
   public ResponseEntity<?> queryWeatherByCity() {
      return new ResponseEntity<>("student management service + " + randomServerPort, HttpStatus.OK);
   }
}

