package com.vientamthuong.sqlitehinhanh;

public class DoVat {
    private String name;
    private String mota;
    private byte[] hinh;

    public DoVat(String name, String mota, byte[] hinh) {
        this.name = name;
        this.mota = mota;
        this.hinh = hinh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public byte[] getHinh() {
        return hinh;
    }

    public void setHinh(byte[] hinh) {
        this.hinh = hinh;
    }
}
