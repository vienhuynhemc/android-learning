package com.vientamthuong.learning_15;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter {

    private final List<Student> danhSachSinhVien;

    //  type view
    public static final int TYPE_1 = 0;
    public static final int TYPE_2 = 1;

    //  Constructor nhận vô danh sách sinh viên
    public StudentAdapter(List<Student> danhSachSinhVien) {
        this.danhSachSinhVien = danhSachSinhVien;
    }

    //  Phương thức trả về itemView type
    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return TYPE_1;
        } else {
            return TYPE_2;
        }
    }

    //  Tạo đối tượng viewHoler, trong đó chứa view hiển thị dữ liệu, ở đây là từng đối tượng
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //  Nạp layout
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = null;
        if (viewType == TYPE_1) {
            view = layoutInflater.inflate(R.layout.activity_student, parent, false);
        } else {
            view = layoutInflater.inflate(R.layout.activity_student_2, parent, false);
        }

        //  Trả về view holer
        return new StudentViewHoler(view);

    }

    // Chuyển dữ liệu vào viewholer, ở đây là từng đối tượng
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Student student = danhSachSinhVien.get(position);
        if (student != null) {
            StudentViewHoler studentViewHoler = (StudentViewHoler) holder;

            studentViewHoler.getIsChecked().setOnCheckedChangeListener((buttonView, isChecked) -> student.setChecked(isChecked));
            studentViewHoler.getTenSinhVien().setText(student.getTenSinhVien());
            studentViewHoler.getMaSoSinhVien().setText(student.getMaSoSinhVien());

        }

    }


    //  Trả về số item trong recylerView
    @Override
    public int getItemCount() {
        return danhSachSinhVien.size();
    }

}
