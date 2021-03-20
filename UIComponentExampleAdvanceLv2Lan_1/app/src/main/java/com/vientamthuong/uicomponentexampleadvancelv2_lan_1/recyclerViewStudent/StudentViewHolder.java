package com.vientamthuong.uicomponentexampleadvancelv2_lan_1.recyclerViewStudent;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.uicomponentexampleadvancelv2_lan_1.R;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    // Khai báo các thuộc tính
    private TextView tvTen;
    private TextView tvPhone;
    private Button btRemove;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);

        // Lấy view từ itemView
        getViewFromItemView(itemView);
    }

    private void getViewFromItemView(View itemView) {
        tvTen = itemView.findViewById(R.id.custom_recyclerViewStudent_textView_1);
        tvPhone = itemView.findViewById(R.id.custom_recyclerViewStudent_textView_2);
        btRemove = itemView.findViewById(R.id.custom_recyclerViewStudent_button_1);
    }

    // getter and setter
    public TextView getTvTen() {
        return tvTen;
    }

    public void setTvTen(TextView tvTen) {
        this.tvTen = tvTen;
    }

    public TextView getTvPhone() {
        return tvPhone;
    }

    public void setTvPhone(TextView tvPhone) {
        this.tvPhone = tvPhone;
    }

    public Button getBtRemove() {
        return btRemove;
    }

    public void setBtRemove(Button btRemove) {
        this.btRemove = btRemove;
    }
}
