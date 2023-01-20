package com.example.cmproject.Models;

public class Registration {

    private String nom ;
    private String prenom ;
    private String login ;
    private String adresse ;
    private String password ;

    public Registration(String nom, String prenom, String login, String adresse, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.adresse = adresse;
        this.password = password;
    }

    public Registration() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
