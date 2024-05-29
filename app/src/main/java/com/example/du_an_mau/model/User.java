package com.example.du_an_mau.model;

public class User {
    private int idAdmin;
    private int name;
    private int user;
    private int pass;

    public User() {
    }

    public User(int user, int pass) {
        this.user = user;
        this.pass = pass;
    }

    public User(int idAdmin, int name, int user, int pass) {
        this.idAdmin = idAdmin;
        this.name = name;
        this.user = user;
        this.pass = pass;
    }

    public User(int name, int user, int pass) {
        this.name = name;
        this.user = user;
        this.pass = pass;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }
}