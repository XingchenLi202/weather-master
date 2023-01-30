package com.example.hw;

import com.example.hw.pojo.User;
import com.example.hw.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestWithH2 {
   private final UserService userService;

   private static User u1;
   private static User u2;
   private static User u3;

   @Autowired
   public TestWithH2(UserService userService) {
      this.userService = userService;
   }

   @BeforeAll
   public static void init(){
      u1 = new User(1, "x","o","li", "2000-1-1");
      u2 = new User(2, "x","o","wu", "2000-1-1");
      u3 = new User(3, "x","o","li", "2000-1-1");
   }


   @Test
   public void testGetAll() {
      userService.saveUser(u1);
      userService.saveUser(u2);
      userService.saveUser(u3);

      List<User> users = userService.getAllUser();
      Assertions.assertEquals(users, new ArrayList<>(Arrays.asList(u1, u2, u3)));

      User u4 = new User(4, "x","o","li", "2000-1-1");
      userService.saveUser(u4);
      Assertions.assertEquals(userService.getAllUser(), new ArrayList<>(Arrays.asList(u1, u2, u3, u4)));
   }

   @Test
   public void testSave() {
      User userR1 = userService.saveUser(u1);
      Assertions.assertEquals(userR1, u1);
   }
   @Test
   public void testGetById(){
      userService.saveUser(u1);
      userService.saveUser(u2);
      userService.saveUser(u3);

      User user2 = userService.getUserById(2);
      Assertions.assertEquals(user2, u2);
   }
   @Test
   public void testGetByLastName() {
      userService.saveUser(u1);
      userService.saveUser(u2);
      userService.saveUser(u3);

      List<User> users = userService.getUserByLastName("li");
      Assertions.assertEquals(users, new ArrayList<>(Arrays.asList(u1,u3)));
   }
}
