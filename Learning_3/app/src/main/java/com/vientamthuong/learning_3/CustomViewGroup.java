package com.vientamthuong.learning_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomViewGroup extends LinearLayout {

    //  Như ở list layout, bao gồm 1 checkBox và 2 textView
    private CheckBox checkBox;
    private TextView textViewNoiDungCongViec;
    private TextView textViewThoiGianCongViec;

    public CustomViewGroup(Context context) {
        super(context);

        //  Sử dụng layoutInflater để gán giao diện ở list.xml cho class này
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        layoutInflater.inflate(R.layout.list, this, true);

        //  Lấy các view về tương ứng
        checkBox = findViewById(R.id.check_congViec);
        textViewNoiDungCongViec = findViewById(R.id.noiDungCongViec);
        textViewThoiGianCongViec = findViewById(R.id.thoiGianCongViec);

    }

    // Getter and setter
    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public TextView getTextViewNoiDungCongViec() {
        return textViewNoiDungCongViec;
    }

    public void setTextViewNoiDungCongViec(TextView textViewNoiDungCongViec) {
        this.textViewNoiDungCongViec = textViewNoiDungCongViec;
    }

    public TextView getTextViewThoiGianCongViec() {
        return textViewThoiGianCongViec;
    }

    public void setTextViewThoiGianCongViec(TextView textViewThoiGianCongViec) {
        this.textViewThoiGianCongViec = textViewThoiGianCongViec;
    }

}
