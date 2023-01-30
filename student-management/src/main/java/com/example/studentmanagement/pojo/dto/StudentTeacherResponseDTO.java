package com.example.studentmanagement.pojo.dto;

import com.example.studentmanagement.pojo.entity.Student;
import com.example.studentmanagement.pojo.entity.Student_Teacher;
import com.example.studentmanagement.pojo.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentTeacherResponseDTO {


   List<StudentTeacherDTO> studentTeacherDTOs;

   @Data
   @AllArgsConstructor
   @Builder
   public static class StudentTeacherDTO {
      Logger logger = LoggerFactory.getLogger(getClass());
      private int id;
      private int s_id;
      private int t_id;
      private String s_name;
      private String t_name;

      public StudentTeacherDTO(Student_Teacher st) {
         this.id = st.getId();
         this.s_id = st.getStu().getId();
         this.t_id = st.getTea().getId();
         this.s_name = st.getStu().getName();
         this.t_name = st.getTea().getName();
         logger.debug("s_id: " + s_id);
         logger.debug("t_id: " + t_id);
      }
   }
}
