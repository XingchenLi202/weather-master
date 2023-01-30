package com.example.studentmanagement.repository;

import com.example.studentmanagement.pojo.entity.Student;
import com.example.studentmanagement.pojo.entity.Student_Teacher;
import com.example.studentmanagement.pojo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentTeacherRepository extends JpaRepository<Student_Teacher, Integer> {

   @Query("select st from Student_Teacher st where st.stu.id=?1")
   List<Student_Teacher> findByStduentId(int s_id);

   @Query("select st from Student_Teacher st where st.tea.id=?1")
   List<Student_Teacher> findByTeacherId(int t_id);

   @Query("select st from Student_Teacher st where st.stu.id=?1 and st.tea.id=?2")
   Student_Teacher findByStudentIdAndTeacherId(int s_id, int t_id);

}
