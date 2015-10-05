package sample.spring.ibatis.resource;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import sample.spring.ibatis.model.Student;
import sample.spring.ibatis.model.PageSupporter;
import sample.spring.ibatis.services.StudentService;

@WebService(serviceName = "studentServices")
@Path("/student")
public class StudentResource {

    @Autowired
    StudentService studentService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/{id}")
    public PageSupporter<Student> getStudent(@PathParam("id") Integer id) {
        return studentService.getStudentById(id);
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public PageSupporter<Student> getAllStudents(@Param("pageSize")Integer pageSize,@Param("pageNumber")Integer pageNumber) {
        return studentService.getAllStudent(pageSize,pageNumber);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON })
    public PageSupporter<Student> saveStudent(Student student) {
        return studentService.saveStudent(student);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/{id}")
    public PageSupporter<Student> deleteStudent(@PathParam("id") Integer id) {
        return studentService.deleteStudent(id);
    }

}
