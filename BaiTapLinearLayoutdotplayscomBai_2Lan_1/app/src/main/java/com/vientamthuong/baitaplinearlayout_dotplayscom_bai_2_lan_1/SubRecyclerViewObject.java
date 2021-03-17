package com.vientamthuong.baitaplinearlayout_dotplayscom_bai_2_lan_1;

public class SubRecyclerViewObject {

    //  Khai báo các biến
    private String name;
    private String price;
    private int resourceImg;

    public SubRecyclerViewObject(String name, String price, int resourceImg) {
        this.name = name;
        this.price = price;
        this.resourceImg = resourceImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getResourceImg() {
        return resourceImg;
    }

    public void setResourceImg(int resourceImg) {
        this.resourceImg = resourceImg;
    }

}
