package com.example.hw.service;

import com.example.hw.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//public interface UserService {
//   //get
//   List<User> getAllUser();
//   User getUserById(String id);
//   List<User> getUserByLastName(String lastname);
//   //post
//   User saveUser(User user);
//}

@Service
public interface UserService {
   //get
   List<User> getAllUser();
   User getUserById(int id);
   List<User> getUserByLastName(String lastname);

   //post
   User saveUser(User user);
}