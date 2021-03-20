package com.vientamthuong.uicomponentexampleadvance_lan_1;

import java.util.ArrayList;
import java.util.List;

public class RegisterObject {

    private String hoVaTen;
    private String dienThoai;
    private String email;
    private String diaChi;
    private Date ngaySinh;
    private boolean isNam;
    private List<String> dsKhoaHoc;
    private List<Student> lsNhom;

    public RegisterObject() {
        dsKhoaHoc = new ArrayList<>();
        lsNhom = new ArrayList<>();
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isNam() {
        return isNam;
    }

    public void setNam(boolean nam) {
        isNam = nam;
    }

    public List<String> getDsKhoaHoc() {
        return dsKhoaHoc;
    }

    public void setDsKhoaHoc(List<String> dsKhoaHoc) {
        this.dsKhoaHoc = dsKhoaHoc;
    }

    public List<Student> getLsNhom() {
        return lsNhom;
    }

    public void setLsNhom(List<Student> lsNhom) {
        this.lsNhom = lsNhom;
    }
}

