package com.vientamthuong.sqlite.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.sqlite.R;
import com.vientamthuong.sqlite.customViewRemoveDatabse.AdapterRemoveDatabase;
import com.vientamthuong.sqlite.database.DatabaseSingleton;
import com.vientamthuong.sqlite.model.Database;

import java.util.ArrayList;
import java.util.List;

public class RemoveActivity extends AppCompatActivity {

    private TextView textViewNotFound;
    private EditText editTextFind;
    private Button buttonBack;
    private Button buttonRemoveSelect;
    private RecyclerView recyclerViewDanhSachDatabase;
    private AdapterRemoveDatabase adapterRemoveDatabase;
    private List<Database> databases;
    private List<Database> databasesFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_remove_database);
        getView();
        init();
        action();
        updateView();
    }

    private void action() {
        buttonBack.setOnClickListener(v -> onBackPressed());
        buttonRemoveSelect.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(RemoveActivity.this);
            builder.setTitle("Xóa những lựa chọn của bạn?");
            builder.setMessage("Sau khi xóa không thể khổi phục lại đâu nhá :v");
            builder.setPositiveButton("Không", (dialog, which) -> {
            });
            builder.setNegativeButton("Xóa", (dialog, which) -> {
                int count = 0;
                int removed = 0;
                List<Integer> ids = new ArrayList<>();
                while (count < databasesFind.size()) {
                    if (databasesFind.get(count).isSelect()) {
                        if (DatabaseSingleton.getInstance().getNowDatabase() != null) {
                            if (databasesFind.get(count).getId() == DatabaseSingleton.getInstance().getNowDatabase().getDatabase().getId()) {
                                DatabaseSingleton.getInstance().setNowDatabase(null);
                            }
                        }
                        deleteDatabase(databasesFind.get(count).getName() + ".sqlite");
                        DatabaseSingleton.getInstance().getRootDatabase().removeDatabase(databasesFind.get(count).getId());
                        ids.add(databasesFind.get(count).getId());
                        databasesFind.remove(count);
                        removed++;
                    } else {
                        count++;
                    }
                }
                for (int id : ids) {
                    removeObjectDatabase(id);
                }
                Toast.makeText(RemoveActivity.this, "Xóa thành công " + removed + " Database", Toast.LENGTH_SHORT).show();
                updateView();
                adapterRemoveDatabase.notifyDataSetChanged();
            });
            builder.show();
        });
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
                databasesFind.clear();
                if (nowText.length() == 0) {
                    for (Database database : databases) {
                        databasesFind.add(new Database(database));
                    }
                } else {
                    for (Database database : databases) {
                        if (database.getName().toLowerCase().contains(nowText)) {
                            databasesFind.add(new Database(database));
                        }
                    }
                }
                adapterRemoveDatabase.notifyDataSetChanged();
                updateView();
            }
        });
    }

    private void init() {
        databases = DatabaseSingleton.getInstance().getRootDatabase().getAll();
        databasesFind = new ArrayList<>(databases);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RemoveActivity.this);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewDanhSachDatabase.setLayoutManager(linearLayoutManager);
        adapterRemoveDatabase = new AdapterRemoveDatabase(databasesFind, RemoveActivity.this, R.layout.holder_remove_database);
        recyclerViewDanhSachDatabase.setAdapter(adapterRemoveDatabase);
    }

    public void updateView() {
        int count = 0;
        for (Database database : databasesFind) {
            if (database.isSelect()) {
                count++;
                buttonRemoveSelect.setEnabled(true);
                break;
            }
        }
        if (count == 0) {
            buttonRemoveSelect.setEnabled(false);
        }
        if (databasesFind.size() == 0) {
            textViewNotFound.setVisibility(View.VISIBLE);
        } else {
            textViewNotFound.setVisibility(View.GONE);
        }
    }

    private void getView() {
        editTextFind = findViewById(R.id.editText_find);
        buttonBack = findViewById(R.id.button_back);
        recyclerViewDanhSachDatabase = findViewById(R.id.danh_sach_database);
        buttonRemoveSelect = findViewById(R.id.button_remove_select);
        textViewNotFound = findViewById(R.id.text_view_not_found);
    }

    public void removeObjectDatabase(int id) {
        int count = 0;
        while (count < databases.size()) {
            if (databases.get(count).getId() == id) {
                databases.remove(count);
                break;
            } else {
                count++;
            }
        }
    }

    public void checkedObjectDatabse(int id, boolean isSelect) {
        System.out.println(id + " " + isSelect);
        for (Database db : databases) {
            if (db.getId() == id) {
                db.setSelect(isSelect);
                break;
            }
        }
    }

}
