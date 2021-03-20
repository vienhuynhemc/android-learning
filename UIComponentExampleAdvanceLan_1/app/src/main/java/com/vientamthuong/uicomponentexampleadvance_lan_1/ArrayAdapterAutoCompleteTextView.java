package com.vientamthuong.uicomponentexampleadvance_lan_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterAutoCompleteTextView extends ArrayAdapter<Student> {

    // Khởi tạo các biến
    private List<Student> dsHocSinh;
    private Context context;
    private Filter filter;

    public ArrayAdapterAutoCompleteTextView(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.dsHocSinh = objects;
        this.context = context;

        // Tạo filter
        init();
    }

    // Hiện thực getView
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Nếu convertView == null thì tạo mới nó
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_auto_complete_text_view, parent, false);
        }
        // Lấy học sinh tại vị trí tương ứng, gán dữ liêu cho view
        Student student = dsHocSinh.get(position);
        if (student != null) {
            // getView
            TextView tvTen = convertView.findViewById(R.id.act_textView_1);
            TextView tvSDT = convertView.findViewById(R.id.act_textView_2);
            ImageView ivPerson = convertView.findViewById(R.id.act_imageView_1);
            ImageView ivPhone = convertView.findViewById(R.id.act_imageView_2);
            // gán dữ liệu vào view
            ivPerson.setImageResource(dsHocSinh.get(position).getIconPerson());
            ivPhone.setImageResource(dsHocSinh.get(position).getIconPhone());
            tvTen.setText(dsHocSinh.get(position).getName());
            tvSDT.setText(dsHocSinh.get(position).getSoDienThoai());
        }

        return convertView;
    }

    private void init() {
        filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                // Khởi tạo các thuộc tính cần thiết cho filter
                FilterResults filterResults = new FilterResults();
                List<Student> listSearch = new ArrayList<>();
                // Dựa còn constraint để xem thử đối tượng nào trong dsSinhVien đc thêm vô
                if (constraint == null || constraint.length() == 0) {
                    // Nếu chưa nhập hay nhập rỗng thì show all
                    listSearch.addAll(dsHocSinh);
                } else {
                    String search = constraint.toString().toLowerCase();
                    for (Student student : dsHocSinh) {
                        if (student.getName().toLowerCase().contains(search) || student.getSoDienThoai().contains(search)) {
                            listSearch.add(student);
                        }
                    }
                }
                //  gán giá trị cho filterResult
                filterResults.values = listSearch;
                filterResults.count = listSearch.size();
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                // xóa hết ds cũ
                clear();
                // thêm sách sách đã được xử lý
                addAll((List) results.values);
                // thông báo để autocompleteView cập nhật lại
                notifyDataSetChanged();
            }

            //  Hàm để khi click vô item trả về 1 string
            @Override
            public CharSequence convertResultToString(Object resultValue) {
                return ((Student)resultValue).getName()+" - "+ ((Student)resultValue).getSoDienThoai();
            }
        };
    }

    // getter and setter
    public List<Student> getDsHocSinh() {
        return dsHocSinh;
    }

    public void setDsHocSinh(List<Student> dsHocSinh) {
        this.dsHocSinh = dsHocSinh;
    }

    @NonNull
    @Override
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }
}
