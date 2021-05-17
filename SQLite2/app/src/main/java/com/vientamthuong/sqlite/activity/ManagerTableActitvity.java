package com.vientamthuong.sqlite.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.MainActivity;
import com.vientamthuong.sqlite.R;
import com.vientamthuong.sqlite.customViewRemoveDatabse.AdapterCreateTable;
import com.vientamthuong.sqlite.customViewRemoveDatabse.AdapterRemoveAttributes;
import com.vientamthuong.sqlite.database.DatabaseSingleton;
import com.vientamthuong.sqlite.dialog.DiaLogCreateTable;
import com.vientamthuong.sqlite.model.Attribute;
import com.vientamthuong.sqlite.model.Database;
import com.vientamthuong.sqlite.model.Table;
import com.vientamthuong.sqlite.model.TypeAttribute;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ManagerTableActitvity extends AppCompatActivity {

    private Button buttonBack;
    private EditText editTextFind;
    private EditText editTextTenThuocTinh;
    private Button buttonCreateNewTable;
    private Button buttonRemoveAllSelect;
    private TextView textViewShowNotFound;
    private RecyclerView recyclerViewDanhSachBang;
    private List<Table> tables;
    private List<Table> tablesFind;
    private AdapterCreateTable adapterCreateTable;
    private List<TypeAttribute> attributes;
    private Spinner spinner;
    private ArrayAdapter<TypeAttribute> spinnerAdapter;
    private EditText editTextChieuDai;
    private Button buttonThemThuocTinh;
    private RecyclerView recyclerViewDanhSachThuocTinh;
    private List<Attribute> listAttribute;
    private AdapterRemoveAttributes adapterRemoveAttributes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_manager_table);
        getView();
        action();
        init();
    }

    private void action() {
        buttonBack.setOnClickListener(v -> onBackPressed());
        editTextFind.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String nowText = s.toString().trim().toLowerCase();
                tablesFind.clear();
                if (nowText.length() == 0) {
                    for (Table table : tables) {
                        tablesFind.add(new Table(table));
                    }
                } else {
                    for (Table table : tables) {
                        if (table.getName_table().toLowerCase().contains(nowText)) {
                            tablesFind.add(new Table(table));
                        }
                    }
                }
                adapterCreateTable.notifyDataSetChanged();
                updateView();
            }
        });
        buttonCreateNewTable.setOnClickListener(v -> {
            DiaLogCreateTable diaLogCreateTable = new DiaLogCreateTable(ManagerTableActitvity.this);
            diaLogCreateTable.show();
        });
        buttonRemoveAllSelect.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ManagerTableActitvity.this);
            List<Table> tableNeedDrop = new ArrayList<>();
            for (Table table : tablesFind) {
                if (table.isSelect()) {
                    tableNeedDrop.add(new Table(table));
                }
            }
            builder.setTitle("Xóa " + tableNeedDrop.size() + " Table?");
            builder.setMessage("Sau khi xóa không thể khổi phục lại đâu nhá :v");
            builder.setPositiveButton("Không", (dialog, which) -> {
            });
            int length = tableNeedDrop.size();
            builder.setNegativeButton("Xóa", (dialog, which) -> {
                for (Table table : tableNeedDrop) {
                    if (table.isSelectManager()) {
                        resetAttributeTable();
                    }
                    removeObjectTableFind(table.getId_table());
                    DatabaseSingleton.getInstance().getNowDatabase().removeTable(table.getName_table());
                    DatabaseSingleton.getInstance().getRootDatabase().removeTable(table.getId_table());
                    removeObjectTable(table.getId_table());
                }
                Toast.makeText(ManagerTableActitvity.this, "Xóa thành công " + length + " Table", Toast.LENGTH_SHORT).show();
                updateView();
                adapterCreateTable.notifyDataSetChanged();
            });
            builder.show();
        });
        buttonThemThuocTinh.setOnClickListener(v -> {
            try {
                String tenThuocTinh = editTextTenThuocTinh.getText().toString().trim();
                String typeAttribute = spinner.getSelectedItem().toString();
                Table table = getNowTable();
                if (table == null) {
                    Toast.makeText(ManagerTableActitvity.this, "Vui lòng chọn Table", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isOke = true;
                    if (DatabaseSingleton.getInstance().getRootDatabase().isExitsColumn(table.getId_table(), tenThuocTinh)) {
                        Toast.makeText(ManagerTableActitvity.this, "Đã tồn tại thuộc tính", Toast.LENGTH_SHORT).show();
                        isOke = false;
                    } else if (tenThuocTinh.length() == 0) {
                        isOke = false;
                        Toast.makeText(ManagerTableActitvity.this, "Tên thuộc tính không được bỏ trống", Toast.LENGTH_SHORT).show();
                    } else if (tenThuocTinh.length() > 0 && tenThuocTinh.contains(" ")) {
                        isOke = false;
                        Toast.makeText(ManagerTableActitvity.this, "Tên thuộc tính không được chứa khoảng trống", Toast.LENGTH_SHORT).show();
                    } else if (tenThuocTinh.length() > 0 && (tenThuocTinh.charAt(0) < 65 || (tenThuocTinh.charAt(0) > 90 &&
                            tenThuocTinh.charAt(0) < 97) || tenThuocTinh.charAt(0) > 122)) {
                        isOke = false;
                        Toast.makeText(ManagerTableActitvity.this, "Tên thuộc tính phải bắt đầu bằng chữ", Toast.LENGTH_SHORT).show();
                    } else if (typeAttribute.equals("VARCHAR")) {
                        try {
                            Integer.parseInt(editTextChieuDai.getText().toString());
                            isOke = true;
                        } catch (Exception e) {
                            isOke = false;
                            Toast.makeText(ManagerTableActitvity.this, "Lỗi nhập liệu", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        isOke = true;
                    }
                    if (isOke) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ManagerTableActitvity.this);
                        builder.setTitle("Thêm thuộc tính: " + tenThuocTinh + "?");
                        builder.setMessage("Thêm phát là vô Database luôn đấy :v");
                        builder.setPositiveButton("Không", (dialog, which) -> {
                        });
                        builder.setNegativeButton("Thêm", (dialog, which) -> {
                            Attribute attribute;
                            if (typeAttribute.equals("VARCHAR")) {
                                int length = Integer.parseInt(editTextChieuDai.getText().toString().trim());
                                attribute = new Attribute(table.getId_table(), tenThuocTinh, 0, length);
                                Toast.makeText(ManagerTableActitvity.this, "Thêm thuộc tính thành công", Toast.LENGTH_SHORT).show();
                            } else {
                                int length = 0;
                                attribute = new Attribute(table.getId_table(), tenThuocTinh, 1, length);
                            }
                            DatabaseSingleton.getInstance().getNowDatabase().addNewCol(table.getName_table(), attribute);
                            DatabaseSingleton.getInstance().getRootDatabase().insertNewDataToDetailtable(attribute);
                            Toast.makeText(ManagerTableActitvity.this, "Thêm thuộc tính thành công", Toast.LENGTH_SHORT).show();
                            listAttribute.add(attribute);
                            updateView();
                            adapterCreateTable.notifyDataSetChanged();
                            editTextTenThuocTinh.setText("");
                            editTextChieuDai.setText("");
                            adapterRemoveAttributes.notifyDataSetChanged();
                        });
                        builder.show();
                    }
                }
            } catch (Exception e) {
                Toast.makeText(ManagerTableActitvity.this, "Lỗi nhập liệu", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public Table getNowTable() {
        for (Table table : tables) {
            if (table.isSelectManager()) {
                return table;
            }
        }
        return null;
    }

    private void getView() {
        buttonBack = findViewById(R.id.button_back);
        editTextFind = findViewById(R.id.editText_find);
        buttonCreateNewTable = findViewById(R.id.button_them_bang);
        textViewShowNotFound = findViewById(R.id.text_view_not_found);
        recyclerViewDanhSachBang = findViewById(R.id.danh_sach_database);
        buttonRemoveAllSelect = findViewById(R.id.button_remove_select);
        spinner = findViewById(R.id.loai_thuoc_tinh);
        editTextTenThuocTinh = findViewById(R.id.ten_thuoc_tinh);
        editTextChieuDai = findViewById(R.id.chieu_dai);
        buttonThemThuocTinh = findViewById(R.id.button_add_thuoc_tinh);
        recyclerViewDanhSachThuocTinh = findViewById(R.id.danh_sach_thuoc_tinh);
    }

    private void init() {
        attributes = new ArrayList<>();
        attributes.add(new TypeAttribute(0, "VARCHAR"));
        attributes.add(new TypeAttribute(1, "INTEGER"));
        spinnerAdapter = new ArrayAdapter<TypeAttribute>(ManagerTableActitvity.this, android.R.layout.simple_list_item_1, attributes);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TypeAttribute typeAttribute = attributes.get(position);
                editTextChieuDai.setEnabled(typeAttribute.getType() == 0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        tables = DatabaseSingleton.getInstance().getRootDatabase().getAllTable();
        if (tables.size() > 0) {
            tables.get(0).setSelectManager(true);
        }
        tablesFind = new ArrayList<>(tables);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ManagerTableActitvity.this);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewDanhSachBang.setLayoutManager(linearLayoutManager);
        adapterCreateTable = new AdapterCreateTable(tablesFind, R.layout.holder_create_table, ManagerTableActitvity.this);
        recyclerViewDanhSachBang.setAdapter(adapterCreateTable);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(ManagerTableActitvity.this);
        linearLayoutManager1.setSmoothScrollbarEnabled(true);
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewDanhSachThuocTinh.setLayoutManager(linearLayoutManager1);
        if (tables.size() > 0) {
            Table table = getNowTable();
            if (table != null) {
                listAttribute = DatabaseSingleton.getInstance().getRootDatabase().getAllAttribute(table.getId_table());
            } else {
                listAttribute = new ArrayList<>();
            }
        } else {
            listAttribute = new ArrayList<>();
        }
        adapterRemoveAttributes = new AdapterRemoveAttributes(ManagerTableActitvity.this, R.layout.holder_remove_attributes, listAttribute);
        recyclerViewDanhSachThuocTinh.setAdapter(adapterRemoveAttributes);
        updateView();
    }

    public void updateView() {
        int count = 0;
        for (Table table : tablesFind) {
            if (table.isSelect()) {
                count++;
                buttonRemoveAllSelect.setEnabled(true);
                break;
            }
        }
        if (count == 0) {
            buttonRemoveAllSelect.setEnabled(false);
        }
        if (tablesFind.size() == 0) {
            textViewShowNotFound.setVisibility(View.VISIBLE);
        } else {
            textViewShowNotFound.setVisibility(View.GONE);
        }
    }

    public void checkedObject(int id, boolean isSelect) {
        for (Table table : tables) {
            if (table.getId_table() == id) {
                table.setSelect(isSelect);
                break;
            }
        }
    }


    public void addNewTable(String nameDatabase) {
        Table newTable = new Table(DatabaseSingleton.getInstance().getNowDatabase().getDatabase().getId(), DatabaseSingleton.getInstance().getRootDatabase().getNumbsTable() - 1, nameDatabase);
        newTable.setSelectManager(true);
        tables.add(newTable);
        if (newTable.getName_table().toLowerCase().contains(editTextFind.getText().toString().toLowerCase().trim())) {
            tablesFind.add(newTable);
        }
        for (Table table : tables) {
            if (table.getId_table() != newTable.getId_table()) {
                table.setSelectManager(false);
            }
        }
        for (Table table : tablesFind) {
            if (table.getId_table() != newTable.getId_table()) {
                table.setSelectManager(false);
            }
        }
        adapterCreateTable.notifyDataSetChanged();
        recyclerViewDanhSachBang.scrollToPosition(tablesFind.size() - 1);
        updateView();
    }

    public void updateSelect(int id_table) {
        for (Table table : tables) {
            table.setSelectManager(table.getId_table() == id_table);
        }
        for (Table table : tablesFind) {
            table.setSelectManager(table.getId_table() == id_table);
        }
    }

    public void updateTableAttribue(int id_table) {
        List<Attribute> newList = DatabaseSingleton.getInstance().getRootDatabase().getAllAttribute(id_table);
        listAttribute.clear();
        listAttribute.addAll(newList);
        adapterRemoveAttributes.notifyDataSetChanged();
    }

    public void resetAttributeTable() {
        listAttribute.clear();
        adapterRemoveAttributes.notifyDataSetChanged();
    }

    public void renameTable(String nameDatabase, int id_table) {
        for (Table table : tables) {
            if (table.getId_table() == id_table) {
                table.setName_table(nameDatabase);
            }
        }
        for (Table table : tablesFind) {
            if (table.getId_table() == id_table) {
                table.setName_table(nameDatabase);
            }
        }
        adapterCreateTable.notifyDataSetChanged();
    }

    public void removeObjectTable(int id) {
        int count = 0;
        while (count < tables.size()) {
            if (tables.get(count).getId_table() == id) {
                tables.remove(count);
                break;
            } else {
                count++;
            }
        }
    }

    public void removeObjectTableFind(int id) {
        int count = 0;
        while (count < tablesFind.size()) {
            if (tablesFind.get(count).getId_table() == id) {
                tablesFind.remove(count);
                break;
            } else {
                count++;
            }
        }
    }

    public AdapterCreateTable getAdapterCreateTable() {
        return adapterCreateTable;
    }

}
