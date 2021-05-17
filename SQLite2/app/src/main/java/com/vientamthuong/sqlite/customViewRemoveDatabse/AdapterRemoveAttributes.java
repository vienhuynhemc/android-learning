package com.vientamthuong.sqlite.customViewRemoveDatabse;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.activity.ManagerTableActitvity;
import com.vientamthuong.sqlite.database.DatabaseSingleton;
import com.vientamthuong.sqlite.model.Attribute;
import com.vientamthuong.sqlite.model.Table;

import java.util.List;

public class AdapterRemoveAttributes extends RecyclerView.Adapter<ViewHolderRemoveAttributes> {

    private List<Attribute> attributes;
    private int resoucre;
    private ManagerTableActitvity managerTableActitvity;

    public AdapterRemoveAttributes(ManagerTableActitvity managerTableActitvity, int resoucre, List<Attribute> attributes) {
        this.managerTableActitvity = managerTableActitvity;
        this.resoucre = resoucre;
        this.attributes = attributes;
    }

    @NonNull
    @Override
    public ViewHolderRemoveAttributes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderRemoveAttributes(LayoutInflater.from(managerTableActitvity).inflate(resoucre, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRemoveAttributes holder, int position) {
        Attribute attribute = attributes.get(position);
        holder.getTextViewTitle().setText((position + 1) + ". " + attribute.getName_col());
        String type = attribute.getType() == 0 ? "VARCHAR" : "INTEGER";
        if (attribute.getType() == 0) {
            type += "(" + attribute.getLegnth() + ")";
        }
        holder.getTextViewShowAttribute().setText(type);
    }

    @Override
    public int getItemCount() {
        return attributes.size();
    }
}
