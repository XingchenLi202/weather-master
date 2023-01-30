package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.exception.ResourceNotFoundException;
import com.example.studentmanagement.pojo.entity.Teacher;
import com.example.studentmanagement.pojo.dto.TeacherResponseDTO;
import com.example.studentmanagement.repository.TeacherRepository;
import com.example.studentmanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.studentmanagement.pojo.dto.TeacherResponseDTO.*;

@Service
public class TeacherServiceImpl implements TeacherService {

   private final TeacherRepository teacherRepository;

   @Autowired
   public TeacherServiceImpl(TeacherRepository teacherRepository){
      this.teacherRepository = teacherRepository;
   }

   //Get: all teachers
   @Transactional
   @Override
   public TeacherResponseDTO getAllTeacher() {
      Collection<Teacher> teacherCollection = teacherRepository.findAll();
      List<TeacherDTO> teacherDTOS = teacherCollection
            .stream()
            .map(t -> new TeacherDTO(t))
            .collect(Collectors.toList());
      return new TeacherResponseDTO(teacherDTOS);
   }

   //Get: by id
   @Override
   @Transactional
   public TeacherDTO getTeacherDTOById(int id) {
      Optional<Teacher> teacherOptional = teacherRepository.findById(id);
      if(!teacherOptional.isPresent()) {
         throw new ResourceNotFoundException("Teacher not found.");
      } else {
         return new TeacherDTO(teacherOptional.get());
      }
   }

   @Override
   @Transactional
   public Teacher getTeacherById(int id) {
      Optional<Teacher> teacherOptional = teacherRepository.findById(id);
      if(!teacherOptional.isPresent()) {
         throw new ResourceNotFoundException("Teacher not found.");
      }
      return teacherOptional.get();
   }

   //Post
   @Override
   public Teacher saveTeacher(Teacher teacher) {
      return teacherRepository.save(teacher);
   }

   //Put
   @Override
   @Transactional
   public Teacher updateTeacher(Teacher newTeacher, int id) {
      Teacher existingTeacher = teacherRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Teacher not found."));
      existingTeacher.setId(newTeacher.getId());
      existingTeacher.setName(newTeacher.getName());

      teacherRepository.save(existingTeacher);
      return existingTeacher;
   }

   @Override
   @Transactional
   public void deleteTeacher(int id) {
      Teacher teacher = teacherRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Teacher not found."));
      teacherRepository.deleteById(id);
   }
}
