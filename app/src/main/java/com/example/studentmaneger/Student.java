package com.example.studentmaneger;

import java.io.Serializable;

public class Student implements Serializable {
    private String Name;
    private String Birth;
    private String ID;
    private String Number;
    private String Sex;
    private String Address;
    private String VaoDoan;

    public Student() {
    }

    public Student(String name, String birth, String ID, String number, String sex, String address, String vaoDoan) {
        Name = name;
        Birth = birth;
        this.ID = ID;
        Number = number;
        Sex = sex;
        Address = address;
        VaoDoan = vaoDoan;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        Birth = birth;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getVaoDoan() {
        return VaoDoan;
    }

    public void setVaoDoan(String vaoDoan) {
        VaoDoan = vaoDoan;
    }

    public boolean isMale(){
        if (this.Sex == "Nam")
            return true;
        else return false;
    }
}
