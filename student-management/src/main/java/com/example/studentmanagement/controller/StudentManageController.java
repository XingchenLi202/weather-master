package com.example.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentManageController {

   @Value("8001")
   private int randomServerPort;

   @GetMapping("/studentManagement/port")
   public ResponseEntity<?> queryWeatherByCity() {
      return new ResponseEntity<>("student management service + " + randomServerPort, HttpStatus.OK);
   }
}
