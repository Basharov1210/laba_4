package com.company;
import java.io.IOException;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        try {
            // Упражнение 1

            File mf1 = new File("D:\\Учеба\\ООП\\laba_4\\src\\com\\company\\MyFile1.txt");
            mf1.createNewFile();
            mf1.deleteOnExit();
            boolean exist1 = mf1.exists();
            if (exist1) {
                System.out.println("MyFile1.txt существует");
            }

            File mf2 = new File("D:\\MyFile2.txt");
            mf2.createNewFile();
            mf2.deleteOnExit();
            boolean exist2 = mf2.exists();
            if (exist2) {
                System.out.println("MyFile2.txt существует");
            }

            File mf3 = new File("D:\\Учеба\\ООП\\laba_4\\src\\com");
            mf3.createNewFile();
            mf3.deleteOnExit();
            boolean exist3 = mf3.exists();
            if (exist3) {
                System.out.println("MyFile3.txt существует");
            }

            File dir = new File("D:\\Учеба\\ООП");
            dir.mkdirs();
            boolean exist4 = dir.exists();
            if (exist4) {
                System.out.println("Папка существует");
            }

            // Упражнение 2
            if (mf1.isFile()) {
                System.out.println(mf1.getName() + " в " + mf1.getAbsolutePath().substring(0,mf1.getAbsolutePath().lastIndexOf('\\')));
            }

            if (dir.isDirectory()) {
                System.out.println(dir.getName());
            }

            if (exist1) {
                System.out.println("MyFile1.txt существует");
            }

            System.out.println(dir.getAbsolutePath());
            System.out.println("Размер " + mf3.getName() + " - " + mf3.length() + " байт"); // файл

            // Упражнение 3
            File myFile5 = new File("D:\\Учеба\\ООП\\laba_4\\src");
            myFile5.mkdir();
            myFile5.deleteOnExit();
            System.out.println("Содержимое папки " + myFile5.getParentFile().getName() + ":");
            for (String file: myFile5.getParentFile().list()) {
                System.out.println(file);
            }

            int directorys = 0;
            for (File file: myFile5.getParentFile().listFiles()) {
                if (file.isDirectory()) {directorys++;}
            }

            System.out.println("Количество директорий: " + directorys);

            File myFile7 = new File("D:\\Учеба\\ООП\\laba_4\\src\\papka\\papka2");
            File myFile8 = new File("D:\\Учеба\\ООП\\laba_4\\src\\papka");
            dir.delete();
            myFile7.delete();
            myFile8.delete();

        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
}







