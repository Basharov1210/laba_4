package com.company;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Resident {
    private String Surname;
    private String Name;
    private String City;
    private String Street;
    private int HouseNum;
    private int ApartNum;

    Resident(){
        this.Surname = null;
        this.Name = null;
        this.City = null;
        this.Street = null;
        this.HouseNum = 0;
        this.ApartNum = 0;
    }

    public Resident(String Surname,String Name,String City,String Street,int HouseNum,int ApartNum) {
        this.Surname = Surname;
        this.Name = Name;
        this.City = City;
        this.Street = Street;
        this.HouseNum = HouseNum;
        this.ApartNum = ApartNum;

    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }


    public String getPar(){
        return Surname + "/" + Name + "/" + City + "/" + Street + "/" + HouseNum + "/" + ApartNum + "\n";
    }

    public String SurnameRes(String Street,int HouseNum,int ApartNum, List<Resident> res){
        for (Resident resident : res) {
            if (resident.Street == Street && resident.HouseNum == HouseNum && resident.ApartNum == ApartNum) {
                return resident.Surname;
            }
        }

        return "Такого жильца нет!";
    }

    public int FindRes(String Street,int HouseNum,int ApartNum, List<Resident> res){
        int buff = 0;
        for (Resident resident : res) {
            if (resident.Street == Street && resident.HouseNum == HouseNum && resident.ApartNum == ApartNum) {
                buff++;
            }
        }
        return buff;
    }
}
