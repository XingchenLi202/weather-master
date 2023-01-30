package com.example.studentmanagement.controller;

import static com.example.studentmanagement.pojo.dto.TeacherResponseDTO.*;
import static com.example.studentmanagement.pojo.dto.StudentTeacherResponseDTO.*;
import static com.example.studentmanagement.pojo.dto.StudentResponseDTO.*;

import com.example.studentmanagement.pojo.dto.StudentTeacherResponseDTO;
import com.example.studentmanagement.pojo.entity.Student;
import com.example.studentmanagement.pojo.entity.Student_Teacher;
import com.example.studentmanagement.pojo.entity.Teacher;
import com.example.studentmanagement.service.StudentService;
import com.example.studentmanagement.service.StudentTeacherService;
import com.example.studentmanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student_teacher")
public class StudentTeacherController {

   private final StudentTeacherService studentTeacherService;

   @Autowired
   public StudentTeacherController(StudentTeacherService studentTeacherService) {
      this.studentTeacherService = studentTeacherService;
   }

   //get
   @GetMapping
   public ResponseEntity<StudentTeacherResponseDTO> getAllStudentAndTeacher() {
      return new ResponseEntity<>(studentTeacherService.getAll(), HttpStatus.OK);
   }

   @GetMapping("/student/{s_id}/teacher/{t_id}")
   public ResponseEntity<StudentTeacherDTO> getStudentTeacherByTwoId(@PathVariable int s_id, @PathVariable int t_id){
      return new ResponseEntity<>(studentTeacherService.getStudentTeacherByTwoId(s_id, t_id), HttpStatus.OK);
   }

   @GetMapping("/students/{t_id}")
   public ResponseEntity<List<Student>> getStudentsByTeacherId(@PathVariable int t_id){
      List<Student> students = studentTeacherService.getStudentsByTeaId(t_id);
      return new ResponseEntity<>(students, HttpStatus.OK);
   }

   @GetMapping("/teachers/{s_id}")
   public ResponseEntity<List<Teacher>> getTeachersByStudentId(@PathVariable int s_id){
      List<Teacher> teachers = studentTeacherService.getTeachersByStuId(s_id);
      return new ResponseEntity<>(teachers, HttpStatus.OK);
   }

   //post
   @PostMapping
   public ResponseEntity<Student_Teacher> saveStudentTeacher(@RequestBody StudentTeacherDTO stDTO) {
      return new ResponseEntity<>(studentTeacherService.saveStudentTeacher(stDTO.getS_id(), stDTO.getT_id()), HttpStatus.OK);
   }

   //put
   @PutMapping("/student/{s_id}/teacher/{t_id}")
   public ResponseEntity<Student_Teacher> updateStudentTeacherByTwoId(@PathVariable int s_id, @PathVariable int t_id, @RequestBody StudentTeacherDTO stDTO) {
      return new ResponseEntity<>(studentTeacherService.updateStudentTeacherByTwoId(s_id, t_id, stDTO), HttpStatus.OK);
   }

   //delete
   @DeleteMapping
   public ResponseEntity<String> deleteAll() {
      studentTeacherService.deleteAll();
      return new ResponseEntity<>("Delete all relationship successfully.", HttpStatus.OK);
   }
   @DeleteMapping("/student/{s_id}/teacher/{t_id}")
   public ResponseEntity<String> deleteStudentTeacherByTwoId(@PathVariable int s_id, @PathVariable int t_id) {
      studentTeacherService.deleteStudentTeacherByTwoId(s_id, t_id);
      return new ResponseEntity<>("Delete the relationship successfully.", HttpStatus.OK);
   }
}
