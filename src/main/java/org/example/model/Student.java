package org.example.model;

public class Student {
    private static int count = 0;
    private int id;
    private String name;

    public Student() {
        count++;
    }

    public Student(String name) {
        count++;
        this.id = count;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
