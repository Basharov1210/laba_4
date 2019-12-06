package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ClassTextFile {
    private String path;

    public ClassTextFile(String path) {
        File file = new File(path);
        if (file.isFile()) {
            this.path = path;
        } else {
            this.path = "";
        }
    }

    public Student read() {
        try {
            if (path != "") {
                File file = new File(path);
                Scanner scanner = new Scanner(file);
                String name = "";
                int age;
                name = scanner.nextLine();
                age = scanner.nextInt();
                System.out.print(name + " - ");
                System.out.println(age);
                Student student = new Student(name,age);
                scanner.close();
                return student;
            }
            return null;
        } catch (IOException e) {
            System.out.println("error 0");
        }
        return null;
    }


}
