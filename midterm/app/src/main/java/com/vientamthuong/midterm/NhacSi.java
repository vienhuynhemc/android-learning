package com.vientamthuong.midterm;

public class NhacSi {

    private String ma_nhac_si;
    private String ten_nhac_si;
    private int id;

    public NhacSi(String ma_nhac_si, String ten_nhac_si, int id) {
        this.ma_nhac_si = ma_nhac_si;
        this.ten_nhac_si = ten_nhac_si;
        this.id = id;
    }

    public String getMa_nhac_si() {
        return ma_nhac_si;
    }

    public void setMa_nhac_si(String ma_nhac_si) {
        this.ma_nhac_si = ma_nhac_si;
    }

    public String getTen_nhac_si() {
        return ten_nhac_si;
    }

    public void setTen_nhac_si(String ten_nhac_si) {
        this.ten_nhac_si = ten_nhac_si;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
