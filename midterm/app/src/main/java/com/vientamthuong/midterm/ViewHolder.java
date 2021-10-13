package com.vientamthuong.midterm;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView t1;
    private TextView t2;
    private TextView t3;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        t1 = itemView.findViewById(R.id.t1);
        t2 = itemView.findViewById(R.id.t2);
        t3 = itemView.findViewById(R.id.t3);
    }

    public TextView getT1() {
        return t1;
    }

    public void setT1(TextView t1) {
        this.t1 = t1;
    }

    public TextView getT2() {
        return t2;
    }

    public void setT2(TextView t2) {
        this.t2 = t2;
    }

    public TextView getT3() {
        return t3;
    }

    public void setT3(TextView t3) {
        this.t3 = t3;
    }
}
