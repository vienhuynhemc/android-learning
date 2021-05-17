package com.vientamthuong.sqlite.customViewRemoveDatabse;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.R;

public class ViewHolderRemoveDatabase extends RecyclerView.ViewHolder {

    private Button buttonRemove;
    private TextView textViewTitle;
    private TextView textViewDateCreate;
    private CheckBox checkBoxSelect;

    public ViewHolderRemoveDatabase(@NonNull View itemView) {
        super(itemView);
        getView(itemView);
    }

    private void getView(View itemView) {
        buttonRemove = itemView.findViewById(R.id.button_remove);
        textViewTitle = itemView.findViewById(R.id.textView_title);
        textViewDateCreate = itemView.findViewById(R.id.textView_date_create);
        checkBoxSelect = itemView.findViewById(R.id.checkBox_select);
    }

    public Button getButtonRemove() {
        return buttonRemove;
    }

    public void setButtonRemove(Button buttonRemove) {
        this.buttonRemove = buttonRemove;
    }

    public TextView getTextViewTitle() {
        return textViewTitle;
    }

    public void setTextViewTitle(TextView textViewTitle) {
        this.textViewTitle = textViewTitle;
    }

    public TextView getTextViewDateCreate() {
        return textViewDateCreate;
    }

    public void setTextViewDateCreate(TextView textViewDateCreate) {
        this.textViewDateCreate = textViewDateCreate;
    }

    public CheckBox getCheckBoxSelect() {
        return checkBoxSelect;
    }

    public void setCheckBoxSelect(CheckBox checkBoxSelect) {
        this.checkBoxSelect = checkBoxSelect;
    }
}
