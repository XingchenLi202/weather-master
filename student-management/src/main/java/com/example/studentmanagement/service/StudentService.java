package com.example.studentmanagement.service;

import com.example.studentmanagement.pojo.entity.Student;
import com.example.studentmanagement.pojo.dto.StudentResponseDTO;
import org.springframework.stereotype.Service;
import static com.example.studentmanagement.pojo.dto.StudentResponseDTO.*;

@Service
public interface StudentService {
   //Get API
   StudentResponseDTO getAllStudent();
   StudentDTO getStudentDTOById(int id);
   Student getStudentById(int id);

   //Post API
   Student saveStudent(Student student);

   //Put API
   Student updateStudent(Student student, int id);

   //Delete API
   void deleteStudent(int id);
   void deleteAllStudent();
}
