package com.vientamthuong.sqlite.customViewRemoveDatabse;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.R;

import org.w3c.dom.Text;

public class ViewHolderRemoveAttributes extends RecyclerView.ViewHolder {

    private TextView textViewTitle;
    private TextView textViewShowAttribute;

    public ViewHolderRemoveAttributes(@NonNull View itemView) {
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.textView_title);
        textViewShowAttribute = itemView.findViewById(R.id.textView_date_create);
    }

    public TextView getTextViewTitle() {
        return textViewTitle;
    }

    public void setTextViewTitle(TextView textViewTitle) {
        this.textViewTitle = textViewTitle;
    }

    public TextView getTextViewShowAttribute() {
        return textViewShowAttribute;
    }

    public void setTextViewShowAttribute(TextView textViewShowAttribute) {
        this.textViewShowAttribute = textViewShowAttribute;
    }
}
