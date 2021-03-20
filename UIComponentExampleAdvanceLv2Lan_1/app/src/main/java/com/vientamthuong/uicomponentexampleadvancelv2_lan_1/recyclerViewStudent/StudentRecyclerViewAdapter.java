package com.vientamthuong.uicomponentexampleadvancelv2_lan_1.recyclerViewStudent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.uicomponentexampleadvancelv2_lan_1.R;
import com.vientamthuong.uicomponentexampleadvancelv2_lan_1.register.MainActivity;
import com.vientamthuong.uicomponentexampleadvancelv2_lan_1.student.Student;

import java.util.List;

public class StudentRecyclerViewAdapter extends RecyclerView.Adapter<StudentViewHolder> {

    // Khởi tạo các biến
    private List<Student> dsSinhVienDuocChon;
    private Context context;

    public StudentRecyclerViewAdapter(Context context, List<Student> dsSinhVienDuocChon) {
        this.context = context;
        this.dsSinhVienDuocChon = dsSinhVienDuocChon;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_custom_recycler_view_student, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = dsSinhVienDuocChon.get(position);
        ((StudentViewHolder) holder).getTvTen().setText(student.getName());
        ((StudentViewHolder) holder).getTvPhone().setText(student.getPhone());
        ((StudentViewHolder) holder).getBtRemove().setOnClickListener(v -> {
            Toast.makeText(context, "Xóa thành công "+dsSinhVienDuocChon.get(position).getName()+" ra khỏi nhóm", Toast.LENGTH_SHORT).show();
            dsSinhVienDuocChon.remove(position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return dsSinhVienDuocChon.size();
    }
}
