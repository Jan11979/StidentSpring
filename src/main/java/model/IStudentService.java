package model;

import java.util.List;

public interface IStudentService {
    Student getStudent(int id);
    List<Student> getStudentList();
    boolean addStudent(Student newStudent);
    boolean killStudent(int id);
}
