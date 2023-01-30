package com.example.studentmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {

   @ExceptionHandler
   public ResponseEntity<String> handleResourceAlreadyExistException(ResourceAlreadyExistException e) {
      return new ResponseEntity<>(e.getMessage() + " Handle Resource Already Exist Exception!", HttpStatus.NOT_ACCEPTABLE);
   }
   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
      return new ResponseEntity<>(e.getMessage() + " Handle Resource Not Found Exception!", HttpStatus.NOT_FOUND);
   }

}
