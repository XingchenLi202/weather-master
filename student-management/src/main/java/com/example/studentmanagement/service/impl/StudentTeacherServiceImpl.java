package com.example.studentmanagement.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.studentmanagement.exception.ResourceAlreadyExistException;
import com.example.studentmanagement.exception.ResourceNotFoundException;
import static com.example.studentmanagement.pojo.dto.StudentTeacherResponseDTO.*;

import com.example.studentmanagement.pojo.dto.StudentTeacherResponseDTO;
import com.example.studentmanagement.pojo.entity.Student;
import com.example.studentmanagement.pojo.entity.Student_Teacher;
import com.example.studentmanagement.pojo.entity.Teacher;
import com.example.studentmanagement.repository.StudentRepository;
import com.example.studentmanagement.repository.StudentTeacherRepository;
import com.example.studentmanagement.repository.TeacherRepository;
import com.example.studentmanagement.service.StudentTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentTeacherServiceImpl implements StudentTeacherService {

   private final StudentTeacherRepository studentTeacherRepository;
   private final StudentRepository studentRepository;
   private final TeacherRepository teacherRepository;

   @Autowired
   public StudentTeacherServiceImpl(StudentTeacherRepository stR, StudentRepository sR, TeacherRepository tR) {
      this.studentTeacherRepository = stR;
      this.studentRepository = sR;
      this.teacherRepository = tR;
   }

   //get
   @Override
   @Transactional
   public StudentTeacherResponseDTO getAll() {
      List<StudentTeacherDTO> stDTOs= studentTeacherRepository.findAll()
            .stream()
            .map(st -> new StudentTeacherDTO(st))
            .collect(Collectors.toList());

      return new StudentTeacherResponseDTO(stDTOs);
   }

//   @Override
//   @Transactional
//   public StudentTeacherDTO getStudentTeacherById(int id) {
//      Optional<Student_Teacher> st = studentTeacherRepository.findById(id);
//      if(!st.isPresent()){
//         throw new ResourceNotFoundException("The Student_teacher " + id + "is not found.");
//      }
//      return new StudentTeacherDTO(st.get());
//   }

   @Override
   @Transactional
   public StudentTeacherDTO getStudentTeacherByTwoId(int s_id, int t_id) {
      Student_Teacher st = studentTeacherRepository
            .findByStudentIdAndTeacherId(s_id, t_id);
      if(st == null){
         throw new ResourceNotFoundException("The Student_teacher is not found.");
      }
      return new StudentTeacherDTO(st);
   }

//   private List<StudentTeacherDTO> getByTeacherId(int t_id) {
//      List<Student_Teacher> student_teachers = studentTeacherRepository.findByTeacherId(t_id);
//      if(student_teachers == null || student_teachers.isEmpty()){
//         throw new ResourceNotFoundException("The teacher " + t_id + "is not found.");
//      }
//      List<StudentTeacherDTO> studentTeacherDTOs = student_teachers
//            .stream()
//            .map(st -> new StudentTeacherDTO(st))
//            .collect(Collectors.toList());
//      return studentTeacherDTOs;
//   }

   //transaction propagation
   @Override
   @Transactional
   public List<Student> getStudentsByTeaId(int t_id) {
      Logger logger = LoggerFactory.getLogger(getClass());
//      List<StudentTeacherDTO> studentTeacherDTOs = getByTeacherId(t_id);
      List<Student_Teacher> student_teachers = studentTeacherRepository.findByTeacherId(t_id);
      logger.info("can do");
//      for(Student_Teacher st : student_teachers){
//         System.out.println(st.getStu().getId());
//      }

      if(student_teachers == null || student_teachers.isEmpty()){
         throw new ResourceNotFoundException("The teacher " + t_id + "is not found.");
      }
      List<StudentTeacherDTO> studentTeacherDTOs = student_teachers
            .stream()
            .map(st -> new StudentTeacherDTO(st))
            .collect(Collectors.toList());
//roll back
      List<Student> students = new ArrayList<>();
      for(StudentTeacherDTO stDTO : studentTeacherDTOs){
         int s_id = stDTO.getS_id();
         students.add(studentRepository.findById(s_id).get());
      }
      return students;
   }


//   private List<StudentTeacherDTO> getByStudentId(int s_id) {
//      List<Student_Teacher> student_teachers = studentTeacherRepository.findByStduentId(s_id);
//      if(student_teachers == null || student_teachers.isEmpty()) {
//         throw new ResourceNotFoundException("The Student " + s_id + "is not found.");
//      }
//      List<StudentTeacherDTO> studentTeacherDTOs = student_teachers
//            .stream()
//            .map(st -> new StudentTeacherDTO(st))
//            .collect(Collectors.toList());
//      return studentTeacherDTOs;
//   }
   @Override
   @Transactional
   public List<Teacher> getTeachersByStuId(int s_id) {
//      List<StudentTeacherDTO> stDTOs = getByStudentId(s_id);
      List<Student_Teacher> student_teachers = studentTeacherRepository.findByStduentId(s_id);
      if(student_teachers == null || student_teachers.isEmpty()) {
         throw new ResourceNotFoundException("The Student " + s_id + "is not found.");
      }
      List<StudentTeacherDTO> stDTOs = student_teachers
            .stream()
            .map(st -> new StudentTeacherDTO(st))
            .collect(Collectors.toList());

      List<Teacher> teachers = new ArrayList<>();
      for(StudentTeacherDTO stDTO : stDTOs) {
         int t_id = stDTO.getT_id();
         Teacher t = teacherRepository.findById(t_id).get();
         teachers.add(t);
      }
      return teachers;
   }

   //post
   @Override
   @Transactional
   public Student_Teacher saveStudentTeacher(int s_id, int t_id) {
      //check if StudentTeacher exist in junction table
      Student_Teacher st = studentTeacherRepository.findByStudentIdAndTeacherId(s_id, t_id);
      if(st != null){
         throw new ResourceAlreadyExistException("The Student_teacher already existes.");
      }
      //look for stu_id in student table and tea_id in teacher table
      Student student = studentRepository.findById(s_id).orElseThrow(() ->
            new ResourceNotFoundException("The Student_Teacher does not exist, but student " +
                  s_id + "can not found."));
      Teacher teacher = teacherRepository.findById(t_id).orElseThrow(() ->
            new ResourceNotFoundException("The Student_Teacher does not exist, but teacher " +
                  t_id + "can not found."));
      //build the relationship
      Student_Teacher student_teacher = new Student_Teacher(student, teacher);
      //save the relationship in junction table
      studentTeacherRepository.save(student_teacher);
      return student_teacher;
   }

   //put
   @Override
   @Transactional
   public Student_Teacher updateStudentTeacherByTwoId(int s_id, int t_id, StudentTeacherDTO stDTO) {
      //check if old Student_Teacher is existed
      Student_Teacher existing_student_teacher = studentTeacherRepository.findByStudentIdAndTeacherId(s_id, t_id);
      if(existing_student_teacher == null){
         throw new ResourceNotFoundException("The Student_Teacher is not found");
      }
      //get new Student and Teacher
      int newStuId = stDTO.getS_id();
      int newTeaId = stDTO.getT_id();
      Student student = studentRepository.findById(newStuId).orElseThrow(() ->
            new ResourceNotFoundException("The new Student is not found"));
      Teacher teacher = teacherRepository.findById(newTeaId).orElseThrow(() ->
            new ResourceNotFoundException("The new Teacher is not found"));
      //change the attribute of existing Student_Teacher
      existing_student_teacher.setStu(student);
      existing_student_teacher.setTea(teacher);

      return existing_student_teacher;
   }

   //delete
   @Override
   @Transactional
   public void deleteAll() {
      studentTeacherRepository.deleteAll();
   }

   @Override
   @Transactional
   public void deleteStudentTeacherByTwoId(int s_id, int t_id) {
      Student_Teacher student_teacher = studentTeacherRepository.findByStudentIdAndTeacherId(s_id, t_id);
      if(student_teacher == null){
         throw new ResourceNotFoundException("The Student_Teacher is not found");
      }
      studentTeacherRepository.deleteById(student_teacher.getId());
   }
}
