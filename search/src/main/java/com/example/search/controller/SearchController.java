package com.example.search.controller;

import com.example.hw.pojo.User;
import com.example.search.service.SearchService;
import com.example.studentmanagement.pojo.entity.Student;
import com.example.studentmanagement.pojo.entity.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
//@RequestMapping("")
public class SearchController {


    private final SearchService searchService;
//    private final Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search/studentAndTeacher/{id}")
    public ResponseEntity<?> searchStudentAndTeacherAndSave(@PathVariable int id) {
        return new ResponseEntity<>(searchService.searchStudentAndTeacher(id), HttpStatus.OK);
    }

//*    *     *       *       *       *       *       *       *
    @GetMapping("/search")
    public ResponseEntity<?> getDetails() {
        //TODO
        return new ResponseEntity<>("this is search service", HttpStatus.OK);
    }
//*    *     *       *       *       *       *       *       *
//    @GetMapping("/api/v1/{userId}")
//    public ResponseEntity<User> getUserById(@PathVariable int userId) {
//
//        User user = restTemplate.getForObject("http://USERS-SERVICE/api/v1/users/" + userId, User.class);
//        List<User> users = restTemplate.getForObject("http://USERS-SERVICE/api/v1/users", List.class);
//        //        logger.debug(String.valueOf(user.getId()));
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @GetMapping("/api/v1/users")
//    public ResponseEntity<List<User>> getUserById() {
//
//        List<User> users = restTemplate.getForObject("http://USERS-SERVICE/api/v1/users", List.class);
//        //        logger.debug(String.valueOf(user.getId()));
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
}
