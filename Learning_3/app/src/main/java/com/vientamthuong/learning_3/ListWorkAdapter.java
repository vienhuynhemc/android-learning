package com.vientamthuong.learning_3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListWorkAdapter extends ArrayAdapter<Work> {

    /*
     * Khi kế thừa arrayAdapter thì phải có 1 list, 1 context và 1 resource
     *
     * Vì sử dụng Custum view group nên đành phải kế thừa mà tự viết
     *
     * Nếu chỉ hiển thị chuỗi string bình thường thì khau báo arrayAdapter sài luôn
     * (ArrayAdapter a = new ArrayAdapter(this,android.R.layout.simple_test_1,listCongViec))
     */
    private List<Work> listCongViec;
    private Context context;
    private int resource;

    public ListWorkAdapter(Context context, int resource, List<Work> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listCongViec = objects;
    }

    //  Đây là phương thức xác định view mà adapter sẽ hiển thị, ở đây chính là CustomViewGroup
    //  Bắt buộc phải Override khi kế thừa từ arrayAdapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //  Lấy ra một view hiên tại trong arrayAdapter
        View viewCongViec = convertView;

        //  Kiểm tra nếu null thì khởi tạo là 1 customViewGroup
        if (viewCongViec == null)
            viewCongViec = new CustomViewGroup(context);

        //  Lấy về đối tượng work hiện tại
        Work work = listCongViec.get(position);

        //  Kiểm tra xem work có khác null thì mới làm tiếp
        if (work != null) {

            //  Nếu work khác null thì lấy các đối tượng từ view hiện tại
            CheckBox checkBoxCongViec = ((CustomViewGroup) viewCongViec).getCheckBox();
            TextView noiDungCongViec = ((CustomViewGroup) viewCongViec).getTextViewNoiDungCongViec();
            TextView thoiGianCongViec = ((CustomViewGroup) viewCongViec).getTextViewThoiGianCongViec();

            //  Set sử kiện check khi check trên check trên view ở view hiện tại
            checkBoxCongViec.setOnCheckedChangeListener((buttonView, isChecked) -> {
                work.setCheck(isChecked);
            });

            //  Lấy về nội dung cho work hiện tại
            checkBoxCongViec.setChecked(work.isCheck());
            noiDungCongViec.setText(work.getNoiDungCongViec());
            thoiGianCongViec.setText(work.getThoiGianCongViec());
        }

        //  Trả về view hiện tại
        return viewCongViec;
    }

    //  Getter and setter
    public List<Work> getListCongViec() {
        return listCongViec;
    }

    public void setListCongViec(List<Work> listCongViec) {
        this.listCongViec = listCongViec;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
