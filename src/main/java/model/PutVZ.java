package model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;


@RestController
public class PutVZ {
    List<Student> list = new ArrayList<Student>();

    PutVZ() {
        list.add(new Student("Jan", 0));
        list.add(new Student("Peter", 1));
        list.add(new Student("Willi", 2));
        list.add(new Student("Fanny", 3));
        list.add(new Student("Lisa", 4));
    }

    @PutMapping("/put")
    public List<Student> getAllStudent() {
        return list;
    }

}
