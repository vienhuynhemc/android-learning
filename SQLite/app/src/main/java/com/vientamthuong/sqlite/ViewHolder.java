package com.vientamthuong.sqlite;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private Button buttonEdit;
    private Button buttonRemove;
    private TextView textView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        buttonEdit = itemView.findViewById(R.id.buttonSua);
        buttonRemove = itemView.findViewById(R.id.buttonXoa);
        textView = itemView.findViewById(R.id.textView);
    }

    public Button getButtonEdit() {
        return buttonEdit;
    }

    public void setButtonEdit(Button buttonEdit) {
        this.buttonEdit = buttonEdit;
    }

    public Button getButtonRemove() {
        return buttonRemove;
    }

    public void setButtonRemove(Button buttonRemove) {
        this.buttonRemove = buttonRemove;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
