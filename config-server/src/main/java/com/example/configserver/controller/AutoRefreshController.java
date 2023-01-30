//package com.example.configserver.controller;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RefreshScope
//public class AutoRefreshController {
//
//   @Value("${my.greeting.message}")
//   private String greetingMessage;
//
//   @GetMapping("/config/greeting")
//   public ResponseEntity<String> getGreeting() {
//      return new ResponseEntity<>("greeting:" + greetingMessage, HttpStatus.OK);
//   }
//}
