package com.vientamthuong.learning_10_1.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class ArrayAdapterProduct extends ArrayAdapter<Product> {

    //  Đối tượng này có một lisst product, context
    private final List<Product> products;
    private final Context context;

    public ArrayAdapterProduct(Context context, int resource, List<Product> products) {
        super(context, resource, products);
        this.products = products;
        this.context = context;
    }

    // Phải luôn luôn hiện thực lại phương thức getView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Lấy view hiện tại
        View nowView = convertView;

        //  Kiểm tra nếu null thì khởi tạo
        if (nowView == null)
            nowView = new CustomView(context);

        //  Lấy product ở vị trí postion
        Product nowProduct = products.get(position);

        //  Lấy các view con của custom view từ now View
        TextView textViewId = ((CustomView) nowView).getTextViewId();
        TextView textViewInfo = ((CustomView) nowView).getTextViewInfo();
        TextView textViewPrice = ((CustomView) nowView).getTextViewPrice();
        CheckBox checkBoxSelect = ((CustomView) nowView).getCheckBoxSelect();

        //  add action cho checkBoxSelect
        checkBoxSelect.setOnCheckedChangeListener((buttonView, isChecked) -> nowProduct.setChecked(isChecked));

        //  Gán lại các thuộc tính cho view
        textViewId.setText(nowProduct.getId());
        textViewInfo.setText(nowProduct.getInfo());
        textViewPrice.setText(nowProduct.getPrice());
        checkBoxSelect.setChecked(nowProduct.isChecked());

        //  Trả về nowView
        return nowView;

    }
}
