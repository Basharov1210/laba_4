package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static LinkedList<Resident> res = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("0 - Выход\n1 - Ввод\n2 - Вывод\n3 - RandomAccess");
            System.out.print("Что вы хотите выполнить? - ");
            int choice = in.nextInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    input();
                    break;
                case 2:
                    output();
                    break;
                case 3:
                    randomAccess();
                    break;
                default:
                    System.out.println("Число введено неправильно!");
            }
        }
    }

    public static void input() {
        try {
            String inform = "";
            Scanner in = new Scanner(System.in);
            System.out.print("Сколько жителей вы хотите добавить? - ");
            int ResCount = 0 + in.nextInt();
            for (; ResCount > 0; ResCount--) {
                in.nextLine();
                System.out.print("Фамилия: ");
                String Surname = "" + in.nextLine();
                System.out.print("Имя: ");
                String Name = "" + in.nextLine();
                System.out.print("Город: ");
                String City = "" + in.nextLine();
                System.out.print("Улица: ");
                String Street = "" + in.nextLine();
                System.out.print("Номер дома: ");
                int HouseNum = 0 + in.nextInt();
                if (HouseNum > 100 || HouseNum < 1) {
                    System.out.println("Неверное число!");
                    return;
                }
                System.out.print("Номер квартиры: ");
                int ApartNum = 0 + in.nextInt();
                if (ApartNum > 1000 || ApartNum < 1) {
                    System.out.println("Неверное число!");
                    return;
                }

                inform += Surname + "/" + Name + "/" + City + "/" + Street + "/" + HouseNum + "/" + ApartNum + "\n";
            }
            char[] inform_ch = inform.toCharArray();
            FileOutputStream outStream = new FileOutputStream(inFile());
            for (char ch : inform_ch) {
                outStream.write(ch);
            }
            outStream.close();
        } catch (IOException ex) {
            ex.getMessage();
        } catch (Exception e) {
            System.out.println("Input Error!");
        }
    }

    public static File inFile() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите имя файла: ");
            String name = in.nextLine();
            File input = new File(name + ".txt");
            if (input.exists()) {
                System.out.println("Файл существует");
            }
            if (input.createNewFile()) {
                System.out.println("Успешно создан!");
            }
            return input;
        } catch (IOException ex) {
            System.out.print("Неправильное имя,не используйте данные значения: \\ | / * : < > ? \" ");
        }
        return null;
    }

    public static void output() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Имя города: ");
            String cy = in.nextLine();
            FileInputStream inputStream = new FileInputStream(inFile());
            String inf = "";
            int c;
            System.out.println("Проживающих в городе " + cy + ":");
            while ((c = inputStream.read()) != -1) {
                if (c == '\n') {
                    String[] cy_arr = inf.split("/");
                    if (cy_arr[2].equals(cy)) {
                        System.out.printf("Фамилия - %s, Имя - %s, Город - %s, Улица - %s, Дом - %s, Кваритра - %s\n",
                                cy_arr[0],cy_arr[1], cy_arr[2],cy_arr[3],cy_arr[4],cy_arr[5]);
                        Resident resident = new Resident(cy_arr[0],cy_arr[1], cy_arr[2],
                                cy_arr[3], Integer.parseInt(cy_arr[4]),
                                Integer.parseInt(cy_arr[5]));
                        res.add(resident);
                    }
                    inf = "";
                } else {
                    inf += (char) c;
                }
            }
            inputStream.close();

        } catch (IOException ex) {
            ex.getMessage();
        }
    }
    public static void randomAccess() throws IOException {
        Scanner b = new Scanner(System.in);
        RandomAccessFile randomAccessFile = new RandomAccessFile("randAccess.txt", "rw");
        String inf = "";
        for (Resident resident : res) {
            inf = resident.getPar();
            randomAccessFile.writeBytes(inf);
        }
        while ((inf = randomAccessFile.readLine()) != null) {
            int count = 0;
            String[] a = inf.split("/");
            System.out.print("Введите номер дома и квартиры человека которого хотети удалить: ");
            int house = b.nextInt();
            System.out.print(" ");
            int room = b.nextInt();
            if (Integer.parseInt(a[4]) == house && Integer.parseInt(a[5])==room){
                count++;
                randomAccessFile.seek(inf.getBytes().length*count - (a[3].getBytes().length));
                Resident resident = new Resident(a[0],a[1], a[2],
                        a[3], Integer.parseInt(a[4]), Integer.parseInt(a[5]));
                randomAccessFile.writeBytes(String.valueOf(resident));
            }

        }
    }
}
