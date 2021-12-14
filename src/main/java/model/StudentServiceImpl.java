package model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    List<Student> listStudents = new ArrayList<Student>();

    public Student getStudent(int id){
        for (Student lObject : listStudents) {
            if (lObject.getId() == id)
                return lObject;
        }
        return null;
    }
    public List<Student> getStudentList() {
        return listStudents;
    }

    public boolean addStudent(Student newStudent) {
        if( newStudent == null )
            return false;
        for (Student lObject : listStudents) {
            if (lObject.getId() == newStudent.getId())
                return false;
        }
        return listStudents.add(newStudent);
    }
    public boolean killStudent(int id) {
        for (Student lObject : listStudents) {
            if (lObject.getId() == id)
                return listStudents.remove(lObject);
        }
        return false;
    }
}
