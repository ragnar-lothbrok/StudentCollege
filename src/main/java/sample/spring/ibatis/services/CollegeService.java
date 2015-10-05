package sample.spring.ibatis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sample.spring.ibatis.dao.CollegeDAO;
import sample.spring.ibatis.model.College;
import sample.spring.ibatis.model.PageSupporter;
import sample.spring.ibatis.model.Student;

public class CollegeService {

    @Autowired
    CollegeDAO collegeDAO;

    public PageSupporter<College> getAllColleges() {

        List<College> collegesList = collegeDAO.getAllColleges();
        PageSupporter<College> ps = new PageSupporter<College>();
        ps.setItems(collegesList);
        ps.getMetaData().put("totalRecords", collegesList.size());
        return ps;
    }

    public PageSupporter<Student> getStudentByCollegeId(Integer id) {
        List<Student> studentList = collegeDAO.getStudentByCollegeId(id);
        PageSupporter<Student> ps = new PageSupporter<Student>();
        ps.setItems(studentList);
        ps.getMetaData().put("totalRecords", (studentList == null ? 0 : studentList.size()));
        return ps;
    }

}
