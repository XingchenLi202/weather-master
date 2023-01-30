package com.example.hw.service.Impl;

import com.example.hw.exception.IllegalNullField;
import com.example.hw.exception.ResourceNotFound;
import com.example.hw.pojo.User;
import com.example.hw.repository.UserRepository;
import com.example.hw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

   private final UserRepository userRepository;

   @Autowired
   public UserServiceImpl(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Override
   @Transactional
   public List<User> getAllUser() {

      List<User> users = userRepository.findAll();
      if(users == null){
         throw new ResourceNotFound("Users not found");
      }
      return users;
   }

   @Override
   @Transactional
   public User getUserById(int id) {
      return userRepository.findById(id).get();
   }

   @Override
   @Transactional
   public List<User> getUserByLastName(String lastname) {
      List<User> all = userRepository.findAll();
      List<User> users = new ArrayList<>();
      for(User u : all) {
         if(u.getLastname().equals(lastname)){
            users.add(u);
         }
      }

      return users;
   }

   @Override
   @Transactional
   public User saveUser(User user) {
      if(user.getFirstname() == null){
         throw new IllegalNullField("First name requires not null");
      }
      else if(user.getLastname() == null){
         throw new IllegalNullField("Last name requires not null");
      }
//      else if(user.getDateofbirth() == null){
//         throw new IllegalNullField("Date of birth requires not null");
//      }
      return userRepository.save(user);
   }
}