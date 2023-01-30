package com.example.hw;

import com.example.hw.pojo.User;
import com.example.hw.repository.UserRepository;
import com.example.hw.service.Impl.UserServiceImpl;
import com.example.hw.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

//@SpringBootTest
class HwApplicationTests {

   private static UserRepository userRepository;
   private static UserService userService;
   private User u1;
   private User u2;
   private User u3;
   private User u4;

   @BeforeAll
   public static void init(){
      userRepository = Mockito.mock(UserRepository.class);
      userService = new UserServiceImpl(userRepository);
   }

   @BeforeEach
   public void initUser() {
      u1 = new User(1, "x","m","li", "2000-1-1");
      u2 = new User(2, "p","m","yu", "2000-1-1");
      u3 = new User(3, "x","m","li", "2000-1-1");
      u4 = new User(4, "o","m","wu", "2000-1-1");
   }
   @Test
   public void testGetAll(){
      Mockito.when(userRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(u1,u2,u3)));
      Assertions.assertEquals(userService.getAllUser(), new ArrayList<>(Arrays.asList(u1,u2,u3)));
   }

   @Test
   public void testGetById() {
      Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(u1));
      Assertions.assertEquals(userService.getUserById(1), u1);
   }

   @Test
   public void testGetByLastName() {
      Mockito.when(userRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(u1,u2,u3)));
      Assertions.assertEquals(userService.getUserByLastName("li"), new ArrayList<>(Arrays.asList(u1, u3)));
   }

   @Test
   public void testPost() {
      Mockito.when(userRepository.save(u4)).thenReturn(u4);
      Assertions.assertEquals(userService.saveUser(u4), u4);
   }
}
