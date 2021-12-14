package model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("VZ")
//@PostMapping("post")// fügt POST Endpunkt hinzu
//@PutMapping("put") //fügt PUT Endpunkt hinzu
//@RequestBody Daten im request body
public class StudiVZ {

    List<Student> list = new ArrayList<Student>();

    StudiVZ() {
        list.add(new Student("Jan", 0));
        list.add(new Student("Peter", 1));
        list.add(new Student("Willi", 2));
        list.add(new Student("Fanny", 3));
        list.add(new Student("Lisa", 4));
    }

   /* @GetMapping
    public Student getStudent() {
        return new Student("Name");
    }*/

    @GetMapping(path = "/list/")
    public List<Student> getStudent() {
        return list;
    }

    @GetMapping(path = "/std/{id}")
    public Student getStudent(@PathVariable int id) {
        return list.get(id);

    }
    @GetMapping(path = "/add/{name}")
    public Student getStudent(@PathVariable String name) {
        Student newS = new Student(name, 99);
        list.add(newS);
        return newS;

    }

    //url?q=someName&other=value
    @GetMapping(path = "/std/")
    public String search(@RequestParam String q) {
        return "Hallo " + q;
    }

    @GetMapping("/std2/{id}/{name}")
    @ResponseBody
    public String getEmployeesByIdAndName(@PathVariable String id, @PathVariable String name) {
        return "ID: " + id + ", name: " + name;
    }

    @PutMapping("/put")
    public List<Student> getAllStudent() {
        return list;
    }

    @PostMapping(path ="/post/{name}") //Kein Parameter?
    public List<Student> getAllStudent2(String name) {
        Student newS = new Student(name, 47);
        list.add(newS);
        return list;
    }
    @PutMapping(path ="/putti") //Kein Parameter?

    public List<Student> getAddd(@RequestBody Student studi) {
    //    Student newS = new Student(name, 47);
        list.add(studi);
        return list;
    }
}




/*
    @PostMapping fügt POST Endpunkt hinzu
    @PutMapping fügt PUT Endpunkt hinzu
    @RequestBody Daten im request body

    REST Controller Post

Füge einen GET Endpunkt hinzu, der einen spezifischen Studenten zurückgibt
Füge einen PUT Endpunkt hinzu, um einen Studenten hinzuzufügen
*/
