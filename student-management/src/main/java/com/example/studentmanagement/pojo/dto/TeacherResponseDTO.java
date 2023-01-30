package com.example.studentmanagement.pojo.dto;

import com.example.studentmanagement.pojo.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TeacherResponseDTO {

   private List<TeacherDTO> teacherDTOList;

   @Data
   @AllArgsConstructor
   @Builder
   public static class TeacherDTO{

      public int id;
      public String name;

      public TeacherDTO (Teacher t){
         id = t.getId();
         name = t.getName();
      }
   }
}
