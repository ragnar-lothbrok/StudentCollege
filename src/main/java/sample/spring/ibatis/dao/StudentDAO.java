package sample.spring.ibatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sample.spring.ibatis.model.Student;

public interface StudentDAO {

    public List<Student> getAllStudent();

    public Student getStudentById(@Param("studentId") int studentId);

    public int saveStudent(@Param("student") Student student);

    public void updateStudent(@Param("student") Student student);

    public void deleteStudent(@Param("studentId") int studentId);
}
