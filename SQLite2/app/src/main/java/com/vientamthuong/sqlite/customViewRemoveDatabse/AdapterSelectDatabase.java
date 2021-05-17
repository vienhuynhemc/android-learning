package com.vientamthuong.sqlite.customViewRemoveDatabse;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.MainActivity;
import com.vientamthuong.sqlite.database.DatabaseSingleton;
import com.vientamthuong.sqlite.dialog.DiaLogSelectDatabase;
import com.vientamthuong.sqlite.model.Database;
import com.vientamthuong.sqlite.model.SelectDatabase;

import java.util.List;

public class AdapterSelectDatabase extends RecyclerView.Adapter<ViewHolderSelectDatabase> {

    private final List<Database> databases;
    private final MainActivity mainActivity;
    private final int resource;
    private final DiaLogSelectDatabase diaLogSelectDatabase;

    public AdapterSelectDatabase(List<Database> databases, MainActivity mainActivity, int resource, DiaLogSelectDatabase diaLogSelectDatabase) {
        this.databases = databases;
        this.mainActivity = mainActivity;
        this.resource = resource;
        this.diaLogSelectDatabase = diaLogSelectDatabase;
    }

    @NonNull
    @Override
    public ViewHolderSelectDatabase onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderSelectDatabase(LayoutInflater.from(mainActivity).inflate(resource, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolderSelectDatabase holder, int position) {
        Database database = databases.get(position);
        holder.getTextViewTitle().setText((position + 1) + "." + database.getName());
        holder.getTextViewDateCreate().setText(database.getDateCreate());
        holder.getButtonSelect().setOnClickListener(v -> {
            DatabaseSingleton.getInstance().setNowDatabase(new SelectDatabase(database, mainActivity));
            Toast.makeText(mainActivity, "Bạn đã chọn Database: " + database.getName(), Toast.LENGTH_SHORT).show();
            diaLogSelectDatabase.complete();
        });
    }

    @Override
    public int getItemCount() {
        return databases.size();
    }
}
