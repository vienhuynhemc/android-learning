package com.vientamthuong.learning_10_1.model;

public class Product {

    //  Đối tượng product
    private String id;
    private String info;
    private String price;
    private boolean isChecked;

    public Product(String id, String info, String price, boolean isChecked) {
        this.id = id;
        this.info = info;
        this.price = price;
        this.isChecked = isChecked;
    }

    //  Getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

}
