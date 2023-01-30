package com.example.studentmanagement.service;

import com.example.studentmanagement.pojo.entity.Teacher;
import com.example.studentmanagement.pojo.dto.TeacherResponseDTO;
import org.springframework.stereotype.Service;

import static com.example.studentmanagement.pojo.dto.TeacherResponseDTO.*;

@Service
public interface TeacherService {
   //Get API
   TeacherResponseDTO getAllTeacher();
   TeacherDTO getTeacherDTOById(int id);
   Teacher getTeacherById(int id);

   //Post API
   Teacher saveTeacher(Teacher teacher);

   //Put API
   Teacher updateTeacher(Teacher teacher, int id);

   //Delete API
   void deleteTeacher(int id);
}
