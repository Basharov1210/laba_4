package com.company;

public class Student {
    private String name;
    private int age;

    Student () {
        this.name = "no_name";
        this.age = 0;
    }

    Student (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
