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


        assertFalse(restTemplate.addStudent(2, "Peter") );
    }

    @Test
    public void test_Mokki() {
        StudentServiceImpl studentService = mock(StudentServiceImpl.class);

        when(studentService.getStudent(2)).thenReturn( (new Student("SomeName", 2)) );

        when(studentService.addStudent(new Student("SomeName", 2))).thenReturn(true);
        when(studentService.addStudent(new Student(null, 7))).thenReturn(true);

        when(studentService.killStudent(2)).thenReturn(true);
        when(studentService.killStudent(99)).thenReturn(false);

        StudentController studCon = new StudentController();
        studCon.setStudentServiceImpl(studentService);

        assertTrue( studCon.getStudent(2).getName().equals("SomeName"));
        assertTrue( studCon.getStudent(1) == null);
        assertTrue( studCon.addStudent(2, "SomeName"));
        assertTrue( studCon.addStudent(7, "NoName"));
        assertTrue( studCon.deleteStudent(2 ));
        assertFalse( studCon.deleteStudent(99 ));


        //verify(studentService).getStudent(2);
    }



}
