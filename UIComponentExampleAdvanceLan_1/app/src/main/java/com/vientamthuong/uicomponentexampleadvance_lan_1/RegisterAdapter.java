package com.vientamthuong.uicomponentexampleadvance_lan_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RegisterAdapter extends RecyclerView.Adapter<RegisterViewHolder> {

    // Khởi tạo các thuộc tính
    private Context context;
    private RegisterObject registerObject;

    public RegisterAdapter(Context context, RegisterObject registerObject) {
        this.context = context;
        this.registerObject = registerObject;
    }

    // Tạo view
    @NonNull
    @Override
    public RegisterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RegisterViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_register, parent, false), registerObject, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RegisterViewHolder holder, int position) {
        // Gán dữ liệu vô view, cơ mà ở trường hợp này ta không cần gán
    }

    // vì chỉ có 1 main chính nên trả về 1
    @Override
    public int getItemCount() {
        return 1;
    }
}
