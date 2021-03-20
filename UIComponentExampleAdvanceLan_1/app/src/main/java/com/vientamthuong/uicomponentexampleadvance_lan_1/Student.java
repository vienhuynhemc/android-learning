package com.vientamthuong.uicomponentexampleadvance_lan_1;

public class Student {

    private String name;
    private String soDienThoai;
    private int iconPerson;
    private int iconPhone;

    public Student(String name, String soDienThoai, int iconPerson, int iconPhone) {
        this.name = name;
        this.soDienThoai = soDienThoai;
        this.iconPerson = iconPerson;
        this.iconPhone = iconPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getIconPerson() {
        return iconPerson;
    }

    public void setIconPerson(int iconPerson) {
        this.iconPerson = iconPerson;
    }

    public int getIconPhone() {
        return iconPhone;
    }

    public void setIconPhone(int iconPhone) {
        this.iconPhone = iconPhone;
    }
}
