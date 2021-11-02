package com.vientamthuong.learning_3_1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomViewWorkAdapter extends ArrayAdapter<Work> {

    //  Các tham số của arrayAapter
    private Context context;
    private int resource;
    private List<Work> listCongViec;

    public CustomViewWorkAdapter(Context context, int resource, List<Work> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listCongViec = objects;
    }

    // luôn luôn hiện thực phương thức này
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //  Lấy view hiện tại ra
        View nowView = convertView;

        //  Kiểm tra nếu nowView = null thì khởi tạo nó
        if (nowView == null)
            nowView = new CustomViewWork(context);

        // lấy work ở vị trí position ra. nếu work != null thì làm tiếp
        Work nowWork = listCongViec.get(position);
        if (nowWork != null) {

            //  Lấy các đối tượng từ nowView ra
            CheckBox checkBoxSelect = ((CustomViewWork) nowView).getCheckBoxSelect();
            TextView textViewCongViec = ((CustomViewWork) nowView).getTextViewTenCongViec();
            TextView textViewThoiGianCongViec = ((CustomViewWork) nowView).getTextViewThoiGianCongViec();

            // set action cho checkBoxSelect
            checkBoxSelect.setOnCheckedChangeListener((buttonView, isChecked) -> nowWork.setSelect(isChecked));

            //  Cập nhật lại cho các view
            checkBoxSelect.setChecked(nowWork.isSelect());
            textViewCongViec.setText(nowWork.getTenCongViec());
            textViewThoiGianCongViec.setText(nowWork.getThoiGianCongViec());
        }

        return nowView;
    }

}
