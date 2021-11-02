package com.vientamthuong.learning_3_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomViewWork extends LinearLayout {

    //  Kết nối với custom view work
    private CheckBox checkBoxSelect;
    private TextView textViewTenCongViec;
    private TextView textViewThoiGianCongViec;

    public CustomViewWork(Context context) {
        super(context);

        //  Dùng layoutInfalter kết nối với active
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        layoutInflater.inflate(R.layout.custom_view_work, this, true);

        //  Kết nối xong rồi thì lấy theo id tương ứng
        checkBoxSelect = findViewById(R.id.checkBox_1);
        textViewTenCongViec = findViewById(R.id.textView_1);
        textViewThoiGianCongViec = findViewById(R.id.textView_2);
    }

    public CheckBox getCheckBoxSelect() {
        return checkBoxSelect;
    }

    public TextView getTextViewTenCongViec() {
        return textViewTenCongViec;
    }

    public TextView getTextViewThoiGianCongViec() {
        return textViewThoiGianCongViec;
    }

}
