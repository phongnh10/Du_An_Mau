package com.example.du_an_mau.model;

public class PhieuMuon {
    private int idPhieuMuon;
    private String nguoiMuon;
    private String soDienThoai;
    private String sachMuon;
    private String ngayMuon;
    private String ngayTra;
    private String ghiChu;

    private String trangThai;

    public PhieuMuon() {
    }

//    tenNguoiMuon, soDienThoai, sachMuon, ngayMuon, ngayTra, ghiChu,trangThai


    public PhieuMuon(String nguoiMuon, String soDienThoai, String sachMuon, String ngayMuon, String ngayTra, String ghiChu, String trangThai) {
        this.nguoiMuon = nguoiMuon;
        this.soDienThoai = soDienThoai;
        this.sachMuon = sachMuon;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public PhieuMuon(int idPhieuMuon, String nguoiMuon, String soDienThoai, String sachMuon, String ngayMuon, String ngayTra, String ghiChu, String trangThai) {
        this.idPhieuMuon = idPhieuMuon;
        this.nguoiMuon = nguoiMuon;
        this.soDienThoai = soDienThoai;
        this.sachMuon = sachMuon;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public int getIdPhieuMuon() {
        return idPhieuMuon;
    }

    public void setIdPhieuMuon(int idPhieuMuon) {
        this.idPhieuMuon = idPhieuMuon;
    }

    public String getNguoiMuon() {
        return nguoiMuon;
    }

    public void setNguoiMuon(String nguoiMuon) {
        this.nguoiMuon = nguoiMuon;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getSachMuon() {
        return sachMuon;
    }

    public void setSachMuon(String sachMuon) {
        this.sachMuon = sachMuon;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}