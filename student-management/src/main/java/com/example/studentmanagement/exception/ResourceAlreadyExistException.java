package com.example.studentmanagement.exception;


public class ResourceAlreadyExistException extends RuntimeException{
   public ResourceAlreadyExistException(String message){
      super(message);
   }
}
