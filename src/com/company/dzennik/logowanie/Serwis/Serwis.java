package com.company.dzennik.logowanie.Serwis;

import com.company.dzennik.logowanie.uczniowie.oceny.User;

import java.util.List;

public class Serwis {
    public static int findLastId(List<User> lista) {
        int max = 0;
        for (User user : lista) {
            if (user.getId() > max) {
                max = user.getId();

            }
        }
        return max + 1;
    }
}
