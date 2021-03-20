package com.vientamthuong.uicomponentexampleadvancelv2_lan_1.autoCompleteStudent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.vientamthuong.uicomponentexampleadvancelv2_lan_1.R;
import com.vientamthuong.uicomponentexampleadvancelv2_lan_1.student.Student;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterAutoCompleteStudent extends ArrayAdapter<Student> {

    // Khai báo các thuộc tính
    private Context context;
    private int resouce;
    private List<Student> dsHocVien;
    private List<Student> suggestionnn;
    private List<Student> dsHocVienDuocChon;

    // Filter để hiện thực lại search của autocompleteTextView
    private Filter filter;

    public ArrayAdapterAutoCompleteStudent(@NonNull Context context, int resouce, @NonNull List<Student> objects, List<Student> dsHocVienDuocChon) {
        super(context, resouce, objects);
        this.context = context;
        this.resouce = resouce;
        // Vì list sinh viên truyền vào kết nối với adpater rồi, nên list dssHocVien này phải clone ra
        // tránh trường hợp khi list này == list adapter, mà dapter clear thì xong rồi :3
        this.dsHocVien = new ArrayList<>();
        dsHocVien.addAll(objects);
        this.dsHocVienDuocChon = dsHocVienDuocChon;

        this.suggestionnn = new ArrayList<>();
        suggestionnn.addAll(objects);

        // khởi tạo class
        init();
    }

    private void init() {
        // Khởi tạo filter
        filter = new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                // Trả về filter results
                // Khởi tạo các thuộc tính cho filter
                FilterResults filterResults = new FilterResults();
                // Xem thử nhập liệu oke ko, oke thì search
                if (constraint != null) {
                    // Tạo mảng lưu mấy thằng mới
                    List<Student> suggestion = new ArrayList<>();
                    // Sử lý constraint
                    String search = constraint.toString().trim().toLowerCase();
                    // Không thì tìm điểm chung rồi add vô
                    for (Student student : dsHocVien) {
                        boolean check = false;
                        for (Student s : dsHocVienDuocChon) {
                            if (s.getId().equals(student.getId())) {
                                check = true;
                                break;
                            }
                        }
                        if (!check) {
                            if (student.getName().toLowerCase().contains(search) || student.getPhone().contains(search)) {
                                suggestion.add(new Student(student.getId(), student.getName(), student.getPhone()));
                            }
                        }
                    }
                    // Gán thuộc tính cho filterResult rồi trả về
                    filterResults.count = suggestion.size();
                    filterResults.values = suggestion;
                    return filterResults;
                }
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                // Xem thử results trả về từ performFilltering có null ko, ko thì làm
                // à quên kiểm tra xem thử có phần từ nào ko luôn thì mới làm
                if (results != null && results.count > 0) {
                    // Xóa mấy thằng hiện tại
                    clear();
                    // add mấy thằng mới vào
                    addAll((List<Student>) results.values);
                    // Thông báo cập nhật
                    notifyDataSetChanged();
                    //add vô suggestion để qua kia tác vụ với action
                    suggestionnn.clear();
                    suggestionnn.addAll((List<Student>) results.values);
                }
            }

            @Override
            public CharSequence convertResultToString(Object resultValue) {
                // conver result về string khi click vô nó
                return ((Student) resultValue).toString();
            }
        };
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Kiểm tra convertView mà null thì tạo mới
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resouce, parent, false);
        }
        // Lấy học sinh ở vị trí tương ứng
        Student student = suggestionnn.get(position);
        // Nếu tồn tại thì làm công việc tiếp theo
        if (student != null) {
            // Lấy view tương ứng ra
            TextView tvTen = convertView.findViewById(R.id.custom_atuoCompleteStudent_textView_1);
            TextView tvPhone = convertView.findViewById(R.id.custom_atuoCompleteStudent_textView_2);
            // Gán dữ liêu từ student vào view
            tvTen.setText(student.getName());
            tvPhone.setText(student.getPhone());
        }
        return convertView;
    }

    // getter and setter
    @NonNull
    @Override
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Student> getDsHocVien() {
        return dsHocVien;
    }

    public void setDsHocVien(List<Student> dsHocVien) {
        this.dsHocVien = dsHocVien;
    }

    public List<Student> getDsHocVienDuocChon() {
        return dsHocVienDuocChon;
    }

    public void setDsHocVienDuocChon(List<Student> dsHocVienDuocChon) {
        this.dsHocVienDuocChon = dsHocVienDuocChon;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public int getResouce() {
        return resouce;
    }

    public void setResouce(int resouce) {
        this.resouce = resouce;
    }

    public List<Student> getSuggestionnn() {
        return suggestionnn;
    }

    public void setSuggestionnn(List<Student> suggestionnn) {
        this.suggestionnn = suggestionnn;
    }
}
