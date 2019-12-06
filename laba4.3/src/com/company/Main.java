package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("0 - Выход\n1 - Упр.1\n2 - Упр.2\n3 - Упр.3");
        while (true) {
            System.out.print("Выберете задание: ");
            int option = in.nextInt();
            switch (option) {
                case 0:
                    return;
                case 1:
                    quest1();
                    break;
                case 2:
                    quest2();
                    break;
                case 3:
                    quest3();
                    break;
                default:
                    System.out.println("Неверный ввод!");
            }
        }
    }

    public static void quest1() {
        try {
            FileReader inputFirstStream = null;
            FileWriter outputSecondStream = null;
            inputFirstStream = new FileReader("D:\\Учеба\\ООП\\laba4.3\\src\\com\\company\\T1.txt");
            outputSecondStream = new FileWriter("D:\\Учеба\\ООП\\laba4.3\\src\\com\\company\\T2.txt");
            int c;
            while ((c = inputFirstStream.read()) != -1) {
                outputSecondStream.write(c);
            }
            inputFirstStream.close();
            outputSecondStream.close();
            System.out.println("Все работает!");
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public static void quest2() {
        try {

            FileWriter outputStream = null;
            outputStream = new FileWriter("A.txt");
            for (int i = 0; i < 512; i++) {
                outputStream.write(55);
            }
            outputStream.close();
            BufferedReader inb = new BufferedReader(new FileReader("A.txt"), 128);
            BufferedWriter outb = new BufferedWriter(new FileWriter("B.txt"), 128);
            char[] buf = new char[128];
            int x;
            while ((x = inb.read(buf)) != -1) {
                outb.write(buf);
                outb.write(10);
            }
            inb.close();
            outb.close();
            System.out.println("Все работает!");
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public static void quest3() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader
                    (new FileInputStream("D:\\Учеба\\ООП\\laba4.3\\src\\com\\company\\AA.txt"), "UTF-8"));
            BufferedReader iN = new BufferedReader(new InputStreamReader
                    (new FileInputStream("D:\\Учеба\\ООП\\laba4.3\\src\\com\\company\\AA.txt"), "Cp1251"));
            System.out.println("Набор символов по умолчанию: " + Charset.defaultCharset().name());
            String temp;
            System.out.println("Чтение AA.txt с UTF-8:");
            while ((temp = in.readLine()) != null) {
                System.out.println(temp);
            }
            System.out.println("Чтение AA.txt с Cp1251:");
            while ((temp = iN.readLine()) != null) {
                System.out.println(temp);
            }
            iN.close();
            in.close();
            System.out.println("Все работает!");
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }
}