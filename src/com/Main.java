package com;

import com.company.dzennik.logowanie.Login;
import com.company.dzennik.logowanie.Singup;
import com.company.dzennik.logowanie.uczniowie.oceny.Dodajocene;
import com.company.dzennik.logowanie.uczniowie.oceny.Ocena;
import com.company.dzennik.logowanie.uczniowie.oceny.User;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        List<User> list1 = new ArrayList<>();
        System.out.println("Witaj w twoim e-dzienniku");
        System.out.println("Co chcesz zrobic?: ");
        System.out.println("-Singup" + '\n' + "-Login");

        String teachertn = "n";
        petla:
        while (true) {
            String order = sc.nextLine();
            switch (order) {
                case "Singup":
                    teachertn = "n";
                    System.out.println("jestes nauczycielem czy uczniem?: ");
                    String teacher = sc.nextLine();
                    if (teacher.equals("nauczyciel") || teacher.equals("nauczycielem")) {
                        teachertn = "t";
                    } else if (teacher.equals("uczen") || teacher.equals("uczniem")) {
                        teachertn = "n";
                    } else {
                        System.out.println("bład");
                        System.out.println("Wpisz co chcesz zrobic: ");
                        break;
                    }
                    System.out.println("podaj imie: ");
                    String name = sc.nextLine();

                    System.out.println("podaj nazwisko: ");
                    String surname = sc.nextLine();

                    System.out.println("podaj swoją klase: ");
                    String clas = sc.nextLine();

                    System.out.println("Podaj haslo: ");
                    String passowrd = sc.nextLine();

                    Singup uczen1 = new Singup(list1);
                    User user = uczen1.singUp(name, surname, clas, passowrd, teachertn);
                    list1.add(user);
                    System.out.println("Wpisz co chcesz zrobic: ");
                    break;
                case "Login":
                    teachertn = "n";
                    System.out.println("jestes nauczycielem czy uczniem?: ");
                    String teacherlog = sc.nextLine();
                    if (teacherlog.equals("nauczyciel") || teacherlog.equals("nauczycielem")) {
                        teachertn = "t";
                    } else if (teacherlog.equals("uczen") || teacherlog.equals("uczniem")) {
                        teachertn = "n";
                    } else {
                        System.out.println("bład");
                        System.out.println("Wpisz co chcesz zrobic: ");
                        break;
                    }
                    System.out.println("podaj imie: ");
                    String nameLog = sc.nextLine();

                    System.out.println("podaj nazwisko: ");
                    String surnameLog = sc.nextLine();

                    System.out.println("Podaj haslo: ");
                    String passowrdLog = sc.nextLine();


                    Login uczen = new Login();
                    User user1 = uczen.login(nameLog, surnameLog, passowrdLog);
                    if (uczen.zalogowano == true) {
                        System.out.println(user1.getName() + " " + user1.getSurname() + " " + user1.getClas());
                        break petla;
                    } else {

                        System.out.println("Wpisz co chcesz zrobic: ");

                        break;
                    }
                case "Quit":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Błędne polecenie");
                    System.out.println("Wpisz co chcesz zrobic: ");
                    break;
            }
            saveuser(list1);
        }
//        Menu
        List<Ocena> listaocen = new ArrayList<>();
        System.out.println("Menu");
        System.out.println("Co chcesz zrobic?: ");
        if (teachertn.equals("t")) {
//            dodatkowe mozliwosci

            while (true) {
                String komenta = sc.nextLine();
                switch (komenta) {
                    case "Dodaj ocene":
                        System.out.println("Przedmiot: ");
                        String przedmiotl = sc.nextLine();
                        System.out.println("Imie i nazwisko nauczyciela:");
                        String nauczyciell = sc.nextLine();
                        System.out.println("Imię ucznia: ");
                        String imiel = sc.nextLine();
                        System.out.println("Nazwisko ucznia: ");
                        String nazwiskol = sc.nextLine();
                        System.out.println("Klasa: ");
                        String klasal = sc.nextLine();
                        System.out.println("Jaka ocena?: ");
                        int ocenal = sc.nextInt();
                        Dodajocene ocena = new Dodajocene(listaocen);
                        Ocena ocenka = ocena.DodajOcene(przedmiotl, nauczyciell, imiel, nazwiskol, klasal, ocenal);
                        listaocen.add(ocenka);
                        System.out.println(listaocen);
                        break;
                    case "Wyloguj":
                        System.out.println("Zosałeś wylogowany");
                        System.exit(0);
                        break;
                }
                saveocena(listaocen);

            }
        }

    }

    public static void saveuser(List<User> list) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter(new FileOutputStream("text.txt", true));
        for (User user : list) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(user.getName());
            stringBuilder.append(",");
            stringBuilder.append(user.getSurname());
            stringBuilder.append(",");
            stringBuilder.append(user.getId());
            stringBuilder.append(",");
            stringBuilder.append(user.getClas());
            stringBuilder.append(",");
            stringBuilder.append(user.getPassword());
            stringBuilder.append(",");
            stringBuilder.append(user.getTeacher());
            zapis.println(stringBuilder.toString());
            zapis.flush();
        }
        zapis.close();
    }
    public static void saveocena(List<Ocena> list) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter(new FileOutputStream("oceny.txt", true));
        for (Ocena ocena : list) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ocena.getPrzedmiot());
            stringBuilder.append(",");
            stringBuilder.append(ocena.getNauczyciel());
            stringBuilder.append(",");
            stringBuilder.append(ocena.getImieu());
            stringBuilder.append(",");
            stringBuilder.append(ocena.getNazwiskou());
            stringBuilder.append(",");
            stringBuilder.append(ocena.getKlasa());
            stringBuilder.append(",");
            stringBuilder.append(ocena.getOcena());
            zapis.println(stringBuilder.toString());
            zapis.flush();
        }
        zapis.close();
    }
}
