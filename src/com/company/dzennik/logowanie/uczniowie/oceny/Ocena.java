package com.company.dzennik.logowanie.uczniowie.oceny;

public class Ocena {
    private String przedmiot;
    private String nauczyciel;
    private String imieu;
    private String nazwiskou;
    private String klasa;
    private int ocena;

    public String getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(String przedmiot) {
        this.przedmiot = przedmiot;
    }

    public String getNauczyciel() {
        return nauczyciel;
    }

    public void setNauczyciel(String nauczyciel) {
        this.nauczyciel = nauczyciel;
    }

    public String getImieu() {
        return imieu;
    }

    public void setImieu(String imieu) {
        this.imieu = imieu;
    }

    public String getNazwiskou() {
        return nazwiskou;
    }

    public void setNazwiskou(String nazwiskou) {
        this.nazwiskou = nazwiskou;
    }

    public String getKlasa() {
        return klasa;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Ocena(String przedmiot, String nauczyciel, String imieu, String nazwiskou, String klasa, int ocena) {
        this.przedmiot = przedmiot;
        this.nauczyciel = nauczyciel;
        this.imieu = imieu;
        this.nazwiskou = nazwiskou;
        this.klasa = klasa;
        this.ocena = ocena;
    }
}
