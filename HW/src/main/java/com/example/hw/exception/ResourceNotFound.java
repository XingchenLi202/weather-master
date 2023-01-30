package com.example.hw.exception;

public class ResourceNotFound extends RuntimeException{
   public ResourceNotFound(String msg) {
      super(msg);
   }
}
