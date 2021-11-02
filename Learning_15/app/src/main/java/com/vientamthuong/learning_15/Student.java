package com.vientamthuong.learning_15;

public class Student {

    private String tenSinhVien;
    private String maSoSinhVien;
    private boolean isChecked;

    public Student(String tenSinhVien, String maSoSinhVien, boolean isChecked) {
        this.tenSinhVien = tenSinhVien;
        this.maSoSinhVien = maSoSinhVien;
        this.isChecked = isChecked;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getMaSoSinhVien() {
        return maSoSinhVien;
    }

    public void setMaSoSinhVien(String maSoSinhVien) {
        this.maSoSinhVien = maSoSinhVien;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

}
