package com.company.dzennik.logowanie.uczniowie.oceny;

import java.util.List;

public class Dodajocene {
    List<Ocena> listaocen;

    public Dodajocene(List<Ocena> listaocen) {
        this.listaocen = listaocen;
    }

    public Ocena DodajOcene(String przedmiot, String nauczyciel, String imieu, String nazwiskou, String klasa, int ocena) {
        Ocena ocena1 = new Ocena(przedmiot,nauczyciel,imieu,nazwiskou,klasa,ocena);
        listaocen.add(ocena1);
        return ocena1;
    }

}
