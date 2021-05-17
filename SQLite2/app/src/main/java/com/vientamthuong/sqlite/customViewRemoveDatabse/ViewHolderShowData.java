package com.vientamthuong.sqlite.customViewRemoveDatabse;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.R;

public class ViewHolderShowData extends RecyclerView.ViewHolder {

    private Button buttonRemove;
    private TextView textViewShowText;

    public ViewHolderShowData(@NonNull View itemView) {
        super(itemView);
        buttonRemove = itemView.findViewById(R.id.button_add);
        textViewShowText = itemView.findViewById(R.id.textView_title);
    }

    public Button getButtonRemove() {
        return buttonRemove;
    }

    public void setButtonRemove(Button buttonRemove) {
        this.buttonRemove = buttonRemove;
    }

    public TextView getTextViewShowText() {
        return textViewShowText;
    }

    public void setTextViewShowText(TextView textViewShowText) {
        this.textViewShowText = textViewShowText;
    }
}
