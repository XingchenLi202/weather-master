package com.example.studentmanagement.service;

import com.example.studentmanagement.pojo.dto.StudentTeacherResponseDTO;
import static com.example.studentmanagement.pojo.dto.StudentTeacherResponseDTO.*;

import com.example.studentmanagement.pojo.entity.Student;
import com.example.studentmanagement.pojo.entity.Student_Teacher;
import com.example.studentmanagement.pojo.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentTeacherService {
   //get
   StudentTeacherResponseDTO getAll();
//   StudentTeacherDTO getStudentTeacherById(int id);

   StudentTeacherDTO getStudentTeacherByTwoId(int s_id, int t_id);

   List<Student> getStudentsByTeaId(int t_id);
   List<Teacher> getTeachersByStuId(int s_id);

   //post
   Student_Teacher saveStudentTeacher(int s_id, int t_id);//exc

   //put
   Student_Teacher updateStudentTeacherByTwoId(int s_id, int t_id, StudentTeacherDTO stDTO);

   //delete
   void deleteAll();
   void deleteStudentTeacherByTwoId(int s_id, int t_id);
}
