package com.vientamthuong.learning_10_1.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vientamthuong.learning_10_1.R;

public class CustomView extends LinearLayout {

    //  Khai báo các view có tác động của Custom view
    private CheckBox checkBoxSelect;
    private TextView textViewId;
    private TextView textViewInfo;
    private TextView textViewPrice;

    //  Constructor nhận vô context thôi
    public CustomView(Context context) {
        super(context);

        // Nạp activity theo context truyền vào
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        layoutInflater.inflate(R.layout.ativity_custom_view_list_view, this, true);

        //  Kết nối các view con
        textViewId = findViewById(R.id.textView_1);
        textViewInfo = findViewById(R.id.textView_2);
        textViewPrice = findViewById(R.id.textView_3);
        checkBoxSelect = findViewById(R.id.checkBox_1);
    }

    // getter and setter
    public CheckBox getCheckBoxSelect() {
        return checkBoxSelect;
    }

    public void setCheckBoxSelect(CheckBox checkBoxSelect) {
        this.checkBoxSelect = checkBoxSelect;
    }

    public TextView getTextViewId() {
        return textViewId;
    }

    public void setTextViewId(TextView textViewId) {
        this.textViewId = textViewId;
    }

    public TextView getTextViewInfo() {
        return textViewInfo;
    }

    public void setTextViewInfo(TextView textViewInfo) {
        this.textViewInfo = textViewInfo;
    }

    public TextView getTextViewPrice() {
        return textViewPrice;
    }

    public void setTextViewPrice(TextView textViewPrice) {
        this.textViewPrice = textViewPrice;
    }

}
