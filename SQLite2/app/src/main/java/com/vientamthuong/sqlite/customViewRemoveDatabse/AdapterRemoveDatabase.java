package com.vientamthuong.sqlite.customViewRemoveDatabse;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.activity.RemoveActivity;
import com.vientamthuong.sqlite.database.DatabaseSingleton;
import com.vientamthuong.sqlite.model.Database;

import java.util.List;

public class AdapterRemoveDatabase extends RecyclerView.Adapter<ViewHolderRemoveDatabase> {

    private final List<Database> databases;
    private final RemoveActivity context;
    private final int resource;

    public AdapterRemoveDatabase(List<Database> databases, RemoveActivity context, int resource) {
        this.databases = databases;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public ViewHolderRemoveDatabase onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderRemoveDatabase(LayoutInflater.from(context).inflate(resource, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolderRemoveDatabase holder, int position) {
        Database database = databases.get(position);
        holder.getTextViewTitle().setText((position + 1) + "." + database.getName());
        holder.getTextViewDateCreate().setText(database.getDateCreate());
        holder.getCheckBoxSelect().setChecked(database.isSelect());
        holder.getCheckBoxSelect().setOnClickListener(v -> {
            database.setSelect(!database.isSelect());
            context.updateView();
            context.checkedObjectDatabse(database.getId(), database.isSelect());
        });
        holder.getButtonRemove().setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Xóa " + database.getName() + "?");
            builder.setMessage("Sau khi xóa không thể khổi phục lại đâu nhá :v");
            builder.setPositiveButton("Không", (dialog, which) -> {
            });
            builder.setNegativeButton("Xóa", (dialog, which) -> {
                if (DatabaseSingleton.getInstance().getNowDatabase() != null) {
                    if (database.getId() == DatabaseSingleton.getInstance().getNowDatabase().getDatabase().getId()) {
                        DatabaseSingleton.getInstance().setNowDatabase(null);
                    }
                }
                context.deleteDatabase(database.getName() + ".sqlite");
                Toast.makeText(context, "Xóa thành công Database: " + database.getName(), Toast.LENGTH_SHORT).show();
                DatabaseSingleton.getInstance().getRootDatabase().removeDatabase(database.getId());
                int id = databases.get(position).getId();
                context.removeObjectDatabase(id);
                databases.remove(position);
                context.updateView();
                notifyDataSetChanged();
            });
            builder.show();
        });
    }

    @Override
    public int getItemCount() {
        return databases.size();
    }

}
