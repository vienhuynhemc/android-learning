package com.vientamthuong.baitaplinearlayout_dotplayscom_bai_2_lan_1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SubRecyclerViewViewHoler extends RecyclerView.ViewHolder {

    // Khai báo variable
    private TextView logo;
    private TextView name;
    private TextView price;

    public SubRecyclerViewViewHoler(@NonNull View itemView) {
        super(itemView);

        //  nhận vô view group, tìm lại các varialbe
        getView(itemView);

    }

    private void getView(View view) {
        logo = view.findViewById(R.id.logo);
        name = view.findViewById(R.id.name);
        price = view.findViewById(R.id.price);
    }

    // getter and setter
    public TextView getLogo() {
        return logo;
    }

    public void setLogo(TextView logo) {
        this.logo = logo;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getPrice() {
        return price;
    }

    public void setPrice(TextView price) {
        this.price = price;
    }

}
