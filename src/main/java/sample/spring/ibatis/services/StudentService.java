package sample.spring.ibatis.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import sample.spring.ibatis.dao.CollegeDAO;
import sample.spring.ibatis.dao.StudentDAO;
import sample.spring.ibatis.model.College;
import sample.spring.ibatis.model.PageSupporter;
import sample.spring.ibatis.model.Student;

public class StudentService {

    static Logger log = Logger.getLogger(StudentService.class.getName());

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    CollegeDAO collegeDAO;

    public PageSupporter<Student> getStudentById(Integer studentId) {
        PageSupporter<Student> ps = new PageSupporter<Student>();
        ps.getMetaData().put("totalrecords", 0);
        try {
            Student student = studentDAO.getStudentById(studentId);
            if (student != null) {
                List<Student> studentList = new ArrayList<Student>();
                studentList.add(student);
                ps.setItems(studentList);
                ps.getMetaData().put("totalrecords", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ps.getMetaData().put("error", "Some error occured.");
        }
        return ps;
    }

    public PageSupporter<Student> getAllStudent(Integer pageSize,Integer pageNumber) {
        PageSupporter<Student> ps = new PageSupporter<Student>();
        try {
            List<Student> studentList = studentDAO.getAllStudent();
            if (studentList != null && studentList.size() > 0) {
                ps.setItems(studentList);
                ps.getMetaData().put("totalrecords", studentList.size());
            } else {
                ps.getMetaData().put("totalrecords", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ps.getMetaData().put("error", "Some error occured.");
        }
        return ps;
    }

    @Transactional
    public PageSupporter<Student> saveStudent(Student student) {
        PageSupporter<Student> ps = new PageSupporter<Student>();
        try {
            studentDAO.saveStudent(student);
            List<College> colleges = collegeDAO.getAllColleges();
            College college = student.getCollege();
            if (college == null || college.getId() == null || !colleges.contains(college)) {
                ps.getMetaData().put("error", "Please provide valid college.");
            }
            collegeDAO.saveStudentCollegeMapping(student.getId(), college.getId());
            List<Student> studentList = new ArrayList<Student>();
            studentList.add(student);
            ps.setItems(studentList);
            ps.getMetaData().put("totalrecords", 1);
        } catch (Exception exception) {
            exception.printStackTrace();
            ps.getMetaData().put("error", "Some error occured.");
        }
        return ps;
    }

    @Transactional
    public PageSupporter<Student> deleteStudent(Integer id) {
        PageSupporter<Student> ps = new PageSupporter<Student>();
        try {
            Student student = studentDAO.getStudentById(id);
            collegeDAO.deleteMappingByStudentId(id);
            if (student == null) {
                ps.getMetaData().put("error", "No record found");
            } else {
                studentDAO.deleteStudent(id);
                ps.getMetaData().put("success", "true");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            ps.getMetaData().put("error", "Some error occured.");
        }
        return ps;
    }

}
