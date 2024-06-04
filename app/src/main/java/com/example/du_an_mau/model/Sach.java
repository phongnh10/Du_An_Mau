package com.example.du_an_mau.model;



public class Sach {
    private int idSach;
    private String tenSach;
    private String tacGia;
    private String theLoai;
    private String nhaXuatBan;
    private String namXuatBan;
    private int soLuong;

    public Sach(int anInt, String string, String cursorString, String theLoai, String nhaXuatBan, int cursorInt, String s) {
    }

    public Sach(String tenSach, String tacGia, String theLoai, String nhaXuatBan, String namXuatBan, int soLuong) {
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

    public Sach(int idSach, String tenSach, String tacGia, String theLoai, String nhaXuatBan, String namXuatBan, int soLuong) {
        this.idSach = idSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;

    }

    public Sach(int idSach, String tenSach, String tacGia) {
        this.idSach = idSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
    }

    public Sach(int idSach, String tenSach, String theLoai, int soLuong, String tacGia) {
        this.idSach = idSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.soLuong = soLuong;
        this.tacGia = tacGia;
    }


    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(String namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
