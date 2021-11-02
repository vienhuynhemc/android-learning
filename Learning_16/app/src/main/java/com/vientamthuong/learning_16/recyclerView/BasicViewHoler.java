package com.vientamthuong.learning_16.recyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.learning_16.R;

public class BasicViewHoler extends RecyclerView.ViewHolder {

    private TextView textView;

    public BasicViewHoler(@NonNull View itemView) {
        super(itemView);
        this.textView = itemView.findViewById(R.id.textVIew_3);
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
