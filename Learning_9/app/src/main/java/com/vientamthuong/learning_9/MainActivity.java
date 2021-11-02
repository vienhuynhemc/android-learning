package com.vientamthuong.learning_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputLayout textInputLayout = findViewById(R.id.textInputLayout_1);
        TextInputEditText textInputEditText = findViewById(R.id.textInputEditText_1);

        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    textInputEditText.setError("ơ lồi rồi nè");
                    textInputLayout.setError(null);
                } else if (s.length() == 2) {
                    textInputEditText.setError(null);
                    textInputLayout.setError("ơ lồi rồi nè");
                } else {
                    textInputLayout.setError(null);
                    textInputEditText.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        String[] array = {"Tai nghe", "Tai nghe cao cap", "tai nghe c", "tai nghe sin"};
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView_1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, array);
        autoCompleteTextView.setAdapter(arrayAdapter);

    }
}