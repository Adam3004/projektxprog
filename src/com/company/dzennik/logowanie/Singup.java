package com.company.dzennik.logowanie;

import com.company.dzennik.logowanie.Serwis.Serwis;
import com.company.dzennik.logowanie.uczniowie.oceny.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Singup {
    List<User> list;


    public Singup(List<User> list) {
        this.list = list;
    }

    public User singUp(String name, String surname, String clas, String passowrd, String teacher) throws FileNotFoundException {
        File file = new File("text.txt");
        Scanner in = new Scanner(file);
        while (in.hasNext()) {
            String zdanie = in.nextLine();
            String[] tablica = new String[6];
            tablica = zdanie.split(",");
//        for (int a = 0; a < 5; a++) {
//            System.out.println(tablica[a]);
//        }
            String nametab = tablica[0];
            String surnametab = tablica[1];
            String idtabs = tablica[2];
            int idtab = Integer.parseInt(idtabs);
            String clastab = tablica[3];
            String passwordtab = tablica[4];
            String steacher = tablica[5];
            User user = new User(nametab, surnametab, idtab, clastab, passwordtab,steacher);
            list.add(user);
        }


        int id = Serwis.findLastId(list);
        User uczen1 = new User(name, surname, id, clas, passowrd, teacher);
        for (int i = 0; i < list.size(); i++) {
            String nameForList = list.get(i).getName();
            String surnameForList = list.get(i).getSurname();
            int idForList = list.get(i).getId();
            String clasForList = list.get(i).getClas();
            list.removeAll(list);
            if (name.equals(nameForList) && surname.equals(surnameForList)) {
                System.out.println("taki urzytkownik juz istnieje");
                break;
            } else {
                System.out.println("zarejestrowano " + uczen1);
                break;
            }

        }
        return uczen1;


    }


    @Override
    public String toString() {
        return "User: " + list
                ;
    }


}
