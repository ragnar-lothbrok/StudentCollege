package sample.spring.ibatis.resource;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import sample.spring.ibatis.model.College;
import sample.spring.ibatis.model.PageSupporter;
import sample.spring.ibatis.model.Student;
import sample.spring.ibatis.services.CollegeService;

@WebService(serviceName = "collegeServices")
@Path("/college")
public class CollegeResource {

    @Autowired
    CollegeService collegeService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public PageSupporter<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/{id}")
    public PageSupporter<Student> getStudentByCollege(@PathParam("id") Integer id) {
        return collegeService.getStudentByCollegeId(id);
    }

}
