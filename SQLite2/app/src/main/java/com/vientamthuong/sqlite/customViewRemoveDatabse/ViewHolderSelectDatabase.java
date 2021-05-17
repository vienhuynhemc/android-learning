package com.vientamthuong.sqlite.customViewRemoveDatabse;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.R;

import org.w3c.dom.Text;

public class ViewHolderSelectDatabase extends RecyclerView.ViewHolder {

    private Button buttonSelect;
    private TextView textViewTitle;
    private TextView textViewDateCreate;

    public ViewHolderSelectDatabase(@NonNull View itemView) {
        super(itemView);
        getView(itemView);
    }

    private void getView(View itemView) {
        buttonSelect = itemView.findViewById(R.id.button_add);
        textViewTitle = itemView.findViewById(R.id.textView_title);
        textViewDateCreate = itemView.findViewById(R.id.textView_date_create);
    }

    public Button getButtonSelect() {
        return buttonSelect;
    }

    public void setButtonSelect(Button buttonSelect) {
        this.buttonSelect = buttonSelect;
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
}
