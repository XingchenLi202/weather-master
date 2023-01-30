package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.service.RestTemplateService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

   RestTemplate restTemplate = new RestTemplate();

   private static final String GET_ALL_STUDENTS_API= "http://localhost:8000/students";

   //Method to get all students
   public ResponseEntity<String> getAllStudents(){

      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

      HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

      ResponseEntity<String> response = restTemplate.exchange(GET_ALL_STUDENTS_API, HttpMethod.GET, entity, String.class);
      return response;
   }
}
