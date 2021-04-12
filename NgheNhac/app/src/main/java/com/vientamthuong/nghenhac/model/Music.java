package com.vientamthuong.nghenhac.model;

public class Music {

    private int idImage;
    private String name;
    private int idSound;
    private String time;
    private String tenCaSi;
    private boolean isSelect;

    public Music(int idImage, String name, int idSound, String time, String tenCaSi) {
        this.idImage = idImage;
        this.name = name;
        this.idSound = idSound;
        this.time = time;
        this.tenCaSi = tenCaSi;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdSound() {
        return idSound;
    }

    public void setIdSound(int idSound) {
        this.idSound = idSound;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTenCaSi() {
        return tenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        this.tenCaSi = tenCaSi;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
