package com.example.studentmanagement.repository;

import com.example.studentmanagement.pojo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

   //Hard Code test
//   Student findById(int id);
//   Collection<Student> findAll();
}
