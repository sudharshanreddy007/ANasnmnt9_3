package com.example.user.anasnmnt9_3;

/**
 * Created by USER on 27-12-2017.
 */


public  class Student { //created student cLass
    String name;
    String phone;

    public Student() {//implementing the constructors for the student class
    }

    public Student(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() { //invoking getters and setters

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }


}
