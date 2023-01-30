package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.exception.ResourceNotFoundException;
import com.example.studentmanagement.pojo.entity.Student;
import com.example.studentmanagement.pojo.dto.StudentResponseDTO;
import static com.example.studentmanagement.pojo.dto.StudentResponseDTO.*;
import com.example.studentmanagement.repository.StudentRepository;
import com.example.studentmanagement.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

   private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
   private final StudentRepository studentRepository;

   @Autowired
   public StudentServiceImpl(StudentRepository studentRepository){
      this.studentRepository = studentRepository;
   }

   //Get: all students
   @Override
   @Transactional
   public StudentResponseDTO getAllStudent() {
      Collection<Student> studentCollection = studentRepository.findAll();
      List<StudentDTO> studentDTOS = studentCollection
            .stream()
            .map(s -> new StudentDTO(s))
            .collect(Collectors.toList());

      return new StudentResponseDTO(studentDTOS);
   }

   //Get: by id
   @Transactional
   @Override
   public StudentDTO getStudentDTOById(int id) {
      //log id
      logger.debug(String.valueOf(id));

      Optional<Student> student = studentRepository.findById(id);

      //log student info
      logger.debug(student.get().getName());

      if(!student.isPresent()) {
         //log exception
         logger.debug("Throw an Exception: ");
         throw new ResourceNotFoundException("Student not found.");
      }
      return new StudentDTO(student.get());

      //return new StudentDTO(student);
//            StudentDTO.builder()
//            .id(id)
//            .name("Sam")
//            .build();
   }

   @Transactional
   @Override
   public Student getStudentById(int id) {
      //log id
      logger.debug(String.valueOf(id));

      Optional<Student> student = studentRepository.findById(id);

      //log student info
      logger.debug(student.get().getName());

      if(!student.isPresent()) {
         //log exception
         logger.debug("Throw an Exception: ");
         throw new ResourceNotFoundException("Student not found.");
      }
      return student.get();

      //return new StudentDTO(student);
//            StudentDTO.builder()
//            .id(id)
//            .name("Sam")
//            .build();
   }

   //Post
   @Override
   public Student saveStudent(Student student) {
      return studentRepository.save(student);
   }

   //Put
   @Override
   @Transactional
   public Student updateStudent(Student newStudent, int id) {
      Optional<Student> optional = studentRepository.findById(id);
      if(!optional.isPresent()){
         throw new ResourceNotFoundException("Student not found.");
      } else {
         Student existingStudent = optional.get();

         existingStudent.setId(newStudent.getId());
         existingStudent.setName(newStudent.getName());

         studentRepository.save(existingStudent);
         return existingStudent;
      }
   }

   //Delete
   @Override
   @Transactional
   public void deleteStudent(int id) {
      studentRepository.findById(id).orElseThrow(() ->
               new ResourceNotFoundException("Student not found."));
      studentRepository.deleteById(id);
   }

   @Override
   @Transactional
   public void deleteAllStudent() {
      studentRepository.deleteAll();
   }
}
