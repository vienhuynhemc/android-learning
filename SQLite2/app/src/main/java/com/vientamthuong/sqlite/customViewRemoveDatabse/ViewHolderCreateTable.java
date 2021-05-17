package com.vientamthuong.sqlite.customViewRemoveDatabse;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.R;

public class ViewHolderCreateTable extends RecyclerView.ViewHolder {

    private Button buttonRemove;
    private Button buttonEdit;
    private TextView textViewTitle;
    private TextView textViewShowNumbsRow;
    private CheckBox checkBoxSelect;
    private ConstraintLayout cardView;

    public ViewHolderCreateTable(@NonNull View itemView) {
        super(itemView);
        getView(itemView);
    }

    private void getView(View itemView) {
        buttonRemove = itemView.findViewById(R.id.button_remove);
        buttonEdit = itemView.findViewById(R.id.button_edit);
        textViewTitle = itemView.findViewById(R.id.textView_title);
        textViewShowNumbsRow = itemView.findViewById(R.id.textView_show_numbs_row);
        checkBoxSelect = itemView.findViewById(R.id.checkBox_select);
        cardView = itemView.findViewById(R.id.lay_out);
    }

    public Button getButtonRemove() {
        return buttonRemove;
    }

    public void setButtonRemove(Button buttonRemove) {
        this.buttonRemove = buttonRemove;
    }

    public Button getButtonEdit() {
        return buttonEdit;
    }

    public void setButtonEdit(Button buttonEdit) {
        this.buttonEdit = buttonEdit;
    }

    public TextView getTextViewTitle() {
        return textViewTitle;
    }

    public void setTextViewTitle(TextView textViewTitle) {
        this.textViewTitle = textViewTitle;
    }

    public TextView getTextViewShowNumbsRow() {
        return textViewShowNumbsRow;
    }

    public void setTextViewShowNumbsRow(TextView textViewShowNumbsRow) {
        this.textViewShowNumbsRow = textViewShowNumbsRow;
    }

    public CheckBox getCheckBoxSelect() {
        return checkBoxSelect;
    }

    public void setCheckBoxSelect(CheckBox checkBoxSelect) {
        this.checkBoxSelect = checkBoxSelect;
    }

    public ConstraintLayout getCardView() {
        return cardView;
    }

    public void setCardView(ConstraintLayout cardView) {
        this.cardView = cardView;
    }
}
