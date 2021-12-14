package model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentControllerTest {




    @Test
    public void test_it() {

        StudentController restTemplate = new StudentController();
        restTemplate.setStudentServiceImpl( new StudentServiceImpl());

        String sollResult = "[{\"name\":\"Peter\",\"id\":2}]";
        sollResult = "[Student(name=Peter, id=2)]";


        assertTrue(restTemplate.addStudent(2, "Peter") );

        assertTrue(restTemplate.getStudent(2).getId() == 2 );
        assertTrue(restTemplate.getStudent(2).getName().equals("Peter"));

        assertTrue(restTemplate.getStudentList().toString().equals(sollResult) );


        assertTrue(restTemplate.addStudent(2, null) );
    }

    @Test
    public void test_it22() {
        StudentServiceImpl studentService = mock(StudentServiceImpl.class);

        when(studentService.getStudent(2)).thenReturn( (new Student("Some Name", 2)) );

        assertNotNull(studentService.getStudent(2));
        verify(studentService).getStudent(2);
    }



}
