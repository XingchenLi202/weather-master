package com.example.hw.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
   @ExceptionHandler(IllegalNullField.class)
   public ResponseEntity<?> handleIllegalNullException() {
      return new ResponseEntity<>("Not-null Field is Null", HttpStatus.BAD_REQUEST);
   }

   @ExceptionHandler(ResourceNotFound.class)
   public ResponseEntity<?> handleResourceNotFoundException() {
      return new ResponseEntity<>("Users is not found", HttpStatus.NOT_FOUND);
   }
}
