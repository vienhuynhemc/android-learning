package com.vientamthuong.sqlite.dialog;

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

import com.vientamthuong.sqlite.MainActivity;
import com.vientamthuong.sqlite.R;
import com.vientamthuong.sqlite.database.DatabaseSingleton;

import java.util.Date;

public class DiaLogCreateDatabase extends Dialog {

    private Button buttonCreate;
    private Button buttonBack;
    private EditText editTextFillNameDatabase;
    private TextView textViewError;
    private final MainActivity mainActivity;

    public DiaLogCreateDatabase(@NonNull MainActivity mainActivity) {
        super(mainActivity);
        this.mainActivity = mainActivity;
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.dialog_create_database);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getView();
        action();
    }

    private void action() {
        buttonBack.setOnClickListener(v -> dismiss());
        buttonCreate.setOnClickListener(v -> {
            String nameDatabase = editTextFillNameDatabase.getText().toString().trim();
            if (nameDatabase.length() == 0) {
                Toast.makeText(mainActivity, "Tên Database không được để trống", Toast.LENGTH_SHORT).show();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
                builder.setTitle("Tạo " + nameDatabase + "?");
                builder.setMessage("Tạo phát là vô cơ sở dữ liệu luôn đấy :v");
                builder.setPositiveButton("Không", (dialog, which) -> {
                });
                builder.setNegativeButton("Tạo", (dialog, which) -> {
                    DatabaseSingleton.getInstance().createNewDatabase(nameDatabase);
                    DatabaseSingleton.getInstance().getRootDatabase().addNewDatabase(nameDatabase, new Date().getTime());
                    mainActivity.updateView();
                    Toast.makeText(mainActivity, "Tạo thành công Database: " + nameDatabase, Toast.LENGTH_SHORT).show();
                    editTextFillNameDatabase.setText("");
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

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().equals("root") ||
                        DatabaseSingleton.getInstance().getRootDatabase().isExistsDatabase(s.toString().trim())) {
                    textViewError.setVisibility(View.VISIBLE);
                    buttonCreate.setEnabled(false);
                } else {
                    buttonCreate.setEnabled(true);
                    textViewError.setVisibility(View.GONE);
                }
            }
        });
    }

    private void getView() {
        buttonCreate = findViewById(R.id.button_create);
        buttonBack = findViewById(R.id.button_back);
        editTextFillNameDatabase = findViewById(R.id.editText_fill_name_database);
        textViewError = findViewById(R.id.textView_error);
    }

    @Override
    public void onBackPressed() {
    }

}
