package com.example.hw;

import com.example.hw.pojo.User;
import com.example.hw.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest
public class H2WebMVCTest {

//   private final MockMvc mvc;
//   private final ObjectMapper objectMapper;
//   @MockBean
//   private UserService userService;
//
//   @Autowired
//   public H2WebMVCTest(MockMvc mvc, ObjectMapper objectMapper) {
//      this.mvc = mvc;
//      this.objectMapper = objectMapper;
//   }
//   private User getUser1() {
//      User user = new User();
//      user.setFirstname("Tom");
//      user.setLastname("Lin");
//      user.setDateOfBirth(new Date(2000,1,1));
//      return user;
//   }
//
//   private User getUser2() {
//      User user = new User();
//      user.setFirstname("Tony");
//      user.setLastname("Stark");
//      user.setDateOfBirth(new Date(2000,1,1));
//      return user;
//   }
//
//   @Test
//   public void testGetAllUsers() throws Exception {
//      List<User> users = new ArrayList<>();
//      users.add(getUser1());
//      users.add(getUser2());
//      given(userService.getAllUser()).willReturn(users);
//
//      ResultActions response = mvc.perform(get("/api/v1/users"));
//
//      response.andExpect(status().isOk())
//            .andDo(print())
//            .andExpect(jsonPath("$.size()",
//                  is(users.size())));
//   }
//
//   @Test
//   public void testInsertUser() throws Exception {
//      User user = getUser1();
//      given(userService.saveUser(any(User.class)))
//            .willAnswer((invocation) -> invocation.getArgument(0));
//
//      ResultActions response = mvc.perform(post("/api/v1/users")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(objectMapper.writeValueAsString(user)));
//
//      response.andDo(print()).
//            andExpect(status().isCreated())
//            .andExpect(jsonPath("$.firstname",
//                  is(user.getFirstname())))
//            .andExpect(jsonPath("$.lastname",
//                  is(user.getLastname())))
//            .andExpect(jsonPath("$.dateOfBirth",
//                  is(user.getDateOfBirth())));
//   }
}
