package com.example.hw.controller;

import com.example.hw.pojo.User;
import com.example.hw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

   private final UserService userService;

   @Autowired
   public UserController(UserService userService) {
      this.userService = userService;
   }

   @GetMapping
   public ResponseEntity<List<User>> getAll(){
      return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
   }

   @GetMapping("/{id}")
   public ResponseEntity<User> getById(@PathVariable int id) {
      return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
   }

   @GetMapping("/lastname")
   public ResponseEntity<List<User>> getByName(@RequestParam(required = true) String lastname) {
      return new ResponseEntity<>(userService.getUserByLastName(lastname), HttpStatus.OK);
   }

   @PostMapping
   public ResponseEntity<User> saveUser(@RequestBody User user) {
      return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
   }
}