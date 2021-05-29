package com.vientamthuong.fragment1;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.b1);
        Button b2 = findViewById(R.id.b2);

        b1.setOnClickListener(v -> {
            addFragment(new FragmentA());
        });

        b2.setOnClickListener(v -> {
            addFragment(new FragmentB());
        });
    }

    public void addFragment(Fragment f){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.f1,f);
        fragmentTransaction.commit();
    }
}