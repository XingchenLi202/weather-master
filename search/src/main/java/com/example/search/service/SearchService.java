package com.example.search.service;

import com.example.hw.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public interface SearchService {
   List<User> searchStudentAndTeacher(int id);
}
