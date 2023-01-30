package com.example.studentmanagement.controller;

import com.example.studentmanagement.service.RestTemplateService;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resttmplate/v1")
public class RestTemplateController {

   private final RestTemplateService restTemplateService;

   @Autowired
   public RestTemplateController(RestTemplateService restTemplateService) {
      this.restTemplateService = restTemplateService;
   }

   public ResponseEntity<String> getAllStudents(){
      return restTemplateService.getAllStudents();
   }
}
