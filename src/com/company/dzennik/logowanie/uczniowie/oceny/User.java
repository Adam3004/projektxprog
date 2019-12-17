package com.company.dzennik.logowanie.uczniowie.oceny;

public class User {
    String name;
    String surname;
    String clas;
    String password;
    int id;
    static int nextfreeid = 1;

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    String teacher;


    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String name, String surname, int id, String clas, String password, String teacher) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.clas = clas;
        this.password = password;
        nextfreeid++;
        this.teacher=teacher;
    }

    @Override
    public String toString() {
        return name + "," +
                surname + "," +
                id + "," + clas;
    }
}
