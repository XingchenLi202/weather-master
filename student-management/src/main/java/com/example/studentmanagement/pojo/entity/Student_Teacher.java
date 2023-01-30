package com.example.studentmanagement.pojo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "teacher_student")
@NoArgsConstructor
@AllArgsConstructor

public class Student_Teacher {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "s_id")
   @JsonIgnore
   private Student stu;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "t_id")
   @JsonIgnore
   private Teacher tea;

   public Student_Teacher(Student stu, Teacher tea) {
      this.stu = stu;
      this.tea = tea;
   }


}
