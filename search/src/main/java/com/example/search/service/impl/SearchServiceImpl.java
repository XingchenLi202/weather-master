package com.example.search.service.impl;

import com.example.hw.pojo.User;
import com.example.search.service.SearchService;
import com.example.studentmanagement.pojo.entity.Student;
import com.example.studentmanagement.pojo.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SearchServiceImpl implements SearchService{
   //    @Value("@{users-service.user.save.api}")
//    private String userSaveURL;
//
//    @Value("@{student-management.student.deleteAll.api}")
//    private String studentDeleteAllURL;
   @Value("@{student-management.student.getById.api}")
   private String studentGetByIdURL;

   @Value("@{student-management.teacher.getById.api}")
   private String teacherGetByIdURL;

   private static final ExecutorService pool = Executors.newCachedThreadPool();
   private final RestTemplate restTemplate;

   @Autowired
   public SearchServiceImpl(RestTemplate restTemplate) {
      this.restTemplate = restTemplate;
   }

   @Override
   @Transactional
   public List<User> searchStudentAndTeacher(int id) {
      //get one student and one teacher
      User u1 = new User();
      User u2 = new User();

      CompletableFuture.allOf(
            CompletableFuture.supplyAsync(() ->
                        restTemplate.getForObject("http://STUDENT-MANAGEMENT/api/v1/students/" + id, Student.class), pool)
                  .thenAccept(x -> u1.setFirstname(x.getName())),

            CompletableFuture.supplyAsync(() ->
                        restTemplate.getForObject("http://STUDENT-MANAGEMENT/api/v1/teachers/" + id, Teacher.class), pool)
                  .thenAccept(x -> u2.setFirstname(x.getName()))
      ).join();
      return new ArrayList<>(Arrays.asList(u1, u2));
   }
}
