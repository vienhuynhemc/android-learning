package com.vientamthuong.sqlite;

public class CongViec {

    private int id;
    private String tenCongViec;

    public CongViec(int id, String tenCongViec) {
        this.id = id;
        this.tenCongViec = tenCongViec;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }
}
