package com.example.studentmanagement.pojo.dto;

import com.example.studentmanagement.pojo.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentResponseDTO {
   public List<StudentDTO> studentDTOList;

   @Data
   @AllArgsConstructor
   @Builder
   public static class StudentDTO {
      public int id;
      public String name;

      public StudentDTO(Student s) {
         this.id = s.getId();
         this.name = s.getName();
      }
   }
}
