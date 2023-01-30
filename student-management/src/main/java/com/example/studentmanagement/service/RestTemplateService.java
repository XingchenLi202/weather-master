package com.example.studentmanagement.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RestTemplateService {
   ResponseEntity<String> getAllStudents();
}
