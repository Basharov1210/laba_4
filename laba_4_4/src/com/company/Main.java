package com.company;

public class Main {

    public static void main(String[] args) {
	    ClassTextFile classTextFile = new ClassTextFile("D:\\Учеба\\ООП\\laba_4_4\\src\\com\\company\\lastTast.txt");
        ClassSeriyazableFile classSeriyazableFile = new ClassSeriyazableFile("D:\\Учеба\\ООП\\laba_4_4\\src\\com\\company\\lastTaskSeri.txt");
        classSeriyazableFile.save(classTextFile.read());
        Student student = classSeriyazableFile.load();
        student.getName();
        classSeriyazableFile.loadList();
        classSeriyazableFile.saveList();
        classSeriyazableFile.printList();
    }
}
