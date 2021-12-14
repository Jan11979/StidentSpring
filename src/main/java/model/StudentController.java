package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

//    @Autowired // Field-Injection Finde ich Doof
    StudentServiceImpl studService;
/*
  // Constructor-Injection
    StudentController(IStudentService iStudentService) {
        studService = (StudentServiceImpl) iStudentService;
    }
*/
    @Autowired // Setter-Injection
    public void setStudentServiceImpl(IStudentService iStudentService) {
        this.studService = (StudentServiceImpl) iStudentService;
    }


    @GetMapping(path = "/all/")
    public List<Student> getStudentList() {
        return studService.getStudentList();
    }

    @GetMapping(path = "/single/{id}")
    public Student getStudent(@PathVariable int id) {
        return studService.getStudent(id);
    }

    @GetMapping(path = "/kill/{id}")
    public boolean deleteStudent(@PathVariable int id) {
        return studService.killStudent(id);
    }

    @GetMapping("/add/{id}/{name}")
    @ResponseBody
    public boolean addStudent(@PathVariable int id, @PathVariable String name) {
        return studService.addStudent(new Student( name, id ));
    }

    @PutMapping(path ="/add/")
    public boolean addStudent(@RequestBody Student studi) {
        return studService.addStudent(studi);
    }

    @PostMapping(path ="/add/")
    public boolean addStudentPost(@RequestBody Student studi) {
        return studService.addStudent(studi);
    }

}
