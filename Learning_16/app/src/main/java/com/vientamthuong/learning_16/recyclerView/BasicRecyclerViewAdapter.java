package com.vientamthuong.learning_16.recyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.learning_16.MainActivity;
import com.vientamthuong.learning_16.R;

import java.util.List;

public class BasicRecyclerViewAdapter extends RecyclerView.Adapter<BasicViewHoler> {

    private List<String> list;

    public BasicRecyclerViewAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public BasicViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new BasicViewHoler(layoutInflater.inflate(R.layout.activity_basic_recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BasicViewHoler holder, int position) {
        holder.getTextView().setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
