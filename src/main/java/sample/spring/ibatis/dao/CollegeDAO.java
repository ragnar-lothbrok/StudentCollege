package sample.spring.ibatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sample.spring.ibatis.model.College;
import sample.spring.ibatis.model.Student;

public interface CollegeDAO {
    List<College> getAllColleges();

    List<Student> getStudentByCollegeId(@Param("collegeId") Integer id);

    void saveStudentCollegeMapping(@Param("studentId") Integer studentId, @Param("collegeId") Integer collegeId);

    void deleteMappingByStudentId(@Param("studentId")Integer studentId);
}
