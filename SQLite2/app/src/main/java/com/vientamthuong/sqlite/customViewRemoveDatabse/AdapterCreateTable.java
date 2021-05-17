package com.vientamthuong.sqlite.customViewRemoveDatabse;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.R;
import com.vientamthuong.sqlite.activity.ManagerTableActitvity;
import com.vientamthuong.sqlite.database.DatabaseSingleton;
import com.vientamthuong.sqlite.dialog.DiaLogRenameTable;
import com.vientamthuong.sqlite.model.Table;

import java.util.List;

import static android.graphics.Color.WHITE;

public class AdapterCreateTable extends RecyclerView.Adapter<ViewHolderCreateTable> {

    private List<Table> tables;
    private int resoucre;
    private ManagerTableActitvity managerTableActitvity;

    public AdapterCreateTable(List<Table> tables, int resouce, ManagerTableActitvity managerTableActitvity) {
        this.tables = tables;
        this.resoucre = resouce;
        this.managerTableActitvity = managerTableActitvity;
    }

    @NonNull
    @Override
    public ViewHolderCreateTable onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderCreateTable(LayoutInflater.from(managerTableActitvity).inflate(resoucre, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolderCreateTable holder, int position) {
        Table table = tables.get(position);
        holder.getTextViewTitle().setText((position + 1) + ". " + table.getName_table());
        holder.getTextViewShowNumbsRow().setText("Số thuộc tính: " + DatabaseSingleton.getInstance().getRootDatabase().getNumbsRowForTable(table.getId_table()));
        holder.getCheckBoxSelect().setChecked(table.isSelect());
        holder.getCheckBoxSelect().setOnClickListener(v -> {
            table.setSelect(!table.isSelect());
            managerTableActitvity.checkedObject(table.getId_table(), table.isSelect());
            managerTableActitvity.updateView();
        });
        if (table.isSelectManager()) {
            holder.getCardView().setBackgroundResource(R.color.select);
        } else {
            holder.getCardView().setBackgroundResource(R.color.white);
        }
        holder.getCardView().setOnClickListener(v -> {
            table.setSelectManager(true);
            managerTableActitvity.updateSelect(table.getId_table());
            managerTableActitvity.updateTableAttribue(table.getId_table());
            notifyDataSetChanged();
        });
        holder.getButtonEdit().setOnClickListener(v -> {
            DiaLogRenameTable diaLogRenameTable = new DiaLogRenameTable(managerTableActitvity, table.getName_table(), table.getId_table());
            diaLogRenameTable.show();
        });
        holder.getButtonRemove().setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(managerTableActitvity);
            builder.setTitle("Xóa " + table.getName_table() + "?");
            builder.setMessage("Sau khi xóa không thể khổi phục lại đâu nhá :v");
            builder.setPositiveButton("Không", (dialog, which) -> {
            });
            builder.setNegativeButton("Xóa", (dialog, which) -> {
                int id = tables.get(position).getId_table();
                DatabaseSingleton.getInstance().getNowDatabase().removeTable(table.getName_table());
                DatabaseSingleton.getInstance().getRootDatabase().removeTable(table.getId_table());
                Toast.makeText(managerTableActitvity, "Xóa thành công Table: " + table.getName_table(), Toast.LENGTH_SHORT).show();
                managerTableActitvity.removeObjectTable(id);
                if(table.isSelectManager()){
                    managerTableActitvity.resetAttributeTable();
                }
                tables.remove(position);
                managerTableActitvity.updateView();
                notifyDataSetChanged();
            });
            builder.show();
        });
    }

    @Override
    public int getItemCount() {
        return tables.size();
    }
}
