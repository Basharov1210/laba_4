package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ClassSeriyazableFile {
    private String path;
    private List<Student> songList = new LinkedList<>();
    ClassSeriyazableFile (String path) {
        this.path = path;
    }
    public void save (Student student) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
            objectOutputStream.close();
        } catch (IOException ex) {
            System.out.println("error 1");
        }
    }
    public Student load () {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Student st = (Student) objectInputStream.readObject();
            objectInputStream.close();
            return st;
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("error 2");
        }
        return null;
    }
    public void saveList() {
        try {
            FileWriter fileWriter = new FileWriter("D:\\Учеба\\ООП\\laba_4_4\\src\\com\\company\\lastTaskList.txt");
            for (Student student : songList) {
                fileWriter.write(student.getName()+'\n'+student.getAge()+'\n');
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("error 3");
        }
    }
    public List loadList() {
        try {
            File file = new File("D:\\Учеба\\ООП\\laba_4_4\\src\\com\\company\\lastTast.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                Student st = new Student(line,Integer.parseInt(bufferedReader.readLine()));
                songList.add(st);
            }
        } catch (IOException e) {
            System.out.println("error 4");
        }
        return songList;
    }
    public void printList() {
        for (Student student : songList) {
            System.out.println(student.getName() + " " + student.getAge());
        }
    }
}