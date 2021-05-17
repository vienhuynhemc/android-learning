package com.vientamthuong.sqlite.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.vientamthuong.sqlite.R;
import com.vientamthuong.sqlite.activity.ManagerTableActitvity;
import com.vientamthuong.sqlite.database.DatabaseSingleton;

public class DiaLogRenameTable extends Dialog {

    private ManagerTableActitvity managerTableActitvity;
    private Button buttonCreate;
    private Button buttonBack;
    private EditText editTextFillNameDatabase;
    private TextView textViewError;
    private TextView textViewTitle;
    private String name_table;
    private int id_table;

    public DiaLogRenameTable(@NonNull ManagerTableActitvity managerTableActitvity, String name_table, int id_table) {
        super(managerTableActitvity);
        this.managerTableActitvity = managerTableActitvity;
        this.name_table = name_table;
        this.id_table = id_table;
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.dialog_create_database);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getView();
        action();
    }

    private void getView() {
        buttonCreate = findViewById(R.id.button_create);
        buttonBack = findViewById(R.id.button_back);
        editTextFillNameDatabase = findViewById(R.id.editText_fill_name_database);
        textViewError = findViewById(R.id.textView_error);
        textViewTitle = findViewById(R.id.textView_title);
        textViewTitle.setText("Đổi tên Table");
        buttonCreate.setText("Đổi");
        editTextFillNameDatabase.setHint("Tên Table");
        editTextFillNameDatabase.setText(name_table);
    }

    private void action() {
        buttonBack.setOnClickListener(v -> dismiss());
        buttonCreate.setOnClickListener(v -> {
            String nameDatabase = editTextFillNameDatabase.getText().toString().trim();
            if (nameDatabase.length() == 0) {
                Toast.makeText(managerTableActitvity, "Tên Table không được để trống", Toast.LENGTH_SHORT).show();
            } else if (nameDatabase.equals(name_table)) {
                Toast.makeText(managerTableActitvity, "Trùng tên ban đầu", Toast.LENGTH_SHORT).show();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(managerTableActitvity);
                builder.setTitle("Đổi thành " + nameDatabase + "?");
                builder.setMessage("Đổi là vô cơ sở dữ liệu luôn đấy :v");
                builder.setPositiveButton("Không", (dialog, which) -> {
                });
                builder.setNegativeButton("Đổi", (dialog, which) -> {
                    DatabaseSingleton.getInstance().getNowDatabase().renameTable(nameDatabase, name_table);
                    DatabaseSingleton.getInstance().getRootDatabase().renameTable(nameDatabase, id_table);
                    managerTableActitvity.renameTable(nameDatabase, id_table);
                    Toast.makeText(managerTableActitvity, "Đổi tên thành công Table: " + name_table + " -> " + nameDatabase, Toast.LENGTH_SHORT).show();
                    editTextFillNameDatabase.setText("");
                    dismiss();
                });
                builder.show();
            }
        });
        editTextFillNameDatabase.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void afterTextChanged(Editable s) {
                String data = s.toString();
                if (data.length() > 0 && data.contains(" ")) {
                    textViewError.setVisibility(View.VISIBLE);
                    textViewError.setText("Tên Table không được chứa khoảng trống");
                    buttonCreate.setEnabled(false);
                } else if (data.length() > 0 && (data.charAt(0) < 65 || (data.charAt(0) > 90 && data.charAt(0) < 97) || data.charAt(0) > 122)) {
                    textViewError.setVisibility(View.VISIBLE);
                    textViewError.setText("Tên Table phải bắt đầu bằng chữ");
                    buttonCreate.setEnabled(false);
                } else if (data.length() > 0 && DatabaseSingleton.getInstance().getRootDatabase().checkExistsTable(data) && !data.equals(name_table)) {
                    textViewError.setVisibility(View.VISIBLE);
                    textViewError.setText("Tên Table đã tồn tại");
                    buttonCreate.setEnabled(false);
                } else {
                    buttonCreate.setEnabled(true);
                    textViewError.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
