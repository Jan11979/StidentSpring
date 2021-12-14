package model;

import lombok.Data;

@Data
public class Student {
    String name;
    int id;

    Student(String sNew, int id) {
        if(sNew == null)
            this.name = "NoName";
        else
            this.name = sNew;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
